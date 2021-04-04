package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.SBoardDao;
import model.SBoard;

public class SInfoHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		/* 1. num 파라미터를 이용하여 db에 해당 게시물 조회
		Board borad = new Board().selectOne(num);
		 2. 조회수 증가시키기. readcnt+1
		 	new BoardDao().readcntadd(num);
		 3. 1번에서 조회한 게시물 데이터를 화면에 출력하기. */
		 
		HttpSession session=request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));//파라미터 값 읽기
		SBoardDao dao = new SBoardDao();
		SBoard board = dao.selectOne(num); //게시물 조회
		dao.readcntadd(num); //조회수 증가
		
		request.setAttribute("board", board);
		request.setAttribute("num", num);
		request.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/SInfo.jsp";
	}
}
