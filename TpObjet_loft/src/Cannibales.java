
public class Cannibales extends Neuneus{

	
	Cannibales ( String n,int e, Case c){
		super(n,e,c);
	}
	Cannibales ( String n,int e){
		super(n,e);
	}
	
	public void init_nou(){
		this.liste_nou.add("Alcool");
		this.liste_nou.add("Poisson");
		this.liste_nou.add("Neuneu");
	}
	
	
	@Override
	void se_deplacer() {
		
		// TODO Auto-generated method stub
		
	    Case c = this.pos._neuneu(this);
	    	if (c==null){
	            c = this.pos._nourriture(this);
	        }
	    //si on a trouvé une case a laquelle le neuneu peut se deplacer , on change ses positions
	        int X=0;
	        int Y=0; 
	        
	        if(c!=null){
	           X = c.abs-this.pos.abs;
	           Y = c.ord-this.pos.ord;
	        }
	        
	        if(this.pos!=c){
	            //deplacement vers la case adjacente
	            Case randomDir = this.deplacement(c, X, Y);
	            if(randomDir==null){
	                randomDir=this.pos;
	            }
	            //*//supprimer le neuneu de la case actuelle
	            this.pos.habitant.remove(this);
	            //modifier sa position
	            this.pos = randomDir;
	            //deplacer le neuneu
	            randomDir.habitant.add(this);
	        }
	        
	        //le neuneu se reproduit si son energie le permet et il trouve un partenaire sur la case 
	        if(this.energie >=min_en_prod && this.pos.habitant.size()>1){
	            pos.loft.ajout_neuneu(this.reproduction(this.pos.autre_neuneu(this)));
	        }
	        //si non il mange ce qui se trouve
	        else{
	            		if(this.pos.autre_neuneu(this)!=null || this.pos.test_aliment(this)){
	            			this.manger();
	            		}
	        	}
	    }
	
}
