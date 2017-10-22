
package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import command.Command;

public class IHM {

	private JFrame frame;
	private Collection<myButton> buttons;

	protected TextArea textArea;


	private Command couper;
	private Command copier;
	private Command coller;
	private Command selectionner;
	private Command taper;
	private Command supprimer;

	public IHM() {
		frame = new JFrame("MiniEditeur v1");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		buttons = new ArrayList<myButton>();
	}


	public void show() {
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	private void addButton(String nom, Command cmd) {
		myButton bouton = new myButton(nom, cmd);
		buttons.add(bouton);

		bouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.requestFocusInWindow();
			}
		});

		frame.add(bouton);
	}


	public void initButtons() {
		addButton("Couper", couper);
		addButton("Copier", copier);
		addButton("Coller", coller);
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

	/**
	 * Obtient le plus récent caractère tapé dans la zone de texte.
	 * 
	 * @return char c
	 */
	public char getChar() {
		return textArea.getLastChar();
	}


	public int getDebutSelection() {
		return textArea.getSelectStart();
	}

	public int getSelectionLength() {
		return textArea.getSelectLength();
	}

	// Initialise les commandes
	public void setCommands(HashMap<String, Command> h){
		this.couper = h.get("couper");
		this.copier = h.get("copier");
		this.coller = h.get("coller");
		this.selectionner = h.get("selectionner");
		this.taper = h.get("taper");
		this.supprimer = h.get("supprimer");
	}

}
