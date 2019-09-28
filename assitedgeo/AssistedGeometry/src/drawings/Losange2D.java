package drawings;

public class Losange2D extends Carré2D{

	Losange2D(Angle b, Angle c, Angle d, Angle e) {
		
		super(b, c, d, e);
		
		Point2D xr = this.getX();
		Point2D yr = this.getY();
		xr.setX(xr.getX()-1);
		yr.setY(yr.getY()-1);
		
	}



}
