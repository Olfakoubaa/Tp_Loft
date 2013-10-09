
public class Population {

	public int taille;
	
	Population(){
		this.taille=0;
	}
	
	public void augmenter(){
		this .taille +=1;
	}
	
	public void diminuer(){
		
		this.taille-=1;
	}
	
	public String toString(){
		String ch=""+this.taille;
		return ch;
	}
	
}
