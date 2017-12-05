
package invoker;

import command.Command;
import command.CommandMacro;

import javax.swing.*;

class myButton extends JButton {
	private String label;

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public myButton(String label, final Command cmd) {
		super(label);
		this.label = label;
		this.addActionListener(e -> cmd.execute());
	}



	/*
	Momento
	 */
	public myButton(String label, final CommandMacro cmd) {
		super(label);
		this.label = label;
		this.addActionListener(e -> cmd.execute());
	}
		/*
	Momento
	 */

}
