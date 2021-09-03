/*
* File: Controller.java
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

package controller;

import view.MainWindow;
import view.Car;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller {
	MainWindow mainWindow = new MainWindow();
	javax.swing.Timer timer = 
	new javax.swing.Timer(200, new ActionListener(){
		public void actionPerformed(ActionEvent event){
			timerActionListener(event);
		}
	});
	public Controller() {
		mainWindow.buttonPanel.addStartButtonActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				startButtonActionListener(event);				
			}
		});
		mainWindow.buttonPanel.addStopButtonActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				stopButtonActionListener(event);
			}
		});
		mainWindow.buttonPanel.addShowSpeedButtonActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				showSpeedButtonActionListener(event);				
			}
		});
		mainWindow.buttonPanel.addResetButtonActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent event) {				
				resetButtonActionListener(event);
			}
		});
		mainWindow.buttonPanel.addAboutButtonActionListener(
		new ActionListener(){
			public void actionPerformed(ActionEvent event) {				
				aboutButtonActionListener(event);
			}
		});
	}
	
	public void startButtonActionListener(ActionEvent event) {
		timer.start();
		mainWindow.setTitle("Megy a futam");
	}
	
	public void stopButtonActionListener(ActionEvent event) {
		timer.stop();
		mainWindow.setTitle("Futam áll");
	}
	
	public void aboutButtonActionListener(ActionEvent event) {
		javax.swing.JOptionPane.showMessageDialog(
		mainWindow.getContentPane(), "Sallai András\n2014-05-27");
	}
	
	public void resetButtonActionListener(ActionEvent event) {
		for(Car car : mainWindow.track.cars) {
			resetCar(car);
		}		
		mainWindow.displayPanel.listModel.clear();
		mainWindow.repaint();
	}
	
	private void resetCar(Car car) {
		int startPosition = mainWindow.track.startPosition;
		int y = car.getLocation().y;
		car.setLocation(startPosition, y);
	}
	
	public void showSpeedButtonActionListener(ActionEvent event) {		
		if(mainWindow.buttonPanel.showSpeedButton.getModel().isSelected()){
			for(Car car : mainWindow.track.cars) {
				setSpeedVisible(car, true);
			}
		}else{
			for(Car car : mainWindow.track.cars) {
				setSpeedVisible(car, false);
			}
		}		
		mainWindow.repaint();
	}
	
	private void setSpeedVisible(Car car, boolean visible) {
		car.setSpeedVisible(visible);
	}
	
	public void timerActionListener(ActionEvent event) {
		mainWindow.repaint();
		mainWindow.go();
		for(int i=0; i<mainWindow.track.cars.size(); i++) {
			if(mainWindow.track.carHasTarget(mainWindow.track.cars.get(i))) {
				if(!mainWindow.displayPanel.listModel.contains(
				mainWindow.track.cars.get(i).getName())) {
					mainWindow.displayPanel.listModel.addElement(
					mainWindow.track.cars.get(i).getName());
				}
			}
		}		
	}	
}
