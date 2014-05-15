package model;

public class Utilisateur{

	private  int id;
	private String mail;
	private String nom;
	private String prenom;
	private String psoeudo;
	private byte[] photoDeProfil;
	
	
	public Utilisateur(){
		
	}
	
	

	public Utilisateur(int id, String mail, String nom, String prenom,
			String psoeudo, byte[] photoDeProfil) {
		super();
		this.id = id;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.psoeudo = psoeudo;
		this.photoDeProfil = photoDeProfil;
	}

	public void SeConnecter(){
		
	}
	public void SeDeconnecter(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public String getPsoeudo() {
		return psoeudo;
	}

	public void setPsoeudo(String psoeudo) {
		this.psoeudo = psoeudo;
	}

	public byte[] getPhotoDeProfil() {
		return photoDeProfil;
	}

	public void setPhotoDeProfil(byte[] photoDeProfil) {
		this.photoDeProfil = photoDeProfil;
	}
}
