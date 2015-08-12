package tangren.component.GUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.collections.map.StaticBucketMap;

import tangren.Data.KeySave;
import tangren.Data.Key_Helper;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KeyAccessPanel extends JPanel{
	private final static String AppIDPath="AppID.log";
	private final static String AppSecretPath="AppSecret.log";
	private final static String URLPath="URL.log";
	private  String access_token="";
	public static String getAccess_token(){
		String AppID=textField.getText();
		String AppSecret=textField_1.getText();
		String URL=textField_2.getText();
		
		String access_token1=Key_Helper.get_access_token(URL);
		if (access_token1==null) {
			access_token1=Key_Helper.get_access_token_with_key(AppID, AppSecret);
		}

		return access_token1;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	static JLabel label = new JLabel("");
	public KeyAccessPanel(){
		
		this.setBounds(10, 10, 305, 137);
		this.setLayout(null);
		
		
		JLabel lblAppID = new JLabel("AppID:");
		this.add(lblAppID);
		lblAppID.setForeground(new Color(0, 191, 255));
		lblAppID.setBounds(24, 10, 54, 15);
		
		
		textField = new JTextField();
		this.add(textField);
		textField.setBounds(81, 7, 214, 21);
	    textField.setText(KeySave.readFileByLines(AppIDPath));
		textField.setColumns(10);
		
		JLabel lblAppsecret = new JLabel("AppSecret:");
		this.add(lblAppsecret);
		lblAppsecret.setForeground(new Color(0, 191, 255));
		lblAppsecret.setBounds(10, 51, 68, 15);
		
		
		textField_1 = new JTextField();
		this.add(textField_1);
		textField_1.setBounds(81, 48, 214, 21);
		textField_1.setColumns(10);
		textField_1.setText(KeySave.readFileByLines(AppSecretPath));
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setForeground(new Color(0, 191, 255));
		lblUrl.setBounds(24, 82, 31, 15);
		add(lblUrl);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 79, 214, 21);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(KeySave.readFileByLines(URLPath));
		
		
		JButton btnCeshi = new JButton("测试");
		btnCeshi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getConnect();
				
			}
		});
		btnCeshi.setBounds(202, 110, 93, 23);
		add(btnCeshi);
		
		
		label.setForeground(new Color(0, 255, 0));
		label.setBounds(81, 110, 99, 15);
		add(label);
		
	}
	public static String getConnect(){
		String AppID=textField.getText();
		String AppSecret=textField_1.getText();
		String URL=textField_2.getText();
		if(!(URL.equals(""))||(!(AppID.equals(""))&&!(AppSecret.equals("")))){
			if((!(AppID.equals(""))&&!(AppSecret.equals("")))){
				String access_token=Key_Helper.get_access_token_with_key(AppID, AppSecret);
				if(access_token==null){
					label.setText("");
					JOptionPane.showMessageDialog(null, "AppId或AppSecret出错！");
					
				}else{
				    label.setText("连接成功！！");
				    KeySave.writeFileByLines(AppIDPath, AppID);
				    KeySave.writeFileByLines(AppSecretPath, AppSecret);
				   EditPanel.getInstance().getPreviewPanel(access_token);
				    return access_token;
				}
			}else{
				String access_token=Key_Helper.get_access_token(URL);
				if(access_token==null){
					label.setText("");
					JOptionPane.showMessageDialog(null, "URL出错！");
				}else{
					if(EditPanel.getInstance().getPreviewPanel(access_token)==null){
						JOptionPane.showMessageDialog(null, "网址服务器端access_token过期！");
					}else{
						 label.setText("连接成功！！");
						 KeySave.writeFileByLines(URLPath, URL);	
					}
				   		    
				    return access_token;
				}
			}
			
			
		}else{
			label.setText("");
			JOptionPane.showMessageDialog(null, "输入有误，请输入AppId和AppSecret或者一个URL！");
		}
		return null;
	}
}
