package drawings;
import java.util.*; 

public class ListeObjet extends Objet2D{
	
	
	private ArrayList<Objet2D> DessinArray; 
	
	public ListeObjet() {
		
		 DessinArray = new ArrayList<Objet2D>();
		
	}
	
	public void ajouterObjet(Objet2D e) {
		
		DessinArray.add(e);
	
	}
	
	public int taille() {
		
		return DessinArray.size(); 
		
	}
	
	public Objet2D get(int i) {
		
		return DessinArray.get(i); 
		
	}
	
	
	public void enleverObjet(Objet2D e) {
		
		DessinArray.remove(e); 
		
	}

	public ArrayList<Objet2D> getLd() {
		return DessinArray;
	}

	public void setLd(ArrayList<Objet2D> ld) {
		this.DessinArray = ld;
	}
	
	
	@Override
	public String toString() {
		return "MultiObjet";
	}

	public void afficherListe() {
		
		System.out.println("liste objet");
		
	for(int i=0;i<DessinArray.size();i++) {
		
		
		System.out.println(DessinArray.get(i).toString()); 
	}
	}

}
