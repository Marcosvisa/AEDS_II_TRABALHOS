import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class arquivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String nomeArquivo = "dados.bin";

        try (RandomAccessFile arquivo = new RandomAccessFile(nomeArquivo, "rw")) {
            for (int i = 0; i < n; i++) {
                double valor = sc.nextDouble();
                arquivo.writeDouble(valor);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        try (RandomAccessFile arquivo = new RandomAccessFile(nomeArquivo, "r")) {
            long tamanhoArquivo = arquivo.length();
            for (long posicao = tamanhoArquivo - 8; posicao >= 0; posicao -= 8) {
                arquivo.seek(posicao);
                double valor = arquivo.readDouble();
                System.out.println(valor);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        sc.close();
    }
}