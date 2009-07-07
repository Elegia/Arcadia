package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import engine.Config;
import engine.gui.EmptyWindow;
import engine.gui.EventActionType;
import engine.gui.Window;
import engine.gui.widgets.Button;
import engine.gui.widgets.Label;
import engine.gui.widgets.Panel;
import engine.gui.widgets.PictureBox;

public class TownInfoView {

	private Window window;
	private Panel panel;
	
	private Label labelTown;
	private Label labelPopulation;
	
	private Label labelGold;
	private Label labelFood;
	private Label labelTreasury;
	private Label labelTaxes;
	private Label labelFoodstocks;
	private Label labelProduction;
	private Label labelConsumption;
	
	private PictureBox picture;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Kingdom kingdom;
	
	public TownInfoView(Game game, Kingdom kingdom) {
		this.x = Config.getScreenWidth() - 300;
		this.y = Config.getScreenHeight() - 30 - 400;
		this.width = 300;
		this.height = 400;	
		this.kingdom = kingdom;
		
		window = new EmptyWindow("TownInfo", x, y, width, height);
		panel = new Panel("TownInfo", 0, 0, width, height, true);
		
		
		labelTown = new Label("TownInfo", 10, 10, kingdom.getName() + " town info");
		labelPopulation = new Label("TownInfo", 10, 30, "Population: " + kingdom.getPopulation());
		
		labelGold = new Label("TownInfo", 10, 60, "Gold:");
		labelTreasury = new Label("TownInfo", 10, 90, "Treasury: " + kingdom.getWealth());
		labelTaxes = new Label("TownInfo", 10, 110, "Taxes: " + 0);
		
		labelFood = new Label("TownInfo", 160, 60, "Food:");			
		labelFoodstocks = new Label("TownInfo", 160, 90, "Foodstocks: " + kingdom.getFood());
		labelProduction = new Label("TownInfo", 160, 110, "Production: " + 0);
		labelConsumption = new Label("TownInfo", 160, 130, "Consumption: " + kingdom.getPopulation() * 3);
		
		picture = new PictureBox("TownInfo", 150, 260, 128, 118, Config.getTextureManager().getTextureByKey("sword_and_shield"));
		
		Button closeButton = new Button("TownInfo", EventActionType.CLOSE, 10, 370, "Close", "CloseTownInfo");
		closeButton.addGuiListener(game);
				
		window.addWidget(panel);
		window.addWidget(labelTown);
		window.addWidget(labelPopulation);
		window.addWidget(labelGold);
		window.addWidget(labelFood);
		window.addWidget(labelTreasury);
		window.addWidget(labelTaxes);
		window.addWidget(labelFoodstocks);
		window.addWidget(labelProduction);
		window.addWidget(labelConsumption);
		window.addWidget(picture);
		window.addWidget(closeButton);
	}
	
	public Window getWindow() {
		return window;
	}
		
	public void draw(Graphics g) {
		window.draw(g);		
	}
	
	public void isMouseOver(int mouseX, int mouseY) {
		window.isMouseOver(mouseX, mouseY);				
	}
	
	public boolean isMouseClicked(int mouseX, int mouseY) {
		return window.isMouseClicked(mouseX, mouseY);
	}
	
	public void update(int population, int treasury, int taxes, int foodstocks, int production, int consumption) {
		
		TrueTypeFont ttf = Config.getCurrentFont();
		
		labelPopulation.setText("Population: " + population);
		labelTreasury.setText("Treasury: " + treasury);
		labelTaxes.setText("Taxes: " + taxes);
		labelFoodstocks.setText("Foodstocks: " + foodstocks);
		labelProduction.setText("Production: " + production);
		labelConsumption.setText("Consumption: " + consumption);			
	}
}
