package ui_start;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import control.PlayerControl;
import ui.FrameTotal;
import ui_game.PanelWin;

public class FrameHelp extends FrameTotal{
	private int width=750;
	private int height=450;
	private PanelHelp panelHelp;
	
	public FrameHelp(PlayerControl playerControl){
		this.panelHelp = new PanelHelp(playerControl);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//����ͨ�ش��ڵĴ�С��λ��
		int w = PanelHelp.WIDTH;
		int h = PanelHelp.HEIGHT;
		int x = (WINDOWW-w)/2+WINDOWX;
		int y = (WINDOWH-h)/2+WINDOWY;
		this.setSize(w, h);
		this.setLocation(x, y);
		
		this.setContentPane(panelHelp);
		//����Ϊ�����ƶ�
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
