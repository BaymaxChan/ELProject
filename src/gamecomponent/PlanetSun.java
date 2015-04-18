package gamecomponent;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ̫���࣬������ûʲô�����ģ�������һ���ؾ������
 * ���ǲ�ʡ�ӿ��ˣ���һ�Ժ������أ�
 * 2015.4.14
 * @author CX
 *
 */
public class PlanetSun extends Planet {
	/**
	 * ͬplanetearth��
	 * @param x sun��ˮƽ����
	 * @param y sun����ֱ����
	 * @param Radius sun�İ뾶��Ҫ��earth��һ��Ŷ~
	 */
	public PlanetSun(int x,int y,int Radius){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		//���찴ť��ͼƬ���Զ�����
		this.planetImg=this.getImageIcon("image/����/����6.png", 2*radius,2*radius);
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, 2*radius);
		//���ò���ӡ���ε�����
		this.setContentAreaFilled(false);
		//���ò���ӡ�߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
	}

	

}
