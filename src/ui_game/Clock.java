/**
 * һ������ӽ���ؿ���ʼ��ʱ����ʾһ�����ͼ�κ��ַ���
 */
package ui_game;

import java.awt.Color;
import ui.FrameTotal;
import gamecomponent.Planet;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * @author DorA
 *
 * 2015��5��7������12:01:40
 */
public class Clock extends JPanel{
	PanelGame panelGame;
	Clock clock=this;
	private int WINDOWW = FrameTotal.WINDOWW;
	private int WINDOWH = FrameTotal.WINDOWH;
	//��ʱ���Ĵ�С��λ��
	private final int WIDTH=(int)(WINDOWW*0.18),HEIGHT=(int)(WINDOWH*0.090);
	private final int x=(int)(WINDOWW*0.435),y=(int)(WINDOWH*0.008);
	//��ʼʱ��
	private long startMillis;
	//����ʱ��
	private long currentMillis;
	//��ʱ
	private long totalMillis=180000;
	//��ʱ��
	private Timer timer=new Timer(100,new TimerListener());
	//����ͼƬ
	ImageIcon img=Planet.getImageIcon("image/componnet/����.png", WIDTH,HEIGHT);
	//ʱ������
	private Font font=new Font("swfit_slm_fw",Font.PLAIN,23);
	
	public Clock(long totalMillis, PanelGame panelGame){
		this.panelGame=panelGame;
		this.totalMillis=totalMillis;
		this.setBounds(x, y, WIDTH, HEIGHT);
		this.setOpaque(false);
		//��ȡ��ʼ��ʱ�ӵ�ʱ��
		startMillis=System.currentTimeMillis();
		this.timer.start();
	}
	
	//ֹͣ��ʱ��
	public void stop(){
		this.timer.stop();
	}
	
	//���ش�ʣ��ĺ�����
	public long getMillis(){
		currentMillis=System.currentTimeMillis();
		long millis = currentMillis-startMillis;
		return totalMillis-millis;
	}

	
	//����ʣ��ʱ����ַ���
	public String getTimeString(){
		long millis=getMillis();
		int sec=(int)(millis/1000);
		
		int hundredMillis=(int)((millis)%100);
		int minute=(int)(sec/60)%60;
		int second=sec%60;
		String time;
		
		time=String.format("%02d", minute)+":"+String.format("%02d", 

second)+":"+String.format("%02d", hundredMillis);
		
		return time;
	}

	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			repaint();
			if(getMillis()/100==0){				
				panelGame.gameLose();
			}			
		}
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setFont(font);
		g.setColor(Color.white);
		int xCenter=WIDTH/2;
		int yCenter=HEIGHT/2;
		
		g.drawImage(img.getImage(), 0,0, null);
		//��ȡ����ĳߴ���Ϣ
		FontMetrics fm=g.getFontMetrics();	
		int stringAscent=fm.getAscent();
		int stringDescent=fm.getDescent();
		int stringWidth=fm.stringWidth(getTimeString());
		//�������־���
		int xCoordinate=xCenter-stringWidth/2;
		int yCoordinate=(int)(yCenter+(stringAscent-stringDescent)/2);
		//��ʾ��ǰ����ʱ��
		if(getMillis()/100<=0){
			g.drawString(" 00:00:00", xCoordinate, yCoordinate);
		}else{
			g.drawString(getTimeString(), xCoordinate, yCoordinate);
		}
		

	}



}