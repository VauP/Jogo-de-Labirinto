import java.io.*;
import java.util.Vector;

public class OpenFile {
    Vector<String> filePerLine = new Vector<>();
    String fileName;
    String nome;
    private int lineLen = 0;
    private int columnLen = 0;
    public static void main(String[] args){
       
        
    }

    public OpenFile(String name){
        this.fileName = name;
    }


    public Vector fileReturn(){
        BufferedReader in = null;
        String file = "";
        try {
            in = new BufferedReader (new FileReader("./TextsFiles/" + fileName + ".txt"));
            
            String str;
            int a = 0;
            while((str = in.readLine()) != null){
                if(a == 0){
                    LineAndCol GetLinAndCol = new LineAndCol(str, a);
                    System.out.println("Entrou a = 0");
                    this.lineLen = GetLinAndCol.GetLine();
                    
                    
                    a++;
                }else if(a == 1){
                    LineAndCol GetLinAndCol = new LineAndCol(str, a);
                    System.out.println("Entrou a = 1");
                    
                    this.columnLen = GetLinAndCol.GetCol();
                   
                    a++;
                }
                filePerLine.add(str);
                // System.out.println(str); 
                
            }


            file = in.readLine();
            in.close();
        } catch(IOException e) {}
        return filePerLine;
    }

    public int[] getLinAndCol(int x, int y){
        int[] stockPos = new int[2];
        stockPos[0] = x;
        stockPos[1] = y;

        return stockPos;
    }


    public Boolean fileVerify(){
        Vector fileObj = fileReturn();

        // String[] acceptableCharacters = {"#", " ", "S", "E", "*"};
        String[] acceptableCharacters = {
        "A", "B", "C", "D", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "T", "U", "V",
        "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "'", "!", "@", "$", "%", "¨",
        "&", "(", ")", "-", "_", "+", "=", "`", "´", "{", "[", "^", "~", "]", "}", ",", "<", ".", ">", ";",
        ":", "/", "?", "|" };

        int HasAnyEspaço = 0;
        int HasAnyS = 0;
        int HasAnyE = 0;
        int HasAnyCerquilha = 0;
        Boolean HasEqualLine = true;
        Boolean HasEqualColumn = true;
        Boolean HasSquaresOnLaterals = true;
        Boolean HasAnyNotAcceptCharacter = true;
        // LineAndCol GetLinAndCol = new LineAndCol();
        int line = this.lineLen;
        int column = this.columnLen;

        // System.out.println("tamanho -> " + fileObj.size());

        for(int i = 2; i < fileObj.size(); i++){

            // System.out.println("linha -> " + line + " coluna -> " + column);
            // System.out.println("olha o tamanho da linha -> " +((String) fileObj.elementAt(i)).length());
            if(fileObj.size() - 2 > line) HasEqualLine = false;
            if(((String) fileObj.elementAt(i)).length() > column) HasEqualColumn = false;
            if(
                fileObj.elementAt(i).toString().substring(0, 1).compareTo("#") != 0 && 
                fileObj.elementAt(i).toString().substring(0, 1).compareTo("S") != 0 &&
                fileObj.elementAt(i).toString().substring(0, 1).compareTo("E") != 0
            ) HasSquaresOnLaterals = false;
            
            for(int j = 0; j < acceptableCharacters.length; j++){
                if(fileObj.elementAt(i).toString().toUpperCase().contains(acceptableCharacters[j])) HasAnyNotAcceptCharacter = false;
            }
            if(fileObj.elementAt(i).toString().contains(" ")) HasAnyEspaço++;
            if(fileObj.elementAt(i).toString().contains("S")) HasAnyS++;
            if(fileObj.elementAt(i).toString().contains("E")) HasAnyE++;
            if(fileObj.elementAt(i).toString().contains("#")) HasAnyCerquilha++;
        }
        if(!HasAnyNotAcceptCharacter || !HasSquaresOnLaterals || !HasEqualLine || !HasEqualColumn || HasAnyCerquilha == 0 || HasAnyE == 0 || HasAnyE > 1 || HasAnyS == 0 || HasAnyS > 1 || HasAnyEspaço == 0){
            return false;
        }
       
        return true;
    }

    
    public String[][] convertToMatrix(){
        Vector fileObj = fileReturn();
        int x = Integer.parseInt(fileObj.elementAt(0).toString());
        int y = Integer.parseInt(fileObj.elementAt(1).toString());
        String[][] matrix = new String[x][y];

        for(int i = 0, j = 2;i < x; i++, j++){ 

            for(int k = 0; k < y;  k++){
                String line = fileObj.elementAt(j).toString();
                // System.out.println(line);
                if(k < y) {
                    String c = line.substring(k, k+1);
                    matrix[i][k] = c;
                    // System.out.print(matrix[i][j]);
                    // System.out.println("i -> " + i + " j-> " + j);
                }
                // System.out.print(matrix[i][j]);
            }
            // System.out.println();
        }
        // for(int i = 0; i < x; i++){
        //     for(int j = 0; j< y; j++){
        //         System.out.print(matrix[i][j]);
        //     }
        //     System.out.println();
        // }
        return matrix;
    }
    
}
