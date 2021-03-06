package com.book.Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.CustomerDaoImpl;
import com.book.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	
       
   

    HttpSession session;
    RequestDispatcher rd;
    CustomerDaoImpl cimpl = new CustomerDaoImpl();
    
    int cid;
	String fname;
	String lname;
	String caddress;
	String cemail;
	String contact;
	String password;
	
	boolean flag;
	
	List<Customer> list;
	Customer c;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String process = request.getParameter("process");
		
		session= request.getSession();
		
		if(process!=null && process.equals("updateCust")) {
			
			cid= Integer.parseInt(request.getParameter("cid"));
			
			c= cimpl.searchCustomer(cid);
			System.out.println("Customer in doGet= "+c);
			session.setAttribute("uCust", c);
			
			response.sendRedirect("updateCust.jsp");
		}
		
		else if(process!=null && process.equals("deleteCust")) {
			
			cid= Integer.parseInt(request.getParameter("cid"));
			
			flag=cimpl.deleteCustomer(cid);
			
			if(flag) {
				
				request.setAttribute("msg", "Deleted Successfully");
				
				list= cimpl.showCustomers();
				
				session.setAttribute("list", list);
				
				rd= request.getRequestDispatcher("customerlist.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("msg", "Error while Deleting Successfully");
				
				list =cimpl.showCustomers();
				
				session.setAttribute("list", list);
				
				rd= request.getRequestDispatcher("customerlist.jsp");
				rd.forward(request, response);
			}
			
		}
		
		else if(process!=null && process.equals("Customerlist")) {
			
			list= cimpl.showCustomers();
			
			session.setAttribute("list", list);
			
			rd= request.getRequestDispatcher("customerlist.jsp");
			rd.forward(request, response);
		}
		
		else if(process!=null && process.equals("changecurrentpassword")) {
			
		}
		
		else {
			cemail= (String) session.getAttribute("customer");
			
			c= cimpl.searchCustomer(cemail);
			
			session.setAttribute("uCust", c);
			
			response.sendRedirect("updateCust.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process = request.getParameter("process");		
		PrintWriter pw= response.getWriter();
		
		session = request.getSession();
		
		System.out.println("Process in doPost = "+process);
		
		if(process!=null && process.equals("addcustomer")) {
			
			fname= request.getParameter("fname");
			lname= request.getParameter("lname");
			caddress= request.getParameter("caddress");
			cemail= request.getParameter("cemail");
			contact= request.getParameter("contact");
			password= request.getParameter("password");
			
			c= new Customer();
			c.setFname(fname);
			c.setLname(lname);
			c.setCaddress(caddress);
			c.setCemail(cemail);
			c.setContact(contact);
			c.setPassword(password);
			
			System.out.println("customer= "+c);
			flag=cimpl.addCustomer(c);
			
			if(flag) {
				
				request.setAttribute("msg","Customer Added Successfully");
				
				rd= request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			}
			else {
				
				request.setAttribute("emsg","Error while Adding Customer");
				
				rd= request.getRequestDispatcher("addCustomer.jsp");
				rd.include(request, response);
			}
			
		}
		
		else if(process!=null && process.equals("updateCust")) {
			cid=Integer.parseInt(request.getParameter("cid"));
			fname= request.getParameter("fname");
			lname= request.getParameter("lname");
			caddress= request.getParameter("caddress");
			cemail= request.getParameter("cemail");
			contact= request.getParameter("contact");
			password= request.getParameter("password");
			
			c= cimpl.searchCustomer(cid);
			c.setCaddress(caddress);
			c.setCemail(cemail);
			c.setContact(contact);
			c.setFname(fname);
			c.setLname(lname);
			c.setPassword(password);;
			
			
			
			flag=cimpl.updateCustomer(c);
			
			if(flag) {
				
				String msg="Your profile has been updated successfully";
				
				request.setAttribute("msg", msg);
				
				session.setAttribute("customer", null);
				
				rd= request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			}
			else
			{
			
				String emsg = "Error while Updating your profile";
				
				request.setAttribute("emsg", emsg);
				
				rd= request.getRequestDispatcher("updateCust.jsp");
				rd.forward(request, response);
				
			}
		}
		
	}

}
