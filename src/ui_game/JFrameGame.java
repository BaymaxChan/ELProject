package ui_game;

import javax.swing.JFrame;

import ui.JFrameTotal;
/**
 * ��Ϸ������
 * @author �����
 * 2015.4.8.
 */

public class JFrameGame extends JFrameTotal{
	
	public JFrameGame(PanelGame panelGame){
		super();
		
		//������Ϸ�������
		this.setContentPane(panelGame);
	}
}
