/**
 * ��ʼ�����frame
 * ����ӱ���ͼƬ�Ͱ�ť���һ��塣
 */
package ui_start;

import java.awt.Container;
import javax.swing.*;

/**
 * @author DorA
 *
 * 2015��4��8������11:51:29
 */
public class FrameStartGame extends ui.JFrameTotal{
//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/bg1.png");
//ʵ����һ����ť���һ���
	private static PanelStartGame panelStartGame=new PanelStartGame();

	public FrameStartGame(){	
		//���뱳��ͼƬ���	
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,frameWidth,frameHeight);		
		this.getLayeredPane().add(background);
		//���밴ť���	
		Container cp=this.getContentPane();
		cp.add(panelStartGame);
		((JPanel)cp).setOpaque(false);
		
	}
	
	public static void main(String[]args){
		FrameStartGame frame=new FrameStartGame();
		


	}

//	//��ʼ���汳��ͼƬ
//		private ImageIcon bg=new ImageIcon("image/bg/bg1.png");
//	//ʵ����һ����ť���һ���
//		private PanelStartGame panelStartGame=new PanelStartGame();
//
//		public FrameStartGame(){
//			//���뱳��ͼƬ���	
//				JLabel background = new JLabel(bg);
//				background.setBounds(0,0,frameWidth, frameHeight);		
//				this.getLayeredPane().add(background);
//			//���밴ť���	
//				Container cp=this.getContentPane();
//				cp.add(panelStartGame);
//				((JPanel)cp).setOpaque(false);
//				
//				add(panelStartGame);
//			}
//		
//		public static void main(String[] args){
//			FrameStartGame f=new FrameStartGame();
//		}
}
