package bennett.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileFrame extends JFrame {
    static final int ANGLE_MIN = 0;
    static final int ANGLE_MAX = 90;
    static final int ANGLE_INIT = 45;
    private final JSlider angleSlider;
    private final JTextField velocityField;
    private final JTextField secondsField;
    private final JLabel calculatedLabelX;
    private final JLabel calculatedLabelY;
    private final JLabel peakY;
    private final JLabel interceptX;

    private ProjectileGraph graph = new ProjectileGraph();

    public ProjectileFrame() {
        setSize(1000, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);
        // tells the JFrame to use this JPanel
        setContentPane(main);

        west.setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);

        velocityField = new JTextField();
        west.add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);

         angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        west.add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField();
        west.add(secondsField);

        JLabel labelX = new JLabel("X");
        west.add(labelX);
        calculatedLabelX = new JLabel();
        west.add(calculatedLabelX);

        JLabel labelY = new JLabel("Y");
        west.add(labelY);
        calculatedLabelY = new JLabel();
        west.add(calculatedLabelY);

        JLabel peakLabelY = new JLabel("Peak Y");
        west.add(peakLabelY);
        peakY = new JLabel();
        west.add(peakY);

        JLabel interceptLabelX = new JLabel("Intercept X");
        west.add(interceptLabelX);
        interceptX = new JLabel();
        west.add(interceptX);

        JLabel empty = new JLabel();
        west.add(empty);
        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> projectileAction());

        angleSlider.addChangeListener(e -> projectileAction());

        calculateButton.addActionListener(e -> projectileAction());

        main.add(graph, BorderLayout.CENTER);

    }

    private void projectileAction() {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(String.valueOf(velocityField.getText()))
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        calculatedLabelX.setText(Double.toString(projectile.getX()));
        calculatedLabelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));

        graph.setProjectile(projectile);
    }

}