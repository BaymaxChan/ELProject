/**
 * 
 */
package ui_start;

import gamecomponent.Planet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ui.FrameTotal;
import control.PlayerControl;

/**
 * @author DorA
 *
 * 2015��4��29������7:03:07
 */
public class PanelHelp extends JPanel{
	private PlayerControl playerControl;
	
	/**
	 * ����5��ͼ��ʾ
	 */
	private static ImageIcon img0=new ImageIcon("image/help/help0.png");
	private static ImageIcon img1=new ImageIcon("image/help/help1.png");
	private static ImageIcon img2=new ImageIcon("image/help/help2.png");
	private static ImageIcon img3=new ImageIcon("image/help/help3.png");
	private static ImageIcon img4=new ImageIcon("image/help/help4.png");
	private static ImageIcon img5=new ImageIcon("image/help/help5.png");
	private static ImageIcon img6=new ImageIcon("image/help/help1.png");
	private static ImageIcon img7=new ImageIcon("image/help/help2.png");
	private static ImageIcon img8=new ImageIcon("image/help/help2.png");
	private static ImageIcon img9=new ImageIcon("image/help/help4.png");
	private PanelHelp panelHelp=this;
	private JLabel jl0,jl1,jl2,jl3,jl4;
	/**
	 * �ô����ĳ���
	 */
	static int WIDTH = img1.getIconWidth();
	static int HEIGHT =img1.getIconHeight();
	/**
	 * ��������ͼ��ʾ
	 */
	private ImageIcon imgUp=new ImageIcon("image/help/up.png");
	private ImageIcon imgDown=new ImageIcon("image/help/down.png");
	/**
	 * �رհ�ť
	 */
	private JButton closeButton;
	/**
	 * TODO �رհ�ť��ͼƬ
	 */
	private static ImageIcon closeImg=new ImageIcon("image/button/Return4.png");
	private static final ImageIcon BUTTON_CLOSE = Planet.getImageIcon("image/button/Return4.png", (int)(closeImg.getIconWidth()*0.22), (int)(closeImg.getIconHeight()*0.22));

	/**
	 * ����������ť���µĴ���
	 */
	int countUp=0;
	int countDown=0;
	int page=0;
	/**
	 * ����ʵ�ֶ�̬ͼƬ�仯
	 */
	boolean isChanged=false;
	Timer timer=new Timer(800,new TimerListener());
	
	
	public PanelHelp(PlayerControl playerControl){
		this.playerControl = playerControl;

		this.jl0=new JLabel(img0);
		this.jl1=new JLabel(img1);
		this.jl2=new JLabel(img2);
		this.jl3=new JLabel(img3);
		this.jl4=new JLabel(img4);
		
		this.setLayout(null);
		
		initButton();
		initExchange();
		//��ʼʱ���ص�һ��ͼ
		jl0.setBounds(0, 0, WIDTH, HEIGHT);
		this.setOpaque(false);
		this.add(jl0);
		

		this.timer.start();
	}
	
	public void stop(){
		this.timer.stop();
	}
	/**
	 * ��ʼ��������ť
	 */
	private void initButton(){
		closeButton = new JButton();
		closeButton.setIcon(BUTTON_CLOSE);
		closeButton.setBounds((int)(WIDTH/2-BUTTON_CLOSE.getIconWidth()/2), (int)(HEIGHT*0.95), (int)(closeImg.getIconWidth()*0.22), (int)(closeImg.getIconHeight()*0.22));
		closeButton.addActionListener(playerControl);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setActionCommand("CloseFrameHelp");
		closeButton.setVisible(true);
		this.add(closeButton);	
	}
	/**
	 * ��ʼ��ͼƬ����һҳ��һҳ��ť����Ӽ�����
	 */
	void initExchange(){
		JButton jbtUp=new JButton(imgUp);
		JButton jbtDown=new JButton(imgDown);	
		jbtUp.setBounds((int)(WIDTH*0.92), (int)(HEIGHT*0.65), 40,40);
		jbtDown.setBounds((int)(WIDTH*0.92), (int)(HEIGHT*0.77), 40,40);
		jbtUp.setContentAreaFilled(false);
		jbtUp.setBorderPainted(false);
		jbtDown.setContentAreaFilled(false);
		jbtDown.setBorderPainted(false);
		this.add(jbtUp);
		this.add(jbtDown);
		
		jbtUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				countUp++;
				page=countDown-countUp;
				switch(page){
				case 0:	panelHelp.remove(jl1);
					jl0.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl0);
				break;
				case 1:	 panelHelp.remove(jl2);
					jl1.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl1);
					break;
				case 2:	panelHelp.remove(jl3);
					jl2.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl2);
					break;
				case 3:	panelHelp.remove(jl4);
					jl3.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl3);
				break;
				default: countUp--;
				}

				repaint();
			}
		});
		
		jbtDown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				countDown++;
				page=countDown-countUp;
				switch(page){
				case 1:	 panelHelp.remove(jl0);	
					jl1.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl1);
					break;
				case 2:	 panelHelp.remove(jl1);	
					jl2.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl2);
					break;
				case 3:	panelHelp.remove(jl2);	
					jl3.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl3);
					break;
				case 4:	panelHelp.remove(jl3);	
					jl4.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jl4);
				break;
				default: countDown--;
				}

				repaint();
			}
		});
	}
	

	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			isChanged=!isChanged;
			if(isChanged==false){
				switch(page){
				case 0:panelHelp.remove(jl0);
				jl0=new JLabel(img0);
				jl0.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl0);break;
				
				case 1:panelHelp.remove(jl1);
				jl1=new JLabel(img1);
				jl1.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl1);break;
				
				case 2:panelHelp.remove(jl2);
				jl2=new JLabel(img2);
				jl2.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl2);break;
				
				case 3:panelHelp.remove(jl3);
				jl3=new JLabel(img3);
				jl3.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl3);break;
				
				case 4:panelHelp.remove(jl4);
				jl4=new JLabel(img4);
				jl4.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl4);break;				
				}
			}else{

				
				switch(page){
				case 0:panelHelp.remove(jl0);
				jl0=new JLabel(img5);
				jl0.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl0);break;
				
				case 1:panelHelp.remove(jl1);
				jl1=new JLabel(img6);
				jl1.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl1);break;
				
				case 2:panelHelp.remove(jl2);
				jl2=new JLabel(img7);
				jl2.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl2);break;
				
				case 3:panelHelp.remove(jl3);
				jl3=new JLabel(img8);
				jl3.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl3);break;
				
				case 4:panelHelp.remove(jl4);
				jl4=new JLabel(img9);
				jl4.setBounds(0,0,WIDTH,HEIGHT);
				panelHelp.add(jl4);break;				
				}
				
			}
			repaint();

			
			/*switch(labelNumber){
			case 1:jl1.setBounds(0, 0, WIDTH, HEIGHT);
				add(jl1);
			}*/
			
			
		}
	}
	
	
}