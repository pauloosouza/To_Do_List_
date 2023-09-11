import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class ImprovedToDoListGUI extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ImprovedToDoListGUI() {
        setTitle("Lista de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskField = new JTextField(20);
        JButton addButton = new JButton("Adicionar Tarefa");
        JButton removeButton = new JButton("Remover Tarefa");

        addButton.setIcon(new ImageIcon("add.png")); // Adicione um ícone ao botão
        removeButton.setIcon(new ImageIcon("remove.png")); // Adicione um ícone ao botão

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Digite uma tarefa válida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma tarefa para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        panel.add(taskField, BorderLayout.NORTH);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImprovedToDoListGUI todoApp = new ImprovedToDoListGUI();
                todoApp.setVisible(true);
            }
        });
    }
}
