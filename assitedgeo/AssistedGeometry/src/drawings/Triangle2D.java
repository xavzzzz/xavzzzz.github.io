package drawings;

public class Triangle2D extends Segment2D{

	Triangle2D(Angle b, Angle c, Angle d) {
		
		super(b, c);
		
		this.z.setX(Math.cos(Math.toRadians(d.getAngl())));
		this.z.setY(Math.sin(Math.toRadians(d.getAngl())));
		this.AnglZ = d;
	}

	public Triangle2D(Point2D aBS, Point2D aBS2, Point2D aBS3) {
		super(aBS,aBS2);
		this.z = aBS3;
	}



	@Override
	public String toString() {
		return "Triangle2D"+this.getNom();
	}

	private Point2D z;	
	private Angle AnglZ;


	public Point2D getZ() {
		return z;
	}

	public void setZ(Point2D z) {
		this.z = z;
	}

	public Angle getAnglZ() {
		return AnglZ;
	}

	public void setAnglZ(Angle anglZ) {
		AnglZ = anglZ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AnglZ == null) ? 0 : AnglZ.hashCode());
		result = prime * result + ((z == null) ? 0 : z.hashCode());
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
		Triangle2D other = (Triangle2D) obj;
		if (AnglZ == null) {
			if (other.AnglZ != null)
				return false;
		} else if (!AnglZ.equals(other.AnglZ))
			return false;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}

	public void setCordABS(double x, double y) {	
		this.getCordABS().setX(x);
		this.getCordABS().setY(y);
	}
	
	
	
}
