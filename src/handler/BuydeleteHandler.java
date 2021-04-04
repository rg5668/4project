package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BuyDao;
import model.Buy;
import model.Member;
import model.Product4;

public class BuydeleteHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
			String msg="";
			String url="";
			Buy buy=new Buy();//상품
			Member mem=new Member();//회원정보
			buy.setPnum(req.getParameter("pnum"));
			HttpSession session=req.getSession();
			mem.setId(session.getAttribute("id").toString());
			BuyDao buydao=new BuyDao();
			
			if(buydao.delete(buy,mem))
			{
				msg="삭제 완료";
				url="buy";
			}
			else
			{
				msg="삭제오류";
				url="buy";
			}
			
			req.setAttribute("session", session.getAttribute("id"));
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
	}
}
