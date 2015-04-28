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
	 * TODO ���ú�ɫ����ͼ
	 */
	private static final Image INITIMAGE = new ImageIcon("image/componnet/Light.png").getImage();
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
	 * ��ת����ߵ�ͼƬ
	 */
	private Image lightImage;
	/**
	 * ��ת��ͼƬ�ĳ���
	 */
	private int lightImage_W;
	private int lightImage_H;
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
		
		this.lightImage = this.Rotate(INITIMAGE, this.directX, this.directY);
		
		this.lightImage_W = this.lightImage.getWidth(null);
		this.lightImage_H = this.lightImage.getHeight(null);
		
		this.ratio = (double)this.lightImage_H/this.lightImage_W;
	}
	/**
	 * ���ߴ���
	 */
	public void deliverLight(){
		if(this.directX>0){
			this.directX = this.directX+this.SPEED;
		} else if(this.directX<0){
			this.directX = this.directX-this.SPEED;
		}
		
		if(this.directY>0){
			this.directY = this.directY+this.SPEED*this.ratio;
		} else if(this.directY<0){
			this.directY = this.directY-this.SPEED*this.ratio;
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
	/**
	 * TODO 1������̫С
	 * ���ƹ���
	 * @param g ����
	 */
	public void paint(Graphics g){
		//���ݲ�ͬ����ķ��������Բ�ͬ��������Ƽ���
		if((this.directX>=0)&&(this.directY>=0)){
			g.drawImage(lightImage, this.launchX, this.launchY, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.initImageX, this.initImageY, this.initImageX+(int)this.directX, this.initImageY+(int)this.directY, null);
		} else if((this.directX>=0)&&(this.directY<0)){
			g.drawImage(lightImage, this.launchX, this.launchY+(int)this.directY, this.launchX+(int)this.directX, this.launchY, this.initImageX, this.initImageY+(int)this.directY, this.initImageX+(int)this.directX, this.initImageY, null);
		} else if((this.directX<0)&&(this.directY<0)){
			g.drawImage(lightImage, this.launchX+(int)this.directX, this.launchY+(int)this.directY, this.launchX, this.launchY, this.initImageX+(int)this.directX, this.initImageY+(int)this.directY, this.initImageX, this.initImageY, null);
		} else if((this.directX<0)&&(this.directY>=0)){
			g.drawImage(lightImage, this.launchX+(int)this.directX, this.launchY, this.launchX, this.launchY+(int)this.directY, this.initImageX+(int)this.directX, this.initImageY, this.initImageX, this.initImageY+(int)this.directY, null);
		}
	}
	
	/**
	 * ��ͼƬ���ݴ��뷽�������Ƕ���ת
	 * @param src ��Ҫ��ת��ͼƬ
	 * @param directX ��������X
	 * @param directY ��������Y
	 * @return
	 */
	private BufferedImage Rotate(Image src, double directX,  double directY){
		double angel;
		//���ǵ�X��Y����Ϊ0�����
		if((directX>0)&&(directY==0)){
			angel = 0.0;
		} else if((directX<0)&&(directY==0)){
			angel = 180.0;
		} else if((directX==0)&&(directY>0)){
			angel = 90.0;
		}else if((directX==0)&&(directY<0)){
			angel = 270.0;
		}else{
			angel = Math.toDegrees(Math.atan(directY/directX));
		}
		
		
		int src_width = src.getWidth(null);
		int src_height = src.getHeight(null);
		//������ͼƬ��С
		Rectangle rect_des = this.CalcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);
		
		BufferedImage res = null;
		res = new BufferedImage(rect_des.width, rect_des.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = res.createGraphics();
		//ת��
		g2.translate((rect_des.width-src_width)/2, (rect_des.height-src_height)/2);
		g2.rotate(Math.toRadians(angel), src_width/2, src_height/2);
		
		g2.drawImage(src, null, null);
		return res;
	}
	
	private Rectangle CalcRotatedSize(Rectangle src, double angel){
		//����Ƕ�С��0�ȣ���Ҫ����ת��
		if(angel<0){
			angel = angel+360;
		}
		//����Ƕȴ���90�ȣ���Ҫ����ת��
		if(angel>=90){
			if(angel/90%2==1){
				int temp = src.height;
				src.height = src.width;
				src.width = temp;
			}
			angel = angel%90;
		}
//		System.out.println(angel);
		//�뾶r
		double r = Math.sqrt(src.height*src.height+src.width*src.width)/2;
		double len = 2*Math.sin(Math.toRadians(angel)/2)*r;
		double angel_alpha = (Math.PI-Math.toRadians(angel))/2;
		double angel_dalta_width = Math.atan((double)src.height/src.width);
		double angel_dalta_height = Math.atan((double)src.width/src.height);
		
		int len_dalta_width = (int)(len*Math.cos(Math.PI-angel_alpha-angel_dalta_width));
		int len_dalta_height = (int)(len*Math.cos(Math.PI-angel_alpha-angel_dalta_height));
		
		int des_width = src.width+len_dalta_width*2;
		int des_height = src.height+len_dalta_height*2;
		
		return new java.awt.Rectangle(new Dimension(des_width, des_height));
	}
}
