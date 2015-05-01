package gamecomponent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
/**
 * TODO ������������һΪ0ʱ�������δ���������ratio̫С��intת����Ϊ0���Լ����ص�λ̫������⣬ϣ������ͨ��double�����滭��
 * @author �����
 * 2015.4.14.
 */
public class Light {
	/**
	 * ����ǰ�����ٶ�
	 */
	private static int SPEED = 10;
	/**
	 * ͼƬƫ����
	 */
	private static final int PADDING = 7;
	/**
	 * 4������Ĺ���ͼƬ
	 */
	private static final Image HORIZON = new ImageIcon("image/componnet/Light.png").getImage();
	private static final Image PLUMB = new ImageIcon("image/componnet/Light2.png").getImage();
	private static final Image RIGHTUP = new ImageIcon("image/componnet/Light3.png").getImage();
	private static final Image RIGHTDOWN = new ImageIcon("image/componnet/Light4.png").getImage();
	/**
	 * ��ʼ����
	 * ��������
	 */
	private int launchX;
	private int launchY;
	private double directX;
	private double directY;
	/**
	 * ���߾�ͷ����
	 */
	private int endX;
	private int endY;
	/**
	 * ͼƬ�ϳ�ʼ�滭�����궥��
	 */
	private int initImageX = 0;
	private int initImageY = 0;
	/**
	 * ͼƬ�Ŀ�߱�,Ϊ��/��
	 */
	private double ratio;
	/**
	 * �Ƿ��������
	 */
	private boolean canDeliver = false;
	
	/**
	 * ���캯��
	 * @param launchX ���½�X
	 * @param launchY ���½�Y
	 * @param directX ��������X
	 * @param directY ��������Y
	 */
	public Light(int launchX, int launchY, double directX, double directY){
		this.launchX = launchX;
		this.launchY = launchY;
		this.directX = directX;
		this.directY = directY;
		
		this.canDeliver = true;
		
		if((this.directX<0)&&(this.directY==0)){
			this.initImageX = HORIZON.getWidth(null);
		}else if((this.directX==0)&&(this.directY<0)){
			this.initImageY = PLUMB.getHeight(null);
		}else if((this.directX>0)&&(this.directY<0)){
			this.initImageY = RIGHTUP.getHeight(null);
		}else if((this.directX<0)&&(this.directY>0)){
			this.initImageX = RIGHTUP.getWidth(null);
		}else if((this.directX<0)&&(this.directY<0)){
			this.initImageX = RIGHTDOWN.getWidth(null);
			this.initImageY = RIGHTDOWN.getHeight(null);
		}
		if(this.directX!=0){
			this.ratio = (double)this.directY/this.directX;
		}
	}
	/**
	 * ���ߴ���
	 */
	public void deliverLight(){
		if(this.directX>0){
			this.directX = this.directX+SPEED;
		} else if(this.directX<0){
			this.directX = this.directX-SPEED;
		}
		
		if(this.directX!=0){
			this.directY = this.directX*this.ratio;
		}else{
			if(this.directY>0){
				this.directY = this.directY+SPEED;
			} else if(this.directY<0){
				this.directY = this.directY-SPEED;
			}
		}
		
		//��¼���߾�ͷ����
		this.endX = this.launchX+(int)this.directX;
		this.endY = this.launchY+(int)this.directY;
	}
	//�ù����Ƿ��ܹ���������
	public boolean isCanDeliver() {
		return canDeliver;
	}
	//ֹͣ���ߴ���
	public void stopDeliver(){
		this.canDeliver = false;
	}
	public int getEndX() {
		return endX;
	}
	public int getEndY() {
		return endY;
	}
	
	public double getDirectX() {
		return directX;
	}
	public double getDirectY() {
		return directY;
	}
	/**
	 * ���ƹ���
	 * ���ƹ���
	 * @param g ����
	 */
	public void paint(Graphics g){
		if((this.directX>0)&&(this.directY==0)){
			g.drawImage(HORIZON, this.launchX, this.launchY, this.launchX+(int)this.directX, this.launchY+PADDING, this.initImageX, this.initImageY, this.initImageX+(int)this.directX, this.initImageY+PADDING, null);
		}else if((this.directX<0)&&(this.directY==0)){
			g.drawImage(HORIZON, this.launchX+(int)this.directX, this.launchY-PADDING, this.launchX, this.launchY, this.initImageX+(int)this.directX, this.initImageY, this.initImageX, this.initImageY+PADDING, null);
		}else if((this.directX==0)&&(this.directY>0)){
			g.drawImage(PLUMB, this.launchX-PADDING, this.launchY, this.launchX, this.launchY+(int)this.directY, this.initImageX, this.initImageY, this.initImageX+PADDING, this.initImageY+(int)this.directY, null);
		}else if((this.directX==0)&&(this.directY<0)){
			g.drawImage(PLUMB, this.launchX, this.launchY+(int)this.directY, this.launchX+PADDING, this.launchY, this.initImageX, this.initImageY+(int)this.directY, this.initImageX+PADDING, this.initImageY, null);
		}else if((this.directX>0)&&(this.directY>0)){
			g.drawImage(RIGHTDOWN, this.launchX, this.launchY, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.initImageX, this.initImageY, this.initImageX+(int)this.directX, this.initImageY+(int)this.directX, null);
		}else if((this.directX<0)&&(this.directY<0)){
			g.drawImage(RIGHTDOWN, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.launchX, this.launchY, this.initImageX+(int)this.directX, this.initImageY+(int)this.directY, this.initImageX, this.initImageY, null);
		}else if((this.directX>0)&&(this.directY<0)){
			g.drawImage(RIGHTUP, this.launchX, this.launchY+(int)this.directY, this.launchX+(int)this.directX, this.launchY, this.initImageX, this.initImageY+(int)this.directY, this.initImageX+(int)this.directX, this.initImageY, null);
		}else if((this.directX<0)&&(this.directY>0)){
			g.drawImage(RIGHTUP, this.launchX+(int)this.directX, this.launchY, this.launchX, this.launchY+(int)this.directY, this.initImageX+(int)this.directX, this.initImageY, this.initImageX, this.initImageY+(int)this.directY, null);
		}
	}
}