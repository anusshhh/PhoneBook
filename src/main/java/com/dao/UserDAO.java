package com.dao;
import java.sql.*;

import com.entity.User;

public class UserDAO {
	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean userRegister(User user) {
		boolean f=false;
		try {
			String sql="insert into user (name,email,password) values (?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			if(ps.executeUpdate()==1) {
			  f=true;
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return f;
	}
	
	public User userLogin(String email,String pass) {
		User user = null;
		try {
	
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return user;
		
		
		
		
	}

}
