package gamecomponent;

import gamedata.GameData;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * ��������   2015.5.1
 * @author CXWorks
 * 
 */
public class PlanetReflection extends Planet implements Runnable {
	//Ҫ��gameData��ȡ����
	private GameData gameData;
	private int lastLightX,lastLightY;
	private boolean lock=true;
	private Image[] image=new Image[43];
	private byte a=16,b=0;
	/**
	 * ���췴�������
	 * @param x x����
	 * @param y y����
	 * @param Radius ����뾶
	 * @param gameData ���뵼��gameData����ȡ����
	 */
	public PlanetReflection(int x,int y,int Radius,int tag,GameData gameData){
		// ����Ĳ�������
		this.locationX = x;
		this.locationY = y;
		this.radius = Radius;
		this.virtualRadius=radius-1;
		this.tag=tag;
		this.gameData=gameData;
		// ���찴ť��ͼƬ���Զ�����
		for(;a<59;a++,b++){
			this.image[b] = getImageIcon("image/�����˶�/����/����000"+Byte.toString(a)+".png", 2 * radius,2 * radius).getImage();
		}
		this.a=0;
		this.b=0;
//		this.planetImg = new ImageIcon("image/����/MARS.gif");
//		Image previousImage = this.planetImg.getImage();
//		Image nowImage =previousImage.getScaledInstance(2 * radius, 2 * radius, Image.SCALE_FAST);
//		this.planetImg = new ImageIcon(nowImage);
		
//		this.setIcon(planetImg);
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
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image[a], 0, 0, null);
		b++;
		if(b>5){
			a++;
			if(a>42)
				a=0;
			b=0;
		}
	}
	//
	@Override
	/**
	 * ÿ�θı�λ�õ�ʱ��ҲҪͬ�����������
	 */
	public void setLocation(Point location){
		super.setLocation(location);
		this.locationX=location.x;
		this.locationY=location.y;
//		System.out.println(location);
		this.gameData.refreshPlanet(this.tag, location);
	}
	/**
	 * ��⡢������߳�
	 */
	public void run(){
		while (true) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				// TODO
			}
//			System.out.println("aaa");
			//��ȡ��ǰ���й���
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
			
			if (!lightList.isEmpty()) {
				lastLightX = lightX;
				lastLightY = lightY;
				this.getLight(lightList.get(lightList.size() - 1));
				// ����Ƿ����Ӵ�
				if (checkDistance(locationX, locationY, lightX, lightY, radius)) {
//					System.out.println(lastLightX+" "+lastLightY);
//					System.out.println(lightX+" "+lightY);
					// ��ù�����Բ�Ľ��㣬ͬʱҲ���¹��ߵ���ʼ��
					Point location = getLocation(lastLightX,lastLightY, lightX, lightY,locationX+radius,locationY+radius);
					
//					System.out.println("bbb"+location);
//					System.out.println(locationX+radius);
//					System.out.println(locationY+radius);
					// ����¹��ߵķ���
					Point direct=getDirection(locationX+radius, locationY+radius, directX, directY, location);
					
//					System.out.println("aaa"+location);
//					System.out.println(direct);
					// TODO finish it
					// System.out.println(location);
					
					if(lock){
						// ��֮ǰ�Ĺ���ֹͣ
						this.gameData.getLightControl().stopLight(
								lightList.get(lightList.size() - 1));
						this.gameData.getLightControl().launchLight(location.x,
								location.y, direct.x, direct.y);
						lock=false;
					}
					else
						lock=true;
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
	private Point getLocation(int lastLightX,int lastLightY,int lightX,int lightY,int centerX,int centerY){
		Point answer = null;
//		System.out.println("lx"+lightX);
		if(directX==0){
			double y=Math.pow((virtualRadius*virtualRadius-Math.pow(centerX-lightX, 2)), 0.5);
			if(lastLightY>centerY)
				return new Point(lightX,centerY+(int)y);
			else
				return new Point(lightX,centerY-(int)y);
		}
		//
		if(directY==0){
			double x=Math.pow((virtualRadius*virtualRadius-Math.pow(centerY-lightY, 2)), 0.5);
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
				+Math.pow(directY*lightX/directX, 2)+centerY*centerY-virtualRadius*virtualRadius;
//		System.out.println(lightX+" "+lightY);
//		System.out.println(directX+" "+directY);
//		System.out.println(centerX+" "+centerY);
		if(directX>=0)
			x=(-b-Math.pow(b*b-4*a*c, 0.5))/(2*a);
		else
			x=(-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
		y=directY*x/directX+lightY-directY*lightX/directX;

		answer=new Point((int)x,(int)y);
		if(answer.equals(new Point (0,0))||virtualRadius-answer.distance(centerX, centerY)>4)
			answer=this.binarySearch(new Point(lastLightX,lastLightY),new Point(lightX,lightY), 0);
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
	private Point getDirection(int centerX,int centerY,double directX,double directY,Point touch){

		//
		if(Math.abs(touch.x-centerX)<5)
			return new Point((int)directX,-(int)directY);
		if(Math.abs(touch.y-centerY)<5)
			return new Point(-(int)directX,(int)directY);
		//
		
		int instruction=this.getInstruction(touch, centerX, centerY);
		//
		double derta=this.getDerta(touch, centerX, centerY, virtualRadius, instruction);
		touch = new Point(touch.x - centerX, touch.y - centerY);
		//
		
		double seita=Math.acos((-directX*touch.x-directY*touch.y)/(touch.distance(0, 0)*Point.distance(directX, directY, 0, 0)));
		double check=directX*touch.y-directY*touch.x;

			if (check < 0) {
				int x = (int) (virtualRadius * Math.cos(derta + seita));
				int y = (int) (virtualRadius * Math.sin(derta + seita));
				return new Point(x, y);
			} else if (check > 0) {
				int x = (int) (virtualRadius * Math.cos(derta - seita));
				int y = (int) (virtualRadius * Math.sin(derta - seita));
				return new Point(x, y);
			} else {
				return new Point(-(int) directX, -(int) directY);
			}

		

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
//		System.out.println(touch);
//		System.out.println(centerX+" "+centerY);
		if(touch.x>centerX){
			if(touch.y>centerY)
				answer=1;
			else
				answer=4;
		}
		else{
			if(touch.y>centerY)
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
		double derta = Math.asin((touch.y - centerY) /(double)radius);
//		System.out.println(arg0);
//		System.out.println(derta);
		if (instruction == 2)
			derta = Math.PI - derta;
		else if (instruction == 3)
			derta = Math.PI - derta;
		else if (instruction == 4)
			derta += Math.PI * 2;
		return derta;
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
			if (distance - virtualRadius > 1)
				return binarySearch(half, second,++times);
			else if (distance - virtualRadius < -1)
				return binarySearch(first, half,++times);
			else
				return half;
		}
		
	}
}