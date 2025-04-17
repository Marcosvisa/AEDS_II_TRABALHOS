
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class paginahtml {

    public static void processar(String end, String nome) {
     
        int consoantes = 0, table = 0, br = 0;
        int contarA = 0, contarE = 0, contarI = 0, contarO = 0, contarU = 0;
        int contarAacute = 0, contarEacute = 0, contarIacute = 0, contarOacute = 0, contarUacute = 0;
        int contarAgrave = 0, contarEgrave = 0, contarIgrave = 0, contarOgrave = 0, contarUgrave = 0;
        int contarAtilde = 0, contarOtilde = 0;
        int contarCircunflexo = 0, contarEcircunflexo = 0, contarIcircunflexo = 0, contarOcircunflexo = 0, contarUcircunflexo = 0;

        try {
            //conectar à URL e ler o conteúdo da página
            URL url = new URL(end);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder conteudo = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            reader.close();
            String texto = conteudo.toString();

            table = texto.split("<table", -1).length - 1;
            br = texto.split("<br", -1).length - 1;

          //percorrer e contar os caracteres 
            for (int x = 0; x < texto.length(); x++) {
                char letra = texto.charAt(x);
            
                if (Character.isLowerCase(letra)) {
            
                    //contagem de vogais e acentuadas
                    if (letra == 'a') contarA++;
                    else if (letra == 'e') contarE++;
                    else if (letra == 'i') contarI++;
                    else if (letra == 'o') contarO++;
                    else if (letra == 'u') contarU++;
                    else if (letra == '\u00E2') contarCircunflexo++;
                    else if (letra == '\u00E1') contarAacute++;
                    else if (letra == '\u00E9') contarEacute++; 
                    else if (letra == '\u00ED') contarIacute++; 
                    else if (letra == '\u00F3') contarOacute++; 
                    else if (letra == '\u00FA') contarUacute++; 
                    else if (letra == '\u00E0') contarAgrave++; 
                    else if (letra == '\u00E8') contarEgrave++;
                    else if (letra == '\u00EC') contarIgrave++;
                    else if (letra == '\u00F2') contarOgrave++;
                    else if (letra == '\u00F9') contarUgrave++;
                    else if (letra == '\u00E3') contarAtilde++;
                    else if (letra == '\u00F5') contarOtilde++; 
                    else if (letra == '\u00EA') contarEcircunflexo++;
                    else if (letra == '\u00EE') contarIcircunflexo++;
                    else if (letra == '\u00F4') contarOcircunflexo++;
                    else if (letra == '\u00FB') contarUcircunflexo++; 
            
                    //contar consoantes
                    else consoantes++;
                }
            }
            

            // Impressão do resultado
            System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í(%d) ó(%d) ú(%d) à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) consoante(%d) <br>(%d) <table>(%d) %s\n",
                    contarA, contarE, contarI, contarO, contarU,
                    contarAacute, contarEacute, contarIacute, contarOacute, contarUacute,
                    contarAgrave, contarEgrave, contarIgrave, contarOgrave, contarUgrave,
                    contarAtilde, contarOtilde, contarCircunflexo, contarEcircunflexo, contarIcircunflexo, contarOcircunflexo, contarUcircunflexo,
                    consoantes, br, table, nome);

        } catch (IOException e) {
            System.out.println("Erro ao acessar a URL: " + e.getMessage());
        }
    }

    public static void main(String args[]) {

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            System.setProperty("file.encoding", "UTF-8");
        } catch (Exception e) {
            System.err.println();
        }

        Scanner sc = new Scanner(System.in);
        String nome, endereco;

        nome = sc.nextLine();

        while (!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')) {
            endereco = sc.nextLine();
            processar(endereco, nome);
            nome = sc.nextLine();
        }

        sc.close();
    }
}
