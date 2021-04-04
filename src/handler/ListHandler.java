package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BoardDao;
import dao.MemberDao;
import model.Board;
import model.Member;

public class ListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		HttpSession session=request.getSession();
		request.setAttribute("session", session.getAttribute("id"));
		
		
		
		
		
		return "/view/ex/alert.jsp";
	}
}
