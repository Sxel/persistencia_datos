import java.sql.Connection;
import java.util.Scanner;

public class Home {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do{
            System.out.println("--------");
                System.out.println(" app message");
                    System.out.println(" 1. create message");
                    System.out.println(" 2. list message");
                    System.out.println(" 3. delete message");
                    System.out.println(" 4. edit message");
                    System.out.println(" 5. exit message");

                    option= sc.nextInt();

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
                            messageService.editMessage();
                            break;
                        case 5:
                            break;
                    }
        } while (option != 5 );


    }
}
