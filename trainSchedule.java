import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class trainSchedule {
	private JFrame trainJF = new JFrame("Trains");
	private MyTrainEngine[] someTrains = new MyTrainEngine[10];
	private int numTrains = 10;
	public trainSchedule() {
		trainJF.setSize(700, 200);
		JPanel trainJP = new JPanel();
		trainJF.add(trainJP, BorderLayout.CENTER);
		trainJP.setLayout(new GridLayout(numTrains, 0));
		
		for(int i = 0; i < numTrains; i++) {
			JButton name = new JButton("name");								// this won't be a button when it's done
			JButton position = new JButton("coord (x,y)");					// this won't be a button when it's done
			JButton currentSpeed = new JButton("Speed / Max Speed");		// this won't be a button when it's done
			JButton numCars = new JButton("# cars");						// this won't be a button when it's done
			JButton direction = new JButton("Backwards");					// pressed = train moves backwards
			JButton delete = new JButton("delete");							// removes the train and all cars
			trainJP.add(name);
			trainJP.add(position);
			trainJP.add(currentSpeed);
			trainJP.add(numCars);
			trainJP.add(direction);
			trainJP.add(delete);
		}
	}
	public void addTrain(int id, int xpos, int ypos) {
		someTrains[numTrains] = new MyTrainEngine(id, xpos, ypos);
		numTrains++;
		trainJF.repaint();
	}
	public void trainJFshow() {
		trainJF.setVisible(true);
	}
	public int getNumTrains() {
		return numTrains;
	}
}
