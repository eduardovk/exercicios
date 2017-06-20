package applications;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Point;

public class Screen {
	int x, y;
	private Item it1, it2;
	private int health = 20;
	private Item newItem;
	private boolean onItemSelection = false;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

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
		if(it1 != null)
		{
			canvas.drawImage(it1.getImagem(), 591, 156);
		}
		if(it2 != null)
		{
			canvas.drawImage(it2.getImagem(), 686, 156);
		}
	}
	
	public void Click(Point pontoClick, Room room, DrawScreen dw)
	{
		if(onItemSelection)
		{
			onItemSelection = false;
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
			Console.println("Ataque: " + ataque + " Defesa: " + defesa + "\nPrecisao: " + precisao + " Esquiva: " + esquiva + "\n");
		int num = (int) (Math.random() * 100);
		if(num <= precisao)
		{
			monster.setHealth(monster.getHealth() - ataque);
			Console.println("Causou " + ataque + " de dano ao " + monster.getTipo() + "!");
		}
		else
		{
			Console.println("Errou o ataque ao " + monster.getTipo() + "!");
		}
		
		if(monster.getHealth() > 0)
		{
			num = (int) (Math.random() * 100);
			if(num <= (monster.getPrecision() - esquiva))
			{
				if((monster.getAtk() - defesa) > 0)
				{
					health -= (monster.getAtk() - defesa);
					Console.println("Perdeu " + (monster.getAtk() - defesa) + " de vida!");
					if(health < 1)
					{
						Console.println("GAAAAAMEEEE OOOOOVEEEEEEER!");
					}				
				}
				
			}
			else
			{
				Console.println("O " + monster.getTipo() + " errou o ataque!");
			}
			Console.println("\nVida Monstro: " + monster.getHealth());
		}
		else
		{
			door.bloqueada = false;
			monster.RemoveMonster(dw);
			Console.println("\nVida Monstro: 0");
		}
		Console.println("Vida Player: " + health);
		Console.println("\n");
	}
	
	
}
