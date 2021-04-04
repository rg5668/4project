package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.SBoardDao;

public class SDeleteHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		int num = Integer.parseInt(request.getParameter("num"));
		String url1="SList";
		String url2="SInfo?num="+num;
		SBoardDao dao = new SBoardDao();
		HttpSession session=request.getSession();
		request.setAttribute("num", num);
		request.setAttribute("dao", dao);
		request.setAttribute("url1", url1);
		request.setAttribute("url2", url2);
		request.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/SDelete.jsp";
	}
}