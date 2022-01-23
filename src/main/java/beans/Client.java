package beans;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String cin;
	private String email ;
	private String password;
	private static int comp =0 ;
	public Client(String nom, String prenom, String cin,String email,String password) {
		this.id = ++comp;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
		this.password = password ;
	}
	
	public Client(int id, String nom, String prenom, String cin,String email,String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
		this.password = password ;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + "]";
	}
	
	
	
	
	

}
