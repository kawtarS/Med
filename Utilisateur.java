package model;

/**
 *

 */
public abstract class  Utilisateur {
private String login;
private String password;

public Utilisateur(String login,String password){
this.login= new String(login);
this.password= new String(password);}
 public Utilisateur() {}
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}