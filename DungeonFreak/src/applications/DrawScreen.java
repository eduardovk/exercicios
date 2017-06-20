package applications;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

import controller.EventoDoMouse;

public class DrawScreen
	extends GraphicApplication 
	implements MouseObserver 
{	
	private java.awt.Point ponto;
	private Image roomImage;
	private Image statusBar;
	Screen screen;
	Room room;
	RoomList roomList;
	
	@Override
	public void notify(MouseEvent event, int button, Point point) {
		if (event == MouseEvent.CLICK) {
			Point pontoClick = new Point(point.x, point.y);
			screen.Click(pontoClick, room, this);
		}
	}

	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		canvas.drawImage(roomImage, 0, 0);
		try
		{	
			this.ponto = canvas.getMousePosition();
		}
		catch(Exception e)
		{
			ponto.setLocation(0, 0);
		}
		canvas.drawImage(statusBar, 570, 0);
		screen.Draw(canvas, ponto, this.room);	
	}
	
	@Override
	protected void loop() {
		redraw();
	}

	@Override
	protected void setup() {	
		setFramesPerSecond(60);
		setResolution(Resolution.HIGHRES);
		addMouseObserver(MouseEvent.CLICK, this);
		addMouseObserver(MouseEvent.DOUBLECLICK, this);
		addMouseObserver(MouseEvent.CLICK, new MouseObserver(){
			@Override
			public void notify(MouseEvent e, int b, Point p) {
			}
		});
		addMouseObserver(MouseEvent.DOUBLECLICK,
				(e,b,p)->{
				});
		addMouseObserver(MouseEvent.CLICK, new EventoDoMouse());
		
		roomList = new RoomList();
		LoadRooms("rooms.txt", roomList);
		this.room = roomList.GetRoomByNumber(1);
		screen = new Screen();
		try {
			roomImage = new Image("Room.png");
			statusBar = new Image("StatusBar.png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void LoadRooms(String arquivo, RoomList list)
	{
		File file = new File(arquivo);
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				Room room = new Room(sc.nextLine());
				list.Add(room);
			}
			sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}