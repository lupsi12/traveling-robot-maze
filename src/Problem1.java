import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Timer;
public class Problem1 extends JFrame {
    public Problem1(String dosya) throws IOException {
        Fonksiyonlar asd=new Fonksiyonlar();
        Engel engel = new Engel();
        Izgara izgara = new Izgara();
        Robot robot = new Robot();
        izgara.setlIzgara(new ArrayList<>());
        engel.setLengel(new ArrayList<>());
        engel.setEngel1(new ArrayList<>());
        engel.setEngel2(new ArrayList<>());
        engel.setEngel3(new ArrayList<>());
        Lokasyon baslangic = new Lokasyon();
        Lokasyon bitis = new Lokasyon();
        ArrayList<Lokasyon> matris = new ArrayList<>();//harita full label koordinat
        ArrayList<Lokasyon> k=new ArrayList<>();
        ArrayList<Lokasyon> robotko1 = new ArrayList<>();
        final ArrayList<Lokasyon>[] robotadim = new ArrayList[]{new ArrayList<>()};
        final ArrayList<Lokasyon>[] robotadim2 = new ArrayList[]{new ArrayList<>()};
        final ArrayList<Lokasyon>[] kakak = new ArrayList[]{new ArrayList<>()};
        ArrayList<Lokasyon> robotko=new ArrayList<>();
        JPanel panel = new JPanel();
        add(panel);
        setSize(1000,800);
        setTitle("GEZGİN ROBOT");
        JLabel label = new JLabel();
        label.setBounds(0,0,1000,800);
        getContentPane().add(label);
        JLabel label1 = new JLabel("EN KISA YOL İÇİN E");
        label1.setFont(new Font((""), Font.BOLD, 20));
        label1.setBounds(700,50,300,20);
        getContentPane().add(label1);
        JLabel label2 = new JLabel("ROBOT HAREKET İÇİN R");
        label2.setFont(new Font((""), Font.BOLD, 20));
        label2.setBounds(700,100,300,20);
        getContentPane().add(label2);
        JLabel label3 = new JLabel("BUĞU KALDIRMAK İÇİN B");
        label3.setFont(new Font((""), Font.BOLD, 20));
        label3.setBounds(700,150,300,20);
        getContentPane().add(label3);
        JLabel label8= new JLabel("İKİNCİ EN KISA YOL İÇİN M");
        label8.setFont(new Font((""), Font.BOLD, 20));
        label8.setBounds(700,200,300,20);
        getContentPane().add(label8);
        JLabel label9= new JLabel("SONUÇ İÇİN K");
        label9.setFont(new Font((""), Font.BOLD, 20));
        label9.setBounds(700,250,300,20);
        getContentPane().add(label9);
        JLabel label10= new JLabel("OTOMATİK HAREKET İÇİN O");
        label10.setFont(new Font((""), Font.BOLD, 20));
        label10.setBounds(700,300,300,20);
        getContentPane().add(label10);
        JLabel label16= new JLabel("HARİTA ÇİZMEK İÇİN H");
        label16.setFont(new Font((""), Font.BOLD, 20));
        label16.setBounds(700,350,300,20);
        getContentPane().add(label16);
        BufferedReader br = null;
        try {
            URL url = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/"+dosya);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        String line;
        int satir=1,sutun=0,sutun1=1;
        while ((line=br.readLine())!=null){
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i)=='0'){
                    izgara.getlIzgara().add(new Izgara());
                    izgara.getlIzgara().get(izgara.getlIzgara().size()-1).setX(sutun1);
                    izgara.getlIzgara().get(izgara.getlIzgara().size()-1).setY(satir);
                }
                else if(line.charAt(i)=='1'){
                    engel.getLengel().add(new Engel());
                    engel.getLengel().get(engel.getLengel().size()-1).setX(sutun1);
                    engel.getLengel().get(engel.getLengel().size()-1).setY(satir);
                    engel.getEngel1().add(new Engel());
                    engel.getEngel1().get(engel.getEngel1().size()-1).setX(sutun1);
                    engel.getEngel1().get(engel.getEngel1().size()-1).setY(satir);
                }
                else if(line.charAt(i)=='2'){
                    engel.getEngel2().add(new Engel());
                    engel.getEngel2().get(engel.getEngel2().size()-1).setX(sutun1);
                    engel.getEngel2().get(engel.getEngel2().size()-1).setY(satir);
                }
                else if(line.charAt(i)=='3'){
                    engel.getEngel3().add(new Engel());
                    engel.getEngel3().get(engel.getEngel3().size()-1).setX(sutun1);
                    engel.getEngel3().get(engel.getEngel3().size()-1).setY(satir);
                }
                sutun1++;
            }
            sutun=line.length();
            sutun1=1;
            satir++;
        }
        for (int i = 0; i < satir+1; i++) {
            engel.getLengel().add(new Engel());
            engel.getLengel().get(engel.getLengel().size()-1).setX(0);
            engel.getLengel().get(engel.getLengel().size()-1).setY(i);
            engel.getLengel().add(new Engel());
            engel.getLengel().get(engel.getLengel().size()-1).setX(sutun+1);
            engel.getLengel().get(engel.getLengel().size()-1).setY(i);
        }
        for (int i = 0; i < sutun+1; i++) {
            engel.getLengel().add(new Engel());
            engel.getLengel().get(engel.getLengel().size()-1).setX(i);
            engel.getLengel().get(engel.getLengel().size()-1).setY(0);
            engel.getLengel().add(new Engel());
            engel.getLengel().get(engel.getLengel().size()-1).setX(i);
            engel.getLengel().get(engel.getLengel().size()-1).setY(satir);
        }
        System.out.println("engel şekillendiriliyor");
        asd.SekilIkiOlustur(engel);
        System.out.println("engel şekillendirildi");
        System.out.println("başlangıç bitiş belirleniyor");
        asd.BaslangicBitisRastgeleBelirle(baslangic,bitis,engel,satir,sutun);
        System.out.println("başlangıç bitiş belirlendi");
        izgara.setSutun(sutun+2);
        izgara.setSatir(satir+1);
        robot.setX(baslangic.getX());
        robot.setY(baslangic.getY());
        robotko.add(new Lokasyon());
        robotko.get(robotko.size()-1).setX(robot.getX());
        robotko.get(robotko.size()-1).setY(robot.getY());
        JLabel[][] labirent=new JLabel[izgara.getSutun()][izgara.getSatir()];
        asd.LabirentOlusturma(labirent,matris,label,izgara);
        int[][] matris2=new int[izgara.getSatir()][izgara.getSutun()];
        asd.TumEnkisaYol(matris2,izgara,engel);
        ////////////////////////////
        Uygulama a1=new Uygulama(); // en kısa yol koordinatlarını verir
        int[] start = {baslangic.getY(), baslangic.getX()};
        int[] end = {bitis.getY(), bitis.getX()};
        System.out.print("case 1: ");
        k=a1.enKisaYol(matris2,start,end);
        System.out.println("k boyut "+k.size());
        JLabel  label4 = new JLabel("EN KISA YOL UZUNLUĞU "+(k.size()-1));
        label4.setFont(new Font((""), Font.BOLD, 20));
        label4.setBounds(700,400,300,20);
        getContentPane().add(label4);
        JLabel label11 = new JLabel("İKİNCİ EN KISA YOL"+ String.valueOf(kakak[0].size()-1));
        label11.setFont(new Font((""), Font.BOLD, 20));
        label11.setBounds(700,450,300,20);
        getContentPane().add(label11);
        JLabel label19= new JLabel("ROBOT TOPLAM ADIM "+String.valueOf(robotko.size()-1));
        label19.setFont(new Font((""), Font.BOLD, 20));
        label19.setBounds(700,500,300,20);
        getContentPane().add(label19);
        JLabel label20= new JLabel("GEZİLEN KARE ");
        label20.setFont(new Font((""), Font.BOLD, 20));
        label20.setBounds(700,550,300,20);
        getContentPane().add(label20);
        JLabel bos = new JLabel();
        getContentPane().add(bos);
        ArrayList<Lokasyon> finalK = k;
        asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
            }
            @Override
            public void keyReleased(KeyEvent e){
            }
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    int a=0,m=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()+1==b.getX() && robot.getY()==b.getY())
                            a++;
                    }
                    for (Lokasyon b:matris) {
                        if(robot.getX()+1==b.getX() && robot.getY()==b.getY())
                            m++;
                    }
                    if(a==0 && m!=0){
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
                    asd.robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    int a=0,m=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()-1==b.getX() && robot.getY()==b.getY())
                            a++;
                    }
                    for (Lokasyon b:matris) {
                        if(robot.getX()-1==b.getX() && robot.getY()==b.getY())
                            m++;
                    }
                    if(a==0 && m!=0){
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
                    asd.robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    int a=0,m=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()==b.getX() && robot.getY()+1==b.getY())
                            a++;
                    }
                    for (Lokasyon b:matris) {
                        if(robot.getX()==b.getX() && robot.getY()+1==b.getY())
                            m++;
                    }
                    if(a==0 && m!=0){
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
                        }}
                    asd.robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                }
                else if(e.getKeyCode()==KeyEvent.VK_UP){
                    int a=0,m=0;
                    for (Engel b:engel.getLengel()) {
                        if(robot.getX()==b.getX() && robot.getY()-1==b.getY())
                            a++;
                    }
                    for (Lokasyon b:matris) {
                        if(robot.getX()==b.getX() && robot.getY()-1==b.getY())
                            m++;
                    }
                    if(a==0 && m!=0){
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
                    asd.robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
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
                    robotadim2[0] =asd.deneme(labirent,baslangic,bitis,izgara,robotko,engel,robot,matris,finalK,kakak, robotadim2[0]);
                     label19.setText("ROBOT TOPLAM ADIM "+String.valueOf(robotadim2[0].size()-1));
                     ArrayList<Lokasyon> robotko3 = new ArrayList<>();
                    int d=0;
                    for (Lokasyon k: robotadim2[0]) {
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
                    asd.sonuchareket(labirent,baslangic,bitis,izgara,robotko,engel,robot,matris,finalK,kakak);
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
                    asd.haritaciz(labirent, izgara, engel, baslangic, bitis, robot, matris, robotko1, finalK);
                    label11.setText("İKİNCİ EN KISA YOL:"+String.valueOf(kakak[0].size()-1) );
                }
            }
        });
    }
}