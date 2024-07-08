import java.util.Scanner;

public class func {
    // public static Scanner scanner = new Scanner(System.in);

    public static String pedirNome(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserir Nome -> ");

        String nome = scanner.nextLine();
        
        return nome;
    }

    public static int pedirNif(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserir Nif -> ");
        
        if (scanner.hasNextInt()) {
            int nif = scanner.nextInt();
            return nif;
        } else {
            System.out.print("Nif Invalido");
            return 0;
        }
    }       



}
