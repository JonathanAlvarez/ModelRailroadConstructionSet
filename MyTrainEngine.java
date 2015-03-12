import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class MyTrainEngine {
	public int id = 0;
	public int xpos = 0;
	public int ypos = 0;
	public int numCars = 0;
	public int[] maxSpeed = new int[10];
	public int currentSpeed = 0;
	public boolean forward = true;										// Train is going forward = true, backwards = false
	public int direction = 0;											// 0 = EAST, 1 = SOUTH, 2 = WEST, 3 = NORTH
	public MyTrainEngine(int img, int xPosition, int yPosition) {
		id = (img - 1100) / 10;
		xpos = xPosition;
		ypos = yPosition;
	}
	public int getSpeed() {
		return maxSpeed[id];
	}
	public void setNumCars(int n) {
		numCars = n;
	}
	public void incrementNumCars() {
		numCars++;
	}
	public void decrementNumCars() {
		numCars--;
	}
	public int getXPos() {
		return xpos;
	}
	public int getYPos() {
		return ypos;
	}
	public int getDirection() {
		return direction;
	}
	public int getCurrentSpeed() {										// trains take 8 seconds to reach top speed if they have no cars attached.
		if (forward && currentSpeed < maxSpeed[id]) {
			currentSpeed += maxSpeed[id] / 8;
		}
		if (!forward && -1 * currentSpeed > -1 * maxSpeed[id]) {
			currentSpeed -= maxSpeed[id] / 8;
		}
		return currentSpeed;
	}
}
