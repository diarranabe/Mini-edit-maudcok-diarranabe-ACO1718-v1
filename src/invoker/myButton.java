
package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import command.Command;

public class myButton extends JButton {
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
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
	}

}
