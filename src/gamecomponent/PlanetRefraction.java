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
	private int lastLightX,lastLightY;
	private boolean lock=true;
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
		this.planetImg = this.getImageIcon("image/����/����3.png", 2 * radius,2 * radius);
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
				lastLightX = lightX;
				lastLightY = lightY;
				this.getLight(lightList.get(lightList.size() - 1));
				//
				if (checkDistance(this.locationX + radius, this.locationY
						+ radius, this.lightX, this.lightY, this.radius)) {
					//
					this.gameData.getLightControl().stopLight(
							lightList.get(lightList.size() - 1));
					//
					Point touch = getTouch(this.locationX + radius, locationY
							+ radius, lightX, lightY, radius, directX, directY);
//					System.out.println((this.locationX + radius) + "   "
//							+ (locationY + radius));
					Point[] launchData = getAll(touch, locationX + radius,
							locationY + radius, directX, directY, radius);

					// System.out.println(launchData[0]);
					// System.out.println(launchData[1]);
					this.gameData.getLightControl().launchLight(
							launchData[0].x, launchData[0].y, launchData[1].x,
							launchData[1].y);
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
		if(directX==0){
			double y=Math.pow((radius*radius-Math.pow(centerX-lightX, 2)), 0.5);
			if(lastLightY>centerY)
				return new Point(lightX,centerY+(int)y);
			else
				return new Point(lightX,centerY-(int)y);
		}
		//
		if(directY==0){
			double x=Math.pow((radius*radius-Math.pow(centerY-lightY, 2)), 0.5);
			if(lastLightX>centerX)
				return new Point(centerX+(int)x,lightY);
			else
				return new Point(centerX-(int)x,lightY);
		}
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
		if(answer.equals(new Point (0,0))||radius-answer.distance(centerX, centerY)>4)
			answer=this.binarySearch(new Point(lastLightX,lastLightY),new Point(lightX,lightY), 0);
		//
		return answer;
	}
	
	/**
	 * ��ȡ�¹��ߵ���������
	 * @param touch ���������򽻵�
	 * @param centerX ����Բ��x
	 * @param centerY ����Բ��y
	 * @param directX ���ߴ�������x
	 * @param directY ���ߴ�������y
	 * @param radius ����뾶
	 * @return ����Ϊ2��point���飬point[0]Ϊ�¹�����ʼ�㣬point[1]Ϊ�¹��ߴ�������
	 */
	private Point[] getAll(Point touch,int centerX,int centerY,double directX,double directY,int radius){
		Point[] answer=new Point[2];
		boolean clock;
		//
		double seita=Math.acos((directX*(centerX-touch.x)+directY*(centerY-touch.y))/
				Math.pow(((directX*directX+directY*directY)*((centerX-touch.x)*(centerX-touch.x)+(centerY-touch.y)*(centerY-touch.y))), 0.5));
		//
		double aerfa=Math.asin(Math.sin(seita)*0.6);
		//
		int instruction=getInstruction(touch, centerX, centerY);
//		System.out.println(instruction);
		//
		double derta=getDerta(touch, centerX, centerY, radius, instruction);
//		System.out.println("     "+derta);
		//
//		double centerDegree=Math.atan((touch.y-centerY)/(touch.x-centerX));
//		if(centerDegree<0)
//			centerDegree+=Math.PI;
//		System.out.println(centerDegree);
		//
//		double lightDegree=Math.atan(directY/directX);
//		if(lightDegree<0)
//			lightDegree+=Math.PI;
		//
		if(((centerX-touch.x)*directY-(centerY-touch.y)*directX)<0){
			derta+=Math.PI-2*aerfa;
			clock=true;
		}
		else{
			derta-=(Math.PI-2*aerfa);
			clock=false;
		}
		//
//		System.out.println(clock);
		//
		answer[0]=new Point((int)(centerX+radius*Math.cos(derta)),(int)(centerY+radius*Math.sin(derta)));
		if(Math.abs(touch.x-centerX)<3||Math.abs(touch.y-centerY)<3){
			answer[1]=new Point((int)directX,(int)directY);
			return answer;
		}
		double line=getDirection(answer[0], centerX, centerY, clock, seita);
		//
		answer[1]=finalCheck(answer[0], centerX, centerY, line);
		
		return answer;
	}
	/**
	 * ��ȡ��������һ������
	 * @param touch ����
	 * @param centerX ����Բ��x
	 * @param centerY ����Բ��y
	 * @return 1��2��3��4�ֱ����һ����������
	 */
	private int getInstruction(Point touch,int centerX,int centerY){
		int answer;
		if(touch.x>=centerX){
			if(touch.y>centerY)
				answer=1;
			else
				answer=4;
		}
		else{
			if(touch.y>=centerY)
				answer=2;
			else
				answer=3;
		}
		return answer;
	}
	//
	/**
	 * ��ý���ļ�����Ħ�ֵ����0~2��֮��
	 * @param touch ����
	 * @param centerX ����Բ��x
	 * @param centerY ����Բ��y
	 * @param radius ����뾶
	 * @param instruction ����
	 * @return �Ƕ�
	 */
	private double getDerta(Point touch,int centerX,int centerY,int radius,int instruction){
		double derta = Math.asin((touch.y - centerY) / (double) radius);
		if (instruction == 2)
			derta = Math.PI - derta;
		else if (instruction == 3)
			derta = Math.PI - derta;
		else if (instruction == 4)
			derta += Math.PI * 2;
		return derta;
	}
	/**
	 * ����¹��ߵķ���
	 * @param point
	 * @param centerX
	 * @param centerY
	 * @param clock 
	 * @param seita
	 * @return
	 */
	private double getDirection(Point point,int centerX,int centerY,boolean clock,double seita){
		double answer;
		answer=Math.asin((point.y-centerY)/(double)radius);
		if(answer<0)
			answer+=Math.PI;
		if(clock)
			answer+=seita;
		else
			answer-=seita;
		return answer;
	}
	/**
	 * �������ȡֵ
	 * @param point
	 * @param centerX
	 * @param centerY
	 * @param line
	 * @return
	 */
	private Point finalCheck(Point point,int centerX,int centerY,double line){
		Point answer;
		Point a=new Point(point.x+50,(int)(point.y+50*Math.tan(line)));
		Point b=new Point(point.x-50,(int)(point.y-50*Math.tan(line)));
		if(a.distance(centerX, centerY)>b.distance(centerX, centerY))
			answer=new Point(1000,(int)(1000*Math.tan(line)));
		else 
			answer=new Point(-1000,(int)(-1000*Math.tan(line)));
		return answer;
	}
	//
	private Point binarySearch(Point first,Point second,int times) {
		if(times>1000){
			System.out.println("times");
			return first;
		}
		else{
			Point half = new Point();
			half.setLocation(((first.x+second.x)/2),((first.y+second.y)/2));
			int distance=(int) half.distance(locationX + radius, locationY + radius);
			if (distance - radius > 1)
				return binarySearch(half, second,++times);
			else if (distance - radius < -1)
				return binarySearch(first, half,++times);
			else
				return half;
		}
		
	}
}