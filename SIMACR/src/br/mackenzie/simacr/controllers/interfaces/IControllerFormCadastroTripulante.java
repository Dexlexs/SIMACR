package br.mackenzie.simacr.controllers.interfaces;

public interface IControllerFormCadastroTripulante {
    
    public void cancelar();

    public void salvar(String varNome, String varNascimento, String varNaturalidade, String varTelefone, String varProfissao, String varSexo,String varLogin,String varSenha);
    
    public void excluir();
}
