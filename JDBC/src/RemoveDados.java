import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class RemoveDados {

	public static void main (String args[]){
		
		try {
			System.out.println("Criando conexão..");
			Connection conexao = ConnectionFactory.criaConexao();
			
			System.out.println("Digite o id da editora que deseja excluir:\n");
			Scanner entrada = new Scanner(System.in);
			
			String id = entrada.nextLine();
			
			String sql = "DELETE FROM editora WHERE id_editora=?";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, id);
			
			System.out.println("executando comando..");
			comando.execute();
			
			System.out.println("Fechando conexão..");
			
			ListaDados.main(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
