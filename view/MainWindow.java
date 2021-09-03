/*
* File: MainWindow.java
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

import view.Track;
import view.ButtonPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class MainWindow extends JFrame {
	public Track track = new Track();
	public ButtonPanel buttonPanel = new ButtonPanel();
	public DisplayPanel displayPanel = new DisplayPanel();
	
	public MainWindow() {
		initComponents();
	}
	public void initComponents() {		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(track);
		add(buttonPanel);
		add(displayPanel);
		centerWindow(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		pack();
		centerWindow(this);
		setVisible(true);		
	}
	public void go() {
		track.go();
	}
	public static void centerWindow(java.awt.Window frame) {
		java.awt.Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}	
}
