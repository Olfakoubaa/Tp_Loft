import java.util.ArrayList;

public abstract class Neuneus {
	
	int energie;
	Case pos;
	String nom;
	Loft loft;
	//liste de nourriture favoris
	ArrayList <String>liste_nou=new ArrayList <String>();
	
	abstract void se_deplacer();
	abstract void manger();
	abstract Neuneus reproduction(Neuneus n);
		
	Neuneus(){
	}
	
	ArrayList<String> get_liste_nou(){
		return liste_nou;
	}
	
	public Case deplacement(Case c, int x, int y){
		 ArrayList<Case> directions = new ArrayList<Case>();
	      
	        if ((this.pos.case_gauche() != null && x<0) ||
	                (c==null && this.pos.case_gauche() != null)){
	            directions.add(this.pos.case_gauche());
	        }
	        if ((this.pos.case_haut()!= null && y<0) || 
	                (c==null && this.pos.case_haut() != null)){
	            directions.add(this.pos.case_haut());
	        }
	        if ((this.pos.case_droite()!= null && x>0) || 
	                (c==null && this.pos.case_droite() != null)){
	            directions.add(this.pos.case_droite());
	        }
	        if ((this.pos.case_bas()!= null && y>0) || 
	                (c==null && this.pos.case_bas() != null)){
	            directions.add(this.pos.case_bas());
	        }
	        return (directions.size()==0? null : directions.get((int)(Math.random() * directions.size())));
	    }
	 
	
}
