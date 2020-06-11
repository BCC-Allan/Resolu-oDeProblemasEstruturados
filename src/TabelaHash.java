

public class TabelaHash {
    public int colisao; // numero de colisoes da tabela
    public NodeTabela[] tabelas;

    public TabelaHash(int max) {
        tabelas = new NodeTabela[max];
    }

    public void insere(int chave){
        var indice = h(chave);

        if (tabelas[indice] == null) {
            var node = new NodeTabela(chave);
            tabelas[indice] = node;
        }else{
            var node = tabelas[indice];
            encadeamento(node, chave);
            System.out.println("Break");
        }

    }

    public void encadeamento(NodeTabela node, int chave){
        node.getLista().insertLast(chave);
    }

    public int h(int chave){
        return chave % tabelas.length;
    }

    public static void main(String[] args) {
        TabelaHash tabelas = new TabelaHash(10);
        tabelas.insere(155);
        tabelas.insere(255);

        System.out.println(tabelas.tabelas[5].getLista());



    }
}
