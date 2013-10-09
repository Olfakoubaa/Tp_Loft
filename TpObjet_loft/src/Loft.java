import java.util.ArrayList;
import java.util.Random;

public class Loft {
	
		//h et w : nombres de cases à la verticale et l'horisontale
		public int h,w;
		
		//le loft est un ensemble contenant h*w cases
		ArrayList <Case> cases= new ArrayList <Case>();
		
		//contient une population
		int p=0;
		
		//liste des habitants du loft
		ArrayList <Neuneus> lofteurs=new ArrayList <Neuneus>();
		
		//contient des nutriments pour les neuneu
		ArrayList<Nourriture> nourriture =new ArrayList <Nourriture> ();
		
		//création du loft
		public Loft(int h,int w){
			this.h=h;
			this.w=w;
			//instantiation des cases
			for(int i=0;i<w;i++){
				for (int j=0;j<h;j++){
					Case c= new Case(i,j,this);
					this.cases.add (c);
				}
			}
			//ajout de la nourriture
			init_loft_nourriture();
			//ajout des neuneus
			init_loft_neuneu();	
		}
		
			
		//placer les neuneus dans le loft
		Random rd=new Random ();
		
		public void init_loft_neuneu(){
					
			//nombre de neuneus à ajouter 
			int nb=rd.nextInt((int) (h*w) /2)+2;
				        
		    for (int i=0;i<nb;i++){
		    	//choisir aléatoirement le type de neuneu
				int ind= rd.nextInt(4)+1; 
				
		    	//choisir aléatoirement une case
		    	Case _c=cases.get(rd.nextInt(cases.size()));  
		    	//pour ne pas tomber tous sur une meme case
		    	while(_c.habitant.size()>1){
		    		 _c=cases.get(rd.nextInt(cases.size())); 
		    	}
		    	Neuneus n=null;
		    	 p++;
		            if(ind == 1){
		                n = new Erratique("Erratique_"+p, 20, _c);
		            }
		            else if(ind== 2){
		                n = new Vorace("Vorace_"+p, 10, _c);
		            }
		            else if(ind== 3){
		                n = new Cannibales("Cannibale_"+p, 30, _c);
		            }
		            else if(ind== 4){
		                n = new Lapin("Lapin_"+p, 15, _c);
		            }
		            
		            _c.AjoutHabitant(n);
		            lofteurs.add(n);
		           
		            }
		}

		//ajouter un neuneu dans une case
		public void ajout_neuneu(Neuneus n){
			this.lofteurs.add(n);
			n.pos.habitant.add(n);
			p++;
		}
		
		//supprimer les neuneu
		public void ExclureHabitant(){
			for (int i=0;i<cases.size();i++){
				Case c=cases.get(i);
					for (int j=0;j<c.habitant.size();j++)
						if (c.habitant.get(j).energie<50){
							c.habitant.remove(j);
							p--;
						}
			}
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
		
		public void tour_de_jeu(){
	        
	        for (int i=0;i<lofteurs.size();i++) {
	            lofteurs.get(i).se_deplacer();
	        }
	        affiche();
	        
	        ExclureHabitant();
	        init_loft_nourriture();
	       
	    }
		
		 public void affiche(){
		        System.out.println("Nouveau tour! \n taille de population : "+p );
		        for (int i=0; i<cases.size(); i++){
		            System.out.println(cases.get(i).toString());
		        	}
		        
		    }
}
