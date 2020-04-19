public class PilhaEncadeada<E> {
    private int topo;
    public ListaEncadeada<E> dados;
    private int MAX;

    public PilhaEncadeada(int MAX) {
        this.MAX = MAX;
        this.topo = -1;
        this.dados = new ListaEncadeada<>();
    }

    public E getTop() {
        return isEmpty() ? null :  dados.getLastNode(dados.getFirstNode()).getInformacao();
    }

    public void stackUp(E dado) {
        topo += 1;
        dados.insertNext();

    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == MAX -1;
    }

    public void unstack() {
        dados.removeLast();
        topo -= 1;
    }

//    @Override
//    public String toString() {
//        System.out.println("aaaaaaaa");
//        String str = "Pilha Object:\n[\n";
//        for (int i = MAX -1; i > -1; i--) {
//            try {
//                str = str.concat("  " + dados[i].toString() + "\n");
//
//            } catch (Exception e) {
//                str = str.concat("  " + "null" + "\n");
//            }
//
//        }
//        return str + "]";
//    }

    public static void main(String[] args) {
        PilhaEncadeada<String> dois = new PilhaEncadeada<String>(2);

        dois.stackUp("j");
        dois.stackUp("l");
//        dois.unstack();
//        System.out.println(dois);
        System.out.println(dois.isFull());
        System.out.println(dois.isEmpty());


    }

}
