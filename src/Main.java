import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;

        while (true) {
            System.out.println("Conversor de moedas");
            System.out.println("*******************");
            System.out.println("1. Converter Real (BRL) para Dólar (USD)");
            System.out.println("2. Converter Dólar (USD) para Real (BRL)");
            System.out.println("3. Converter Real (BRL) para Euro (EUR)");
            System.out.println("4. Converter Euro (EUR) para Real (BRL)");
            System.out.println("5. Converter Dólar (USD) para Euro (EUR)");
            System.out.println("6. Converter Euro (EUR) para Dólar (USD)");
            System.out.println("7. Sair");
            System.out.println("*******************");
            System.out.print("Selecione uma opção:");
            option = scanner.nextInt();

            if (option == 7) {
                System.out.println("Programa encerrado.");
                break;
            }

            switch (option) {

                case 1:
                    System.out.println("-------------------------------------------");
                    System.out.println("Opção 1 selecionada: Converter Real (BRL) para Dólar (USD)");
                    double usdRate = Conversor.getConversionRate("BRL", "USD");
                    System.out.print("Digite um valor em BRL: ");
                    double valorBRL = scanner.nextDouble();
                    System.out.printf("Valor convertido BRL -> USD : $%.2f (USD)\n", valorBRL * usdRate);
                    System.out.println("-------------------------------------------");
                    break;
                case 2:
                    System.out.println("-------------------------------------------");
                    System.out.println("Opção 2 selecionada: Converter Dólar (USD) para Real (BRL)");
                    double brlRate = Conversor.getConversionRate("USD", "BRL");
                    System.out.print("Digite um valor em USD: ");
                    double valorUSD = scanner.nextDouble();
                    System.out.printf("Valor convertido USD -> BRL : R$%.2f (BRL)\n", valorUSD * brlRate);
                    System.out.println("-------------------------------------------");
                    break;
                case 3:
                    // Implement case 3: Convert BRL to EUR
                    System.out.println("-------------------------------------------");
                    System.out.println("Opção 3 selecionada: Converter Real (BRL) para Euro (EUR)");
                    double eurRateFromBRL = Conversor.getConversionRate("BRL", "EUR");
                    System.out.print("Digite um valor em BRL: ");
                    double valorBRLtoEUR = scanner.nextDouble();
                    System.out.printf("Valor convertido BRL -> EUR : €%.2f (EUR)\n", valorBRLtoEUR * eurRateFromBRL);
                    System.out.println("-------------------------------------------");
                    break;
                case 4:
                    // Implement case 4: Convert EUR to BRL
                    System.out.println("-------------------------------------------");
                    System.out.println("Opção 4 selecionada: Converter Euro (EUR) para Real (BRL)");
                    double brlRateFromEUR = Conversor.getConversionRate("EUR", "BRL");
                    System.out.print("Digite um valor em EUR: ");
                    double valorEURtoBRL = scanner.nextDouble();
                    System.out.printf("Valor convertido EUR -> BRL : R$%.2f (BRL)\n", valorEURtoBRL * brlRateFromEUR);
                    System.out.println("-------------------------------------------");
                    break;
                case 5:
                    // Implement case 5: Convert USD to EUR
                    System.out.println("-------------------------------------------");
                    System.out.println("Opção 5 selecionada: Converter Dólar (USD) para Euro (EUR)");
                    double eurRateFromUSD = Conversor.getConversionRate("USD", "EUR");
                    System.out.print("Digite um valor em USD: ");
                    double valorUSDtoEUR = scanner.nextDouble();
                    System.out.printf("Valor convertido USD -> EUR : €%.2f (EUR)\n", valorUSDtoEUR * eurRateFromUSD);
                    System.out.println("-------------------------------------------");
                    break;
                case 6:
                    // Implement case 6: Convert EUR to USD
                    System.out.println("-------------------------------------------");
                    System.out.println("Opção 6 selecionada: Converter Euro (EUR) para Dólar (USD)");
                    double usdRateFromEUR = Conversor.getConversionRate("EUR", "USD");
                    System.out.print("Digite um valor em EUR: ");
                    double valorEURtoUSD = scanner.nextDouble();
                    System.out.printf("Valor convertido EUR -> USD : $%.2f (USD)\n", valorEURtoUSD * usdRateFromEUR);
                    System.out.println("-------------------------------------------");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
