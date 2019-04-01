package application.temperature.by.youssouf;

public class Convertisseur {
	public static float ConverterFahrenheit(int celsicus) {
		float fahrenheit = ((celsicus * (1.8f)) + 32.0f);
		return fahrenheit;
	}
	
	public static double ConverterKelvin(int celsicus) {
		double kelvin = celsicus +  273.15;
		return kelvin;
	}
}
