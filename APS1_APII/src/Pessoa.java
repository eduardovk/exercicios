import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	
	private String nome;
	private LocalDate nascimento;
	private String signo;
	
	public Pessoa(String nome, LocalDate nascimento)
	{
		this.nome = nome;
		this.nascimento = nascimento;
		DescobreSigno();
	}
	
	public int VerIdade()
	{
		Period periodo = Period.between(nascimento, LocalDate.now());
		return periodo.getYears();		
	}
	
	public String VerNome()
	{
		return nome;
	}
	
	public String VerSigno()
	{
		return signo;
	}
	
	private void DescobreSigno()
	{
		int dia = nascimento.getDayOfMonth();
		int mes = nascimento.getMonthValue();
		if (dia>=20 && dia<=31 && mes==3 || dia>=1 && dia<=20 &&  mes==4)
	     {
	                 signo = "aries";
	      }
	      else if (dia>=21 && dia<=30 && mes==4 || dia>=1 && dia<=20 && mes==5)
	      {
	    	  signo = "touro";
	      }
	      else if (dia>=21 && dia<=31 && mes==5 || dia>=1 && dia<=20 && mes==6)
	      {
	    	  signo = "gemeos";
	      }
	      else if (dia>=21 && dia<=30 && mes==6 || dia>=1 && dia<=21 && mes==7)
	      {
	    	  signo = "cancer";
	       }
	       else if (dia>=22 && dia<=31 && mes==7 || dia>=1 && dia<=22 && mes==8)
	       {
	    	   signo = "leao";
	       }
	       else if (dia>=22 && dia<=31 && mes==8 || dia>=1 && dia<=22 && mes==9)
	       {
	    	   signo = "vigem";
	        }
	        else if (dia>=22 && dia<=30 && mes==9 || dia>=1 && dia<=22 && mes==10)
	        {
	        	signo = "libra";
	         }
	         else if (dia>=23 && dia <=31 && mes==10 || dia>=1 && dia<=21 && mes==11)
	         {
	        	 signo = "escorpiao";
	          }
	          else if (dia>=22 && dia<=30 && mes==11 || dia>=1 && dia<=21 && mes==12)
	          {
	        	  signo = "sagitario";
	           }
	           else if (dia>=22 && dia<=31 && mes==12 || dia>=1 && dia<=20 && mes==1)
	           {
	        	   signo = "capricornio";
	            }
	            else if (dia>=21 && dia<=31 && mes==1 || dia>=1 && dia<=18 && mes==2)
	            {
	            	signo = "aquario";
	              }
	              else if (dia>=19 && dia<=29 && mes==2 || dia>=1 && dia<=19 && mes==3)
	              {
	            	  signo = "peixes";
	               }
	               else
	               {
	            	   signo = "dia ou mes invalido";
	                }
	}
	
}

