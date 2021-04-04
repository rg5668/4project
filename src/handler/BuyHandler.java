package handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BuyDao;
import dao.Product4Dao;
import model.Buy;
import model.Member;
import model.Product4;

public class BuyHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
			Product4 pro=new Product4();
			Member mem=new Member();
			pro.setPcode(req.getParameter("pcode"));
			HttpSession session=req.getSession();
			mem.setId(session.getAttribute("id").toString());
			BuyDao buydao=new BuyDao();
			List<Buy> list=buydao.list(mem.getId());


			ArrayList<String> plist = new ArrayList<String>();
			plist.add("101"); plist.add("102"); 
			plist.add("103"); plist.add("104");
			plist.add("201"); plist.add("202"); 
			plist.add("203"); plist.add("204");
			plist.add("205"); plist.add("301"); 
			plist.add("302"); plist.add("303"); 
			plist.add("304"); plist.add("401");
			plist.add("402"); plist.add("403"); 
			plist.add("404"); plist.add("501");
			plist.add("502"); plist.add("503"); 
			plist.add("504"); plist.add("505"); 
			
			String subpcode = req.getParameter("subpcode");
	        Product4Dao dao = new Product4Dao();
	        List<Product4>pro1 = dao.select(subpcode);
	         
	        req.setAttribute("pro", pro1);
	        req.setAttribute("plist", plist);
			
			
			req.setAttribute("session", session.getAttribute("id"));
			req.setAttribute("list", list);
			return "/view/ex/buyForm.jsp";
	}
}
