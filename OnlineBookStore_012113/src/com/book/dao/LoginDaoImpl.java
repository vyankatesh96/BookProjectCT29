package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.util.DBConnectivity;

public class LoginDaoImpl implements LoginDao{

	Connection con;
	String sql;
	ResultSet rs;
	PreparedStatement ps;
	
	@Override
	public boolean isOurCustomer(String cemail, String password) {
		con = DBConnectivity.getConnection();
		
		sql = "select * from customer96 where cemail=? and password=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cemail);
			ps.setString(2, password);;
			
			rs=ps.executeQuery();
			
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean isOurAdmin(String adEmail, String adPassword) {
		
con = DBConnectivity.getConnection();
		
		sql = "select * from admin96 where adEmail=? and adPassword=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, adEmail);
			ps.setString(2, adPassword);
			
			rs=ps.executeQuery();
			
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
