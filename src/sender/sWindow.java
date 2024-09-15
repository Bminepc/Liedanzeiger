package sender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class sWindow extends javax.swing.JFrame {
    JPanel panel;
    JTextField lied;
    JLabel liedlabel;
    JTextField strophe;
    JLabel strophelabel;
    JButton send;
    public sWindow() {
        super("Liedanzeiger Eingabe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        lied = new JTextField(10);
        strophe = new JTextField(20);
        liedlabel = new JLabel("Liednummer:");
        strophelabel = new JLabel("Stophe/n:");
        send = new JButton("Senden");
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    HttpClient client = HttpClient.newHttpClient();
                    String jsonInputString = "{\"number\": \""+ lied.getText() + "<br/>" + strophe.getText() +"\"}";

                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(new URI("http://81.169.152.161:5011/write-number"))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                            .build();
                    client.send(request, HttpResponse.BodyHandlers.ofString());
                } catch (Exception ese) {
                }
            }
        });
        panel.add(liedlabel);
        panel.add(lied);
        panel.add(strophelabel);
        panel.add(strophe);
        panel.add(send);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
