package gui;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;

public class Principal {
   

    public static void main(String[] args) {
   
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
//        usuario.setNome(JOptionPane.showInputDialog("Nome do Usuário"));
//        usuario.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade do Usuário")));
////        dao.inserir(usuario);
//    usuario.setId(Integer.parseInt(JOptionPane.showInputDialog("Id do usuario")));
//    if(dao.excluir(usuario)){
//    JOptionPane.showMessageDialog(null, "sucesso");
//    }else{
//    JOptionPane.showMessageDialog(null, "falha");
//    }
//    
        String texto = "";
        for(Usuario u : dao.listarTudo()){
        texto += u.getId() + " " + u.getNome() + " "  +u.getIdade() + " ";
        JOptionPane.showMessageDialog(null, texto);
        
        }
    }
    
}
