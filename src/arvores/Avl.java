package arvores;

import java.nio.charset.IllegalCharsetNameException;

public class Avl<E> extends ArvoreBinaria<Integer>{

    public Avl(Node<Integer> raiz) {
        super(raiz);
    }

    public Node<Integer> buscar(int elemento) {
        Node<Integer> atual = raiz;

        while ( atual != null && atual.getInfo() != elemento) {
            if (atual.getInfo() > elemento)
                atual = atual.getEsquerda();
            else
                atual = atual.getDireita();
        }
        return atual;
    }

    public int balanceamento(Node<Integer> node) {
        return altura(node.getEsquerda()) - altura(node.getDireita());
    }

    public static void main(String[] args) {
        Node<Integer> raiz =  new Node<Integer>(10);
        Avl<Integer> arvore = new Avl<>(raiz);

        var test1 = new Node<Integer>(8);
        var test2 = new Node<Integer>(5);


        arvore.insere(test1);
        arvore.insere(test2);

        System.out.println(arvore.buscar(1));
        System.out.println(arvore.altura());
        System.out.println(arvore.balanceamento(arvore.raiz));

    }


}
