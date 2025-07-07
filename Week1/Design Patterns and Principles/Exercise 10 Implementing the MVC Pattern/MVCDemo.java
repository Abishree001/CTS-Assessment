public class MVCDemo {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Abishree", "S123", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        controller.updateView();

        // Update model data through controller
        controller.setStudentName("Abi Shree Murugesan");
        controller.setStudentGrade("A+");

        // Display updated info
        System.out.println("\nAfter Update:");
        controller.updateView();
    }
}
