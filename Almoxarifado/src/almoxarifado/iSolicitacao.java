
package almoxarifado;


public interface iSolicitacao {
      
    void finalizaSolicitacao();
    
    void adicionaProduto(int index, int quantidade);
    
    void cancelaProduto(Produto produto);
    
    void calculaTotal();
}
