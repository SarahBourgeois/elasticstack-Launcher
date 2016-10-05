package com.bourgeois.event;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.bourgeois.configuration.Configuration;
import com.bourgeois.displayText.WinLauncherText;

public class LaucherItemEvent extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Configuration conn = new Configuration();
	Desktop desk;

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) (e.getSource());

		if (item.getText().equals(WinLauncherText.getItemQuit())) {
			System.exit(1);
		}

		if (item.getText().equals("Open elasticsearch log"))
			desk = Desktop.getDesktop();
		try {
			desk.open(new File(conn.getPathLog()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}