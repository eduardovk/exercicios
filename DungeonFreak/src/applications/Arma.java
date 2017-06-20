package applications;

import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Arma extends Item{
	private int atk;
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
	
	public Arma(String tipo, String categoria, int x, int y, int tamX, int tamY)
	{
		this.setTipo(tipo);
		this.setCategoria(categoria);
		if(tipo.equals("Adaga"))
		{
			atk = 1;
			precision = 75;
		}
		else if(tipo.equals("Faca"))
		{
			atk = 2;
			precision = 80;
		}
		else if(tipo.equals("Espada"))
		{
			atk = 3;
			precision = 85;
		}
		else
		{
			atk = 5;
			precision = 65;
		}
		this.setX(x);
		this.setY(y);
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
		if(dw.screen.getIt1() == null)   //if(dw.screen.getItem1().equals(""))
		{
			dw.screen.setIt1(this);   //dw.screen.setItem1(this.tipo);
			dw.room.getItemList().Remove(this);
		}
		else if(dw.screen.getIt2() == null)   //else if(dw.screen.getItem2().equals(""))
		{
			dw.screen.setIt2(this);   //dw.screen.setItem2(this.tipo);
			dw.room.getItemList().Remove(this);
		}
		else
		{
			dw.screen.NewItemSelection(this);
			dw.room.getItemList().Remove(this);
		}
	}
}
