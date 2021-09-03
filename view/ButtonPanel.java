/*
* File: ButtonPanel.java
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

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;

public class ButtonPanel extends JPanel {
	JButton startButton;
	JButton stopButton;
	public JToggleButton showSpeedButton;
	JButton resetButton;
	JButton aboutButton;
	public ButtonPanel() {
		initComponents();
	}
	private void initComponents() {
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		showSpeedButton = new JToggleButton("Mutat sebesség");
		resetButton = new JButton("Kezdőhelyzet");
		aboutButton = new JButton("Programról");
		setBorder(
			BorderFactory.createCompoundBorder(
				new EmptyBorder(10, 10, 10, 10),
				new TitledBorder("Vezérlő")
			)
		);		
		
		add(startButton);
		add(stopButton);
		add(showSpeedButton);
		add(resetButton);
		add(aboutButton);
	}
	public void addStartButtonActionListener(ActionListener listener) {
		startButton.addActionListener(listener);
	}
	public void addStopButtonActionListener(ActionListener listener) {
		stopButton.addActionListener(listener);
	}
	public void addShowSpeedButtonActionListener(ActionListener listener) {
		showSpeedButton.addActionListener(listener);
	}
	public void addResetButtonActionListener(ActionListener listener) {
		resetButton.addActionListener(listener);
	}
	public void addAboutButtonActionListener(ActionListener listener) {
		aboutButton.addActionListener(listener);
	}
}
