/*
 *   Copyright (C) 2010 Maarten Lauwers
 *
 *   This program is free software; you can redistribute it and/or modify it under the terms of the 
 *   GNU General Public License as published by the Free Software Foundation; either version 2 of the License, 
 *   or (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *   without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *   See the GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License along with this program; 
 *   if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 *	 Email: maartenlauwers007@gmail.com 
 */

package engine.gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class PictureBox implements Widget {

	private String id;
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;
	
	public PictureBox(String id, int x, int y, int width, int height, Image image) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;		
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	
	public void setX(int x) {
		this.x = x ;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public WidgetType getType() {
		return WidgetType.LABEL;
	}
	
	public void draw(Graphics g) {
		image.draw(x, y, width, height);
	}

}
