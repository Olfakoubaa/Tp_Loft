
public class Vorace extends Neuneus{

	public Vorace(String n, int e, Case c){
		super(n,e,c);
		init_nou();
	}
	public Vorace (String n, int e){
		super(n,e);
	}
	
	public void init_nou(){
		this.liste_nou.add("Alcool");
		this.liste_nou.add("Poisson");
		this.liste_nou.add("Normal");
	}
	
	@Override
	void se_deplacer() {
		// TODO Auto-generated method stub
		 		
        Case c = this.pos._nourriture(this);
        
        int X = 0;
        int Y = 0;
        if(c!=null){
            X = c.abs-this.pos.abs;
            Y = c.ord-this.pos.ord;
        }
        //le vorace reste sur place si il reste de la nourriture
        if(this.pos!=c){
            Case randomDir = this.deplacement(c, X, Y);
            if (randomDir == null) {
                randomDir = this.pos;
            }
            this.pos.habitant.remove(this);
            randomDir.habitant.add(this);
            this.pos = randomDir;
            
        }
        
        //reproduction
        if((this.energie >= min_en_prod)&&(this.pos.habitant.size()>1))   {	
        	Neuneus n= reproduction(this.pos.autre_neuneu(this));
            pos.loft.ajout_neuneu(n);
        }
        //si la case contient les aliments pr�f�r�s par el neuenu
        else if(c.test_aliment(this)){
            this.manger();
        }  
	}
	
}
