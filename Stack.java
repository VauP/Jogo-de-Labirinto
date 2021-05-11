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

	

	// função adicional, cujo o objetivo é achar todos os lugares possiveis, para que no fim, retorne ao usuario quantos caminhos disponiveis restaram para ele passar
	// public int[] findForAllPossibilities(String m[][]){
	// 	// Procurando por possibilidades, procurando pelos caminhos disponiveis.
	// 	int positions[] = new int[8];
	// 	try{
	// 		for(int i = 0; i < lineMat; i++){
	// 			for(int j = 0; j < lineMat; j++){
	// 				if(this.matrix[i][j] == " "){
						
	// 				}
	// 			}
	// 		}
	// 	}
	// }

	
}

