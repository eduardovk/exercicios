import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class CacaPalavras {
	private static int tam = 0;
	private static char[][] matriz;
	public CacaPalavras(int tamanho)
	{
		tam = tamanho;
		matriz = new char[tam][tam];
		for(int h = 0; h < tam; h++)
		{
			for(int v = 0; v < tam; v++)
			{
				matriz[h][v] = '.';
			}
		}
	}
	
	public void printCacaPalavras()
	{
		for(int h = 0; h < tam; h++)
		{
			for(int v = 0; v < tam; v++)
			{
					System.out.print(matriz[h][v] + " ");
			}
			System.out.println();
		}
	}
	
	public int getTamanho()
	{
		return tam;
	}
	
	public boolean inserirPalavra(Palavra palavra)
	{
		char[] arrayPalavra = palavra.arrayPalavra;
		Random r = new Random();
		int hor = 0;
		int ver = 0;

		boolean horizontal = true;

		hor = r.nextInt(tam - 2) + 1;
		ver = r.nextInt(tam - 2) + 1;
		horizontal = r.nextBoolean();

		boolean insere = true;
		try{
			if(horizontal && (ver + arrayPalavra.length) < (tam - 1))
			{
				for(int v = ver; v < (ver + arrayPalavra.length); v++)
				{
					if(matriz[hor][v] != '.' && matriz[hor][v] != arrayPalavra[v - ver])
						insere = false;				
				}
				if(matriz[hor][ver + arrayPalavra.length + 1] != '.')
					insere = false;
				if(insere)
				{
					for(int v = ver; v < (ver + arrayPalavra.length); v++)
					{
						matriz[hor][v] = arrayPalavra[v - ver];
					}
					return true;
				}			
			}
			else if(!horizontal && (hor + arrayPalavra.length) < (tam - 1))
			{
				for(int h = hor; h < hor + arrayPalavra.length; h++)
				{
					if(matriz[h][ver] != '.' && matriz[ver][h] != arrayPalavra[h - hor])
						insere = false;
				}
				if(matriz[hor + arrayPalavra.length + 1][ver] != '.')
					insere = false;
				if(insere)
				{
					for(int h = hor; h < hor + arrayPalavra.length; h++)
					{
						matriz[h][ver] = arrayPalavra[h - hor];
					}
					return true;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("hor = " + hor);
			System.out.println("ver = " + ver);
			System.out.println("Horizontal: " + horizontal);
		}
		inserirPalavra(palavra);
		return true;
	}
	
	public Palavra[] lerPalavras(String arquivo)
	{
		int count = 0;
		File file = new File(arquivo);
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				sc.nextLine();
				count++;
			}
			sc.close();
			Palavra[] palavras = new Palavra[count];
			sc = new Scanner(file);
			count = 0;
			while(sc.hasNextLine())
			{
				Palavra palavra = new Palavra(sc.nextLine());
				palavras[count] = palavra;
				count++;
			}
			sc.close();
			return palavras;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public boolean escolheCruzamento(Palavra[] palavras, boolean duplo)
	{
		int n = 0;
		do{
			Random r = new Random();
			n = r.nextInt(palavras.length);	
		}while(palavras[n].impressa);
		int count = 0;
		Palavra[] palavrasMatch = new Palavra[2];
		Palavra palavraMatch = new Palavra("");
		int letraFoi = -1;
		int index1, index2, index3, index4;
		index1 = index2 = index3 = index4 = 0;
		
		for(int i = 0; i < palavras.length; i++)
		{
			if(i != n && !palavras[i].impressa)
			{
				boolean matched = false;
				for(int k = 0; k < palavras[n].arrayPalavra.length && !matched; k++)
				{				
					for(int j = 0; j < palavras[i].arrayPalavra.length; j++)
					{
						if(count <2 && palavras[n].arrayPalavra[k] == palavras[i].arrayPalavra[j] && k != letraFoi && k != letraFoi - 1 && k!= letraFoi + 1)
						{
							letraFoi = k;							
							if(!duplo && count < 1)
								palavraMatch = palavras[i];
							else
								palavrasMatch[count] = palavras[i];
							count++;
							if(count == 1)
							{
								index1 = k;
								index2 = j;
							}
							if(count == 2 && duplo)
							{
								index3 = k;
								index4 = j;
							}
							matched = true;
							k++;
							break;
						}
					}
				}
			}
			if(count >= 2 || (count > 0 && !duplo))
				break;
		}
		if(duplo && count >= 2)
		{
			insereCruzamento(palavras[n], palavrasMatch[0], palavrasMatch[1], index1, index2, index3, index4);
			return true;
		}
		else if(!duplo && count >0)
		{
			int countErro = 0;
			do{			
				if(!insereCruzamento(palavras[n],  palavraMatch,  index1,  index2))
					countErro++;
				else
					return true;
			}while(countErro < 100);
		}
		return false;
	}

	public boolean insereCruzamento(Palavra principal, Palavra palavra1, Palavra palavra2, int index1, int index2, int index3, int index4)
	{
		Random r = new Random();
		int hor = r.nextInt(tam - 2) + 1;
		int ver = r.nextInt(tam - 2) + 1;
			if ( ver + principal.arrayPalavra.length < (tam - 1) && hor + palavra1.arrayPalavra.length < (tam - 1) && hor + palavra2.arrayPalavra.length < (tam - 1))
			{
				if(hor - palavra1.arrayPalavra.length > 0 && hor - palavra2.arrayPalavra.length > 0)
				{
					for(int i = ver; i < ver + principal.arrayPalavra.length; i++)
					{
						matriz[hor][i] = principal.arrayPalavra[i - ver];
					}
					for(int i = hor - index2; i < (hor - index2) + palavra1.arrayPalavra.length; i++)
					{
						matriz[i][ver + index1] = palavra1.arrayPalavra[i - (hor - index2)];
					}
					for(int i = hor - index4; i < (hor - index4) + palavra2.arrayPalavra.length; i++)
					{
						matriz[i][ver + index3] = palavra2.arrayPalavra[i - (hor - index4)];
					}
					principal.impressa = true;
					palavra1.impressa = true;
					palavra2.impressa = true;
					return true;
				}
			}
				insereCruzamento( principal,  palavra1,  palavra2,  index1,  index2,  index3,  index4);
		return true;
	}

	public boolean insereCruzamento(Palavra palavra1, Palavra palavra2, int index1, int index2)
	{
		Random r = new Random();
		int hor = r.nextInt(tam - 2) + 1;
		int ver = r.nextInt(tam - 2) + 1;
		boolean apropriada = true;
			if (ver + palavra1.arrayPalavra.length < (tam - 1) && hor + palavra2.arrayPalavra.length < (tam - 1))
			{
				if(hor - palavra2.arrayPalavra.length > 0)
				{
					for(int i = ver; i < ver + palavra1.arrayPalavra.length; i++)
					{						
						if(matriz[hor][i] != '.')
							apropriada = false;
					}					
					for(int i = hor - index2; i < (hor - index2) + palavra2.arrayPalavra.length; i++)
					{						
						if(matriz[i][ver + index1] != '.')
							apropriada = false;
					}
					if(matriz[hor][ver -1] != '.' || matriz[hor - index2 - 1][ver + index1] != '.')
						apropriada = false;
					if(apropriada)
					{
						for(int i = ver; i < ver + palavra1.arrayPalavra.length; i++)
						{
							matriz[hor][i] = palavra1.arrayPalavra[i - ver];
						}
						for(int i = hor - index2; i < (hor - index2) + palavra2.arrayPalavra.length; i++)
						{
							matriz[i][ver + index1] = palavra2.arrayPalavra[i - (hor - index2)];
						}
						palavra1.impressa = true;
						palavra2.impressa = true;
						return true;
					}
				}
			}
		return false;
	}
	
	public void insereLetras(boolean gabarito)
	{
		if(!gabarito)
		{
			Random r = new Random();
			for(int i = 0; i < tam; i++)
			{
				for(int k = 0; k < tam; k++)
				{
					if(matriz[i][k] == '.')
					{
						matriz[i][k] = (char)(r.nextInt(26) + 'a');
					}
				}
			}
		}
	}
}
