package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * �����ࣺ���н����ģ�壬����������������⣬��С��λ�õ���Ϣ
 * @author �����
 * 2015.4.8.
 * �Ķ���1�������С��Ϊ��Ļ��С��0.618����2��ȥ���˸߶ȡ���ȵľ�̬������3������̬����ȫ����д��by CX  2015.4.8
 */

public abstract class JFrameTotal extends JFrame{
	//TODO ����������
	protected static final String TITLE = "ELPrject";
	/*//������
	private static final int frameWidth = 1162;
	//����߶�
	private static final int frameHeight = 654;*/
	//��ȥ��Ļ���������
	private static final int WINDOW_UP = 16;
	
	public JFrameTotal(){
		//���ñ���������
		this.setTitle(TITLE);
		
		//���ò��ɸı��С�Լ��رպ�ֹͣ����
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		//���ý����С
		this.setSize((int)(screen.width*0.618), (int)(screen.height*0.618));     //0.618�ǻƽ�ָ��
		//������������ʾ��������
		int x = screen.width-this.getWidth()>>1;
		int y = (screen.height-this.getHeight()>>1)-WINDOW_UP;
		this.setLocation(x, y);
		
		
		//���ÿ�����ʾ
		this.setVisible(true);
	}
}
