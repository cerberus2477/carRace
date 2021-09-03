/*
* File: Car.java
* Author: Sallai András
* Copyright: 2014, Sallai András
* Date: 2014-05-28
* Web: https://szit.hu
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details:
* http://www.gnu.org/licenses/gpl.html
*
*/

package view;

import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Car extends JComponent {
	Color color;
	Integer actSpeed;
	int maxSpeed;
	boolean speedVisible;
	String name;
	
	Car(String name, Color color, int initSpeed, int x, int y) {
		this.color = color;		
		this.actSpeed = initSpeed;
		this.maxSpeed = 20;
		this.speedVisible = false;
		this.name = name;
		this.setLocation(x, y);
		this.setSize(60, 30);
	}
	
	public void paintComponent(Graphics g) {
		Color actColor = g.getColor();
		g.setColor(this.color);
		g.fillRect(0, 0, 60, 30);
		g.setColor(Color.white);
		if(this.speedVisible){
			g.drawString (actSpeed.toString(), 20, 20);
		}
		g.setColor(actColor);
	}
	
	public void go() {
		int x = getLocation().x;
		int y = getLocation().y;
		x = x + this.actSpeed;
		setLocation(x, y);
		setSpeed();			
	}
	
	public void setSpeedVisible(boolean speedVisible){
		this.speedVisible = speedVisible;
	}
	
	public String getName(){
		return this.name;
	}
		
	public void setSpeed(){
		Random random = new Random();
		boolean booster = random.nextBoolean();
		int newSpeedNum = random.nextInt(3) + 1;		
		
		if(booster) {
			if(maxSpeed>(this.actSpeed + newSpeedNum)) {
				this.actSpeed = this.actSpeed + newSpeedNum;
			}
		}else {
			if((this.actSpeed - newSpeedNum) >0){
				this.actSpeed = this.actSpeed - newSpeedNum;
			}
		}		
	}	
}
