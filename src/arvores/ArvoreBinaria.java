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
        var direita = raizNode.getDireita();
        var esquerda = raizNode.getEsquerda();
        if(raizNode.vazio()){
            if(esquerda.getInfo().equals(raizNode.getInfo())){
                nodeAnterior.setEsquerda(null);
            }else{
                nodeAnterior.setDireita(null);
            }
        }else if(esquerda != null && direita != null){
           nodeAnterior.setDireita(direita);
           direita.setEsquerda(esquerda);
        }else if(esquerda != null){
            nodeAnterior.setEsquerda(esquerda);
        }else if(direita != null){
            nodeAnterior.setDireita(direita);
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
//          System.out.println(bla);
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
//            System.out.println(nodeRaiz);
            System.out.println(nodeRaiz.test());
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

    public int altura(){
       return altura(raiz);
    }

    public int altura(Node<Integer> atual) {
        if(atual == null || (atual.getEsquerda() == null && atual.getDireita() == null))
            return 0;
        else {
            if (altura(atual.getEsquerda()) > altura(atual.getDireita()))
                return ( 1 + altura(atual.getEsquerda()) );
            else
                return ( 1 + altura(atual.getDireita()) );
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
//        arvore.buscaNode(9);

        arvore.printaExercicio("emOrdem");
        System.out.println("--------------------------");
        arvore.delete(9);
//        System.out.println("--------------------------");
//        arvore.printaExercicio("emOrdem");


    }
}
