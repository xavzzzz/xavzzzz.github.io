package drawings;

import java.util.ArrayList;

public class ListSegment {

	ArrayList<Segment2D> s;
	
	ListSegment(){
		
		s = new ArrayList<Segment2D>();
	}

	public ArrayList<Segment2D> getS() {
		return s;
	}

	public void setS(ArrayList<Segment2D> s) {
		this.s = s;
	}
	
	public void afficherListe() {
		
		System.out.println("liste segment");
		
	for(int i=0;i<s.size();i++) {
		
		
		System.out.println(s.get(i).toString()); 
	}
	
	}

	public void add(Segment2D s1) {
		
		s.add(s1);
	}
	
}
