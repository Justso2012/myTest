package alex.per.testObserver;

public class WeatherStation {
	
	public static void main(String[] args){
		WeatherData weather = new WeatherData();
		CurrentConditionDisplay current = new CurrentConditionDisplay();
		
		weather.registerObserver(current);
		weather.setMeasureData(20, 60, 50);
		weather.setMeasureData(15, 62, 35);
		weather.setMeasureData(25, 93, 91);
		
	}
}
