public class Merge {

    public static Fila<Integer> merge(Fila<Integer> filaA, Fila<Integer> filaB) { 
        int maiorTamanho = filaA.MAX + filaB.MAX;
        int min;

        Fila<Integer> filaOut = new Fila<>(maiorTamanho);

        for (int i = 0; i < maiorTamanho; i++) {
            Integer a = filaA.get();
            Integer b = filaB.get();

            if (!filaA.vazia()  && !filaB.vazia()) {

                if (a < b) {
                    min = a;
                    filaA.remove();
                } else {
                    min = b;
                    filaB.remove();
                }
                filaOut.insert(min);

            } else if (filaA.vazia()) {
                filaOut.insert(b);
                filaB.remove();

            } else if (filaB.vazia()) {
                filaOut.insert(a);
                filaA.remove();
            }

        }

        return filaOut;
    }

    public static void main(String[] args) {
        Fila<Integer> filaA = new Fila<>(3);
        Fila<Integer> filaB = new Fila<>(5);

        filaA.insert(1);
        filaA.insert(4);
        filaA.insert(7);

        filaB.insert(2);
        filaB.insert(8);
        filaB.insert(9);
        filaB.insert(10);
        filaB.insert(11);

        System.out.println(filaA);
        System.out.println(filaB);
        System.out.println(Merge.merge(filaA, filaB));

    }
}
