package almoxarifado;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class GerenciadorEstoque {
//Esta classe gerencia a lista de produtos contidos no estoque.

    protected static List<Produto> estoque = new ArrayList();

    protected static List<Produto> getEstoque() {
        return estoque;
    }
    

    protected static void cadastrarProduto(String nomeProduto, double valorProduto, int quantidadeProduto) {

        estoque.add(new Produto(nomeProduto, valorProduto, quantidadeProduto));
        Collections.sort(estoque);
    }

    protected static void removeProduto(int index) {

        estoque.remove(index);
    }

    protected static void baixaProduto(int index, int quantBaixa) {
        Produto produto = estoque.get(index);
        int quantProduto = produto.getQuantidade();
        int baixa = quantProduto - quantBaixa;
        produto.setQuantidade(baixa);
    }

    protected static void repoeProduto(Produto produto, int novaQuant) {
        estoque.get(estoque.indexOf(produto)).setQuantidade(novaQuant);
    }

    protected static Produto pesquisaProduto(int produtoID) {
        Produto produtoPesquisa = null;
        for (Produto produto : estoque) {
            if (produto.getProdutoID() == produtoID) {
                produtoPesquisa = produto;
            }
        }
        return produtoPesquisa;
    }

    protected static String printEstoque() {
        Collections.sort(estoque);
        String relatorio = " ";

        for (Produto produto : estoque) {

            relatorio += produto.toString() + "\n";

        }
        return relatorio;
    }

    protected static String[] estoqueArray() {  //Passa a Lista para Array para ser utilizado em outras jClasses.
        String arrayEstoque[] = new String[estoque.size()];
        for (int i = 0; i < arrayEstoque.length; i++) {
            arrayEstoque[i] = estoque.get(i).toString(false);
        }
        return arrayEstoque;
    }

    protected static void OrdenaEstoque() { //Ordena a lista com base no CompareTo da sua classe.
        Collections.sort(estoque);
    }
}
