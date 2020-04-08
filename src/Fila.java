public class Fila<E> {
    public int primeiro, ultimo;
    private E[] dados;
    public int MAX;

    public Fila(int MAX) {
        this.MAX = MAX;
        this.dados = (E[]) new Object[MAX];
        this.primeiro = 0;
        this.ultimo = -1;
    }

    public void insert(E elemento) {
        ultimo += 1;
        if (ultimo == MAX){
            ultimo -= MAX;
        }
        if (cheia()) {
            throw new Error("Fila cheia");
        }
        dados[ultimo] = elemento;
    }

    public void remove() {
        if (vazia()) {
            throw new Error("Fila vazia");
        }
        dados[primeiro] = null;
        primeiro +=1;
        if (primeiro == MAX) {
            primeiro -= MAX;
        }
    }

    public E get() {
        return dados[primeiro];
    }

    public boolean cheia() {
        return dados[ultimo] != null;
    }

    public boolean vazia() {
        return dados[primeiro] == null;
    }

    public String toString() {
        String str = "Fila Object:\n[";
        for (int i = 0; i < MAX; i++) {
            try {
                str = str.concat("  " + dados[i].toString() + ",");

            } catch (Exception e) {
                str = str.concat("  " + "null" + ",");
            }
        }
        return str + "]";
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<Integer>(10);

        for (int i = 0; i < 10; i++) {
            fila.insert(0);
        }
        System.out.println(fila);
        System.out.println(fila.vazia());
        System.out.println(fila.cheia());
    }
}
