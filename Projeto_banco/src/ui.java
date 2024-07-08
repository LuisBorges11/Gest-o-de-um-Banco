import java.util.Scanner;

public class ui {

    public static void invalid_option() {

        System.out.print("Opção Inválida!!!!\n");
    }

    public static void Menu() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("==========================================\n" +
                    "=============== MENU =================\n" +
                    "(1) Menu Clientes\n" +
                    "(2) Menu Movimentos\n" +
                    "(3) Informação do Banco\n" +
                    "-------------------\n" +
                    "(9) Sair da aplicação\n" +
                    "==========================================\n" +
                    "Insira a sua opção -> ");
            String entrada = scanner.nextLine();

            switch (entrada) {

                case "1":
                    MenuClientes();
                    break;
                case "2":
                    MenuMovimentos();
                    break;
                case "3":
                    BancoInfo();
                    break;
                case "9":
                    System.exit(0);
                    break;
                default:
                    invalid_option();
                    Menu();
            }
        }
    }

    public static void MenuClientes() {

        System.out.print("\n\n");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("==========================================\n" +
                    "========== MENU CLIENTES =============\n" +
                    "(1) Inserir Cliente\n" +
                    "(2) Listar Clientes\n" +
                    "(3) Procurar Cliente\n" +
                    "(4) Apagar Cliente\n" +
                    "-------------------\n" +
                    "(9) Menu Principal\n" +
                    "==========================================\n" +
                    "Insira a sua opção -> ");
            String entrada = scanner.nextLine();

            String nome;
            int nif;

            switch (entrada) {

                case "1":
                    nome = func.pedirNome();
                    nif = func.pedirNif();
                    if (nif != 0) {
                        if (banco.getNum_clientes() < banco.getMax_clientes()) {
                            cliente.adicionarCliente(new cliente(nome, nif, banco.nextID(), cliente.newConta()));
                            banco.entrada_cliente();

                            for (cliente c : cliente.listClientes()) {

                                if (c.nif == nif) {
                                    System.out.println("===== Novo Cliente =====");
                                    System.out.println("Nome: " + c.nomeCliente);
                                    System.out.println("NIF: " + c.nif);
                                    System.out.println("Codigo de Conta: " + c.codigo_conta);
                                }
                            }
                        } else {
                            System.out.print("Sem vagas para novos clientes");
                        }
                    }
                    MenuClientes();
                    break;
                case "2":
                    for (cliente c : cliente.listClientes()) {
                        System.out.println("________________");
                        System.out.println("ID: " + c.id_cliente);
                        System.out.println("Nome: " + c.nomeCliente);
                        System.out.println("NIF: " + c.nif);
                    }
                    MenuClientes();
                    break;
                case "3":
                    nif = func.pedirNif();
                    if (nif != 0) {
                        for (cliente c : cliente.listClientes()) {

                            if (c.nif == nif) {
                                System.out.println("ID: " + c.id_cliente);
                                System.out.println("Nome: " + c.nomeCliente);
                                System.out.println("NIF: " + c.nif);
                                System.out.println("Codigo de Conta: " + c.codigo_conta);
                                System.out.println("Saldo: " + c.saldo);
                            }
                        }
                    }
                    MenuClientes();
                    break;
                case "4":
                    nif = func.pedirNif();

                    for (cliente c : cliente.listClientes()) {
                        if (c.nif == nif) {
                            cliente.removerCliente(c);
                            banco.saida_cliente();
                            System.out.println("Cliente removido com sucesso!");
                            break;
                        }
                    }
                    MenuClientes();
                    break;
                case "9":
                    Menu();
                    break;
                default:
                    invalid_option();
                    MenuClientes();
            }
        }
    }

    public static void MenuMovimentos() {

        System.out.print("\n\n");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("==========================================\n" +
                    "========== MENU MOVIMENTOS =============\n" +
                    "(1) Depositar Dinheiro\n" +
                    "(2) Levantar Dinheiro\n" +
                    "(3) Efetuar Transferência\n" +
                    "-------------------\n" +
                    "(9) Menu Principal\n" +
                    "==========================================\n" +
                    "Insira a sua opção -> ");
            String entrada = scanner.nextLine();

            int nif;

            switch (entrada) {

                case "1":
                    nif = func.pedirNif();
                    if (nif != 0) {
                        for (cliente c : cliente.listClientes()) {

                            if (c.nif == nif) {
                                System.out.println("Insira a quantia do deposito ->");
                                int quantia = scanner.nextInt();

                                cliente.newDeposito(c, quantia);
                            }
                        }
                    }
                    MenuMovimentos();
                    break;
                case "2":
                    nif = func.pedirNif();
                    if (nif != 0) {
                        for (cliente c : cliente.listClientes()) {

                            if (c.nif == nif) {
                                System.out.println("Insira a quantia do levantamento ->");
                                int quantia = scanner.nextInt();

                                cliente.newLevantamento(c, quantia);
                            }
                        }
                    }
                    MenuMovimentos();
                    break;
                case "3":
                    nif = func.pedirNif();
                    if (nif != 0) {
                        for (cliente c : cliente.listClientes()) {

                            if (c.nif == nif) {

                                System.out.print("Insira a conta destinataria ->");
                                String conta_destino = scanner.nextLine();

                                if (cliente.encontrarConta(conta_destino)) { //!NOVO

                                    System.out.println("Insira a quantia do levantamento ->");
                                    double quantia = scanner.nextInt();

                                    cliente.newTransferencia(c, quantia, conta_destino);
                                }
                                else{
                                    System.out.print("Código de conta Invalido");
                                }
                            }
                        }
                    }
                    MenuMovimentos();
                    break;
                case "9":
                    Menu();
                    break;
                default:
                    invalid_option();
                    MenuMovimentos();
            }
        }
    }

    public static void BancoInfo() {

        System.out.print("\n\n");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("==== " + banco.getNome() + " ====\n" +
                    "Clientes: " + banco.getNum_clientes() + "\n" +
                    "Valor em Cofre: " + banco.getSaldo_cofre() + "\n" +
                    "========================");
            Menu();
        } catch (Exception e) {
            invalid_option();
            Menu();
        }
    }

    public static void newCliente() {

    }

}
