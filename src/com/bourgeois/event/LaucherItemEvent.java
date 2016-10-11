package com.bourgeois.event;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import com.bourgeois.configuration.Configuration;


public class LaucherItemEvent extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final ResourceBundle bundle = ResourceBundle.getBundle("displaytext.ressources");
	Configuration conn = new Configuration();
	Desktop desk;

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) (e.getSource());

		if (item.getText().equals(bundle.getString("quit.item"))) {
			System.exit(1);
		}

		if (item.getText().equals(bundle.getString("openlog.item")))
			desk = Desktop.getDesktop();
		try {
			desk.open(new File(conn.getPathLog()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}