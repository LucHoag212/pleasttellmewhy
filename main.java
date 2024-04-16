package com.mycompany.ptmw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ptmw extends JFrame {
    private List<JLabel> words = new ArrayList<>();
    private int index = 0;

    public Ptmw() {
        setTitle("Please tell me why");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(new Color(255, 105, 180)); 
        add(panel, BorderLayout.CENTER);

        addWords(panel);

        setVisible(true);
        animateLyrics();
    }

    private void addWords(JPanel panel) {
        String[] lyricsArray = {
                "My", "baby", "love", "you", "so", "much", "forever", "you", "and", "I!",
                "I", "love", "you", "oh!", "I", "love", "you", "so", "much", "forever", "you", "and", "I"
        };

        for (String word : lyricsArray) {
            JLabel label = new JLabel(word);
            label.setFont(new Font("Comic Sans MS", Font.BOLD, 40)); 
            label.setForeground(Color.WHITE);
            label.setVisible(false);
            panel.add(label);
            words.add(label);
        }
    }

    private void animateLyrics() {
        new Thread(() -> {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (JLabel word : words) {
                SwingUtilities.invokeLater(() -> word.setVisible(true)); 
                try {
                    int delay = word.getText().contains("love") ? 250 : 500;
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ptmw::new);
    }
}
