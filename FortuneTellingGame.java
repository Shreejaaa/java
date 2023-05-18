import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FortuneTellingGame implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton button1, button2, button3, button4;
    private JLabel label;

    private String[] messages = {"You'll have a good day today!", "No luck today!!", 
                                 "Your luck is as same as the weather today!", "Better luck next time"};

    public FortuneTellingGame() {
        frame = new JFrame("Fortune Telling Game"); //main window
        frame.setSize(400, 300); //frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit program

        panel = new JPanel(); //creating jpanel object
        panel.setBackground(Color.WHITE); //panel's color
        panel.setLayout(new BorderLayout()); //buttons to be added in either east west north or south // arranging component in a simple way.

        label = new JLabel("Click a button to see your fortune", SwingConstants.CENTER); //tyo lekeyko lai center ma rakhna
        label.setFont(new Font("Arial", Font.BOLD, 16)); //text font
        panel.add(label, BorderLayout.CENTER);//add the component to center

        button1 = new JButton("1"); //creates button with text
        button1.addActionListener(this);//adds actionlistener to button
        panel.add(button1, BorderLayout.WEST);//sets button to west

        button2 = new JButton("2");
        button2.addActionListener(this);
        panel.add(button2, BorderLayout.EAST);

        button3 = new JButton("3");
        button3.addActionListener(this);
        panel.add(button3, BorderLayout.NORTH);

        button4 = new JButton("4");
        button4.addActionListener(this);
        panel.add(button4, BorderLayout.SOUTH);

        frame.getContentPane().setBackground(Color.LIGHT_GRAY); //sets panel background to gray
        frame.add(panel); //adds panel in frame
        frame.setVisible(true);//the JFrame will be displayed on the screen when the program is run.
    }

    public void actionPerformed(ActionEvent e) 
    {
        Random rand = new Random(); //creating object
        int index = rand.nextInt(4); //generating random integer from 0 to 4 which will be stored in "index"
        String message = messages[index]; //is assigning a randomly selected message from the 'messages' array to the variable `message`.
        label.setText(message);//setting text of label to message
        
        if (message.equals("You'll have a good day today!")) {
            panel.setBackground(Color.cyan); //panel color setting
        } else if (message.equals("No luck today!!")) {
            panel.setBackground(Color.RED);
        } else if (message.equals("Your luck is as same as the weather today!")) {
            panel.setBackground(Color.YELLOW);
        } else {
            panel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new FortuneTellingGame();
    }
}
