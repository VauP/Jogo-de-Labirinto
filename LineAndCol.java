import java.io.*;
import java.util.Vector;

public class LineAndCol {
    int line;
    int col;

    public LineAndCol(String x, int ver){
      if(ver == 0){
        this.line = Integer.parseInt(x);
      }else if(ver == 1){
          this.col = Integer.parseInt(x);
      }
    }

    public LineAndCol(){

    }

    public int GetLine(){
        return this.line;
    }

    public int GetCol(){
        return this.col;
    }

    


}
