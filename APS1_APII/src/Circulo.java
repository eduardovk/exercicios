
public class Circulo {

	private float x, y;
	private float diametro;

	static final float pi = 3.14159265f;
	
	public Circulo(float diametro, float coordenadaX, float coordenadaY)
	{
		this.x = coordenadaX;
		this.y = coordenadaY;
		this.diametro = diametro;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getDiametro() {
		return diametro;
	}

	public void setDiametro(float diametro) {
		this.diametro = diametro;
	}

	public float CalculaArea()
	{
		float raio = diametro / 2;
		return pi * (raio * raio);
	}
	
	public float CalculaCircunferencia()
	{
		return (pi * diametro);
	}
	
	public boolean VerificaContato(Circulo circulo2)
	{
		float x1 = x, x2 = circulo2.getX();
		float y1 = y, y2 = circulo2.getY();
		float r1 = diametro/2, r2 = circulo2.getDiametro()/2;
		if(Math.pow((x2-x1), 2) + Math.pow((y1-y2), 2) <= Math.pow((r1+r2), 2))
		{
			return true;
		}		
		return false;
	}
}
