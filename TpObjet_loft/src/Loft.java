import java.util.ArrayList;
import java.util.Random;


public class Loft {
	
		//h et w : nombres de cases à la verticale et l'horisontale
		int h,w;
		//le loft est un ensemble de cases
		ArrayList <Case> cases= new ArrayList <Case>();
		// contient un stock de nourriture
		ArrayList <Nourriture>stock= new ArrayList<Nourriture>();
		//contient une population
		Population P;
		ArrayList <Neuneus> neuneus =new ArrayList <Neuneus>();
				
		//création du loft
		public Loft(int h,int w){
			this.h=h;
			this.w=w;
			P=new Population(0);
			for(int i=0;i<w;i++){
				for (int j=0;j<h;j++){
					Case c= new Case(i,j,this);
					this.cases.add (c);
				}
			}
		}
		
		//ajuter un neuneu au loft
		public void ajout_neuneu(Neuneus n){
			this.neuneus.add(n);
		}
		
		
		public ArrayList <Case> get_cases(){
			return cases;
		}
		
		/*initialisation du loft*/
		public void init_loft_neuneu(ArrayList neuneus){
			//placer tout les neuneus crées dans le loft dans leurs positions
			for (int i=0;i<neuneus.size();i++){
				Neuneus n= (Neuneus)neuneus.get(i);
				
			}	
		}
		

		//placer la nourriture d'une façon aléatoire 
		int X,Y,K;
		
		public void init_loft_nourriture(){
			Random rd = new Random();
			for (int i=0;i<10;i++)
			{
				X=rd.nextInt(h);
				Y=rd.nextInt(w);
				K=rd.nextInt(stock.size());
				//cases[X][Y].contenu.add(stock.get(K).nom);
			}
		}

}
