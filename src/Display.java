
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.JPanel;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Display.java
//  @ Date : 3/29/2013
//  @ Author : 
//
//

class MyKeyListener implements KeyListener {
	
	boolean inputArray[];
	
	int spaceCounter;
	
	public MyKeyListener(boolean[] inputArray) {
		this.inputArray = inputArray;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("KEY RELEASED");
		
		int keyCode = e.getKeyCode();
		
		inputArray[keyCode] = false;
		
		//displayInfo(e, "KEY RELEASED: ");
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("KEY TYPED");
		//displayInfo(e, "KEY TYPED: ");
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("KEY PRESSED");
		
		int keyCode = e.getKeyCode();
		
		inputArray[keyCode] = true;
		
		//displayInfo(e, "KEY PRESSED: ");
		
		
		
	}
	
	private void maintainKeyArray(KeyEvent e) {
		
	}
	
	
	private void displayInfo(KeyEvent e, String keyStatus){
	
	//You should only rely on the key char if the event
	//is a key typed event.
	int id = e.getID();
	String keyString;
	if (id == KeyEvent.KEY_TYPED) {
	    char c = e.getKeyChar();
	    keyString = "key character = '" + c + "'";
	} else {
	    int keyCode = e.getKeyCode();
	    keyString = "key code = " + keyCode
	            + " ("
	            + KeyEvent.getKeyText(keyCode)
	            + ")";
	}
	
	int modifiersEx = e.getModifiersEx();
	String modString = "extended modifiers = " + modifiersEx;
	String tmpString = KeyEvent.getModifiersExText(modifiersEx);
	if (tmpString.length() > 0) {
	    modString += " (" + tmpString + ")";
	} else {
	    modString += " (no extended modifiers)";
	}
	
	String actionString = "action key? ";
	if (e.isActionKey()) {
	    actionString += "YES";
	} else {
	    actionString += "NO";
	}
	
	String locationString = "key location: ";
	int location = e.getKeyLocation();
	if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	    locationString += "standard";
	} else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	    locationString += "left";
	} else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	    locationString += "right";
	} else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	    locationString += "numpad";
	} else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	    locationString += "unknown";
	}
	
	System.out.println(keyStatus + "\n"
	        + "    " + keyString + "\n"
	        + "    " + modString + "\n"
	        + "    " + actionString + "\n"
	        + "    " + locationString + "\n");
	//displayArea.setCaretPosition(displayArea.getDocument().getLength());
	}
}

public class Display extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Simulation simulation;
	
	public Display(final Simulation simulation) {
		this.simulation = simulation;
		add(simulation.legend);
        
		this.addKeyListener(new MyKeyListener(simulation.inputArray));
	        
		/*this.addMouseListener(new MouseListener() {
	            @Override
	            public void mouseReleased(MouseEvent e) {
	                //System.out.println(":MOUSE_RELEASED_EVENT:");
	            }
	            @Override
	            public void mousePressed(MouseEvent e) {
	                //System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                //System.out.println(":MOUSE_EXITED_EVENT:");
	            }
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                //System.out.println(":MOUSE_ENTER_EVENT:");
	            }
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                System.out.println(simulation.roboFighters.size());
	            }
	        });*/
		
			//this.requestFocus();
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(simulation.zoneWidth, simulation.zoneHeight);
	}
	
	public void paintComponent(Graphics g) {
		this.requestFocus();
	
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for(Clutter each : simulation.clutters) {
			each.draw(g2d);
		}
		
		for(Projectile each : simulation.projectiles) {
			each.draw(g2d);
		}
		
		for(RoboFighter each : simulation.roboFighters) {
			each.draw(g2d);
		}
		
		//simulation.legend.repaint();
		
		simulation.legend.setBounds(0, 0, simulation.legend.width, simulation.legend.height);
		simulation.legend.setOpaque(true);
		simulation.legend.setBackground(this.getBackground());
		
	}
}