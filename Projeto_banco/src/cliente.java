import java.util.ArrayList;
import java.util.Random;

public class cliente extends banco{
	
	private static ArrayList<cliente> lista_clientes = new ArrayList<>();

	cliente(String nome, int nif, int id, String codigo_conta){
		super.id_cliente = id;
		super.nomeCliente = nome;
		super.nif = nif;
		super.codigo_conta = codigo_conta;
		super.saldo = 0.0;
	}	



	public static boolean encontrarNif(int nif){
		boolean result = false;
		for (cliente c : listClientes()) {

			if (c.nif == nif) {
			  result = true;
			}
		}
		return result;
	}

	public static boolean encontrarConta(String codigo){
		boolean result = false;
		for (cliente c : listClientes()) {

			if (c.codigo_conta.equals(codigo)) {
			  result = true;
			}
		}
		return result;
	}

    public static void adicionarCliente(cliente c) {
        lista_clientes.add(c);
    }

    public static void removerCliente(cliente c) {
        lista_clientes.remove(c);
    }

	public static ArrayList<cliente> listClientes(){	

		return lista_clientes;
	}

	public static String newDeposito(cliente c, double quantia){
		c.saldo += quantia;
		return "Deposito efetuado com sucesso ";
	}

	public static String newLevantamento(cliente c, double quantia){
		c.saldo -= quantia;
		return "Levantamento efetuado com sucesso ";
	}

	public static String newTransferencia(cliente c, double quantia, String conta_destino){

		for (cliente c2 : cliente.listClientes()) {

			if (c2.codigo_conta.equals(conta_destino)) {
				c.saldo -= quantia;
			  	c2.saldo += quantia;
			}
		}

		return "Transferencia para a conta "+ conta_destino +" efetuado com sucesso ";
	}

	public static String newConta() {
        // Caracteres válidos para letras
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Números válidos
        String numeros = "0123456789";

        // Inicializa um objeto Random
        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        // Gera 3 letras aleatórias
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(letras.length());
            sb.append(letras.charAt(index));
        }

        // Gera 3 números aleatórios
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(numeros.length());
            sb.append(numeros.charAt(index));
        }

        return sb.toString();
    }

	public cliente() {
		
	}
	
}
