package applications;
import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Door extends Item {	
	private String tipo;
	private int sala;
	boolean travada = false;
	boolean bloqueada = false;
	
	public Door(String tipo, String categoria, int sala, int x, int y, int tamX, int tamY, String lastDoor)
	{
		this.tipo = tipo;
		this.setCategoria(categoria);
		this.sala = sala;
		this.setX(x);
		this.setY(y);
		this.setTamX(tamX);
		this.setTamY(tamY);
		try 
		{
			this.setSelected(new Image("Selected" + tipo + ".png"));
			if(!tipo.equals("Up") && !tipo.equals("Down"))
			{
				this.setImagem(new Image(this.CalcularPossibilidade() + ".png"));
			}
			else
			{
				this.setImagem(new Image(tipo + ".png"));
			}			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	@Override
	public void Click(DrawScreen dw)
	{
		if(!travada && !bloqueada)
		{
			
			if(sala == 0)
			{
				dw.screen.setWin(true);
			}
			else
			{
				dw.room = dw.roomList.GetRoomByNumber(this.sala);
			}
		}
		else if(!bloqueada)
		{
			try
			{	
				String i1 = "-";
				String i2 = "-";
				if(dw.screen.getIt1() != null)
				{
					 i1 = dw.screen.getIt1().getTipo();
				}
				if(dw.screen.getIt2() != null)
				{
					 i2 = dw.screen.getIt2().getTipo();
				}
				if(this.tipo.equals(i1 + "North") || this.tipo.equals(i1 + "South") || this.tipo.equals(i1 + "West") || this.tipo.equals(i1 + "East"))
				{
					if(sala == 0)
					{
						dw.screen.setWin(true);
					}
					else
					{
						dw.room = dw.roomList.GetRoomByNumber(this.sala);
					}
				}
				else if(this.tipo.equals(i2 + "North") || this.tipo.equals(i2 + "South") || this.tipo.equals(i2 + "West") || this.tipo.equals(i2 + "East"))
				{
					if(sala == 0)
					{
						dw.screen.setWin(true);
					}
					else
					{
						dw.room = dw.roomList.GetRoomByNumber(this.sala);
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public String CalcularPossibilidade()
	{
		int num = (int) (Math.random()*100);
		String cor;
		this.travada = true;
		if(num <= 80)
		{
			cor = "";
			this.travada = false;
		}
		else if(num <= 85)
			cor = "Blue";			
		else if(num <= 90)
			cor = "Green";
		else if(num <= 95)
			cor = "Red";
		else
			cor = "Yellow";
			tipo = cor + tipo;
		
		return tipo;
	}
}
