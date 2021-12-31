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

import com.book.dao.CartDaoImpl;
import com.book.pojo.Cart;



@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	HttpSession session;
	RequestDispatcher rd;
	Cart c;
	CartDaoImpl cimpl = new CartDaoImpl();
	
	boolean flag;
	
	int cartid;
	int bookid;
	String cemail;
	int quantity;
	String bookname;
	double bookprice;
	
	List<Cart> list;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process = request.getParameter("process");
		
		session = request.getSession();
		
		if(process!=null && process.equals("addToCart")) {
			
			bookid= Integer.parseInt(request.getParameter("bookid"));
			cemail = (String) session.getAttribute("customer");
			
			if(cemail==null) {
				
				request.setAttribute("emsg", "Please login first , before adding books to cart!!");
				
				rd= request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
			else if(cemail!=null) {
				
				Cart c1 = cimpl.checkBookId(bookid, cemail);
				
				if(c1!=null) {
					
					cartid=c1.getCartid();
					quantity=c1.getQuantity()+1;
					
					cimpl.updateQuantity(cartid, quantity);
					
					request.setAttribute("msg", "This product was already in cart, and the qunantity has been increased!!");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				}
				
			
			else {
				
				/* quantity= Integer.parseInt(request.getParameter("quantity")); */
				
				quantity=1;
			
			
			
			c= new Cart();
			c.setBookid(bookid);
			c.setCemail(cemail);
			c.setQuantity(quantity);
			
			flag = cimpl.addtoCart(c);
			
			if(flag) {
				
				request.setAttribute("msg", "Book added to Cart Successfully!!");
				
				rd= request.getRequestDispatcher("Home.jsp");
				rd.include(request, response);
			}
			else {
				request.setAttribute("emsg", "Error while Adding Books to Cart!!");
				
				rd= request.getRequestDispatcher("Home.jsp");
				rd.include(request, response);
			}
			
			}
			}
			
		}
		
		else if(process!=null && process.equals("myCart")) {
			
			cemail = (String) session.getAttribute("customer");
			
			list=cimpl.showMyCart(cemail);
			System.out.println("list of myCart= "+list);
			if(list.isEmpty()) {
				
				request.setAttribute("msg", "Your Cart is Empty Please add book in your cart");
				
				rd= request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
			else {
				session.setAttribute("MyClist", list);
				
				rd= request.getRequestDispatcher("ViewCart.jsp");
				rd.forward(request, response);
			}
			
			
			
		}
		
		else if(process!=null && process.equals("deleteCart")) {
			
			cartid= Integer.parseInt(request.getParameter("cartid"));
			
			flag=cimpl.removeFromCart(cartid);
			System.out.println("flag of deletItem in servlet= "+flag);
			if(flag) {
				
				request.setAttribute("msg", "Book removed from cart!!");
				
				list=cimpl.showMyCart(cemail);
				
				session.setAttribute("MyClist", list);
				
				rd= request.getRequestDispatcher("ViewCart.jsp");
				rd.forward(request, response);
			}
			
			else {
				
				request.setAttribute("emsg", "Error while deleting");
				
				session.setAttribute("MyClist", list);
				
				rd= request.getRequestDispatcher("ViewCart.jsp");
				rd.forward(request, response);
			}
				
		}
		
		else if(process!=null && process.equals("allCart")){
			
			list=cimpl.showAllCartCopy();
			
				session.setAttribute("allcartCopy", list);
				
				response.sendRedirect("AllCart.jsp");
			
			
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process = request.getParameter("process");
		
		session = request.getSession();
		
		if(process!=null && process.equals("updateQuantity")) {
			
			quantity = Integer.parseInt(request.getParameter("Quantity"));
			cartid = Integer.parseInt(request.getParameter("Cid"));
			
			cimpl.updateQuantity(cartid, quantity);
		}
		
	}

}
