import java.io.*;
import java.util.Arrays;

class Program
{

	public static void main (String[] args) throws Exception{
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
			}
			
		}
			
	}
}
