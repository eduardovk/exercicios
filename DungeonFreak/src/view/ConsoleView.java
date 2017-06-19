package view;

import com.senac.SimpleJava.Console;

public class ConsoleView implements View {

	@Override
	public void showMessage(String msg) {
		Console.println(msg);
	}

	@Override
	public String readString(String prompt) {
		return Console.readString(prompt);
	}

}
