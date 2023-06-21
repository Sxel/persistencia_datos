import java.util.Scanner;

public class Home {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("--------");
            System.out.println(" app message");
            System.out.println(" 1. create message");
            System.out.println(" 2. list message");
            System.out.println(" 3. delete message");
            System.out.println(" 4. edit message");
            System.out.println(" 5. exit message");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        messageService.createMessage();
                        break;
                    case 2:
                        messageService.listMessage();
                        break;
                    case 3:
                        messageService.deleteMessage();
                        break;
                    case 4:
                        messageService.editMessage(scanner);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingresa un número válido.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número válido.");
                option = 0; // Reiniciar la opción para continuar el bucle
            }
        } while (option != 5);

        scanner.close(); // Cerrar el objeto Scanner al finalizar el programa
    }
}
