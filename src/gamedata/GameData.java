package gamedata;

import gamecomponent.LightControl;
import gamecomponent.Planet;
import gamecomponent.PlanetBlackHole;
import gamecomponent.PlanetEarth;
import gamecomponent.PlanetReflection;
import gamecomponent.PlanetRefraction;
import gamecomponent.PlanetSun;
import gamecomponent.PlanetThreeBody;
import gamecomponent.PlanetWormHole;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import config.ConfigFactory;
import config.DataConfig;
import config.LevelConfig;
import config.PlanetConfig;
import config.WormHoleConfig;

/**
 * ������Ϸ���ݣ�������Ϸ�������Ϸ����������
 * @author �����
 * 2015.4.15.
 */
public class GameData {
	//����
	private PlanetEarth planetEarth;
	//̫��
	private PlanetSun planetSun;
	//����
	private PlanetThreeBody planetThreeBody;
	//����������
	private List<PlanetReflection> planetReflections;
	//����������
	private List<PlanetRefraction> planetRefractions;
	//�ڶ���
	private List<PlanetBlackHole> planetBlackHoles;
	//�涴
	private PlanetWormHole planetWormHole;
	//�涴�Ƿ����
	public boolean haveWornhole = false;
	
	//���߿�����
	private LightControl lightControl;
	
	//��0���ǵ��򣬵�1������������������ֱ���X���꣬Y���꣬�뾶
	public int[][] planetPoints;
	
	//��ʼ���߷���
	private int lightDirectionX;
	private int lightDirectionY;
	//��ǰ�ؿ���Ϸ�ȼ�
	private int level;
	public GameData(int level){		
		lightControl = new LightControl();
		
		this.level = level;
		try {
			//���������ļ��е�������������
			LevelConfig levelCfg = ConfigFactory.getLEVEL_CFG();		
			DataConfig dataCfg = levelCfg.getDataConfig().get(this.level - 1);
			
			this.planetReflections = new ArrayList<PlanetReflection>(dataCfg.reflectionNum);
			this.planetRefractions = new ArrayList<PlanetRefraction>(dataCfg.refractionNum);
			this.planetBlackHoles = new ArrayList<PlanetBlackHole>(dataCfg.blackholeNum);
			
			List<PlanetConfig> planetsCfg = dataCfg.getPlanetsConfig();
			List<Planet> planets = new ArrayList<Planet>(planetsCfg.size());
			
			//���������������
			for (PlanetConfig planetConfig : planetsCfg) {
				Class<?> cla = Class.forName(planetConfig.getClassName());
				Constructor<?> ctr = cla.getConstructor(int.class, int.class, int.class, int.class, GameData.class);
				Planet planet = (Planet)ctr.newInstance(
						planetConfig.getLocationX(), 
						planetConfig.getLocationY(), 
						planetConfig.getRadius(), 
						planetConfig.getTag(),
						this);
				
				planets.add(planet);				
			}
			this.planetPoints = new int[planetsCfg.size()][3];
			
			for (int i = 0; i < planetPoints.length; i++) {
				this.planetPoints[i][0] = planets.get(i).getLocationX();
				this.planetPoints[i][1] = planets.get(i).getLocationY();
				this.planetPoints[i][2] = planets.get(i).getRadius();
			}
			
			//��������
			this.planetEarth = (PlanetEarth)planets.get(0);
			//����̫��
			this.planetSun = (PlanetSun)planets.get(1);
			//������������
			this.planetThreeBody = (PlanetThreeBody)planets.get(2);
			//������������
			for (int i = 3; i < 3+dataCfg.reflectionNum; i++) {
				this.planetReflections.add((PlanetReflection) planets.get(i));
			}
			//������������
			for (int i = 3+dataCfg.reflectionNum; i < 3+dataCfg.reflectionNum+dataCfg.refractionNum; i++) {
				this.planetRefractions.add((PlanetRefraction) planets.get(i));
			}
			//�����ڶ�
			for (int i = 3+dataCfg.reflectionNum+dataCfg.refractionNum; i < 3+dataCfg.reflectionNum+dataCfg.refractionNum+dataCfg.blackholeNum; i++) {
				this.planetBlackHoles.add((PlanetBlackHole) planets.get(i));
			}
			//�����涴
			if(dataCfg.wormholeNum == 1){
				this.haveWornhole = true;
				
				WormHoleConfig wormholeCfg = dataCfg.getWormholeConfig();
				
				Class<?> cla = Class.forName(wormholeCfg.getClassName());
				Constructor<?> ctr = cla.getConstructor(int.class, int.class, int.class, int.class, int.class, GameData.class);
				planetWormHole = (PlanetWormHole) ctr.newInstance(wormholeCfg.getLocation1X(), wormholeCfg.getLocation1Y(), wormholeCfg.getLocation2X(), wormholeCfg.getLocation2Y(), wormholeCfg.getRadius(), this); 
			
			}	
			
			this.lightDirectionX = this.planetSun.getLocationX()+this.planetSun.getRadius()-this.planetEarth.getLocationX()-this.planetEarth.getRadius();
			this.lightDirectionY = this.planetSun.getLocationY()+this.planetSun.getRadius()-this.planetEarth.getLocationY()-this.planetEarth.getRadius();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshLight() {
		lightControl = new LightControl();
	}

	public LightControl getLightControl() {
		return lightControl;
	}

	public PlanetEarth getPlanetEarth() {
		return planetEarth;
	}

	public PlanetSun getPlanetSun() {
		return planetSun;
	}

	public PlanetThreeBody getPlanetThreeBody() {
		return planetThreeBody;
	}
	
	public List<PlanetReflection> getPlanetReflections() {
		return planetReflections;
	}

	public List<PlanetRefraction> getPlanetRefractions() {
		return planetRefractions;
	}

	public List<PlanetBlackHole> getPlanetBlackHoles() {
		return planetBlackHoles;
	}

	public int getLevel() {
		return level;
	}

	public PlanetWormHole getPlanetWormHole() {
		return planetWormHole;
	}

	public int getLightDirectionX() {
		return lightDirectionX;
	}

	public int getLightDirectionY() {
		return lightDirectionY;
	}
	//
	public void refreshPlanet(int tag,Point location){
		this.planetPoints[tag][0]=location.x;
		this.planetPoints[tag][1]=location.y;
	}
}