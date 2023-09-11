import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (choice) {
                case 1:
                    System.out.print("Digite a tarefa a ser adicionada: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de tarefas:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa concluída: ");
                    int taskIndex = scanner.nextInt();
                    if (taskIndex >= 1 && taskIndex <= tasks.size()) {
                        tasks.remove(taskIndex - 1);
                        System.out.println("Tarefa marcada como concluída e removida da lista.");
                    } else {
                        System.out.println("Número de tarefa inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo da aplicação.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
