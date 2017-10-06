
public class Voo {
	
	private String origem = "";
	private String destino = "";
	private String horario = "";
	private Aviao aviao;
	private short codigo;
	
	public Voo(String origem, String destino, Aviao aviao, short codigo, String horario)
	{
		this.origem = origem;
		this.destino = destino;
		this.aviao = aviao;
		this.codigo = codigo;
		this.horario = horario;
	}
	
	public short getCodigo()
	{
		return codigo;
	}
	
	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public String getHorario() {
		return horario;
	}

	public Aviao getAviao() {
		return aviao;
	}
	
	public String toString()
	{
		String dados = "Código do Voo: " + codigo;
		dados += "\nAvião: " + (aviao != null ? aviao.getNome() : "Dado não informado.");
		dados += "\nOrigem: " + (!origem.equals("") ? origem : "Dado não informado. ");
		dados += "\nDestino: " + (!destino.equals("") ? destino : "Dado não informado. ");
		dados += "\nHorário: " + (!horario.equals("") ? horario : "Dado não informado. ");
		return dados;
	}
	
	
	
	
	
}
