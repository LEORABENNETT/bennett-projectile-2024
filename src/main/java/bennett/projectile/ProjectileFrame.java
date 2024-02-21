package bennett.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    static final int ANGLE_MIN = 0;
    static final int ANGLE_MAX = 90;
    static final int ANGLE_INIT = 45;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);

        JSlider angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);


        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        JLabel labelX = new JLabel("X");
        add(labelX);
        JLabel labelY = new JLabel("Y");
        add(labelY);

        JTextField velocityField = new JTextField();
        add(velocityField);
        //JTextField angleField = new JTextField();
        JTextField secondsField = new JTextField();
        add(secondsField);
        JLabel calculatedLabelX = new JLabel();
        add(calculatedLabelX);
        JLabel calculatedLabelY = new JLabel();
        add(calculatedLabelY);
        JLabel empty = new JLabel();
        add(empty);
        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);
        JLabel peakLabelY = new JLabel("Peak Y");
        add(peakLabelY);
        JLabel interceptLabelX = new JLabel("Intercept X");
        add(interceptLabelX);
        JLabel peakY = new JLabel();
        add(peakY);
        JLabel interceptX = new JLabel();
        add(interceptX);


        add(angleSlider);
        //add(angleField);

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                Projectile projectile = new Projectile(
                        Double.parseDouble(velocityField.getText()),
                        Double.parseDouble(String.valueOf(angleSlider.getValue()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                calculatedLabelX.setText(Double.toString(projectile.getX()));
                calculatedLabelY.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Projectile projectile = new Projectile(
                        angleSlider.getValue(),
                        Double.parseDouble(String.valueOf(velocityField.getX()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                calculatedLabelX.setText(Double.toString(projectile.getX()));
                calculatedLabelY.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(
                        angleSlider.getValue(),
                        Double.parseDouble(String.valueOf(velocityField.getX()))
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );
                calculatedLabelX.setText(Double.toString(projectile.getX()));
                calculatedLabelY.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

    }
}