/**
 * ��ʼ����İ�ť��壬Ӧ�ð�����ʼ��Ϸ���������˳���Ϸ�������İ�ť��������ť��
 * ������ť��ûд��������Ҳûд��yeah��
 */
package ui_start;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
/**
 * @author DorA
 *
 * 2015��4��8������11:51:29
 */
public class PanelStartGame extends JPanel{
	private ImageIcon defaultIcon=new ImageIcon("image/button/img1.jpg");
	private ImageIcon rollIcon=new ImageIcon("image/button/img2.jpg");
	
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screen = toolkit.getScreenSize();
	//������,��0.618�ǻƽ�ָ��
	protected int width=(int)(screen.width*0.618);
	//����߶�,��0.618�ǻƽ�ָ��
	protected int height=(int)(screen.height*0.618);
	

	
	
	public PanelStartGame(){
		setLayout(null);
	//���һ����ʼ��Ϸ��ť
		JButton jbtStart=new JButton(defaultIcon);
		jbtStart.setBounds((int)(width*0.3),(int)(height*0.5),100,100);
		jbtStart.setPressedIcon(rollIcon);
		jbtStart.setRolloverIcon(rollIcon);
		add(jbtStart);
		//���º�ʼ��Ϸ
		
	//���һ������&��ʾ��ť
		JButton jbtHelp=new JButton(defaultIcon);
		jbtHelp.setBounds((int)(width*0.1),(int)(height*0.3),100,100);
		jbtHelp.setPressedIcon(rollIcon);
		jbtHelp.setRolloverIcon(rollIcon);
		add(jbtHelp);
		//�˴�Ӧ�м�����
		
	//���һ���˳���Ϸ��ť
		JButton jbtQuit=new JButton(defaultIcon);
		jbtQuit.setBounds((int)(width*0.5),(int)(height*0.8),100,100);
		jbtQuit.setPressedIcon(rollIcon);
		jbtQuit.setRolloverIcon(rollIcon);
		add(jbtQuit);
		//�˴�Ӧ�м�����
	
	
	}
	
	
}
