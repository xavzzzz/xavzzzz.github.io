package drawings;

public class Cercle2D extends Objet{

	public Cercle2D(Point2D a, double r){
		super(a,r);
	}

	@Override
	public String toString() {
		return "Cercle2D"+this.getNom();
	}
	
	
	
}
