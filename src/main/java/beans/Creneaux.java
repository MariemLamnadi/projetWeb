package beans;

import java.sql.Time;




public class Creneaux {
	private int id ;
	private Time heurDebut;
	private Time heurFin;
	
	private static int count =0 ;

	public Creneaux(int id, Time heurDebut, Time heurFin) {
		super();
		this.id = id;
		this.heurDebut = heurDebut;
		this.heurFin = heurFin;
	}

	public Creneaux(Time heurDebut, Time heurFin) {
		this.id = ++count;
		this.heurDebut = heurDebut;
		this.heurFin = heurFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHeurDebut() {
		return heurDebut;
	}

	public void setHeurDebut(Time heurDebut) {
		this.heurDebut = heurDebut;
	}

	public Time getHeurFin() {
		return heurFin;
	}

	public void setHeurFin(Time heurFin) {
		this.heurFin = heurFin;
	}

	@Override
	public String toString() {
		return "Creneaux [id=" + id + ", heurDebut=" + heurDebut + ", heurFin=" + heurFin + "]";
	}
	
	

}
