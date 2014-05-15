package model;

public abstract class Publication {
	protected int id ;
	protected String commentaire;
	
	public Publication(int id, String commentaire) {
		super();
		this.id = id;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	
}
