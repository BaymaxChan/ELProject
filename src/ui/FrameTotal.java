package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import control.PlayerControl;
/**
 * �����ࣺ���н����ģ�壬����������������⣬��С��λ�õ���Ϣ
 * @author �����
 * 2015.4.8.
 * �Ķ���1�������С��Ϊ��Ļ��С��0.618����2��ȥ���˸߶ȡ���ȵľ�̬������3������̬����ȫ����д��by CX  2015.4.8
 * �Ķ����Ѵ�С��ʱ��Ϊ�̶���ֵ�� by CX 2015.4.15
 */

public abstract class FrameTotal extends JFrame{
	//TODO ����������
	protected static final String TITLE = "ELPrject";
	//Ŀ��ĵ�ַ���߶�
	private static final int WINDOW_UP = 16;
	//Frame��λ������
	protected static int WINDOWX;
	protected static int WINDOWY;
	//���ڴ�С
	public static final int WINDOWW = 1024;
	public static final int WINDOWH = 700;
	
	public FrameTotal(){
		//���ñ���������
		this.setTitle(TITLE);
		
		//���ò��ɸı��С�Լ��رպ�ֹͣ����
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������Ϊ�˴�ӡ����Ļ�м�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();  
		//����JFrame��С����ʱ�ô��ڱ�����80%��ʾ
//		WINDOWW = (int)(screen.width*0.8);
//		WINDOWH = (int)(screen.height*0.8);
		this.setSize(WINDOWW, WINDOWH);   
		
		//������������ʾ��������
		WINDOWX = screen.width-this.getWidth()>>1;
		WINDOWY = (screen.height-this.getHeight()>>1)-WINDOW_UP;
		this.setLocation(WINDOWX, WINDOWY);
//		this.setUndecorated(true);
		//���ÿ�����ʾ
		this.setVisible(false);
	}
//	/**
//	 * ������������
//	 * @param playerControl	��ҿ�����
//	 */
//	public void addControl(PlayerControl playerControl){
//		this.playerControl = playerControl;
//	}
}
