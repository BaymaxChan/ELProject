/**
 * ��ʼ�����frame������Ͷ������г��룬�ȴ�����˵�ɡ�
 * ����ӱ���ͼƬ�Ͱ�ť���һ��塣
 */
package ui;

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
	}
	
	public static void main(String[]args){
		FrameStartGame frame=new FrameStartGame();
		
	//���뱳��ͼƬ���	
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,1000, 650);		
		frame.getLayeredPane().add(background);
	//���밴ť���	
		Container cp=frame.getContentPane();
		cp.add(panelStartGame);
		((JPanel)cp).setOpaque(false);
		
		frame.setSize(1000,650);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
