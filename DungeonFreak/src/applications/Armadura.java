package applications;

import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Armadura extends Item {
	private int defesa;
	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public Armadura(String tipo, String categoria, int x, int y, int tamX, int tamY)
	{
		this.setTipo(tipo);
		this.setCategoria(categoria);
		if(tipo.equals("Escudo"))
		{
			defesa = 25;
		}
		else if(tipo.equals("ArmaduraCouro"))
		{
			defesa = 2;
		}
		else if(tipo.equals("ArmaduraMetal"))
		{
			defesa = 3;
		}
		else 
		{
			defesa = 5;
		}
		this.setX(x);
		this.setY(y);
		this.setTamX(tamX);
		this.setTamY(tamY);
		try {
			this.setSelected(new Image("Selected" + categoria + ".png"));
			this.setImagem(new Image(tipo + ".png"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void Click(DrawScreen dw)
	{
		if(dw.screen.getIt1() == null)
		{
			dw.screen.setIt1(this);
			dw.room.getItemList().Remove(this);
		}
		else if(dw.screen.getIt2() == null)
		{
			dw.screen.setIt2(this);
			dw.room.getItemList().Remove(this);
		}
		else
		{
			dw.screen.NewItemSelection(this);
			dw.room.getItemList().Remove(this);
		}
	}
}
