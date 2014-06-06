import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsereDados {

	public static void main(String args[]){
		
		String stringDeConexao = "jdbc:mysql://localhost:3306/editora";
		String usuario = "root";
		String senha = "1234";
		
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			
			System.out.println("Abrindo conexão..." );
			
			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
			
			System.out.println("Digite o nome da editora:");
			
			String id = "2";
			
			String nome = entrada.nextLine();
			
			System.out.println("Digite o email da editora:");
			
			String email = entrada.nextLine();
			
			String textoComando = " INSERT INTO EDITORA (id_editora, nome, email) "+
									"VALUES(?,?,?)";
			
			PreparedStatement comando = conexao.prepareStatement(textoComando);
			
			comando.setString(1, id);
			comando.setString(2, nome);
			comando.setString(3, email);
			
			System.out.println("executando comando..");
			
			comando.execute();
			
			System.out.println("Fechando conexão");
			
			comando.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
