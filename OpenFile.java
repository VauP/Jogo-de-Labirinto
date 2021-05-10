import java.io.*;
import java.util.Vector;

public class OpenFile {
    Vector<String> filePerLine = new Vector<>();
    String fileName;
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
                filePerLine.add(str);
                // System.out.println(str); 
                
            }
            file = in.readLine();
            in.close();
        } catch(IOException e) {}
        return filePerLine;
    }

    public Boolean fileVerify(){
        Vector fileObj = fileReturn();

        Boolean HasAnyEspaço = false;
        Boolean HasAnyS = false;
        Boolean HasAnyE = false;
        Boolean HasAnyCerquilha = false;
        for(int i = 0; i < fileObj.size(); i++){
            if(fileObj.elementAt(i).toString().contains(" ")) HasAnyEspaço = true;
            if(fileObj.elementAt(i).toString().contains("S")) HasAnyS = true;
            if(fileObj.elementAt(i).toString().contains("E")) HasAnyE = true;
            if(fileObj.elementAt(i).toString().contains("#")) HasAnyCerquilha = true;
        }
        if(!HasAnyCerquilha || !HasAnyE || !HasAnyS || !HasAnyEspaço){
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
