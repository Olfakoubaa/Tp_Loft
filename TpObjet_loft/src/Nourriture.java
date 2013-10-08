
public class Nourriture {

	int val_energitique;
	String nom;
	
	public Nourriture(int val_energitique, String nom){
		this.val_energitique=val_energitique;
		this.nom=nom;
	}
	
	public String toString(){
		String ch;
		ch = " ("+nom+","+val_energitique+") ";
		return ch;
	}
}
