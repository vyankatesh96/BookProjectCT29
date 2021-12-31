package com.book.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.OrderDao;
import com.book.dao.OrderDaoImpl;
import com.book.pojo.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    HttpSession session;
    RequestDispatcher rd;
    
    OrderDao oimpl = new OrderDaoImpl();
    
    Order order;
    
    List<Order> Olist;
    
    int orderId;
	String orderStatus;
	String orderDate;
	String cemail;
	double totalBill;
	
	boolean flag;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process= request.getParameter("process");
		
		session = request.getSession();
		
		if(process!=null && process.equals("allOrders")) {
			
			Olist=oimpl.ShowAllorders();
			
			session.setAttribute("AllOrders", Olist);
			
			response.sendRedirect("AllOrders.jsp");
		}
		
		else if(process!=null && process.equals("updateStatus")) {
			
			orderId=Integer.parseInt(request.getParameter("orderId"));
			
			orderStatus="Completed";
			
			flag=oimpl.UpdateStatus(orderStatus, orderId);
			
			if(flag) {
				request.setAttribute("msg", "Status Changed to Completed!!");
				
				Olist=oimpl.ShowAllorders();
				session.setAttribute("AllOrders", Olist);
				
				rd=request.getRequestDispatcher("AllOrders.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(process!=null && process.equals("CancelOrder")) {
			
			orderId=Integer.parseInt(request.getParameter("orderId"));
			
			orderStatus="Cancelled";
			
			flag=oimpl.UpdateStatus(orderStatus, orderId);
			
			if(flag) {
				request.setAttribute("msg", "Status Changed to Cancelld!!");
				Olist=oimpl.ShowAllorders();
				session.setAttribute("AllOrders", Olist);
				
				rd=request.getRequestDispatcher("AllOrders.jsp");
				rd.forward(request, response);
			}
			
		}
		
		else if(process!=null && process.equals("myorderhistory")) {
			
			cemail= (String)session.getAttribute("customer");
			
			Olist= oimpl.ShowMyOrderHistory(cemail);
			
			if(Olist.isEmpty()) {
				
				request.setAttribute("msg", "You order history is empty");
				
				
				
				rd=request.getRequestDispatcher("MyOrderHistory.jsp");
				rd.forward(request, response);
			}
			
			else {
				
				session.setAttribute("myOH", Olist);
				response.sendRedirect("MyOrderHistory.jsp");
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process= request.getParameter("process");
		
		session = request.getSession();
		
		if(process!=null && process.equals("order")) {
			
			cemail= (String)session.getAttribute("customer");
			totalBill=Double.parseDouble(request.getParameter("bill"));
			
			order=oimpl.placeOrder(cemail, totalBill);
			
			session.setAttribute("myOrder", order);
			
			request.setAttribute("mgs", "Your order has been placed successfully!!");
			
			rd=request.getRequestDispatcher("MyOrder.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
