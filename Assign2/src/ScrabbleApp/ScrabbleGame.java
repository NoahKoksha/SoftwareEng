package ScrabbleApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;
/**
 * Application class for scrabble game
 */
public class ScrabbleGame {

	private JFrame frame;
	private JTextField input;
	private JTextField output;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleGame window = new ScrabbleGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScrabbleGame() {
		initialize();
		registerTapButtonEvent();
	}
	
    private void registerTapButtonEvent() {
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeScrabble();
            }
        });
    }
    
    
    /**
     * Execute application and check for errors
     */
    private void executeScrabble() {
        Letters letters = new Letters(input.getText().trim());

        if (!letters.underSev()) {
            output.setText("Enter 7 letters or less");
            return;
        }
        
        if (!letters.isAlp()) {
            output.setText("Enter only alphabetic characters");
            return;
        }

        List<String> arrangements = letters.getArr();
        output.setText(String.join(" ", arrangements));
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		input = new JTextField();
		input.setBounds(115, 45, 278, 26);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		output = new JTextField();
		output.setColumns(10);
		output.setBounds(115, 129, 278, 119);
		frame.getContentPane().add(output);
		
		JLabel title = new JLabel("Scrabble");
		title.setBounds(203, 17, 61, 16);
		frame.getContentPane().add(title);
		
		btn = new JButton("Arrange Letters");
		btn.setBounds(192, 88, 124, 29);
		frame.getContentPane().add(btn);
		
		JLabel inpLabel = new JLabel("Input letters");
		inpLabel.setBounds(18, 50, 87, 16);
		frame.getContentPane().add(inpLabel);
		
		JLabel outLabel = new JLabel("Arrangements");
		outLabel.setBounds(18, 138, 97, 16);
		frame.getContentPane().add(outLabel);
	}
}
