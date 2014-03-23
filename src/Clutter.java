import java.awt.Color;
import java.awt.Graphics2D;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Clutter.java
//  @ Date : 3/29/2013
//  @ Author : 
//
//




public abstract class Clutter extends Entity {
	public int type; // 0 is for weak, 1 is for sturdy
	
	public Clutter(int radius, Simulation simulation) {
		super(radius, simulation);
		this.damage = 0;
		
	}
	
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		g2d.fillOval((int) x - radius,(int) y - radius, (int) 2*radius, (int) 2*radius);
		g2d.setColor(Color.BLACK);
		g2d.drawString(Integer.toString(strength), (int) x - radius/4,(int)  y + radius/4);
	}
	
	public int strength;
	public int damage;
}