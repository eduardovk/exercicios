package applications;


import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

import controller.EventoDoMouse;

public class DrawScreen
	extends GraphicApplication // Para aplicacoes graficas com SimpleJava
	implements MouseObserver // Para responder a eventos de mouse na propria applicacao
{	
	private java.awt.Point ponto;
	private Image roomImage;
	private Image statusBar;
	Screen screen;
	Room room;
	RoomList roomList;
	
	private boolean red = false;
	
	@Override
	public void notify(MouseEvent event, int button, Point point) {
		// ajusta posicao final da linha.
		if (event == MouseEvent.CLICK) {
			Point pontoClick = new Point(point.x, point.y);
			screen.Click(pontoClick, room, this);
			
			// !!!!!!!
			Item itemAtual = room.getItemList().getHead();
			Console.println("Itens da room: ");
			for(int i = 0; i < room.getItemList().GetTamanho(); i++)
			{
				Console.println(itemAtual.getTipo());
				itemAtual = itemAtual.getProximo();
			}
			// !!!!!!!
			
		}
		if (event == MouseEvent.DOUBLECLICK) {
			
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
		/*
		 * Cria um ponto randomico.
		 * 
		 * int x = (int)(Math.random() * 100):
		 * int y = (int)(Math.random() * 100):
		 * this.point = new Point(x,y);
		 */
		// forca a tela a ser redesenhada.
		redraw();
		
	}

	@Override
	protected void setup() {
		
		try{
			
		}
		catch(Exception e)
		{
			Console.print(e.getMessage());
		}
		
		
		// ajusta o numero maximo de vezes por segundo que "loop()" sera executado
		setFramesPerSecond(60);
		// ajusta a resolucao
		setResolution(Resolution.HIGHRES);
		
		int x = getResolution().width / 2;
		int y = getResolution().height / 2;
		System.out.println(x*2 + " " + y*2);
		
		// adiciona o objeto da aplicacao a lista de observadores de eventos de mouse.
		addMouseObserver(MouseEvent.CLICK, this);
		addMouseObserver(MouseEvent.DOUBLECLICK, this);
		
		// adiciona um observador de mouse implementando a interface.
		addMouseObserver(MouseEvent.CLICK, new MouseObserver(){
			@Override
			public void notify(MouseEvent e, int b, Point p) {
				Console.println("Evento de mouse na INTERFACE.");
			}
		});

		// adiciona um observador de mouse com "lambdas" do Java 8.
		addMouseObserver(MouseEvent.DOUBLECLICK,
				(e,b,p)->{
					Console.println("Evento de mouse com LAMBDA");
				});

		// adiciona um observador de mouse utilizando uma classe de objetos.
		addMouseObserver(MouseEvent.CLICK, new EventoDoMouse());
		
		
		Scanner sc = new Scanner(System.in);
		roomList = new RoomList();
		LoadRooms("rooms.txt", roomList);
		this.room = roomList.GetRoomByNumber(1);
		screen = new Screen();
		try {
			roomImage = new Image("Room.png");
			statusBar = new Image("StatusBar.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ponto = new java.awt.Point(0, 0);
		
	}
	
	private void LoadRooms(String arquivo, RoomList list)
	{
		File file = new File(arquivo);
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				//Console.println(sc.nextLine());
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