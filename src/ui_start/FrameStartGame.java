/**
 * ��ʼ�����frame������Ͷ������г��룬�ȴ�����˵�ɡ�
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
public class FrameStartGame extends JFrame{
//��ʼ���汳��ͼƬ
	private static ImageIcon bg=new ImageIcon("image/bg/bg1.png");
//ʵ����һ����ť���һ���
	private static PanelStartGame panelStartGame=new PanelStartGame();

	public FrameStartGame(){
		//���뱳��ͼƬ���	
			JLabel background = new JLabel(bg);
			background.setBounds(0,0,1000, 650);		
			this.getLayeredPane().add(background);
		//���밴ť���	
			Container cp=this.getContentPane();
			cp.add(panelStartGame);
			((JPanel)cp).setOpaque(false);
			
			this.setSize(1000,650);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
	
	public static void main(String[]args){
		FrameStartGame framestartgame=new FrameStartGame();
	}
		
}
