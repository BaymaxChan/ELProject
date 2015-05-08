package ui_game;

import javax.swing.JFrame;

import control.PlayerControl;
import ui.FrameTotal;
import ui.FrameTotal;
/**
 * ͨ�ؽ���Ĵ���
 * @author �����
 * 20.5.4.24.
 */
public class FrameWin extends JFrame{
	PanelWin panelWin;
	
	public FrameWin(PlayerControl playerControl,int secPassed){
		panelWin = new PanelWin(playerControl,secPassed);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//����ͨ�ش��ڵĴ�С��λ��
		int w = PanelWin.WIDTH;
		int h = PanelWin.HEIGHT+16;
		int x = (FrameTotal.WINDOWW-w)/2+FrameTotal.WINDOWX;
		int y = (FrameTotal.WINDOWH-h)/2+FrameTotal.WINDOWY;
		this.setSize(w, h);
		this.setLocation(x, y);
		
		this.setContentPane(panelWin);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}