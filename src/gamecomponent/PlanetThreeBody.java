package gamecomponent;

import gamedata.GameData;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PlanetThreeBody extends Planet {
	/**�����ࣻ�����յĽ��ܵ㣬��Ҫlight���֧��
	 * ͬplanetearth��
	 * @param x sun��ˮƽ����
	 * @param y sun����ֱ����
	 * @param Radius sun�İ뾶��
	 */
	public PlanetThreeBody(int x,int y,int Radius,int tag,GameData gameData){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		this.tag=tag;
		//���찴ť��ͼƬ���Զ�����
		this.planetImg=getImageIcon("image/����/santi.png", 2*radius,2*radius);
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius,2*radius);
		//���ò���ӡ��������
		this.setContentAreaFilled(false);
		//���ò���ӡ�߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);	
	}

	/**
	 * �����ߵִ�ʱȡ�����߿������Լ����й���
	 */
	public void stopLight(LightControl lightControl){
		//�õ�������
		int distanceX = this.locationX+this.radius-this.lightX;
		int distanceY = this.locationY+this.radius-this.lightY;
		double distance = Math.sqrt((double)(distanceX*distanceX+distanceY*distanceY));
		
		if(distance<(double)this.radius){
			lightControl.deleteLights();
		}
	}
}