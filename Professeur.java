package model;

public class Professeur extends Client {
    private String matricule;
    public Professeur(String login, String password, String cin, String  nom, String  prenom, String matricule,int id){
        super(login, password, cin, nom, prenom,id);
        
        this.matricule= new String(matricule);
    }
    
    public String toString(){
        return super.toString()+"Matricule: "+matricule;
    } 

    public String getMatricule() {
        return matricule;
    }
   
    
}
