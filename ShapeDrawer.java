import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeDrawer extends JFrame implements ActionListener 
{
    
    private JButton houseButton, triangleButton, circleButton, rectangleButton;
    private JPanel drawingPanel;
    
    public ShapeDrawer() {
        super("Shape Drawer"); //calling constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit program
        setSize(500, 500); //size of frame
        setLocationRelativeTo(null); // centers the jframe
        setLayout(null); //layout manage hunchha 
        
        houseButton = new JButton("House"); 
        houseButton.setBounds(20, 20, 100, 30); //button size
        houseButton.addActionListener(this);
        add(houseButton);
        
        triangleButton = new JButton("Triangle");
        triangleButton.setBounds(140, 20, 100, 30); //button size
        triangleButton.addActionListener(this);
        add(triangleButton);
        
        circleButton = new JButton("Circle");
        circleButton.setBounds(260, 20, 100, 30); //button size
        circleButton.addActionListener(this);
        add(circleButton);
        
        rectangleButton = new JButton("Rectangle");
        rectangleButton.setBounds(380, 20, 100, 30); //button size
        rectangleButton.addActionListener(this);
        add(rectangleButton);
        
        drawingPanel = new JPanel() //creating jpanel object and // `drawingPanel` variable. This panel will be used to draw the shapes based on the button
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                // draw shape based on button clicked
            }
        };
        drawingPanel.setBounds(20, 60, 460, 400); //jframe bhitral panel ko posotion ra size , 
        drawingPanel.setBackground(Color.WHITE); //panel ko color
        add(drawingPanel); //adding drwaingpanel's object to jframe
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand(); //getting text from the button clicked and assigning to buttontext
        Graphics g = drawingPanel.getGraphics(); //getting graphics context of jpsnel object
        g.setColor(Color.BLACK); //setting color black of objects
        g.clearRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());  //clearing panel before drawing new shape
        
        if (buttonText.equals("House")) {
            g.drawRect(100, 200, 200, 200); // draw house
            g.drawLine(100, 200, 200, 100);
            g.drawLine(200, 100, 300, 200);
        } else if (buttonText.equals("Triangle")) {
            g.drawLine(50, 50, 200, 50); // draw triangle
            g.drawLine(200, 50, 125, 175);
            g.drawLine(125, 175, 50, 50);
        } else if (buttonText.equals("Circle")) {
            g.drawOval(100, 100, 200, 200); // draw circle
        } else if (buttonText.equals("Rectangle")) {
            g.drawRect(100, 150, 200, 100); // draw rectangle
        }
    }
    
    public static void main(String[] args)
    {
        new ShapeDrawer();
    }
}
