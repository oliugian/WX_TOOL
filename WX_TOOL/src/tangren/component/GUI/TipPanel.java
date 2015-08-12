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
		txtrKeyaccesspanel.setText("1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。\n2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。\n3、创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。");
		txtrKeyaccesspanel.setBounds(10, 43, 531, 84);
	    txtrKeyaccesspanel.setEditable(false);
		JLabel label = new JLabel("小提示");
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(246, 10, 54, 15);
		this.add(label);
	}

}
