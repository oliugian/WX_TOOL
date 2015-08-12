package tangren.component.GUI.patten;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewEditPanel extends JPanel{
	private JTextField txtClick;
	private JTextField textField_1;
	private JTextField textField_2;
	public ViewEditPanel(){

		this.setBounds(10, 78, 383, 145);
		this.setLayout(null);
		
		JLabel lblType = new JLabel("type\uFF1A");
		lblType.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		lblType.setBounds(10, 43, 48, 15);
		this.add(lblType);
		
		JLabel lblName = new JLabel("name\uFF1A");
		lblName.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		lblName.setBounds(10, 81, 54, 15);
		this.add(lblName);
		
		JLabel lblKey = new JLabel("key\uFF1A");
		lblKey.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		lblKey.setBounds(10, 116, 54, 15);
		this.add(lblKey);
		
		txtClick = new JTextField();
		txtClick.setText("click");
		txtClick.setEditable(false);
		txtClick.setBounds(58, 40, 226, 21);
		this.add(txtClick);
		txtClick.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 78, 226, 21);
		this.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(58, 110, 226, 21);
		this.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("save");
		btnNewButton_3.setBounds(305, 112, 68, 23);
		this.add(btnNewButton_3);
		
		JLabel lblView = new JLabel("View");
		lblView.setBounds(144, 10, 54, 15);
		this.add(lblView);
		

	}

}
