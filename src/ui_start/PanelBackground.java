/**
 * ͼƬ������壬�ṩһ��imageicon���ɹ���һ��panel�Ž�frame����
 */
package ui_start;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
/**
 * @author DorA
 *
 * 2015��4��8������11:51:29
 */

public class PanelBackground extends JLayeredPane{
	
	PanelBackground(ImageIcon bg){
		JLabel background = new JLabel(bg);
		background.setBounds(0,0,1000, 650);
		add(background);
	}

}
