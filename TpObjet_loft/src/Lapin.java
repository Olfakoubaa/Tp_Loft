
public class Lapin extends Neuneus {

	Lapin(String n,int e,Case c){
		super(n,e,c);
		init_nou();
	}
	
	//liste de nourriture préféré par les lapins
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
        System.out.println(this.nom+" s'est déplacé");
        randomDir.habitant.add(this);
        this.pos = randomDir;
      //se reproduit ou mange
        if(this.energie >= min_en_prod && this.pos.habitant.size()>1){
        	
        	Neuneus n= reproduction(this.pos.autre_neuneu(this));
        	System.out.println("reproduction des neuneu");
            pos.loft.ajout_neuneu(n);
            
        }else if(c.test_aliment(this)){
            this.manger();
        }
	}
}
