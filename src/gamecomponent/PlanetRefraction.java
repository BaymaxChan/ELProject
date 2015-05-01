package gamecomponent;

import java.awt.Point;
import java.util.ArrayList;

import gamedata.GameData;
/**
 * ��������    2015.5.1
 * @author CXWorks
 *
 */
public class PlanetRefraction extends Planet implements Runnable {
	//ҲҪ��gameData��ȡ����
	private GameData gameData; 
	/**
	 * �������������
	 * @param x x����
	 * @param y y����
	 * @param Radius ����뾶
	 * @param gameDAta ���뵼��gameData����ȡ����
	 */
	public PlanetRefraction(int x,int y,int Radius,GameData gameDAta){
		// ����Ĳ�������
		this.locationX = x;
		this.locationY = y;
		this.radius = Radius;
		this.gameData=gameDAta;
		// ���찴ť��ͼƬ���Զ�����
		this.planetImg = this.getImageIcon("image/����/����1.png", 2 * radius,2 * radius);
		this.setIcon(planetImg);
		// ��ť��λ��
		this.setBounds(locationX, locationY, 2 * radius, 2 * radius);
		// ���ò����ƾ��ε�����
		this.setContentAreaFilled(false);
		// ���ò����Ʊ߿�
		this.setBorderPainted(false);
		// ���ÿɼ�
		this.setVisible(true);
		//�½�����ʼ�����߳�
		Thread t=new Thread(this);
		t.start();
		
	}
	/**
	 * ��ʼ��⡢������߳�
	 */
	public void run(){
		while (true) {
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO
			}
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			if (!lightList.isEmpty()) {
				for (int i = 1; i <= lightList.size(); i++) {
					//
					this.getLight(lightList.get(lightList.size() - 1));
					//
					if(checkDistance(this.locationX,this.locationY,this.lightX,this.lightY,this.radius)){
						//
						Point touch=getTouch(this.locationX+radius, locationY+radius, lightX, lightY, radius, directX, directY);
						Point[] launchData=getAll(touch, locationX+radius, locationY+radius, radius, directX, directY);
					}
				}

			}
		}
	}
	//
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
		int answer=(int) (radius-Point.distance(centerX, centerY, lightX, lightY));
		return (answer>-1);
	}
	/**
	 * ���ڼ������������Ľ���
	 * @param centerX �������ĵ�x����
	 * @param centerY �������ĵ�y����
	 * @param lightX ���߶����x����
	 * @param lightY ���߶����y����
	 * @param radius ����뾶
	 * @param directX ����x���������
	 * @param directY ����y���������
	 * @return Point���͵Ľ���
	 */
	private Point getTouch(int centerX,int centerY,int lightX,int lightY,int radius,double directX,double directY){
		Point answer = null;
		double x,y;
		//
		double a=1+Math.pow(directY, 2)/Math.pow(directX, 2);
		double b=2*directY*lightY/directX-2*Math.pow(directY, 2)*lightX/Math.pow(directX, 2)
				-2*centerY*directY/directX-2*centerX;
		double c=centerX*centerX+lightY*lightY-2*directY*lightX*lightY/directX-2*centerY*lightY+2*centerY*lightX*directY/directX
				+Math.pow(directY*lightX/directX, 2)+centerY*centerY-radius*radius;
		
		if(directX>=0)
			x=(-b-Math.pow(b*b-4*a*c, 0.5))/(2*a);
		else
			x=(-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
		y=directY*x/directX+lightY-directY*lightX/directX;

		answer=new Point((int)x,(int)y);
		//
		return answer;
	}
	/**
	 * ��ȡ�¹��ߵ���������
	 * @param touch ԭ������Բ�ĽӴ���
	 * @param centerX Բ��x����
	 * @param centerY Բ��y����
	 * @param radius �뾶
	 * @param directX ԭ���ߴ�����x����
	 * @param directY ԭ���ߴ�����y����
	 * @return ����Ϊ����Point���飬point[0]��Ϊ�¹��ߵ���ʼ�㣬point[1]��Ϊ�¹��ߵķ���
	 */
	private Point[] getAll(Point touch,int centerX,int centerY,int radius,double directX,double directY){
		Point[] answer=null;
		//�����������x����н�
		double beita=getDegreeWithX(centerX-touch.x, centerY-touch.y);
		double seita=getDegreeSpecial(touch, centerX, centerY, directX, directY);
		double aerfa=Math.sin((Math.sin(seita)*0.8));
		double gama=Math.PI+beita-2*aerfa;
		double check=Math.PI-2*aerfa;
		//
		Point a=new Point((int)(centerX+radius*Math.cos(gama)),(int)(centerY+radius*Math.cos(gama)));
		Point b=new Point((int)(centerX-radius*Math.cos(gama)),(int)(centerY-radius*Math.cos(gama)));
		if((getDegreeSpecial(touch, centerX, centerY, centerX-a.x, directY-a.y)-check)<(getDegreeSpecial(touch, centerX, centerY, centerX-b.x, centerY-b.y))){
			answer[0]=a;
			answer[1]=new Point(a.x-centerX,a.y-centerY);
		}
		else{
			answer[0]=b;
			answer[1]=new Point(b.x-centerX,b.y-centerY);
		}
		return answer;
	}
	/**
	 * һ�������Եķ�������ù�����x������ļн�
	 * @param x ���ߴ�����x����
	 * @param y ���ߴ�����y����
	 * @return double�ļн�ֵ
	 */
	private double getDegreeWithX(double x,double y){
		double answer;
		answer=Math.atan(y/x);
		if(answer<0)
			answer+=Math.PI;
		return answer;
	}
	/**
	 * ����ָ�������������ļн�
	 * @param touch ����A����ʼ��
	 * @param centerX ����A����ֹ���x����
	 * @param centerY ����A����ֹ���y����
	 * @param directX ����B��x����
	 * @param directY ����B��y����
	 * @return double�ĽǶȣ���0~��֮��
	 */
	private double getDegreeSpecial(Point touch,int centerX,int centerY,double directX,double directY){
		double answer;
		touch.setLocation(centerX-touch.x, centerY-touch.y);
		answer=Math.acos((touch.x*directX+touch.y*directY)/Math.pow(((directX*directX+directY*directY)*(touch.x*touch.x+touch.y*touch.y)), 0.5));
		return answer;
	}
	//

}
