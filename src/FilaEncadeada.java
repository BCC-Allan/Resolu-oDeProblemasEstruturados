public class FilaEncadeada<E> {

    private ListaEncadeada<E> dados;

    public FilaEncadeada() {
        this.dados = new ListaEncadeada<E>();

    }

    public void inserir(E dado) {
        dados.insertLast(dado);

    }

    public void remover() {
        if (dados.empty()){
            System.out.println("A fila esta vazia");
        } else {
            dados.removeFirst();
        }

    }

    @Override
    public String toString() {
        return dados.toString();
    }

    public static void main(String[] args) {
        FilaEncadeada<String> fila = new FilaEncadeada<>();
        fila.remover();

        fila.inserir("a");
        fila.inserir("b");
        fila.inserir("c");
        System.out.println(fila);
        fila.remover();
        System.out.println(fila);


    }
}
