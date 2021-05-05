package model;

public class Auteur {
 public int idAteur;
 public String nom;
 public String prenom;
 public Auteur(int id, String nom,String prenom) {
	 this.idAteur=id;
	 this.nom=nom;
	 this.prenom=prenom;
 }
@Override
public String toString() {
	return "Auteur [idAteur=" + idAteur + ", nom=" + nom + ", prenom=" + prenom + ", getIdAteur()=" + getIdAteur()
			+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
}
public int getIdAteur() {
	return idAteur;
}
public void setIdAteur(int idAteur) {
	this.idAteur = idAteur;
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
}
