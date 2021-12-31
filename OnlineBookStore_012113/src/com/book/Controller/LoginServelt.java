package com.book.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginServelt
 */
@WebServlet("/LoginServelt")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	HttpSession session;
	RequestDispatcher rd;
	
	LoginDaoImpl limpl = new LoginDaoImpl();
	
	boolean flag;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process = request.getParameter("process");
		
		session= request.getSession();
		
		if(process!=null && process.equals("LogOut")) {
			
			session.invalidate();
			
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process = request.getParameter("process");
		session= request.getSession();
		
		if(process!=null && process.equals("login")) {
			
			String usertype = request.getParameter("utype");
			String email = request.getParameter("uEmail");
			String password = request.getParameter("uPassword");
			
			if(usertype.equals("Customer")) {
				
				flag=limpl.isOurCustomer(email, password);
				
				if(flag) {
					
					request.setAttribute("msg", "Login Successfull!!!");
					
					session.setAttribute("customer", email);
					
					rd= request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				}
				else {
					
					request.setAttribute("emsg", "Email id or Password given is incorrect ");
					
					rd= request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
			
			else if(usertype.equals("Admin")) {
				
				flag=limpl.isOurAdmin(email, password);
				
				if(flag) {
					
					request.setAttribute("msg", "Login Successfull!!!");
					
					session.setAttribute("admin", email);
					
					rd= request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
					
				}
				else {
					
					request.setAttribute("emsg", "Email id or Password given is incorrect ");
					
					rd= request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
		}
		
	}

}
