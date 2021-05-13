import java.io.*;
import java.util.Vector;

public class OpenFile {
    Vector<String> filePerLine = new Vector<>();
    String fileName;
    String nome;
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
                    a++;
                }else if(a == 1){
                    LineAndCol GetLinAndCol = new LineAndCol(str, a);
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


    public Boolean fileVerify(){
        Vector fileObj = fileReturn();

        int HasAnyEspaço = 0;
        int HasAnyS = 0;
        int HasAnyE = 0;
        int HasAnyCerquilha = 0;
        Boolean HasEqualLine = true;
        Boolean HasEqualColumn = true;
        LineAndCol GetLinAndCol = new LineAndCol();
        int line = GetLinAndCol.GetLine();
        int column = GetLinAndCol.GetCol();

        System.out.println(fileObj.size());

        for(int i = 0; i < fileObj.size(); i++){

            if(((String) fileObj.elementAt(i)).length() > line) HasEqualLine = false;
            if(((String) fileObj.elementAt(i)).length() > column) HasEqualColumn = false;
            if(fileObj.elementAt(i).toString().contains(" ")) HasAnyEspaço++;
            if(fileObj.elementAt(i).toString().contains("S")) HasAnyS++;
            if(fileObj.elementAt(i).toString().contains("E")) HasAnyE++;
            if(fileObj.elementAt(i).toString().contains("#")) HasAnyCerquilha++;
        }
        if(!HasEqualLine || !HasEqualColumn || HasAnyCerquilha == 0 || HasAnyE == 0 || HasAnyE > 1 || HasAnyS == 0 || HasAnyS > 1 || HasAnyEspaço == 0){
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
