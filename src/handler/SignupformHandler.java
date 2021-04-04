package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;


public class SignupformHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
			
		HttpSession session=req.getSession();
		req.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/Signupform.jsp";
	}
}
