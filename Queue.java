import java.io.*;
import java.util.Vector;

class Queue <X> implements Cloneable{
	//tentar resolver isso
	String[][] matrix = new String[99][99];
	int lineMat, colMat;
	Boolean ahead, back, up, down;

	public Queue (String[][] m) throws Exception{
		try{
			if(m.length > 0){
				lineMat = m.length;
				colMat = m[0].length;
				//instancia a pilha
			}
			System.out.println("" + lineMat + ","+ colMat);
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
		// Procurando a letra 'E', que por sua vez, representa o inicio
		int posXandY[] = new int[2];

		try{
			
			for(int i = 0; i < lineMat; i++){
				for(int j = 0; j < colMat; j++){
					
					if(this.matrix[i][j].compareTo("E") == 0){
						
						posXandY[0] = i;
						posXandY[1] = j;
					} 
				}
				// System.out.println();
			}
			return posXandY;

		}catch(Exception err){
			throw new Exception(err);
		}
	}

	public int[] findForPossibilities(int x, int y, Boolean code) throws Exception{
		int i = 0;
		Boolean stringCode = code;
		Boolean anterior = false;
		/* Array indicando as possibilidades em string, onde a primeira posição se refere à "back", segunda à "ahead"
		terceira à "up" e quarta à "down" 
		o 1 representa que tal lugar é possivel, o 0 o contrário.*/
		int possibilities[] = {0, 0, 0 ,0};

		/* Array indicando as possibilidades em int (coordenadas).
		0*  posição -> up
		1*  posição -> down
		2*  posição -> ahead -> direita
		3*  posição -> back -> esquerda
		*/
		int array[] = {-1,-1,-1,-1,-1,-1,-1,-1};

		try{ 
			if(x > 0){
				if(matrix[x -1][y].compareTo(" ") == 0 || matrix[x - 1][y].compareTo("S") == 0 || matrix[x -1][y].compareTo("*") == 0) {
					array[i] = x;
					i++;
					array[i] = y;
					possibilities[0] = 1;
					anterior = true;
					if(matrix[x -1][y].compareTo("*") == 0){
						
					}
				}
			}
			
			if(x < lineMat){
				if(matrix[x + 1][y].compareTo(" ") == 0 || matrix[x + 1][y].compareTo("S") == 0) {
					if(anterior) i++;
					array[i] = x;
					i++;
					array[i] = y;
					possibilities[1] = 1;
				}
			}

			if(y < colMat - 1){
				if(matrix[x][y + 1].compareTo(" ") == 0 || matrix[x][y + 1].compareTo("S") == 0) {
					if(anterior) i++;
					array[i] = x;
					i++;
					array[i] = y;
					possibilities[2] = 1;
				}
			}
			
			if(y > 0){
				if(matrix[x][y - 1].compareTo(" ") == 0 || matrix[x][y - 1].compareTo("S") == 0) {
					if(anterior) i++;
					array[i] = x;
					i++;
					array[i] = y;
					possibilities[3] = 1;
				}
			}		

			//Desejo retornar as opções em string
			if(stringCode) return possibilities;
			else return array;

		}catch(Exception err){
			throw new Exception(err);
		}
	}

	public Vector returnStringPossibilities(int x, int y, Boolean code) throws Exception{
		int X = x;
		int Y = y;
		//Code true significa que queremos que retorne o array de strings
		Boolean CODE = code;
		// Função adicional para mostrar ao usuário quais opções de caminho ele tem
		int stringPos[] = findForPossibilities(X, Y, CODE);

		Vector<String> possibilities = new Vector<String>();

		if(stringPos[0] != 0) possibilities.add("Acima (pressione [A])");
		if(stringPos[1] != 0) possibilities.add("Abaixo (pressione [B])");
		if(stringPos[2] != 0) possibilities.add("Frente (pressione [F])");
		if(stringPos[3] != 0) possibilities.add("Voltar (pressione [V])");
		
		
		return possibilities;
	}

	public void printGame(){
		System.out.println();
		for(int i = 0; i < lineMat; i++){
			for(int j = 0; j  < colMat; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public int[] toWalk(int x, int y, String z){

		int ret[] = {-1,-1};

		if(z.toUpperCase().compareTo("A") == 0){
			if(x != 0){
				if(matrix[x -1][y].compareTo(" ") == 0 || matrix[x - 1][y].compareTo("S") == 0) {
					if(matrix[x - 1][y].compareTo(" ") == 0) matrix[x -1][y] = "*";
					
					ret[0] = x - 1;
					ret[1] = y;
				}else{
					System.out.println("Opa! Você digitou uma opção inexistente!");
				}
			}else{
				System.out.println("Opa! Você digitou uma opção inexistente!");
			}
		}
		
		if(z.toUpperCase().compareTo("B") == 0){
			if(x < lineMat){
				if(matrix[x + 1][y].compareTo(" ") == 0 || matrix[x + 1][y].compareTo("S") == 0) {
					if(matrix[x + 1][y].compareTo(" ") == 0) matrix[x + 1][y] = "*";
					ret[0] = x + 1;
					ret[1] = y;
				}else{
					System.out.println("Opa! Você digitou uma opção inexistente!");
				}
			}else{
				System.out.println("Opa! Você digitou uma opção inexistente!");
			}
		}
		

		if(z.toUpperCase().compareTo("F") == 0){
			if(y < colMat){
				if(matrix[x][y + 1].compareTo(" ") == 0 || matrix[x][y + 1].compareTo("S") == 0) {
					if(matrix[x][y + 1].compareTo(" ") == 0) matrix[x][y + 1] = "*";
					ret[0] = x;
					ret[1] = y + 1;
				}else{
					System.out.println("Opa! Você digitou uma opção inexistente!");
				}
			}else{
				System.out.println("Opa! Você digitou uma opção inexistente!");
			}
		}

		
		if(z.toUpperCase().compareTo("V") == 0){
			if(y != 0){
				if(matrix[x][y - 1].compareTo(" ") == 0 || matrix[x][y - 1].compareTo("S") == 0) {
					if(matrix[x][y - 1].compareTo(" ") == 0) matrix[x][y - 1] = "*";
					ret[0] = x;
					ret[1] = y - 1;
				}else{
					System.out.println("Opa! Você digitou uma opção inexistente!");
				}
			}else{
				System.out.println("Opa! Você digitou uma opção inexistente!");
			}
		}
		return ret;
	}

	public Boolean winVerify(int x, int y){
		if(matrix[x][y].toUpperCase().compareTo("S") != 0) return false;
		else return true;
	}
	
	public void endGame(){
		//ainda resta mostrar o numero de movimentos realizados.
		System.out.println("Parabéns, você venceu!");
	}

}
