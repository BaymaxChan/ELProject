package gamecomponent;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * �����ࣺ���򣬰���λ�ã��뾶��ͼƬ�Ȳ���
 * �޸�1���ɴ������̳�jbutton���ˣ�Ҫ��Ȼjavaֻ�ܼ̳�һ����button���ԾͲ��������ˣ� by CX 2015.4.13
 * �޸�2��1����ԭ����image��Ϊimageicon�ˣ�2��������һ������  by CX 2015.4.15
 * @author �����
 * 2015.4.8.
 */

public abstract class Planet extends JButton {
	
	private static final long serialVersionUID = 1L;
	//Բ��λ������
	protected int locationX;
	protected int locationY;
	//�뾶
	protected int radius;
	//ͼƬ
	protected ImageIcon planetImg;
	//��������
	protected int lightX;
	protected int lightY;
	
	/**
	 * ��ͼƬ���ŵ�ָ����ʽ
	 * @author CX
	 * @param filename·����
	 * @param width�����Ŀ��
	 * @param height�����ĸ߶�
	 * @return ���ź��ͼ��Ϊimageicon��ʽ
	 */
	public static ImageIcon getImageIcon(String filename,int width,int height){
		ImageIcon temp=new ImageIcon(filename);
		Image alsoTemp=temp.getImage();
		alsoTemp=alsoTemp.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
		temp.setImage(alsoTemp);
		return temp;
	}
	
	public void getLight(Light light){
		this.lightX = light.getEndX();
		this.lightY = light.getEndY();
	}
}
	
