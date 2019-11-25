package exo4;

public class essai {
	 int cpt=0;
	 static int ident;
public essai(){
	ident++;
	cpt+=ident;
}
	public  int getide(){
		return cpt;
	}
	public static int getmax(){
		return ident;
	}
	
	public static void main(String [] args){
		essai s1=new essai();
		essai s2=new essai();
		System.out.println(s1.getmax());
		essai s3=new essai();
		System.out.println(s1.getmax());
		System.out.println(s3.getide());
		
	}
}
