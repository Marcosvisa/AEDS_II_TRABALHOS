import java.util.Scanner;

public class algebraBooleana {

    public static int processar(String entrada) {
        String[] partes = entrada.split(" ", 3);
        int n = Integer.parseInt(partes[0]);
        
        // Coletar os valores binários
        boolean[] valores = new boolean[n];
        for (int i = 0; i < n; i++) {
            valores[i] = partes[i + 1].equals("1");
        }

        // Expressão booleana
        String expressao = partes[2];

        // Substituir A, B, C, ... pelos valores correspondentes
        char var = 'A';
        for (boolean valor : valores) {
            expressao = expressao.replace("" + var, valor ? "true" : "false");
            var++;
        }

        // Avaliar a expressão
        return avaliar(expressao) ? 1 : 0;
    }

    private static boolean avaliar(String expressao) {
        expressao = expressao.replace("and", "&&").replace("or", "||").replace("not", "!");

        try {
            return (boolean) javax.script.ScriptEngineManager.class
                .getDeclaredConstructor().newInstance()
                .getEngineByName("JavaScript")
                .eval(expressao);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String palavra;
        Scanner sc = new Scanner(System.in);

        palavra = sc.nextLine();

        while (!(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M')) {
            System.out.println(processar(palavra));
            palavra = sc.nextLine();
        }

        sc.close();
    }
}