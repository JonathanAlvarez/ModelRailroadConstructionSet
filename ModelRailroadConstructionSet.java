import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.applet.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;

/**
 * Model Railroad Construction Set.
 *
 * @author Jonathan Alvarez
 * @author James Job
 *
 * @version 1.0.0
 */
public class ModelRailroadConstructionSet extends JFrame implements ActionListener, MouseListener, MouseWheelListener {
/** ---------------------------- Global Variables ---------------------------- */
	JFrame jf;
	JPanel jp = new MyJPanel();
	public Image bg = Toolkit.getDefaultToolkit().getImage("images/background.gif");
	public Image strack = Toolkit.getDefaultToolkit().getImage("images/tracks/straight.gif");
	public Image ctrack = Toolkit.getDefaultToolkit().getImage("images/tracks/ctrack.png");
	public Image train1 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train1.gif");
	public Image train2 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train2.gif");
	public Image train3 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train3.gif");
	public Image train4 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train4.gif");
	public Image train5 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train5.gif");
	public Image train6 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train6.gif");
	public Image train7 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train7.gif");
	public Image train8 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train8.gif");
	public Image train9 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train9.gif");
	public Image train10 = Toolkit.getDefaultToolkit().getImage("images/trainParts/Train10.gif");
	public Image church = Toolkit.getDefaultToolkit().getImage("images/environment/church.gif");
	public Image house1 = Toolkit.getDefaultToolkit().getImage("images/environment/house1.gif");
	public Image house2 = Toolkit.getDefaultToolkit().getImage("images/environment/house2.gif");
	public Image house3 = Toolkit.getDefaultToolkit().getImage("images/environment/house3.gif");
	public Image mountain = Toolkit.getDefaultToolkit().getImage("images/environment/mountain.gif");
	public Image trees = Toolkit.getDefaultToolkit().getImage("images/environment/trees.gif");
	public Image water = Toolkit.getDefaultToolkit().getImage("images/environment/water.gif");
	public Image trainCar1 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar1.gif");
	public Image trainCar2 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar2.gif");
	public Image trainCar2a = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar2a.gif");
	public Image trainCar3 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar3.gif");
	public Image trainCar4 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar4.gif");
	public Image trainCar5 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar5.gif");
	public Image trainCar5a = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar5a.gif");
	public Image trainCar6 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar6.gif");
	public Image trainCar7 = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar7.gif");
	public Image trainCar8a = Toolkit.getDefaultToolkit().getImage("images/trainParts/TrainCar8a.gif");
	public int[] theMap =  new int[544];  						// instantiates an array used as a grid in the user interface
	public int[] histMap = new int[544];						// directional map
	public double zoom = 0.5;							// variable used for zooming in and out
	public int zoomX = 0;								// x-coordinate for scrolling
	public int zoomY = 0;								// y-coordinate for scrolling
	public int x1;									// x-coordinate of mouse position
	public int y1;									// y-coordinate of mouse position
	public int img = 1000;								// variable used to change grid position into an image
	public int stop = 0;								// variable used for Go and Stop
	public JButton strackJB = new JButton("S.track");
	public JButton ctrackJB = new JButton("C.track");
	public JButton train1JB = new JButton("Train1");
	public JButton train2JB = new JButton("Train2");
	public JButton train3JB = new JButton("Train3");
	public JButton train4JB = new JButton("Train4");
	public JButton train5JB = new JButton("Train5");
	public JButton train6JB = new JButton("Train6");
	public JButton train7JB = new JButton("Train7");
	public JButton train8JB = new JButton("Train8");
	public JButton train9JB = new JButton("Train9");
	public JButton train10JB = new JButton("Train10");
	public JButton churchJB = new JButton("Church");
	public JButton house1JB = new JButton("House1");
	public JButton house2JB = new JButton("House2");
	public JButton house3JB = new JButton("House3");
	public JButton mountainJB = new JButton("Mountain");
	public JButton treesJB = new JButton("Trees");
	public JButton waterJB = new JButton("Water");
	public JButton trainCar1JB = new JButton("TrainCar1");
	public JButton trainCar2JB = new JButton("TrainCar2");
	public JButton trainCar2aJB = new JButton("TrainCar2a");
	public JButton trainCar3JB = new JButton("TrainCar3");
	public JButton trainCar4JB = new JButton("TrainCar4");
	public JButton trainCar5JB = new JButton("TrainCar5");
	public JButton trainCar5aJB = new JButton("TrainCar5a");
	public JButton trainCar6JB = new JButton("TrainCar6");
	public JButton trainCar7JB = new JButton("TrainCar7");
	public JButton trainCar8aJB = new JButton("TrainCar8a");
	public JButton goJB = new JButton("Go");
	public JButton stopJB = new JButton("Stop");
	public JButton zoom3JB = new JButton("Zoom 3");
	public JButton zoom2JB = new JButton("Zoom 2");
	public JButton zoom1JB = new JButton("Zoom 1");
	public JButton rotateJB = new JButton("Rotate");
	public Image trackIcon = Toolkit.getDefaultToolkit().getImage("images/ui/TrackIcon.gif");	
	public ImageIcon trackUI = new ImageIcon(trackIcon);
	public Image trainIcon = Toolkit.getDefaultToolkit().getImage("images/ui/TrainIcon.gif");
	public ImageIcon trainUI = new ImageIcon(trainIcon);
	public Image trainCarIcon = Toolkit.getDefaultToolkit().getImage("images/ui/TrainCarIcon.gif");
	public ImageIcon trainCarUI = new ImageIcon(trainCarIcon);
	public Image buildingIcon = Toolkit.getDefaultToolkit().getImage("images/ui/BuildingIcon.gif");
	public ImageIcon buildingUI = new ImageIcon(buildingIcon);
	public Image environmentIcon = Toolkit.getDefaultToolkit().getImage("images/ui/EnvironmentIcon.gif");
	public ImageIcon environmentUI = new ImageIcon(environmentIcon);
	public AudioClip whistle;
	public AudioClip railClack;
	public AudioClip place;										// noise for when pieces are placed on the map
	public Thread th = new Thread();
	int delay = 150; 											// milliseconds	
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			int[] tempMap = new int[544];						// working map for movement changes
			for (int i = 0; i < theMap.length; i++) {
				if (theMap[i] / 1000 > 0) {
					int track = theMap[i] / 1000;
					int piece = (theMap[i] - track * 1000) / 100;
					int subPiece = (theMap[i] - track * 1000 - piece * 100) / 10;
					int direction = theMap[i] - track * 1000 - piece * 100 - subPiece * 10;
					int trainDirection;
					int x = i % 34;
					int y = i / 34;
					if (histMap[i] > -1) {
						trainDirection = histMap[i];
					} else {
						trainDirection = direction;
					}
					if (track == 1) {
						if (piece == 1 || piece == 2) {
							switch (trainDirection) {
								case (0) :
									x++;
									break;
								case (1) :
									y++;
									break;
								case (2) :
									x--;
									break;
								case (3) :
									y--;
									break;
								default : 
									break;
							}
							int newPosition = y * 34 + x;
							int newTrack = theMap[newPosition] / 1000;
							int newPiece = (theMap[newPosition] - newTrack * 1000) / 100; 
							int newSubPiece = (theMap[newPosition] - newTrack * 1000 - newPiece * 100) / 10;
							int newDirection = theMap[newPosition] - newTrack * 1000 - newPiece * 100 - newSubPiece * 10;
							
							histMap[i] = -1;
							histMap[newPosition] = trainDirection;
							if (newPiece == 0) {
								theMap[i] = track * 1000 + direction;
								if (newTrack == 1) {
									tempMap[newPosition] = newTrack * 1000 + piece * 100 + subPiece * 10 + trainDirection;
								} else {
									tempMap[newPosition] = newTrack * 1000 + piece * 100 + subPiece * 10 + newDirection;
								}
							}
						}
					}
					if (track == 2) {
						if (piece == 1 || piece == 2) {						
							switch (direction) {				// this looks at the direction of the turn NOT the trains
								case (0) :
									if (trainDirection == 0) {
										trainDirection = 1;
									}
									if (trainDirection == 3) {
										trainDirection = 2;
									}
									break;
								case (1) :
									if (trainDirection == 1) {
										trainDirection = 2;
									}
									if (trainDirection == 0) {
										trainDirection = 3;
									}
									break;
								case (2) :
									if (trainDirection == 2) {
										trainDirection = 3;
									}
									if (trainDirection == 1) {
										trainDirection = 0;
									}
									break;
								case (3) :
									if (trainDirection == 3) {
										trainDirection = 0;
									}
									if (trainDirection == 2) {
										trainDirection = 1;
									}
									break;
								default : 
									break;
							}
							switch (trainDirection) {
								case (0) :
									x++;
									break;
								case (1) :
									y++;
									break;
								case (2) :
									x--;
									break;
								case (3) :
									y--;
									break;
								default : 
									break;
							}
							int newPosition = y * 34 + x;
							int newTrack = theMap[newPosition] / 1000;
							int newPiece = (theMap[newPosition] - newTrack * 1000) / 100; 
							int newSubPiece = (theMap[newPosition] - newTrack * 1000 - newPiece * 100) / 10;
							int newDirection = theMap[newPosition] - newTrack * 1000 - newPiece * 100 - newSubPiece * 10;
							
							histMap[i] = -1;
							histMap[newPosition] = trainDirection;
							if (newPiece == 0) {
								theMap[i] = track * 1000 + direction;
								if (newTrack == 1) {
									tempMap[newPosition] = newTrack * 1000 + piece * 100 + subPiece * 10 + trainDirection;
								} else {
									tempMap[newPosition] = newTrack * 1000 + piece * 100 + subPiece * 10 + newDirection;
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < theMap.length; i++) {
				if (tempMap[i] != 0) {
					theMap[i] = tempMap[i];
				}
			}
			jp.repaint();
		}
	};
	public Timer mrtime = new Timer(delay, taskPerformer);
	public ModelRailroadConstructionSet() {						// constructor begins.
/** ---------------------------- JFrame Stuff ---------------------------- */
		jf = new JFrame("Model Railroad Construction Set"); 	// creats new JFrame with title: Model Railroad Construction Set.
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	// when X is clicked on this frame, entire program closes.
		JPanel jp2 = new JPanel();								// creates a new JPanel named jp2.
		jf.add(jp2, BorderLayout.SOUTH);						// adds jp2 JPanel to jf2 JFrame and centers it.
		jf.add(jp, BorderLayout.CENTER);						// adds jp JPanel to jf JFrame and centers it.
		jf.setSize(1000, 650);									// sets size of jf JFrame to 1000x650.
		jf.setVisible(true);									// makes jf JFrame visible.
		jf.setLocationRelativeTo(null);
		for (int i = 0; i < 544; i++) {
			histMap[i] = -1;
		}
/** ---------------------------- JMenuBar Stuff ---------------------------- */ 
		JMenuBar menuBar = new JMenuBar();					// creates a new JMenuBar named menuBar.
		JMenu menu = new JMenu("File");						// creats a new JMenu named menu that displays "File" on the JMenuBar.
		JMenu editJM = new JMenu("Edit");
		JMenu helpJM = new JMenu("Help");
		menuBar.add(menu);									// adds the JMenu to the JMenuBar so it is displayed.
		//menuBar.add(editJM);
		menuBar.add(helpJM);
		JMenuItem fNew = new JMenuItem("New");				// creates a new JMenuItem to be used with the "File" menu. displays "New".
		fNew.addActionListener(								// adds an action listener to the JMenuItem fExit.
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < theMap.length; i++) {
						theMap[i] = 0;
					}
					jp.repaint();
				}
			}
		);
		// the above code makes it so when you click on "New", the grid clears.
		JMenuItem fOpen = new JMenuItem("Open");			// creates a new JMenuItem to be used with the "File" menu. displays "Open".
		fOpen.addActionListener(							// adds an action listener to the JMenuItem fExit.
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField filename = new JTextField(), dir = new JTextField();
					JFileChooser fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					fc.setCurrentDirectory(new File("C:/cos210/JonathanA/mrcs"));
					int returnVal = fc.showOpenDialog(ModelRailroadConstructionSet.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						filename.setText(fc.getSelectedFile().getName());
						dir.setText(fc.getCurrentDirectory().toString());
						String text = filename.getText();
						for (int i = 0; i < theMap.length; i++) {
							theMap[i] = 0;
						}
						jp.repaint();
						try {
							BufferedReader in = new BufferedReader(new FileReader(text));
							for (int i = 0; i < theMap.length; i++) {
								theMap[i] = Integer.parseInt(in.readLine());
								//System.out.println(theMap[i]);
							}
							jf.repaint();
							in.close();
						} catch (IOException ioe) { }
					}	
					if (returnVal == JFileChooser.CANCEL_OPTION) {
						filename.setText("You pressed cancel");
						dir.setText("");
					}
				}
			}
		);
		// the above code reads integers from a .dat file and stores them into theMap array and repaints the grid.
		JMenuItem fSave = new JMenuItem("Save");			// creates a new JMenuItem to be used with the "File" menu. displays "Save".
		fSave.addActionListener(							// adds an action listener to the JMenuItem fExit.
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField filename = new JTextField(), dir = new JTextField();
					JFileChooser fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					fc.setCurrentDirectory(new File("C:/cos210/JonathanA/mrcs"));
					int returnVal = fc.showSaveDialog(ModelRailroadConstructionSet.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						filename.setText(fc.getSelectedFile().getName());
						dir.setText(fc.getCurrentDirectory().toString());
						String text = filename.getText();
						try {
							FileWriter fw = new FileWriter(text + ".dat");
							for (int i = 0; i < theMap.length; i++) {
								fw.write(theMap[i] + "\n");
							}
							fw.close();
						} catch (IOException ioe) { }
					}
					if (returnVal == JFileChooser.CANCEL_OPTION) {
						filename.setText("You pressed cancel");
						dir.setText("");
					}
				}
			}
		);
		// the above code saves the integers from theMap array and stores them into a .dat file.
		JMenuItem fExit = new JMenuItem("Exit");			// creates a new JMenuItem to be used with the "File" menu. displays "Exit"
		fExit.addActionListener(							// adds an action listener to the JMenuItem fExit
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(-1);
				}
			}
		);
		// the above code makes it so when you click on "Exit", the program closes
		/*JMenuItem trainsJMI = new JMenuItem("edit Trains");
		trainsJMI.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ts.trainJFshow();
				}
			}
		);*/
		JMenuItem helpJMI = new JMenuItem("Controls");
		helpJMI.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame help = new JFrame("Controls");
					JLabel helpJL1 = new JLabel("Arrow Keys: Moves the camera around the screen.");
					JLabel helpJL2 = new JLabel("SpaceBar: Rotates a selected piece.");
					JLabel helpJL3 = new JLabel("MouseWheel: Zooms in and out of the grid.");
					helpJL1.setFont(new Font("SansSerif", Font.PLAIN, 20));
					helpJL2.setFont(new Font("SansSerif", Font.PLAIN, 20));
					helpJL3.setFont(new Font("SansSerif", Font.PLAIN, 20));
					help.setLayout(new GridLayout(3,1));
					help.add(helpJL1);
					help.add(helpJL2);
					help.add(helpJL3);
					help.setSize(500,150);
					help.setLocationRelativeTo(null);
					help.setVisible(true);
					
				}
			}
		);
		menu.add(fNew);										// adds and displays the JMenuItem fNew in the JMenu.
		menu.add(fOpen);									// adds and displays the JMenuItem fOpen in the JMenu.
		menu.add(fSave);									// adds and displays the JMenuItem fSave in the JMenu.
		menu.add(fExit);									// adds and displays the JMenuItem fExit in the JMenu.
		helpJM.add(helpJMI);
		//editJM.add(trainsJMI);
		jf.setJMenuBar(menuBar);							// sets the JMenuBar to the jf JFrame.
