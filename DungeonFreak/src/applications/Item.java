package applications;
import com.senac.SimpleJava.Graphics.Image;

public abstract class Item {
	private Image imagem;
	private Image selected;
	private int x, y;
	private int tamX, tamY;
	private Item anterior, proximo;
	private String tipo;
	private String categoria;
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Item getAnterior() {
		return anterior;
	}

	public void setAnterior(Item anterior) {
		this.anterior = anterior;
	}

	public Image getSelected() {
		return selected;
	}

	public void setSelected(Image selected) {
		this.selected = selected;
	}

	
	
	public int getTamX() {
		return tamX;
	}

	public void setTamX(int tamX) {
		this.tamX = tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public void setTamY(int tamY) {
		this.tamY = tamY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public void setProximo(Item item) {
		// TODO Auto-generated method stub
		this.proximo = item;
	}

	public Item getProximo() {
		// TODO Auto-generated method stub
		return proximo;
	}
	
	public void Click(DrawScreen dw)
	{
		
	}
	
}
