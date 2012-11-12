import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


/*Given a 2–d matrix , which has only 1’s and 0’s in it. Find the total number of connected sets in that matrix.
 
 
Explanation:
Connected set can be defined as group of cell(s) which has 1 mentioned on it and have at least one other cell in that set with which they share the neighbor relationship. A cell with 1 in it and no surrounding neighbor having 1 in it can be considered as a set with one cell in it. Neighbors can be defined as all the cells adjacent to the given cell in 8 possible directions ( i.e N , W , E , S , NE , NW , SE , SW direction ). A cell is not a neighbor of itself.
 
 
Input format :
 
First line of the input contains T , number of test-cases.
Then follow T testcases. Each testcase has given format.
N [ representing the dimension of the matrix N X N ].
Followed by N lines , with N numbers on each line.
 
 
 
Ouput format :
 
For each test case print one line ,  number of connected component it has.
 
Sample Input :
 
4
4
0 0 1 0
1 0 1 0
0 1 0 0
1 1 1 1
4
1 0 0 1
0 0 0 0
0 1 1 0
1 0 0 1
5
1 0 0 1 1
0 0 1 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
8
0 0 1 0 0 1 0 0
1 0 0 0 0 0 0 1
0 0 1 0 0 1 0 1
0 1 0 0 0 1 0 0
1 0 0 0 0 0 0 0
0 0 1 1 0 1 1 0
1 0 1 1 0 1 1 0
0 0 0 0 0 0 0 0
 
Sample output :
 
1
3
3
9
 
Constraint :
 
0 < T < 6 
0 < N < 1009 */
public class ConnectedSets {

	
	public static int matrix[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int no_tc = sc.nextInt();

		for (int c = 0; c < no_tc; c++) {
			int size = sc.nextInt();

			matrix = new int[size][size];

			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					matrix[i][j] = sc.nextInt();

			int total_count=0;
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					if(matrix[i][j]==1){
						if(isSingleSet( i, j, size))
							total_count+=1;
						else if(incriment(i, j, size,false)){
							total_count+=1;
						}
					}
					/*if(matrix[i][j]==2){
						incrimentedNearByOnes(i, j, size);
					}*/
				}
			}
			System.out.println(total_count);
		}

	}
	
	public static boolean isSingleSet(int xIndex,int yIndex,int size){
		
		
		if (adjacentOnes(xIndex, yIndex, size)==0) {
			
			return true;
		}
		
		return false;
	}
	
	public static int adjacentOnes(int xIndex, int yIndex,int size) {
		int total = 0;
		if(areInBounds( xIndex-1,yIndex-1,size)) total+=matrix[xIndex-1][yIndex-1];
		if(areInBounds( xIndex-1,yIndex,size)) total+=matrix[xIndex-1][yIndex];
		if(areInBounds(xIndex-1,yIndex+1,size)) total+=matrix[xIndex-1][yIndex+1];
		if(areInBounds(xIndex,yIndex-1,size)) total+=matrix[xIndex][yIndex-1];
		if(areInBounds(xIndex,yIndex+1,size)) total+=matrix[xIndex][yIndex+1];
		if(areInBounds(xIndex+1,yIndex-1,size)) total+=matrix[xIndex+1][yIndex-1];
		if(areInBounds(xIndex+1,yIndex,size)) total+=matrix[xIndex+1][yIndex];
		if(areInBounds(xIndex+1,yIndex+1,size)) total+=matrix[xIndex+1][yIndex+1];
		return total;
	}

	public static boolean areInBounds(int x, int y,int size){
		if(x>=0 && y>=0 && x<size && y<size)
			return true;
		return false;
	}
	public static boolean incriment(int xIndex, int yIndex,int size,boolean flag){
		matrix[xIndex][yIndex]=2;
		return (incrimentedNearByOnes(xIndex, yIndex, size,false));
	}
	
	public static boolean incrimentedNearByOnes(int xIndex, int yIndex,int size,boolean flag){
		int total = 0;
		if(areInBounds( xIndex-1,yIndex-1,size)) {
			if(matrix[xIndex-1][yIndex-1]==1){
				flag=true;
				matrix[xIndex-1][yIndex-1]=2;
				incrimentedNearByOnes(xIndex-1,yIndex-1,size,true);
			}	
		}
		if(areInBounds( xIndex-1,yIndex,size)) {
			if(matrix[xIndex-1][yIndex]==1){
				flag=true;
				matrix[xIndex-1][yIndex]=2;
				incrimentedNearByOnes(xIndex-1,yIndex,size,true);
			}	
		}
		if(areInBounds(xIndex-1,yIndex+1,size)){
			if(matrix[xIndex-1][yIndex+1]==1){
				flag=true;
				matrix[xIndex-1][yIndex+1]=2;
				incrimentedNearByOnes(xIndex-1,yIndex+1,size,true);
			}	
		}
		if(areInBounds(xIndex,yIndex-1,size)) {
			if(matrix[xIndex][yIndex-1]==1){
				flag=true;
				matrix[xIndex][yIndex-1]=2;
				incrimentedNearByOnes(xIndex,yIndex-1,size,true);
			}	
		}
		if(areInBounds(xIndex,yIndex+1,size)){
			
			if(matrix[xIndex][yIndex+1]==1){
				flag=true;
				matrix[xIndex][yIndex+1]=2;
				incrimentedNearByOnes(xIndex,yIndex+1,size,true);
			}	
		}
		if(areInBounds(xIndex+1,yIndex-1,size)){
			
			if(matrix[xIndex+1][yIndex-1]==1){
				flag=true;
				matrix[xIndex+1][yIndex-1]=2;
				incrimentedNearByOnes(xIndex+1,yIndex-1,size,true);
			}	
		}
		if(areInBounds(xIndex+1,yIndex,size)){
			
			if(matrix[xIndex+1][yIndex]==1){
				flag=true;
				matrix[xIndex+1][yIndex]=2;
				incrimentedNearByOnes(xIndex+1,yIndex,size,true);
			}	
		}
		if(areInBounds(xIndex+1,yIndex+1,size)) {
			if(matrix[xIndex+1][yIndex+1]==1){
				flag=true;
				matrix[xIndex+1][yIndex+1]=2;
				incrimentedNearByOnes(xIndex+1,yIndex+1,size,true);
			}	
		}
		return flag;
	}
	
}