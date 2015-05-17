package control;

import audio.SoundEffect;
import gamecomponent.PlanetEarth;
import gamedata.GameData;
import gamedata.TotalData;
import ui.FrameTotal;
import ui.WindowDragger;
import ui_game.FrameWin;
import ui_game.PanelGame;
import ui_start.PanelEdit;
import ui_start.PanelSelectDIY;
import ui_start.PanelSelectMission;
import ui_start.PanelStartGame;
/**
 * ��Ϸ�����������ڽ���PlayerControl�������Ϣ����ˢ��JPanelGame��
 * @author �����
 * 2015.4.13.
 */
public class GameControl {
	/**
	 * ��Ϸ����
	 */
	private FrameTotal frameTotal;
	/**
	 * ��ʼ�����
	 */
	private PanelStartGame panelStartGame;
	/**
	 * ѡ�ؽ����
	 */
	private PanelSelectMission panelSelectMission;
	/**
	 * �Զ����
	 */
	private PanelSelectDIY panelSelectDIY;
	/**
	 * ��Ϸ��ƽ���
	 */
	private PanelEdit panelEdit;
	/**
	 * ��Ϸ�����
	 */
	private PanelGame panelGame;
	/**
	 * ������Ϸ����
	 */
	private GameData gameData;
	
	public GameControl(){
	}
	
	/**
	 * ����Ϸ�������м������
	 * @param frameTotal
	 */
	public void addFrame(FrameTotal frameTotal) {
		this.frameTotal = frameTotal;	
	}
	
	public void setPanelStartGame(PanelStartGame panelStartGame) {
		this.panelStartGame = panelStartGame;
	}
	public void setPanelSelectMission(PanelSelectMission panelSelectMission) {
		this.panelSelectMission = panelSelectMission;
	}
	public void setPanelSelectDIY(PanelSelectDIY panelSelectDIY) {
		this.panelSelectDIY = panelSelectDIY;
	}
	public void setPanelGame(PanelGame panelGame) {
		this.panelGame = panelGame;
	}
	public void setPanelEdit(PanelEdit panelEdit) {
		this.panelEdit = panelEdit;
	}
	
	//
	public void stopDrag(){
		if(this.panelGame != null){
			this.panelGame.stopDrag();
		}else if (this.panelEdit != null){
			this.panelEdit.stopDrag();
		}
		
	}
	
