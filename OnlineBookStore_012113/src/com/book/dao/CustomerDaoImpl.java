package com.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.book.pojo.Customer;
import com.book.util.DBConnectivity;


public class CustomerDaoImpl implements CustomerDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	Customer c;
	
	
	@Override
	public boolean addCustomer(Customer c) {
		con= DBConnectivity.getConnection();
		sql = "insert into customer96 (fname, lname, caddress, cemail, contact, password) values (?,?,?,?,?,?)";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setString(3, c.getCaddress());
			ps.setString(4, c.getCemail());
			ps.setString(5, c.getContact());
			ps.setString(6, c.getPassword());
			System.out.println(ps);
			int i = ps.executeUpdate();
			
			
			if(i>0) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		
		con= DBConnectivity.getConnection();
		
		sql = "update customer96 set fname=?, lname=?, caddress=?, cemail=?, contact=?, password=? where cid=?";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setString(3, c.getCaddress());
			ps.setString(4, c.getCemail());
			ps.setString(5, c.getContact());
			ps.setString(6, c.getPassword());
			ps.setInt(7, c.getCid());
			
			int i= ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		con =  DBConnectivity.getConnection();
		
		sql = "delete from customer96 where cid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, cid);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer searchCustomer(int cid) {
		
		con= DBConnectivity.getConnection();
		
		sql = "select * from Customer96 where cid=?";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setInt(1, cid);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				c= new Customer();
				
				c.setCid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setCaddress(rs.getString(4));
				c.setCemail(rs.getString(5));
				c.setContact(rs.getString(6));
				c.setPassword(rs.getString(7));
				
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer searchCustomer(String cemail) {
		con  = DBConnectivity.getConnection();
		
		sql= "select * from customer96 where cemail=?";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setString(1, cemail);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setCaddress(rs.getString(4));
				c.setCemail(rs.getString(5));
				c.setContact(rs.getString(6));
				c.setPassword(rs.getString(7));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> showCustomers() {
		List<Customer> customerlist = new ArrayList<>();
		try {
		con = DBConnectivity.getConnection();
		
		sql = "select * from customer96";
		
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				Customer customer= new Customer();
				customer.setCid(rs.getInt(1));
				customer.setFname(rs.getString(2));
				customer.setLname(rs.getString(3));
				customer.setCaddress(rs.getString(4));
				customer.setCemail(rs.getString(5));
				customer.setContact(rs.getString(6));
				customer.setPassword(rs.getString(7));
				
				customerlist.add(customer);
			}
			return customerlist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
