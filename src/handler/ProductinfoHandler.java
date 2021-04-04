package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BuyDao;
import model.Member;
import model.Product4;
import model.Productinfo;

public class ProductinfoHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		
		Product4 pro=new Product4();//상품
		Member mem=new Member();//회원정보
		pro.setPcode(req.getParameter("pcode"));
		Productinfo pinfo=new Productinfo();
		HttpSession session=req.getSession();
		
		BuyDao buy=new BuyDao();//insert db
		/* buy.insert(mem, pro); */
		pinfo=buy.select(pro);
		
		req.setAttribute("pinfo", pinfo);
		req.setAttribute("mem", mem);
		req.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/productinfo.jsp";
	}
}
