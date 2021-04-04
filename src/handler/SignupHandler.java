package handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import command.CommandHandler;
import dao.BoardDao;
import dao.MemberDao;
import model.Board;
import model.Member;


public class SignupHandler implements CommandHandler
{
	@Override
	public String process(HttpServletRequest req,HttpServletResponse res)
	{HttpSession session=req.getSession();
		try {
	         req.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String userphone = req.getParameter("userphone");
		String birthyy = req.getParameter("birthyy");
		String birthmm = req.getParameter("birthmm");
		String birthdd = req.getParameter("birthdd");
		

		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		
		String birth = stringTodate1(birthyy, birthmm, birthdd);
		String address = stringTodate2(address1,address2);
		
		Member member = new Member();
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setTel(userphone);
		member.setBirth(birth);
		member.setAddress(address);
		
		MemberDao dao=new MemberDao();
		dao.insert(member);
		
		String msg = "가입되었습니다.";
		String url = "loginForm";
		
		System.out.println(member);
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.setAttribute("session", session.getAttribute("id"));
		return "/view/ex/alert.jsp";
	}

	public String stringTodate1(String birthyy, String birthmm, String birthdd) {
		
		String birth = birthyy + birthmm + birthdd;
		return birth;
	}
	
	public String stringTodate2(String address1, String address2) {
		
		String address = address1 + address2;
		return address;
	}

	}
	
