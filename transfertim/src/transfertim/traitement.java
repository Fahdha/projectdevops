package transfertim;
import java.net.*;
import java.io.*;

public class traitement extends Thread{


 Socket sock;
	  BufferedReader entree;

	  public traitement(Socket socket)
	  { sock=socket;
	    try
	    { entree=new BufferedReader(new InputStreamReader(sock.getInputStream()));
	    }
	    catch(IOException e) { }
	    this.start();
	  }

	  public void run()
	  { String text;
	    try
	    { text=entree.readLine();
	      System.out.println(text);
	      sock.close();
	    }
	    catch(IOException e) { }
	  }
	}


