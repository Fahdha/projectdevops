package haouari_bourouay;


public class Table {

    public static void main(String[] args) {
        // TODO code application logic here
        int nbr = 5;

    	ThreadGroup gp = new ThreadGroup("pers");        
        Personnes[] pers = new Personnes[nbr];
        Baguette bg = new Baguette(nbr);


 
 
    for (int k =0; k<nbr; k++) pers[k] = new  Personnes(gp, k, 7, bg);
 
    long debut = System.currentTimeMillis();
    for (Personnes consommer:pers)  consommer.start();
    while( gp.activeCount()!=0) Thread.yield();

    long Fin = System.currentTimeMillis();
    double duree = (Fin -  debut) / 1000d;
 
    System.out.printf("Toutes les personnes ont fini leurs repas en %.3f s.", duree);
  }
    }
    
