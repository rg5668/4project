package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;
import model.Member;



public class EditprofileHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		Member mem=new Member();//회원정보
		MemberDao memdao=new MemberDao();
		HttpSession session=req.getSession();
		
		mem.setId(session.getAttribute("id").toString());
		if(mem.getId().equals(null)||mem.getId().equals(""))
		{
			String msg="로그인이 필요합니다";
			String url="loginForm";
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			return "/view/ex/alert.jsp";
		}
		mem=memdao.selectOne(mem.getId());
		System.out.println(req.getParameter("id"));
		req.setAttribute("session", session.getAttribute("id"));
		req.setAttribute("mem", mem);
		return "/view/ex/editprofile.jsp";
	}
}
