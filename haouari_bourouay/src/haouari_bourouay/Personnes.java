package haouari_bourouay;


import java.util.Random;


public class Personnes extends Thread{
    
   
  int numero;
 
  int nbfois;
  
  long debut; 
  
  double duree;
 
  Baguette bg;
  
  static final int Maxb=250;
  
  static final int Maxp=800;

 
  Personnes(ThreadGroup gp, int numero, int nbfois, Baguette bg)
  {
    super(gp, "Philosophe numero :"+numero);	
    this.nbfois = nbfois;
    this.bg = bg;
    this.numero = numero;
  }
  public void run()
  {
    debut = System.currentTimeMillis();
    Random aleatoire = new Random();
    while(nbfois>0)
    {
      System.out.println(this.getName() + " : je veux  manger ");
      bg.commancer(numero);           
      nbfois--;
       System.out.println(this.getName() + " :  je mange, il me reste " + nbfois + " bouchees.");
      try {  Thread.sleep(aleatoire.nextInt(Personnes.Maxb ));} 
      catch (InterruptedException e) {}
 
      bg.terminer(numero);
      System.out.println(this.getName() + " : je  pense ...");
      try {  Thread.sleep( aleatoire.nextInt(Personnes.Maxp ));}  
      catch (InterruptedException e) {}
    }
    long fin = System.currentTimeMillis();
    duree = (fin-debut)/1000d;
    System.out.printf("%s : Assiet vide ,j'ai fini mon repas en %.3f s.\n", this.getName(),duree);
  }
    
}

