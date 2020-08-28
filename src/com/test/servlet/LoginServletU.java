package com.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import com.test.model.User;

/**
 * Servlet implementation class LoginServletU
 */
@WebServlet("/userlogin")
public class LoginServletU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletU() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String psw = request.getParameter("password");
		
		UserDao uda =  new UserDaoImpl();
		User u =  uda.userLogin(un, psw);
		 if(u!=null) {
			 //session creating
			 HttpSession session = request.getSession();
			 session.setAttribute("validuser",u.getUsername());
			 session.setMaxInactiveInterval(14);
			 
			 request.setAttribute("user", un);
			 request.getRequestDispatcher("home.jsp").forward(request, response);
		 }
		 else {
			request.setAttribute("error", "user doest exist");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		 }
		
	}

}
