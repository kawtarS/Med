package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
public class SeverMT extends Thread {
	//chaque client en attribut un num
	int nb=0;
	public void run() {
		try {
			ServerSocket ss=new ServerSocket(12652);
			while(true) {
				Socket s=ss.accept();
				++nb;
				new Conv(s,nb).start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//comunication avec client 
	class Conv extends Thread{
		//private static final String InputStreamReader isr = null;
		private Socket socket; 
		private int numclient;
		
		public Conv(Socket socket,int num) {
			super();
			this.socket=socket;
			this.numclient=num;
		}
		public void run() {
			//le code de la conversation
			//comunication avec chaine de caractere
			try {
				InputStream is= socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				//envoyer
				OutputStream os=socket.getOutputStream();
				PrintWriter pw=new PrintWriter(os,true);
				//savoir add ip du client
				String IP=socket.getRemoteSocketAddress().toString();
				System.out.println("Connexion du client num"+numclient+"IP="+IP);
				
				pw.println("hi ,vous etes le client num"+numclient);
				while(true) {
					//convo
					String req=br.readLine();
					System.out.println(IP+"a envoye"+req);
					String rep="size"+req.length();
					if(rep!=null) {
						pw.println(rep);
					}
					
				}
				
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new SeverMT().start();
	}
	

}
