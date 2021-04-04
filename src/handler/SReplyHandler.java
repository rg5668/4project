package handler;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import command.CommandHandler;
import dao.SBoardDao;
import model.SBoard;

public class SReplyHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		SBoard board = new SBoard();
		String uploadpath = request.getServletContext().getRealPath("/") + 
				"view/ex/upfile/";
		HttpSession session=request.getSession();

		MultipartRequest multi;
		
		try {
			request.setCharacterEncoding("UTF-8");
			try {
				multi = new MultipartRequest(request,uploadpath,10*1024*1024,"utf-8");
				board.setNum(Integer.parseInt(multi.getParameter("num")));
				board.setRef(Integer.parseInt(multi.getParameter("ref")));
				board.setReflevel(Integer.parseInt(multi.getParameter("reflevel")));
				board.setRefstep(Integer.parseInt(multi.getParameter("refstep")));
				board.setName(multi.getParameter("name"));
				board.setSubject(multi.getParameter("subject"));
				board.setCategory(multi.getParameter("category"));
				board.setContent(multi.getParameter("content"));
				board.setFile1(multi.getFilesystemName("file1"));
				//수정시 첨부 파일의 수정이 발생하지 않은 경우
				if(board.getFile1()==null || board.getFile1().equals("")) {
					board.setFile1(multi.getParameter("file2"));
				}
				SBoardDao dao = new SBoardDao();
				dao.refstepadd(board.getRef(),board.getRefstep());
				
				//3.board객체를 db에 insert하기
				String msg = "답변 등록 실패";
				String url = "SReplyForm?num="+board.getNum();
				
				if(dao.insert(board)) {
					msg = "답변 등록 성공";
					url = "SList";
				}
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/alert.jsp";

	}
}

