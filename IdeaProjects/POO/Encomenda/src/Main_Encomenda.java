public class Main_Encomenda {

    public static void main (String[]args){
        Encomenda t1 = new Encomenda();

        LinhaEncomenda le = new LinhaEncomenda("ikenfwn", "Cadeira gaming",150 , 1, 0.1, 0.3);

        t1.adicionaLinha(le);
        double res1 = t1.calculaValorTotal();
        double res2 = t1.calculaValorDesconto();
        double res3 = t1.numeroTotalProdutos();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(t1.toString());
    }
}
