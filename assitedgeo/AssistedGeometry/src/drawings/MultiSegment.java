package drawings;
import java.util.*;

public class MultiSegment extends Objet2D {
	
			
	MultiSegment() {
		
		SegmentArray = new ArrayList <Segment2D>();
	}
	

	private ArrayList <Segment2D> SegmentArray; 
	
	
	public ArrayList<Segment2D> getSegmentArray() {
		return SegmentArray;
	}

	public void setSegmentArray(ArrayList<Segment2D> segmentArray) {
		SegmentArray = segmentArray;
	}
	
	
	public void afficher() {
		
		System.out.println("multi segment");
		
	for(int i=0;i<SegmentArray.size();i++) {
		
		
		System.out.println(SegmentArray.get(i).toString()); 
		
		
		
	}
	}
}
