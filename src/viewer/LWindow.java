package viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LWindow extends JFrame {

    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    JPanel p = new JPanel();
    JLabel l = new JLabel("");
    String text = "";
    public LWindow() {
        super("Liedanzeiger");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        this.setLayout(new BorderLayout());
        l.setFont(new Font("Arial Black", Font.PLAIN, 400));
        l.setForeground(Color.WHITE);
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
                    text = "";
                }else if(e.getKeyChar() == ',') {
                   text = text + "<br/>";
                }else{
                        text = text + e.getKeyChar();
                    }
                updateText(text);
                }


            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public void updateText(String text){
        l.setText("<html>" + text + "</html>");
    }
}
