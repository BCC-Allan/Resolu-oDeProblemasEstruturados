public class ListaEncadeada<E> {
    public Node<E> getLista() {
        return lista;
    }

    private Node<E> lista;

    public ListaEncadeada() {
        this.lista = null;
    }

    public void insertFirst(E info) {
        lista = new Node<>(info, null);
    }

    public E getFirst() {
        return lista.getInformacao();
    }


    public boolean empty() {
        return lista == null;
    }

    public void insertNext(Node<E> node, E info) {

        Node<E> before = findNode(lista, node);
        Node<E> midle;
        Node<E> last = before.getProximo();
        if (last == null) {
            midle = new Node<>(info, null);
        } else {
            midle = new Node<>(info, last);
        }
        before.setProximo(midle);
    }
//
    public void insertLast(E info) {
        if(lista == null) {
            insertFirst(info);
            return;
        }

        Node<E> last = getLastNode(lista);
        Node<E> next = new Node<>(info, null);

        last.setProximo(next);

    }

    private Node<E> getLastNode(Node<E> node) {
        if (node.getProximo() == null) {
            return node;
        } else {
            return  getLastNode(node.getProximo());
        }
    }

    private Node<E> findNode(Node<E> baseNode,Node<E> node) {
        if (node.equals(baseNode)) {
            return baseNode;
        } else {
            return findNode(baseNode.getProximo(), node);
        }
    }

    public void gambis(Node<E> node){
        findNode(lista, node);
    }

    //penultimo
    private Node<E> findOneToLastNode(Node<E> baseNode) {
        if (baseNode.getProximo() == null) {
            return baseNode;
        } else if(baseNode.getProximo().getProximo() == null){
            return baseNode;
        } else {
            return findOneToLastNode(baseNode.getProximo());
        }
    }

    public Node<E> removeFirst() {
        lista = lista.getProximo();
        return lista;
    }

    public Node<E> removeLast() {
        Node<E> oneToLast = findOneToLastNode(lista);
        Node<E> last = oneToLast.getProximo();
        oneToLast.setProximo(null);
        return last;
    }

    @Override
    public String toString() {
        return "ListaEncadeada[" + lista.toString() + "]";
    }

//    public static void main(String[] args) {
//        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
//        lista.insertFirst(39);
//        lista.insertLast(40);
//        lista.insertLast(41);
//        lista.insertLast(42);
//        lista.insertLast(43);
//        lista.insertLast(45);
//        lista.insertLast(46);
//        Node<Integer> oldNode = new Node<>(40, null);
//        lista.insertNext(oldNode, 99);
//
//        lista.removeLast();
//
//        System.out.println(lista.toString());
//
//    }

}
