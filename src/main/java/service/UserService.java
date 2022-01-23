package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.User;
import connexion.Connexion;
import dao.IDao;

public class UserService implements IDao<User> {

	@Override
	public boolean create(User o) {
		String sql = "insert into user values (null, ?, ? )";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setString(1, o.getLogin());
			ps.setString(2, o.getPassword());
			;
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("create : erreur sql : " + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean delete(User o) {
		String sql = "delete from user where id  = ?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("delete : erreur sql : " + e.getMessage());

		}
		return false;
	}

	@Override
	public boolean update(User o) {
		String sql = "update user set login = ? , password = ?  where id  = ?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setString(1, o.getLogin());
			ps.setString(2, o.getPassword());
			ps.setInt(4, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("update : erreur sql : " + e.getMessage());

		}
		return false;
	}

	@Override
	public User findById(int id) {
		String sql = "select * from user where id  = ?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from user";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("password")));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return users;
	}

	public boolean connexion(String login, String password) {
		try {

			String sql = "select * from user where login=? and password =?";
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);

			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return true;

			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return false;
	}
	public boolean login(String login,String password) {

	     try {
			 String sql = "select id,login,password from user where login  = ? and password= ?" ;
	         PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	         ps.setString(1, login);
	         ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();
	             if(rs.next()) {
	            	 
	            	 return true;
	             }else {
	            	 return false;
	             }
	     } catch (SQLException e) {
	         System.out.println("login " + e.getMessage());
	     }
		return false;
		 
	 }
}
