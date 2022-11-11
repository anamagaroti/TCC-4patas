package TratamentoErros;

import javax.swing.JOptionPane;

public class Erros {
    
    public void confirmarSenha(){
        JOptionPane.showMessageDialog(null, 
                         "Senha e confirmar senha estão diferentes", 
                         "Erro ao cadastrar cliente", JOptionPane.ERROR_MESSAGE);
    }
    
    public void validaEmail(){
        JOptionPane.showMessageDialog(null, 
                         "Email já cadastrado, faça login na rede ou se esqueceu a senha, clique em recuperar senha", 
                         "Erro ao cadastrar cliente", JOptionPane.ERROR_MESSAGE);
    }
}
