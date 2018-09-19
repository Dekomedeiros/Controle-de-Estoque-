package almoxarifado;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileControl {
//Classe que grava as informações da aplicação em JSONs e TXTs afim de manter o que foi feito.
//IMPORTANTE: Utiliza importação da biblioteca externa GSON da Google.
    
    static void salvarAlteracoes() {

        Gson gson = new Gson();
        FileWriter JsonListas;
        BufferedWriter TxtListaID;

        String jsonEstoque = gson.toJson(GerenciadorEstoque.estoque);

        String jsonDepartamentos = gson.toJson(GerenciadorDepartamentos.listaDepartamentos);

        String jsonSolicitacoes = gson.toJson(GerenciadorSolicitacoes.listaSolicitacoes);

        try {
            JsonListas = new FileWriter("ListaEstoque.json", false);
            JsonListas.write(jsonEstoque);
            JsonListas.close();
            JsonListas = new FileWriter("ListaDepartamentos.json", false);
            JsonListas.write(jsonDepartamentos);
            JsonListas.close();
            JsonListas = new FileWriter("ListaSolicitacoes.json", false);
            JsonListas.write(jsonSolicitacoes);
            JsonListas.close();
            
            TxtListaID = new BufferedWriter(new FileWriter("ListaID.txt"));
            TxtListaID.write(String.valueOf(Produto.id));
            TxtListaID.newLine();
            TxtListaID.write(String.valueOf(Solicitacao.id));            
            TxtListaID.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void carregaArquivos() {

        try {
            BufferedReader JsonListaEstoque = new BufferedReader(new FileReader("ListaEstoque.json"));
            BufferedReader JsonListaDepartamentos = new BufferedReader(new FileReader("ListaDepartamentos.json"));
            BufferedReader JsonListaSolicitacoes = new BufferedReader(new FileReader("ListaSolicitacoes.json"));
            BufferedReader TxtListaID = new BufferedReader(new FileReader("ListaID.txt"));
            
            int idProdutos = 0, idSolicitacoes = 0;
            
            Gson gson = new Gson();

            Produto[] produtoArray = gson.fromJson(JsonListaEstoque, Produto[].class);
            Departamento[] departamentoArray = gson.fromJson(JsonListaDepartamentos, Departamento[].class);
            Solicitacao[] solicitacaoArray = gson.fromJson(JsonListaSolicitacoes, Solicitacao[].class);

            GerenciadorEstoque.estoque.addAll(Arrays.asList(produtoArray));

            GerenciadorDepartamentos.listaDepartamentos.addAll(Arrays.asList(departamentoArray));

            GerenciadorSolicitacoes.listaSolicitacoes.addAll(Arrays.asList(solicitacaoArray));
            
            idProdutos = Integer.parseInt(TxtListaID.readLine()); //Lê a primeira linha do ID de produtos e já pula para a próxima       
            idSolicitacoes = Integer.parseInt(TxtListaID.readLine());//Lê a segunda linha do ID de solicitações pois o primeiro readLine já pulou pra próxima.
          
            Produto.id = idProdutos;
            Solicitacao.id = idSolicitacoes;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
