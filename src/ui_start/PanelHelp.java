/**
 * 
 */
package ui_start;

import gamecomponent.Planet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.PlayerControl;
import ui.FrameTotal;

/**
 * @author DorA
 *
 * 2015��4��29������7:03:07
 */
public class PanelHelp extends JPanel{
	private PlayerControl playerControl;
	/**
	 * �ô����ĳ���
	 */
	static int WIDTH = (int)(FrameTotal.WINDOWW*0.6);
	static int HEIGHT = (int)(FrameTotal.WINDOWH*0.6);
	/**
	 * �رհ�ť
	 */
	private JButton closeButton;
	/**
	 * TODO �رհ�ť��ͼƬ
	 */
	private static final ImageIcon BUTTON_CLOSE = Planet.getImageIcon("image/button/Return4.png", (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
	
	public PanelHelp(PlayerControl playerControl){
		this.playerControl = playerControl;
		
		this.setLayout(null);
		
		this.initButton();
	}
	/**
	 * ��ʼ��������ť
	 */
	private void initButton(){
		closeButton = new JButton();
		closeButton.setIcon(BUTTON_CLOSE);
		closeButton.setBounds((int)(WIDTH*0.2), (int)(HEIGHT*0.6), (int)(WIDTH*0.2), (int)(HEIGHT*0.2));
		closeButton.addActionListener(playerControl);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setActionCommand("CloseFrameHelp");
		closeButton.setVisible(true);
		this.add(closeButton);	
	}
}