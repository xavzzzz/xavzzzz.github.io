package drawings;

public class Segment2D extends Objet{

	private Point2D y;	
	private Angle AnglY;


	public Segment2D(Angle b, Angle c) {
		super(b);
		
		this.setAnglX(b);
		Point2D p1 = new Point2D(Math.cos(Math.toRadians(b.getAngl())),Math.sin(Math.toRadians(b.getAngl())));
		this.setX(p1);
		
		
		this.AnglY = c;
		Point2D p2 = new Point2D(Math.cos(Math.toRadians(c.getAngl())),Math.sin(Math.toRadians(c.getAngl())));
		this.y = p2 ; 
		
		
	}
	
	public Segment2D(Angle a, Angle b, Point2D x) {
		super(a);
		
		this.setCordABS(x);
		this.AnglY = b;
		
		
	}
	
	
	Segment2D(Point2D a, Point2D c) {
		
		super(a);
		this.y = c; 
	}
	
	public Segment2D(double x, double y, double a, double b) {
		
		super(x,y);
		
		Point2D p = new Point2D(a,b);
		
		this.y = p;
		this.AnglY = null;
	}

	public Point2D getY() {
		return y;
	}


	public void setY(Point2D y) {
		this.y = y;
	}


	public Angle getAnglY() {
		return AnglY;
	}


	public void setAnglY(Angle anglY) {
		AnglY = anglY;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AnglY == null) ? 0 : AnglY.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		Segment2D other = (Segment2D) obj;
		if (AnglY == null) {
			if (other.AnglY != null)
				return false;
		} else if (!AnglY.equals(other.AnglY))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Segment2D"+this.getNom();
	}



	

	

}
