package com.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import com.test.model.User;

/**
 * Servlet implementation class SignupU

 */


@WebServlet("/signup")
public class SignupU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignupU() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("signup.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		User u = new User();
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		
		UserDao udao = new UserDaoImpl();
		udao.userSignup(u);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
