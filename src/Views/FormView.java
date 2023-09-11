import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Andre Delorme
 *
 */
public class FormView {

	JFrame frame;
	Object id;
	ArrayList<JTextField> fieldControls = new ArrayList<JTextField>();

	public FormView(ListController controller) {
		this(controller, null);
	}

	public FormView(ListController controller, Object id) {

		final Object fields[] = controller.getHeaders();
		// cria componentes de interface
		for (int i = 0; i < fields.length; i++) {
			fieldControls.add(new JTextField(20));
		}

		JButton saveButton = new JButton("Salvar");
		JButton cancelButton = new JButton("Cancelar");

		// botão de todos: realiza chamada ao controller
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> data = new ArrayList<Object>();
				for (JTextField field : fieldControls)
					data.add(field.getText());

				Object[] newData = data.toArray();
				if (id != null)
					controller.updateOne(newData[0], newData);
				else
					controller.insertOne(newData);

				frame.setVisible(false);
				frame.dispose();
			}
		});
		// botão de inserção: realiza chamada ao controller
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		// cria JPanel para organizar os componentes (layout)
		GridLayout formLayout = new GridLayout(0, 2);
		JPanel ctrlPane = new JPanel();
		ctrlPane.setLayout(formLayout);
		// adiciona os componentes ao JPanel
		Object[] edit = id != null ? controller.getById(id) : null;

		for (int i = 0; i < fields.length; i++) {
			ctrlPane.add(new Label(fields[i].toString()));
			ctrlPane.add(fieldControls.get(i));
			if (id != null)
				fieldControls.get(i).setText(edit[i].toString());
		}
		ctrlPane.add(saveButton);
		ctrlPane.add(cancelButton);
		// cria um frame para receber o split pane
		frame = new JFrame(
				"Swing MVC Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ctrlPane);
		frame.pack();
		frame.setVisible(true);
	}

}
