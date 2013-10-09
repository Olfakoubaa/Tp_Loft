import java.util.ArrayList;
import java.util.Random;


public class Loft {
	
		//h et w : nombres de cases à la verticale et l'horisontale
		int h,w;
		
		//le loft est un ensemble de cases
		ArrayList <Case> cases= new ArrayList <Case>();
		
		//contient une population
		Population p=new Population ();
		ArrayList <Neuneus> lofteurs=new ArrayList <Neuneus>();
		
		//contient des nutriments 
		ArrayList<Nourriture> nourriture =new ArrayList <Nourriture> ();
		
		//création du loft
		public Loft(int h,int w){
			this.h=h;
			this.w=w;
			
			for(int i=0;i<w;i++){
				for (int j=0;j<h;j++){
					Case c= new Case(i,j,this);
					this.cases.add (c);
				}
			}
			init_loft_nourriture();
			init_loft_neuneu();	
		}
		
			
		/*initialisation du loft*/
		
		public void init_loft_neuneu(){
			
			//placer des neuneus dans le loft 
			Random rd=new Random ();
			
			//nombre de neuneu à ajouter 
			int nb=rd.nextInt(h*w/2)+1;
					        
		    
		    for (int i=0;i<nb;i++){
		    	//choisir aléatoirement le type de neuneu
				int ind= rd.nextInt(4); 
		    	//choisir aléatoirement une case
		    	Case rdc=cases.get(rd.nextInt(cases.size()));  
		    	
		    	Neuneus n=null;
		            if(ind == 1){
		                n = new Erratique("Erratique", 20, rdc);
		            }else if(ind== 2){
		                n = new Vorace("Vorace", 10, rdc);
		            }else if(ind== 3){
		                n = new Cannibales("Cannibale", 30, rdc);
		            }else if(ind== 4){
		                n = new Lapin("Lapin", 15, rdc);
		            }
		            rdc.AjoutHabitant(n);
		            lofteurs.add(n);
		            n.affiche();
		    }
		}

		//ajouter un neuneu dans une case
		public void ajout_neuneu(Neuneus n){
			this.lofteurs.add(n);
			n.pos.habitant.add(n);
		}
		
		//placer la nourriture d'une façon aléatoire 
		int X,Y;
		
		public void init_loft_nourriture(){
			
			Nourriture n;
			n=new Nourriture(5,"alcool");
			nourriture.add(n);
			n= new Nourriture(15,"neuneu");
			nourriture.add(n);
			n= new Nourriture(2,"eau");
			nourriture.add(n);
			n= new Nourriture(9,"poisson");
			nourriture.add(n);
			Random rd = new Random();
			int nb=rd.nextInt(h*w);
			for (int i=0;i<nb;i++)
			{
				X=rd.nextInt(h*w);
				Y=rd.nextInt(nourriture.size());	
				cases.get(X).stock.add(nourriture.get(Y));
				
			}
		}
		
		 public void affiche(){
		        System.out.println("Nouveau tour! \n taille de population:"+p.toString() );
		        
		        for (int i=0; i<cases.size(); i++)
		            System.out.println(cases.get(i).toString());
		        
		    }
}