/** ---------------------------- JButton & JToolBar Stuff ---------------------------- */	
		jp.addMouseListener(this);							// adds the MouseListener to the JPanel which contains the grid.
		jp.addMouseWheelListener(this);
		strackJB.addActionListener(this);
		ctrackJB.addActionListener(this);
		train1JB.addActionListener(this);
		train2JB.addActionListener(this);
		train3JB.addActionListener(this);
		train4JB.addActionListener(this);
		train5JB.addActionListener(this);
		train6JB.addActionListener(this);
		train7JB.addActionListener(this);
		train8JB.addActionListener(this);
		train9JB.addActionListener(this);
		train10JB.addActionListener(this);
		trainCar1JB.addActionListener(this);
		trainCar2JB.addActionListener(this);
		trainCar2aJB.addActionListener(this);
		trainCar3JB.addActionListener(this);
		trainCar4JB.addActionListener(this);
		trainCar5JB.addActionListener(this);
		trainCar5aJB.addActionListener(this);
		trainCar6JB.addActionListener(this);
		trainCar7JB.addActionListener(this);
		trainCar8aJB.addActionListener(this);
		churchJB.addActionListener(this);
		house1JB.addActionListener(this);
		house2JB.addActionListener(this);
		house3JB.addActionListener(this);
		mountainJB.addActionListener(this);
		treesJB.addActionListener(this);
		waterJB.addActionListener(this);
		rotateJB.addActionListener(this);
		zoom3JB.addActionListener(this);
		zoom2JB.addActionListener(this);
		zoom1JB.addActionListener(this);
		goJB.addActionListener(this);
		stopJB.addActionListener(this);
		JToolBar trackTB = new JToolBar();
		trackTB.add(strackJB);
		trackTB.add(ctrackJB);
		JToolBar trainTB = new JToolBar();
		trainTB.add(train1JB);
		trainTB.add(train2JB);
		trainTB.add(train3JB);
		trainTB.add(train4JB);
		trainTB.add(train5JB);
		trainTB.add(train6JB);
		trainTB.add(train7JB);
		trainTB.add(train8JB);
		trainTB.add(train9JB);
		trainTB.add(train10JB);
		JToolBar carTB = new JToolBar();
		carTB.setLayout(new GridLayout(2,0));
		carTB.add(trainCar1JB);
		carTB.add(trainCar2JB);
		carTB.add(trainCar2aJB);
		carTB.add(trainCar3JB);
		carTB.add(trainCar4JB);
		carTB.add(trainCar5JB);
		carTB.add(trainCar5aJB);
		carTB.add(trainCar6JB);
		carTB.add(trainCar7JB);
		carTB.add(trainCar8aJB);
		JToolBar buildingTB = new JToolBar();
		buildingTB.add(churchJB);
		buildingTB.add(house1JB);
		buildingTB.add(house2JB);
		buildingTB.add(house3JB);
		JToolBar envTB = new JToolBar();
		envTB.add(mountainJB);
		envTB.add(treesJB);
		envTB.add(waterJB);
		JTabbedPane jtp= new JTabbedPane();
		jtp.addTab("Tracks", trackUI, trackTB);
		jtp.addTab("Trains", trainUI, trainTB);
		jtp.addTab("TrainCars", trainCarUI, carTB);
		jtp.addTab("Environment", environmentUI, envTB);
		jtp.addTab("Buildings and Structures", buildingUI, buildingTB);
		jp2.add(jtp);
		JToolBar tbControl = new JToolBar();
		tbControl.add(rotateJB);
		tbControl.add(zoom3JB);
		tbControl.add(zoom2JB);
		tbControl.add(zoom1JB);
		tbControl.add(goJB);
		tbControl.add(stopJB);
		jp2.add(tbControl);
		URL urlWhistle = ModelRailroadConstructionSet.class.getResource("sounds/Whistle.wav");
		whistle = Applet.newAudioClip(urlWhistle);
		URL urlRailclack = ModelRailroadConstructionSet.class.getResource("sounds/RailClack.wav");
		railClack = Applet.newAudioClip(urlRailclack);
		URL urlPlace = ModelRailroadConstructionSet.class.getResource("sounds/Placement.wav");
		place = Applet.newAudioClip(urlPlace);
	}
	public void actionPerformed(ActionEvent e) {				// button actions
		if (e.getSource() == strackJB) {
			img = 1000;
		}
		if (e.getSource() == ctrackJB) {
			img = 2000;
		}
		if (e.getSource() == train1JB) {
			img = 1100;
		}
		if (e.getSource() == train2JB) {
			img = 1110;
		}
		if (e.getSource() == train3JB) {
			img = 1120;
		}
		if (e.getSource() == train4JB) {
			img = 1130;
		}
		if (e.getSource() == train5JB) {
			img = 1140;
		}
		if (e.getSource() == train6JB) {
			img = 1150;
		}
		if (e.getSource() == train7JB) {
			img = 1160;
		}
		if (e.getSource() == train8JB) {
			img = 1170;
		}
		if (e.getSource() == train9JB) {
			img = 1180;
		}
		if (e.getSource() == train10JB) {
			img = 1190;
		}
		if (e.getSource() == trainCar1JB) {
			img = 1200;
		}
		if (e.getSource() == trainCar2JB) {
			img = 1210;
		}
		if (e.getSource() == trainCar2aJB) {
			img = 1220;
		}
		if (e.getSource() == trainCar3JB) {
			img = 1230;
		}
		if (e.getSource() == trainCar4JB) {
			img = 1240;
		}
		if (e.getSource() == trainCar5JB) {
			img = 1250;
		}
		if (e.getSource() == trainCar5aJB) {
			img = 1260;
		}
		if (e.getSource() == trainCar6JB) {
			img = 1270;
		}
		if (e.getSource() == trainCar7JB) {
			img = 1280;
		}
		if (e.getSource() == trainCar8aJB) {
			img = 1290;
		}
		if (e.getSource() == churchJB) {
			img = 430;
		}
		if (e.getSource() == house1JB) {
			img = 400;
		}
		if (e.getSource() == house2JB) {
			img = 410;
		}
		if (e.getSource() == house3JB) {
			img = 420;
		}
		if (e.getSource() == waterJB) {
			img = 300;
		}
		if (e.getSource() == mountainJB) {
			img = 310;
		}
		if (e.getSource() == treesJB) {
			img = 320;
		}
		if (e.getSource() == rotateJB) {
			img += 1;
			if (img % 10 == 4) {
				img -= img % 10;
			}
			if (img - (img % 10) == 1000) {
				if (img % 10 == 3) {
					img -= 3;
					img += 1;
				}
				if (img % 10 == 2) {
					img -= 2;
				}
			}
		}
		if (e.getSource() == zoom3JB) {
			zoom = 0.5;
		}
		if (e.getSource() == zoom2JB) {
			zoom = 0.75;
		}
		if (e.getSource() == zoom1JB) {
			zoom = 1.0;
		}
		if (e.getSource() == goJB) {
			whistle.play();
			try {
				th.sleep(3000);
			} catch (InterruptedException ioe) {}
			railClack.loop();
			mrtime.start();
		}	
		if (e.getSource() == stopJB) {
			whistle.stop();
			railClack.stop();
			mrtime.stop();
		}					
		jp.repaint();
		jp.requestFocus();
		jp.setFocusable(true);
	}
	public void mousePressed(MouseEvent e) {
		int replace = 0;
		if (e.getButton() == 1) {							// left-click
			replace = img;
		}
		if (e.getButton() == 2) {							// right-click
			replace = 0;									// clears it
		}
		x1 = e.getX();										// gets x coordinate of mouse position when mouse is pressed.
		y1 = e.getY();										// gets y coordinate of mouse position when mouse is pressed.
		x1 = (int) x1 / (int) (75 * zoom) + zoomX;			// converts the x coordinate to work with our zoom and grid.
		y1 = (int) y1 / (int) (75 * zoom) + zoomY;			// converts the y coordinate to work with our zoom and grid.
		theMap[(34 * y1) + x1] = replace;					// assigns the image to the grid that was "pressed".	
		jp.repaint();
		place.play();
	}
	public void mouseDragged (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited  (MouseEvent e) {}
    public void mouseClicked (MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
	public void mouseWheelMoved(MouseWheelEvent e) {			// zooming
		if (zoom <= 1 && zoom >= 0.5) {
			zoom -= e.getWheelRotation() *  0.01;
		}
		if (zoom > 1) {
			zoom = 1;
		}
		if (zoom < 0.5) {
			zoom = 0.5;
		}
		jp.repaint();
	}
/** ---------------------------- main ---------------------------- */	
	public static void main(String[] sa) {
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					new ModelRailroadConstructionSet();
				}
			}
		);
	}
