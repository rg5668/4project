package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BasketDao;
import dao.BuyDao;
import model.Buy;
import model.Member;

import model.Product4;

public class BasketDeleteHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		String msg="";
		String url="";
		if(req.getParameterValues("select")==null)
		{
			msg="선택한 내역이 없습니다";
			url="basketForm";
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
			
		}
		String[] basketstr=req.getParameterValues("select");
		int[] basket=new int[basketstr.length];
		for(int i=0;i<basketstr.length;i++)
		{
			basket[i]=Integer.parseInt(basketstr[i]);
		}
		Product4 pro=new Product4();//상품
		Member mem=new Member();//회원정보
		BasketDao basdao=new BasketDao();
		HttpSession session=req.getSession();
		mem.setId(session.getAttribute("id").toString());
		basdao.delete(mem, basket);
		
		msg="삭제성공";
		url="basketForm"; 
		System.out.println(url);
		req.setAttribute("url", url);
		req.setAttribute("msg", msg);
		req.setAttribute("session", session.getAttribute("id"));
		
		return "/view/ex/alert.jsp";
	}
}
