package gamecomponent;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * TODO �в������ν�ͼƬ��б����
 * ���췽������������ͼƬ��ȡ���ȣ�����Ӧ����ͼƬ����Ϸ�����е���ʾ���ȣ��Ӷ����ֳ�����Ч��
 * @author �����
 * 2015.4.14.
 */
public class Light {
	/**
	 * �����������
	 * ���½Ǻ����Ͻ�����
	 */
	private int leftDownX;
	private int leftDownY;
	private int rightUpX;
	private int rightUpY;
	/**
	 * TODO ���뼤��ͼƬ(��ȱ)
	 */
//	private static Image IMG_LIGHT = new ImageIcon().getImage();
	/**
	 * �Ƿ��������
	 */
	private boolean canDeliver = false;
	
	/**
	 * ���캯��
	 * @param leftDownX ���½�X
	 * @param leftDownY ���½�Y
	 * @param rightUpX ���Ͻ�X
	 * @param rightUpY ���Ͻ�Y
	 *  @param g ����
	 */
	public Light(int leftDownX, int leftDownY, int rightUpX, int rightUpY){
		this.leftDownX = leftDownX;
		this.leftDownY = leftDownY;
		this.rightUpX = rightUpX;
		this.rightUpY = rightUpY;
		
		this.canDeliver = true;
	}
	/**
	 * ���ߴ���
	 * @return
	 */
	public void deliverLight(){
	
	}
	
	public boolean isCanDeliver() {
		return canDeliver;
	}
	
	/**
	 * ���ƹ���
	 * @param g ����
	 */
	private void paint(Graphics g){
		g.drawLine(leftDownX, leftDownY, rightUpX, rightUpY);
	}
}
