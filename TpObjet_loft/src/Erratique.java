import java.util.ArrayList;

public class Erratique extends Neuneus{

	
	public Erratique(String n, int e, Case c){
		super();
		init_nou();
	}
	
	public void init_nou(){
		this.liste_nou.add("Alcool");
		this.liste_nou.add("Poisson");
		
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
