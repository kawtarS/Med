package bd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Emprunt;
import model.Client;
import model.Etudiant;
import model.Professeur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Kindel;

public class CRUD_Emprunt {
	
	public static Connection getConnection() {
		Connection con=null;;
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mediatheque1";
			con = DriverManager.getConnection(url,"root","kawtar");
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return con;
	}
	public static  boolean ajouter_emprunt(Emprunt t) throws SQLException {
		int statue1 =0;
		try {
	Connection con = CRUD_Emprunt.getConnection();
String sql1 ="INSERT INTO emprunts (idclient,idkindel,dateemprunt,dateretour,idemprunt) Values (?,?,?,?,?)";
			
			PreparedStatement preparedStatementHieritage;
					preparedStatementHieritage = (PreparedStatement) con.prepareStatement(sql1);
					preparedStatementHieritage.setString(1,t.getClient().getCin());
					preparedStatementHieritage.setInt(2,t.getKindel().getMac());
					preparedStatementHieritage.setInt(3, t.getDate_emprunt());
					preparedStatementHieritage.setInt(4,t.getDate_retour());
					preparedStatementHieritage.setFloat(5,t.getid());
					
                   statue1 = preparedStatementHieritage.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (statue1 > 0 );
		 } 
			    	
	public static List<Emprunt>get_Emprunt() throws SQLException{
		List<Emprunt> list = new ArrayList<Emprunt>();
		
		try {
		
		Connection con =CRUD_Emprunt.getConnection();
		String query="select clients.username, clients.motdepasse ,clients.cin,clients.clientid,clients.nom,clients.prenom,clients.cne,clients.matricule,clients.userType,  kindel.mac,kindel.model,kindel.pouces,kindel.emprunt,kindel.lon,kindel.lat ,emprunts.dateretour,emprunts.dateretour,emprunts.dateemprunt,emprunts.idemprunt FROM mediatheque1.emprunts INNER JOIN mediatheque1.clients ON emprunts.idclient=clients.cin INNER JOIN mediatheque1.kindel ON emprunts.idkindel = kindel.mac;";
				
				
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
		//preparedStatement.setInt(0,type);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Emprunt E= new Emprunt();
			E.setDate_emprunt(rs.getInt("dateemprunt"));
			E.setDate_emprunt(rs.getInt("dateretour"));
			
			
			
				Kindel K=new Kindel(rs.getString("model"),rs.getInt("mac"),rs.getFloat("pouces"),rs.getFloat("lon"),rs.getFloat("lat"));
				K.setEmprunte(rs.getBoolean("emprunt"));
				E.setKindel(K);
			
		
				if (rs.getInt("userType")==0) {
			Etudiant Z= new Etudiant(rs.getString("username"),rs.getString("motdepasse"),rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("cne"),rs.getInt("clientid"));
			E.setClient(Z);
				}
			if (rs.getInt("userType")==1) {
				Professeur P= new Professeur(rs.getString("username"),rs.getString("motdepasse"),rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("matricule"),rs.getInt("clientid"));
				E.setClient(P);
			}
			
				
				
		
			
				list.add(E);}
	
		
		}catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
}
	
	
	
	
	
	public static boolean Supprimer(Emprunt K)throws SQLException{
		int statue1 =0;
		try {
			
			String sql = "DELETE FROM emprunts where idemprunt=?";
			Connection con = CRUD_Emprunt.getConnection();
			
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setInt(1,K.getid());
			statue1 = preparedStatement.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (statue1 > 0 );
	}
	public static int Modifier_dateemp (Emprunt K,int date_emp) throws SQLException{
	   	
		int statue1 =0;
		
		try {
			
			String sql = "UPDATE emprunts SET dateemprunt=?  where idemprunt=?";
			Connection con = CRUD_Emprunt.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setInt(1,K.getid());
			preparedStatement.setInt(2,K.getDate_emprunt());
			

			
			statue1=preparedStatement.executeUpdate();

//			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return statue1 ;
		
	}
	
	
	


 
	public static int Modifier_dateretour (Emprunt K,Date date_re) throws SQLException{
	   	

		int statue1 =0;
		
		try {
			
			String sql = "UPDATE emprunts SET dateemprunt=?  where idemprunt=?";
			Connection con = CRUD_Emprunt.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setInt(1,K.getid());
			preparedStatement.setInt(2,K.getDate_retour());
			

			
			statue1=preparedStatement.executeUpdate();

//			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return statue1 ;
		
	}
	
}

