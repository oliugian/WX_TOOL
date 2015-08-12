package tangren.component.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class MainFrame extends JFrame{

	public MainFrame() {
		setVisible(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("WX_Tool");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(960, 650);
		KeyAccessPanel keyAccessPanel=new KeyAccessPanel();
		getContentPane().add(keyAccessPanel);
        TipPanel Tippanel = new TipPanel();
        getContentPane().add(Tippanel);
        EditPanel editPanel =EditPanel.getInstance();
        getContentPane().add(editPanel);
        editPanel.setLocation(10, 157);		
		this.setLocation(300, 100);
		
	}
}
