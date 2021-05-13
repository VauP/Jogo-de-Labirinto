class Positions{
    private int x;
    private int y;

    public Positions(int x, int y) throws Exception{
      if(x == 0 || y == 0)
        throw new Exception ("Tamanho invalido");

      this.x = x;
      this.y = y;
      System.out.println("o x é: " + x + " o y é: "  + y);

    }

    public Positions(){

    }

    public int getX(){
      return this.x;
    }

     public int getY(){
      return this.y;
    }
}

