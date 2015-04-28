package ui_game;

import gamecomponent.Planet;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.JFrameTotal;
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
	static int WIDTH = (int)(JFrameTotal.WINDOWW*0.6);
	static int HEIGHT = (int)(JFrameTotal.WINDOWH*0.6);
	/**
	 * ���ذ�ť
	 */
	JButton returnButton;
	/**
	 * ���ذ�ť��ͼƬ
	 */
	private static final ImageIcon BUTTON_RETURN = Planet.getImageIcon("image/button/����.jpg", (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
	public PanelWin(PlayerControl playerControl){
		//����Ȼ�ᰴť��������ص���������
		this.setLayout(null);
		returnButton = new JButton();
		returnButton.setIcon(BUTTON_RETURN);
		returnButton.setBounds((int)(WIDTH*0.2), (int)(HEIGHT*0.6), (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
		returnButton.addActionListener(playerControl);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.setActionCommand("ReturnFromWin");
		returnButton.setVisible(true);
		this.add(returnButton);
	}
}
