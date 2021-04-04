package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BasketDao;
import dao.BuyDao;
import dao.MemberDao;
import model.Buy;
import model.Member;

import model.Product4;

public class MypageDeleteHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		Member mem=new Member();//������蹂�
		MemberDao memdao=new MemberDao();
		HttpSession session=req.getSession();
		mem.setId(session.getAttribute("id").toString());
		memdao.delete(mem.getId());
		
		String msg="���댁�깃났";
		String url="loginForm";
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("mem", mem);
		
		session.invalidate();
		return "/view/ex/alert.jsp";
	}
}
