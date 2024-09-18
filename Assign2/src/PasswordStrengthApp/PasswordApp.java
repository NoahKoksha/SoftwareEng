package PasswordStrengthApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 * Application class for password strength app 
 */
public class PasswordApp {

	private JFrame frame;
	private JTextField input;
	private JButton btn;
	private JTextArea output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordApp window = new PasswordApp();
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
	public PasswordApp() {
		initialize();
		registerTapButtonEvent();
	}
	
	  private void registerTapButtonEvent() {
	        btn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                checkPass();
	            }
	        });
	    }
	
	  
	  /**
	   * Executes application and checks if the password is of current length, format, and how strong it is.
	   */
    public void checkPass() {
        Password password = new Password(input.getText());
    	
        output.setText("");
        
    	if (!password.isLength()) {
            output.append("Password must be between \n8 and 12 characters.");
            return;
        }
        
        if (password.hasSpaces()) {
            output.append("Password can't contain spaces.");
            return;
        }
        
        int block = password.getBlock();
        if (block <= 2) {
            output.append("The largest block in the pass is " + block + ". \nThis is a decent pass.");
        } else {
        	output.append("The largest block in the pass is " + block + ". \nThis pass can be made stronger by \nreducing this block by " + (block - 2));
        }
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
		input.setBounds(125, 49, 240, 26);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setBounds(49, 54, 77, 16);
		frame.getContentPane().add(passLabel);
		
		JLabel outLabel = new JLabel("Output:");
		outLabel.setBounds(49, 183, 50, 16);
		frame.getContentPane().add(outLabel);
		
		JLabel Title = new JLabel("Password Strength");
		Title.setBounds(169, 6, 127, 16);
		frame.getContentPane().add(Title);
		
		btn = new JButton("Check Password");
		btn.setBounds(160, 98, 146, 29);
		frame.getContentPane().add(btn);
		
		output = new JTextArea();
		output.setBounds(125, 183, 238, 70);
		frame.getContentPane().add(output);
	}
}
