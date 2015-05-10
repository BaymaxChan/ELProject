package config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class FrameConfig {
	//�����������ļ�
	private FrameTotalConfig totalCfg;
	//�������������ļ�
	private FrameHelpConfig helpCfg;
	//ͨ�ش��������ļ�
	private FrameWinConfig winCfg;
	
	public FrameConfig() throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read("config/frameCfg.xml");
		
		Element frame = doc.getRootElement();
		
		Element frametotal = frame.element("frametotal");
		Element framehelp = frame.element("framehelp");
		Element frameWin = frame.element("framewin");
		
		totalCfg = new FrameTotalConfig(frametotal);
		helpCfg = new FrameHelpConfig(framehelp);
		winCfg = new FrameWinConfig(frameWin);
	}

	public FrameTotalConfig getTotalCfg() {
		return totalCfg;
	}

	public FrameHelpConfig getHelpCfg() {
		return helpCfg;
	}

	public FrameWinConfig getWinCfg() {
		return winCfg;
	}
}
