package view;

import model.Action;

public class Option {

	private String label;
	private String command;
	private Action action;

	public Option(String label, String command, Action action) {
		this.label = label;
		this.command = command;
		this.action = action;
	}

	public void show(View view) {
		view.showMessage(label);
	}

	public boolean executeIf(String cmd) {
		if (label.equalsIgnoreCase(cmd) || command.equalsIgnoreCase(cmd)) {
			action.execute();
			return true;
		}
		return false;
	}

}