
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
		
	}

	@Override
	void manger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	Neuneus reproduction(Neuneus n) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
