package handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BasketDao;
import dao.BuyDao;
import model.Basket;
import model.Buy;
import model.Member;
import model.Product4;

public class BasketInsertHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		try {
	         req.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
			String msg="";
			String url="";
			Product4 pro=new Product4();//상품
			Member mem=new Member();//회원정보
			Basket bas=new Basket();
			pro.setPcode(req.getParameter("pcode"));
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
			mem.setId(session.getAttribute("id").toString());

			BasketDao basdao=new BasketDao();
			if(basdao.insert(mem,pro)==0)
			{
				msg="장바구니 담기 실패";
				url="productinfo?pcode="+pro.getPcode();
			}
			else
			{
				msg="장바구니 담기 성공";
				url="basketForm?pcode="+pro.getPcode();
			}
			
			req.setAttribute("session", session.getAttribute("id"));
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
	}
}
