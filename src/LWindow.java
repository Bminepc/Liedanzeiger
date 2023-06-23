import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LWindow extends JFrame {

    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

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
        device.setFullScreenWindow(this);
        p.setBackground(Color.GREEN);
        p.setSize(this.getWidth(),this.getHeight());
        setVisible(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '\n'){
                    l.setText("");
                }else {
                    l.setText(l.getText() + e.getKeyChar());
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
