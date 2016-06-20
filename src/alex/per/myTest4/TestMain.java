package alex.per.myTest4;

public class TestMain {

	public static void main(String[] args){
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performfly();
		mallard.performQuack();

		System.out.println("--------------");
		
		Duck model = new ModelDuck();
		model.display();
		model.performfly();
		model.performQuack();
		
		model.setFlyBehavior(new FlyWithRocket());
		model.setQuackBehavior(new Quack());
	
		System.out.println("--------------");

		model.display();
		model.performfly();
		model.performQuack();
		
	
	}
}
