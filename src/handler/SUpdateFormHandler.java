package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.SBoardDao;
import model.SBoard;

public class SUpdateFormHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {

		int num = Integer.parseInt(request.getParameter("num"));
		SBoard board = new SBoardDao().selectOne(num);
		HttpSession session=request.getSession();
		request.setAttribute("board", board);
		request.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/SUpdateForm.jsp";
	}
}