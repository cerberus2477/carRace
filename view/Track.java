/*
* File: Track.java
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

import view.Car;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class Track extends JPanel {
	
	public ArrayList<Car> cars;
	public int startPosition = 15;
	public final int TARGET_POSITION = 600;
	private int trackHeight = 180;
	public int initSpeed = 7;

	public Track() {
		cars = new ArrayList<>();
		cars.add(new Car("Piros", Color.red, initSpeed, startPosition, 25));
		cars.add(new Car("Kék", Color.blue, initSpeed, startPosition, 65));
		cars.add(new Car("Zöld", Color.green, initSpeed, startPosition, 105));		

		for(Car car : cars) {
			add(car);
		}

		setLayout(null);
		setPreferredSize(new Dimension(700, trackHeight));
		setBorder(
			BorderFactory.createCompoundBorder(
				new EmptyBorder(10, 10, 10, 10),
				new TitledBorder("Pálya")
			)
		);
	}
	
	public void go() {
		for(Car car : cars) {
			if(!carIsInBox(car)) {
				car.go();
			}
		}
	}
	
	public boolean carHasTarget(Car car) {
		int x = car.getLocation().x;
		int width = car.getSize().width;
		if(x + width >= TARGET_POSITION) {		
			return true;
		}else {
			return false;
		}
	}

	public boolean carIsInBox(Car car) {
		int x = car.getLocation().x;
		if(x >= TARGET_POSITION) {		
			return true;
		}else {
			return false;
		}
	}
	
	public void paintComponent(Graphics g) {
		Color actColor = g.getColor();
		g.setColor(Color.blue);
		g.drawLine(TARGET_POSITION, 0, TARGET_POSITION, trackHeight);
		g.setColor(actColor);
	}
}
