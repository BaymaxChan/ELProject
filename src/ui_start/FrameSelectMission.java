/**
 * ѡ�ؽ��棬Ӧ�ڰ��¿�ʼ���桰��ʼ��Ϸ����ť����롣�����Ƿ�����ùؿ��������Ƿ���Ե��ͼ�����ùؿ���
 * �Ƿ�����ùؿ�Ӧ����ÿ���ؿ��ṩһ������ֵ��
 */
package ui_start;

import gamedata.GameData;
import gameservice.GameService;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui_game.FrameGame;
import ui_game.PanelGame;
import control.GameControl;
import control.PlayerControl;


/**
 * @author DorA
 *
 * 2015��4��18������6:09:14
 */
public class FrameSelectMission extends ui.FrameTotal{
	public PanelSelectMission panelSelectMission;
	
	public FrameSelectMission(PlayerControl playerControl, GameData gameData){	//������Ӧ�ô�����ؿ��Ƿ�ͨ���Ĳ���ֵ
		super();
		
		panelSelectMission = new PanelSelectMission(gameData);
		panelSelectMission.addControl(playerControl);
		this.setContentPane(panelSelectMission);
		
//		//�ڷֲ������뱳��ͼƬ���	
//		JLabel background = new JLabel(bg);
//		background.setBounds(0,0,1024,768);		
//		this.getLayeredPane().add(background);
//		
//		//�������������Ϊ͸��	
//		Container cp=this.getContentPane();
//		((JPanel)cp).setOpaque(false);
		
//		//���ɲ���
//		setLayout(null);
//		
//		if(isPassed){
//			//��ʾ��һ��ͼ��
//			JButton jbtMission1=new JButton(icon1);
//			jbtMission1.setBounds((int)(1024*0.2), (int)(768*0.4), 100, 100);
//			add(jbtMission1);
//			
//			//�����������ͼ�����ؿ�һ
//			jbtMission1.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e){
//					//mission1();		
//				}	
//			});
//		}
//		
//		if(isPassed){
//			//��ʾ�ڶ���ͼ��
//			JButton jbtMission2=new JButton(icon1);
//			jbtMission2.setBounds((int)(1024*0.5), (int)(768*0.4), 100, 100);
//			add(jbtMission2);
//			
//			//�����������ͼ�����ؿ���
//			jbtMission2.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e){
//					//mission2();		
//				}	
//			});
//		}
//		
//		if(isPassed){
//			//��ʾ������ͼ��
//			JButton jbtMission3=new JButton(icon1);
//			jbtMission3.setBounds((int)(1024*0.8), (int)(768*0.4), 100, 100);
//			add(jbtMission3);
//			
//			//�����������ͼ�����ؿ���
//			jbtMission3.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e){
//				}	
//			});
//		}
//		
	}
}
