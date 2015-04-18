package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * �����ࣺ���н����ģ�壬����������������⣬��С��λ�õ���Ϣ
 * @author �����
 * 2015.4.8.
 * �Ķ���1�������С��Ϊ��Ļ��С��0.618����2��ȥ���˸߶ȡ���ȵľ�̬������3������̬����ȫ����д��by CX  2015.4.8
 * �Ķ����Ѵ�С��ʱ��Ϊ�̶���ֵ�� by CX 2015.4.15
 */

public abstract class JFrameTotal extends JFrame{
	//TODO ����������
	protected static final String TITLE = "ELPrject";
	//Ŀ��ĵ�ַ���߶�
	private static final int WINDOW_UP = 16;
	/**
	 * 
	 */
	public JFrameTotal(){
		
		//���ñ���������
		this.setTitle(TITLE);
		
		//���ò��ɸı��С�Լ��رպ�ֹͣ����
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������Ϊ�˴�ӡ����Ļ�м�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();  
		//����JFrame��С����ʱ����ֵ��ʾ
		this.setSize(1024, 768);   
		//������������ʾ��������
		int x = screen.width-this.getWidth()>>1;
		int y = (screen.height-this.getHeight()>>1)-WINDOW_UP;
		this.setLocation(x, y);
//		this.setUndecorated(true);
		//���ÿ�����ʾ
		this.setVisible(true);
	}
}
