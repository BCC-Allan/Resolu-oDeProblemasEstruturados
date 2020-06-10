package arvores;

public class ArvoreBinaria<E> {
    public Node<Integer> raiz;

    public ArvoreBinaria(Node<Integer> raiz) {
        this.raiz = raiz;
    }


    public Node<Integer> getRaiz() {
        return raiz;
    }

    public void setRaiz(Node<Integer> raiz) {
        this.raiz = raiz;
    }

    public void delete(int valorDeletar){
        deleteFake(valorDeletar, raiz);
    }

    public void deleteFake(int valor, Node<Integer> raizNode){
        var nodeAnterior = buscaAnterior(valor, raizNode);
        var direita_anterior = nodeAnterior.getDireita();
        var esquerda_anterior = nodeAnterior.getEsquerda();
        var node_atual = buscaNodeFake(valor, raizNode);
        var direita_atual = node_atual.getDireita();
        var esquerda_atual = node_atual.getEsquerda();

        if(node_atual.semFilho()){
            if(direita_anterior.getInfo().equals(node_atual.getInfo())){  // atual na direita do seu pai
                nodeAnterior.setDireita(null);
            }else{ // atual na esquerda do seu pai
                nodeAnterior.setEsquerda(null);
            }

        }else if(node_atual.doisFilhos()){  // atual tem 2 filhos
           nodeAnterior.setDireita(direita_atual);
           direita_atual.setEsquerda(esquerda_atual);
        }else if(esquerda_atual != null){ // atual tem 1 filho na esquerda
            nodeAnterior.setEsquerda(esquerda_atual);
        }else if(direita_atual != null){
            nodeAnterior.setDireita(direita_atual);
        }

    }

    public Node<Integer> buscaAnterior(int valor, Node<Integer> raizNode){
        if(valor == raizNode.getEsquerda().getInfo() || valor == raizNode.getDireita().getInfo()){
            return raizNode;
        }else if(valor > raizNode.getInfo()){
            return buscaAnterior(valor, raizNode.getDireita());
        }else if(valor < raizNode.getInfo()) {
            return buscaAnterior(valor, raizNode.getEsquerda());
        }else{
            return new Node<Integer>(-1);
        }
    }

    public void buscaNode(int valor){
        buscaNodeFake(valor, raiz).printaOsDois();
    }

    public Node<Integer> buscaNodeFake(int valor, Node<Integer> raizNode){

        if(valor == raizNode.getInfo()){
            return raizNode;
        }else if(valor > raizNode.getInfo()){
            return buscaNodeFake(valor, raizNode.getDireita());
        }else if(valor < raizNode.getInfo()) {
            return buscaNodeFake(valor, raizNode.getEsquerda());
        }else{
            return new Node<Integer>(-1);
        }

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
        Node<Integer> raiz =  new Node<>(10);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>(raiz);

        var test1 = new Node<>(8);
        var test2 = new Node<>(5);
        var test3 = new Node<>(9);
        var test4 = new Node<>(12);
        var test5 = new Node<>(15);
        var test6 = new Node<>(11);

        arvore.insere(test1);
        arvore.insere(test2);
        arvore.insere(test3);
        arvore.insere(test4);
        arvore.insere(test5);
        arvore.insere(test6);


//        arvore.printaExercicio("emOrdem");
        System.out.println(arvore.raiz);
        System.out.println("--------------------------");
        arvore.delete(9);
        System.out.println("--------------------------");
        System.out.println(arvore.raiz);

        arvore.printaExercicio("emOrdem");


    }
}
