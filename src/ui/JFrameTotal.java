package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * �����ࣺ���н����ģ�壬����������������⣬��С��λ�õ���Ϣ
 * @author �����
 * 2015.4.8.
 */

public abstract class JFrameTotal extends JFrame{
	//TODO ����������
	protected static final String title = "ELPrject";
	//������
	private static final int frameWidth = 1162;
	//����߶�
	private static final int frameHeight = 654;
	//��ȥ��Ļ���������
	private static final int windowUp = 16;
	
	public JFrameTotal(){
		//���ñ���������
		this.setTitle(title);
		//���ý����С
		this.setSize(frameWidth, frameHeight);
		//���ò��ɸı��С�Լ��رպ�ֹͣ����
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������������ʾ��������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width-this.getWidth()>>1;
		int y = (screen.height-this.getHeight()>>1)-windowUp;
		this.setLocation(x, y);
		
		//���ÿ�����ʾ
		this.setVisible(true);
	}
}
