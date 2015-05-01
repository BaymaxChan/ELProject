
//package ui_game;
/**
 * ��������ΰ���ĸ��
 * ͼƬֻ���ȵ�ͼ��
 * @author CX
 *2015.4.13
 */
//=======
package gamecomponent;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import control.PlayerControl;

public class PlanetEarth extends Planet{
	/**
	 * ���췽����������򣬲���������õļ�����
	 * @param x �����ˮƽ����
	 * @param y �������ֱ����
	 * @param Radius ����İ뾶
	 * @author CX
	 */
	public static int lightX;
	public static int lightY;
	
	public PlanetEarth(int x,int y,int Radius){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		//���찴ť��ͼƬ���Զ�����
		this.planetImg=Planet.getImageIcon("image/����/����2.png", 2*radius, 2*radius);
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, 2*radius);
		//���ò����ƾ��ε�����
		this.setContentAreaFilled(false);
		//���ò����Ʊ߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
		//
		lightX=this.locationX+this.radius;
		lightY=this.locationY+this.radius;
	}
//	public static int getLightX(){
//		
//		return ;
//	}
//	public int getLightY(){
//		return this.locationY+this.radius;
//	}
}