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
	 * ��������ͼ��ʾ
	 */
	private static ImageIcon img1=new ImageIcon("image/help/help1.png");
	private static ImageIcon img2=new ImageIcon("image/help/help2.png");
	private static ImageIcon img3=new ImageIcon("image/help/help3.png");
	private static ImageIcon img4=new ImageIcon("image/help/help4.png");
	/**
	 * �ô����ĳ���
	 */
	static int WIDTH = img1.getIconWidth();
	static int HEIGHT = img1.getIconHeight();
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
	private static final ImageIcon BUTTON_CLOSE = Planet.getImageIcon("image/button/Return4.png", (int)(WIDTH*0.18), (int)(HEIGHT*0.18));
	/**
	 * ����ͼ
	 */
	private PanelHelp panelHelp=this;
	private JLabel jp1=new JLabel(img1);
	private JLabel jp2=new JLabel(img2);
	private JLabel jp3=new JLabel(img3);
	private JLabel jp4=new JLabel(img4);
	/**
	 * ����������ť���µĴ���
	 */
	int countUp=0;
	int countDown=0;
	int page;
	
	public PanelHelp(PlayerControl playerControl){
		this.playerControl = playerControl;
		
		this.setLayout(null);
		
		initButton();
		initLabel();
		//��ʼʱ���ص�һ��ͼ
		jp1.setBounds(0, 0, WIDTH, HEIGHT);
		this.setOpaque(false);
		this.add(jp1);
	}
	/**
	 * ��ʼ��������ť
	 */
	private void initButton(){
		closeButton = new JButton();
		closeButton.setIcon(BUTTON_CLOSE);
		closeButton.setBounds((int)(WIDTH/2-BUTTON_CLOSE.getIconWidth()/2), (int)(HEIGHT*0.892), (int)(WIDTH*0.18), (int)(HEIGHT*0.18));
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
	void initLabel(){
		JButton jbtUp=new JButton(imgUp);
		JButton jbtDown=new JButton(imgDown);	
		jbtUp.setBounds((int)(WIDTH*0.88), (int)(HEIGHT*0.65), 40,40);
		jbtDown.setBounds((int)(WIDTH*0.88), (int)(HEIGHT*0.77), 40,40);
		jbtUp.setContentAreaFilled(false);
		jbtUp.setBorderPainted(false);
		jbtDown.setContentAreaFilled(false);
		jbtDown.setBorderPainted(false);
		this.add(jbtUp);
		this.add(jbtDown);
		
		jbtUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				countUp++;
				page=countDown-countUp+1;
				switch(page){
				case 1:	 panelHelp.remove(jp2);	
					jp1.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jp1);
					break;
				case 2:	panelHelp.remove(jp3);	 
					jp2.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jp2);
					break;
				case 3:	panelHelp.remove(jp4);	
					jp3.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jp3);
				break;
				default: countUp--;
				}

				repaint();
			}
		});
		
		jbtDown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				countDown++;
				page=countDown-countUp+1;
				switch(page){
				case 2:	 panelHelp.remove(jp1);	
					jp2.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jp2);
					break;
				case 3:	panelHelp.remove(jp2);	 
					jp3.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jp3);
					break;
				case 4:	panelHelp.remove(jp3);	
					jp4.setBounds(0, 0, WIDTH, HEIGHT);
					panelHelp.add(jp4);
				break;
				default: countDown--;
				}

				repaint();
			}
		});
	}

	
	
}