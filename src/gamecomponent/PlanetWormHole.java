package gamecomponent;

import java.awt.Point;
import java.util.ArrayList;

import gamedata.GameData;

public class PlanetWormHole implements Runnable{
	private WormHole[] wormHole=new WormHole[2];
	private GameData gameData;
	private int lightX;
	private int lightY;
	private double directX;
	private double directY;
	public PlanetWormHole(int firstX,int firstY,int secondX,int secondY,int radius,GameData gameData){
		wormHole[0]=new WormHole(firstX,firstY,radius);
		wormHole[1]=new WormHole(secondX,secondY,radius);
		this.gameData=gameData;//
		//
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(50);
			}
			catch(Exception e){
				System.out.println("CXWorks   ���쳣�׳���PlanetWormHole���߳�");
			}
			//
			ArrayList<Light> lightList = this.gameData.getLightControl().getLightList();
//			System.out.println("aaa");
			if(!lightList.isEmpty()){
				this.getLight(lightList.get(lightList.size() - 1));
				if(checkDistance(wormHole[0].locationX, wormHole[0].locationY, lightX, lightY, wormHole[0].radius)){
					// ��֮ǰ�Ĺ���ֹͣ
					this.gameData.getLightControl().stopLight(
							lightList.get(lightList.size() - 1));
					//
					this.gameData.getLightControl().launchLight(wormHole[1].locationX+wormHole[1].radius, 
							wormHole[1].locationY+wormHole[1].radius, (int)this.directX,(int)this.directY);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					System.out.println((wormHole[1].locationX+wormHole[1].radius)+" "+
//							(wormHole[1].locationY+wormHole[1].radius)+" "+(int)this.directX+" "+(int)this.directY);
					
				}
				//
				if(checkDistance(wormHole[1].locationX, wormHole[1].locationY, lightX, lightY, wormHole[1].radius)){
					// ��֮ǰ�Ĺ���ֹͣ
					this.gameData.getLightControl().stopLight(
							lightList.get(lightList.size() - 1));
					//
					this.gameData.getLightControl().launchLight(wormHole[0].locationX+wormHole[0].radius, 
							wormHole[0].locationY+wormHole[0].radius, (int)this.directX, (int)this.directY);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	//
	private void getLight(Light light){
		this.lightX = light.getEndX();
		this.lightY = light.getEndY();
		this.directX=light.getDirectX();
		this.directY=light.getDirectY();
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
	public WormHole getWormHole(){
		return this.wormHole[0];
	}
	public WormHole getAnotherWormHole(){
		return this.wormHole[1];
	}

}
/**
 * 
 * */
//public class WormHole extends Planet{
//	private static final long serialVersionUID = 1L;
//	public WormHole(int x,int y,int Radius){
//		//����Ĳ�������
//		this.locationX=x;
//		this.locationY=y;
//		this.radius=Radius;
//		//���찴ť��ͼƬ���Զ�����
//		this.planetImg=getImageIcon("image/����/����4.png", 2*radius,2*radius);
//		this.setIcon(planetImg);
//		//��ť��λ��
//		this.setBounds(locationX, locationY, 2*radius, 2*radius);
//		//���ò���ӡ���ε�����
//		this.setContentAreaFilled(false);
//		//���ò���ӡ�߿�
//		this.setBorderPainted(false);
//		//���ÿɼ�
//		this.setVisible(true);
//	}
//}