package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    private Usuario usuario;
    private DB db;
    private PreparedStatement startment;
    private String sql;

    public UsuarioDAO() {
        usuario = new Usuario();
        db = new DB();
    }
    
    public void inserir(Usuario usuario){
        if(db.getConexao()){
    try{
        sql = "INSERT INTO tb_teste(tst_nome,tst_idade) VALUES(?, ?)";
    
    startment = db.conexao.prepareStatement(sql);
    startment.setString(1, usuario.getNome());
    startment.setInt(2, usuario.getIdade());
    startment.execute();
    startment.close();
    }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
    } finally{
        db.fechar();
    }
    }
    }
    public boolean excluir(Usuario usuario){
        if(db.getConexao()){
            String sql = "DELETE FROM tb_teste WHERE tst_id = ?";
            try{
                startment = db.conexao.prepareStatement(sql);
                startment.setInt(1, usuario.getId());
                if(startment.executeUpdate()== 1){
                return true;
                }
                
            }catch(SQLException erro){
                System.out.println("Falha na operação!");
                System.out.println("Erro: " + erro);
                return false;
            }
        } return false;
    
    }
    public List<Usuario> listarTudo(){
        if(db.getConexao()){
    List<Usuario> usuarios = new ArrayList();
    sql = "SELECT * FROM tb_teste";
    try{
    startment = db.conexao.prepareStatement(sql);
        ResultSet resultSet = startment.executeQuery();
        while(resultSet.next()){
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("tst_id"));
        usuario.setNome(resultSet.getString("tst_nome"));
        usuario.setIdade(resultSet.getInt("tst_idade"));
        usuarios.add(usuario);
        }
        
    }catch(SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
    
    }
        
    return usuarios;
        }
        return null;
    }
    public Usuario listarPorId(int id){
        Usuario usuario = new Usuario();
        sql = "SELECT * FROM tb_teste WHERE tst_id = ?";
        if(db.getConexao()){
        try{
            startment = db.conexao.prepareStatement(sql);
            startment.setInt(1, id);
            ResultSet resultSet = startment.executeQuery();
            while(resultSet.next()){
            usuario.setId(resultSet.getInt("tst_id"));
            usuario.setNome(resultSet.getString("tst_nome"));
            usuario.setIdade(resultSet.getInt("tst_idade"));
            }
        return usuario;
        
        }catch (SQLException erro){
        System.out.println("Falha na operação!");
        System.out.println("Erro: "+ erro);
        return null;
        }
        
        }
        return null;
    }
    public List<Usuario> listarPorNome(String nome){
        List<Usuario> usuarios = new ArrayList();
        
        sql = "SELECT * FROM tb_teste WHERE tst_nome LIKE ?";
        nome = "%"+ nome+ "%";
        if(db.getConexao()){
            
        try{
            startment = db.conexao.prepareStatement(sql);
            startment.setString(1, nome);
            ResultSet resultSet = startment.executeQuery();
            while(resultSet.next()){
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("tst_id"));
            usuario.setNome(resultSet.getString("tst_nome"));
            usuario.setIdade(resultSet.getInt("tst_idade"));
            usuarios.add(usuario);
            }
           resultSet.close();
           startment.close();
            return usuarios;
           }catch(SQLException erro){
            System.out.println("Falha na operação!");
            System.out.println("Erro: "+ erro);
            
        }finally{
        db.fechar();
        }
        }
        return null;
    
    
    }
    
    
}
