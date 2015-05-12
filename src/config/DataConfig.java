package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class DataConfig {
	private String className;
	
	private String name;
	//�������壬���������������򣬺ڶ����װ���
	private ArrayList<PlanetConfig> planetsConfig;
	//�涴
	private WormHoleConfig wormholeConfig;
	//��ʼ���߷���
	private int lightDirectionX;
	private int lightDirectionY;
	
	//������������
	public int reflectionNum = 0;
	//������������
	public int refractionNum = 0;
	//�ڶ�����
	public int blackholeNum = 0;
	//�涴����
	public int wormholeNum = 0;

	//������
	public DataConfig(Element data) {
		this.planetsConfig = new ArrayList<PlanetConfig>();
		
		this.className = data.attributeValue("className");
		this.name = data.attributeValue("name");
		this.reflectionNum = Integer.parseInt(data.attributeValue("reflectionNum"));
		this.refractionNum = Integer.parseInt(data.attributeValue("refractionNum"));
		this.blackholeNum = Integer.parseInt(data.attributeValue("blackholeNum"));
		this.wormholeNum = Integer.parseInt(data.attributeValue("wormholeNum"));
		this.lightDirectionX = Integer.parseInt(data.attributeValue("lightDirectionX"));
		this.lightDirectionY = Integer.parseInt(data.attributeValue("lightDirectionY"));
		
		@SuppressWarnings("unchecked")
		List<Element> planets = data.elements("planet");
		for (Element planet : planets) {
			PlanetConfig pc = new PlanetConfig(planet);
			planetsConfig.add(pc);
		}
		
		if(this.wormholeNum == 1){
			Element wormhole = data.element("wormhole");
			wormholeConfig = new WormHoleConfig(wormhole);
		}		
	}

	public String getClassName() {
		return className;
	}

	public String getName() {
		return name;
	}

	public ArrayList<PlanetConfig> getPlanetsConfig() {
		return planetsConfig;
	}

	public WormHoleConfig getWormholeConfig() {
		return wormholeConfig;
	}

	public int getLightDirectionX() {
		return lightDirectionX;
	}

	public int getLightDirectionY() {
		return lightDirectionY;
	}
}
