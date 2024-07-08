public class banco {

	//Características do Banco
	private static String nomeBanco = "Banco Penedo";
	
	private static double saldo_cofre = 0;

	private static int max_clientes = 20;

	private static int num_clientes = 0;
	
	
	//Características dos Clientes
	int id_cliente = 1;
	
	String nomeCliente;
	int nif;
    
	String codigo_conta;
	double saldo;
	
	
	public banco() {
		
	}

	public static int nextID(){
		return num_clientes + 1;
	}

	public void update_cofre(double valor) {
		
		saldo_cofre += valor;
	}
	
	public static void entrada_cliente() {
		
		num_clientes += 1;
	}

	public static void saida_cliente() {
		
		num_clientes -= 1;
	}
	
	public static String getNome() {
		return nomeBanco;
	}

	public static double getSaldo_cofre() {
		return saldo_cofre;
	}

	public static int getMax_clientes() {
		return max_clientes;
	}

	public static int getNum_clientes() {
		return num_clientes;
	}
}
