package tangren.component.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TipPanel extends JPanel{
	public TipPanel(){
		this.setBounds(370, 10, 551, 137);
		this.setLayout(null);		
		JTextArea txtrKeyaccesspanel = new JTextArea();
		this.add(txtrKeyaccesspanel);	
		txtrKeyaccesspanel.setLineWrap(true);
		txtrKeyaccesspanel.setText("1���Զ���˵�������3��һ���˵���ÿ��һ���˵�������5�������˵���\n2��һ���˵����4�����֣������˵����7�����֣�������Ĳ��ֽ����ԡ�...�����档\n3�������Զ���˵�������΢�ſͻ��˻��棬��Ҫ24Сʱ΢�ſͻ��˲Ż�չ�ֳ���������ʱ���Գ���ȡ����ע�����˺ź��ٴι�ע������Կ����������Ч����");
		txtrKeyaccesspanel.setBounds(10, 43, 531, 84);
	    txtrKeyaccesspanel.setEditable(false);
		JLabel label = new JLabel("С��ʾ");
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("����", Font.PLAIN, 16));
		label.setBounds(246, 10, 54, 15);
		this.add(label);
	}

}
