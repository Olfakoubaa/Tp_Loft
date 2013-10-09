import java.util.ArrayList;
import java.util.Random;


public class Erratique extends Neuneus{

	
	public Erratique(String n, int e, Case c){
		super(n,e,c);
		init_nou();
	}
	
	//liste de nourriture préféré par le neuneu
	public void init_nou(){
		this.liste_nou.add("Alcool");
		this.liste_nou.add("Poisson");
		this.liste_nou.add("Normal");
	}
	
	@Override


	void se_deplacer() {
		// TODO Auto-generated method stub

		//voir toutes les direction accessibles
        ArrayList<Case> directions = new ArrayList<Case>();
        if (this.pos.case_gauche() != null){
            directions.add(this.pos.case_gauche());
        }
        if (this.pos.case_haut()!= null){
            directions.add(this.pos.case_haut());
        }
        if (this.pos.case_droite()!= null){
            directions.add(this.pos.case_droite());
        }
        if (this.pos.case_bas()!= null){
            directions.add(this.pos.case_bas());
        }
        //choix d'une case aléatoireparmis les directions qu'on a trouvé
        Random rd=new Random();
        Case c = directions.get(rd.nextInt(directions.size()));
       
        //supprimer le neuneu de la case actuelle
        this.pos.habitant.remove(this);
        //modifier sa position
        this.pos = c;
        //deplacer le neuneu
        c.habitant.add(this); 
        System.out.println(this.nom+" s'est déplacé");
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
