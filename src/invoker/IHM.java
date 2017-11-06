
package invoker;

import command.Command;
import command.CommandM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class IHM {

	private JFrame frame;
	protected TextArea textArea;

	private Command couper;
	private Command copier;
	private Command coller;
	private Command selectionner;
	private Command taper;
	private Command supprimer;

	private CommandM faire;
	private CommandM defaire;

	public IHM() {
		frame = new JFrame("Mini Editeur 1.0");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	}

	public void show() {
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void addButton(String nom, Command cmd) {
		myButton bouton = new myButton(nom, cmd);

		bouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.requestFocusInWindow();
			}
		});

		frame.add(bouton);
	}

	/*
	Momento ***
	 */

	private void addButton(String nom, CommandM cmd) {
		myButton bouton = new myButton(nom, cmd);

		bouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.requestFocusInWindow();
			}
		});

		frame.add(bouton);
	}
	/*
	Momento ***
	 */

	public void initButtons() {
		addButton("Couper",  couper);
		addButton("Copier",  copier);
		addButton("Coller",  coller);
	/*
	Momento ***
	 */
		addButton("Faire",   faire);
		addButton("Defaire", defaire);
			/*
	Momento ***
	 */
	}


	public void addTextArea(int rows, int cols) {
		HashMap<String, Command> cmds = new HashMap<String, Command>();
		cmds.put("selectionner", selectionner);
		cmds.put("taper", taper);
		cmds.put("supprimer", supprimer);
		textArea = new TextArea(cmds);
		textArea.setRows(rows);
		textArea.setColumns(cols);
		JScrollPane scroll = new JScrollPane(textArea);
		frame.add(scroll);
	}

	public char getChar() {
		return textArea.getLastChar();
	}

	public int getDebutSelection() {
		return textArea.getSelectStart();
	}

	public int getSelectionLength() {
		return textArea.getSelectLength();
	}

	public void setCommands(HashMap<String, Command> cmds){
		this.couper = cmds.get("couper");
		this.copier = cmds.get("copier");
		this.coller = cmds.get("coller");
		this.selectionner = cmds.get("selectionner");
		this.taper = cmds.get("taper");
		this.supprimer = cmds.get("supprimer");
	}
	public void setCommandMs(HashMap<String, CommandM> cmds){
		this.faire = cmds.get("faire");
		this.defaire = cmds.get("defaire");
	}

}
