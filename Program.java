import java.io.*;
import java.util.Vector;

class Program
{

	public static void main (String[] args) throws Exception{
		try{
			String fileName = "";
			Boolean checkErro = false;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	
			while(fileName == "" || !checkErro){
				System.out.println("Qual será o nome do labirinto?");
				fileName = in.readLine();
	
				OpenFile OpenFileObj = new OpenFile(fileName);
	
				checkErro = OpenFileObj.fileVerify();
				if(!checkErro){
					System.out.println("Ops! Parece que este jogo não está finalizado, ele possui erros!");
				}
				else{
					System.out.println("Bom Jogo!");
					String matrix[][] = OpenFileObj.convertToMatrix();	
	
					//Instanciando classes
					Queue queue = new Queue(matrix);
	
					int startPosition[] = queue.findForStart();
	
					System.out.println("Sua posição atual é: (" + startPosition[0] + "," + startPosition[1] + ")");
					queue.printGame();
	
					Vector<String> freeSquares = new Vector<String>();
	
					while(!queue.winVerify(startPosition[0], startPosition[1])){
						freeSquares = queue.returnStringPossibilities(startPosition[0], startPosition[1], true);
	
						
						int oldPos1 = startPosition[0]; //EIXO X [AQUI][]
						int oldPos2 = startPosition[1]; //EIXO Y [][AQUI]
						System.out.println();
						printOptions(freeSquares);
	
						System.out.println();
	

						String charIn = in.readLine();
						try{
							startPosition = queue.toWalk(startPosition[0], startPosition[1], charIn);
						}catch(Exception err){
							//pega a exception
							System.out.println("Opa! Opção invalida, digite novamente");
						}
	
						if(startPosition[0] == -1){
							startPosition[0] = oldPos1;
							startPosition[1] = oldPos2;
						}
					
						queue.printGame();
						
					}
	
					Stack coordenadas = queue.getStack();
					queue.endGame();
					System.out.println(coordenadas.printAllMoves());;
					
					
				}
				
			}
		}catch(Exception err){
			throw new Exception ("Erro! " + err);
		}
		
			
	}



	private static void printOptions(Vector<String> x){
		if(x != null){
			System.out.println("Suas opções são: ");

			for(int i = 0; i < x.size(); i++){
				if(x.size() > 1){
					if(i < x.size() - 1){
						System.out.print(x.get(i) + ", ");
					}else{
						System.out.print("e " + x.get(i));
					}
				}
				else{
					System.out.println("Opa! Você pode ir apenas para: " + x.get(i));
				}
				
			}
		}
			
	}
}
