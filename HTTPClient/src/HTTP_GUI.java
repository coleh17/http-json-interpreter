import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class HTTP_GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HTTP_GUI window = new HTTP_GUI();
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
	public HTTP_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.windowBorder);
		frame.setBounds(100, 100, 597, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		String res = "loading...";
		
		try {
			res = HTTPRequest.getHTML("http://tacoshack.online:4041/richest");
			System.out.println(HTTPRequest.getHTML("http://tacoshack.online:4041/richest"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(res);
		String [] lines = res.split("\n");
		System.out.println(Arrays.toString(lines));
//		JLabel label1 = new JLabel(lines[0]);
//		panel.add(label1);
		//for (String line : lines) {
//		for (int i = 0; i < lines.length; i++) {
//			System.out.println(i + " " + lines[i]);
//			JLabel label = new JLabel(lines[i]);
//			panel.add(label);
//			System.out.println(label.getText());
//		}
		
		JTextArea textArea = new JTextArea(res);
		textArea.setFont(new Font("Arial Black", Font.BOLD, 13));
		textArea.setBackground(new Color(204, 204, 204));
		textArea.setBounds(25, 11, 364, 484);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
//		JLabel lblNewLabel = new JLabel(res);
//		lblNewLabel.setBounds(102, 54, 136, 67);
//		frame.getContentPane().add(lblNewLabel);
	}
}
