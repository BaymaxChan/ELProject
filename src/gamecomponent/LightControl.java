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
	private int directX;
	private int directY;
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
		isExist = true;
		//����һ����������(���ǵ������������������߹켣��ͬ���ö����������ʾ)
		lightList = new ArrayList<Light>();
		
		//�����߳�LightControl.
		Thread t = new Thread(this);
		t.start();
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
		//������߷�������
		this.directX = directX;
		this.directY = directY;	
		
		// TODO �Ƿ�Ӧ�ڴ����г�ʼ�������ڴ˳�ʼ����ν�g����light��paint�����У�
		Light light = new Light(this.launchX, this.launchY, this.directX, this.directY);
		System.out.println("add");
		this.lightList.add(light);
	}
	
	/**
	 * �ɽ����������Ƿ����
	 * @param isExist �Ƿ����
	 */
	public void setExist(boolean isExist) {
		this.isExist = isExist;
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
		while(true){
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//�����Ƿ����
			if(this.isExist){
				for (int i = 0; i < this.lightList.size(); i++) {
					Light light = this.lightList.get(i);
					//�жϼ����Ƿ�Ϊ�ղ����Ƿ��ܹ���������
					if((light != null)&&light.isCanDeliver()){
						light.deliverLight();
					}
				}
			} else{
				break;
			}
			System.out.println("lc");
		}
	}
		
}
