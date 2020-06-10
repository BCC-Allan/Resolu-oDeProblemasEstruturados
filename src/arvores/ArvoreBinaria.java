package arvores;

public class ArvoreBinaria<E> {
    private Node<Integer> raiz;

    public ArvoreBinaria(Node<Integer> raiz) {
        this.raiz = raiz;
    }


    public Node<Integer> getRaiz() {
        return raiz;
    }

    public void setRaiz(Node<Integer> raiz) {
        this.raiz = raiz;
    }

    public void insere(Node<Integer> node){
        if (raiz == null){
            setRaiz(node);
        }else{
            var bla = escolheLado(raiz, node);
//            System.out.println(bla);
        }

    }

    public Node<Integer> escolheLado(Node<Integer> nodeAtual , Node<Integer> nodeNovo) {
        if (nodeAtual.getInfo() > 0 && nodeAtual.getInfo() > nodeNovo.getInfo()) {
            if (nodeAtual.getEsquerda() == null){
                nodeAtual.setEsquerda(nodeNovo);
                return nodeAtual;
            }else{
                return escolheLado(nodeAtual.getEsquerda(), nodeNovo);
            }
        }else if (nodeAtual.getInfo() > 0 && nodeAtual.getInfo() < nodeNovo.getInfo()) {
            if (nodeAtual.getDireita() == null){
                nodeAtual.setDireita(nodeNovo);
                return nodeAtual;
            }else{
                return escolheLado(nodeAtual.getDireita(), nodeNovo);
            }
        }else{
            System.out.println("Valor Invalido este Nó ja possui no node ou é negativo");
            return new Node<Integer>(666);
        }
    }

    public void printaExercicio(String Tipo){
        switch (Tipo) {
            case "preOrdem":
                preOrdem(raiz);
                break;
            case "emOrdem":
                emOrdem(raiz);
                break;
            case "posOrdem":
                posOrdem(raiz);
                break;
        }
    }

    private void posOrdem(Node<Integer> nodeRaiz) {
        if (nodeRaiz != null) {
            posOrdem(nodeRaiz.getEsquerda());
            posOrdem(nodeRaiz.getDireita());
            System.out.println(nodeRaiz);
        }
    }

    private void emOrdem(Node<Integer> nodeRaiz) {
        if (nodeRaiz != null){
            emOrdem(nodeRaiz.getEsquerda());
            System.out.println(nodeRaiz);
            emOrdem(nodeRaiz.getDireita());
        }
    }

    public void preOrdem(Node<Integer> nodeRaiz) {
        System.out.println(nodeRaiz);
        if(nodeRaiz.getEsquerda() != null){
            preOrdem(nodeRaiz.getEsquerda());
            preOrdem(nodeRaiz.getDireita());
        }else if(nodeRaiz.getDireita() != null){
            preOrdem(nodeRaiz.getDireita());
        }
    }

    public static void main(String[] args) {
        Node<Integer> raiz =  new Node<Integer>(10);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>(raiz);

        var test1 = new Node<Integer>(8);
        var test2 = new Node<Integer>(5);
        var test3 = new Node<Integer>(9);
        var test4 = new Node<Integer>(12);
        var test5 = new Node<Integer>(15);
        var test6 = new Node<Integer>(11);

        arvore.insere(test1);
        arvore.insere(test2);
        arvore.insere(test3);
        arvore.insere(test4);
        arvore.insere(test5);
        arvore.insere(test6);

//        arvore.printaExercicio("preOrdem");
//        arvore.printaExercicio("emOrdem");
//        arvore.printaExercicio("posOrdem");

    }
}
