package arvores;

public class ArvoreBinaria<E> {
    private Node<E> raiz;

    public ArvoreBinaria(Node<E> raiz) {
        this.raiz = raiz;
    }

    public static void main(String[] args) {
        Node<Integer> raiz =  new Node<>(1);
        ArvoreBinaria<Integer> arvre = new ArvoreBinaria<>(raiz);
    }

}
