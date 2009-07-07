package engine.gui;


import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import engine.Config;

public class Panel implements Widget {
	
	private String id;
	private int x;	
	private int y;
	private int width;
	private int height;
	private boolean hasBorder;
	private Image texture_background;
	private Image texture_border;	
	
	public Panel(String id, int x, int y, int width, int height, boolean hasBorder) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hasBorder = hasBorder;
		this.texture_background = Config.getTextureManager().getTextureByKey("texPanel");
		this.texture_border = Config.getTextureManager().getTextureByKey("border");	
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}	
	
	public void draw(Graphics g) {			
		
		texture_background.draw(x, y, width, height);	
		
		if(hasBorder) {
			//left border
			texture_border.draw(x, y, 1, height);
			//right border
			texture_border.draw(x + width - 1, y, 1, height);
			
			//top border
			texture_border.draw(x, y, width, 1);
			//bottom border
			texture_border.draw(x, y + height - 1, width, 1);	
		}
		
		
				
	}			

	@Override
	public WidgetType getType() {
		return WidgetType.PANEL;
	}

}
