import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ListaDados {
	public static void main(String args[]){
		
		String StringDeConexao = "jdbc:mysql://localhost:3306/editora";
		String usuario = "root";
		String senha = "1234";
		
		try {
			System.out.println("Criando conexão!");
			
			Connection conexao = DriverManager.getConnection(StringDeConexao, usuario, senha);
			
			String sql = " SELECT * FROM editora ";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			System.out.println("Executando comando...");
			
			ResultSet rs = comando.executeQuery();
			
			List<Editora> lsEditora = new ArrayList<>();
			
			while(rs.next()){
				Editora editora = new Editora(rs.getInt("id_editora"), rs.getString("nome"), rs.getString("email"));
				lsEditora.add(editora);
				
				System.out.printf("%d : %s - %s\n",
						rs.getInt("id_editora"),
						rs.getString("nome"),
						rs.getString("email"));
				
			}
			
			System.out.println("\nFechando conexão..");
			
			conexao.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
