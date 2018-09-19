package almoxarifado;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

abstract class GerenciadorSolicitacoes {
//Esta classe gerencia a lista de Solicitações feitas.

    static List<Solicitacao> listaSolicitacoes = new ArrayList();

    protected static void adicionaSolicitacao(Solicitacao solicitacao) {
        listaSolicitacoes.add(solicitacao);
        Collections.sort(listaSolicitacoes);
    }

    protected static void removeSolicitacao(int index) {
        listaSolicitacoes.remove(index);
        Collections.sort(listaSolicitacoes);
    }

    protected static Solicitacao pesquisaSolicitacao(int solicitacaoID) {
        Solicitacao solicitacaoPesquisa = null;
        for (Solicitacao solicitacao : listaSolicitacoes) {
            if (solicitacao.getSolicitacaoID() == solicitacaoID) {
                solicitacaoPesquisa = solicitacao;
            }
        }
        return solicitacaoPesquisa;
    }

    protected static String[] GerenciadorSolicitacoesArray() { //Passa a Lista para Array para ser utilizado em outras jClasses.
        String arraySolicitacoes[] = new String[listaSolicitacoes.size()];
        for (int i = 0; i < arraySolicitacoes.length; i++) {
            arraySolicitacoes[i] = listaSolicitacoes.get(i).toString(true);
        }
        return arraySolicitacoes;
    }

}
