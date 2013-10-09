
public class Population {

	private int taille;
	
	Population(){
		this.taille=0;
	}
	
	public void augmenter(){
		this .taille +=1;
	}
	
	public void diminuer(){
		
		this.taille-=1;
	}
	
	int get_taille(){
		return taille;
	}
	
	public String toString(){
		String ch= " Taille de population ="+taille;
		return ch;
	}
}
