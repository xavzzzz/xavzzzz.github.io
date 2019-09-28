package frame;
import drawings.*;
import java.awt.Button;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

public class frameController {

	public int IntObj = 0;
	public int CountCreated = 0;
	
	@FXML
	private BorderPane Border;
		
    @FXML
    private Menu edition;
        
    @FXML
    private TextField TailleField;
    
    @FXML
    private TextField XField;
    
    @FXML
    private TextField YField;
    

    @FXML
    private FlowPane ButtonPane;

    @FXML
    private ToggleButton segment;

    @FXML
    private ToggleButton tri;

    @FXML
    private ToggleButton quad;

    @FXML
    private ToggleButton losange;

    @FXML
    private ToggleButton cercle;

    @FXML
    private ToggleButton ell;
    
    @FXML
    private ToggleButton arc;
   
    @FXML
    private ToggleButton ToggleDrag;
    
    @FXML
    private ToggleButton MultiObj;
    
  //booleen pr drag special
	Boolean dragged = false;
	Boolean dragg = false;
	Boolean ModeMulti = false;
	

    @FXML
    private SplitPane Tabs;

    @FXML
    private Tab TabObjets;

    @FXML
    private Tab TabProprietes;

    @FXML
    private Button ProSauvegarder;

    @FXML
    private ListView<Objet2D> ObjectList;
        
    @FXML
    private Canvas mainCanvas;
    
    @FXML
    private ColorPicker ColorChoix;
    
    @FXML
    private AnchorPane CanvasPane;
    
    @FXML
    private Group root;
    
    @FXML
    private ToggleButton carre;
    

