package model;

public class Client extends Utilisateur {
	static private int idClient;
	 private  int id;
    private String cin;
    private String nom;
    private String prenom;
    
    public Client(String login, String password, String cin, String  nom, String  prenom,int idClient){
    	
    	super(login, password);
    	this.id=idClient;
    	this.cin= new String(cin);
        this.nom= new String(nom);
        this.prenom= new String(prenom);
    }
    public Client() {}
    
    public Client(Client c){
        super(c.getLogin(), c.getPassword());
        this.cin= new String(c.getCin());
        this.nom= new String(c.getNom());
        this.prenom= new String(c.getPrenom());
    }
    
    public String toString(){
        return "Cin: "+cin+" Nom:"+nom+" Prenom:"+ prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public int getid() {
        return idClient;
    }
    
     
}