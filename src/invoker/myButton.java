
package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import command.Command;
import command.CommandM;

public class myButton extends JButton {
	private String label;

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	/**
	 * Instanaciation with a Command
	 * @param label button's label
	 * @param cmd button's Command
	 */
	public myButton(String label, final Command cmd) {
		super(label);
		this.label = label;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
	}

	/**
	 * Instanciation with a Momento command
	 * @param label the label
	 * @param cmd Momento command
	 */
	public myButton(String label, final CommandM cmd) {
		super(label);
		this.label = label;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
	}
}
