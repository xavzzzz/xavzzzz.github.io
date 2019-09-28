package drawings;

public class Quadrangle2D extends Carré2D{

	public void RandAngle(){
		
	    double x = (Math.random()*((0-360)+1));
	    
	    Angle res = new Angle(x);	
	    Point2D r = new Point2D(Math.cos(Math.toRadians(res.getAngl())),Math.cos(Math.toRadians(res.getAngl())));
	    this.setAnglA(res);	
	    this.setA(r);
	}
	
	public Quadrangle2D(Angle a, Angle b, Angle c, Angle d) {
		super(a, b, c, d);
		RandAngle();
	}

	public Quadrangle2D(Point2D un, Point2D deux, Point2D trois, Point2D quatre) {
		super(un, deux, trois, quatre);
	}

	
	

	
}
