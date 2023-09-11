/**
 * @author Andre Delorme
 * 
 */
public class DAOFuncionarios extends DAO {

    // campos do modelo
    static Object[] FIELDS = { "Funcionario No.", "Nome" };

    // lista de alunos (modelos)
    static Object[][] DATA = {
            { 5730735, "José" },
            { 5743313, "Maria" },
            { 7813423, "Sandra" },
            { 3385166, "Márcio" },
            { 455591, "João" },
            { 5555353, "Rodrigo" },
            { 893125, "José" },
            { 2824896, "Arthur" },
            { 5093026, "Dalva" },
            { 6301789, "Paulo" }
    };

    public DAOFuncionarios() {
        super(FIELDS, DATA);
    }
}