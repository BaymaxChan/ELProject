/**
 * һ������ӽ���ؿ���ʼ��ʱ����ʾһ�����ͼ�κ��ַ���
 */
package ui_game;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * @author DorA
 *
 * 2015��5��7������12:01:40
 */
public class Clock extends JPanel{
	private long startMillis;
	private long currentMillis;
	private int sec;
	
	public Clock(){
		//��ȡ��ʼ��ʱ�ӵ�ʱ��
		startMillis=System.currentTimeMillis();
		Timer timer=new Timer(1000,new TimerListener());
		timer.start();
	}
	
	//���شӳ�ʼ��ʱ�ӵ���ǰ����������
	public int getSec(){
		currentMillis=System.currentTimeMillis();
		sec = (int)((currentMillis-startMillis)/1000);
		return sec;
	}
	
	//���ؾ���ʱ����ַ���
	public String getTimeString(){
		int minute=(sec/60)%60;
		int second=sec%60;
		int hour=sec/60/60;
		String time;
		
		if((hour==0)&&(minute==0)){		
			time="���Ѿ�̽����"+second+"��";
		}else if(hour==0){
			time="���Ѿ�̽����"+minute+"����"+second+"��";
		}else time="���Ѿ�̽����"+hour+"Сʱ"+minute+"����"+second+"��";
		
		return time;
	}

	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sec=getSec();
			repaint();
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw circle
		int xCenter=getWidth()/2;
		int yCenter=getHeight()/2;
		int radius=(int)(Math.min(getWidth(), getHeight())*0.7*0.5);
		g.drawOval(xCenter-radius, yCenter-radius, 2*radius, 2*radius);
		//draw the second hand
		int sLength=(int)(radius*0.8);
		int xSec=(int)(xCenter+sLength*Math.sin(Math.PI*sec/30));
		int ySec=(int)(yCenter-sLength*Math.cos(Math.PI*sec/30));
		g.drawLine(xCenter, yCenter, xSec, ySec);
		//��ȡ����ĳߴ���Ϣ
		FontMetrics fm=g.getFontMetrics();	
		int stringAscent=fm.getAscent();
		int stringDescent=fm.getDescent();
		int stringWidth=fm.stringWidth(getTimeString());
		//��������ˮƽ����
		int xCoordinate=getWidth()/2-stringWidth/2;
		//��ʾ��ǰ����ʱ��
		g.drawString(getTimeString(), xCoordinate, getHeight()-(stringAscent+stringDescent)*2);

	}

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setLayout(null);
		Clock clock=new Clock();
		clock.setBounds(800,100,150,200);
	//	clock.setLocation(800, 100);
		frame.add(clock);
		frame.setSize(1024, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
