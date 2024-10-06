package assn07;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

        // your code below
        // infinite loop to go back to "Enter master password"
        while (true){
            System.out.println("Enter Master Password");
            String password = scanner.nextLine();
            if (passwordManager.checkMasterPassword(password)){
                break;
            }
        }
        while (true){
            String userCommand1;
            String userCommand2;
            userCommand1 = scanner.nextLine();
            if (userCommand1.equals("Exit")){
                break;
            }
            switch (userCommand1){
                case ("New password"):
                    userCommand1 = scanner.nextLine();
                    userCommand2 = scanner.nextLine();
                    passwordManager.put(userCommand1, userCommand2);
                    System.out.println("New password added");
                    break;
                case ("Get password"):
                    userCommand1 = scanner.nextLine();
                    String password = passwordManager.get(userCommand1);
                    if (password == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(password);
                    }
                    break;
                case ("Delete account"):
                    userCommand1 = scanner.nextLine();
                    String d = passwordManager.remove(userCommand1);
                    if (d == null){
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println("Account deleted");
                    }
                    break;
                case ("Check duplicate password"):
                    userCommand1 = scanner.nextLine();
                    List<String> e = passwordManager.checkDuplicate(userCommand1);
                    if (e.isEmpty()){
                        System.out.println("No account uses that password");
                    } else {
                        System.out.println("Websites using that password:");
                        for (int i = 0; i < e.size(); i++){
                            System.out.println(e.get(i));
                        }
                    }
                    break;
                case ("Get accounts"):
                    Set<String> accounts = passwordManager.keySet();
                    System.out.println("Your accounts:");
                    for (String element : accounts) {
                        System.out.println(element);
                    }
                    break;
                case ("Generate random password"):
                    int length = Integer.parseInt(scanner.nextLine());
                    System.out.println(passwordManager.generatesafeRandomPassword(length));
                    break;
                default:
                    System.out.println("Command not found");
                    break;
            }
        }
    }
}
