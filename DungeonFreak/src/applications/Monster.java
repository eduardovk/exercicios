package applications;

import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Monster extends Item{
	private int atk;
	private int health;
	private Door door;
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	private int precision;
	
	public Monster(String tipo, String categoria, String local, Door door, int tamX, int tamY)
	{
		this.setTipo(tipo);
		this.setCategoria(categoria);
		this.door = door;
		if(tipo.equals("Goblin"))
		{
			atk = 2;
			precision = 80;
			health = 5;
		}
		else if(tipo.equals("Orc"))
		{
			atk = 4;
			precision = 75;
			health = 10;
		}
		else if (tipo.equals("Troll"))
		{
			atk = 6;
			precision = 50;
			health = 15;
		}
		if(local.equals("North"))
		{
			this.setX(255);
			this.setY(71);
		}
		else if(local.equals("South"))
		{
			this.setX(255);
			this.setY(364);
		}
		else if(local.equals("West"))
		{
			this.setX(79);
			this.setY(225);
		}
		else
		{
			this.setX(418);
			this.setY(225);
		}
		this.setTamX(tamX);
		this.setTamY(tamY);
		try {
			this.setSelected(new Image("Selected" + tipo + ".png"));
			this.setImagem(new Image(tipo + ".png"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void Click(DrawScreen dw)
	{
		dw.screen.Duel(this, dw, door);
	}
	
	public void RemoveMonster(DrawScreen dw)
	{
		dw.room.getItemList().Remove(this);
	}
	
}
