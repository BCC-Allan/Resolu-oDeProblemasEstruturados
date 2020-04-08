public class Expressao {

    public Pilha<String> charactes;
    public String exp;

    public Expressao(String exp) {
        this.exp = exp;
        charactes = new Pilha<String>(exp.length());
    }
    // getter
    public Pilha<String> getCharactes() {
        return charactes;
    }

    public boolean isValid() {
        for (char cara: exp.toCharArray()) { //para cada caracter da expressão
            String strChar = Character.toString(cara); //char to string

            if (isOpenChar(strChar)) { //se for um caracter de abertura
                empilha(strChar);
            } else if (isCloseChar(strChar)) { // se for um caracter de fechamento
                desempilha(strChar);
            }
        }
        System.out.println(charactes);
        return charactes.isEmpty();
    }

    // verifica se o caracter é de abertura "{[("
    private boolean isOpenChar(String baseStr) {
        String pattern = "\\(|\\{|\\[";
        return baseStr.matches(pattern);
    }

    // verifica se o caracter é de fechamento "}])"
    private boolean isCloseChar(String baseStr) {
        String pattern = "\\)|\\}|\\]";
        return baseStr.matches(pattern);
    }

    // retorna o caracter e fechamento de um caracter de abertura
    private String closePartener(String character){
        String closePair;
        if (character == null){
            return null;
        }
        switch (character){
            case "{":
                closePair = "}";break;
            case "(":
                closePair = ")";break;
            case "[":
                closePair = "]";break;

            default:
                throw new IllegalStateException("Unexpected value: " + character);
        }
        return closePair;

    }

    private void empilha(String strChar){
        charactes.stackUp(strChar);

    }

    private void desempilha(String strChar) {
        if (strChar.equals(closePartener(charactes.getTop()))) { //compara o caracter ao topo da pilha
            charactes.unstack();
        }

    }

    public static void main(String[] args) {
        Expressao expressao = new Expressao("(((1+2) -3 )* 6) ");
        System.out.println(expressao.isValid());
    }
}
