import java.util.Objects;

public class Node<E> {
    private E informacao;
    private Node<E> proximo;

    public Node(E informacao, Node proximo) {
        this.informacao = informacao;
        this.proximo = proximo;
    }

    public void setProximo(Node<E> proximo) {
        this.proximo = proximo;
    }

    public Node<E> getProximo() {
        return proximo;
    }

    public E getInformacao() {
        return informacao;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(55, null);
        Node<Integer> node2 = new Node<>(40, null);
        System.out.println(node1.equals(node2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return informacao.equals(node.informacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informacao);
    }

    @Override
    public String toString() {
        String next = proximo == null ? "null" : proximo.toString();
        return "Node{" + informacao + "} -> " + next;
    }
}
