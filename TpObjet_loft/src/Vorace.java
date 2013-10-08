
public class Vorace extends Neuneus{

	Vorace(String n,int x, int y,Loft l) {
		super(n, x, y, l);
	}
	
	public void se_deplacer(){
		//récupérer la position 
		Case c= loft.cases[x][y];		
		loft.placer_neuneu(this);
		manger();
	}
	
	public void manger(){
		
	
	}
}
