package model;

import java.util.Date;

public class Emprunt {
 
  private final int id;
    private Client client;
    private Kindel kindel;
    private int date_emprunt;
    private int date_retour;
    
    public Emprunt(Client client,Kindel kindel, int date_emprunt,int date_retour,int id ){
        this.client= new Client(client);
        this.kindel= new Kindel(kindel);
       this.date_emprunt=  date_emprunt;
        this.date_retour=  date_retour;
       this.id=id;
    }
 public Emprunt() {id=0;};
    public Client getClient() {
        return client;
    }
    public int getid() {
        return id;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Kindel getKindel() {
        return kindel;
    }

    public void setKindel(Kindel kindel) {
        this.kindel = kindel;
    }

    public int getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(int date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public int getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(int date_retour) {
        this.date_retour = date_retour;
    }
   public boolean isEtudiant() {
	   if (this.client instanceof Etudiant) return true;
	   else return false;
		   
	   
   }
    
   public String toString(){
	   return  "client: "+ client+ "Kindel:"+ kindel+"date-emp:"+date_emprunt + "date_retour: "+ date_retour;
    }
  
    
}