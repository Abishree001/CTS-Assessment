public class TestCommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("Turning Light ON:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("Turning Light OFF:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
