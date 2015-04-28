package ui_game;

import javax.swing.JFrame;

import control.PlayerControl;
import ui.JFrameTotal;
/**
 * ͨ�ؽ���Ĵ���
 * @author �����
 * 20.5.4.24.
 */
public class FrameWin extends JFrameTotal{
	PanelWin panelWin;
	
	public FrameWin(PlayerControl playerControl){
		panelWin = new PanelWin(playerControl);
		
		this.setTitle("ͨ�ؽ���");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//����ͨ�ش��ڵĴ�С��λ��
		int w = PanelWin.WIDTH;
		int h = PanelWin.HEIGHT;
		int x = (WINDOWW-w)/2+WINDOWX;
		int y = (WINDOWH-h)/2+WINDOWY;
		this.setSize(w, h);
		this.setLocation(x, y);
		
		this.setContentPane(panelWin);
	}
}
