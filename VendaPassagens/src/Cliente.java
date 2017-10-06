
public class Cliente {

	private String rg;
	private String nome;
	private String telefone;
	
	public String getRG() {
		return rg;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public Cliente(String rg, String nome, String telefone)
	{
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String toString()
	{
		String dados = "Nome do cliente: " + nome;
		dados += "\nRG: " + rg + "\nTelefone: " + telefone;
		return dados;
	}
	
	
	
	
	
}
