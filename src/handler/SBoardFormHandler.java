package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;
import model.Member;


public class SBoardFormHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		Member mem = new Member();
		MemberDao memdao = new MemberDao();
		HttpSession session=request.getSession();
		
		mem.setId(session.getAttribute("id").toString());
		mem = memdao.selectOne(mem.getId());
		
		String name = mem.getName();
		
		request.setAttribute("session", session.getAttribute("id"));
		request.setAttribute("name", name);
		return "/view/ex/SBoardForm.jsp";
	}
}
