package ui_game;

import gamecomponent.Planet;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.FrameTotal;
import control.PlayerControl;
/**
 * ͨ�غ���ʾ�Ľ���
 * @author �����
 * 2015.4.23.
 */
public class PanelWin extends JPanel{
	/**
	 * ͨ������
	 */
	private int grade;
	/**
	 * ����ͼƬ
	 */
	private ImageIcon img;
	private JLabel bg;
	
	public PanelWin(PlayerControl playerControl,int grade){		
		this.grade=grade;
		//����Ȼ�ᰴť��������ص���������
		this.setLayout(null);
		
		//����������ʾ����ͼƬ
		getMark();
		bg=new JLabel(img);
		this.add(bg);
		bg.setBounds(0, 0, FrameWin.WIDTH, FrameWin.HEIGHT);		
	}
	
	//����ͨ��ʱ������
	public void getMark(){
		String address = new String();
		if (this.grade == 5){
			address = "image/win/S.png";
		}else if(this.grade == 4){
			address = "image/win/A.png";
		}else if(this.grade == 3){
			address = "image/win/B.png";
		}else if(this.grade == 2){
			address = "image/win/C.png";
		}else if(this.grade == 1){
			address = "image/win/D.png";
		}else if(this.grade==0){
			address = "image/lose/lose.png";
		}
		img = Planet.getImageIcon(address, (int)(FrameWin.WIDTH*1.02), (int)(FrameWin.HEIGHT*1.02));
	}	
}