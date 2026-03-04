package Backend;

import java.util.ArrayList; 
import java.util.List; 

/**
 * Représente une tâche dans un projet de gestion.
 * Une tâche peut être bloquée avec une raison.
 */
public class Task {
    private String name;
    private String project;
    private int priority; // 1 = haute, 3 = basse
    private boolean isBlocked;
    private String blockReason;

    public Task(String name, String project, int priority, boolean isBlocked, String blockReason) {
        this.name = name;
        this.project = project;
        setPriority(priority);
        setBlocked(isBlocked, blockReason);
        this.blockReason = blockReason;
    }

    // Getters et setters (simplifiés)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException("La priorité doit être comprise entre 1 et 3");
        }
        this.priority = priority;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String getBlockReason() {
        return blockReason;
    }

    /**
     * Marque la tâche comme bloquée ou débloquée avec une raison.
     * Si isBlocked est true, blockReason ne doit pas être vide ou ne contenir que
     * des espaces.
     *
     */
    public void setBlocked(boolean isBlocked, String blockReason) {
        if (isBlocked && (blockReason == null || blockReason.trim().isEmpty())) {
            throw new IllegalArgumentException("blockReason ne peut pas être vide quand isBlocked est true");
        }
        this.isBlocked = isBlocked;
        this.blockReason = blockReason;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", project='" + project + '\'' +
                ", priority=" + priority +
                ", isBlocked=" + isBlocked +
                ", blockReason='" + blockReason + '\'' +
                '}';
    }

    // ========== Fonctions statiques pour le filtrage et tri ==========
    public static List<Task> getBlockedTasksSorted(List<Task> tasks) {
        List<Task> result = new ArrayList<>();

        // Filtrer les tâches bloquées
        for (Task task : tasks) {
            if (task.isBlocked) {
                result.add(task);
            }
        }

        // Trier par priorité puis alphabétiquement
        for (int p = 1; p <= 3; p++) {
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i).priority == p && result.get(i + 1).priority == p) {
                    if (result.get(i).name.compareToIgnoreCase(result.get(i + 1).name) > 0) {
                        Task temp = result.get(i);
                        result.set(i, result.get(i + 1));
                        result.set(i + 1, temp);
                    }
                }
            }
        }

        return result;
    }

}