import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LWindow extends JFrame {

    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    JPanel p = new JPanel();
    JLabel l = new JLabel("");
    JLabel l2 = new JLabel("");
    JLabel l3 = new JLabel("");
    //TODO This ist just Debug! Please empty after testing
    String text = "123<br/>1+2+3";
    String BauchbindeTop = "Moonlight Sonata";
    String BauchbindeBottom = "Mozzart";
    public LWindow() {
        super("Liedanzeiger");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        p.setLayout(null);
        //this.setLayout(new BorderLayout());
        l.setFont(new Font("Arial Black", Font.PLAIN, 100));
        l.setText("<html>" + text + "</html>");
        l.setForeground(Color.WHITE);
        p.add(l);
        l2.setFont(new Font("Arial Black", Font.PLAIN, 80));
        l2.setText(BauchbindeTop);
        l2.setForeground(Color.WHITE);
        p.add(l2);
        l3.setFont(new Font("Arial Black", Font.PLAIN, 50));
        l3.setText(BauchbindeBottom);
        l3.setForeground(Color.WHITE);
        p.add(l3);
        this.add(p);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        device.setFullScreenWindow(this);
        p.setBackground(Color.GREEN);
        p.setSize(this.getWidth(),this.getHeight());
        //Settings for Liednummer Label
        l.setSize(500,500);
        l.setLocation(100,0);
        //Settings for Bauchbinden Top Label
        l2.setSize(1000,500);
        l2.setLocation(50,600);
        //Settings for Bauchbinden Bottom Label
        l3.setSize(1000,500);
        l3.setLocation(53,680);
        setVisible(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '\n'){
                    text = "";
                }else if(e.getKeyChar() == ',') {
                   text = text + "<br/>";
                }else{
                        text = text + e.getKeyChar();
                    }
                l.setText("<html>" + text + "</html>");
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
