/*
* File: DisplayPanel.java
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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;

public class DisplayPanel extends JPanel {
	public DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> list = new JList<String>(listModel);
	JScrollPane sp = new JScrollPane(list);
	public DisplayPanel() {
		setBorder(
			BorderFactory.createCompoundBorder(
				new EmptyBorder(10, 10, 10, 10),
				new TitledBorder("Megjelenítő")
			)
		);
		add(sp);
	}
}
