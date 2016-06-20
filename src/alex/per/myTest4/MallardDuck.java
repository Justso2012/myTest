package alex.per.myTest4;

public class MallardDuck extends Duck{
	
	public MallardDuck(){
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	public void display(){
		System.out.println("Ok,I'm a mallard.");
	}
}
