package alex.per.testObserver;

import java.util.ArrayList;

public class WeatherData implements Subject{
	private ArrayList<Observer> obserList;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData(){
		obserList = new ArrayList<Observer>();
	}
	

	@Override
	public void registerObserver(Observer ob) {
		obserList.add(ob);
	}
	

	@Override
	public void removeObserver(Observer ob) {
		int i = obserList.indexOf(ob);
		if(i>=0){
			obserList.remove(i);
		}
		
	}

	@Override
	public void notifyObserver() {
		for(int i = 0;i<obserList.size();i++){
			Observer ob = obserList.get(i);
			ob.update(temperature, humidity,pressure);
		}
		
	}
	
	//有天气相关数据更改时，通知所有观察者
	public void measureChanged(){
		notifyObserver();
	}
	
	public void setMeasureData(float tempurature, float humidity, float pressure){
		this.temperature = tempurature;
		this.humidity = humidity;
		this.pressure = pressure;
		measureChanged();
	}
}
