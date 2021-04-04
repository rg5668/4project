package handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import dao.MemberDao;
import model.Member;


public class idcheckHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		
		
		MemberDao dao=new MemberDao();
		if(dao.selectById(id)==1)
		{
		  String msg="아이디가 중복되었습니다";
		  String url="Signupform";
		  
		  req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "/view/ex/alert.jsp";
		}
		else {
			String msg="사용가능한 아이디입니다.";
			  String url="Signupform";
		
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "/view/ex/alert.jsp";
		}
		
		
	}
}
