//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : WeakClutterFactory.java
//  @ Date : 3/29/2013
//  @ Author : 
//
//




public class WeakClutterFactory extends ClutterFactory {
	public static int radius;
	
	public WeakClutterFactory(Simulation simulation) {
		super(simulation);
	}
	
	@Override
	public Clutter createClutter() {
		return new WeakClutter(minStrength, maxStrength, simulation, radius);
	}
}