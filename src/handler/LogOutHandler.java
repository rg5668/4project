package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;
import model.Member;


public class LogOutHandler implements CommandHandler
{
		@Override
		public String process(HttpServletRequest req,HttpServletResponse res)
		{
			String msg="이미 로그아웃 되었습니다";
			String url="main";
			
			HttpSession session = req.getSession();

			int sess = 1;
			if(session.getAttribute("id")==null) {
				sess = 0;
			}

			if (sess != 0) {
				session.invalidate();
				msg="로그아웃 되었습니다";
				sess=0;
				url="main?sess="+sess;
			}
			
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			return "/view/ex/alert.jsp";
		}
}
