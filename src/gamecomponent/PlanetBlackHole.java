package gamecomponent;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gamedata.GameData;

public class PlanetBlackHole extends Planet implements Runnable{
	private GameData gameData;
	public PlanetBlackHole(int x,int y,int Radius,GameData gameData){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		this.gameData=gameData;

		//���찴ť��ͼƬ���Զ�����
//		Image temp=new Image().
		this.planetImg=getImageIcon("image/����/����6.png", 2*radius, 2*radius);
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, 2*radius);
		//���ò���ӡ���ε�����
		this.setContentAreaFilled(false);
		//���ò���ӡ�߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
		
		Thread t=new Thread(this);
		t.start();
	}

	public void run() {
		while(true){
			try{
				Thread.sleep(25);
			}
			catch(Exception e){
				System.out.println("CXWorks   ��PlanetBlackHole�߳��׳�");
			}

			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();

			if(!lightList.isEmpty()){
				this.getLight(lightList.get(lightList.size() - 1));
				if(checkDistance(locationX, locationY, lightX, lightY, radius)){
					GAMECONTINUE=false;
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
}
