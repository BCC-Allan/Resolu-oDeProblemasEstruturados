

public class TabelaHash {
    public int colisao; // numero de colisoes da tabela
    public NodeTabela[] tabelas = new NodeTabela[10];

    public TabelaHash() {

    }

    public TabelaHash(int max) {
        tabelas = new NodeTabela[max];
    }

    public void insere(int chave){
        var indice = h(chave);
        var node = new NodeTabela(chave);

        if (tabelas[indice] == null) {
            tabelas[indice] = node;
        }else{
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
        TabelaHash tabelas = new TabelaHash();
        tabelas.insere(155);
        tabelas.insere(255);

        System.out.println(tabelas.tabelas[5]);



    }
}
