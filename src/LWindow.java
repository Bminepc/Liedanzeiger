import javax.swing.*;

public class LWindow extends JFrame {

    JPanel p = new JPanel();
    JLabel l = new JLabel("Bananas");
    public LWindow() {
        super("Liedanzeiger");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        //Fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
}
