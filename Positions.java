class Positions{
    private int x;
    private int y;

    public Positions(int x, int y) throws Exception{

      this.x = x;
      this.y = y;

    }

    public Positions(){

    }

    public int getX(){
      return this.x;
    }

     public int getY(){
      return this.y;
    }

    @Override
    public String toString(){
      String ret = "(" + this.x + ", " + this.y + ")";

      return ret;
    }
}

