package bennett.projectile;

import static java.lang.Math.sin;

public class Projectile {
    // class is a way to organize code
    // private means not accessible outside the class, limited scope
    private double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private static final double GRAVITY = 9.8;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public Projectile(Projectile projectile) {
        this(projectile.angle, projectile.velocity);
        this.seconds = projectile.seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return sin(radians) * velocity * seconds
                - .5 * GRAVITY * seconds * seconds;
    }

    /**
     * @return the time when the Projectile is at its highest point.
     */

    public double getApexTime() {
        return velocity * sin(radians) / 9.8;
    }

    public double getPeakY() {
        return (sin(radians) * velocity) * (sin(radians) * velocity) / (2 * GRAVITY);
    }

    public double getInterceptX() {
        double t = 2 * sin(radians) * velocity / GRAVITY;

        return Math.cos(radians) * velocity * t;
    }
}
