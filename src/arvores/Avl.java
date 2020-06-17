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

    public int balanceamento(){
        return balanceamento(this.raiz);
    }


    private void balancear(Node<Integer> nodeAtual) {
        var test = balanceamento(nodeAtual);
        if (balanceamento(raiz) > 1) {
            System.out.println("dir");
            rotDireita(nodeAtual);
        }
        else if (Math.abs(balanceamento(raiz)) > 1) {
            System.out.println("esq");
            rotEsquerda(nodeAtual);
        }
    }

    private void rotDireita(Node<Integer> raiz) {
//        System.out.println("rotacionando para direita");


        Node<Integer> novaRaiz = raiz.getEsquerda();
        Node<Integer> temp = novaRaiz.getDireita();
        novaRaiz.setDireita(raiz);
        raiz.setEsquerda(temp);

        var esquerda = novaRaiz.getEsquerda();
        var direita = novaRaiz.getDireita();
        trocaPai(novaRaiz, buscaAnterior(raiz.getInfo()));
        if (novaRaiz.getEsquerda() != null)
            trocaPai(buscaAnterior(esquerda.getInfo()), novaRaiz);
        trocaPai(buscaAnterior(direita.getInfo()), novaRaiz);

        if (raiz == this.raiz)
            this.raiz = novaRaiz;
    }


    private void trocaPai(Node<Integer> filho, Node<Integer> novoPai) {
        var pai = buscaAnterior(filho.getInfo());
        var direita = pai.getDireita();
        var esquerda = pai.getEsquerda();

        if(esquerda.getInfo().equals(filho.getInfo())){
            pai.setEsquerda(null);
        }else{
            pai.setDireita(null);
        }

        if(filho.getInfo() < novoPai.getInfo()){
            novoPai.setEsquerda(filho);
        }else{
            novoPai.setDireita(filho);
        }





    }

    private void rotEsquerda(Node<Integer> raiz) {
        Node<Integer> novaRaiz = raiz.getEsquerda();
        Node<Integer> temp = novaRaiz.getEsquerda();
        novaRaiz.setEsquerda(raiz);
        raiz.setDireita(temp);

        var esquerda = novaRaiz.getEsquerda();
        var direita = novaRaiz.getDireita();

        trocaPai(novaRaiz, buscaAnterior(raiz.getInfo()));


        if (novaRaiz.getDireita() != null)
            trocaPai(buscaAnterior(direita.getInfo()), novaRaiz);
        trocaPai(buscaAnterior(esquerda.getInfo()), novaRaiz);


        if (raiz == this.raiz)
            this.raiz = novaRaiz;
    }

    @Override
    public void insere(Node<Integer> node) {
        super.insere(node);
        var balanca = balanceamento(raiz);
        if(!isBalanceado(raiz)){
            System.out.println("não esta balanceado otario");
            balancear(node);
        }
    }
    private int diferencaBalanceamento(Node<Integer> node) {
        if (node == null)
            return 0;

        return altura(node.getEsquerda()) - altura(node.getDireita());
    }

    private boolean isBalanceado(Node<Integer> atual) {
        if (atual == null)
            return true;

        return Math.abs(diferencaBalanceamento(atual)) <= 1
                && isBalanceado(atual.getEsquerda()) && isBalanceado(atual.getDireita());
    }


    public static void main(String[] args) {
        Node<Integer> raiz =  new Node<Integer>(10);
        Avl<Integer> arvore = new Avl<>(raiz);

        var test1 = new Node<Integer>(8);
        var test2 = new Node<Integer>(20);
        var test3 = new Node<Integer>(19);
        var test4 = new Node<Integer>(21);
        var test5 = new Node<Integer>(22);
        System.out.println(arvore.balanceamento());

        arvore.insere(test1);
        System.out.println(arvore.balanceamento());

        arvore.insere(test2);
        System.out.println(arvore.balanceamento());

        arvore.insere(test3);
        System.out.println(arvore.balanceamento());

        arvore.insere(test4);
        System.out.println(arvore.balanceamento());

        arvore.insere(test5);
        System.out.println(arvore.balanceamento());


//        System.out.println(arvore.buscar(5));
//        System.out.println(arvore.altura());
        System.out.println("-----------------------");
//        arvore.printaExercicio("emOrdem");


    }


}
