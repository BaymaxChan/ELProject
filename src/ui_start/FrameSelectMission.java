/**
 * ѡ�ؽ��棬Ӧ�ڰ��¿�ʼ���桰��ʼ��Ϸ����ť����롣�����Ƿ�����ùؿ��������Ƿ���Ե��ͼ�����ùؿ���
 * �Ƿ�����ùؿ�Ӧ����ÿ���ؿ��ṩһ������ֵ��
 */
package ui_start;

import ui.*;

/**
 * @author DorA
 *
 * 2015��4��18������6:09:14
 */
public class FrameSelectMission extends ui.JFrameTotal{

	private final FrameSelectMission f=this;
	private final BgmSyncData bgmData;
	private final SoundSyncData soundData;
	
	public FrameSelectMission(BgmSyncData bgmSyncData,SoundSyncData soundSyncData){	//������Ӧ�ô�����ؿ��Ƿ�ͨ���Ĳ���ֵ
		super();
		bgmData=bgmSyncData;
		soundData=soundSyncData;
		
		this.setContentPane(new PanelSelectMission(f,bgmData, soundData));
		
		
		
	}
	
	//�رմ��ڷ���
	public void closeFrame(){
		f.dispose();
	}

}