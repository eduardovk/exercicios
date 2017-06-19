package view;

public class Menu {

	private static final int MAX_OPTIONS = 10;
	
	private String title;
	private Option[] options;
	private int countOptions;

	public Menu(String title) {
		this.title = title;
		this.countOptions = 0;
		this.options = new Option[MAX_OPTIONS];
	}

	public void execute(View view) {
		display(view);
		waitForUserInput(view);
	}

	private void waitForUserInput(View view) {
		do {
			String cmd = view.readString("Opcao: ");
			for (int i = 0; i < countOptions; i++) {
				if (options[i].executeIf(cmd))
					return;
			}
			view.showMessage("Opcao invalida!");
		} while (true);
	}

	private void display(View view) {
		view.showMessage(title);
		view.showMessage(String.format("%020d",0).replace("0","="));
		for (int i = 0; i < countOptions; i++) {
			options[i].show(view);
		}
	}

	public void addOption(Option option) {
		if (countOptions < MAX_OPTIONS) {
			options[countOptions] = option;
			countOptions++;
		}
	}

	
}
