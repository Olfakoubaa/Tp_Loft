import java.util.ArrayList;

public abstract class Neuneus {
	
	int energie;
	Case pos;
	String nom;
	Loft loft;
	//liste de nourriture favoris
	ArrayList <String>liste_nou=new ArrayList <String>();
	//population
	int population=0;
	
	abstract void se_deplacer();
	abstract void manger();
	abstract Neuneus reproduction(Neuneus n);
		
	Neuneus(){
	}
	public Neuneus(String n, int e, Case c){
		this.nom=n;
		this.pos=c;
		this.energie=e;
		this.population+=1;
		System.out.println("taille population:"+population);
	}
	
	ArrayList<String> get_liste_nou(){
		return liste_nou;
	}
	
	public String toString(){
		String ch;
		ch= " ("+nom+","+energie+") ";
		return ch;
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
	void setNourriture() {
		// TODO Auto-generated method stub
		
	}
	 
	
}
