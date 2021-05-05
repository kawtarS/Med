package model;

public class Etudiant extends Client{
    private String cne;
    public Etudiant(String login, String password, String cin, String  nom, String  prenom, String cne,int id){
        super(login, password, cin, nom, prenom,id);
        this.cne= new String(cne);
    }
    public Etudiant() {}
      public String toString(){
        return super.toString()+" CNE: "+cne;
    } 

    public String getCne() {
        return cne;
    }
      
            
}