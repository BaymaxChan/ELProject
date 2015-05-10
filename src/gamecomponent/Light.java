package gamecomponent;

import java.awt.Graphics;
import java.awt.Image;
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
	 * ����ǰ���ķ��ٶ�
	 */
	private double SPEEDX;
	/**
	 * ͼƬƫ����
	 */
	private static final int PADDING = 7;
	/**
	 * 4������Ĺ���ͼƬ
	 */
	private static final Image LIGHT0 = new ImageIcon("image/componnet/����1.png").getImage();
	private static final Image LIGHT30 = new ImageIcon("image/componnet/����2.png").getImage();
	private static final Image LIGHT60 = new ImageIcon("image/componnet/����3.png").getImage();
	private static final Image LIGHT90 = new ImageIcon("image/componnet/����4.png").getImage();
	private static final Image LIGHT120 = new ImageIcon("image/componnet/����5.png").getImage();
	private static final Image LIGHT150 = new ImageIcon("image/componnet/����6.png").getImage();
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
	 * ����Ŀ�߱�,Ϊ��/��
	 */
	private double ratio;
	/**
	 * ͼƬ�Ŀ�߱ȣ�Ϊ��/��
	 */
	private double imgRatio;
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
			this.initImageX = LIGHT0.getWidth(null);
		}else if((this.directX==0)&&(this.directY<0)){
			this.initImageY = LIGHT90.getHeight(null);
		}else if((this.directX>0)&&(this.directY<0)&&(this.directX+this.directY>0)){
			this.initImageY = LIGHT150.getHeight(null);
		}else if((this.directX>0)&&(this.directY<0)&&(this.directX+this.directY<=0)){
			this.initImageY = LIGHT120.getHeight(null);
		}else if((this.directX<0)&&(this.directY>0)&&(this.directX+this.directY>=0)){
			this.initImageX = LIGHT120.getWidth(null);
		}else if((this.directX<0)&&(this.directY>0)&&(this.directX+this.directY<0)){
			this.initImageX = LIGHT150.getWidth(null);
		}else if((this.directX<0)&&(this.directY<0)&&this.directX<=this.directY){
			this.initImageX = LIGHT30.getWidth(null);
			this.initImageY = LIGHT30.getHeight(null);
		}else if((this.directX<0)&&(this.directY<0)&&this.directX>this.directY){
			this.initImageX = LIGHT60.getWidth(null);
			this.initImageY = LIGHT60.getHeight(null);
		}
		
		if(this.directX!=0){
			this.ratio = (double)this.directY/this.directX;
			double temp = Math.sqrt(this.directX*this.directX+this.directY*this.directY);
			SPEEDX = SPEED*this.directX/temp;
		}
		
		if(((this.directX>=this.directY)&&(this.directY>0))||((this.directX<=this.directY)&&(this.directY<0))){
			imgRatio = (double)LIGHT30.getHeight(null)/LIGHT30.getWidth(null);
		}else if(((this.directY>this.directX)&&(this.directX>0))||((this.directY<this.directX)&&(this.directX<0))){
			imgRatio = (double)LIGHT60.getHeight(null)/LIGHT60.getWidth(null);
		}else if(((this.directX<0)&&(this.directY+this.directX>=0))||((this.directX>0)&&(this.directX+this.directY<=0))){
			imgRatio = (double)LIGHT120.getHeight(null)/LIGHT120.getWidth(null);
		}else if(((this.directY>0)&&(this.directY+this.directX<0))||((this.directY<0)&&(this.directX+this.directY>0))){
			imgRatio = (double)LIGHT150.getHeight(null)/LIGHT150.getWidth(null);
		}
	}
	/**
	 * ���ߴ���
	 */
	public void deliverLight(){
		if(this.directX!=0){
			this.directX = this.directX+SPEEDX;
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
		//ˮƽ����
		if((this.directX>0)&&(this.directY==0)){
			g.drawImage(LIGHT0, this.launchX, this.launchY, this.launchX+(int)this.directX, this.launchY+PADDING, this.initImageX, this.initImageY, this.initImageX+(int)this.directX, this.initImageY+PADDING, null);
		}//ˮƽ����
		else if((this.directX<0)&&(this.directY==0)){
			g.drawImage(LIGHT0, this.launchX+(int)this.directX, this.launchY-PADDING, this.launchX, this.launchY, this.initImageX+(int)this.directX, this.initImageY, this.initImageX, this.initImageY+PADDING, null);
		}//��ֱ����
		else if((this.directX==0)&&(this.directY>0)){
			g.drawImage(LIGHT90, this.launchX-PADDING, this.launchY, this.launchX, this.launchY+(int)this.directY, this.initImageX, this.initImageY, this.initImageX+PADDING, this.initImageY+(int)this.directY, null);
		}//��ֱ����
		else if((this.directX==0)&&(this.directY<0)){
			g.drawImage(LIGHT90, this.launchX, this.launchY+(int)this.directY, this.launchX+PADDING, this.launchY, this.initImageX, this.initImageY+(int)this.directY, this.initImageX+PADDING, this.initImageY, null);
		}//ƫ���½��������ˮƽ��С�ڵ���45��
		else if((this.directX>0)&&(this.directY>0)&&(this.directX>=this.directY)){
			g.drawImage(LIGHT30, this.launchX, this.launchY, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.initImageX, this.initImageY, this.initImageX+(int)this.directX, this.initImageY+(int)(this.directX*this.imgRatio), null);
		}//ƫ���½��������ˮƽ�ߴ���45��
		else if((this.directX>0)&&(this.directY>0)&&(this.directX<this.directY)){
			g.drawImage(LIGHT60, this.launchX, this.launchY, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.initImageX, this.initImageY, this.initImageX+(int)this.directX, this.initImageY+(int)(this.directX*this.imgRatio), null);
		}//ƫ���Ͻ��������ˮƽ��С�ڵ���45��
		else if((this.directX<0)&&(this.directY<0)&&(this.directX<=this.directY)){
			g.drawImage(LIGHT30, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.launchX, this.launchY, this.initImageX+(int)this.directX, this.initImageY+(int)(this.directX*this.imgRatio), this.initImageX, this.initImageY, null);
		}//ƫ���Ͻ��������ˮƽ�ߴ���45��
		else if((this.directX<0)&&(this.directY<0)&&(this.directX>this.directY)){
			g.drawImage(LIGHT60, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.launchX, this.launchY, this.initImageX+(int)this.directX, this.initImageY+(int)(this.directX*this.imgRatio), this.initImageX, this.initImageY, null);
		}//ƫ���Ͻ��������ˮƽ�ߴ��ڵ���45��
		else if((this.directX>0)&&(this.directY<0)&&(this.directX+this.directY<=0)){
			g.drawImage(LIGHT120, this.launchX, this.launchY+(int)this.directY, this.launchX+(int)this.directX, this.launchY, this.initImageX, this.initImageY-(int)(this.directX*this.imgRatio), this.initImageX+(int)this.directX, this.initImageY, null);
		}//ƫ���Ͻ��������ˮƽ��С��45��
		else if((this.directX>0)&&(this.directY<0)&&(this.directX+this.directY>0)){
			g.drawImage(LIGHT150, this.launchX, this.launchY+(int)this.directY, this.launchX+(int)this.directX, this.launchY, this.initImageX, this.initImageY-(int)(this.directX*this.imgRatio), this.initImageX+(int)this.directX, this.initImageY, null);
		}//ƫ���½��������ˮƽ�ߴ��ڵ���45��
		else if((this.directX<0)&&(this.directY>0)&&(this.directX+this.directY>=0)){
			g.drawImage(LIGHT120, this.launchX+(int)this.directX, this.launchY, this.launchX, this.launchY+(int)this.directY, this.initImageX+(int)this.directX, this.initImageY, this.initImageX, this.initImageY-(int)(this.directX*this.imgRatio), null);
		}//ƫ���½��������ˮƽ��С��45��
		else if((this.directX<0)&&(this.directY>0)&&(this.directX+this.directY<0)){
			g.drawImage(LIGHT150, this.launchX+(int)this.directX, this.launchY, this.launchX, this.launchY+(int)this.directY, this.initImageX+(int)this.directX, this.initImageY, this.initImageX, this.initImageY-(int)(this.directX*this.imgRatio), null);
		}
	}
}