public class PilhaEncadeada<E> {

    private ListaEncadeada<E> dados;

    public PilhaEncadeada() {
        this.dados = new ListaEncadeada<E>();
    }

    public void emplilha(E dado) {
        dados.insertLast(dado);
    }

    public void desemplilha() {
        dados.removeLast();

    }

    public E topo() {
        return dados.getFirst();
    }

    @Override
    public String toString() {
        return dados.toString();
    }

    public static void main(String[] args) {
        PilhaEncadeada<String> pilha = new PilhaEncadeada<>();
        pilha.emplilha("a");
        pilha.emplilha("b");
        System.out.println(pilha);
        pilha.emplilha("c");
        pilha.emplilha("d");
        System.out.println(pilha);

        pilha.desemplilha();
        System.out.println(pilha);

        pilha.emplilha("f");
        pilha.emplilha("f");

        System.out.println(pilha);
    }
}
