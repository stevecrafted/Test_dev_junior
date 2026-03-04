package Backend;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Deployer", "Projet A", 1, true, "En attente de validation"));
        PrintResult(1, tasks);

        tasks.add(new Task("Corriger bug", "Projet B", 2, true, "reason"));
        PrintResult(2, tasks);

        tasks.add(new Task("Documenter", "Projet A", 3, false, "null"));
        PrintResult(3, tasks);

        tasks.add(new Task("Tester", "Projet B", 1, true, "Pas encore prêt"));
        PrintResult(4, tasks);

        // try {
        //     Task t = new Task("Exemple", "Test", 2, true, null);
        //     t.setBlocked(true, "   "); // devrait lever une exception
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Erreur : " + e.getMessage());
        // }

        // Filtrage et tri
        List<Task> blockedSorted = Task.getBlockedTasksSorted(tasks);
        System.out.println("Tâches bloquées triées :");
        PrintResult(5, blockedSorted);
    }

    // Afficher facilement le resultat voulu
    private static void PrintResult(int numTest, List<Task> tasks) {
        System.out.println(numTest);
        tasks.forEach(System.out::println);
        System.out.println();
    }
}
