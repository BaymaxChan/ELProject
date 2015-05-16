
//package ui_game;
/**
 * ��������ΰ���ĸ��
 * ͼƬֻ���ȵ�ͼ��
 * @author CX
 *2015.4.13
 */
//=======
package gamecomponent;

import gamedata.GameData;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import control.PlayerControl;

public class PlanetEarth extends Planet implements Runnable{
	/**
	 * ���췽����������򣬲���������õļ�����
	 * @param x �����ˮƽ����
	 * @param y �������ֱ����
	 * @param Radius ����İ뾶
	 * @author CX
	 */
	public static int launchX;
	public static int launchY;
	private Image[] image=new Image[51];
	private byte a=9,b=0;
	
	private boolean NOW = true;
	private boolean BEFORE = true;
	public int count = 0;
	
	public PlanetEarth(int x,int y,int Radius, int tag, GameData gameData){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		this.tag = tag;
		this.gameData=gameData;
		
		//���찴ť��ͼƬ���Զ�����
		for(;a<60;a++,b++){
			image[b]=Planet.getImageIcon("image/�����˶�/����/����000"+Byte.toString(a)+".png", 2*radius, 2*radius).getImage();
		}
		this.a=0;
		this.b=0;
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, 2*radius);
		//���ò����ƾ��ε�����
		this.setContentAreaFilled(false);
		//���ò����Ʊ߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
		//���߳�ʼ����
		launchX=this.locationX+this.radius;
		launchY=this.locationY+this.radius;
		
		Thread t=new Thread(this);
		t.start();
	}
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image[a], 0, 0, null);
		b++;
		if(b>5){
			a++;
			if(a>50)
				a=0;
			b=0;
		}
	}

	public void run() {
		while(true){
			try{
				Thread.sleep(25);
			}
			catch(Exception e){
			}

			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			if(!lightList.isEmpty()){
				this.getLight(lightList.get(lightList.size() - 1));
				if(checkDistance(locationX, locationY, lightX, lightY, radius)){
					NOW = false;
					if(NOW != BEFORE){
						count++;
						BEFORE = NOW;
					}
				}else{
					NOW = true;
					if(NOW != BEFORE){
						count++;
						BEFORE = NOW;
					}
				}
				if(count == 3){
					GAMECONTINUE = false;
				}
			}
		}		
	}

	/**
	 * ���ڼ����߶���������ľ��룬�ж��Ƿ�Ӵ�
	 * @param centerX ����ť���ĵ�x���꣬����locationX+radius
	 * @param centerY ����ť���ĵ�y���꣬����locationY+radius
	 * @param lightX ���߶���x����
	 * @param lightY ���߶���y����
	 * @param radius ����뾶
	 * @return booleanֵ��true�������Ӵ���false����δ�����Ӵ�
	 */
	private boolean checkDistance(int centerX,int centerY,int lightX,int lightY,int radius){
		int answer=(int) (radius-Point.distance(centerX+radius, centerY+radius, lightX, lightY));
		return (answer>-1);
	}

	public void setCount() {
		
	}

	public void initeCondition() {
		this.count = 0;
		NOW = true;
		BEFORE = true;
	}
}