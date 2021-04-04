package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;
import dao.SBoardDao;
import model.Member;
import model.SBoard;

public class SListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		/*
		1. pageNum 파라미터 존재. pageNum 파라미터 없으면 1로 설정.
		2. 3건의 게시물 출력.
			=>db에서 해당 페이지에 출력되는 게시물만 조회. 순서 : 최근게시물순
	*/  HttpSession session=request.getSession();
	    
		int pageNum = 1;
		
		try{
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {

		}
		Member mem = new Member();
	    MemberDao memdao=new MemberDao();
	
	    mem.setId(session.getAttribute("id").toString());
	    mem = memdao.selectOne(mem.getId());
		String name = mem.getName();

	    request.setAttribute("session", session.getAttribute("id"));
	    request.setAttribute("name", name);
		
		int limit = 10;
		SBoardDao dao = new SBoardDao();
		int boardcount = dao.boardCount();
		
		List<SBoard> list = dao.list(pageNum, limit, boardcount);
		
		int maxpage = (int)(boardcount/limit)+(boardcount%limit==0?0:1);
		
		int bottomLine=10;
		int startpage = 1 + (pageNum -1) / bottomLine * bottomLine;
		int endpage = startpage + bottomLine - 1;
		
		if(endpage>maxpage) {
			endpage = maxpage;
		}
		int boardnum = boardcount - (pageNum - 1) * limit;
		
		request.setAttribute("boardcount", boardcount);
		request.setAttribute("list", list);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("startpage", startpage);
		request.setAttribute("bottomLine", bottomLine);
		request.setAttribute("endpage", endpage);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/SList.jsp";
	}
}

