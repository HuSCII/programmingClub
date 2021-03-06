package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.ArcType;
import model.Compass;

public class Python {
	
	Image head;
	Image body;
	Image tail;
	
	Python() {
		head = new Image("file:snake_head.png");
		body = new Image("file:snake_body.png");
		tail = new Image("file:snake_tail.png");
	}
	
	public void drawHead(GraphicsContext gc, Compass dir, Point2D pos) {
//		switch(dir) {
//			case NORTH:
//				 gc.fillPolygon(new double[]{pos.getX(), pos.getX()+(Board.PIXEL_SIZE/2), pos.getX()+(Board.PIXEL_SIZE)}, 
//					 		new double[]{pos.getY()+Board.PIXEL_SIZE, pos.getY(), pos.getY()+Board.PIXEL_SIZE}, 3);
//				break;
//			case SOUTH:
//				gc.fillPolygon(new double[]{pos.getX(), pos.getX()+(Board.PIXEL_SIZE/2), pos.getX()+(Board.PIXEL_SIZE)}, 
//				 		new double[]{pos.getY(), pos.getY()+Board.PIXEL_SIZE, pos.getY()}, 3);
//				break;
//			case WEST:
//				gc.fillPolygon(new double[]{pos.getX()+Board.PIXEL_SIZE, pos.getX(), pos.getX()+Board.PIXEL_SIZE}, 
//				 		new double[]{pos.getY(), pos.getY()+(Board.PIXEL_SIZE/2), pos.getY()+(Board.PIXEL_SIZE)}, 3);
//				break;
//			case EAST:
//				gc.fillPolygon(new double[]{pos.getX(), pos.getX()+Board.PIXEL_SIZE, pos.getX()}, 
//				 		new double[]{pos.getY(), pos.getY()+(Board.PIXEL_SIZE/2), pos.getY()+(Board.PIXEL_SIZE)}, 3);
//				break;
//		}
		gc.drawImage(head, pos.getX(), pos.getY(), Board.PIXEL_SIZE, Board.PIXEL_SIZE);
		
	}
	
	public void drawBody(GraphicsContext gc, Point2D pos) {
//		 gc.fillOval(pos.getX(), pos.getY(), 
//				 Board.PIXEL_SIZE, Board.PIXEL_SIZE);
		gc.drawImage(body, pos.getX(), pos.getY(), Board.PIXEL_SIZE, Board.PIXEL_SIZE);
	}

	public void drawTail(GraphicsContext gc, Compass dir, Point2D pos) {
		//switch(dir) {}
		//gc.fillArc(pos.getX(), pos.getY(), Board.PIXEL_SIZE, Board.PIXEL_SIZE, 315, 270, ArcType.ROUND);
		gc.drawImage(tail, pos.getX(), pos.getY(), Board.PIXEL_SIZE, Board.PIXEL_SIZE);
	}
	
	public static void drawFruit(GraphicsContext gc, Point2D pos, String color) {
//		gc.setFill(javafx.scene.paint.Paint.valueOf(color));
//		gc.fillOval(pos.getX(), pos.getY(), Board.PIXEL_SIZE, Board.PIXEL_SIZE);
		Image img = new Image("file:fruit.png");
		gc.drawImage(img, pos.getX(), pos.getY(), Board.PIXEL_SIZE, Board.PIXEL_SIZE);
	}
	
	 public static void paintSplatter(GraphicsContext gc, String color, Point2D origin) {
		 int rx, ry, rh, rw;
//		 int ri = (int)(Math.random()*colors.size());
//		 System.out.println("Color: " + colors.get(ri));
		 gc.setFill(javafx.scene.paint.Paint.valueOf(color));
		 
	     //Paint origin
	     for(int i=0; i<10; i++) {
	    	 rx = (int)((Math.random()*15) + origin.getX());
	    	 ry = (int)((Math.random()*15) + origin.getY());
	    	 rw = (int)(Math.random()*20)+5;
	    	 rh = rw;
	    	 gc.fillOval(rx, ry, rw, rh);
	     }
	     //Paint edges
	     for(int i=0; i<30; i++) {
	    	 rx = (int)((Math.random()*30) + origin.getX());
	    	 ry = (int)((Math.random()*30) + origin.getY());
	    	 rw = (int)(Math.random()*10)+2;
	    	 rh = rw;
	    	 gc.fillOval(rx, ry, rw, rh);
	     }
	 }
	 
	 public static ArrayList<String> generateColors() throws FileNotFoundException {
		 ArrayList<String> colors = new ArrayList<String>();
	    	Scanner scan = new Scanner(new File("colors.txt"));
	    	while(scan.hasNext()) {
	    		colors.add(scan.next());
	    	}
	    	scan.close();
	    	return colors;
	 }
	 
	 public static String pickFruitColor(ArrayList<String> colors, String prvColor) {
		 String newColor;
		 do {
			 int r = (int)(Math.random()*colors.size());
			 newColor = colors.get(r);
		 } while(newColor.equals(prvColor));
		 return newColor;
	 }

}
