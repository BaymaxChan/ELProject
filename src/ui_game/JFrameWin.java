package ui_game;

import javax.swing.JFrame;

import ui.JFrameTotal;
/**
 * ͨ�ؽ���Ĵ���
 * @author �����
 * 20.5.4.24.
 */
public class JFrameWin extends JFrameTotal{
	JPanelWin panelWin;
	
	public JFrameWin(){
		panelWin = new JPanelWin();
		
		this.setTitle("ͨ�ؽ���");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//����ͨ�ش��ڵĴ�С��λ��
		int w = (int)(WINDOWW*0.4);
		int h = (int)(WINDOWH*0.4);
		int x = (WINDOWW-w)/2+WINDOWX;
		int y = (WINDOWH-h)/2+WINDOWY;
		this.setSize(w, h);
		this.setLocation(x, y);
		
		this.setContentPane(panelWin);
	}
}
