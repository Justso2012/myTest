package myTest;


public class TestOut {
	
	private static void createNineCellShape(int type, int[][] nineCellPoints) {
		if(nineCellPoints == null || nineCellPoints.length == 0) 
			return ;
		int shapeCount = nineCellPoints.length;
		int pointCount = -1000;
		int[][][] points = new int[shapeCount][][];
		
		for(int i = 0; i < shapeCount; i++) {
			pointCount = nineCellPoints[i].length;
			points[i] = new int[pointCount + 1][2];
			int width = 0;
			int height = 0;
			// 根据参数的点在九宫格的位置转化为形状的坐标
			for(int j = 0; j < pointCount; j++) {
				points[i][j+1][0] = nineCellPoints[i][j] % 3;
				points[i][j+1][1] = nineCellPoints[i][j] / 3;
				if(width < points[i][j+1][0]) width = points[i][j+1][0];
				if(height < points[i][j+1][1]) height = points[i][j+1][1];
			}
			// 每个形状的第一个点表示该形状的宽度和高度
			points[i][0][0] = width + 1;
			points[i][0][1] = height + 1;
		}
		
		
		for(int i = 0;i < points.length;i++)
			for(int j = 0;j<points[i].length;j++)
				for(int k = 0;k<points[i][j].length;k++){
					//if(points[i][j][k] != -1000)
						System.out.println("("+i+","+j+","+k+")  "+points[i][j][k]);
				}
		return ;
	}
	
	public static void main(String[] args){
		System.out.println("田:");
		createNineCellShape(6, new int[][]{{0,1,3,4}});
		System.out.println("=========================================");
		System.out.println("Z:");
		createNineCellShape(2, new int[][]{{1,3,4,6}, {0,1,4,5}});
		System.out.println("=========================================");
		System.out.println("反T");
		createNineCellShape(5, new int[][]{{1,3,4,5}, {0,3,4,6}, {0,1,2,4}, {1,3,4,7}});
	/*	int pointCount = 4;
		int[][][] points = new int[2][pointCount + 1][2];
		
		for(int i = 0;i < 2;i++)
			for(int j = 0;j<pointCount + 1;j++)
				for(int k = 0;k<2;k++){
					points[i][j][k] = -1000;
				}
		//System.out.println("hhh"+points[0][2][0]);
		
		int offset = 0;
		if(pointCount > 2) offset = (pointCount - 1) / 2;
		
		points[0][0][0] = pointCount;
		points[0][0][1] = 1;
		points[1][0][0] = 1 + offset;
		points[1][0][1] = pointCount - offset;
		
		for(int i = 0; i < pointCount; i++) {
			points[0][i+1][0] = i;
			points[0][i+1][1] = 0;
			points[1][i+1][0] = offset;
			points[1][i+1][1] = i - offset;
		}
		
		
		System.out.println("offset:"+offset);
		
		for(int i = 0;i < 2;i++)
			for(int j = 0;j<pointCount + 1;j++)
				for(int k = 0;k<2;k++){
					if(points[i][j][k] != -1000)
						System.out.println("("+i+","+j+","+k+")  "+points[i][j][k]);
		}*/
	}

}
