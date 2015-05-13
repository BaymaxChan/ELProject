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
	 * �ô����ĳ���
	 */
	static int WIDTH = (int)(FrameTotal.WINDOWW*0.784);
	static int HEIGHT = (int)(FrameTotal.WINDOWH*0.784);
	/**
	 * ͨ������
	 */
	private int grade;
	/**
	 * ���ذ�ť
	 */
	private JButton returnButton;
	/**
	 * ��һ�ذ�ť
	 */
	private JButton nextButton;
	/**
	 * ���ذ�ť��ͼƬ
	 */
	private static final ImageIcon BUTTON_RETURN = Planet.getImageIcon

("image/button/Return4.png", (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
	/**
	 * ��һ�ذ�ťͼƬ
	 */
	private static final ImageIcon BUTTON_NEXT = Planet.getImageIcon

("image/button/NEXT3.png", (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
	/**
	 * ����ͼƬ
	 */
	private ImageIcon img;
	private JLabel bg;
	
	public PanelWin(PlayerControl playerControl,int grade){		
		this.grade=grade;
		//����Ȼ�ᰴť��������ص���������
		this.setLayout(null);

		//���ذ�ť����
		returnButton = new JButton();
		returnButton.setIcon(BUTTON_RETURN);
		returnButton.setBounds((int)(WIDTH*0.1), (int)(HEIGHT*0.8), (int)

(WIDTH*0.2), (int)(HEIGHT*0.2));
		returnButton.addActionListener(playerControl);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setActionCommand("ReturnFromWin");
		returnButton.setVisible(true);
		this.add(returnButton);
		//��һ�ذ�ť����
		nextButton = new JButton();
		nextButton.setIcon(BUTTON_NEXT);
		nextButton.setBounds((int)(WIDTH*0.75), (int)(HEIGHT*0.8), (int)

(WIDTH*0.2), (int)(HEIGHT*0.2));
		nextButton.addActionListener(playerControl);
		nextButton.setContentAreaFilled(false);
		nextButton.setBorderPainted(false);
		nextButton.setActionCommand("NextLevel");
		nextButton.setVisible(true);
		this.add(nextButton);
		
		//����������ʾ����ͼƬ
		getMark();
		bg=new JLabel(img);
		this.add(bg);
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
	}
	
	//����ͨ��ʱ������
	public void getMark(){
		if (this.grade == 5){
			img=new ImageIcon("image/win/S.png");
		}else if(this.grade == 4){
			img=new ImageIcon("image/win/A.png");
		}else if(this.grade == 3){
			img=new ImageIcon("image/win/B.png");
		}else if(this.grade == 2){
			img=new ImageIcon("image/win/C.png");
		}else if(this.grade == 1){
			img=new ImageIcon("image/win/D.png");
		}else if(this.grade==0){
			img=new ImageIcon("image/lose/lose.png");
		}
	}	
}