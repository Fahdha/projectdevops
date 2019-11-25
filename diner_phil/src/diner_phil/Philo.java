package diner_phil;

public class Philo implements Runnable {
	int i;
 
	public Philo(int i) {
		this.i=i;
	}
 
	public void run() {
		new Philo(i);
		System.out.println("Le philosophe "+i+" est arrivé");
		while(true){
			Monitor.prendre_une_fourchette(i);
			Monitor.poser_fourchette(i);
 
		}
	}
}