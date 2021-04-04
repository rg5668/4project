package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BuyDao;
import model.Member;

import model.Product4;

public class BuyinfoHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		String msg="";
		String url="";
		HttpSession session=req.getSession();
		
		if(session.getAttribute("id")==null)
		{
			msg="로그인이 필요합니다";
			url="loginForm";
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
		}
		else if(req.getParameter("pcode").equals("")||req.getParameter("pcode").equals(null))
		{
			msg="선택한 상품이 없습니다";
			url="mypageForm";
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
		}
		else
		{
			Product4 pro=new Product4();//상품
			Member mem=new Member();//회원정보
			BuyDao buydao=new BuyDao();
			pro.setPcode(req.getParameter("pcode"));
			mem.setId(session.getAttribute("id").toString());
			
			buydao.insert(mem, pro);

			msg="구매성공";
			url="buy?pcode="+pro.getPcode(); 
			System.out.println(url);
			req.setAttribute("session", session.getAttribute("id"));
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
			
			
		}
	}
}
