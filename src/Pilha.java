public class Pilha<E> {
    private int topo;
    public E[] dados;
    private int MAX;

    public Pilha(int MAX) {
        this.MAX = MAX;
        this.topo = -1;
        this.dados = (E[]) new Object[MAX];
    }

    public E getTop() {

        return isEmpty() ? null : dados[topo];
    }

    public void stackUp(E dado) {
        topo += 1;
        dados[topo] = dado;

    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == MAX -1;
    }

    public void unstack() {
        dados[topo] = null;
        topo -= 1;
    }

    @Override
    public String toString() {
        String str = "Pilha Object:\n[\n";
        for (int i = MAX -1; i > -1; i--) {
            try {
                str = str.concat("  " + dados[i].toString() + "\n");

            } catch (Exception e) {
                str = str.concat("  " + "null" + "\n");
            }

        }
        return str + "]";
    }

    public static void main(String[] args) {
        Pilha<String> dois = new Pilha<String>(10);

        dois.stackUp("j");
        dois.unstack();
        System.out.println(dois);
        System.out.println(dois.isFull());
        System.out.println(dois.isEmpty());


    }

}
