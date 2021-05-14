import java.io.*;


class Stack <Coordenadas> implements Cloneable{
	private Positions[] posicao;
    private Positions[] finalPos; //private X[] elemento;
    private int      tamanhoInicial;
    private int      ultimo=-1; //vazio
    

    public Stack (int tamanho) throws Exception
    {
		
        if (tamanho<=0)
            throw new Exception ("Tamanho invalido");

        this.posicao        = new Positions[tamanho]; //this.posicao=new X [tamanho];
        this.tamanhoInicial = tamanho;
    }

   
    public void guardeUmItem (Positions x) throws Exception // LIFO
    {
        if (x==null)
            throw new Exception ("Falta o que guardar");

        this.ultimo++;

        this.posicao[this.ultimo] = x;
    }

    public Positions recupereUmItem () throws Exception // LIFO
    {
        if (this.ultimo==-1) // vazia
            throw new Exception ("Nada a recuperar");

        Positions ret =null;
        
        ret = (Positions) this.posicao[this.ultimo];

        return ret;
    }


    public void removaUmItem (Boolean check) throws Exception //LIFO ultimo a entrar primeiro a sair
    {
        if (this.ultimo==-1) {}
        else{// vazia
            // throw new Exception ("Nada a remover");

            if(check) this.posicao[this.ultimo] = null;
            this.ultimo--;
        }
    }

    
    public String tostring ()
    {
        String ret = (this.ultimo+1) + " elemento(s)";
        
        if (this.ultimo!=-1)
            ret += ", sendo o ultimo "+this.posicao[this.ultimo];
            
        return ret;
    }

    public boolean equals (Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Stack<Coordenadas> pil = (Stack<Coordenadas>) obj;

        if(this.ultimo!=pil.ultimo)
            return false;

        if(this.tamanhoInicial!=pil.tamanhoInicial)
            return false;

        for(int i=0 ; i<this.ultimo;i++)
            if(!this.posicao[i].equals(pil.posicao[i]))
                return false;

        return true;
    }

    public boolean isVazia ()
    {
        if(this.ultimo==-1)
            return true;

        return false;
    }

    public void printAllMoves() throws Exception{
        System.out.println("No total foram feitos " + (this.ultimo+1) + " movimentos");
        finalPos = new Positions[this.ultimo];
        int test = this.ultimo;
        
        for(int f = 0; !isVazia(); f++)
        {
            System.out.println("Movimento " + (f + 1) + ": "+ posicao[f].toString() + " ");
           
            removaUmItem(false);
        }
       
        /* if (this.ultimo!=-1)
            ret += ", sendo o ultimo "+this.posicao[this.ultimo]; */
            
    }


}

