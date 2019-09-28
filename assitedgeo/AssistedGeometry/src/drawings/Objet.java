package drawings;

public abstract class Objet extends Objet2D{

	private Point2D X;
	private Angle	AnglX;
	private String nom;
	
	Objet(Angle b){


		this.AnglX = b;
		
		Point2D p = new Point2D(Math.cos(Math.toRadians(b.getAngl())),Math.sin(Math.toRadians(b.getAngl())));
		this.X = p;
		
	}
	
	Objet(Point2D a){
		
		this.X = a;
	}
	
	Objet(Point2D a, double r){
		
		this.setCordABS(a);
		this.setRayon(r);
	}
	
	public Objet(double x2, double y) {
		
		Point2D p = new Point2D(x2,y);
		
		this.X = p;
		this.AnglX = null;
	}

	void Objet2D(){
		
		this.AnglX = null;
		this.X = null;
	}


	public Point2D getX() {
		return X;
	}

	public void setX(Point2D x) {
		X = x;
	}

	public Angle getAnglX() {
		return AnglX;
	}

	public void setAnglX(Angle anglX) {
		AnglX = anglX;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AnglX == null) ? 0 : AnglX.hashCode());
		result = prime * result + ((X == null) ? 0 : X.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objet other = (Objet) obj;
		if (AnglX == null) {
			if (other.AnglX != null)
				return false;
		} else if (!AnglX.equals(other.AnglX))
			return false;
		if (X == null) {
			if (other.X != null)
				return false;
		} else if (!X.equals(other.X))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Objet [X=" + X + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	
}
