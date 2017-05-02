
public class Temperatura {	
	
	
	public static float ToFarenheit(float graus)
	{
		return 1.8f * graus + 32f;
	}
	
	public static float ToCelsius(float graus)
	{
		return (graus - 32) / 1.8f;
	}
	
	public static String ConverterGraus(String temperatura)
	{
		char escala = temperatura.charAt(temperatura.length() - 1);
		float graus = Float.parseFloat(temperatura.substring(0,temperatura.length() - 1));
		if(escala == 'C')
		{
			return ToFarenheit(graus) + "F";
		}
		return ToCelsius(graus) + "C";
	}
}
