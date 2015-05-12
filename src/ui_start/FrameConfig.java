package ui_start;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ui.FrameTotal;
import control.PlayerControl;

public class FrameConfig extends JFrame{
	private PanelConfig panelConfig;
	
	public FrameConfig(PlayerControl playerControl){
		this.panelConfig = new PanelConfig(playerControl);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//����ͨ�ش��ڵĴ�С��λ��
		int w = PanelHelp.WIDTH;
		int h = PanelHelp.HEIGHT;
		int x = (FrameTotal.WINDOWW-w)/2+FrameTotal.WINDOWX;
		int y = (FrameTotal.WINDOWH-h)/2+FrameTotal.WINDOWY;
		this.setSize(w, h);
		this.setLocation(x, y);
		this.setUndecorated(true);
		this.setContentPane(panelConfig);
		//���ָ��
		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("image/cursor/cur.png"), new Point(0, 0),"Slef"));
		//����Ϊ�����ƶ�
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
