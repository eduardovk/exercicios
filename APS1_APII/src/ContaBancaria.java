
public class ContaBancaria {
	
	private float saldo;
	private Cliente dono;
	
	public ContaBancaria(float saldo, Cliente dono)
	{
		this.saldo = saldo;
		this.dono = dono;
	}
	
	public boolean Sacar(float valor)
	{
		if(saldo >= valor)
		{
			saldo -= valor;
			return true;
		}
		return false;
	}
	
	public boolean Depositar(float valor)
	{
		saldo += valor;
		return true;
	}
	
	public float VerSaldo()
	{
		return saldo;
	}
	
	public String VerDono()
	{
		return dono.VerNome();
	}
}
