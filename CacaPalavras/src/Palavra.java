
public class Palavra {
	
	String palavra;
	char[] arrayPalavra;
	boolean horizontal;
	boolean impressa;
	
	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isImpressa() {
		return impressa;
	}

	public void setImpressa(boolean impressa) {
		this.impressa = impressa;
	}

	public String getPalavra() {
		return palavra;
	}

	public char[] getArrayPalavra() {
		return arrayPalavra;
	}

	
	public Palavra(String palavra)
	{
		this.palavra = palavra;
		arrayPalavra = this.palavra.toCharArray();
		impressa = false;
	}
}
