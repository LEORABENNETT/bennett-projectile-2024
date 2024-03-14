package bennett.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ProjectileFrame extends JFrame {
    private static final int VELOCITY_MIN = 0;
    private static final int VELOCITY_MAX = 100;
    private static final int VELOCITY_INIT = 65;
    private static final int ANGLE_MIN = 0;
    private static final int ANGLE_MAX = 90;
    private static final int ANGLE_INIT = 31;
    private static final double SECONDS_INIT = 2.7;

    private final JSlider velocitySlider;
    private final JSlider angleSlider;
    private final JTextField velocityField;
    private final JTextField angleField;
    private final JTextField secondsField;
    private final JLabel calculatedLabelX;
    private final JLabel calculatedLabelY;
    private final JLabel peakY;
    private final JLabel interceptX;

    private final ProjectileGraph graph = new ProjectileGraph();

    public ProjectileFrame() {
        setSize(1000, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);
        west.setLayout(new GridLayout(9, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        velocityField = new JTextField(String.valueOf(VELOCITY_INIT));
        west.add(velocityField);

        velocitySlider = new JSlider(JSlider.HORIZONTAL, VELOCITY_MIN, VELOCITY_MAX, VELOCITY_INIT);
        velocitySlider.setMajorTickSpacing(20);
        velocitySlider.setMinorTickSpacing(10);
        velocitySlider.setPaintTicks(true);
        velocitySlider.setPaintLabels(true);
        west.add(velocitySlider);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        angleField = new JTextField(String.valueOf(ANGLE_INIT));
        west.add(angleField);

        angleSlider = new JSlider(JSlider.HORIZONTAL, ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        west.add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField(String.valueOf(SECONDS_INIT));
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

        JButton calculateButton = new JButton("Calculate");
        west.add(new JLabel());
        west.add(calculateButton);

        velocitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                velocityField.setText(String.valueOf(velocitySlider.getValue()));
                projectileAction();
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                angleField.setText(String.valueOf(angleSlider.getValue()));
                projectileAction();
            }
        });

        calculateButton.addActionListener(e -> projectileAction());

        main.add(graph, BorderLayout.CENTER);

        // default values
        velocitySlider.setValue(VELOCITY_INIT);
        angleSlider.setValue(ANGLE_INIT);
        secondsField.setText(String.valueOf(SECONDS_INIT));
    }

    private void projectileAction() {
        Projectile projectile = new Projectile(
                Double.parseDouble(velocityField.getText()),
                Double.parseDouble(angleField.getText())
        );
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        calculatedLabelX.setText(String.valueOf(projectile.getX()));
        calculatedLabelY.setText(String.valueOf(projectile.getY()));
        peakY.setText(String.valueOf(projectile.getPeakY()));
        interceptX.setText(String.valueOf(projectile.getInterceptX()));

        graph.setProjectile(projectile);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjectileFrame frame = new ProjectileFrame();
            frame.setVisible(true);
        });
    }
}
