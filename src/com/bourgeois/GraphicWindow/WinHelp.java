package com.bourgeois.GraphicWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.*;

public class WinHelp extends JFrame {
	private static final long serialVersionUID = 1L;
	// ================================
	// Declare Windows and components
	// ================================

	// principal pan
	JPanel principalPan;

	// secondary pan
	JPanel fondTitle;
	JPanel fondText;
	JPanel fondButton;

	// components
	JLabel lbl_title;
	JLabel lbl_text;
	JButton btn_exit;

	public WinHelp() throws HeadlessException {
		super();

		principalPan = new JPanel();
		principalPan.setLayout(new GridLayout(3, 1));
		
		// Title
		fondTitle = new JPanel();
		fondTitle.setLayout(new GridBagLayout());
		
		lbl_title = new JLabel("About the Elastic Launcher");
		lbl_title.setSize(new Dimension(250, 200));
		lbl_title.setBackground(Color.blue);
		

		// ==========================================
		// add different pan to principal pan
		// ==========================================
		
		this.setContentPane(principalPan);

		// ==========================================
		// Custom principal pan
		// ==========================================
		this.setTitle("Help");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
	}

}
