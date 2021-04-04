package handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.BasketDao;
import dao.BuyDao;
import dao.MemberDao;
import model.Buy;
import model.Member;

import model.Product4;

public class MypageUpdateHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		try {
	         req.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		Member mem=new Member();//회원정보
		MemberDao memdao=new MemberDao();
		mem.setAddress(req.getParameter("address"));
		mem.setId(session.getAttribute("id").toString());
		mem.setName(req.getParameter("name"));
		mem.setPass(req.getParameter("pass"));
		mem.setBirth(req.getParameter("birth"));
		mem.setTel(req.getParameter("tel"));
		memdao.update(mem);
		
		String msg="개인정보 수정 성공";
		String url="mypageForm";
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("mem", mem);
		req.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/alert.jsp";
	}
}
