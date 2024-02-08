package bennett.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    @Test
    public void getX() {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getX();

        // then
        assertEquals(150.43, actual, 0.01);
    }

    @Test
    public void getY() {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getY();

        // then
        assertEquals(54.66, actual, 0.01);
    }

    @Test
    public void getApexTime() {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getApexTime();

        // then
        assertEquals(1.05, actual, .01);
    }

    @Test
    public void getPeakY() {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getPeakY();

        // then
        assertEquals(57.18, actual, .01);
    }
}