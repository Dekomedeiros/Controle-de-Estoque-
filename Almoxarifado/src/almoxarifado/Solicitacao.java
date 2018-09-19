package almoxarifado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

class Solicitacao implements Comparable<Solicitacao>, iSolicitacao {
//Classe base para as Solicitações do Almoxarifado.

    static int id = 1;

    private Produto produto;
    private int quantidade;
    private int numeroPedidos = 0;
    private int solicitacaoID = 0;
    private double valorTotal;
    private Departamento destino;
    private Date dataPedido;
    private Date dataEntrega;
    private List<Produto> produtos = new ArrayList();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void finalizaSolicitacao() {
        this.solicitacaoID = id;    //Mesmo sistema de ID do produto.
        id++;
    }

    @Override
    public void adicionaProduto(int index, int quantidade) { //Faz o controle e adiciona produtos na Solicitação.
        Produto produto = GerenciadorEstoque.estoque.get(index);
        if (produtos.contains(produto) == false) {
            if (produto != null && produto.getQuantidade() >= quantidade) {

                GerenciadorEstoque.baixaProduto(index, quantidade);

                produto.setQuantidadeSolicitacao(quantidade);

                produtos.add(produto);
                Collections.sort(produtos);

                numeroPedidos++;

                calculaTotal();

            } else {
                JOptionPane.showMessageDialog(null, "Estoque não possue tal quantidade.");
            }
        } else {
            int opcao = JOptionPane.showConfirmDialog(null, "Produto já solicitado, deseja substituir a quantidade?", "Atenção!", JOptionPane.NO_OPTION);
            if (opcao == 0) {
                cancelaProduto(produto);
                adicionaProduto(index, quantidade);

                calculaTotal();
            }
        }
    }

    @Override
    public void cancelaProduto(Produto produto) {    //Cancela Produto (Ao cancelar um produto a quantidade do mesmo é reposta no Estoque.)

        int reposicao = produtos.get(produtos.indexOf(produto)).getQuantidadeSolicitacao()
                + GerenciadorEstoque.estoque.get(GerenciadorEstoque.estoque.indexOf(produto)).getQuantidade();

        GerenciadorEstoque.repoeProduto(produto, reposicao);

        produtos.remove(produto);

        numeroPedidos--;
        calculaTotal();
    }

    @Override
    public void calculaTotal() {
        double total = 0;

        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                total = total + (produto.getValorUnitario() * produto.getQuantidadeSolicitacao());
            }
        }
        this.valorTotal = total;
    }

    protected String[] produtoArray() { //Passa a lista de produtos da Solicitação para um Array (Necessário para as Telas).
        String arrayProdutos[] = new String[produtos.size()];
        for (int i = 0; i < arrayProdutos.length; i++) {
            arrayProdutos[i] = produtos.get(i).toString(true);
        }
        return arrayProdutos;
    }

    protected String produtosString() { //Cria a lista de produtos utilizada para a consulta da Solicitação.
        String produtosString = "";
        for (Produto produto : produtos) {
            produtosString += "\n       " + produto.toString(true);
        }
        return produtosString;
    }

    protected int getSolicitacaoID() {
        return solicitacaoID;
    }

    protected double getValorTotal() {
        return valorTotal;
    }

    protected List<Produto> getProdutos() {
        return produtos;
    }

    protected int getNumeroPedidos() {
        return numeroPedidos;
    }

    protected void setNumeroPedidos(int numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    protected Departamento getDestino() {
        return destino;
    }

    protected void setDestino(Departamento destino) {
        this.destino = destino;
    }

    protected Date getDataPedido() {
        return dataPedido;
    }

    protected boolean setDataPedido(String dataPedido) {

        try {
        	formatter.setLenient(false);
            this.dataPedido = formatter.parse(dataPedido);
        } catch (ParseException ex) {
            //Logger.getLogger(Solicitacao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("ERRO: Data de Pedido vazia ou invalida.");
            return false;
        }
        return true;
    }

    protected Date getDataEntrega() {
        return dataEntrega;
    }

    protected void setDataEntrega(String dataEntrega) {

        try {
        	formatter.setLenient(false);
            Date dataEntregaFormadata = formatter.parse(dataEntrega);

            if (dataEntregaFormadata.before(dataPedido)) {
                JOptionPane.showMessageDialog(null, "Data de Inválida");
            } else {
                this.dataEntrega = dataEntregaFormadata;
            }

        } catch (java.text.ParseException ex) {
            //Logger.getLogger(Solicitacao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("ERRO: Data de Entrega inserida vazia ou invalida.");
            JOptionPane.showMessageDialog(null, "Por favor, insira uma DATA válida.");
        }

    }

    @Override
    public String toString() {
        if (this.dataEntrega != null) {
            return " Solicitação número " + solicitacaoID
                    + "\n Para o Departamento/Setor: " + destino.getSigla()
                    + "\n Produtos pedidos: " + produtosString()
                    + "\n Qnt de tipos de produtos pedidos: " + numeroPedidos
                    + "\n valorTotal= R$" + valorTotal
                    + "\n Data do Pedido: " + formatter.format(dataPedido) + "       Data de Entrega: " + formatter.format(dataEntrega)
                    + "\n_____________________________________________________________________________\n";

        } else {
            return " Solicitação número " + solicitacaoID
                    + "\n Para o Departamento/Setor: " + destino.getSigla()
                    + "\n Produtos pedidos: " + produtosString()
                    + "\n Qnt de tipos de produtos pedidos: " + numeroPedidos
                    + "\n valorTotal= R$" + valorTotal
                    + "\n Data do Pedido: " + formatter.format(dataPedido) + "       Data de Entrega: Não Informada"
                    + "\n_____________________________________________________________________________\n";
        }
    }

    public String toString(boolean minimalista) {   //Uma toString minimalista.
        if (this.dataEntrega != null) {
            return "Solicitação número: " + solicitacaoID + "   \nData do Pedido: " + formatter.format(dataPedido) + "  Data de Entrega: " + formatter.format(dataEntrega)
                    + "   \nQnt de tipos de produtos pedidos: " + numeroPedidos + "  valorTotal= R$" + valorTotal + "\n";
        } else {
            return "Solicitação número: " + solicitacaoID + "   \nData do Pedido: " + formatter.format(dataPedido) + "  Data de Entrega: Não Informada "
                    + "   \nQnt de tipos de produtos pedidos: " + numeroPedidos + "  valorTotal= R$" + valorTotal + "\n";
        }
    }

    @Override
    public int compareTo(Solicitacao solicitacao) { //Compare to para ordenação da lista de Solicitações.

        if (this.getSolicitacaoID() < solicitacao.getSolicitacaoID()) {
            return -1;
        } else if (this.getSolicitacaoID() > solicitacao.getSolicitacaoID()) {
            return 1;
        } else {
            return 0;
        }
    }
}
