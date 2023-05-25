import javax.swing.*;
import java.awt.*;

public class LWindow extends JFrame {

    JPanel p = new JPanel();
    JLabel l = new JLabel("Bananas");
    public LWindow() {
        super("Liedanzeiger");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        this.setLayout(new BorderLayout());
        l.setFont(new Font("Arial Black", Font.PLAIN, 400));
        p.add(l);
        this.add(p, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        p.setBackground(Color.GREEN);
        p.setSize(this.getWidth(),this.getHeight());
        setVisible(true);
    }
}
