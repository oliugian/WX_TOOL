package tangren.component.GUI;

import javax.security.auth.Refreshable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;

import tangren.Data.GetMenuButton;
import tangren.Model.ButtonModel;
import tangren.WX_TOOL.Controller.EditPlaneController;
import tangren.button.factory.entity.ButtonEntity;
import tangren.button.factory.entity.ButtonForClick;
import tangren.button.factory.entity.ButtonForMedia;
import tangren.button.factory.entity.ButtonForURL;
import tangren.button.factory.entity.ButtonFor_Sub;
import tangren.net.HttpRequestorHelper;
import tangren.net.WeixinUtil;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class EditPanel extends JPanel{
	
	private JPanel keyView = new JPanel();
	private JPanel UrlView = new JPanel();
	private JPanel MediaIdView = new JPanel();
	private JPanel SubButtonView = new JPanel();
	private int nowIndex=-1;
	//菜单编辑
	public JPanel JP_1_1=new JPanel();
	public JLabel JL_1_1=new JLabel();
	public JButton JB_1_1=new JButton("add");
	
	public JPanel JP_1_2=new JPanel();
	public JLabel JL_1_2=new JLabel();
	public JButton JB_1_2=new JButton("add");
	
	public JPanel JP_1_3=new JPanel();
	public JLabel JL_1_3=new JLabel();
	public JButton JB_1_3=new JButton("add");
	
	public JLabel chooseOption = new JLabel();
	
	JTextField click_nameText = new JTextField();
	JTextField click_typeText = new JTextField();
	JTextField click_keyText = new JTextField();
	
	JTextField sub_nameText = new JTextField();
	
	JTextField media_nameText = new JTextField();
	JTextField media_typeText = new JTextField();
	JTextField media_idText = new JTextField();
	
	JTextField URL_Text = new JTextField();
	JTextField URL_nameText = new JTextField();
	JTextField URL_typeText = new JTextField();
	
	
	
	
	//全部按钮
	private int buttonType=-1;
	private static ArrayList<ButtonModel>allButtons=new ArrayList<>(18);
	JButton b_0 = new JButton("b_0");
	JButton b_1 = new JButton("b_1");
	JButton b_2 = new JButton("b_2");
	JButton b_0_1 = new JButton("b_0_1");
	JButton b_0_2 = new JButton("b_0_2");
	JButton b_0_3 = new JButton("b_0_3");
	JButton b_0_4 = new JButton("b_0_4");
	JButton b_0_5 = new JButton("b_0_5");
	JButton b_1_1 = new JButton("b_1_1");
	JButton b_1_2 = new JButton("b_1_2");
	JButton b_1_3 = new JButton("b_1_3");
	JButton b_1_4 = new JButton("b_1_4");
	JButton b_1_5 = new JButton("b_1_5");
	JButton b_2_1 = new JButton("b_2_1");
	JButton b_2_2 = new JButton("b_2_2");
	JButton b_2_3 = new JButton("b_2_3");
	JButton b_2_4 = new JButton("b_2_4");
	JButton b_2_5 = new JButton("b_2_5");
	
	ButtonGroup group=new ButtonGroup();
	
	private static EditPanel instance=null;
	private final JLabel lblNewLabel_1 = new JLabel("操作须知");
	public static EditPanel getInstance(){
		if(instance==null){
			instance=new EditPanel();
		}
		return instance;
	}
	public EditPanel(){
		setBackground(new Color(211, 211, 211));
	
		this.setBounds(10, 157, 896, 453);

		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("菜单编辑区");
		lblNewLabel.setBounds(21, 26, 214, 15);
		this.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("预览");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshPreview();
			}
		});
		btnNewButton.setBounds(187, 400, 93, 23);
		this.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPlaneController eController=new EditPlaneController();
			    int returnKey=eController.saveWXMenu();	
			    if(returnKey==0){
			    	JOptionPane.showMessageDialog(null, "保存成功");
			    }else if (returnKey==1){
			    }else {	
			    	JOptionPane.showMessageDialog(null, "格式出错");
			    }
			}
		});
		btnNewButton_1.setBounds(300, 400, 93, 23);
		this.add(btnNewButton_1);
		
		//初始化界面
		initializeEditView();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("key");
		rdbtnNewRadioButton.setBounds(10, 47, 51, 23);
		this.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("sub_button");
		rdbtnNewRadioButton_2.setBounds(198, 47, 96, 23);
		this.add(rdbtnNewRadioButton_2);
		
		
			
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("url");
		rdbtnNewRadioButton_1.setBounds(63, 47, 51, 23);
		this.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("media_id");
		rdbtnNewRadioButton_3.setBounds(116, 47, 80, 23);
		this.add(rdbtnNewRadioButton_3);
		
		
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				keyView.setVisible(true);
				MediaIdView.setVisible(false);
				UrlView.setVisible(false);
				SubButtonView.setVisible(false);
			}
		});
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				keyView.setVisible(false);
				MediaIdView.setVisible(false);
				UrlView.setVisible(true);
				SubButtonView.setVisible(false);
			}
		});
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				keyView.setVisible(false);
				MediaIdView.setVisible(false);
				UrlView.setVisible(false);
				SubButtonView.setVisible(true);
			}
		});
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				keyView.setVisible(false);
				MediaIdView.setVisible(true);
				UrlView.setVisible(false);
				SubButtonView.setVisible(false);
			}
		});
		
		for(int i=0;i<18;i++){
			ButtonModel bModel=new ButtonModel();
			bModel.setExist(false);
     		allButtons.add(bModel);
		}
		
		InitializeAllButtons();
		for (int i = 0; i < allButtons.size(); i++) {
			allButtons.get(i).getJButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					group.clearSelection();
				}
			});
		}
		
		
	}
	public  ArrayList<ButtonModel> InitializeAllButtons(){
		
	    
		
		JPanel panel = new JPanel();
		panel.setBounds(403, 10, 483, 433);
		add(panel);
		panel.setLayout(null);
		
		//第一级别菜单
		JP_1_1.setBackground(new Color(220, 220, 220));
		JP_1_1.setBounds(10, 340, 151, 83);
		panel.add(JP_1_1);
		JP_1_1.setLayout(null);
		
		
		JL_1_1.setBounds(43, 10, 54, 15);
		JP_1_1.add(JL_1_1);
		JB_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<6;i++){
					if(!allButtons.get(i).isExist()){
						allButtons.get(i).getJButton().setVisible(true);
						allButtons.get(i).setExist(true);
						return;
					}
				}
			}
		});
				
		JB_1_1.setBounds(24, 60, 93, 23);
		JP_1_1.add(JB_1_1);
		
	
		
		b_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nowIndex=0;
				buttonType=allButtons.get(0).getType();
				String optionTitle="当前按钮为："+b_0.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(0).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
				
				
				
				
			}
		});
		b_0.setBounds(0, 0, 151, 50);
		JP_1_1.add(b_0);
		allButtons.get(0).setJButton(b_0);
		
		
		JP_1_2.setBackground(new Color(220, 220, 220));
		JP_1_2.setBounds(166, 340, 151, 83);
		panel.add(JP_1_2);
		JP_1_2.setLayout(null);
		b_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nowIndex=6;
				buttonType=allButtons.get(6).getType();
				String optionTitle="当前按钮为："+b_1.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(6).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
	
		
		
		b_1.setBounds(0, 0, 151, 51);
		JP_1_2.add(b_1);
		allButtons.get(6).setJButton(b_1);
		JB_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i=6;i<12;i++){
					if(!allButtons.get(i).isExist()){
						allButtons.get(i).getJButton().setVisible(true);
						allButtons.get(i).setExist(true);
						return;
					}
				}
			}
		});
		
	
		JB_1_2.setBounds(29, 60, 93, 23);
		JP_1_2.add(JB_1_2);
		
		JP_1_3.setBackground(new Color(220, 220, 220));
		JP_1_3.setBounds(322, 340, 151, 83);
		panel.add(JP_1_3);
		JP_1_3.setLayout(null);
		
		
		JL_1_3.setBounds(48, 10, 54, 15);
		JP_1_3.add(JL_1_3);
		JB_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=12;i<18;i++){
					if(!allButtons.get(i).isExist()){
						allButtons.get(i).getJButton().setVisible(true);
						allButtons.get(i).setExist(true);
						return;
					}
				}
			}
		});
		
		
		JB_1_3.setBounds(29, 60, 93, 23);
		JP_1_3.add(JB_1_3);
		b_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=12;
				buttonType=allButtons.get(12).getType();
				String optionTitle="当前按钮为："+b_2.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(12).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_2.setBounds(0, 0, 151, 50);
		JP_1_3.add(b_2);
		allButtons.get(12).setJButton(b_2);
		
		b_0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=1;
				buttonType=allButtons.get(1).getType();
				String optionTitle="当前按钮为："+b_0_1.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(1).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		b_0_1.setBounds(10, 282, 151, 48);
		panel.add(b_0_1);
		allButtons.get(1).setJButton(b_0_1);
		b_0_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=2;
				buttonType=allButtons.get(2).getType();
				String optionTitle="当前按钮为："+b_0_2.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(2).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_0_2.setBounds(10, 226, 152, 48);
		panel.add(b_0_2);
		allButtons.get(2).setJButton(b_0_2);
		b_0_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=3;
				buttonType=allButtons.get(3).getType();
				String optionTitle="当前按钮为："+b_0_3.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(3).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_0_3.setBounds(10, 171, 151, 48);
		panel.add(b_0_3);
		allButtons.get(3).setJButton(b_0_3);
		b_0_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=4;
				buttonType=allButtons.get(4).getType();
				String optionTitle="当前按钮为："+b_0_4.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(4).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_0_4.setBounds(10, 119, 151, 48);
		panel.add(b_0_4);
		allButtons.get(4).setJButton(b_0_4);
		b_0_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=5;
				buttonType=allButtons.get(5).getType();
				String optionTitle="当前按钮为："+b_0_5.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(5).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_0_5.setBounds(10, 61, 151, 48);
		panel.add(b_0_5);
		allButtons.get(5).setJButton(b_0_5);
		b_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=7;
				buttonType=allButtons.get(7).getType();
				String optionTitle="当前按钮为："+b_1_1.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(7).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		
		b_1_1.setBounds(166, 282, 151, 48);
		panel.add(b_1_1);
		allButtons.get(7).setJButton(b_1_1);
		b_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=8;
				buttonType=allButtons.get(8).getType();
				String optionTitle="当前按钮为："+b_1_2.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(8).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
				
		
		b_1_2.setBounds(166, 226, 152, 48);
		panel.add(b_1_2);
		allButtons.get(8).setJButton(b_1_2);
		b_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=9;
				buttonType=allButtons.get(9).getType();
				String optionTitle="当前按钮为："+b_1_3.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(9).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_1_3.setBounds(166, 171, 151, 48);
		panel.add(b_1_3);
		allButtons.get(9).setJButton(b_1_3);
		b_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=10;
				buttonType=allButtons.get(10).getType();
				String optionTitle="当前按钮为："+b_1_4.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(10).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_1_4.setBounds(166, 119, 151, 48);
		panel.add(b_1_4);
		allButtons.get(10).setJButton(b_1_4);
		b_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=11;
				buttonType=allButtons.get(11).getType();
				String optionTitle="当前按钮为："+b_1_5.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(11).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_1_5.setBounds(166, 61, 151, 48);
		panel.add(b_1_5);
		allButtons.get(11).setJButton(b_1_5);
		b_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=13;
				buttonType=allButtons.get(13).getType();
				String optionTitle="当前按钮为："+b_2_1.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(13).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		
		
		b_2_1.setBounds(322, 282, 151, 48);
		panel.add(b_2_1);
		allButtons.get(13).setJButton(b_2_1);
		b_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=14;
				buttonType=allButtons.get(14).getType();
				String optionTitle="当前按钮为："+b_2_2.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(14).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
				
		
		b_2_2.setBounds(321, 226, 152, 48);
		panel.add(b_2_2);
		allButtons.get(14).setJButton(b_2_2);
		b_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=15;
				buttonType=allButtons.get(15).getType();
				String optionTitle="当前按钮为："+b_2_3.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(15).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_2_3.setBounds(322, 171, 151, 48);
		panel.add(b_2_3);
		allButtons.get(15).setJButton(b_2_3);
		b_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=16;
				buttonType=allButtons.get(16).getType();
				String optionTitle="当前按钮为："+b_2_4.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(16).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_2_4.setBounds(322, 119, 151, 48);
		panel.add(b_2_4);
		allButtons.get(16).setJButton(b_2_4);
		b_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowIndex=17;
				buttonType=allButtons.get(17).getType();
				String optionTitle="当前按钮为："+b_2_5.getLabel();
				if(buttonType!=-1){
					chooseEditView(nowIndex,buttonType,allButtons.get(17).getButton(),optionTitle);
				}else{
					chooseEditView(nowIndex, 0, null,optionTitle);
				}
			}
		});
		
		
		b_2_5.setBounds(322, 61, 151, 48);
		panel.add(b_2_5);
		allButtons.get(17).setJButton(b_2_5);
		
		JLabel label = new JLabel("预览区");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setForeground(new Color(135, 206, 235));
		label.setBounds(216, 10, 54, 15);
		panel.add(label);
		chooseOption.setForeground(new Color(220, 20, 60));
		chooseOption.setFont(new Font("宋体", Font.PLAIN, 15));
		
		
		chooseOption.setBounds(116, 10, 197, 31);
		add(chooseOption);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ButtonEntity be=allButtons.get(nowIndex).getButton();
		        if(be!=null){
		        	be.setKey("");
					be.setMedia_id("");
					be.setName("");
					be.setType("");
					be.setUrl("");
		        }	
				allButtons.get(nowIndex).setType(-1);
				allButtons.get(nowIndex).setExist(false);
				allButtons.get(nowIndex).getJButton().setVisible(false);
		        allButtons.get(nowIndex).getJButton().setText("未编辑");
				refresh();

			}
		});
		btnNewButton_2.setBounds(323, 22, 70, 23);
		add(btnNewButton_2);
		
		
		JTextArea textArea = new JTextArea();
		add(textArea);
		textArea.setBounds(10, 286, 383, 104);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setText("1.每项菜单的type类型必须为：click、view、media_id、pic_weixin等，具体详情可参照微信开发文档。\n2.view类型，即URLView的网址必须为一个正确的网址。\n3.若需要二级菜单，则这一列的第一级菜单必须为sub_button类型，否则该列其它二级菜单无法成功保存。");	
		lblNewLabel_1.setBounds(174, 261, 54, 15);
		
		add(lblNewLabel_1);
		for(int i=0;i<allButtons.size();i++){
			if(!allButtons.get(i).isExist()){
				allButtons.get(i).getJButton().setVisible(false);
			}
		}
		return allButtons;
		
	}
	private void refresh(){
		
		click_keyText.setText("");
		click_nameText.setText("");
		click_typeText.setText("");
		URL_nameText.setText("");
		URL_typeText.setText("");
		URL_Text.setText("");
		media_idText.setText("");
		media_nameText.setText("");
		media_typeText.setText("");
		sub_nameText.setText("");
		ButtonEntity click_Button=allButtons.get(nowIndex).getB_click();
		ButtonEntity url_Button=allButtons.get(nowIndex).getB_Url();
		ButtonEntity media_Button=allButtons.get(nowIndex).getB_Media();
		ButtonEntity suButton=allButtons.get(nowIndex).getB_sub();
		if(click_Button!=null){
			click_keyText.setText(click_Button.getKey());
			click_nameText.setText(click_Button.getName());
			click_typeText.setText(click_Button.getType());
		}

		if(url_Button!=null){
			URL_nameText.setText(url_Button.getName());
			URL_typeText.setText(url_Button.getType());
			URL_Text.setText(url_Button.getUrl());
		}
		
		if(media_Button!=null){
			media_idText.setText(media_Button.getMedia_id());
			media_nameText.setText(media_Button.getName());
			media_typeText.setText(media_Button.getType());
		}
		if(suButton!=null){
			sub_nameText.setText(suButton.getName());
		}
		
		
	}
	private void chooseEditView(int index,int type,ButtonEntity bEntity,String optionTitle){
		//设置标题

		if(bEntity!=null){
			optionTitle="当前按钮为："+bEntity.getName();
		}
		chooseOption.setText(optionTitle);
		refresh();
		if(type==0){		
		
				keyView.setVisible(true);
				MediaIdView.setVisible(false);
				UrlView.setVisible(false);
				SubButtonView.setVisible(false);
					
				
			}else if (type==1) {
			
				keyView.setVisible(false);
				MediaIdView.setVisible(false);
				UrlView.setVisible(true);
				SubButtonView.setVisible(false);
				
			}else if (type==2) {
			
				keyView.setVisible(false);
				MediaIdView.setVisible(true);
				UrlView.setVisible(false);
				SubButtonView.setVisible(false);
				
			}else if (type==3){
				
				keyView.setVisible(false);
				MediaIdView.setVisible(false);
				UrlView.setVisible(false);
				SubButtonView.setVisible(true);
				
			}
		
		
		
	}
	
	
	
	public  static ArrayList<ButtonModel> getPreviewPanel(String access_token){
		ArrayList<ButtonModel> ButtonsTemp=new ArrayList<>();
		ButtonsTemp=new GetMenuButton().getMenuButton(access_token);
		int index[]={0,6,12};
		int cout=0;
		
		
		for(int i=0;i<allButtons.size();i++){
			allButtons.get(i).getJButton().setText("未编辑");
			allButtons.get(i).setType(-1);
			allButtons.get(i).getJButton().setVisible(false);
			allButtons.get(i).setExist(false);
		}
		//调换非一级菜单元素顺序，为了正确展示
        int listIndex[]={-1,-1,-1,ButtonsTemp.size()};
        int coutIndex=0;
		for(int i=0;i<ButtonsTemp.size();i++){	
			if(ButtonsTemp.get(i).getLayer()==1){
				listIndex[coutIndex]=i;
				coutIndex++;
			}	
		}
		for(int i=0;i<listIndex.length-1;i++){
			ButtonsTemp=changeIndex(ButtonsTemp, listIndex[i], listIndex[i+1]);
		}
		
					
		for(int i=0,MenuButtonIndex=0;i<ButtonsTemp.size();i++,MenuButtonIndex++){
			
			if(ButtonsTemp.get(i).getType()==3||ButtonsTemp.get(i).getLayer()==1){
				MenuButtonIndex=index[cout];
				cout++;
			}
			ButtonsTemp.get(i).setJButton(allButtons.get(MenuButtonIndex).getJButton());
			allButtons.set(MenuButtonIndex, ButtonsTemp.get(i));
			allButtons.get(MenuButtonIndex).setType(ButtonsTemp.get(i).getType());
			allButtons.get(MenuButtonIndex).setExist(true);	
		}
		for (int i = 0; i < allButtons.size(); i++) {
			
			if(allButtons.get(i).getType()==-1){
				allButtons.get(i).setExist(false);
				allButtons.get(i).getJButton().setVisible(false);
			}else{
				allButtons.get(i).getJButton().setText(allButtons.get(i).getButton().getName());
				allButtons.get(i).getJButton().setVisible(true);
			}
		}
		return ButtonsTemp;
		
		
	}
	
	private static ArrayList<ButtonModel>changeIndex(ArrayList<ButtonModel>buttonModels,int start,int end){
		
		if(end-start<=2){
			return buttonModels;
		}{
		if(start==-1){
			
		}else{
			ArrayList<ButtonModel>temp=new ArrayList<>();
			for(int i=end-1;i>start;i--){
				temp.add(buttonModels.get(i));			
			}
			int a=temp.size();
			for(int i=0;i<temp.size();i++){
				buttonModels.set(start+1+i,temp.get(i));
			}

		}
		}
		return buttonModels;
	}
	
	
	private void initializeEditView(){
         
		addSub_ButtonView();
		addMediaView();
		addUrlView();
		addKeyView();
		this.add(keyView);
		MediaIdView.setVisible(false);
		keyView.setVisible(false);
		this.add(MediaIdView);
		UrlView.setVisible(false);
		this.add(UrlView);
		this.add(SubButtonView);
	}
	private JPanel addSub_ButtonView(){
		SubButtonView.setVisible(false);
		
		SubButtonView.setBounds(10, 80, 383, 134);
		add(SubButtonView);
		SubButtonView.setLayout(null);
		
		JLabel lblSubbutton = new JLabel("sub_button view");
		lblSubbutton.setBounds(138, 9, 116, 15);
		SubButtonView.add(lblSubbutton);
		
		JLabel lblName_1 = new JLabel("name:");
		lblName_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblName_1.setBounds(10, 37, 54, 15);
		SubButtonView.add(lblName_1);
		
		sub_nameText.setBounds(81, 34, 223, 21);
		SubButtonView.add(sub_nameText);
		sub_nameText.setColumns(10);
		
		
		JButton btnNewButton_4 = new JButton("save");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=sub_nameText.getText();
				 
				if(nowIndex==-1){
					JOptionPane.showMessageDialog(null, "请选择一个按钮");
				}else{
					if(name.equals("")){
						JOptionPane.showMessageDialog(null, "请输入完整！");
					}else {
						chooseOption.setText("当前按钮为："+name);
						ButtonFor_Sub sub_button=new ButtonFor_Sub();
						sub_button.setName(name);
						allButtons.get(nowIndex).getJButton().setLabel(name);
						allButtons.get(nowIndex).setB_sub(sub_button);
						allButtons.get(nowIndex).setType(3);
					}
				}
				
				
					
								
			}
		});
		btnNewButton_4.setBounds(319, 87, 62, 23);
		SubButtonView.add(btnNewButton_4);
		return SubButtonView;
		
	}
	private JPanel addMediaView(){
		
//		MediaIdView.setBackground(new Color(255, 240, 245));
		MediaIdView.setBounds(10, 78, 383, 145);
		MediaIdView.setLayout(null);
		
		JLabel lblType = new JLabel("type\uFF1A");
		lblType.setFont(new Font("宋体", Font.PLAIN, 13));
		lblType.setBounds(10, 81, 48, 15);
		MediaIdView.add(lblType);
		
		JLabel lblName = new JLabel("name\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 13));
		lblName.setBounds(10, 43, 54, 15);
		MediaIdView.add(lblName);
		
		JLabel lblKey = new JLabel("media_id\uFF1A");
		lblKey.setFont(new Font("宋体", Font.PLAIN, 13));
		lblKey.setBounds(10, 113, 104, 15);
		MediaIdView.add(lblKey);
		
		
		media_nameText.setText("");
		media_nameText.setBounds(78, 40, 226, 21);
		MediaIdView.add(media_nameText);
		media_nameText.setColumns(10);
		
	
		media_typeText.setBounds(78, 78, 226, 21);
		MediaIdView.add(media_typeText);
		media_typeText.setColumns(10);
		
	
		media_idText.setBounds(78, 110, 226, 21);
		MediaIdView.add(media_idText);
		media_idText.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=media_nameText.getText();
				String type=media_typeText.getText();
				String id=media_idText.getText();
				if(nowIndex==-1){
					JOptionPane.showMessageDialog(null, "请选择一个按钮");
				}else{
				if(name.equals("")||type.equals("")||id.equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整！");
				}else {
					chooseOption.setText("当前按钮为："+name);
					ButtonForMedia buttonForMedia=new ButtonForMedia();
					buttonForMedia.setName(name);
					buttonForMedia.setMedia_id(id);
					buttonForMedia.setType(type);
					allButtons.get(nowIndex).getJButton().setLabel(name);
					allButtons.get(nowIndex).setB_Media(buttonForMedia);
					allButtons.get(nowIndex).setType(2);
				}
				
				}
				    
			}
				
				
			
		});
		btnNewButton_3.setBounds(314, 109, 68, 23);
		MediaIdView.add(btnNewButton_3);
		
		JLabel lblView = new JLabel("media_id view");
		lblView.setBounds(144, 10, 90, 15);
		MediaIdView.add(lblView);
		return MediaIdView;
	}
   	private JPanel addUrlView(){
		
		UrlView.setBounds(10, 78, 383, 145);
		UrlView.setLayout(null);
		
		JLabel lblType = new JLabel("type\uFF1A");
		lblType.setFont(new Font("宋体", Font.PLAIN, 13));
		lblType.setBounds(10, 81, 48, 15);
		UrlView.add(lblType);
		
		JLabel lblName = new JLabel("name\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 13));
		lblName.setBounds(10, 43, 54, 15);
		UrlView.add(lblName);
		
		JLabel lblKey = new JLabel("url\uFF1A");
		lblKey.setFont(new Font("宋体", Font.PLAIN, 13));
		lblKey.setBounds(10, 116, 54, 15);
		UrlView.add(lblKey);
		
	
		URL_nameText.setText("");
		URL_nameText.setBounds(58, 40, 226, 21);
		UrlView.add(URL_nameText);
		URL_nameText.setColumns(10);
		

		URL_typeText.setBounds(58, 78, 226, 21);
		UrlView.add(URL_typeText);
		URL_typeText.setColumns(10);
		
		
		
		URL_Text.setBounds(58, 110, 226, 21);
		UrlView.add(URL_Text);
		URL_Text.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=URL_nameText.getText();
				String type=URL_typeText.getText();
				String URL=URL_Text.getText();
				if(nowIndex==-1){
					JOptionPane.showMessageDialog(null, "请选择一个按钮");
				}else{
				if(name.equals("")||type.equals("")||URL.equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整！");
				}else {
					chooseOption.setText("当前按钮为："+name);
					ButtonForURL buttonForURL=new ButtonForURL();
					buttonForURL.setName(name);
					buttonForURL.setType(type);
					buttonForURL.setUrl(URL);
					allButtons.get(nowIndex).getJButton().setLabel(name);
					allButtons.get(nowIndex).setB_Url(buttonForURL);
					allButtons.get(nowIndex).setType(1);

				}
				
				
				}
			}
		});
		btnNewButton_3.setBounds(305, 112, 68, 23);
		UrlView.add(btnNewButton_3);
		
		JLabel lblView = new JLabel("URL view");
		lblView.setBounds(144, 10, 73, 15);
		UrlView.add(lblView);
		return UrlView;
	}
	private JPanel addKeyView(){
		
		keyView.setBounds(10, 78, 383, 155);
		keyView.setLayout(null);
		
		JLabel lblType = new JLabel("type\uFF1A");
		lblType.setFont(new Font("宋体", Font.PLAIN, 13));
		lblType.setBounds(10, 81, 48, 15);
		keyView.add(lblType);
		
		JLabel lblName = new JLabel("name\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 13));
		lblName.setBounds(10, 43, 54, 15);
		keyView.add(lblName);
		
		JLabel lblKey = new JLabel("key\uFF1A");
		lblKey.setFont(new Font("宋体", Font.PLAIN, 13));
		lblKey.setBounds(10, 116, 54, 15);
		keyView.add(lblKey);
		
		
		
		click_nameText.setBounds(58, 40, 226, 21);
		keyView.add(click_nameText);
		click_nameText.setColumns(10);
		
		
		click_typeText.setBounds(58, 78, 226, 21);
		keyView.add(click_typeText);
		click_typeText.setColumns(10);
		
		
		click_keyText.setBounds(58, 110, 226, 21);
		keyView.add(click_keyText);
		click_keyText.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=click_nameText.getText();
				String type=click_typeText.getText();
				String key=click_keyText.getText();
				if(nowIndex==-1){
					JOptionPane.showMessageDialog(null, "请选择一个按钮");
				}else{
				if(name.equals("")||type.equals("")||key.equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整！");
				}else {
					chooseOption.setText("当前按钮为："+name);
					ButtonForClick buttonForClick=new ButtonForClick();
					buttonForClick.setName(name);
					buttonForClick.setKey(key);
					buttonForClick.setType(type);
					allButtons.get(nowIndex).getJButton().setLabel(name);
					allButtons.get(nowIndex).setB_click(buttonForClick);
					allButtons.get(nowIndex).setType(0);
				}
				}
					
				    
			}
		});
		btnNewButton_3.setBounds(305, 112, 68, 23);
		keyView.add(btnNewButton_3);
		
		JLabel lblView = new JLabel("key view");
		lblView.setBounds(129, 10, 83, 15);
		keyView.add(lblView);
		return keyView;
	}
	

    public void refreshPreview(){
    	for (int i = 0; i < allButtons.size(); i++) {
			if(allButtons.get(i).getType()==-1){
				allButtons.get(i).setExist(false);
				allButtons.get(i).getJButton().setVisible(false);
			}else{
				allButtons.get(i).getJButton().setVisible(true);
			}
		}
    	
    }
    public static  ArrayList<ButtonModel> getAllButtons(){
    	return allButtons;
    }
    public void setAllButtons(ArrayList<ButtonModel>buttonModels){
    	this.allButtons=buttonModels; 	
    }
    }