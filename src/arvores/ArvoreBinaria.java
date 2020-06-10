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
            System.out.println(bla);
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


    public static void main(String[] args) {
        Node<Integer> raiz =  new Node<Integer>(10);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>(raiz);

        var test1 = new Node<Integer>(8);
        var test2 = new Node<Integer>(5);
        var test3 = new Node<Integer>(9);
        var test4 = new Node<Integer>(12);
        var test5 = new Node<Integer>(12);
//        System.out.println(test);
        arvore.insere(test1);
        arvore.insere(test2);
        arvore.insere(test3);
        arvore.insere(test4);
        arvore.insere(test5);

    }
}
