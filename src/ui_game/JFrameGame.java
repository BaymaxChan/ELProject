package ui_game;

import javax.swing.JFrame;

import ui.JFrameTotal;
/**
 * ��Ϸ������
 * @author �����
 * 2015.4.8.
 */

public class JFrameGame extends JFrameTotal{
	
	public JFrameGame(){
		super();
		
		//������Ϸ�������
		JPanelGame panelGame = new JPanelGame();
		this.setContentPane(panelGame);
	}
}
