import java.util.Scanner;

public class MainRefatorado {
    public static void main(String[] args) {
        //versão refatorada
        Scanner scanner = new Scanner(System.in);

        int option;

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Converter Real (BRL) para Dólar (USD)");
            System.out.println("2. Converter Dólar (USD) para Real (BRL)");
            System.out.println("3. Converter Real (BRL) para Euro (EUR)");
            System.out.println("4. Converter Euro (EUR) para Real (BRL)");
            System.out.println("5. Converter Dólar (USD) para Euro (EUR)");
            System.out.println("6. Converter Euro (EUR) para Dólar (USD)");
            System.out.println("7. Sair");

            option = scanner.nextInt();

            if (option == 7) {
                System.out.println("Programa encerrado.");
                break;
            }

            switch (option) {
                case 1:
                    convertCurrency("BRL", "USD", "BRL -> USD", "Digite um valor em BRL: ", scanner);
                    break;
                case 2:
                    convertCurrency("USD", "BRL", "USD -> BRL", "Digite um valor em USD: ", scanner);
                    break;
                case 3:
                    convertCurrency("BRL", "EUR", "BRL -> EUR", "Digite um valor em BRL: ", scanner);
                    break;
                case 4:
                    convertCurrency("EUR", "BRL", "EUR -> BRL", "Digite um valor em EUR: ", scanner);
                    break;
                case 5:
                    convertCurrency("USD", "EUR", "USD -> EUR", "Digite um valor em USD: ", scanner);
                    break;
                case 6:
                    convertCurrency("EUR", "USD", "EUR -> USD", "Digite um valor em EUR: ", scanner);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void convertCurrency(String fromCurrency, String toCurrency, String conversionDesc,
                                        String inputPrompt, Scanner scanner) {
        double conversionRate = Conversor.getConversionRate(fromCurrency, toCurrency);
        System.out.println("-------------------------------------------");
        System.out.println("Opção selecionada: Converter " + conversionDesc);
        System.out.print(inputPrompt);
        double value = scanner.nextDouble();
        System.out.printf("Valor convertido %s : %.2f (%s)\n", conversionDesc, value * conversionRate, toCurrency);
        System.out.println("-------------------------------------------");
    }
}
