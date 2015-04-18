package gamecomponent;

import java.util.ArrayList;
/**
 * ���߿�����������һ���ؿ��е����й�����
 * ���췽������������ͼƬ��ȡ���ȣ�����Ӧ����ͼƬ����Ϸ�����е���ʾ���ȣ��Ӷ����ֳ�����Ч��
 * TODO ��������������
 * @author �����
 * 2015.4.14.
 */
public class LightControl implements Runnable{
	/**
	 * ���巢������
	 */
	private int launchX;
	private int launchY;
	/**
	 * ���巽������
	 */
	private double directX;
	private double directY;
	/**
	 * �Ƿ����
	 */
	private boolean isExist = false;
	/**
	 * ����һ������
	 */
	private ArrayList<Light> lightList;
	/**
	 * ���캯��
	 */
	public LightControl(){	
		//������ߴ���
		this.isExist = true;
		//����һ����������(���ǵ������������������߹켣��ͬ���ö����������ʾ)
		this.lightList = new ArrayList<Light>();
		
		//�����߳�LightControl.
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stopLight(){
		this.isExist = false;
	}
	/**
	 * TODO ���伤�ⷽ��(ʵ�ּ���)
	 * @param launchX ����X����
	 * @param launchY ����Y����
	 * @param directX ��������X����
	 * @param directY ��������Y����
	 */
	public void launchLight(int launchX, int launchY, int directX, int directY){
		//������߷�����ʼ����
		this.launchX = launchX;
		this.launchY = launchY;
		
		//������߷�������������ת��Ϊ��׼����
		double tempsqrt = Math.sqrt((double)(directX*directX+directY*directY));
		this.directX = (double)directX/tempsqrt;
		this.directY = (double)directY/tempsqrt;	

		// TODO �Ƿ�Ӧ�ڴ����г�ʼ�������ڴ˳�ʼ����ν�g����light��paint�����У�
		Light light = new Light(this.launchX, this.launchY, this.directX, this.directY);
		this.lightList.add(light);
	}
	
	/**
	 * �ɽ������õ������Ƿ����
	 * @return �����Ƿ����
	 */
	public boolean getisExist() {
		return this.isExist;
	}
	/**
	 * �õ�һ������
	 * @return �ù��߿���������Ĺ���
	 */
	public ArrayList<Light> getLightList() {
		return lightList;
	}

	/**
	 * ���ߴ��������̣߳�ÿ50����(�ٵ���)����һ�Σ�������ǰ���졣
	 */
	public void run() {
		while(this.isExist){
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//�����Ƿ����
			for (int i = 0; i < this.lightList.size(); i++) {
				Light light = this.lightList.get(i);
				//�жϼ����Ƿ�Ϊ�ղ����Ƿ��ܹ���������
				if((light != null)&&light.isCanDeliver()){
					light.deliverLight();
				}
			}
		}
	}
		
}
