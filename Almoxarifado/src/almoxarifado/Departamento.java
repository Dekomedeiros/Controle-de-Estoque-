package almoxarifado;

class Departamento {
//Classe base para os Departamentos/Setores do Almoxarifado.

    private String nome;
    private String sigla;

    protected Departamento(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        GerenciadorDepartamentos.adicionaDepartamento(this); //Ao instanciar já adiciona na lista de Departamentos.
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getSigla() {
        return sigla;
    }

    protected void setSigla(String sigla) {
        this.sigla = sigla;
    }

    protected String toString(boolean apenasSigla) {
        if (apenasSigla == false) {
            return "Nome: " + nome + "        Sigla: " + sigla;
        } else {
            return sigla;
        }

    }
}
