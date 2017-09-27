import java.util.Scanner;

public class Principal {
	static Palavra[] palavras;
	public static void main(String[] args) {
		boolean pronto = true;
		int count = 0;
		CacaPalavras cacaPalavras;
		int tamanho = 28;
		boolean gabarito = false;
		Scanner sc = new Scanner(System.in);
		char op = ' ';
		do
		{
			System.out.print("Ativar modo gabarito? (s - sim) (n - nao): ");
			try{
				op = sc.next().charAt(0);
			}
			catch(Exception e)
			{
				
			}
			if(op == 's')
				gabarito = true;
		}while(op != 's' && op != 'n');
		sc.close();
		do
		{
			count++;
			cacaPalavras = new CacaPalavras(tamanho);
			palavras = cacaPalavras.lerPalavras("palavras1.txt");
			cacaPalavras.escolheCruzamento(palavras, true);
			for(int i = 0; i < 3; i++)
			{
				if(!cacaPalavras.escolheCruzamento(palavras, false))
					pronto = false;
			}
		}while(!pronto && count < 100);
		if(count < 100)
		{
			
			for(int i = 0; i < palavras.length; i++)
			{
				if(!palavras[i].impressa)
				{
					cacaPalavras.inserirPalavra(palavras[i]);
				}
			}
			cacaPalavras.insereLetras(gabarito);
			cacaPalavras.printCacaPalavras();
			for(int i = 0; i < tamanho; i++)
			{
				System.out.print("--");
			}
			System.out.println("\nEncontre as palavras: ");
			for(int i = 0; i < palavras.length; i++)
			{
				System.out.println(palavras[i].palavra);
			}
		}
		else
		{
			System.out.println("Não foi possível montar o Caca Palavras de acordo com as regras estabelecidas e as palavras fornecidas.");
		}
	}
}
