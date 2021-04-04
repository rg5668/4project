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

public class SBoardHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
/*	   /WebContent/ch10_board/write.jsp
		   1. 파라미터 값을 model.Board 객체 저장
		   2. 게시물 번호 num 현재 등록된 num의 최대값을 조회
		   최대값+1 등록된 게시물의 번호
		   db에서 maxnum을 구해서 +1 값으로 num 설정하기 */
/*
 * int num = Integer.parseInt(request.getParameter("num"));
 * SBoard board = new SBoardDao().selectOne(num);
 */
		//1. 파라미터 값을 model.Board 객체 저장.
		//String uploadpath = application.getRealPath("/") +"ch10_board/upfile/";
		String uploadpath = request.getServletContext().getRealPath("/") +"/view/ex/upfile/";
		int size = 10 * 1024*1024;
		MultipartRequest multi;
		HttpSession session=request.getSession();

		try {
			multi = new MultipartRequest(request,uploadpath,size,"UTF-8");
			SBoard board = new SBoard();
			Member mem = new Member();
			MemberDao memdao = new MemberDao();
			
			mem.setId(session.getAttribute("id").toString());
			mem = memdao.selectOne(mem.getId());
			
			String name = mem.getName();
			String id = mem.getId();
			
			board.setId(id);
			board.setName(name);
			board.setSubject(multi.getParameter("subject"));
			board.setCategory(multi.getParameter("category"));
			board.setContent(multi.getParameter("content"));
			board.setFile1(multi.getFilesystemName("file1"));
			//2.Sequence nextval 입력
			// db에서 maxnum을 구해서 +1 값으로 num 설정하기
			SBoardDao dao = new SBoardDao();
			//3. board 객체의 내용을 db에 insert 하기
			String msg = "게시물 등록 실패";
			String url = "SBoardForm";
			if(dao.insert(board)) {
				msg= "게시물 등록 성공";
				url = "SList";
			} 
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			request.setAttribute("name", name);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("session", session.getAttribute("id"));
		request.setAttribute("name", session.getAttribute("name"));

		return "/view/ex/alert.jsp";
	}
}