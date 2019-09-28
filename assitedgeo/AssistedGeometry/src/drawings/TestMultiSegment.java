package drawings;

public class TestMultiSegment {
	
	public static void main (String [] args)
	
	{
		
		
		Angle a = new Angle(200);
		Angle b = new Angle(300);
		
		Angle c = new Angle(200);
		Angle d = new Angle(177);
	 
		
		Segment2D s1 = new Segment2D(a,b);
		Segment2D s2 = new Segment2D(c,d);
	
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		ListSegment l_obj = new ListSegment(); 
		MultiSegment l_seg = new MultiSegment();
		
		l_obj.add(s1);
		l_obj.add(s2);

		for(int i=0; i < l_obj.getS().size();i++){
			
			for(int x=1; x < l_obj.getS().size();x++){
				
				Point2D testo = new Point2D(l_obj.getS().get(i).getX());
				Point2D testt = new Point2D(l_obj.getS().get(i).getX());
							
				if(testo.equals(testt)) {
					
				} testo =new Point2D(l_obj.getS().get(i).getX());
				
				
		
		}
		

		
				
	}

	}
	
}
