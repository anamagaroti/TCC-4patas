package TratamentoErros;

import javax.swing.JOptionPane;

public class Erros {
    
    public void erroAdocao(){
        JOptionPane.showMessageDialog(null, 
                         "Esse pet esta em análise", 
                         "Erro ao adotar", JOptionPane.ERROR_MESSAGE);
    }
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
