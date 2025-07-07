package com.example;

public class UserControllerTest {

    public static void main(String[] args) {
        UserController controller = new UserController();

        User user = controller.getUser(1L);

        assert user != null;
        assert user.getId().equals(1L);
        assert user.getName().equals("Mock User");

        System.out.println("✅ Test passed: " + user.getName());
    }
}
