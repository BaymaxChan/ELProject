/**
 * ����ͬ���������ֿ������ݣ���Ҫ����Ϸ����ʱ��ʼ�������
 */
package ui;

/**
 * @author DorA
 *
 * 2015��4��28������9:29:24
 */
public class BgmSyncData {
	private int control;
	
	public BgmSyncData(){
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