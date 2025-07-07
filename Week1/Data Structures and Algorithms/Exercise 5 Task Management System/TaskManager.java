public class TaskManager {
    private Task head = null;

    // Add task at end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println(" Task added.");
    }

    // Search task by ID
    public Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println(" No tasks available.");
            return;
        }
        Task temp = head;
        System.out.println("\n Task List:");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("This is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println(" Task deleted.");
            return;
        }

        Task prev = head;
        Task curr = head.next;

        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println(" Task deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println(" Task not found.");
    }

    // Main for testing
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask(1, "Design UI", "Pending");
        tm.addTask(2, "Implement Backend", "In Progress");
        tm.addTask(3, "Write Test Cases", "Pending");

        tm.displayTasks();

        System.out.println("\n Searching for Task ID 2:");
        Task found = tm.searchTask(2);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n Deleting Task ID 1");
        tm.deleteTask(1);

        tm.displayTasks();
    }
}
