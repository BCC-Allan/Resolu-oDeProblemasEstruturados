import java.util.Arrays;

public class TabelaHash {
    public int colisao; // numero de colisoes da tabela
    public NodeTabela[] tabelas;

    public TabelaHash(int max) {
        tabelas = new NodeTabela[max];
        colisao = 0;
//        populaTabela();
    }

    public void insere(int chave){
        var indice = h(chave);

        if (tabelas[indice] == null || tabelas[indice].getInfo() == -1) {
            var node = new NodeTabela(chave);
            tabelas[indice] = node;
        }else{
            var node = tabelas[indice];
            encadeamento(node, chave);
            colisao += 1;
//            System.out.println("Break");
        }

    }

    public void encadeamento(NodeTabela node, int chave){
        node.getLista().insertLast(chave);
    }

    public int h(int chave){
        return chave % tabelas.length;
    }

    public void populaTabela(){
        var node = new NodeTabela(-1);

        Arrays.fill(tabelas, node);
    }

    public void populaTabelaDois(){

        for (int i = 0; i < 100000; i++){
//            var node = new NodeTabela(i);
            insere(i);

        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tabelas.length; i++){
            str.append(i);
            if(tabelas[i] == null){
                str.append("\n");
                continue;
            }
            str.append("    ");
            str.append(tabelas[i].getInfo());
            str.append("    ");
            str.append(tabelas[i].getLista());
            str.append("\n");

        }

        return str.toString();
    }

    public boolean busca(int chave){
        var indice = h(chave);

        if(tabelas[indice] == null){
            return false;
        }
        var listaEncadeadas = tabelas[indice].getLista();
        if(tabelas[indice].getInfo() == chave){
            return true;
        }else return buscaRecursiva(listaEncadeadas.getLista(), chave);
    }

    public boolean buscaRecursiva(Node<Integer> node, int chave){
        if(node.getInformacao() == chave){
            return true;
        }else{
            return buscaRecursiva(node.getProximo(), chave);
        }
    }


    public static void main(String[] args) {
        TabelaHash tabelas = new TabelaHash(10);
        tabelas.insere(155);
        tabelas.insere(255);
//        tabelas.insere(36555);
//        tabelas.populaTabelaDois();

//        System.out.println(tabelas.tabelas[5].getLista());

        System.out.println(tabelas);
        System.out.println(tabelas.busca(255));



    }
}
