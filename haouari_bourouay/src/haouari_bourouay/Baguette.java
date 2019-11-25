package haouari_bourouay;

import java.util.Arrays;


public class Baguette {
    
 
  int nbrbaguettes;
  boolean[] baguettes;
 
  public Baguette(int nbr) {
    Arrays.fill(baguettes, true);
    this.nbrbaguettes = nbr;
    baguettes = new boolean[nbr];

  }
 

 
  
  public synchronized void terminer(int m) {
    int g = m;
    int d = (m+1)%nbrbaguettes;      
    baguettes[g] = true;
    baguettes[d] = true;
    notifyAll(); 
  }    
  public synchronized void commancer(int n) {
	    int g = n;
	    int d = (n+1)%nbrbaguettes;      
	    while (!baguettes[g] || !baguettes[d]) {            
	      try   {  wait();  } catch (InterruptedException e) {}
	    }
	    baguettes[g] = false;
	    baguettes[d] = false;
	  }
    
}
