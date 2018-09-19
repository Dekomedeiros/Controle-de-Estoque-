package almoxarifado;

import java.util.ArrayList;
import java.util.List;


public abstract class GerenciadorDepartamentos {
//Esta classe gerencia a lista de departamentos.

    protected static List<Departamento> listaDepartamentos = new ArrayList();
    
    public static void adicionaDepartamento(Departamento departamento) {
        listaDepartamentos.add(departamento);
    }

    public static void removeDepartamento(int index) {
        listaDepartamentos.remove(index);
    }

    public static String[] GerenciadorDepartamentosArray() {    //Passa a lista de departamentos para Array (É necessário para outras jClasses).
        String arrayDepartamentos[] = new String[listaDepartamentos.size()];
        for (int i = 0; i < arrayDepartamentos.length; i++) {
            arrayDepartamentos[i] = listaDepartamentos.get(i).toString(false);
        }
        return arrayDepartamentos;
    }

    public static String[] GerenciadorDepartamentosSiglaArray() {   //Passa as siglas dos departamentos para Array (Necessário para o jComboBox da jSolicitação.
        String arrayDepartamentos[] = new String[(listaDepartamentos.size())];
        for (int i = 0; i < arrayDepartamentos.length; i++) {
            arrayDepartamentos[i] = listaDepartamentos.get(i).toString(true);
        }
        return arrayDepartamentos;
    }
}
