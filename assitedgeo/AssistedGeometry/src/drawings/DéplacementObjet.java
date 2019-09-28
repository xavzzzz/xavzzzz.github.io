package drawings;

public class DéplacementObjet {

		public void DeplaceABS(Objet2D o,Vecteur2D v){
			
			Point2D res = new Point2D();
			
			res.setX(o.getCordABS().getX()+v.getX());
			res.setX(o.getCordABS().getX()+v.getX());
			o.setCordABS(res);
		}
		
		public void DeplaceP(Point2D o,Vecteur2D v){
			
			Point2D res = new Point2D();
			
			res.setX(o.getX()+v.getX());
			res.setX(o.getY()+v.getY());
			
		}
}
