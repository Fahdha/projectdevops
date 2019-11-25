package transfertim;

import java.net.*;



import java.io.*;

public class serveurconn extends Thread{


 ServerSocket reception;
	  static final int port=10000;

	  public serveurconn()
	  { try
	    { reception=new ServerSocket(port);
	    System.out.println("Le serveur est en écoute sur le "+port);
	    }
	    catch(IOException e) { System.exit(1); }
	    this.start();
	  }

	  public void run()
	  { Socket sock;
	   // Traitement t;
	   String text;

	    try
	    { while(true)
	      { 
	      	System.out.println("Le serveur est en attente ");
	      	sock=reception.accept();
	        System.out.println("Le serveur a accepté la connexion avec "+sock.getInetAddress());
	      //t=new Traitement(sock);
	       
	        BufferedReader entree= new BufferedReader(new InputStreamReader(sock.getInputStream()));
	        System.out.println("Le client cherche à récupérer le canal de communication ");
	  	 	PrintStream sortie=new PrintStream(sock.getOutputStream());
	  	 	System.out.println("Le client cherche à envoyer la donnée au serveur " );
	  	 	FileWriter lecture=new FileWriter("C:\\test2.txt");
	  	 	String text1=entree.readLine();
	  	 	while ((entree.readLine())!=null){
	  	 		text=entree.readLine();
	  	 		lecture.write(text1+text);

	  	 	}  
	  	 	lecture.close();	  	 	
		  	 	
		  	 	
	  	 	//sortie.println(text+" a ete recu par le serveur");
			sock.close();
	      

	      }
	    }
	    catch(IOException e) { }
	  }
	  public static void main(String[] args)
	  { new serveurconn();
	  }
	}



