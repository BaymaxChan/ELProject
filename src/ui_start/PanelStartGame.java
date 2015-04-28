/**
 * ��ʼ�������
 */
package ui_start;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import audio.BackgroundMusic;
import ui.*;

/**
 * @author DorA
 *
 * 2015��4��17��00:20:14
 */
public class PanelStartGame extends JPanel{
	private int w=JFrameTotal.WINDOWW;
	private int h=JFrameTotal.WINDOWH;
	//��ʼ���汳��ͼƬ
	ImageIcon ic=new ImageIcon("image/bg/���汳��.png");
	Image bg=ic.getImage();
	
	//��ť��ͼ��
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");

	//��������
	public static BackgroundMusic bgm=new BackgroundMusic("bgm01");
	
	
	public PanelStartGame(FrameStartGame f,BgmSyncData data,SoundSyncData soundData){
		final FrameStartGame frame=f;
		final BgmSyncData bgmSyncData=data;
		final SoundSyncData soundSyncData=soundData;
	
		this.setBounds(0, 0, w, h);		
		//���ɲ���
		setLayout(null);
				
		
		//���һ����ʼ��Ϸ��ť
		JButton jbtStart=new JButton(defaultIcon);
		jbtStart.setBounds((int)(w*0.2),(int)(h*0.5),100,100);
		jbtStart.setToolTipText("select mission");
			jbtStart.setPressedIcon(rollIcon);
			jbtStart.setRolloverIcon(rollIcon);
		add(jbtStart);
		
		//���º����ѡ�ؽ���	
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bgm.stop();			//�رձ�������
				frame.closeFrame();		//�رոý���
				FrameSelectMission fsm=new FrameSelectMission(bgmSyncData,soundSyncData);	//���½���
				
			}
		});	
		
		
		//���һ������&��ʾ��ť
		JButton jbtHelp=new JButton(defaultIcon);
		jbtHelp.setBounds((int)(w*0.45),(int)(h*0.5),100,100);
		jbtHelp.setToolTipText("Help");
		jbtHelp.setPressedIcon(rollIcon);
		jbtHelp.setRolloverIcon(rollIcon);
		add(jbtHelp);
			//�˴�Ӧ�м�����
		jbtHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add(panel);

			}
		});
			
		//���һ���˳���Ϸ��ť
		JButton jbtQuit=new JButton(defaultIcon);
		jbtQuit.setBounds((int)(w*0.7),(int)(h*0.5),100,100);
		jbtQuit.setToolTipText("Quit");
		jbtQuit.setPressedIcon(rollIcon);
		jbtQuit.setRolloverIcon(rollIcon);
		add(jbtQuit);		
			
		//�����������°�ť��ر���Ϸ	
		jbtQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);		
			}
		});
		
		//�����������뱳�����ֿ��ذ�ť
		ButtonBackgroundMusic jbtSilence=new ButtonBackgroundMusic(bgmSyncData);
		jbtSilence.setMusic(bgm);
		add(jbtSilence);
		
		//������Ч���ذ�ť
		ButtonSound jbtSound=new ButtonSound(soundSyncData);
		add(jbtSound);
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, w,h,this);

	}

}
