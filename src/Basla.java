import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
public class Basla extends JFrame {
    public Basla(){

        JPanel panel = new JPanel();
        add(panel);
        setSize(800,600);
        setTitle("GEZGİN ROBOT PROJESİ");
        JLabel  label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/1.png"))));
        label.setBounds(0,0,800,600);
        panel.add(label);
        JLabel   baslik = new JLabel("GEZGİN ROBOT");
        baslik.setBounds(145,75,400,50);
        baslik.setFont(new Font((""), Font.BOLD, 35));
        panel.add(baslik); // panele ekleme yaptım
        JButton  txt_bir = new JButton("PROBLEM 1-1"); // 1.txt için konulmuş butonn
        txt_bir.setFont(new Font((""), Font.BOLD,20));
        txt_bir.setBounds(250,200,200,40);
        txt_bir.setBackground(Color.GREEN);
        label.add(txt_bir);
        JButton txt_iki = new JButton("PROBLEM 1-2"); // 2.txt için konulmuş butonn
        txt_iki.setFont(new Font((""), Font.BOLD,20));
        txt_iki.setBounds(250,250,200,40);
        txt_iki.setBackground(Color.GREEN);
        label.add(txt_iki);
        JButton  iki = new JButton("PROBLEM 2");
        iki.setFont(new Font((""), Font.BOLD,20));
        iki.setBounds(250,300,200,40);
        iki.setBackground(Color.BLUE);
        label.add(iki);
        JButton  iki1 = new JButton("PROBLEM 2-1");
        iki1.setFont(new Font((""), Font.BOLD,20));
        iki1.setBounds(250,350,200,40);
        iki1.setBackground(Color.BLUE);
        label.add(iki1);
        txt_bir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dosyaadi="url1.txt";
                Problem1 frame = null;
                try {
                    frame = new Problem1(dosyaadi);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        txt_iki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dosyaadi="url2.txt";
                Problem1 frame = null;
                try {
                    frame = new Problem1(dosyaadi);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        iki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boyut frame = new Boyut();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        iki1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                problem3boyut frame = new problem3boyut();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
