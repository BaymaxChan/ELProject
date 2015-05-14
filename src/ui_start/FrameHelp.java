package ui_start;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import control.PlayerControl;
import ui.FrameTotal;

public class FrameHelp extends JFrame{
	private PanelHelp panelHelp;
	
	public FrameHelp(PlayerControl playerControl){
		this.panelHelp = new PanelHelp(playerControl);
		
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
		this.setContentPane(panelHelp);
		//���ָ��
		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("image/cursor/Arrow.png"), new Point(0, 0),"Slef"));
		//����Ϊ�����ƶ�
		this.setLocationRelativeTo(null);
//		//��������ΪԲ��
//		this.addComponentListener(new ComponentAdapter() {
//            public void componentResized(ComponentEvent e) {
//                setShape(new Ellipse2D.Double((w-h)/2,0,h,h));
//            }
//        });
		
		this.setVisible(true);
	}
}