import com.mysql.cj.Messages;

import java.util.Scanner;

public class messageService {

    public static void createMessage() {

        Scanner sc = new Scanner(System.in);
        System.out.println("escribe tu mensaje");
        String message = sc.nextLine();

        System.out.println("tu nombre");
        String nombre = sc.nextLine();

        Message registro = new Message();
        registro.setMessage(message);
        registro.setAuthor_message(nombre);
        MessageDAO.createMessageDB(registro);


    }

    public static void listMessage() {

        MessageDAO.readMessage();
    }

    public static void deleteMessage() {

        Scanner sc = new Scanner(System.in);
        System.out.println("indica el id del mensaje a borrar");
        int id_message = sc.nextInt();
        MessageDAO.deleteMessage(id_message);

    }

    public static void editMessage(Scanner sc) {
        System.out.println("Indica el id del mensaje");
        int id_message;
        if (sc.hasNextInt()) {
            id_message = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea pendiente
            System.out.println("Escribe nuevo mensaje");
            String newMessage = sc.nextLine();

            Message updatedMessage = new Message();
            updatedMessage.setMessage(newMessage);

            MessageDAO.refreshMessageDB(updatedMessage, id_message);
        } else {
            System.out.println("El formato del id del mensaje es incorrecto. Por favor, ingresa un número válido.");
        }
    }




}
