package applications;

import java.io.IOException;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;

public class Screen {
	int x, y;
	//private String item1 = "", item2 = "";
	private Item it1, it2;
	private int health = 100;
	

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	//private Image item1Image;
	//private Image item2Image;
	private Item newItem;
	private boolean onItemSelection = false;
	
	public Item getIt1() {
		return it1;
	}

	public void setIt1(Item it1) {
		this.it1 = it1;
	}

	public Item getIt2() {
		return it2;
	}

	public void setIt2(Item it2) {
		this.it2 = it2;
	}
	
//	public String getItem1() {
//		return item1;
//	}

//	public void setItem1(String item1) {
//		this.item1 = item1;
//		try {
//			item1Image = new Image(item1+".png");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public String getItem2() {
//		return item2;
//	}
//
//	public void setItem2(String item2) {
//		this.item2 = item2;
//		try {
//			item2Image = new Image(item2+".png");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void Draw(Canvas canvas, java.awt.Point ponto, Room room)
	{
		if(onItemSelection)
		{
			canvas.drawImage(newItem.getImagem(), (int)ponto.getX(), (int)ponto.getY());
		}
		Item atual = room.getItemList().getHead();
		for(int i = 0; i < room.getItemList().GetTamanho(); i++)
		{
			canvas.drawImage(atual.getImagem(), atual.getX(), atual.getY());
			x = 0; 
			y = 0;
			try
			{
				this.x = (int) ponto.getX();
				this.y = (int) ponto.getY();
			}
			catch(Exception e)
			{

			}
			if((x >= atual.getX() && x <= atual.getX() + atual.getTamX()) && 
					(y >= atual.getY() && y <= atual.getY() + atual.getTamY()))
			{
				canvas.drawImage(atual.getSelected(), atual.getX(), atual.getY());
			}			
			atual = atual.getProximo();
		}
		if(it1 != null)   //if(!getItem1().equals(""))
		{
			canvas.drawImage(it1.getImagem(), 591, 156);   //canvas.drawImage(item1Image, 591, 156);
		}
		if(it2 != null)   //if(!getItem2().equals(""))
		{
			canvas.drawImage(it2.getImagem(), 686, 156);   //canvas.drawImage(item2Image, 686, 156);
		}
	}
	
	public void Click(Point pontoClick, Room room, DrawScreen dw)
	{
		if(onItemSelection)
		{
			onItemSelection = false;
			//room.getItemList().Add(newItem); //apagar depois
			x = 0; 
			y = 0;
			try
			{
				this.x = (int) pontoClick.x;
				this.y = (int) pontoClick.y;
			}
			catch(Exception e)
			{

			}
			if((x >= 591 && x <= 667) && (y >= 156 && y <= 202))
			{
				
				room.getItemList().Add(it1);
				this.setIt1(newItem);
				newItem = null;
				
				//se clique está dentro do inventario
				//adiciona o item ao menu, e o que estava no menu
				//adiciona a room
			}
			else if((x >= 686 && x <= 762) && (y >= 156 && y <= 202))
			{
				room.getItemList().Add(it2);
				this.setIt2(newItem);
				newItem = null;
			}
			else
			{
				room.getItemList().Add(newItem);
			}
		}
		else
		{
			Item atual = room.getItemList().getHead();
			for(int i = 0; i < room.getItemList().GetTamanho(); i++)
			{
				x = 0; 
				y = 0;
				try
				{
					this.x = (int) pontoClick.x;
					this.y = (int) pontoClick.y;
				}
				catch(Exception e)
				{
	
				}
				if((x >= atual.getX() && x <= atual.getX() + atual.getTamX()) && 
						(y >= atual.getY() && y <= atual.getY() + atual.getTamY()))
				{
					atual.Click(dw);
				}
				atual = atual.getProximo();
			}
		}
	}
	
	public void NewItemSelection(Item item)
	{
		onItemSelection = true;
		this.newItem = item;
		
	}
	
	public void Duel(Monster monster, DrawScreen dw, Door door)
	{
		String monsterType = monster.getTipo();
		int esquiva = 0;
		int defesa = 0;
		int ataque = 2;
		int precisao = 0;
		try
		{
			if(it1.getCategoria().equals("Escudo"))
			{
				Armadura armadura = (Armadura) it1;
				esquiva = armadura.getDefesa();
			}
			else if(it1.getCategoria().equals("Armadura"))
			{
				Armadura armadura = (Armadura) it1;
				defesa += armadura.getDefesa();
			}
			else if(it1.getCategoria().equals("Arma"))
			{
				Arma arma = (Arma) it1;
				ataque += arma.getAtk();
				precisao = arma.getPrecision();
			}
			if(it2.getCategoria().equals("Escudo"))
			{
				Armadura armadura = (Armadura) it2;
				esquiva += armadura.getDefesa();
			}
			else if(it2.getCategoria().equals("Armadura"))
			{
				Armadura armadura = (Armadura) it2;
				defesa += armadura.getDefesa();
			}
			else if(it2.getCategoria().equals("Arma"))
			{
				Arma arma = (Arma) it2;
				ataque += arma.getAtk();
				precisao += arma.getPrecision();
			}
		}
		catch(Exception e)
		{
			
		}
		if(precisao == 0)
		{
			precisao = 75;
		}
			Console.println("Ataque: " + ataque + " Defesa: " + defesa + " Precisao: " + precisao + " Esquiva: " + esquiva);
		int num = (int) (Math.random() * 100);
		if(num <= precisao)
		{
			monster.setHealth(monster.getHealth() - ataque);
		}
		Console.println("Vida Monstro: " + monster.getHealth());
		if(monster.getHealth() > 0)
		{
			num = (int) (Math.random() * 100);
			if(num <= (monster.getPrecision() - esquiva))
			{
				if((monster.getAtk() - defesa) > 0)
				{
					health -= (monster.getAtk() - defesa);
					if(health < 1)
					{
						Console.println("GAAAAAMEEEE OOOOOVEEEEEEER!");
					}
					Console.println("Vida Player: " + health);
				}
			}
		}
		else
		{
			door.bloqueada = false;
			monster.RemoveMonster(dw);
			//dw.room.getItemList().Remove(monster);
			
		}
		
	}
	
	
}
