package drawings;

import javafx.scene.shape.ArcType;

public class Arc2D extends Cercle2D{

	private ArcType at;
	private double angle;
	
	public Arc2D(Point2D a, double r,double s, ArcType at) {
		super(a, r);
		this.angle = s;
		this.at = at;
		
	}

	public ArcType getAt() {
		return at;
	}

	public void setAt(ArcType at) {
		this.at = at;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "Arc2D"+this.getNom();
	}
	
	

}
