class Fan { // Begin class.

    // Global constants.
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    // Private variables.
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    private static int id = 0; // The id variable is static so it can increment.

    // Accessors and mutators.
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSwitch(boolean on) {
        this.on = on;
    }

    public boolean getSwitch() {
        return on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    // The toString() method.
    public String toString() {
        if (on == true) {
            return "Fan: " + id + " Speed: " + speed + " Radius: " + radius + " Color: " + color + "\n The fan is on.";
        } else {
            return "Fan: " + id + " Speed: " + speed + " Radius: " + radius + " Color: " + color + "\n The fan is off.";
        }
    }

    // Public constructor method.
    public Fan() {
        this.speed = SLOW;
        this.radius = 5.0;
        this.color = "blue";
        this.on = false;
        setId(++id);
    }

} // End class.