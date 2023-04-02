package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;
import com.entity.User;

public class ContactDAO {
	private Connection con;

	public ContactDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean saveContact(Contact c) {
		boolean f = false;
		try {
			String sql = "insert into contacts (name,email,phone,about,userid) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setLong(3, c.getPhone());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getUserId());

			if (ps.executeUpdate() == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public List<Contact> viewContacts(int userid) {
		List<Contact> list = new ArrayList<Contact>();
		try {
			String sql = "select * from contacts where userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getLong(4));
				c.setAbout(rs.getString(5));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public Contact getContact(int cid) {
		Contact c = new Contact();
		try {
			String sql = "select * from contacts where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getLong(4));
				c.setAbout(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean updateContact(Contact c) {
		boolean f=false;
		try {
			String sql="update contacts set name=?, email=?, phone=?, about=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setLong(3, c.getPhone());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getId());
			
			if (ps.executeUpdate() == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteContact(int id) {
		boolean f=false;
		try {
			String sql="delete from contacts where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);			
			if (ps.executeUpdate() == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
}
