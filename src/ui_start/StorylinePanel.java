/**
 * ������ʾ��Ļ��Ҫ��ʾ�İ�һ�λ����빹�췽�����м��û��з�������
 */
package ui_start;

import java.awt.Color;
import java.awt.Font;
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
 * 2015��5��5��12:04:48
 */
public class StorylinePanel extends JPanel{
	private int frameWidth=1024;
	private int frameHeight=700;
	//�ı���Ϣ
	private String text="1971������Ҷ�Ľ������찶�ĵڶ���\n�ĸ�ĸ�ѹʹ���е������������\n������ȥ�ĳ�������������Ŀ��\n";
	private String message="";
	private String[] messageList;
	//ˢ�¼��(����)
	int interval=2000;
	//һ�����ֵ�λ����Ϣ
	private int xCoordinate;
	private int yCoordinate=300;

	//���壬���Ե��÷���������
	private Font font=new Font("����", Font.PLAIN, 30);
	//����߶���Ϣ
	private int stringAscent;
	private int stringDescent;
	private int stringWidth;
	//����������
	int i=0;
	
	public StorylinePanel(String text){
		this.text=text;
	
		//��ʱ��
		Timer timer=new Timer(interval,new TimerListener());
		timer.start();
		
		
		//��һ�λ����һ��һ�е��ַ���������������
		this.messageList=text.split("\n");	
	}
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//������ʾ����
			if(i<messageList.length){
				message=messageList[i];
				i++;
				repaint();
			}
		}
	}

	
	//����һ������
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	
		//��������
		g.setFont(font);
		g.setColor(Color.white);
			
		//��ȡ����ĳߴ���Ϣ
		FontMetrics fm=g.getFontMetrics();	
		stringAscent=fm.getAscent();
		stringDescent=fm.getDescent();
		
		//��һ�λ���ʱ���ַ�����ֱ����
		if(yCoordinate==0){
			yCoordinate=frameHeight/2+stringAscent/2;
		}
			
		//һ���ֵĿ��
		stringWidth=fm.stringWidth(message);
		//��������ˮƽ����
		xCoordinate=getWidth()/2-stringWidth/2;
		yCoordinate=frameHeight/2+stringAscent/2;
		
		//����
		g.drawString(message, xCoordinate, yCoordinate);
			
		}
	
/*	public static void main(String[]args){
		JFrame frame=new JFrame();
		
		frame.add(new StorylinePanel("1971������Ҷ�Ľ������찶�ĵڶ��꣬\n�ĸ�ĸ�ѹʹ���е������������\n������ȥ�ĳ�������������Ŀ��\n "));
	

		frame.setSize(1024,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}*/
}