/** ---------------------------- MyJPanel stuff ---------------------------- */	
	public class MyJPanel extends JPanel {
		public MyJPanel() {
			super();
			setLayout(null);
			addKeyListener(new MyKeyListener());
			setFocusable(true);
			requestFocus();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			AffineTransform back = new AffineTransform();
			back.scale(1.44, 1.0);
			g2d.drawImage(bg, back, this);
			double curX;
			double curY;
			//Map drawing loop
			for (int i = 0; i < 544; i++) {
				int tab = theMap[i], tx = i  % 34, ty = i / 34;			
				AffineTransform at = new AffineTransform();	
				curX = 75.0 * tx * zoom - zoomX * 75.0 * zoom;
				curY = 75.0 * ty * zoom - zoomY * 75.0 * zoom;	
				at.translate(curX, curY);
				at.scale(zoom, zoom);
				drawSprite(g2d, at, theMap[i], histMap[i], curX, curY);
			}
			//grid lines
			double x = 75.0 * zoom;							// instantiates a double with the value of 75.
			g2d.setPaint(new Color(0,220,0));				// sets the color of the grid to a light green color.
			for (int i = 0; i < 34; i++) {							
				AffineTransform at = new AffineTransform();
				at.translate(-1 * zoom * zoomX * 75.0, -1 * zoom * zoomY * 75.0);		
				Line2D l2d1 = new Line2D.Double(x, 0, x, 1200 * zoom);
				Shape shape = at.createTransformedShape(l2d1);
				x += 75.0 * zoom;
				g2d.draw(shape);
			}
			x = 75.0 * zoom;								// re-instantiates a double with the value of 75.
			for (int i = 0; i < 16; i++) {
				AffineTransform at = new AffineTransform();
				at.translate(-1 * zoom * zoomX * 75.0, -1 * zoom * zoomY * 75.0);
				Line2D l2d2 = new Line2D.Double(0, x, 2550 * zoom, x);
				Shape shape = at.createTransformedShape(l2d2);
				x += 75.0 * zoom;
				g2d.draw(shape);
			}
			// preview box
			AffineTransform at = new AffineTransform();
			at.translate(10, 10);
			Rectangle2D r2d = new Rectangle2D.Double(9, 9, 76, 76);
			g2d.setPaint(Color.BLACK);
			g2d.draw(r2d);
			drawSprite(g2d, at, img, -1, 0, 0);
		}
		private void drawSprite(Graphics2D g2d, AffineTransform at, int img, int trainDirection, double curX, double curY) {
			int track = img / 1000;
			int rotate = img % 10;
			switch (img % 10) {
				case (1) :
					at.translate(75.0, 0);
					break;
				case (2) :
					at.translate(75.0, 75.0);
					break;
				case (3) :
					at.translate(0, 75.0);
					break;
				default :
					break;
			}
			at.rotate(Math.toRadians(90.0 * rotate));
			AffineTransform at2 = new AffineTransform(at);
			switch ((int) img / 1000) {
				case (1) :
					g2d.drawImage(strack, at, this);
					img = img - 1000;
					break;
				case (2) :
					g2d.drawImage(ctrack, at, this);
					img = img - 2000;
					break;
				default :
					break;
			}
			if ((int) img / 100 == 1) {
				img = img % 100;
				switch ((int) img / 10) {					// switch case draws train cars of different colors
					case (0) :
						g2d.drawImage(train1, at2, this);
						break;
					case (1) :
						g2d.drawImage(train2, at2, this);
						break;
					case (2) :
						g2d.drawImage(train3, at2, this);
						break;
					case (3) :
						g2d.drawImage(train4, at2, this);
						break;
					case (4) :
						g2d.drawImage(train5, at2, this);
						break;
					case (5) :
						g2d.drawImage(train6, at2, this);
						break;
					case (6) :
						g2d.drawImage(train7, at2, this);
						break;
					case (7) :
						g2d.drawImage(train8, at2, this);
						break;
					case (8) :
						g2d.drawImage(train9, at2, this);
						break;
					case (9) :
						g2d.drawImage(train10, at2, this);
						break;
					default :
						break;
				}
			}
			if ((int) img / 100 == 2) {
				img = img % 100;
				switch ((int) img / 10) {					// switch case draws train cars of different colors
					case (0) :
						g2d.drawImage(trainCar1, at2, this);
						break;
					case (1) :
						g2d.drawImage(trainCar2, at2, this);
						break;
					case (2) :
						g2d.drawImage(trainCar2a, at2, this);
						break;
					case (3) :
						g2d.drawImage(trainCar3, at2, this);
						break;
					case (4) :
						g2d.drawImage(trainCar4, at2, this);
						break;
					case (5) :
						g2d.drawImage(trainCar5, at2, this);
						break;
					case (6) :
						g2d.drawImage(trainCar5a, at2, this);
						break;
					case (7) :
						g2d.drawImage(trainCar6, at2, this);
						break;
					case (8) :
						g2d.drawImage(trainCar7, at2, this);
						break;
					case (9) :
						g2d.drawImage(trainCar8a, at2, this);
						break;
					default :
						break;
				}
			}
			if ((int) img / 100 == 3) {
				img = img % 100;
				switch ((int) img / 10) {					// switch case draws train cars of different colors
					case (0) :
						g2d.drawImage(water, at, this);
						break;
					case (1) :
						g2d.drawImage(mountain, at, this);
						break;
					case (2) :
						g2d.drawImage(trees, at, this);
						break;
					default :
						break;
				}
			}
			if ((int) img / 100 == 4) {
				img = img % 100;
				switch ((int) img / 10) {					// switch case draws train cars of different colors
					case (0) :
						g2d.drawImage(house1, at, this);
						break;
					case (1) :
						g2d.drawImage(house2, at, this);
						break;
					case (2) :
						g2d.drawImage(house3, at, this);
						break;
					case (3) :
						g2d.drawImage(church, at, this);
						break;
					default :
						break;
				}
			}
			/** 
			 * The above loop checks each field in the 'theMap' array for certain numerical values and 
			 * places the coresponding piece in the grid position that particular array index is
			 * associated with.
			 * 1*** is a straight track
			 * 11** is a engine on a straight track
			 * 12** is a train car (colored) on a straight track
			 * etc...
			 */
		}
	}
	private class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent ke) {
			switch (ke.getKeyCode()) {
				case (KeyEvent.VK_UP) :
					zoomY--;
					if (zoomY < 0) {
						zoomY = 0;
					}
					break;
				case (KeyEvent.VK_DOWN) :
					zoomY++;
					if (zoomY > 16) {
						zoomY = 16;
					}
					break;
				case (KeyEvent.VK_LEFT) :
					zoomX--;
					if (zoomX < 0) {
						zoomX = 0;
					}
					break;
				case (KeyEvent.VK_RIGHT) :
					zoomX++;
					if (zoomX > 34) {
						zoomX = 34;
					}
					break;
				case (KeyEvent.VK_SPACE) :
					img += 1;
					if (img % 10 == 4) {
						img -= img % 10;
					}			
					if (img - (img % 10) == 1000) {
						if (img % 10 == 3) {
							img -= 3;
							img += 1;
						}
						if (img % 10 == 2) {
							img -= 2;
						}
					}
					break;
				default:
					break;
			}
			jp.repaint();
		}
	}
}
