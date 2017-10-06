
public class Aviao {
		
	private short codigo;
	private String nome;
	private short qtdAssentos;
	
	public short getCodigo() {
		return codigo;
	}
	public short getQtdAssentos() {
		return qtdAssentos;
	}
	public String getNome() {
		return nome;
	}
	
	public Aviao(short codigo, String nome, short qtdAssentos)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.qtdAssentos = qtdAssentos;
	}
	
	public String toString()
	{
		String dados = "Código do Avião: " + codigo;
		dados += "\nNome: " + nome + "\nQtd. de Assentos: " + qtdAssentos;
		return dados;
	}
	
	
	
}
