import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.imageio.*;
import uk.ac.leedsbeckett.oop.LBUGraphics;




public class GraphicsSystem extends LBUGraphics implements ActionListener //interface
{
	private JFrame frame; //object declaration
	private String command; 
	ArrayList<String> commands;  //It writes here before writing in file //array list ko command sbhaney object declare gareyko
	
	
	private int showWarningMessage() {
		String[] buttonLabels = new String[] {"Yes", "No", "Cancel"};
		String defaultOption = buttonLabels[0]; //default 0 matlab yes ma gayera click bhayeko jasto dekhinchha
		Icon icon = null; //aauney icon 
 
		return JOptionPane.showOptionDialog(this,
						"Would you like to save before exiting?\n" + "There is still something that hasn't been saved!!!", "Alert",
                JOptionPane.YES_NO_CANCEL_OPTION, //kk option chha
                JOptionPane.WARNING_MESSAGE, //joptionpane ko type
                icon,
                buttonLabels,
                defaultOption);    
	}
	private void handleClosing() 
	{
		 if (commands.size() > 0) //arraylist ko length
		 {
	            int answer = showWarningMessage();
	             
	            switch (answer) {
	                case JOptionPane.YES_OPTION:
	                    System.out.println("Save and Quit");
	                    processCommand("savecommand");
	                    this.frame.dispose();
	                    break;
	                    
	                case JOptionPane.NO_OPTION:
	                    System.out.println("Don't Save and Quit");
	                    this.frame.dispose();
	                    break;
	                     
	                case JOptionPane.CANCEL_OPTION:
	                    System.out.println("Don't Quit");
	                    break;
	            }
	        } else {
	            this.frame.dispose(); //frame close
	        } 
	 }
	                     
	                
	
	
	GraphicsSystem()
	{
		this.frame = new JFrame();                //create a frame to display the turtle panel on
        this.frame.setLayout(new FlowLayout());  //not strictly necessary
        this.frame.add(this);                                    //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
        this.frame.pack();                                               //set the frame to a size we can see
        this.frame.setVisible(true); 
        this.commands = new ArrayList<String>();
		this.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() //frame ma add hunchha
		{
			public void windowClosing(WindowEvent e) //kei event bhayo bhaney action listener le herchha 
			{
				handleClosing();//arraylist ko size 0 bhanda badi bhayi bhaney warning message dekhauchha 
			}
		});
          penDown();

	}

	@Override
	public void processCommand(String command) //All commands are saved in command variable //abstract method
	{

		
		commands.add(command); //is added in array box by box
		
		
		
    	System.out.println("pressed "+ command);
    	String[] parts = command.split(" "); 
    	command = command.toLowerCase();
    	
    	
    	
    	if (command.equals("penup"))
    	{
    		penUp();
    	}
    	
    	else if (command.equals("pendown"))
    	{
    		penDown();
    	}
    	else if (command.startsWith("turnleft") && "turnleft".length() == parts[0].length()) 
    	{
			
			int parameter = 0;
			
			
			if(parts.length == 2) //index is 0, 1, length is 2
			{
				try 
				{
				
					parameter = Integer.parseInt(parts[1]); //converts string to integer abc, 123 chha bhaney 123 matra linchha
					if (parameter < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						turnLeft(parameter);
					}
						
				}
				
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
    	}
    	

    	else if (command.startsWith("turnright") && "turnright".length() == parts[0].length()) 
    	{
			
			int parameter = 0;
			
			
			if(parts.length == 2) 
			{
				try 
				{
					parameter = Integer.parseInt(parts[1]);
					if (parameter < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						turnRight(parameter);
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
    	}
    	
    	

    	else if (command.startsWith("forward") && "forward".length() == parts[0].length()) 
    	{
			
			int parameter = 0;
			
			
			if(parts.length == 2) 
			{
				try 
				{
					parameter = Integer.parseInt(parts[1]);
					if (parameter < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						forward(parameter);
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
    	}
    	

    	else if (command.startsWith("backward") && "backward".length() == parts[0].length()) 
    	{
			
			int parameter = 0;
			
			
			if(parts.length == 2) 
			{
				try 
				{
					
					parameter = Integer.parseInt(parts[1]);
					if (parameter < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						forward(-parameter);
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
    	}
    	else if (command.equals("black"))
    	{
    		setPenColour(Color.BLACK );
    	}
    	else if (command.equals("green"))
    	{
    		setPenColour(Color.GREEN );
    	}
    	else if (command.equals("red"))
    	{
    		setPenColour(Color.RED );
    	}
    	else if (command.equals("white"))
    	{
    		setPenColour(Color.WHITE );
    	}
    	else if (command.equals("blue"))
    	{
    		setPenColour(Color.BLUE );
    	}
    	else if (command.equals("pink"))
    	{
    		setPenColour(Color.PINK );
    	}
    	else if (command.equals("cyan"))
    	{
    		setPenColour(Color.CYAN );
    	}
    	
    	else if (command.equals("line"))
    	{
    		drawLine(Color.RED , 20, 40, 100 , 90);
    	}
    	else if (command.equals("circle"))
    	{
    		drawCircle(100,30,200);
    	}
    	else if (command.equals("reset"))
    	{
    		
    		
    		reset();
    		setPenColour(Color.red);
    		setStroke(1);
    		penDown();	
    		
    	}
    	else if (command.equals("clear"))
    	{
    		clear();
    		
    	}
    	else if (command.equals("load"))
    	{
    		load();
    	}
    	else if (command.equals("save"))
    	{
    		save();
    	}

    	else if (command.equals("about"))
    	{
    		
    		about();
    		
    	}
    	
    	else if (command.startsWith("square") && "sqaure".length() == parts[0].length())
    	{

  		
    		if(parts.length == 2) 
			{
				try 
				{
					int length = Integer.parseInt(parts[1]); 
					if (length < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						drawSquare(length);
					}
				}
        		
        		catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
    		}
    		else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
    		
    	}
    	
    	else if (command.startsWith("pencolor") && "pencolor".length() == parts[0].length())
        {
            PenColour(command);
        }
    	
  	
    	else if (command.startsWith("penwidth") && "penwidth".length() == parts[0].length()) 
    	{
			
			int parameter = 0;
			
			
			if(parts.length == 2) 
			{
				try 
				{
					parameter = Integer.parseInt(parts[1]);
					if (parameter < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						setSize(command);
					}
				}
				
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
				
			}
			
			else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
    	}
    	

    	
    	else if (command.startsWith("triangle") && "triangle".length() == parts[0].length()) 
    	{
    
			int size;
			
			if(parts.length == 2) 
			{
				try 
				{
					
					size = Integer.parseInt(parts[1]);
					
					if (size < 0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						drawTriangle(size);
						
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
				
			}
			
			else if (parts.length == 4) {
				int side1,side2,side3;
				try 
				{
					
					side1= Integer.parseInt(parts[1]);
					side2= Integer.parseInt(parts[2]);
					side3= Integer.parseInt(parts[3]);

					if (side1 < 0 &&side2<0&&side3<0)
					{
						JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					    System.out.println("Negative value for parameter.");
					    return ;
					}
					else
					{
						triangle(side1,side2,side3);
						
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
					System.out.println("No numeric data for parameter.");
				}
			}
				
			else 
			{
				JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Missing parameter.");
			}
			}
    	
    	
    
    	

    	 
         
    	
    	else if (command.startsWith("savecommand") && "savecommand".length() == parts[0].length())
    	{
    		savecommand();
    	}
    	else if (command.startsWith("loadcommand") && "loadcommand".length() == parts[0].length())
    	{
    		loadcommand();
    	}
    	else if (command.equals("start"))
    	{
    		start();
    	}
    	else if (command.startsWith("loadcommand") && "loadcommand".length() == parts[0].length())
    	{
    		loadcommand();
    	}
    	
    
 	        
    	
    	else 
    	{
    		JOptionPane.showMessageDialog(this.frame, "Invalid Command.", "Error!", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
   
	  


	public void load()
    {
    	BufferedImage image;
    	try
    	{
    		image = ImageIO.read(new File ("image.png"));
    		setBufferedImage(image);//restoring previously saved image
    		JOptionPane.showMessageDialog(this.frame, "Your image has been loaded succesfully.");
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    	repaint();
    	
    }
	
    
    public void save()
    {
    	File outputfile = new File("image.png");
    	try
    	{
    		ImageIO.write(getBufferedImage(), "png", outputfile);
    		JOptionPane.showMessageDialog(this.frame, "Your image has been saved succesfully.");
    		
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    
    
    public void loadcommand() {
		try {
			File file = new File("gui.txt"); //file ko object banayera file ko naam diney
            Scanner scan = new Scanner(file); //file input linchha to read every line scanner ko constructor ma file pathayo
            while (scan.hasNextLine()) //nextline chha ki nai check garna
            {
                String command = scan.nextLine(); //euta command linchha ani process command ma pathauchha, tya bata panel ma draw hunchha ani feri condition check hunchha

                System.out.println("pressed"+command); 
                processCommand(command);
            }
            scan.close();
            JOptionPane.showMessageDialog(this.frame, "Your image has been loaded succesfully.");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
    
  
    public void savecommand()
    {
    	try {
			File f = new File("gui.txt"); //file ko object banayera file ko naam diye
			FileWriter fw = new FileWriter(f, true); //true le garda append hunchha natra write matra hunchha existing code clear garera
			for(String command: commands) // arraylist ma bhayeko element lai file ma lekhna , array ma bhayeko sab string command ma aauchha ani file ma lekhinchha
			{
				if (command.equals ("loadcommand" ))
				{
					continue; //infinite loop ma najana
				
				}
				else if (command.equals ("savecommand" ))
				{
					continue;
				}
				else
				{
					fw.write(command+"\n"); //filewrite ko object le actual file ma write garirachha command ma bhayeko value jati file ma write bhayirachha
				}
				
			}
            fw.close(); //file close garyaaa
            commands.clear(); //arraylist ko command clear garyaaa
            JOptionPane.showMessageDialog(this.frame, "Your previously typed command has been saved succesfully.");
		} catch (IOException e) {
            e.printStackTrace();
        }
    	
	
    }
    

    
   
    
    public void about() //method override
    {
    	
    	displayMessage("Shreeja Neupane");
    	Graphics g = getGraphicsContext();
    	g.drawString("Shreeja Neupane", 250, 300);
    	super.about();
    	
  
    }
    
    public void drawSquare (int length)
	{
		
		
		turnRight(90);
		forward(length);
		turnRight(90);
		forward(length);
		turnRight(90);
		forward(length);
		turnRight(90);
		forward(length);
		reset();
		
	}
    
   
    

    public void PenColour(String command)
    {
        String[] rgb_array = command.split(" ");

        if (rgb_array.length < 4)
        {
            JOptionPane.showMessageDialog(this.frame, "Missing parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println("Missing parameter.");
            return; // exit the function 
        }
        
        
        

        if (rgb_array.length > 4)
        {
            JOptionPane.showMessageDialog(this.frame, "More number of parameters given.", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println("More number of parameters given.");
            return; 
        }

        try
        {
            int red = Integer.parseInt(rgb_array[1]);
            int green = Integer.parseInt(rgb_array[2]);
            int blue = Integer.parseInt(rgb_array[3]);

            if (red < 0 || green < 0 || blue < 0)
            {
                JOptionPane.showMessageDialog(this.frame, "Negative value for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Negative value for parameter.");
                return; 
            }
            
            else if (red > 255 || green > 255 || blue > 255)
            {
            	JOptionPane.showMessageDialog(this.frame, "RGB value cannot be more than 255.", "Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Negative value for parameter.");
                return; 
            }
            else 
            {
            Color c = new Color(red, green, blue); //color constructor ma rgb ko value pass garyo
            setPenColour(c);
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this.frame, "No numeric data for parameter.", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println("No numeric data for parameter.");
        }
    }


        
    public void setSize(String input)
    {
	    String[] split = input.split(" ");//
	    int size = Integer.parseInt(split[1]);
	    setStroke(size); //this method is present in LBUGraphics
	    System.out.println(size);
	}
    
    public void drawTriangle(int size)
    {
    	
		
		
					turnRight(90);
					forward(size);
					turnRight(120);
					forward(size);
					turnRight(120);
					forward(size);
					
				
    }
    
    public void triangle(int x, int y, int z) 
    {	
        if (x <= 0 || y <= 0 || z <= 0) {
       	 JOptionPane.showMessageDialog(this.frame, "Negative Parameter Given.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Negative Parameter Given.");
            return;
        }
        if (x + y <= z || x + z <= y || y + z <= x) {
       	 JOptionPane.showMessageDialog(this.frame, "Triangle inequality theorem not fulfilled.", "Error!", JOptionPane.ERROR_MESSAGE);
				System.out.println("Triangle inequality theorem not fulfilled.");
            return;
        }
        
        penDown();
        forward(x);  
        turnLeft(180 - (int)Math.toDegrees(Math.acos((x*x + y*y - z*z) / (2.0*x*y)))); 
        forward(y); 
        turnLeft(180 - (int)Math.toDegrees(Math.acos((y*y + z*z - x*x) / (2.0*y*z))));  
        forward(z);  
    }
    
   
 


//imagination
     public void start() 
     {
     	
     	
     	penDown();
     	
     	setPenColour(Color.pink);
     	setStroke(4);
     	setxPos(50);
     	setyPos(80);
     	turnLeft(90);
     	forward(70);
     	forward(-70);
     	turnRight(90);
     	forward(50);
     	turnLeft(90);
     	forward(70);
     	turnRight(90);
     	forward(50);
     	turnLeft(90);
     	forward(-70);
     	reset();
  	 
    	
     	
     	
     	penDown();
     	setPenColour(Color.cyan);
     	setStroke(4);
     	setxPos(160);
     	setyPos(80);
     	forward(100);
     	forward(-50);
     	turnLeft(90);
     	forward(60);
     	turnLeft(90);
     	forward(50);
     	turnRight(180);
     	forward(100);
     	reset();
     	
     
     	penDown();
     	setPenColour(Color.cyan);
     	setStroke(4);
     	setxPos(260);
     	setyPos(80);
     	forward(100);
     	forward(-100);
     	setxPos(290);
     	setyPos(100);
     	circle(30);
     	setxPos(260);
     	setyPos(115);
     	turnLeft(45);
     	forward(90);
     	reset();

     	penDown();
     	setPenColour(Color.cyan);
     	setStroke(4);
     	setxPos(360);
     	setyPos(80);
     	forward(100);
     	turnLeft(90);
     	forward(50);
     	forward(-50);
     	turnLeft(90);
     	forward(50);
     	turnRight(90);
     	forward(50);
     	forward(-50);
     	setyPos(80);
     	forward(50);
     	reset();
 	

     	penDown();
     	setPenColour(Color.cyan);
     	setStroke(4);
     	setxPos(450);
     	setyPos(80);
     	forward(100);
     	turnLeft(90);
     	forward(50);
     	forward(-50);
     	turnLeft(90);
     	forward(50);
     	turnRight(90);
     	forward(50);
     	forward(-50);
     	setyPos(80);
     	forward(50);
     	reset();
 

     	penDown();
     	setPenColour(Color.cyan);
     	setStroke(4);
     	setxPos(580);
     	setyPos(80);
     	forward(105);
     	turnRight();
     	forward(50);
     	turnRight();
     	forward(20);
     	reset();
     	

     
     	
     
     	penDown();
     	setStroke(4);
     	setPenColour(Color.pink);	
     	setxPos(650);
     	setyPos(80);
     	turnRight(10);
     	forward(110);
     	forward(-110);
     	setStroke(5);
     	turnLeft(30);
     	forward(120);
     	forward(-120);
     	setyPos(145);
     	turnLeft(95);
     	forward(30);
     	clear();
     	reset();
     	penDown();
     	
    	 
    	 int j, size = 90;
     	
    	 for (j = 0; j <= 11; j++ ) {
    	     System.out.println("Drawing triangle with size: " + size);
    	     drawTriangle(size);
    	 }


    	 
    	 
    	 setPenColour(Color.green);
    	 setStroke(5);
    	 forward(150);
    	 turnLeft(90);
    	 forward(50);
    	 turnRight(120);
    	 forward(100);
    	 turnRight(120);
    	 forward(100);
    	 turnRight(120);
    	 forward(50);
    	 turnLeft(90);
    	 forward(150);

     }
     
     

    

     
     

     		
    	   
    	    
    	 }

     

     
    

    


     
     	
     
    
    
     
   


	

