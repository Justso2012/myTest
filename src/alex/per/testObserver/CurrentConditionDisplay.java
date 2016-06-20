package alex.per.testObserver;

public class CurrentConditionDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	
	public CurrentConditionDisplay(){
		
	}

	@Override
	public void display() {
		System.out.println("I'm current condition:");
		System.out.println("temp:"+temperature+" degree");
		System.out.println("humidity:"+humidity+"%");
		System.out.println("pressure:"+pressure+" Pa");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		
		display();
		
	}
}
