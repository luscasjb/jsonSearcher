import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        CepSearch cepSearch = new CepSearch();

        System.out.println("Digite o CEP a ser consultado: ");
        var cep = reader.nextLine();

        try {
            Address newAddress = cepSearch.searchAddress("99010000");
            System.out.println(newAddress);
            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.saveJson(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Consulta finalizada!");
        }
    }
}