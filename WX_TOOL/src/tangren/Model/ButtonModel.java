package tangren.Model;


import javax.swing.JButton;

import tangren.button.factory.entity.ButtonEntity;
import tangren.button.factory.entity.ButtonForClick;
import tangren.button.factory.entity.ButtonForMedia;
import tangren.button.factory.entity.ButtonForURL;
import tangren.button.factory.entity.ButtonFor_Sub;

public class ButtonModel {
	
	private boolean isExist;
	private int type=-1;
	private ButtonFor_Sub b_sub;
	private ButtonForClick b_click;
	private ButtonForMedia b_Media;
	private ButtonForURL b_Url;
	private JButton JButton;
	private int layer=0;
	public void setLayer(int layer){
		this.layer=layer;
	}
	public int getLayer(){
		return layer;
	}
	
	public ButtonEntity getButton(){
		switch (type) {
		case 0:
			return getB_click();
		case 1:
			return getB_Url();
		case 2:
			return getB_Media();
		case 3:
			return getB_sub();
		default:
			
			break;
		}
		return null;
	}
	public void setButton(ButtonEntity b,int type){
		setType(type);
		switch (type) {
		    
		case 0:
			setB_click((ButtonForClick)b);
			break;
		case 1:
			setB_Url((ButtonForURL)b);
			break;
		case 2:
			setB_Media((ButtonForMedia)b);
            break;
		case 3:
			setB_sub((ButtonFor_Sub)b);
			break;
		default:
			
			break;
		}
	}
	public void setJButton(JButton JButton){
		this.JButton=JButton;
	}
	public JButton getJButton(){
		return JButton;
	}
	public boolean isExist() {
		return isExist;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ButtonFor_Sub getB_sub() {
		return b_sub;
	}
	public void setB_sub(ButtonFor_Sub b_sub) {
		this.b_sub = b_sub;
	}
	public ButtonForClick getB_click() {
		return b_click;
	}
	public void setB_click(ButtonForClick b_click) {
		this.b_click = b_click;
	}
	public ButtonForMedia getB_Media() {
		return b_Media;
	}
	public void setB_Media(ButtonForMedia b_Media) {
		this.b_Media = b_Media;
	}
	public ButtonForURL getB_Url() {
		return b_Url;
	}
	public void setB_Url(ButtonForURL b_Url) {
		this.b_Url = b_Url;
	}

	

}
