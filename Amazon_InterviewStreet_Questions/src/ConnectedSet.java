import java.nio.channels.AlreadyConnectedException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Runtime;
class Pair{
	
	int x;
	int y;
	
	Pair(int x,int y){
		this.x=x;this.y=y;
	}
}

public class ConnectedSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_tc = sc.nextInt();

		for (int c = 0; c < no_tc; c++) {
			int size = sc.nextInt();

			boolean matrix[][] = new boolean[size][size];

			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					matrix[i][j] = (sc.nextInt()!=0);
			
			
			ArrayList<ArrayList<Pair>> total_list=new ArrayList<ArrayList<Pair>>();
			int total_count=0;
			ConnectedSet obj=new ConnectedSet();
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					if(matrix[i][j]==true){
						if(obj.isSingleSet(matrix, i, j, size))
							total_count+=1;
						else if(!obj.alreadyCounted(matrix, i, j, size)){
							if(obj.forwAdjacentOnes(matrix, i, j, size))
								total_count+=1;
						}
					}
				}
			}
			
			System.out.println(total_count);
		}
		
		

	}
	
	
	public boolean isSingleSet(boolean[][] matrix,int xIndex,int yIndex,int size){
			
			
			if (adjacentOnes(matrix,xIndex, yIndex, size)==0) {
				
				return true;
			}
			
			return false;
		}
		
		public int adjacentOnes(boolean[][] matrix,int xIndex, int yIndex,int size) {
			int total = 0;
			if(areInBounds( matrix,xIndex-1,yIndex-1,size)) total+=1;
			if(areInBounds( matrix,xIndex-1,yIndex,size)) total+=1;
			if(areInBounds( matrix,xIndex-1,yIndex+1,size)) total+=1;
			if(areInBounds( matrix,xIndex,yIndex-1,size)) total+=1;
			if(areInBounds( matrix,xIndex,yIndex+1,size)) total+=1;
			if(areInBounds( matrix,xIndex+1,yIndex-1,size)) total+=1;
			if(areInBounds( matrix,xIndex+1,yIndex,size)) total+=1;
			if(areInBounds( matrix,xIndex+1,yIndex+1,size)) total+=1;
			return total;
		}

		private boolean areInBounds(boolean[][] matrix,int x, int y,int size){
			if(x>=0 && y>=0 && x<size && y<size)
				return matrix[x][y];
			return false;
		}
		
		public boolean alreadyCounted(boolean[][] matrix,int xIndex, int yIndex,int size){
			int total = 0;
			if(areInBounds( matrix,xIndex-1,yIndex-1,size)) total+=1;
			if(areInBounds( matrix,xIndex-1,yIndex,size)) total+=1;
			if(areInBounds( matrix,xIndex-1,yIndex+1,size)) total+=1;
			if(areInBounds( matrix,xIndex,yIndex-1,size)) total+=1;
			//if(areInBounds( matrix,xIndex,yIndex+1,size)) total+=1;
			//if(areInBounds( matrix,xIndex+1,yIndex-1,size)) total+=1;
			//if(areInBounds( matrix,xIndex+1,yIndex,size)) total+=1;
			//if(areInBounds( matrix,xIndex+1,yIndex+1,size)) total+=1;
			if(total>0)
				return true;
			else
				return false;
		}
		public boolean forwAdjacentOnes(boolean[][] matrix,int xIndex, int yIndex,int size) {
			int total = 0;
			//if(areInBounds( matrix,xIndex-1,yIndex-1,size)) total+=1;
			//if(areInBounds( matrix,xIndex-1,yIndex,size)) total+=1;
			if(areInBounds( matrix,xIndex-1,yIndex+1,size)) total+=1;
			//if(areInBounds( matrix,xIndex,yIndex-1,size)) total+=1;
			if(areInBounds( matrix,xIndex,yIndex+1,size)) total+=1;
			//if(areInBounds( matrix,xIndex+1,yIndex-1,size)) total+=1;
			if(areInBounds( matrix,xIndex+1,yIndex,size)) total+=1;
			if(areInBounds( matrix,xIndex+1,yIndex+1,size)) total+=1;
			if(total>0)
				return true;
			else
				return false;
		}
		

}
