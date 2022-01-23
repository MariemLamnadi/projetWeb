package beans;

import java.util.Date;

public class Occupation {
	
	private  int id ;
	private Salle salle ;
	private Creneaux creneaux;
	private Date date;
	private Client client ;
	public Occupation(int id ,Salle salle,Creneaux creneaux,Date date,Client client) {
		this.id = id;
		this.salle = salle;
		this.creneaux = creneaux;
		this.date = date;
		this.client =client;
	}

	public Occupation(Salle salle, Creneaux creneaux, Date date, Client client) {
		super();
		this.salle = salle;
		this.creneaux = creneaux;
		this.date = date;
		this.client = client;
	}

	public int getId() {
		return id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Creneaux getCreneaux() {
		return creneaux;
	}
	public void setCreneaux(Creneaux creneaux) {
		this.creneaux = creneaux;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Occupation [id=" + id + ", salle=" + salle + ", creneaux=" + creneaux + ", date=" + date + "]";
	}
	
	

}
