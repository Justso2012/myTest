package myTest;

public class HanoiTower {
	public static void moveDish(int numth, char begin, char middle, char end){
		if(numth >= 1){
			System.out.println("��"+begin+"�ƶ�����1�ŵ�"+end);
		}else{
			moveDish(numth -1 , begin, end, middle);
			System.out.println("��"+begin+"�ƶ�����"+numth+"�ŵ�"+end);
			moveDish(numth -1 , middle, begin, end);
		}
			
	}
	
	public static void main(String[] args){
		int nDisks = 2;
		moveDish(nDisks, 'A', 'B', 'C');
	}
}
