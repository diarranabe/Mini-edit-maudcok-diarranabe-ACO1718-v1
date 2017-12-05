
package invoker;

import command.Command;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;


public class TextArea extends JTextArea {

	private char lastChar;
	private int selectStart;
	private int selectLength;


	private void setContent(String text) {
		this.setText(text);
	}

	public char getLastChar() {
		return lastChar;
	}

	public int getSelectStart() {
		return selectStart;
	}

	public int getSelectLength() {
		return selectLength;
	}

	private void setSelect(int start, int length) {
		selectStart = start;
		selectLength = length;
	}

// --Commented out by Inspection START (04/12/2017 14:24):
//	public String getContent() {
//		return content;
//	}
// --Commented out by Inspection STOP (04/12/2017 14:24)


	public TextArea(HashMap<String, Command> cmds) {

		Command selectionner = cmds.get("selectionner");
		Command taper = cmds.get("taper");
		Command supprimer = cmds.get("supprimer");

		addCaretListener(e -> {
            int start = Math.min(e.getDot(), e.getMark());
            int end = Math.max(e.getDot(), e.getMark());
            int length = end - start;

            if (start != getSelectStart() || length != getSelectLength()) {
                setSelect(start, length);
                selectionner.execute();
            }
        });

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
				char keyChar = e.getKeyChar();
				if (keyChar != '\b') {

						lastChar = keyChar;
					taper.execute();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {// si la touche est un caractère
					e.consume();
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						supprimer.execute();
					}
				}
			}
		});
	}

	public void refresh(String texte, int selectStart, int length) {
		setContent(texte);
		setSelectionStart(selectStart);
		setSelectionEnd(selectStart + length);
		setSelect(selectStart, length);
		requestFocusInWindow();
	}

}
