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

	public HTTP_GUI() {
		initialize();
	}

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

		JTextArea textArea = new JTextArea(res);
		textArea.setFont(new Font("Arial Black", Font.BOLD, 13));
		textArea.setBackground(new Color(204, 204, 204));
		textArea.setBounds(25, 11, 364, 484);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
	}
}