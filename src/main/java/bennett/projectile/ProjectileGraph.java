package bennett.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {
    // JComponent is super class

    private Projectile projectile = new Projectile(0, 0);

    // homework: draw a projectile graph, the path of a projectile
    // draw an arc
    // arc = series of lines
    // put one dot in blue at the peak
    // PR put up - must include a screenshot

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // basic draw calls to know about
        g.translate(0, getHeight());
        // negative values if change origin
        /*g.drawString("(100, 100)", 100, -100);
        g.setColor(Color.GREEN);
        g.drawLine(0, 0, getWidth(), -getHeight());
        g.drawRect(200, -200, 50, 50);
        g.setColor(Color.MAGENTA);
        g.fillRect(400, -400, 25, 25);
        g.setColor(Color.ORANGE);
        g.drawOval(200, -200, 50, 50);*/

        g.setColor(Color.BLACK);

        projectile.setSeconds(0);

        for (int i = 0; i <= (projectile.getApexTime() * 2) + 1; i++)
        {
            double currX = projectile.getX();
            double currY = projectile.getY();

            projectile.setSeconds(i);

            g.drawLine((int) currX,
                    -(int) currY,
                    (int) projectile.getX(),
                    -(int) projectile.getY());
        }

        g.fillOval(
                (int) projectile.getX(),
                (int) -projectile.getY(),
                10,
                10
        );

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tells the operating system to call paintComponent() again.
        repaint();
    }
}
