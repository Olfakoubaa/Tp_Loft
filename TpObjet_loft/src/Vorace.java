
public class Vorace extends Neuneus{

	public Vorace(String n, int e, Case c){
		super();
		init_nou();
	}
	
	public void init_nou(){
		this.liste_nou.add("Alcool");
		this.liste_nou.add("Poisson");
		this.liste_nou.add("Normal");
	}
	
	@Override
	void se_deplacer() {
		// TODO Auto-generated method stub
		 
		//choix de la position
		
		 //supprimer le neuneu de la case actuelle
        this.pos.habitant.remove(this);
        //modifier sa position
        this.pos = c;
        //deplacer le neuneu
        c.habitant.add(this);
        //se reproduire ou manger
        
        //si'il ya un neuneu de meme type=> reproduction
        int k=this.pos.habitant.size();
        if((this.energie >= min_en_prod)&&(k>1))   {	
        	Neuneus n= reproduction(this.pos.autre_neuneu(this));
            pos.loft.ajout_neuneu(n);
        }
        
        //si la case contient les aliments préférés par el neuenu
        else if(c.test_aliment(this)){
            this.manger();
        }  
	}

	@Override
	void manger() {
		// TODO Auto-generated method stub
		int i=0;
		//while (i<this.pos.stock.size()){
			if (this.liste_nou.indexOf(this.pos.stock.get(i))!=0){
				energie+=this.pos.stock.get(i).val_energitique;
				this.pos.stock.remove(i);
		}	
				else i++;
		//}
	}

	@Override
	Neuneus reproduction(Neuneus n) {
		// TODO Auto-generated method stub
		this.energie-=40;
		n.energie-=40;
		Neuneus neu=new Vorace("Vorace",0,this.pos);
		return neu;
	}

	
}
