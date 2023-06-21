import com.mysql.cj.Messages;

import java.util.Scanner;

public class messageService {

    public static void createMessage(){

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
    public static void listMessage(){

        MessageDAO.readMessage();
    }

    public static void deleteMessage(){

        Scanner sc = new Scanner(System.in);
        System.out.println("indica el id del mensaje a borrar");
        int id_message= sc.nextInt();
        MessageDAO.deleteMessage(id_message);

    }

    public static void editMessage(){

    }
}
