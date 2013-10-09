
public class Lapin extends Neuneus {

	Lapin(String n,int e,Case c){
		super(n,e,c);
		init_nou();
	}
	Lapin( String n,int e){
		super(n,e);
	}
	
	public void init_nou(){
		this.liste_nou.add("alcool");
		this.liste_nou.add("carottes");
		this.liste_nou.add("eau");
	}
	@Override
	void se_deplacer() {
		// TODO Auto-generated method stub
				
        Case c = this.pos._neuneu(this);
        int X = 0;
        int Y = 0;
        
        if(c!=null){
           X = c.abs-this.pos.abs;
           Y = c.ord-this.pos.ord;
        }
        
        Case randomDir = this.deplacement(c, X,Y);
        if (randomDir == null) {
            randomDir = this.pos;
        }
        this.pos.habitant.remove(this);
        randomDir.habitant.add(this);
        this.pos = randomDir;
        this.energie-=10;
        
        //se reproduit ou mange
        if(this.energie >= 50 && this.pos.habitant.size()>1){
            pos.loft.ajouter_neuneu(this.reproduction(this.pos.autre_neuneu(this)));
        }else if(randomDir.hasAliment(this)){
            this.manger();
        }
		
		
	}
	
}
