/**
 * ����ͬ����Ч�������ݣ���Ҫ����Ϸ����ʱ��ʼ�������
 */
package ui;
/**
 * @author DorA
 *
 * 2015-4-28 13:00:40
 */
public class SoundSyncData {
	private int control;
	
	public SoundSyncData(){
		control=0;
	}
	
	//�ı侲������ֵ
	public void setControl(int control){
		this.control=control;
	}
	
	//��ȡ��������ֵ
	public int getControl(){
		return control;
	}
}