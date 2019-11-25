package diner_phil;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

	 
	public class Monitor{
	static int nombreDePhilosophes = 5;
	 static int[] etats = new int[nombreDePhilosophes];
	static Lock lock = new ReentrantLock();
	static Condition[] eat = new Condition[Monitor.nombreDePhilosophes];
	 
		public Monitor(){
			for(int j =0;j<nombreDePhilosophes;j++){
				eat[j] = lock.newCondition();
			}
		}
	
			static void prendre_une_fourchette(int i) {
				try {
					lock.lock();
					etats[i]=2;//wants to eat
					if(etats[(i-1+nombreDePhilosophes)%nombreDePhilosophes] !=1 && etats[(i+1+nombreDePhilosophes)%nombreDePhilosophes] !=1){
						//si les 2 voisins ne mangent pas, je mange
						System.out.println("Philo "+ i+" a ses 2 fourchettes.");
						etats[i]=1;
					}else{
						try {
							eat[i].await();
							System.out.println("Philo "+ i+" a ses 2 fourchettes.");
							etats[i]=1;//mange	
						} catch (InterruptedException e) {
						}
					}
					}finally{
					lock.unlock();
				}
				manger(i);
			}
	 
	 
			static void poser_fourchette(int i) {
				lock.lock();
				try{
					etats[i]=0;//ne mange plus	
				if(etats[(i-2+nombreDePhilosophes)%nombreDePhilosophes] !=1 && etats[(i-1+nombreDePhilosophes)%nombreDePhilosophes]==2){
					for(int j =0;j<nombreDePhilosophes;j++){
						System.out.println("Etat Philo "+j+" "+etats[j]);
					}
					System.out.println("Philo "+ i +" signale à Philo "+(i-1+nombreDePhilosophes)%nombreDePhilosophes +" que sa fourchette de droite est libre.");
					eat[(i-1+nombreDePhilosophes)%nombreDePhilosophes].signal();
				}
				if(etats[(i+2+nombreDePhilosophes)%nombreDePhilosophes] !=1 && etats[(i+1+nombreDePhilosophes)%nombreDePhilosophes]==2 ){
					for(int j =0;j<nombreDePhilosophes;j++){
						System.out.println("Etat Philo "+j+" "+etats[j]);
					}
					System.out.println("Philo "+ i +" signale à Philo "+(i+1+nombreDePhilosophes)%nombreDePhilosophes +" que sa fourchette de gauche est libre.");
					eat[(i+1+nombreDePhilosophes)%nombreDePhilosophes].signal();
				}
				}finally{
					lock.unlock();
				}
				pense(i);
	 
			}
	 
			static void pense(int i) {
				System.out.println("Philosophe "+i+" est en train de penser.");
				long wait=(long)(Math.random()*1000);
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
				}
			}
	 
			static void manger(int i) {
				System.out.println("Philosophe "+i+" est en train de manger ");
				long wait=(long)(Math.random()*1000);
				Monitor.etats[i]=1;
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
				}
			}
			public static void main(String[] args) {
				new Monitor();
				for (int i = 0; i < nombreDePhilosophes; i++) {
					etats[i]=0;//everyone starts thinking
					new Thread(new Philo(i)).start();
				}

			}

	}

