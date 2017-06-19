package controller;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

public class EventoDoMouse implements MouseObserver {

	@Override
	public void notify(MouseEvent arg0, int arg1, Point arg2) {
		Console.println("Evento do mouse em uma classe.");
	}

}
