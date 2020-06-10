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

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Node<E> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node<E> esquerda) {
        this.esquerda = esquerda;
    }

    public Node<E> getDireita() {
        return direita;
    }

    public void setDireita(Node<E> direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }

    public Node(E info) {
        this.info = info;
    }

    public Boolean vazio(){
        return this.esquerda == null && this.direita == null;
    }






}


