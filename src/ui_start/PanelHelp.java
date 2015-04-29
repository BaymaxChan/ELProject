/**
 * 
 */
package ui_start;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.FrameTotal;

/**
 * @author DorA
 *
 * 2015��4��29������7:03:07
 */
public class PanelHelp extends JPanel{
	
	private int panelWidth=750;
	private int panelHeight=450;
	private int frameWidth=1024;
	private int frameHeight=700;
	
	private final PanelHelp p=this;
	
	public PanelHelp(){
		
		
		setLayout(null);
		this.setBounds((int)(frameWidth/2-panelWidth/2),(int)(frameHeight/2-panelHeight/2),panelWidth,panelHeight);
		
		CloseButton jbtClose=new CloseButton();
	//	jbtClose.addActionListener(PlayerControl);
		add(new CloseButton());
		

	}
	
	//�رհ�ť���ڲ���
	class CloseButton extends JButton{
		//��ť��С
		private int w=30;
		private int h=30;
		//���㰴ť��λ������
		private int x=(int)(panelWidth/2+frameWidth/2-w/2);
		private int y=(int)(frameHeight/2-panelHeight/2-h/2);
			
		public CloseButton(){
			super();
			this.setBounds(x,y,30,30);
		}
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect((int)(frameWidth/2-panelWidth/2),(int)(frameHeight/2-panelHeight/2),panelWidth,panelHeight);	
	}
}
