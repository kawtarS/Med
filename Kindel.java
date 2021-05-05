package model;

public class Kindel {
    String modele;
   int mac;
    float pouces;
    boolean emprunte;
    float lon ;
    float lat ;
    
    public Kindel(String modele, int mac, float pouces,float lon,float lan){
        this.modele= new String(modele);
        this.mac= mac;
        this.pouces= pouces;
        this.lon=lon;
        this.lat=lat;
        emprunte=false;
    }
    
      public Kindel(Kindel kindel){
        this.modele= new String(kindel.getModele());
        this.mac= kindel.getMac();
        this.pouces= kindel.getPouces();
        emprunte=false;
    }
    
    

    public String getModele() {
        return modele;
    }

    public int getMac() {
        return mac;
    }

    public float getPouces() {
        return pouces;
    }
    public float getlon() {
        return lon;
        
    }
    public float getlat() {
        return lat;
    }
    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }
    
    
    public String toString(){
        return  "Modele: "+ modele+ "Adresse MAC:"+  mac+"Pouces:"+pouces + "emprunt: "+ emprunte+ "lon: "+ lon+ "lat: "+ lat;
    }
}
