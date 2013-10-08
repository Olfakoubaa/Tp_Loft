import java.util.ArrayList;


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

	public ArrayList<Nourriture> getStock() {
        return this.stock;
    }
    public ArrayList<Neuneus> getHabitant() {
        return habitant;
    }  
    public Loft getLoft() {
        return loft;
    }
	
    
    public String toString(){
        String ch;
        ch="la case"+abs+" "+ord+",";
        if (stock.size()==-1 && habitant.size()==-1)
        	ch+=" vide ";
        else ch+="contient :";
       
        int i=0;
        while (i<stock.size()){
        	ch+=stock.get(i).toString();
        	i++;
        }
        int j=0;
        while (j<habitant.size()){
        	ch+=habitant.get(j).toString();
        	j++;
        }
        return ch;
    }
    
    
    //chercher la case a gauche de la case courante
	public Case case_gauche(){
		
		Case c=null;
		ArrayList <Case> cases=loft.get_cases();	
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
		
		ArrayList <Case> cases=loft.get_cases();	
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
		
		ArrayList <Case> cases=loft.get_cases();	
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
		
		ArrayList <Case> cases=loft.get_cases();	
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
			if(n.get_liste_nou().indexOf(stock.get(j).nom)!=0){
				test=true;
			}
			else j++;
		}
		return test;
	}
	
	//donner la case la plus proche contient la nourriture du neuneu en cours _pour les 
	
	public Case proche(Neuneus n){
		Case c=null;
		return c;
	}
	
	//donner le si la case contien un neuneu de mme type

	
	//donner la case la plus proche qui contient un neuneu
}
