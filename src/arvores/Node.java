package arvores;

public class Node<E> {
    private E info;
    private  Node<E> esquerda;
    private  Node<E> direita;



    public Node(E info, Node<E> esquerda, Node<E> direita) {
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Node(E info) {
        this.info = info;
    }



}


