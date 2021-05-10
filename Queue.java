import java.io.*;

class Queue <X> implements Cloneable{
	String[][] matrix;
	int lineMat, colMat;

	public Queue (String[][] m) throws Exception{
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

	public int[] findForStart() throws Exception{
		int posXandY[] = new int[2];

		try{
			for(int i = 0; i < lineMat; i++){
				for(int j = 0; j < colMat; j++){
					if(this.matrix[i][j] == "E"){
						posXandY[0] = i;
						posXandY[1] = j;
					} 
				}
			}
			return posXandY;

		}catch(Exception err){
			throw new Exception(err);
		}
	}

	

}
