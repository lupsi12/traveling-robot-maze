import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Kazankaybet extends JFrame {
    private JPanel panel;
    private JLabel label;
    private Robot robot;
    private Lokasyon bitis;
    public Kazankaybet(Robot robot1,Lokasyon bitis1){
        robot = robot1;
        bitis = bitis1;
        panel = new JPanel();
        setSize(1000,800);
        setTitle("KAZANDIN KAYBETTİN");
        add(panel);
        label = new JLabel();
        label.setBounds(0,0,1000,800);
        getContentPane().add(label);
         JLabel label2=new JLabel();
        label2.setBounds(250,100,300,40);
        label2.setText("TEBRİKLER KAZANDINIZ");
        label2.setFont(new Font((""), Font.BOLD, 20));
        getContentPane().add(label2);
        JLabel label3=new JLabel();
        label3.setBounds(330,200,150,40);
        getContentPane().add(label3);
        if(robot.getX()== bitis.getX() && robot.getY()== bitis.getY())
            label.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/2.png"))));
            getContentPane().repaint();
    }
}
