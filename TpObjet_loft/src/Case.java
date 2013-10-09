import java.util.ArrayList;
import java.util.HashMap;


public class Case {
	int abs;
	int ord;
	Loft loft;
	ArrayList <Nourriture> stock=new ArrayList<Nourriture>();	
	ArrayList <Neuneus> habitant=new ArrayList<Neuneus>();
	
	
	Case (int a,int o, Loft l){
		this.abs=a;
		this.ord=o;
		this.loft=l;
	}
   
    public String toString(){
        String ch=null;
        ch="la case "+abs+" "+ord+",";
        
        if (stock.size()==0 && habitant.size()==0)
        	ch+=" vide ";
        
        else{
        	ch+=" contient :"; 
        	if (stock.size()!=0 )
        	for(int i=0;i<stock.size();i++){
        		ch+=stock.get(i).toString();
        	}
        	if(habitant.size()!=0)
        	for(int j=0;j<habitant.size();j++){
        		ch+=habitant.get(j).toString();       
        	}
        }
        return ch;
    }
    
    
    //chercher la case a gauche de la case courante
	public Case case_gauche(){
		
		Case c=null;
		ArrayList <Case> cases=loft.cases;	
			int i=0;
			boolean t=false;
			while (i< cases.size() && !t){
				if (this.ord==cases.get(i).ord&& this.abs-1==cases.get(i).abs)
					{
					c=cases.get(i);
					t=true;
					}
				i++;
			}
		return c;
	}
	
	
	public Case case_droite(){
		Case c=null;
		
		ArrayList <Case> cases=loft.cases;	
			int i=0;
			boolean t=false;
			while (i< cases.size() && !t){
				if (this.ord==cases.get(i).ord&& this.abs+1==cases.get(i).abs)
					{
					c=cases.get(i);
					t=true;
					}
				i++;
			}
		return c;
	}
	
	public Case case_bas(){
		Case c=null;
		
		ArrayList <Case> cases=loft.cases;	
			int i=0;
			boolean t=false;
			while (i< cases.size() && !t){
				if (this.ord+1==cases.get(i).ord && this.abs==cases.get(i).abs)
					{
					c=cases.get(i);
					t=true;
					}
				i++;
			}
		return c;
	}
	
	public Case case_haut(){
		Case c=null;
		
		ArrayList <Case> cases=loft.cases;	
			int i=0;
			boolean t=false;
			while (i< cases.size() && !t){
				if (this.ord-1==cases.get(i).ord&& this.abs==cases.get(i).abs)
					{
					c=cases.get(i);
					t=true;
					}
				i++;
			}
		return c;
	}
	
	//ajouter un neuneu dans une case
	public void AjoutHabitant(Neuneus n){
		this.habitant.add(n);
	}
	
	
	
	//tester si les aliments stocks dans une case sont mangeables pas le neuneu 
	public boolean test_aliment(Neuneus n){
		
		boolean test=false;
		int j=0;
		while (j<stock.size()&&!test){
			if(n.liste_nou.indexOf(stock.get(j).nom)!=0){
				test=true;
			}
			else j++;
		}
		return test;
	}
	
	//donner l'autre neuneu si il existe dans la case
	 public Neuneus autre_neuneu (Neuneus n){
	        Neuneus n2 = null;
	        int i=0;
	        while (i<habitant.size()&& n2==null){
	            if(! habitant.get(i).equals(n)){
	               n2=habitant.get(i);
	            }
	            i++;
	        }
	        return n2;
	    }
	

	 public Case _nourriture(Neuneus neuneu){
	       
	        ArrayList <Case> position=new ArrayList<Case>();
	        ArrayList <Integer> distance=new ArrayList<Integer>();
		 	
	        //calculer les distances a toutes les case qui contiennet la nourriture du neuneu en cour
	        for (int i=0;i<this.loft.cases.size();i++){
	        	Case c=this.loft.cases.get(i);
	        		if(c.test_aliment(neuneu)){
	        			position.add(c);
	        			distance.add(Math.abs(c.abs - this.abs) + Math.abs(c.ord - this.ord));
	            }
	        }
	        Case decision = null;
	        int min =999;
	        //recherche min 
	        for (int i=0;i<position.size();i++){
	        	int d= distance.get(i);
	        	if(d<min){
	        		min=d;
	        		decision= position.get(i);
	        	}
	        }
	        return decision ;
	    }
	 
	 
	//donner la case la plus proche qui contient un neuneu
	 
	 public Case _neuneu(Neuneus neuneu){
	    
	        ArrayList <Case> position=new ArrayList<Case>();
	        ArrayList <Integer> distance=new ArrayList<Integer>();
	        
		 	//calculer les distances a toutes les case qui contiennet un neuneu de type different
	        for (int i=0;i<this.loft.cases.size();i++){
	        	Case c=this.loft.cases.get(i);
	        		//si la case contient un autre neuneu 
	        		if(autre_neuneu(neuneu)!= null){
	        			position.add(c);
	        			distance.add(Math.abs(c.abs - this.abs) + Math.abs(c.ord - this.ord));
	            }
	        }
	        Case decision = null;
	        int min =999;
	        //recherche min 
	        for (int i=0;i<position.size();i++){
	        	int d= distance.get(i);
	        	if(d<min){
	        		min=d;
	        		decision= position.get(i);
	        	}
	        }
	        return decision ;
	    }
}





