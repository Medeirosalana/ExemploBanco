package exemplo;

import java.sql.*;
import java.util.Scanner;

public class BancosDados {
   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/";
        final String BANCO = URL + "db_teste";
        final String USUARIO = "root";
        final String SENHA = "senac";
        try{
            Class.forName (DRIVER);
            Connection conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
             Usuario usuario = new Usuario();
            System.out.println("Nome: ");
            usuario.setNome(sc.next());
        
            System.out.println("Idade: ");
            usuario.setIdade(sc.nextInt());
            
            String sql = "INSERT INTO tb_teste(tst_nome, tst_idade)VALUE(?, ?)";
            
            PreparedStatement startement = conexao.prepareStatement(sql);
            startement.setString(1, usuario.getNome());
            startement.setInt(2, usuario.getIdade());
            startement.execute();
            
        }catch(ClassNotFoundException erro){
            System.out.println(erro.toString());
        }catch(SQLException erro){
            System.out.println(erro);
        }
        
       
        
        
    }
    
}
