import java.awt.Color;
import java.awt.Graphics2D;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : BasicFighter.java
//  @ Date : 3/29/2013
//  @ Author : 
//
//


public class BasicFighter extends RoboFighter {
	public static int strength;
	
	public BasicFighter(int radius, String name, int ammunition, Simulation simulation) {
		super(radius, simulation);
		
		this.simulation = simulation;
		this.ammunition = ammunition;
		this.name = name;
		this.indStrength = strength;
		
		this.isHuman = false;
		
		if(simulation.randomGenerator.nextBoolean()) strategy = new SAggressive();
		else strategy = new SRandom();
	}
	

}
