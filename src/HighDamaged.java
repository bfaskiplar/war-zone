import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : HighDamaged.java
//  @ Date : 3/29/2013
//  @ Author : 
//
//




public class HighDamaged extends DamageDecorator {
	public static int threshold;
	
	public HighDamaged(RoboFighter f) {
		super(f);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		
		g2d.drawOval((int) x - radius + radius/3,(int) y - radius + radius/3, (int) 2*radius - 2*radius/3, (int) 2*radius- 2*radius/3);
		decoratedRoboFigher.draw(g2d);
	}
}
