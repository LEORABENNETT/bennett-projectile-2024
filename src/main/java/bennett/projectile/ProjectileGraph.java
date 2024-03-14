package bennett.projectile;

import bennett.projectile.Projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0, 0);
    Projectile secondsProjectile = new Projectile(projectile);

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.LIGHT_GRAY);
        for (int i = 30; i < getWidth(); i += 30) {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int i = 30; i < getHeight(); i += 30) {
            g.drawLine(0, i, getWidth(), i);
        }

        g.setColor(Color.BLACK);
        g.drawLine(30, getHeight() - 30, getWidth(), getHeight() - 30);
        g.drawLine(30, getHeight() - 30, 30, 0);

        g.translate(30, getHeight() - 30);

        g.setColor(Color.BLACK);

        projectile.setSeconds(0);

        for (int i = 0; i <= (projectile.getApexTime() * 2) + 1; i++) {
            double currX = projectile.getX();
            double currY = projectile.getY();

            projectile.setSeconds(i);

            g.drawLine((int) currX,
                    -(int) currY,
                    (int) projectile.getX(),
                    -(int) projectile.getY());
        }

        g.setColor(Color.BLUE);
        g.fillOval(
                ((int) projectile.getX() / 2) - 5,
                (int) -projectile.getPeakY() - 5,
                10,
                10
        );

        g.drawString("(" + FORMAT.format(projectile.getX()) + ", " +
                        FORMAT.format(projectile.getPeakY()) + ")", ((int) projectile.getX() / 2) - 7,
                (int) -projectile.getPeakY() - 7);


        g.setColor(Color.RED);
        g.fillOval((int) (secondsProjectile.getX()),
                (int) (-secondsProjectile.getY()),
                10,
                10
        );
        g.drawString("(" + FORMAT.format(secondsProjectile.getX()) + ", " +
                        FORMAT.format(-secondsProjectile.getY()) + ")",
                (int) (secondsProjectile.getX()), (int) (-secondsProjectile.getY()));
    }


    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        this.secondsProjectile = new Projectile(projectile);
        repaint();
    }

}

