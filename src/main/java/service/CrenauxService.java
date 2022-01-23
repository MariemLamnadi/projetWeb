package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Creneaux;
import beans.Salle;
import connexion.Connexion;
import dao.IDao;

public class CrenauxService implements IDao<Creneaux> {

	@Override
	public boolean create(Creneaux o) {
		
		  String sql = "insert into creneau values (null, ?, ?)";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setTime(1,o.getHeurDebut());
	            ps.setTime(2, o.getHeurFin());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("create : erreur sql : " + e.getMessage());

	        }
	       
		return false;
	}

	@Override
	public boolean delete(Creneaux o) {
		 String sql = "delete from creneau where id  = ?";
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
	public boolean update(Creneaux o) {
		  String sql = "update creneau set heurDebut = ? , heurFin = ?  where id  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setTime(1,o.getHeurDebut());
	            ps.setTime(2, o.getHeurFin());
	            ps.setInt(3, o.getId());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("update : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public Creneaux findById(int id) {
	     Creneaux c = null;
	        String sql = "select * from creneau where id  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	return new Creneaux(rs.getInt("id"),rs.getTime("heurDebut"),rs.getTime("heurFin") );         
	            }
	        } catch (SQLException e) {
	            System.out.println("findById " + e.getMessage());
	        }
	        return null;
	}

	@Override
	public List<Creneaux> findAll() {
		 List<Creneaux> creneaux = new ArrayList<Creneaux>();
	        String sql = "select * from creneau";
	        
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                creneaux.add(new  Creneaux(rs.getInt("id"),rs.getTime("heurDebut"),rs.getTime("heurFin") ));
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }
	        return creneaux;
	}
	

}
