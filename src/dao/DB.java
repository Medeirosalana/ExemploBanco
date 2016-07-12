package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public Connection conexao = null;
    final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String BANCO = URL + "db_teste";
    private final String USUARIO = "root";
    private final String SENHA = "senac";
    public boolean getConexao(){
        try{
            Class.forName (DRIVER);
            conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            return true;
        }catch(ClassNotFoundException erro){
            System.out.println("Driver não encontrado!");
            return false;
        }catch(SQLException erro){
            System.out.println("Falha ao conhecter!");
        return false;
        }
    }
    public void fechar(){
    try{
        conexao.close();
        System.out.println("desconectou!");
    }catch(SQLException erro){
        System.out.println("falha ao conectar!");
        }
    }
}

