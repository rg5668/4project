package handler;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;
import model.Member;


public class LoginHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		String id= (String)req.getAttribute("id");
		String msg="";
		String url="";
		Member mem=new Member();//회원정보
		MemberDao memdao=new MemberDao();
		HttpSession session = req.getSession();

		mem.setId(req.getParameter("id"));
		mem=memdao.selectOne(mem.getId());
		if(mem==null)
		{
			msg="아이디를 확인해주세요";
			url="loginForm";
		}
		else if(!(mem.getPass().equals(req.getParameter("pass"))))
		{
			msg="비밀번호를 확인해주세요";
			url="loginForm";
		}
		else
		{
			msg="로그인 성공";
			url="main";
			System.out.println(req.getParameter("id"));
			req.setAttribute("mem", mem);
	        session.setAttribute("id", mem.getId());
	        System.out.println("성공");
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",url);
		req.setAttribute("session", session.getAttribute("id"));
		
		return "/view/ex/alert.jsp";
	}
}
