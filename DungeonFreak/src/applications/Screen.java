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
}
