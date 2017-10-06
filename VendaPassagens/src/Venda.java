
public class Venda {
	
	private Cliente cliente;
	private Voo voo;
	private String horarioCompra;
	
	public Cliente getCliente() {
		return cliente;
	}
	public Voo getVoo() {
		return voo;
	}
	public String getHorarioCompra() {
		return horarioCompra;
	}
	
	public Venda(Cliente cliente, Voo voo, String horarioCompra)
	{
		this.cliente = cliente;
		this.voo = voo;
		this.horarioCompra = horarioCompra;
	}
	
	public String toString()
	{
		String dados = "Comprador: " + cliente.getNome();
		dados += "\nVoo: " + voo.getCodigo() + " Origem: " + voo.getOrigem() + " Destino: " + voo.getDestino();
		dados+= "\nHorário da Compra: " + horarioCompra;
		return dados;
	}
	
}
