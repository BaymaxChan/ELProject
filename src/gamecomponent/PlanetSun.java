package gamecomponent;

import gamedata.GameData;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * ̫���࣬������ûʲô�����ģ�������һ���ؾ������
 * ���ǲ�ʡ�ӿ��ˣ���һ�Ժ������أ�
 * 2015.4.14
 * @author CX
 */
public class PlanetSun extends Planet implements Runnable{
	private boolean NOW = true;
	private boolean BEFORE = true;
	public int count = 0;

	/**
	 * ͬplanetearth��
	 * @param x sun��ˮƽ����
	 * @param y sun����ֱ����
	 * @param Radius sun�İ뾶��Ҫ��earth��һ��Ŷ~
	 */
	public PlanetSun(int x,int y,int Radius,int tag,GameData gameData){
		//����Ĳ�������
		this.locationX=x;
		this.locationY=y;
		this.radius=Radius;
		this.tag=tag;
		this.gameData = gameData;
		
		//���찴ť��ͼƬ���Զ�����
		this.planetImg=getImageIcon("image/����/����6.png", 2*radius,2*radius);
		this.setIcon(planetImg);
		//��ť��λ��
		this.setBounds(locationX, locationY, 2*radius, 2*radius);
		//���ò���ӡ���ε�����
		this.setContentAreaFilled(false);
		//���ò���ӡ�߿�
		this.setBorderPainted(false);
		//���ÿɼ�
		this.setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
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
				System.out.println(count);
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
		this.count  = 0;
	}

	public void initeCondition() {
		this.count = 0;
		NOW = true;
		BEFORE = true;
	}
}