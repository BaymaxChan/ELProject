package gamecomponent;

import java.awt.Point;
import java.util.ArrayList;

import gamedata.GameData;

/**
 * ��������   2015.5.1
 * @author CXWorks
 * 
 */
public class PlanetReflection extends Planet implements Runnable {
	//Ҫ��gameData��ȡ����
	private GameData gameData;
	/**
	 * ���췴�������
	 * @param x x����
	 * @param y y����
	 * @param Radius ����뾶
	 * @param gameData ���뵼��gameData����ȡ����
	 */
	public PlanetReflection(int x,int y,int Radius,GameData gameData){
		// ����Ĳ�������
		this.locationX = x;
		this.locationY = y;
		this.radius = Radius;
		this.gameData=gameData;
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
		//��ʼ��������߳�
		Thread t=new Thread(this);
		t.start();
		
	}
	/**
	 * ��⡢������߳�
	 */
	public void run(){
		while (true) {
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO
			}
//			System.out.println("aaa");
			//��ȡ��ǰ���й���
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			
			if (!lightList.isEmpty()) {
				this.getLight(lightList.get(lightList.size() - 1));
				// ����Ƿ����Ӵ�
				if (checkDistance(locationX, locationY, lightX, lightY, radius)) {
					
					// ��ù�����Բ�Ľ��㣬ͬʱҲ���¹��ߵ���ʼ��
					Point location = getLocation(locationX + radius, locationY
							+ radius, lightX, lightY, radius - 2, directY,
							directX);
//					System.out.println("bbb"+location);
					// ����¹��ߵķ���
					Point direct = getDirection(locationX + radius, locationY
							+ radius, directX, directY, location.x, location.y);
					// TODO finish it
					// System.out.println(location);
					if(location.equals(new Point(0,0))){
						
					}
					else{
						// ��֮ǰ�Ĺ���ֹͣ
						this.gameData.getLightControl().stopLight(
								lightList.get(lightList.size() - 1));
						this.gameData.getLightControl().launchLight(location.x,
							location.y, direct.x, direct.y);
					}
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
	//
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
	private Point getLocation(int centerX,int centerY,int lightX,int lightY,int radius,double directX,double directY){
		Point answer = null;
		double x,y;
		//
		double a=1+Math.pow(directY, 2)/Math.pow(directX, 2);
		double b=2*directY*lightY/directX-2*Math.pow(directY, 2)*lightX/Math.pow(directX, 2)
				-2*centerY*directY/directX-2*centerX;
		double c=centerX*centerX+lightY*lightY-2*directY*lightX*lightY/directX-2*centerY*lightY+2*centerY*lightX*directY/directX
				+Math.pow(directY*lightX/directX, 2)+centerY*centerY-radius*radius;
//		System.out.println(lightX+" "+lightY);
//		System.out.println(directX+" "+directY);
//		System.out.println(centerX+" "+centerY);
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
	 * ���ڼ����¹��ߵķ���
	 * @param centerX Բ�ĵ�x����
	 * @param centerY Բ�ĵ�y����
	 * @param directX ԭ���ߵĴ��������xֵ
	 * @param directY ԭ���ߵĴ��������yֵ
	 * @param intersectionX ������Բ�Ľ���x����
	 * @param intersectionY ������Բ�Ľ���y����
	 * @return Point���ͣ�Ϊ�¹��ߵķ���
	 */
	private Point getDirection(int centerX,int centerY,double directX,double directY,int intersectionX,int intersectionY){
		Point answer=null;
		double sita=getDegreeWithX(centerX-intersectionX, centerY-intersectionY);
		double aerfa=getDegreeWithX(directX, directY);
		double beita=2*sita-aerfa;
		if(beita<0)
			beita+=Math.PI;
//		System.out.println(aerfa+" "+beita);
		//
		Point a=new Point(intersectionX+50,(int)(intersectionY+50*Math.tan(beita)));
		Point b=new Point(intersectionX-50,(int)(intersectionY-50*Math.tan(beita)));
		if(a.distance(centerX, centerY)>b.distance(centerX, centerY))
			answer=new Point(1000,(int)(1000*Math.tan(beita)));
		else 
			answer=new Point(-1000,(int)(-1000*Math.tan(beita)));
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
}