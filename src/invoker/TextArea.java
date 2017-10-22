/**
 * @(#) TextArea.java
 */

package invoker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import command.Command;


public class TextArea extends JTextArea {

	private String content;
	private char lastChar;
	private int selectStart;
	private int selectLength;


	public void setContent(String text) {
		this.content = text;
		this.setText(content);
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

	public void setSelect(int start, int length) {
		selectStart = start;
		selectLength = length;
	}

	public String getContent() {
		return content;
	}


	public TextArea(HashMap<String, Command> h) {


		Command selectionner = h.get("selectionner");
		Command taper = h.get("taper");
		Command supprimer = h.get("supprimer");

		addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				int i = Math.min(e.getDot(), e.getMark());
				int j = Math.max(e.getDot(), e.getMark());
				int l = j - i;

				if (i != getSelectStart() || l != getSelectLength()) {
					setSelect(i, l);
					selectionner.execute();
				}
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
