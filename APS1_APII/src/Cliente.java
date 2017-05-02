
public class Cliente {
	
	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf)
	{
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String VerNome()
	{
		return nome;
	}
	
	public String VerCpf()
	{
		return cpf;
	}
}
