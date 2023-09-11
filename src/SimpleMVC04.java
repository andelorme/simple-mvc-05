import javax.swing.SwingUtilities;

/**
 *
 * @author andre
 */
public class SimpleMVC04 {

	public static void main(String[] args) {
		// realiza a chamada pela thread de eventos de interface
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					initGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void initGui() {

		DAOAlunos daoAlunos = new DAOAlunos();
		DAOProfessores daoProfessores = new DAOProfessores();
		DAOFuncionarios daoFuncionarios = new DAOFuncionarios();
		// Cria controller
		ListController alunosController = new ListController(daoAlunos);
		ListController profsController = new ListController(daoProfessores);
		ListController funcController = new ListController(daoFuncionarios);

		// cria view associada ao controller
		new ListView(alunosController, "Alunos");
		new ListView(profsController, "Professores");
		new ListView(funcController, "Funcionarios");

		// solicita ao controller carregar todos os itens
		alunosController.fetchAll();
		profsController.fetchAll();
		funcController.fetchAll();
	}
}
