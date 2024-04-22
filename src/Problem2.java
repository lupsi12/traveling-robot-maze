import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Timer;
public class Problem2 extends JFrame {
    Izgara izgara = new Izgara();
    Robot robot = new Robot();
    Engel engel = new Engel();
    Lokasyon baslangic = new Lokasyon();
    Lokasyon bitis = new Lokasyon();
    ArrayList<Lokasyon> bugu = new ArrayList<>();
    ArrayList<Lokasyon> yolgecis = new ArrayList<>(); // robot hareket koordinatları engeller yok en kısa yoll
    ArrayList<Lokasyon> robotko = new ArrayList<>();
    ArrayList<Lokasyon> robotko1=new ArrayList<>();
    ArrayList<Lokasyon> robotadim=new ArrayList<>();
    ArrayList<Lokasyon> matris = new ArrayList<>();//harita full label koordinat
    //ArrayList<Lokasyon> yol = new ArrayList<>();//harita full label koordinat
    ArrayList<Lokasyon> k = new ArrayList<>();
    public Problem2(Izgara izgara1,Engel engel1,Robot robot1,Lokasyon baslangic1,Lokasyon bitis1){
        Fonksiyonlar asd=new Fonksiyonlar();
        izgara = izgara1;
        engel = engel1;
        robot = robot1;
        baslangic = baslangic1;
        bitis = bitis1;
        engel.setEngel4(new ArrayList<>());
        engel.setEngel2(new ArrayList<>());
        engel.setEngel3(new ArrayList<>());
        JPanel panel = new JPanel();
        add(panel);
        setSize(1000,800);
        setTitle("GEZGİN ROBOT");
        JLabel label = new JLabel();
        label.setBounds(0,0,1000,800);
        getContentPane().add(label);
        JLabel label1 = new JLabel("EN KISA YOL İÇİN E");
        label1.setFont(new Font((""), Font.BOLD, 20));
        label1.setBounds(900,50,300,20);
        getContentPane().add(label1);
        JLabel label2 = new JLabel("ROBOT HAREKET İÇİN R");
        label2.setFont(new Font((""), Font.BOLD, 20));
        label2.setBounds(900,100,300,20);
        getContentPane().add(label2);
        JLabel label3 = new JLabel("BUĞU KALDIRMAK İÇİN B");
        label3.setFont(new Font((""), Font.BOLD, 20));
        label3.setBounds(900,150,300,20);
        getContentPane().add(label3);
        JLabel label8= new JLabel("İKİNCİ EN KISA YOL İÇİN M");
        label8.setFont(new Font((""), Font.BOLD, 20));
        label8.setBounds(900,200,300,20);
        getContentPane().add(label8);
        JLabel label9= new JLabel("SONUÇ İÇİN K");
        label9.setFont(new Font((""), Font.BOLD, 20));
        label9.setBounds(900,250,300,20);
        getContentPane().add(label9);
        JLabel label10= new JLabel("OTOMATİK HAREKET İÇİN O");
        label10.setFont(new Font((""), Font.BOLD, 20));
        label10.setBounds(900,300,300,20);
        getContentPane().add(label10);
        JLabel label16= new JLabel("HARİTA ÇİZMEK İÇİN H");
        label16.setFont(new Font((""), Font.BOLD, 20));
        label16.setBounds(900,350,300,20);
        getContentPane().add(label16);
        JLabel[][] labirent = new JLabel[izgara.getSutun()][izgara.getSatir()];
        izgara.setlIzgara(new ArrayList<>());
        engel.setLengel(new ArrayList<>());
        for (int i = 0; i < izgara.getSutun(); i++) {
            for (int j = 0; j < izgara.getSatir(); j++) {
                izgara.getlIzgara().add(new Izgara());
                izgara.getlIzgara().get(izgara.getlIzgara().size()-1).setX(i);
                izgara.getlIzgara().get(izgara.getlIzgara().size()-1).setY(j);
            }
        }
        asd.LabirentOlusturma(labirent,matris,label,izgara);
        while(k.size()==0){
            for (Izgara a:izgara.getlIzgara()) {
                if(a.getX()==0 || a.getX()==izgara.getSutun()-1 || a.getY()==0 || a.getY()==izgara.getSatir()-1)
                {
                    engel.getLengel().add(new Engel());
                    engel.getLengel().get(engel.getLengel().size()-1).setX(a.getX());
                    engel.getLengel().get(engel.getLengel().size()-1).setY(a.getY());
                }
            }
            robot.setX(baslangic.getX());
            robot.setY(baslangic.getY());
            engel.getLengel().add(new Engel());
            engel.getLengel().get(engel.getLengel().size()-1).setX(baslangic.getX());
            engel.getLengel().get(engel.getLengel().size()-1).setY(baslangic.getY());
            robotko.add(new Lokasyon());
            robotko.get(robotko.size()-1).setX(robot.getX());
            robotko.get(robotko.size()-1).setY(robot.getY());
            Random random = new Random();
            int sx=0,sy=0,esyc=0,a=0,b=0,c=0,d=0;
            // rastgele engel yerleştirme
            while (engel.getLengel().size() < ((izgara.getSutun() * izgara.getSatir())/2)) {
                sx=random.nextInt(izgara.getSutun());
                sy=random.nextInt(izgara.getSatir());
                if(sx==robot.getX()-2 && sy==robot.getY())
                    a++;
                if(sx==robot.getX()+2 && sy==robot.getY())
                    b++;
                if(sx==robot.getX()-1 && sy==robot.getY()+1)
                    c++;
                if(sx==robot.getX()+1 && sy==robot.getY()-1)
                    d++;
                for (Engel e : engel.getLengel()) {
                    if(e.getX()==sx && e.getY()==sy)
                        esyc++;
                }
                if(esyc==0 && a==0 && b==0&& c==0 && d==0)
                {
                   // System.out.println("engel oluşturuluyor");
                    engel.getLengel().add(new Engel());
                    engel.getLengel().get(engel.getLengel().size()-1).setX(sx);
                    engel.getLengel().get(engel.getLengel().size()-1).setY(sy);
                }
                esyc=0;
                a=0;
                b=0;
                c=0;
                d=0;
            }
            for (int i = 0; i < engel.getLengel().size(); i++) {
                if(engel.getLengel().get(i).getX()==baslangic.getX() && engel.getLengel().get(i).getY()==baslangic.getY())
                    engel.getLengel().remove(i);
                if(engel.getLengel().get(i).getX()==bitis.getX() && engel.getLengel().get(i).getY()==bitis.getY())
                    engel.getLengel().remove(i);
            }
            //labirent[baslangic.getX()][baslangic.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/bh.png"))));
            //labirent[bitis.getX()][bitis.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/h.png"))));
            for (Engel e : engel.getLengel()) {
                //System.out.println(e.getX()+" engeller "+e.getY());
               // labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/s.jpg"))));
            }
            int say=0;
            for (int i = 0; i < izgara.getlIzgara().size(); i++) {
                for (int j = 0; j < engel.getLengel().size(); j++) {
                    if(izgara.getlIzgara().get(i).getX()==engel.getLengel().get(j).getX() && izgara.getlIzgara().get(i).getY()==engel.getLengel().get(j).getY()){
                        say++;
                    }
                }
                if(say==0){
                    //System.out.println("yolgecis ekleniyor");
                    yolgecis.add(new Lokasyon());
                    yolgecis.get(yolgecis.size() - 1).setX(izgara.getlIzgara().get(i).getX());
                    yolgecis.get(yolgecis.size() - 1).setY(izgara.getlIzgara().get(i).getY());
                }
                say=0;
            }

            int[][] matris2=new int[izgara.getSatir()][izgara.getSutun()];

            for (int i=0;i<izgara.getSatir();i++)
            {
                for(int j=0;j<izgara.getSutun();j++)
                {
                    matris2[i][j]=1;
                }
            }
            for (int i=0;i<izgara.getSatir();i++)
            {
                for(int j=0;j<izgara.getSutun();j++)
                {
                    for (Engel e: engel.getLengel()) {
                        if(j==e.getX() && i==e.getY() ){
                           // System.out.println("engel bulundu");
                            matris2[i][j]=0;
                        }
                    }
                }
            }
            Uygulama a1=new Uygulama(); // en kısa yol koordinatlarını verir
            int[] baslangic_koordinatlari = {baslangic.getY(), baslangic.getX()};
            int[] bitis_koordinatlari = {bitis.getY(), bitis.getX()};
            k=a1.enKisaYol(matris2,baslangic_koordinatlari,bitis_koordinatlari);
            if(k.size()==0){
                engel.getLengel().clear();
                robotko.clear();
                yolgecis.clear();
            }
        }
        final ArrayList<Lokasyon>[] kakak = new ArrayList[]{new ArrayList<>()};
        JLabel  label4 = new JLabel("EN KISA YOL UZUNLUĞU "+(k.size()-1));
        label4.setFont(new Font((""), Font.BOLD, 20));
        label4.setBounds(900,400,300,20);
        getContentPane().add(label4);
        JLabel label11 = new JLabel("İKİNCİ EN KISA YOL"+ String.valueOf(kakak[0].size()-1));
        label11.setFont(new Font((""), Font.BOLD, 20));
        label11.setBounds(900,450,300,20);
        getContentPane().add(label11);
        JLabel label19= new JLabel("ROBOT TOPLAM ADIM "+String.valueOf(robotko.size()-1));
        label19.setFont(new Font((""), Font.BOLD, 20));
        label19.setBounds(900,500,300,20);
        getContentPane().add(label19);
        JLabel label20= new JLabel("GEZİLEN KARE ");
        label20.setFont(new Font((""), Font.BOLD, 20));
        label20.setBounds(900,550,300,20);
        getContentPane().add(label20);
        JLabel bos = new JLabel();
        getContentPane().add(bos);
        ///////////////////////////////
        // en kısa yol uzunluğunun kaç birim olduğunu bulur
        ArrayList<Lokasyon> finalK = k;
        asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    int a=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()+1==b.getX() && robot.getY()==b.getY())
                            a++;
                    }
                    if(a==0){
                        robot.setX(robot.getX()+1);
                        int k=0;
                        for (Lokasyon b:robotko) {
                            if(robot.getX()+1==b.getX() && robot.getY()==b.getY())
                                k++;
                        }
                        if(k==0){
                            robotko.add(new Lokasyon());
                            robotko.get(robotko.size()-1).setX(robot.getX());
                            robotko.get(robotko.size()-1).setY(robot.getY());
                        }
                    }
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    int a=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()-1==b.getX() && robot.getY()==b.getY())
                            a++;
                    }
                    if(a==0){
                        robot.setX(robot.getX()-1);
                        int k=0;
                        for (Lokasyon b:robotko) {
                            if(robot.getX()-1==b.getX() && robot.getY()==b.getY())
                                k++;
                        }
                        if(k==0){
                            robotko.add(new Lokasyon());
                            robotko.get(robotko.size()-1).setX(robot.getX());
                            robotko.get(robotko.size()-1).setY(robot.getY());
                        }
                    }
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    int a=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()==b.getX() && robot.getY()+1==b.getY())
                            a++;
                    }
                    if(a==0){
                        robot.setY(robot.getY()+1);
                        int k=0;
                        for (Lokasyon b:robotko) {
                            if(robot.getX()==b.getX() && robot.getY()+1==b.getY())
                                k++;
                        }
                        if(k==0){
                            robotko.add(new Lokasyon());
                            robotko.get(robotko.size()-1).setX(robot.getX());
                            robotko.get(robotko.size()-1).setY(robot.getY());
                        }
                    }
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_UP){
                    int a=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()==b.getX() && robot.getY()-1==b.getY())
                            a++;
                    }
                    if(a==0){
                        robot.setY(robot.getY()-1);
                        int k=0;
                        for (Lokasyon b:robotko) {
                            if(robot.getX()==b.getX() && robot.getY()-1==b.getY())
                                k++;
                        }
                        if(k==0){
                            robotko.add(new Lokasyon());
                            robotko.get(robotko.size()-1).setX(robot.getX());
                            robotko.get(robotko.size()-1).setY(robot.getY());
                        }
                    }
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_E){
                    asd.enkisayoluciz(labirent,baslangic,bitis,robot,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_M){
                    asd.ikincienkisayoluciz(labirent,baslangic,bitis,robot,kakak[0]);
                }
                else if(e.getKeyCode()==KeyEvent.VK_R){
                    asd.robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_B){
                    asd.bugukaldir(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_H){
                    asd.haritaciz(labirent, izgara, engel, baslangic, bitis, robot, matris, robotko, finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_O){
                    robotadim=asd.problem2deneme(labirent,baslangic,bitis,izgara,robotko,engel,robot,matris,finalK,kakak,robotadim);
                    label19.setText("ROBOT TOPLAM ADIM "+String.valueOf(robotadim.size()-1));
                    int d=0;
                    for (Lokasyon k:robotadim) {
                        for (Lokasyon t:robotko1) {
                            if(k.getX()==t.getX() && k.getY()==t.getY()){
                                d++;
                            }
                        }
                        if(d==0){
                            robotko1.add(new Lokasyon());
                            robotko1.get(robotko1.size() - 1).setX(k.getX());
                            robotko1.get(robotko1.size() - 1).setY(k.getY());
                        }
                        d=0;
                    }
                    label20.setText("GEZİLEN KARE "+String.valueOf(robotko1.size()-1));
                    label11.setText("İKİNCİ EN KISA YOL:"+String.valueOf(kakak[0].size()-1) );
                }
                else if(e.getKeyCode()==KeyEvent.VK_K){
                    asd.problem2hareket(labirent,baslangic,bitis,izgara,robotko,engel,robot,matris,finalK,kakak);
                    label19.setText("ROBOT TOPLAM ADIM "+String.valueOf(robotko.size()-1));
                    int d=0;
                    for (Lokasyon k:robotko) {
                        for (Lokasyon t:robotko1) {
                            if(k.getX()==t.getX() && k.getY()==t.getY()){
                                d++;
                            }
                        }
                        if(d==0){
                            robotko1.add(new Lokasyon());
                            robotko1.get(robotko1.size() - 1).setX(k.getX());
                            robotko1.get(robotko1.size() - 1).setY(k.getY());
                        }
                        d=0;
                    }
                    label20.setText("GEZİLEN KARE "+String.valueOf(robotko1.size()-1));
                    System.out.println("haritaçiziliyor--------------------------------------------------");
                    asd.haritaciz(labirent, izgara, engel, baslangic, bitis, robot, matris, robotko1, finalK);
                    label11.setText("İKİNCİ EN KISA YOL:"+String.valueOf(kakak[0].size()-1) );
                }
            }
        });
    }
}