package handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

public class PdeleteHandler implements CommandHandler {
   @Override
   public String process(HttpServletRequest request, HttpServletResponse res) {
	   Product4 pro = new Product4();
	   String uploadpath=request.getServletContext().getRealPath("/")+"view/ex/img/";
	      int size=10*1024*1024;
	      
	      try {
			MultipartRequest multi=new MultipartRequest(request,uploadpath,size,"utf-8");
			
			pro.setPcode(multi.getParameter("pcode"));
		    pro.setPname(multi.getParameter("pname"));
		    pro.setPrice(Integer.parseInt(multi.getParameter("price")));
		    pro.setPcount(Integer.parseInt(multi.getParameter("pcount")));
		    pro.setPimg(multi.getFilesystemName("pimg"));
		    pro.setPcontent(multi.getParameter("pcontent"));
		    pro.setSubpcode(multi.getParameter("subpcode"));
		    
		    Product4Dao dao = new Product4Dao();
		    
		    String msg = "";
		    String url = "";
		    
		    if(dao.delete(pro)) {
				msg = "상품 삭제 완료";
				url = "list?subpcode="+multi.getParameter("subpcode");
			} else {
				msg = "상품 삭제 실패";
				url = "pdeleteForm?pcode="+multi.getParameter("pcode");
			}
		    request.setAttribute("url", url);
			request.setAttribute("msg", msg);
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      HttpSession session=request.getSession();
	         request.setAttribute("session", session.getAttribute("id"));
			
	   return "/view/ex/alert.jsp";
   }
}