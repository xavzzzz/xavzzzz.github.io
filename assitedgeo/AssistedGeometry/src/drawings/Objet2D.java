package drawings;

public class Objet2D{
	
	@Override
	public String toString() {
		return "Objet2D [rayon=" + rayon + ", CordABS=" + CordABS + "]";
	}

	private double rayon;
	private Point2D CordABS;
	
	public Objet2D() {
		
		this.rayon = 100;
		this.CordABS = new Point2D(0,0);
	}
	
	public Objet2D(Point2D a, double r) {
		
		this.rayon = r;
		this.CordABS = a;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public Point2D getCordABS() {
		return CordABS;
	}

	public void setCordABS(Point2D cordABS) {
		CordABS = cordABS;
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CordABS == null) ? 0 : CordABS.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rayon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objet2D other = (Objet2D) obj;
		if (CordABS == null) {
			if (other.CordABS != null)
				return false;
		} else if (!CordABS.equals(other.CordABS))
			return false;
		if (Double.doubleToLongBits(rayon) != Double.doubleToLongBits(other.rayon))
			return false;
		return true;
	}
	

}


