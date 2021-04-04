package handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import command.CommandHandler;
import dao.BoardDao;
import dao.Product4Dao;
import model.Board;
import model.Product4;

public class SearchHandler implements CommandHandler{

		@Override
		public String process(HttpServletRequest request, HttpServletResponse res) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String search=request.getParameter("search");
			
			List<Product4> list=new ArrayList<Product4>();
			Product4Dao dao = new Product4Dao();
			list=dao.select(search);

	        request.setAttribute("pro", list);
	        HttpSession session=request.getSession();
	        request.setAttribute("session", session.getAttribute("id"));
			return "/view/ex/listForm.jsp";
	}
}