    @FXML
    void AClick(ActionEvent event) {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	tri.setSelected(false);
    	ell.setSelected(false);
    	cercle.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);
    }
    
    
    @FXML
    void CaClick(ActionEvent event) {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	tri.setSelected(false);
    	ell.setSelected(false);
    	cercle.setSelected(false);
    	arc.setSelected(false);
    	MultiObj.setDisable(true);
    }

   

    @FXML
    void CClick(ActionEvent event) {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	tri.setSelected(false);
    	ell.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);
    }

    @FXML
    void EClick(ActionEvent event) {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	cercle.setSelected(false);
    	tri.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);
    }

    @FXML
    void EndScene(ActionEvent event) {


    	//---------
    }

    @FXML
    void LClick(ActionEvent event) {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	tri.setSelected(false);
    	cercle.setSelected(false);
    	ell.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);

    	//---------
    }

    @FXML
    void QClick(ActionEvent event) {
    	segment.setSelected(false);
    	tri.setSelected(false);
    	losange.setSelected(false);
    	cercle.setSelected(false);
    	ell.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);

    	//---------
    }

    @FXML
    void SClick(ActionEvent event) {
    	tri.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	cercle.setSelected(false);
    	ell.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);

    	//---------
    }

    @FXML
    void TClick(ActionEvent event) {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	cercle.setSelected(false);
    	ell.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	MultiObj.setDisable(true);

    	//---------
    }

    @FXML
    void BasicDraw(MouseEvent event) {
    	
    		System.out.println("Canvas Click");
    		
    
    	
    		
    				mainCanvas.setOnMouseReleased((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {

    	        @Override
    	        	public void handle(MouseEvent me) {
    	            	System.out.println("Coordinate X -> " + me.getX());
    	            	System.out.println("Coordinate Y -> " + me.getY());
    	            
    	            	
    	            	if(ToggleDrag.isSelected() == true) {// ADD BUTTON CHECK
    	        			System.out.println("ABORT BASIC DRAW");
    	            	}
    	            	else{	
    	            			if(segment.isSelected() == true) {
    	            				BasicSegment(me.getX(), me.getY());
    	            			}
    	            			if(cercle.isSelected() == true) {
    	            				BasicCercle(me.getX(), me.getY());
    	            			}
    	            			if(tri.isSelected() == true && dragged == false) {
    	            				BasicTriangle(me.getX(), me.getY());
    	            			}
    	            			if(tri.isSelected() == true && dragged == true) {
    	            				DragTriangle(me.getX(), me.getY());
    	            			}
    	            			if(quad.isSelected() == true  && dragged == false) {
    	            				BasicQuad(me.getX(), me.getY());
    	            			}
    	            			if(quad.isSelected() == true  && dragged == true && dragg == false) {
    	            				DragQuad(me.getX(),me.getY());
    	            			}
    	            			if(quad.isSelected() == true  && dragg == true && dragged == false) {
    	            				LastDragQuad(me.getX(),me.getY());
    	            			}
    	            			if(carre.isSelected() == true) {
    	            				BasicCarre(me.getX(), me.getY());
    	            			}
    	            			if(arc.isSelected() == true) {
    	            				BasicArc(me.getX(), me.getY());
    	            			}
    	            			
    	
    	            		}	
    	        		}
    				});
    			
    			
    		}
    			
    	
    
    //ALL BASIC DRAWN OBJECTS WITH STANDARD SIZES
    
    public void BasicSegment(double x, double y){
    	IntObj++;
   	

    	
    	Point2D ABS = new Point2D(x,y);
    	
    	Segment2D s = new Segment2D(x-50,y,x+50,y);
    	s.setCordABS(ABS);
    	s.setNom("("+IntObj+")");
    	ObjectList.getItems().add(s);
    	MultiChangeSelect(s);
    	    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	
    	g.setStroke(IfMulti(g));
    	g.strokeLine(ABS.getX()-50, ABS.getY(), ABS.getX()+50, ABS.getY());
    	
    	
    	
    }
    
    public void BasicCarre(double x, double y) {
    	IntObj++;
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	Point2D ABS = new Point2D(x,y);
    	Point2D un = new Point2D(x-50,y-50);
    	Point2D deux = new Point2D(x+50,y+50);
    	Point2D trois = new Point2D(x-50,y+50);
    	Point2D quatre = new Point2D(x+50,y-50);
    	Carré2D ca = new Carré2D(un,deux,trois,quatre);
    	ca.setNom("("+IntObj+")");
    	ca.setCordABS(ABS);
    	ObjectList.getItems().add(ca);
    	
    	MultiChangeSelect(ca);
    	CarfO(ca, g);
    }
    
    public void BasicArc(double x, double y) {
    	IntObj++;
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	g.strokeArc(x-40, y-40, 100, 100, 0, 120, ArcType.OPEN);
    	
    	Point2D ABS = new Point2D(x,y);
    	Arc2D a = new Arc2D(ABS,100,120,ArcType.OPEN);
    	
    	a.getCordABS().setX(x-40);
    	a.getCordABS().setY(y-40);
    	a.setNom("("+IntObj+")");
    	ObjectList.getItems().add(a);
    	
    }
    

    
    public void BasicTriangle(double x,double y) {
    	IntObj++;
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	double[] xpoint = {x+50,x,x-50};
    	double[] ypoint = {y+10,y-50,y+10};
    	
    	Point2D one = new Point2D(xpoint[0],ypoint[0]);
    	Point2D two = new Point2D(xpoint[1],ypoint[1]);
    	Point2D three = new Point2D(xpoint[2],ypoint[2]);
  
    	Triangle2D t = new Triangle2D(one,two,three);
    	t.setCordABS(x,y);
    	t.setNom("("+IntObj+")");
    	ObjectList.getItems().add(t);
    	
    	MultiChangeSelect(t);
    	g.strokePolygon(xpoint, ypoint, 3);
    	
    	
    }
    
    public void BasicCercle(double x, double y){
    	IntObj++;
     
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	
    	g.setStroke(IfMulti(g));
    	
    	
    	Point2D ABS = new Point2D(x,y);
    	Cercle2D c = new Cercle2D(ABS, 50);
    	c.setNom("("+IntObj+")");
    	ObjectList.getItems().add(c);
    	
    	
    	MultiChangeSelect(c);
    	g.strokeOval(x-50, y-50, 100, 100);
    	
    	
    }
    
    public void BasicQuad(double x, double y){

    }
    

    public void BasicLosange(double x, double y){
    	
    	
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(Color.BLACK);
    	
    	
    }
    
    
    public void ButtonUnCheck() {
    	segment.setSelected(false);
    	quad.setSelected(false);
    	losange.setSelected(false);
    	cercle.setSelected(false);
    	ell.setSelected(false);
    	arc.setSelected(false);
    	carre.setSelected(false);
    	tri.setSelected(false);
    }
    
    public void ButtonDisable() {
    	segment.setDisable(true);
    	quad.setDisable(true);
    	losange.setDisable(true);
    	cercle.setDisable(true);
    	ell.setDisable(true);
    	arc.setDisable(true);
    	carre.setDisable(true);
    	tri.setDisable(true);
    }
    
    public void ButtonEnable() {
    	segment.setDisable(false);
    	quad.setDisable(false);
    	losange.setDisable(false);
    	cercle.setDisable(false);
    	ell.setDisable(false);
    	arc.setDisable(false);
    	carre.setDisable(false);
    	tri.setDisable(false);
    }
    
    
 
    
    public Boolean ButtonCheck() {

    	Boolean res = false;

    		if(segment.isSelected() == true) {
    			res = true;
    		}
    		if(quad.isSelected() == true) {
    			res = true;
    		}
    		if(losange.isSelected() == true) {
    			res = true;
    		}
    		if(cercle.isSelected() == true) {
    			res = true;
    		}
    		if(ell.isSelected() == true) {
    			res = true;
    		}
    		if(tri.isSelected() == true) {
    			res = true;
    		}
    		if(carre.isSelected() == true) {
    			res = true;
    		}
    		
    		
    		if( res  == false) {
    			
    			System.out.println("launch error pop-up");
    		}
			return res;	
    }

    @FXML
    void DragDraw(MouseEvent event) {
    	
    		System.out.println("Canvas Drag");
    		
    		//TAKE IN INITIAL POSITION X,Y CANVAS
    		double xo,yo;
    		xo =event.getX();
    		yo = event.getY();
    		
    		
    		
    		if(ButtonCheck() == true) {
    			
    		mainCanvas.setOnMouseDragged((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {

    	        	@Override
    	        	public void handle(MouseEvent me) {
    	            	ToggleDrag.setSelected(true);
    	        		}	
    	        		
    				});
    		
    		mainCanvas.setOnMouseReleased((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {

	        	@Override
	        	public void handle(MouseEvent me) {
	        			
	        		
	        			if(ToggleDrag.isSelected() == true) {
	        			
	        				if(segment.isSelected() == true) {
	        					DragSegment(xo,yo,me.getX(),me.getY());
	        				}
	        				if(cercle.isSelected() == true) {
	        					DragCercle(xo,yo,me.getX(),me.getY());
	        				}
	        				if(losange.isSelected() == true) {
	        					DragLosange(xo,yo,me.getX(),me.getY());
	        				}
	        				if(quad.isSelected() == true){
	        					StartDragQuad(xo,yo,me.getX(),me.getY());
	        					dragged = true;
	        				}
	        				if(carre.isSelected() == true){
	        					DragCarre(xo,yo,me.getX(),me.getY());
	        				}
	        				if(tri.isSelected() == true) {
	        					StartDragTri(xo,yo,me.getX(),me.getY());
	        					dragged = true;
	        				}
	        				if(ell.isSelected() == true) {
	        					DragEllipse(xo,yo,me.getX(),me.getY());
	        					
	        				}
	        				
	        				
	        				
	        			}
	        			
	        			ToggleDrag.setSelected(false);
	        		}	
	        		
				});
    		
    		
    		
    			
    		}
    		
    			
    		
    	}
    //------------ENDDRAGDRAW
    
    public void StartDragQuad(double x, double y, double a, double b) {
    	DragSegment(x,y,a,b);
    }
    
    public void DragQuad(double x, double y) {
    	IntObj++;
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	int index = ObjectList.getItems().size()-1;
    	Segment2D s = (Segment2D) ObjectList.getItems().get(index);
    	Point2D un = new Point2D(s.getX().getX(),s.getX().getY());
    	Point2D deux = new Point2D(s.getY().getX(),s.getY().getY());
    	Point2D trois = new Point2D(x,y);
    	
    	Triangle2D t =new Triangle2D(un,deux,trois);
    	TrianglefS(t,g);	t.setNom("("+IntObj+")");
    	
    	ObjectList.getItems().remove(index);
    	ObjectList.getItems().add(t);
    	
    	dragg = true;
    	dragged = false;
    }
    
    
  //---------------------------------------------------------------FIX LAST QUAD DRAG
    public void LastDragQuad(double x, double y) {
	IntObj++;
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	int index = ObjectList.getItems().size()-1;
    	Triangle2D s = (Triangle2D) ObjectList.getItems().get(index);
    	Point2D un = new Point2D(s.getX().getX(),s.getX().getY());
    	Point2D deux = new Point2D(s.getY().getX(),s.getY().getY());
    	Point2D trois = new Point2D(s.getY().getX(),s.getY().getY());
    	Point2D quatre = new Point2D(x,y);
    	
    	Quadrangle2D q = new Quadrangle2D(un,deux,trois,quatre);
    	QuadfO(q,g);	q.setNom("("+IntObj+")");
    	
    	ObjectList.getItems().remove(index);
    	ObjectList.getItems().add(q);
    	
    	dragg = false;
    }
    
    public void StartDragTri(double x, double y, double a, double b) {
    	DragSegment(x,y,a,b);
    }
    
    public Paint IfMulti(GraphicsContext g){
    	g.setStroke(Color.BLACK);
    	if(MultiObj.isSelected() == true) {
    		g.setStroke(Color.RED);
    	}
		return g.getStroke();
    }
    
    public void DragTriangle(double x, double y) {
    	IntObj++;
    	
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));

    	
    	int index = ObjectList.getItems().size()-1;
    	Segment2D s = (Segment2D) ObjectList.getItems().get(index); 
    	Point2D un = new Point2D(s.getX());
    	Point2D deux = new Point2D(s.getY());
    	Point2D trois = new Point2D(x,y);
    	Triangle2D t = new Triangle2D(un, deux, trois);
    	t.setNom("("+IntObj+")");
    	t.setCordABS(un);
    	
    	TrianglefO(t,g);
    	ObjectList.getItems().remove(index);
    	ObjectList.getItems().add(t);
    	
    	MultiChangeSelect(t);
    	dragged = false;
    }
    
    public void MultiChangeSelect(Objet2D o){
    	
    	
    	if(MultiObj.isSelected() == true) {
    		ObjectList.getItems().remove(o);
    		ObjectList.getItems().add(o);
    		CountCreated++;
    	}
    	
    }
    
    public void DragSegment(double x, double y, double a, double b){
    	IntObj++;
    	
    
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	g.strokeLine(x, y, a, b);
    	
    	Segment2D s = new Segment2D(x,y,a,b);
    	
    	s.setCordABS(new Point2D(x,y));
    	s.setNom("("+IntObj+")");
    	ObjectList.getItems().add(s);
    	
    	MultiChangeSelect(s);
    }
    
    //---------------------------------------------------------------MAKEDRAGLOSANGEGREATAGAIN
    public void DragLosange(double x, double y, double a, double b){
    	
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	
    	double l = Math.sqrt(Math.pow(a-x, 2)+Math.pow(b-y, 2));

    	double[] xpoint = {x,a,a+l,x+l};
    	double[] ypoint = {y,b,b,y};
    	
    	g.strokePolygon(xpoint, ypoint, 4);
    	
    	//A FAIRE AJOUR LISTE
    	
    }
    
    
    //---------------------------------------------------------------------------------DRAGELLIPSE
    public void DragEllipse(double x, double y, double a, double b){
    	
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	//AJOUTER LES 4 CAS 
    	
    	g.strokeOval(x, y, Math.abs(x-a), Math.abs(y-b));

    
    }
    
    public void DragCercle(double x, double y, double a, double b) {
    	IntObj++;
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	
    	double l = Math.sqrt(Math.pow(a-x, 2)+Math.pow(b-y, 2));
    	
    	Point2D ABS = new Point2D(x,y);
    	Cercle2D c = new Cercle2D(ABS,l);
    	c.setNom("("+IntObj+")");
    	ObjectList.getItems().add(c);
    	
    	MultiChangeSelect(c);
    	g.strokeOval(x-l, y-l, 2*l, 2*l);    	
    }
    
    public void DragCarre(double x, double y, double a, double b) {
    	IntObj++;
    	
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(IfMulti(g));
    	
    	double width = Math.abs(x-a);
    	double length = Math.abs(y-b);
    	
    	Point2D one = new Point2D(x,y);
    	Point2D four = new Point2D(x+width,y);
    	Point2D three = new Point2D(x,y+length);
    	Point2D two = new Point2D(x+width,y+length);
    	
    	Carré2D c = new Carré2D(one,two,three,four);
    	c.setNom("("+IntObj+")");
    	c.setCordABS(x+(width/2),y+(length/2));
    	
    	ObjectList.getItems().add(c);
    	
    	MultiChangeSelect(c);
    	CarfO(c,g);
    }
    

    
    @FXML
    void DragEND(MouseEvent event) {		
		//NON UTILISER
	}
    
    public void clearall() {
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.clearRect(0, 0, 2000, 2000);
    }
    
    public void clearone(Objet2D selected) {
    	
    	clearall();
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(Color.BLACK);
    	
    	for(int i=0; i < ObjectList.getItems().size();i++) {
    		
    		Objet2D o = ObjectList.getItems().get(i);
    		
    		if(o.equals(selected)) {
    			break;
    		}
    		if(o instanceof Carré2D) {
    			CarfO(o,g);
    		}
    		else if(o instanceof Triangle2D) {
    			TrianglefO(o,g);
    		}
    		else if(o instanceof Segment2D) {
    			g.strokeLine(((Segment2D) o).getX().getX(), ((Segment2D) o).getX().getY(),
    						((Segment2D) o).getY().getX(),((Segment2D) o).getY().getY());
    		}
    		if(o instanceof Arc2D) {
    			ArcfO(o, g);
    		}
    		else if(o instanceof Cercle2D) {
    			CerclefO(o,g);
    		}
    		if(o instanceof ListeObjet) {
    			clearmulti(o, g);
    		}

    		
    	}
    	

    }
    
    public void clearmulti(Objet2D l, GraphicsContext g) {
  
    	ListeObjet list = ((ListeObjet) l);
    	
    	for(int i=0; i < list.taille();i++) {
    		
    		Objet2D o = list.get(i);

    		if(o instanceof Carré2D) {
    			CarfO(o,g);
    		}
    		else if(o instanceof Triangle2D) {
    			TrianglefO(o,g);
    		}
    		else if(o instanceof Segment2D) {
    			g.strokeLine(((Segment2D) o).getX().getX(), ((Segment2D) o).getX().getY(),
    						((Segment2D) o).getY().getX(),((Segment2D) o).getY().getY());
    		}
    		if(o instanceof Cercle2D) {
    			CerclefO(o,g);
    		}
    		if(o instanceof Arc2D) {
    			ArcfO(o, g);
    		}
    	}
    	
    }
    
    public void ArcfO(Objet2D o,GraphicsContext g) {
    	
    	g.strokeArc(((Arc2D) o).getCordABS().getX(),
    				((Arc2D) o).getCordABS().getY(),
    				((Arc2D) o).getRayon(),
    				((Arc2D) o).getRayon(),
    				0,
    				((Arc2D) o).getAngle(),
    				((Arc2D) o).getAt());
    	
    	
    }
    
    public void TrianglefO(Objet2D o,GraphicsContext g){
    	
    	double[] xpoint = {((Triangle2D) o).getX().getX(),
				((Triangle2D) o).getY().getX(),
				((Triangle2D) o).getZ().getX()};
    	double[] ypoint =	{((Triangle2D) o).getX().getY(),
				((Triangle2D) o).getY().getY(),
				((Triangle2D) o).getZ().getY()};
    	
    	g.strokePolygon(xpoint, ypoint, 3);
    }
    
    //Triangle depuis segment2D
    public void TrianglefS(Triangle2D o,GraphicsContext g){
    	
    	g.strokeLine(o.getX().getX(), o.getX().getY(), o.getY().getX(), o.getY().getY());
    	g.strokeLine(o.getY().getX(), o.getY().getY(), o.getZ().getX(), o.getZ().getY());
    	
    	
    }
    
    public void QuadfO(Objet2D o,GraphicsContext g){
    	
    	double[] xpoint = {((Quadrangle2D) o).getX().getX(),
				((Quadrangle2D) o).getY().getX(),
				((Quadrangle2D) o).getZ().getX(),
				((Quadrangle2D) o).getX().getX()};
    	double[] ypoint =	{((Quadrangle2D) o).getX().getY(),
				((Quadrangle2D) o).getY().getY(),
				((Quadrangle2D) o).getZ().getY(),
				((Quadrangle2D) o).getX().getX()};
    	
    	g.strokePolygon(xpoint, ypoint, 4);
    }
    
    public void CarfO(Objet2D o,GraphicsContext g){
    	
    	
    	double width = Math.abs(((Carré2D) o).getX().getX() - ((Carré2D) o).getY().getX());
    	double length = Math.abs(((Carré2D) o).getX().getY() - ((Carré2D) o).getY().getY());
    	
    	g.strokeRect(((Carré2D) o).getX().getX(), ((Carré2D) o).getX().getY(), width, length);
    }
    
    public void CerclefO(Objet2D o,GraphicsContext g){
    
    	double l = o.getRayon();
    	g.strokeOval(o.getCordABS().getX()-l, o.getCordABS().getY()-l, 2*l, 2*l);
   
    }
    
    @FXML
    void EndMulti(ActionEvent event) {
    	
    	ListeObjet l = new ListeObjet();
    	
    	MultiObj.setSelected(false);
    	ModeMulti = false;
    	
   
    	int first = ObjectList.getSelectionModel().getSelectedIndex();
    	int i = 0;
    	
    	ObjectList.getSelectionModel().selectLast();
    	int last = ObjectList.getSelectionModel().getSelectedIndex();
    	
    	do {
    		Objet2D s = ObjectList.getItems().get(last-i);
    		l.ajouterObjet(s);
    		
    		ObjectList.getItems().remove(last-i);
    		
    		i++;
    	}while(i  != CountCreated);
    	
    	Objet2D firstt = ObjectList.getItems().get(first);
    	l.ajouterObjet(firstt);
    	ObjectList.getItems().remove(first);
    	
    	MultiObj.setSelected(false);
    	ModeMulti = false;
    	
    	
    	ObjectList.getItems().add(l);
    	
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(Color.BLACK);
    	clearmulti(l,g);
    	
    	CountCreated = 0;
    }
    
    @FXML
    void SaveObj(ActionEvent event) {
    	
    	Objet2D selected = ObjectList.getSelectionModel().getSelectedItem();
    	AfterSave(selected);
    }
    
    public void AfterSave(Objet2D selected) {
    	
    	
    	Objet nul = null;
    	
    	double x = Double.parseDouble(XField.getText());
		double y = Double.parseDouble(YField.getText());
    	
		
    	
    	if(selected instanceof Segment2D) {
    		
    		((Segment2D) selected).setNom(TailleField.getText());
    		((Segment2D) selected).getX().setX(((Segment2D) selected).getX().getX()+x);
    		((Segment2D) selected).getY().setX(((Segment2D) selected).getY().getX()+x);
    		
    		((Segment2D) selected).getY().setY(((Segment2D) selected).getY().getY()+y);
    		((Segment2D) selected).getX().setY(((Segment2D) selected).getX().getY()+y);
    		clearone(nul);
    	}
    	
    	if(selected instanceof Triangle2D) {
    		
    		((Segment2D) selected).setNom(TailleField.getText());
    		((Segment2D) selected).getX().setX(((Segment2D) selected).getX().getX()+x);
    		((Segment2D) selected).getY().setX(((Segment2D) selected).getY().getX()+x);
    		((Triangle2D) selected).getZ().setX(((Triangle2D) selected).getZ().getX()+x);
    		
    		((Segment2D) selected).getY().setY(((Segment2D) selected).getY().getY()+y);
    		((Segment2D) selected).getX().setY(((Segment2D) selected).getX().getY()+y);
    		((Triangle2D) selected).getZ().setY(((Triangle2D) selected).getZ().getY()+y);
    		clearone(nul);
    	}
    	if(selected instanceof Cercle2D) {
    		selected.getCordABS().setX(selected.getCordABS().getX()+x);
    		selected.getCordABS().setY(selected.getCordABS().getY()+y);
    		clearone(nul);
    	}
    	if(selected instanceof ListeObjet) {
    		
    		for(int i = 0; i < ((ListeObjet) selected).taille();i++) {
    			AfterSave(((ListeObjet) selected).get(i));
    		}
    		
    	}
    	
    	ObjectList.refresh();
    }
    

    @FXML
    void SupO(ActionEvent event) {
    	
    	System.out.println("Supprimer Pressed");
    	
    	
    	Objet2D selected = ObjectList.getSelectionModel().getSelectedItem();
    	ObjectList.getItems().remove(selected);
    	clearone(selected);
    	
    	MultiObj.setDisable(true);
    }
    
    
    
    @FXML
    void ListClick(MouseEvent event) {		
		
    	
    	Objet nul = null;
    	clearone(nul);
    	
    	ButtonUnCheck();
    	
    	MultiObj.setDisable(false);
    	
    	Objet2D selected = ObjectList.getSelectionModel().getSelectedItem();
    	
    	GraphicsContext g = mainCanvas.getGraphicsContext2D();
    	g.setStroke(Color.RED);
    	
    	TailleField.setText(((Objet2D) selected).toString());
		XField.setText(Double.toString(selected.getCordABS().getX()));
		YField.setText(Double.toString(selected.getCordABS().getY()));
    	
    	

		if(selected instanceof Carré2D){
    		CarfO(selected, g);
    		
    	}
    	else if(selected instanceof Triangle2D){
    		
    		TrianglefO(selected, g);
    	}
		else if(selected instanceof Segment2D){
	    	g.strokeLine(((Segment2D) selected).getX().getX(), ((Segment2D) selected).getX().getY(),
	    				((Segment2D) selected).getY().getX(), ((Segment2D) selected).getY().getY());

		}
    	if(selected instanceof Arc2D){
    		ArcfO(selected, g);
    	}
    	else if(selected instanceof Cercle2D){
    		
    		CerclefO(selected, g);
    	}
    	if(selected instanceof Quadrangle2D){
    		QuadfO(selected, g);
    		
    	}
    	if(selected instanceof ListeObjet){
    		clearmulti(selected, g);
    	}
	}
    
    
}
