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
	static int WIDTH = (int)(FrameTotal.WINDOWW*0.6);
	static int HEIGHT = (int)(FrameTotal.WINDOWH*0.6);
	/**
	 * ͨ��ʱ��
	 */
	private int sec;
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
	private static final ImageIcon BUTTON_RETURN = Planet.getImageIcon("image/button/Return4.png", (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
	/**
	 * ��һ�ذ�ťͼƬ
	 */
	private static final ImageIcon BUTTON_NEXT = Planet.getImageIcon("image/button/NEXT3.png", (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
	/**
	 * ����ͼƬ
	 */
	private ImageIcon img;
	private JLabel bg;
	
	public PanelWin(PlayerControl playerControl,int secPassed){		
		this.sec=secPassed;
		//����Ȼ�ᰴť��������ص���������
		this.setLayout(null);

		//���ذ�ť����
		returnButton = new JButton();
		returnButton.setIcon(BUTTON_RETURN);
		returnButton.setBounds((int)(WIDTH*0.1), (int)(HEIGHT*0.8), (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
		returnButton.addActionListener(playerControl);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setActionCommand("ReturnFromWin");
		returnButton.setVisible(true);
		this.add(returnButton);
		//��һ�ذ�ť����
		nextButton = new JButton();
		nextButton.setIcon(BUTTON_NEXT);
		nextButton.setBounds((int)(WIDTH*0.75), (int)(HEIGHT*0.8), (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
		nextButton.addActionListener(playerControl);
		nextButton.setContentAreaFilled(false);
		nextButton.setBorderPainted(false);
		nextButton.setActionCommand("NextLevel");
		nextButton.setVisible(true);
		this.add(nextButton);
		
		//����������ʾ����ͼƬ
		getMark(sec);
		bg=new JLabel(img);
		this.add(bg);
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
	}
	
	//����ͨ��ʱ������
	public void getMark(int sec){
		if (sec<=60){
			img=new ImageIcon("image/win/S.png");
		}else if(sec<=120){
			img=new ImageIcon("image/win/A.png");
		}else if(sec<=180){
			img=new ImageIcon("image/win/B.png");
		}else if(sec<=240){
			img=new ImageIcon("image/win/C.png");
		}else {
			img=new ImageIcon("image/win/D.png");
		}
	}	
}