public class TestFan { // Begin test class.

    // Main method.
    public static void main(String[] args) {

        // Create first fan object.
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10.0);
        fan1.setColor("yellow");
        fan1.setSwitch(true);
        fan1.incrementID();
        System.out.println(fan1.toString());

        // Create second fan object.
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("blue");
        fan2.setSwitch(false);
        fan2.incrementID();
        System.out.println(fan2.toString());
    }
} // End test class.