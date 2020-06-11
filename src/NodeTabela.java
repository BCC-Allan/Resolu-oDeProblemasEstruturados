

public class NodeTabela {

    private ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
    private int info;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public ListaEncadeada<Integer> getLista() {
        return lista;
    }

    public void setLista(ListaEncadeada<Integer> lista) {
        this.lista = lista;
    }


    public NodeTabela(int info) {
        this.info = info;
    }

}
