package handler;

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

public class BasketFormHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
			Product4 pro=new Product4();//상품
			Member mem=new Member();//회원정보
			pro.setPcode(req.getParameter("pcode"));
			HttpSession session=req.getSession();
			mem.setId(session.getAttribute("id").toString());
			BasketDao basdao=new BasketDao();
			List<Basket> list=basdao.list(mem.getId());
			
			req.setAttribute("session", session.getAttribute("id"));
			req.setAttribute("id", mem.getId());
			req.setAttribute("list", list);
			return "/view/ex/basketForm.jsp";
	}
}
