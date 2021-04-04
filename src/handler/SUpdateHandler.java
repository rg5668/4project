package handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import command.CommandHandler;
import dao.MemberDao;
import dao.SBoardDao;
import model.Member;
import model.SBoard;

public class SUpdateHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		SBoard board= new SBoard();
		String uploadpath = request.getServletContext().getRealPath("/") + 
		"view/ex/upfile/";
		HttpSession session=request.getSession();
		MultipartRequest multi;
		
		try {
			Member mem = new Member();
			MemberDao memdao = new MemberDao();
			
			mem.setId(session.getAttribute("id").toString());
			mem = memdao.selectOne(mem.getId());
			
			String name = mem.getName();
			String id = mem.getId();
			
			board.setId(id);
			board.setName(name);
				
		multi = new MultipartRequest(request,uploadpath,10*1024*1024,"utf-8");
		board.setNum(Integer.parseInt(multi.getParameter("num")));
		board.setSubject(multi.getParameter("subject"));
		board.setCategory(multi.getParameter("category"));
		board.setContent(multi.getParameter("content"));
		board.setFile1(multi.getFilesystemName("file1"));
		//수정시 첨부 파일의 수정이 발생하지 않은 경우
		if(board.getFile1()==null || board.getFile1().equals("")) {
			board.setFile1(multi.getParameter("file2"));
		}
		SBoardDao dao = new SBoardDao();
		String msg = "게시물 수정 오류";
		String url = "SUpdateForm?num=" + board.getNum();
		if(dao.update(board)) {
		  msg = "게시물 수정 완료";
		  url = "SList";
		 } else {
		    msg = "게시물 수정 실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/alert.jsp";
	}
}

