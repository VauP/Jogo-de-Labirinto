import java.io.*;

class Stack <X> implements Cloneable{
	String[][] matrix;
	int lineMat, colMat;

	public Stack (String[][] m) throws Exception{
		try{
			if(m.length > 0){
				lineMat = m.length;
				colMat = m[0].length;
			}
			for(int i = 0; i < lineMat; i++){
				for(int j = 0; j  < colMat; j++){
					this.matrix[i][j] = m[i][j];
				}
			}
		}catch(Exception err){
			throw new Exception(err);
		}
	}

	public int[] possibilities(int x, int y) throws Exception{
		int array[] = new int [8];
		int i = 0;
		try{ 
			if(matrix[x + 1][y] == " " || matrix[x + 1][y] == "S") {
				array[i] = x;
				i++;
				array[i] = y;
			}

			if(matrix[x -1][y] == " " || matrix[x - 1][y] == "S") {
				array[i] = x;
				i++;
				array[i] = y;
			}

			if(matrix[x][y + 1] == " " || matrix[x][y + 1] == "S") {
				array[i] = x;
				i++;
				array[i] = y;
			}

			if(matrix[x][y - 1] == " " || matrix[x][y - 1] == "S") {
				array[i] = x;
				i++;
				array[i] = y;
			}

			return array;
		}catch(Exception err){
			throw new Exception(err);
		}
	}

	
}

