import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select = -1;
        int valor = 0;
// Este es un comentario de una línea
        try {
            do {
                System.out.println("Bienvenidos al conversor de Monedas");
                System.out.println("------------------------------------");
                System.out.println("--------------Menu------------------");
                System.out.println("Elige opción:\n" +
                        "1.- Dólar => Peso Argentino\n" +
                        "2.- Peso Argentino  => Dólar \n" +
                        "3.- Dólar => Real Brasileño\n" +
                        "4.- Real Brasileño  => Dólar \n" +
                        "5.- Dólar => Peso Colombiano\n" +
                        "6.- Peso Colombiano => Dólar\n" +
                        "0.- Salir");

                System.out.println("¿Qué opción desea?");
                select = Integer.parseInt(scanner.nextLine());

                switch (select) {
                    case 1:
                        System.out.println("Qué cantidad desea convertir:");
                        valor = Integer.parseInt(scanner.nextLine());
                        CurrencyConverter.convert(select, valor);
                        break;
                    case 2:
                        System.out.println("Qué cantidad desea convertir:");
                        valor = Integer.parseInt(scanner.nextLine());
                        CurrencyConverter.convert(select, valor);
                        break;
                    case 3:
                        System.out.println("Qué cantidad desea convertir:");
                        valor = Integer.parseInt(scanner.nextLine());
                        CurrencyConverter.convert(select, valor);
                        break;
                    case 4:
                        System.out.println("Qué cantidad desea convertir:");
                        valor = Integer.parseInt(scanner.nextLine());
                        CurrencyConverter.convert(select, valor);
                        break;
                    case 5:
                        System.out.println("Qué cantidad desea convertir:");
                        valor = Integer.parseInt(scanner.nextLine());
                        CurrencyConverter.convert(select, valor);
                        break;
                    case 6:
                        System.out.println("Qué cantidad desea convertir:");
                        valor = Integer.parseInt(scanner.nextLine());
                        CurrencyConverter.convert(select, valor);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa conversor de divisas...");
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtalo de nuevo.");
                        break;
                }
            } while (select != 0);
        } catch (Exception e) {
            System.out.println("¡Oops! Ha ocurrido un error.");
        }
    }
}
