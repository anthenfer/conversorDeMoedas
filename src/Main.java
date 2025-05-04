import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor converter = new Conversor();

        Map<Integer, String> moedas = new HashMap<>();
        Map<String, String> nomes = new HashMap<>();

        moedas.put(1, "USD"); nomes.put("USD", "Dólar americano");
        moedas.put(2, "BRL"); nomes.put("BRL", "Real brasileiro");
        moedas.put(3, "EUR"); nomes.put("EUR", "Euro");
        moedas.put(4, "GBP"); nomes.put("GBP", "Libra esterlina");
        moedas.put(5, "JPY"); nomes.put("JPY", "Iene japonês");
        moedas.put(6, "AUD"); nomes.put("AUD", "Dólar australiano");
        moedas.put(7, "CAD"); nomes.put("CAD", "Dólar canadense");
        moedas.put(8, "CHF"); nomes.put("CHF", "Franco suíço");
        moedas.put(9, "CNY"); nomes.put("CNY", "Yuan chinês");
        moedas.put(10, "INR"); nomes.put("INR", "Rupia indiana");

        while (true) {
            System.out.println("\n=== CONVERSOR DE MOEDAS ===");
            System.out.println("Escolha a opção desejada (1 a 9) para selecionar  moeda de origem:");

            for (Map.Entry<Integer, String> entry : moedas.entrySet()) {
                String codigo = entry.getValue();
                System.out.printf("%d - %s (%s)\n", entry.getKey(), codigo, nomes.get(codigo));
            }
            System.out.println("0 - Sair");

            System.out.print("Escolha a moeda de origem: ");
            int opcaoOrigem = Integer.parseInt(scanner.nextLine());
            if (opcaoOrigem == 0) break;

            String moedaOrigem = moedas.get(opcaoOrigem);
            if (moedaOrigem == null) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            System.out.println("Você escolheu: " + nomes.get(moedaOrigem));

            System.out.println("\nEscolha a opção desejada (1 a 9) para selecionar  moeda de destino:");
            for (Map.Entry<Integer, String> entry : moedas.entrySet()) {
                String codigo = entry.getValue();
                System.out.printf("%d - %s (%s)\n", entry.getKey(), codigo, nomes.get(codigo));
            }
            System.out.println("0 - Sair");

            System.out.print("Você escolhe a moeda de destino:");
            int opcaoDestino = Integer.parseInt(scanner.nextLine());
            if (opcaoDestino == 0) break;

            String moedaDestino = moedas.get(opcaoDestino);
            if (moedaDestino == null) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            System.out.println("Você escolheu: " + nomes.get(moedaDestino));

            System.out.print("Digite o valor a ser convertido: ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Tente novamente.");
                continue;
            }

            double taxa = converter.convert(moedaOrigem, moedaDestino);

            if (taxa > 0) {
                double resultado = valor * taxa;
                System.out.printf("Taxa de câmbio %s -> %s: %.4f\n", moedaOrigem, moedaDestino, taxa);
                System.out.printf("Valor convertido: %.2f %s\n", resultado, moedaDestino);
            } else {
                System.out.println("Erro ao buscar taxa de câmbio.");
            }
        }

        System.out.println("Programa encerrado.");
    }
}
