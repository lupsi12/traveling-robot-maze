import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
public class Boyut extends JFrame {
    public Boyut(){
        JPanel  panel = new JPanel();
        add(panel);
        setSize(800,600);
        setTitle("GEZGİN ROBOT PROBLEM2");
         JLabel label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/god.png"))));
        label.setBounds(0,0,800,600);
        getContentPane().add(label);
        JTextField labirent_boyut = new JTextField();
        labirent_boyut.setFont(new Font("",Font.BOLD,17));
        labirent_boyut.setBounds(510,340,180,40);
        label.add(labirent_boyut);
         JLabel lboyut = new JLabel("LABİRENT BOYUT GİRİNİZ");
        lboyut.setFont(new Font("",Font.BOLD,17));
        lboyut.setBounds(500,300,400,40);
        label.add(lboyut);
        JTextField baslangic_kose = new JTextField();
        baslangic_kose.setFont(new Font("",Font.BOLD,17));
        baslangic_kose.setBounds(500,440,175,40);
        label.add(baslangic_kose);
         JLabel lkose = new JLabel("LABİRENT GİRİŞ KÖŞENİZİ GİRİNİZ 1-2-3-4");
        lkose.setFont(new Font("",Font.BOLD,17));
        lkose.setBounds(400,400,400,40);
        label.add(lkose);
        JButton basla = new JButton("BAŞLA");
        basla.setFont(new Font("",Font.BOLD,20));
        basla.setBounds(560,500,150,40);
        label.add(basla);
        basla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Robot robot = new Robot();
                Izgara izgara = new Izgara();
                Engel engel = new Engel();
                Lokasyon baslangic_noktasi= new Lokasyon();
                Lokasyon bitis_noktasi = new Lokasyon();
                izgara.setSatir(Integer.parseInt(labirent_boyut.getText()));
                izgara.setSutun(Integer.parseInt(labirent_boyut.getText()));
                if(baslangic_kose.getText().equals("1")){
                    baslangic_noktasi.setX(0);
                    baslangic_noktasi.setY(1);
                    bitis_noktasi.setX(izgara.getSutun()-1);
                    bitis_noktasi.setY(izgara.getSatir()-2);
                } else if (baslangic_kose.getText().equals("2")) {
                    baslangic_noktasi.setX(izgara.getSutun()-1);
                    baslangic_noktasi.setY(1);
                    bitis_noktasi.setX(0);
                    bitis_noktasi.setY(izgara.getSatir()-2);
                }
                else if (baslangic_kose.getText().equals("3")) {
                    baslangic_noktasi.setX(0);
                    baslangic_noktasi.setY(izgara.getSatir()-2);
                    bitis_noktasi.setX(izgara.getSutun()-1);
                    bitis_noktasi.setY(1);
                }
                else if (baslangic_kose.getText().equals("4")) {
                    baslangic_noktasi.setX(izgara.getSutun()-1);
                    baslangic_noktasi.setY(izgara.getSatir()-2);
                    bitis_noktasi.setX(0);
                    bitis_noktasi.setY(1);
                }
                Problem2 frame = new Problem2(izgara,engel,robot,baslangic_noktasi,bitis_noktasi);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
