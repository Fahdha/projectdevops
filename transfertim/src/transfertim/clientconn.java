package transfertim;

import java.net.*;
import java.io.*;

public class clientconn {

 Socket sock=null;
	  public void connexion(String host, int port) 
	  { try
	    { 	System.out.println("Le client cherche à se connecter au serveur " + host + "@"+port);
	    	sock = new Socket(host, port);
	    	System.out.println("Le client s'est connecté sur serveur " + host + "@"+port);
	     
	    }
	    catch(IOException e) { }
	  }
	  public void envoi(){
	  	 try{
	  	 	System.out.println("Le client cherche à récupérer le canal de communication ");
	  	 	PrintStream output=new PrintStream(sock.getOutputStream());
	  	 	InputStream flux=new FileInputStream("C:\\test.txt"); 
	  	 	InputStreamReader lecture=new InputStreamReader(flux);
	  	 	BufferedReader buff=new BufferedReader(lecture);
	  	 	String ligne;
	  	 	String res = null;
	  	 	while ((ligne=buff.readLine())!=null){
           res=res+ligne+";";
	  	 		output.println(ligne);
	  	 	}
	  	 	buff.close();
	  	 	System.out.println("Le client cherche à envoyer la donnée au serveur " );
	  	 	
	  	 }
	  	 catch(IOException e){
	  	 }
	      
	  }
	  public void recevoir(){
	  	 try{
	  		System.out.println("Le client cherche à récupérer le canal de communication ");
	  		BufferedReader entree=new BufferedReader(new InputStreamReader(sock.getInputStream()));
	        String text=entree.readLine();
	      	System.out.println(text);
	      }
	  	 catch(IOException e){
	  	 }
	  }
	  public void fermer(){
	  	    try{ 
	  	    	System.out.println("Le client ferme la connexion au serveur ");
	  	    	sock.close();
	  			}
	  		catch(IOException e){
	  	 }
	  }	

	  public static void main(String[] args)
	  { 
	  clientconn client=new clientconn();
	  client.connexion("127.0.0.1", 10000);
	  client.envoi();

	  client.fermer();
	  }
	}

	

