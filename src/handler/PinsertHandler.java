package handler;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import command.CommandHandler;
import dao.MemberDao;
import dao.Product4Dao;
import model.Member;
import model.Product4;




public class PinsertHandler implements CommandHandler {
   @Override
   public String process(HttpServletRequest request, HttpServletResponse res) {
      
	   
      String uploadpath=request.getServletContext().getRealPath("/")+"view/ex/img/";
      int size=10*1024*1024;
      
      try {
      MultipartRequest multi=new MultipartRequest(request,uploadpath,size,"utf-8");
      Product4 pro = new Product4();
      System.out.println("����");
      pro.setPcode(multi.getParameter("pcode"));
      pro.setPname(multi.getParameter("pname"));
      pro.setPrice(Integer.parseInt(multi.getParameter("price")));
      pro.setPcount(Integer.parseInt(multi.getParameter("pcount")));
      pro.setPcontent(multi.getParameter("pcontent"));
      pro.setPimg(multi.getFilesystemName("pimg"));
      pro.setSubpcode(multi.getParameter("subpcode"));
        Product4Dao dao = new Product4Dao();
         int num = dao.insert(pro);
         
         String msg = "";
         String url = "";
         
         if(num > 0) {
            msg="��ǰ��� �Ϸ�";
            url="list?subpcode="+multi.getParameter("subpcode");
         } else {
            msg="��ǰ��� ����";
            url="pinsertForm";
         }
         
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
      }
      catch (Exception e) 
      {
         e.printStackTrace();
      }
     
		
      
		return "/view/ex/alert.jsp";
   }
}