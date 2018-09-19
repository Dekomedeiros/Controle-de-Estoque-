package almoxarifado;

public class Produto implements Comparable<Produto> {
//Classe base dos produtos do almoxarifado.

    static int id = 1;  //ID apenas para distinguir diferentes produtos, sendo único para cada.

    private int produtoID;
    private String nome;
    private double valorUnitario;
    private int quantidade;
    private int quantidadeSolicitacao;

    protected Produto(String nome, double valorUnitario, int quantidade) {
        this.produtoID = id;    //Ao contruir atribuí um ID e já implementa para o próximo.
        id++;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected double getValorUnitario() {
        return valorUnitario;
    }

    protected void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    protected int getQuantidade() {
        return quantidade;
    }

    protected void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    protected int getProdutoID() {
        return produtoID;
    }

    protected void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    protected int getQuantidadeSolicitacao() {
        return quantidadeSolicitacao;
    }

    protected void setQuantidadeSolicitacao(int quantidadeSolicitacao) {
        this.quantidadeSolicitacao = quantidadeSolicitacao;
    }

    protected String toString(boolean emUmaSolicitacao) {   
    /*Verifica se o produto utilizará a quantidade em Estoque ou a quantidade Solicitada.
        Nota: Esta implementação seria mais correta se separada em uma classe (Produto Solicitado) mas acabou ficando assim por faha no planejamento 
        (já tínhamos começado quando notamos isso e seria um enorme re-trabalho implementar do outro modo, deixaremos para ajeitar futuramente).*/
        
        if (emUmaSolicitacao == false) {
            return "Cod: "+ produtoID + " - " + nome + "   Valor Unitario:  " + valorUnitario + "  Quantidade em Estoque: " + quantidade + '\n';

        } else if (emUmaSolicitacao == true) {
            return "Cod: "+ produtoID + " - " + nome + "   Valor Unitario:  " + valorUnitario + "  Quantidade Solicitada: " + quantidadeSolicitacao + '\n';
        }
        return " ";
    }

    @Override
    public int compareTo(Produto produto) { //Método proveniente da interface Comparable<Produto>. Utilizado para ordernar(sort) a lista de Produtos.

        return this.getNome().compareToIgnoreCase(produto.getNome());
    }
}
