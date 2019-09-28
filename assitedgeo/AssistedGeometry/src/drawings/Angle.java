package drawings;

public class Angle {
	
	private double angl;

	
	public Angle(double angl) {
		

			if(angl >= 0 && angl <= 360) {
				this.angl = angl;
			}else{
			System.out.print("Angle :"+angl+" not valid. Please select an angle between 0n360°");}
	}

	public double getAngl() {
		return angl;
	}

	public void setAngl(double angl) {
		this.angl = angl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angl);
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
		Angle other = (Angle) obj;
		if (Double.doubleToLongBits(angl) != Double.doubleToLongBits(other.angl))
			return false;
		return true;
	}
	
	
	
	

}
