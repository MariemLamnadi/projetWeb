package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Occupation;
import beans.Salle;
import connexion.Connexion;
import dao.IDao;

public class OccupationService implements IDao<Occupation> {

	SalleService ss = new SalleService();
	CrenauxService cs = new CrenauxService();
	ClientService sc = new ClientService();

	@Override
	public boolean create(Occupation o) {
		try {
			String req = "Select COUNT(*) from occupation where date  = ? AND IDsalle = ? AND IDcreneaux = ?";
			PreparedStatement p = Connexion.getInstane().getConnection().prepareStatement(req);
			p.setDate(1, new Date(o.getDate().getTime()));
			p.setInt(2, o.getSalle().getId());
			p.setInt(3, o.getCreneaux().getId());

			ResultSet rs = p.executeQuery();
			rs.next();
			int i = rs.getInt("count(*)");
			if (i != 0) {

				System.out.println(i);
				return false;
			} else {

				String sql = "insert into occupation  values (null,?,?,?,?)";

				PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
				ps.setDate(3, new Date(o.getDate().getTime()));
				ps.setInt(1, o.getSalle().getId());
				ps.setInt(2, o.getCreneaux().getId());
				ps.setInt(4, o.getClient().getId());

				if (ps.executeUpdate() == 1) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("create : erreur sql : " + e.getMessage());

		}

		return false;

	}

	@Override
	public boolean delete(Occupation o) {
		String sql = "delete from occupation where id  = ?";
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
	public boolean update(Occupation o) {
		String sql = "update occupation set IDsalle  = ? ,IDcreneaux = ? , date =? IDclient =?  where id  = ?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, o.getSalle().getId());
			ps.setInt(2, o.getCreneaux().getId());
			ps.setDate(3, new Date(o.getDate().getTime()));
			ps.setInt(4, o.getClient().getId());
			ps.setInt(5, o.getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("update : erreur sql : " + e.getMessage());

		}
		return false;
	}

	@Override
	public Occupation findById(int id) {

		String sql = "select * from occupation where id  = ?";
		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Occupation(rs.getInt("id"), ss.findById(rs.getInt("IDsalle")),
						cs.findById(rs.getInt("IDcreneaux")), rs.getDate("date"), sc.findById(rs.getInt("IDclient")));
			}

		} catch (SQLException e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Occupation> findAll() {

		List<Occupation> occupations = new ArrayList<Occupation>();
		String sql = "select * from occupation";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				occupations.add(new Occupation(rs.getInt("id"), ss.findById(rs.getInt("IDsalle")),
						cs.findById(rs.getInt("IDcreneaux")), rs.getDate("date"), sc.findById(rs.getInt("IDclient"))));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return occupations;
	}

}