	/**
	 * �������
	 * @param launchX
	 * @param lightY
	 */
	public void launchLight() {
		if(this.panelGame != null){
			this.printPlanetLocation();
			this.gameData.getLightControl().launchLight(PlanetEarth.launchX, PlanetEarth.launchY, this.gameData.getLightDirectionX(), this.gameData.getLightDirectionY());
			this.panelGame.repaint();
			//��Ч
			SoundEffect.LIGHT.play();		
		}else if(this.panelEdit != null){
			this.gameData.getPlanetEarth().setLocations();
			this.gameData.setLaunchDirections();
			this.gameData.getLightControl().launchLight(PlanetEarth.launchX, PlanetEarth.launchY, this.gameData.getLightDirectionX(), this.gameData.getLightDirectionY());
			this.panelEdit.repaint();
			//��Ч
			SoundEffect.LIGHT.play();
		}
	}
	//==========================�����Ǹ�����������ת����==============================
	/**
	 * �ӿ�ʼ�������DIY������ת��ѡ�ؽ���
	 */
	public void toSelectMission() {
		this.frameTotal.musicStart.stop();
		SoundEffect.ENTER.play();
		if(this.panelStartGame != null){
			this.frameTotal.remove(this.panelStartGame);
			this.panelStartGame = null;
		}else if(this.panelSelectDIY != null){
			this.frameTotal.remove(this.panelSelectDIY);
			this.panelSelectDIY = null;
		}
		
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ��ͨ�ؽ��淵����ѡ�ؽ���
	 */
	public void returnFromWin() {
		this.panelGame.closeFrameWin();
		SoundEffect.ENTER.play();
		this.frameTotal.remove(this.panelGame);
		this.panelGame = null;
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ����Ϸ���淵��ѡ�ؽ���
	 */
	public void returnFromGame() {
		this.panelGame.closeFrameWin();
		this.frameTotal.remove(this.panelGame);
		this.panelGame.clock.stop();
		SoundEffect.ENTER.play();
		this.panelGame = null;
		this.frameTotal.initPanelSelectMission();
	}
	
	/**
	 * ��ѡ�ؽ��淵������ʼ����
	 */
	public void returnToStart() {
		SoundEffect.ENTER.play();	
		this.frameTotal.musicSelect.stop();
		if(this.panelSelectMission != null){
			this.frameTotal.remove(this.panelSelectMission);
			this.panelSelectMission = null;
		}else if(this.panelSelectDIY != null){
			this.frameTotal.remove(this.panelSelectDIY);
			this.panelSelectDIY = null;
		}
		this.frameTotal.initPanelStartGame();
	}
	
	/**
	 * �����Զ������
	 */
	public void toSelectDIY() {
		this.frameTotal.musicStart.stop();
		SoundEffect.ENTER.play();
		if(this.panelSelectMission != null){
			this.frameTotal.remove(this.panelSelectMission);
			this.panelSelectMission = null;
		}else if(this.panelEdit != null){
			this.frameTotal.remove(this.panelEdit);
			this.panelEdit = null;
		}		
		this.frameTotal.initPanelGameSelectDIY();
	}
	
	/**
	 * ����ؿ���ƽ���
	 */
	public void toPanelEdit() {
		this.gameData =new GameData("edit");
		SoundEffect.ENTER.play();
		this.frameTotal.musicSelect.stop();
		this.frameTotal.remove(this.panelSelectDIY);
		this.panelSelectDIY = null;
		this.frameTotal.initPanelEdit(this.gameData);		
	}
	
	/**
	 * �򿪰�������
	 */
	public void openFrameHelp(){
		SoundEffect.ENTER.play();
		this.panelStartGame.jbtHelp.setVisible(false);
		this.panelStartGame.jbtQuit.setVisible(false);
		this.panelStartGame.openFrameHelp();
		
	}
	
	/**
	 * �رհ�������
	 */
	public void closeFrameHelp() {
		SoundEffect.ENTER.play();
		this.panelStartGame.closeFrameHelp();
		this.panelStartGame.jbtHelp.setVisible(true);
		this.panelStartGame.jbtQuit.setVisible(true);
	}

	/**
	 * ������һ��
	 */
	public void nextLevel() {
		//�ر�ͨ�ؽ���
		this.panelGame.closeFrameWin();
		SoundEffect.ENTER.play();
		//���½���������Ϸ����
		this.gameData = new GameData(this.gameData.nextLevel(this.gameData.getFileName()));
		//�Ƴ�ԭ�е���Ϸ����
		this.frameTotal.remove(this.panelGame);
		this.panelGame = null;
		//��һ����Ϸ����
		this.frameTotal.initPanelGame(this.gameData);
	}
	
	/**
	 * �˳���Ϸ
	 */
	public void Quit() {
		SoundEffect.ENTER.play();
		FrameTotal.TOTALDATA.saveData();
		this.frameTotal.removeAll();
		this.frameTotal.dispose();
		System.exit(0);
	}

	/**
	 * ��ѡ�ؽ�����������Ϸ����
	 * @param level
	 */
	public void toGameLevel(String fileName) {		
		SoundEffect.ENTER.play();
		this.gameData =new GameData(fileName);
		this.frameTotal.musicSelect.stop();
		if(this.panelSelectMission != null){
			this.frameTotal.remove(this.panelSelectMission);
			this.panelSelectMission = null;
		}else if(this.panelSelectDIY != null){
			this.frameTotal.remove(this.panelSelectDIY);
			this.panelSelectDIY = null;
		}
		if(this.gameData.getFileName() == "edit"){
			this.frameTotal.initPanelEdit(this.gameData);		
		}else{
			this.frameTotal.initPanelGame(this.gameData);	
			this.panelGame.addControl(this);
		}	
	}
	
	/**
	 * �ı����ֱ���
	 * @param resolution �·ֱ���
	 */
	public void changeResolution(int resolution){
		if((FrameTotal.TOTALDATA.getResolution() != resolution)&&(this.panelStartGame != null)){
			FrameTotal.TOTALDATA.setResolution(resolution);
			FrameTotal.TOTALDATA.saveData();
			this.frameTotal.dispose();
			this.frameTotal = new FrameTotal(this);
		}
	}

	public void printPlanetLocation() {
		System.out.println("���� :x="+this.gameData.getPlanetEarth().getLocationX()+"||y="+this.gameData.getPlanetEarth().getLocationY());
		System.out.println("���� :x="+this.gameData.getPlanetThreeBody().getLocationX()+"||y="+this.gameData.getPlanetThreeBody().getLocationY());
		for (int i = 0; i < this.gameData.getPlanetReflections().size(); i++) {
			System.out.println("����"+i+":x="+this.gameData.getPlanetReflections().get(i).getLocationX()+"||y="+this.gameData.getPlanetReflections().get(i).getLocationY());
		}
		for (int i = 0; i < this.gameData.getPlanetRefractions().size(); i++) {
			System.out.println("����"+i+":x="+this.gameData.getPlanetRefractions().get(i).getLocationX()+"||y="+this.gameData.getPlanetRefractions().get(i).getLocationY());
		}
		for (int i = 0; i < this.gameData.getPlanetBlackHoles().size(); i++) {
			System.out.println("�ڶ�"+i+":x="+this.gameData.getPlanetBlackHoles().get(i).getLocationX()+"||y="+this.gameData.getPlanetBlackHoles().get(i).getLocationY());
		}
	}
	
	//�洢�༭�������Ϸ��ƣ������xml�ļ�
	public void saveData() {
		this.panelEdit.saveData();
	}

	//��༭�����м�������
	public void addPlanet(char planetTag) {
		this.panelEdit.addPlanet(planetTag);
	}
	
	//ɾ���༭�����е�����
	public void deletePlanet(char planetTag) {
		this.panelEdit.deletePlanet(planetTag);
	}
}