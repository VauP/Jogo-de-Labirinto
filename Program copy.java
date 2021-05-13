
class Program
{

	public static void main (String[] args) throws Exception{
		
		 try
        {
            Stack p = new Stack(6);
            Positions posicao1 = new Positions(1, 5);
						Positions posicao2 = new Positions(2, 5);
						Positions posicao3 = new Positions(3, 5);
						Positions posicao4 = new Positions(4, 5);
						Positions posicao5 = new Positions(5, 5);
						Positions posicao6 = new Positions(6, 5);
						

            p.guardeUmItem(posicao1);
            p.guardeUmItem(posicao2);
            p.guardeUmItem(posicao3);
            p.guardeUmItem(posicao4);
            p.guardeUmItem(posicao5);
            p.guardeUmItem(posicao6);

              while (!p.isVazia())
            {
                System.out.println(p.recupereUmItem());
                p.removaUmItem();
            }

        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
	}
}
