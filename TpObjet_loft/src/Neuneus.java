import java.util.ArrayList;
import java.util.Random;

public abstract class Neuneus {
	
	public final int min_en_prod= 20;
	int energie;
	Case pos;
	String nom;
	Loft loft;
	
	//liste de nourriture favoris
	ArrayList <String>liste_nou=new ArrayList <String>();
	
public void affiche(){
		
		System.out.println(this.nom+" en position: "+this.pos.abs+" "+this.pos.ord);
		
	}
	abstract void se_deplacer();
	
	public void manger(){
			int i=0;
			//while (i<this.pos.stock.size()){
				if (this.liste_nou.indexOf(this.pos.stock.get(i))!=0){
					energie+=this.pos.stock.get(i).val_energitique;
					this.pos.stock.remove(i);
			}	
					else i++;
			//}
		
	}
	
	public Neuneus reproduction(Neuneus n){
		this.energie-=40;
		n.energie-=40;
		Neuneus neu=new Erratique("Erratique",0,this.pos);
		return neu;
	}
	
	
	//constructeurs pour les neuneus qui seront placés aléatoirement
	public Neuneus(String n, int e){
		this.nom=n;
		this.energie=e;
		
	}
	
	//constructeur pour les neuneus dont on peut choisir les places
	public Neuneus(String n, int e, Case c){
		this.nom=n;
		this.pos=c;
		this.energie=e;
		
	}
	
	ArrayList<String> get_liste_nou(){
		return liste_nou;
	}
	
	public String toString(){
		String ch;
		ch= " ("+this.nom+","+this.energie+") ";
		return ch;
	}
	
	
	
	public Case deplacement(Case c, int x, int y){
		
			Case _c=null;
			//on prend  toutes les directions acceccibles
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
	        
	        Random rd =new Random ();
	        if (directions.size()!=0){
	        	int alea=rd.nextInt(directions.size());
	        	_c=directions.get(alea);
	        }
	        return _c;
	    }
		 
	
}
