package drawings;

public class Carré2D extends Triangle2D{
	
	private Point2D a;
	private Angle AnglA;
	
	Carré2D(Angle b, Angle c, Angle d, Angle e) {
		super(b, c, d);
		
		this.a.setX(Math.cos(Math.toRadians(e.getAngl())));
		this.a.setY(Math.sin(Math.toRadians(e.getAngl())));
		this.AnglA = e;
	}
	
	public Carré2D(Point2D b, Point2D c, Point2D d, Point2D e) {
		super(b, c, d);
		this.a = e;
	}

	@Override
	public String toString() {
		return "Carré2D"+this.getNom();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AnglA == null) ? 0 : AnglA.hashCode());
		result = prime * result + ((a == null) ? 0 : a.hashCode());
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
		Carré2D other = (Carré2D) obj;
		if (AnglA == null) {
			if (other.AnglA != null)
				return false;
		} else if (!AnglA.equals(other.AnglA))
			return false;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		return true;
	}
	
	public Point2D getA() {
		return a;
	}
	public void setA(Point2D a) {
		this.a = a;
	}
	public Angle getAnglA() {
		return AnglA;
	}
	public void setAnglA(Angle anglA) {
		AnglA = anglA;
	}
	
	
	
}
