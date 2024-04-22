import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Timer;
public class Fonksiyonlar {
    ArrayList<Lokasyon> bugu = new ArrayList<>();
    public void LabirentOlusturma(JLabel[][] labirent, ArrayList<Lokasyon> matris, JLabel label, Izgara izgara) {
        for (int i = 0; i < izgara.getSutun(); i++) {
            for (int j = 0; j < izgara.getSatir(); j++) {
                labirent[i][j] = new JLabel();
                labirent[i][j].setBounds(50 + 21 * i, 40 + 21 * j, 20, 20);
                label.add(labirent[i][j]);
                matris.add(new Lokasyon());
                matris.get(matris.size() - 1).setX(i);
                matris.get(matris.size() - 1).setY(j);
            }
        }
    }
    public void bugukaldir(JLabel[][] labirent, Izgara izgara, Engel engel, Lokasyon baslangic, Lokasyon bitis, Robot robot, ArrayList<Lokasyon> yol, ArrayList<Lokasyon> robotko, ArrayList<Lokasyon> k) {
        for (Lokasyon i : yol) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/g.jpg"))));
        }
        for (Engel e : engel.getEngel3()) {
            labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/hh.png"))));
        }
        for (Engel e : engel.getEngel2()) {
            labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/t.png"))));
        }
        for (Lokasyon i : robotko) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/y.png"))));
        }
        for (Lokasyon i : k) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/pembe1.png"))));
        }
        labirent[baslangic.getX()][baslangic.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/bh.png"))));
        labirent[bitis.getX()][bitis.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/h.png"))));
        for (Engel e : engel.getLengel()) {
            labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/s.jpg"))));
        }
        labirent[robot.getX()][robot.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/k.jpg"))));
    }
    public void enkisayoluciz(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Robot robot, ArrayList<Lokasyon> k) {
        for (Lokasyon i : k) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/pembe1.png"))));
        }
        labirent[baslangic.getX()][baslangic.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/bh.png"))));
        labirent[bitis.getX()][bitis.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/h.png"))));
        labirent[robot.getX()][robot.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/k.jpg"))));
    }
    public ArrayList<Lokasyon> haritabugula(Robot robot) {
        bugu.add(new Lokasyon());
        bugu.get(bugu.size() - 1).setX(robot.getX());
        bugu.get(bugu.size() - 1).setY(robot.getY());
        bugu.add(new Lokasyon());
        bugu.get(bugu.size() - 1).setX(robot.getX() + 1);
        bugu.get(bugu.size() - 1).setY(robot.getY());
        bugu.add(new Lokasyon());
        bugu.get(bugu.size() - 1).setX(robot.getX());
        bugu.get(bugu.size() - 1).setY(robot.getY() + 1);
        bugu.add(new Lokasyon());
        bugu.get(bugu.size() - 1).setX(robot.getX() - 1);
        bugu.get(bugu.size() - 1).setY(robot.getY());
        bugu.add(new Lokasyon());
        bugu.get(bugu.size() - 1).setX(robot.getX());
        bugu.get(bugu.size() - 1).setY(robot.getY() - 1);
        return bugu;
    }
    public void haritaciz(JLabel[][] labirent, Izgara izgara, Engel engel, Lokasyon baslangic, Lokasyon bitis, Robot robot, ArrayList<Lokasyon> yol, ArrayList<Lokasyon> robotko, ArrayList<Lokasyon> k) {
        bugu = haritabugula(robot);
        for (Lokasyon i : yol) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/s.png"))));
        }
        for (Lokasyon i : yol) {
            for (Lokasyon l : bugu) {
                if (i.getX() == l.getX() && i.getY() == l.getY())
                    labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/g.jpg"))));
            }
        }
        for (Engel e : engel.getEngel2()) {
            for (Lokasyon l : bugu) {
                if (e.getX() == l.getX() && e.getY() == l.getY())
                    labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/t.png"))));
            }
        }
        for (Engel e : engel.getEngel3()) {
            for (Lokasyon l : bugu) {
                if (e.getX() == l.getX() && e.getY() == l.getY())
                    labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/hh.png"))));
            }
        }
        for (Lokasyon e : robotko) {
            for (Lokasyon l : bugu) {
                if (e.getX() == l.getX() && e.getY() == l.getY())
                    labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/y.png"))));
            }
        }
        for (Lokasyon e : k) {
            for (Lokasyon l : bugu) {
                if (e.getX() == l.getX() && e.getY() == l.getY())
                    labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/pembe1.png"))));
            }
        }
        for (Engel e : engel.getLengel()) {
            for (Lokasyon l : bugu) {
                if (e.getX() == l.getX() && e.getY() == l.getY())
                    labirent[e.getX()][e.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/s.jpg"))));
            }
        }
        labirent[baslangic.getX()][baslangic.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/bh.png"))));
        labirent[bitis.getX()][bitis.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/h.png"))));
        labirent[robot.getX()][robot.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/k.jpg"))));
        if (robot.getX() == bitis.getX() && robot.getY() == bitis.getY()) {
            Kazankaybet arayuz = new Kazankaybet(robot, bitis);
            arayuz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            arayuz.setVisible(true);
        }
    }
    public void IkinciEnKisa(Izgara izgara, ArrayList<Lokasyon> bugu, Engel engel, Lokasyon baslangic, Lokasyon bitis, ArrayList<Lokasyon>[] kakak) {
        ArrayList<Lokasyon> haritaacilan = new ArrayList<>();
        for (Engel e : engel.getLengel()) {
            for (Lokasyon ab : bugu) {
                if (ab.getX() == e.getX() && ab.getY() == e.getY()) {
                    haritaacilan.add(new Lokasyon());
                    haritaacilan.get(haritaacilan.size() - 1).setX(ab.getX());
                    haritaacilan.get(haritaacilan.size() - 1).setY(ab.getY());
                }
            }

        }
        int[][] matrisacilan = new int[izgara.getSatir()][izgara.getSutun()];
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                matrisacilan[i][j] = 0;
            }
        }
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                for (Lokasyon e : bugu) {
                    if (j == e.getX() && i == e.getY()) {
                        matrisacilan[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                for (Lokasyon e : haritaacilan) {
                    if (j == e.getX() && i == e.getY()) {
                        matrisacilan[i][j] = 0;
                    }
                }
            }
        }
        System.out.println("matrisaçilam");
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                System.out.print(matrisacilan[i][j]);

            }
            System.out.println();
        }
        Uygulama a1 = new Uygulama(); // en kısa yol koordinatlarını verir
        int[] start = {baslangic.getY(), baslangic.getX()};
        int[] end = {bitis.getY(), bitis.getX()};
        long start3 = System.nanoTime();
        kakak[0] = a1.enKisaYol(matrisacilan, start, end);
        long end3 = System.nanoTime();
        long execution = end3 - start3;
        long asks = execution / 1000000000;
        System.out.println("toplam  nanasure: " + execution + " nanoseconds");
        System.out.println(kakak[0].size()+"kakak[0].size");
    }
    public void ikincienkisayoluciz(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Robot robot, ArrayList<Lokasyon> kakak) {
        for (Lokasyon i : kakak) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/mavi.png"))));
        }
        labirent[baslangic.getX()][baslangic.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/bh.png"))));
        labirent[bitis.getX()][bitis.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/h.png"))));
        labirent[robot.getX()][robot.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/k.jpg"))));
    }
    public void robothareketciz(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Robot robot, ArrayList<Lokasyon> robotko, ArrayList<Lokasyon> fk) {
        for (Lokasyon i : robotko) {
            labirent[i.getX()][i.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/y.png"))));
        }
        try (FileWriter fw = new FileWriter("bilgi.txt")) {
            fw.write("ROBOT EN KISA YOL ");
            fw.write(fk.size() - 1 + "\n");
            fw.write("ROBOT HAREKET KOORDİNATLARI\n");
            for (Lokasyon a : robotko) {
                fw.write(a.getX() + "," + a.getY() + "\n");
            }
            fw.write("EN KISA YOL KOORDİNATLARI\n");
            for (Lokasyon ab : fk) {
                fw.write(ab.getX() + "," + ab.getY() + "\n");
            }
        } catch (IOException e) {
            System.out.println("error ");

        }
        labirent[baslangic.getX()][baslangic.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/bh.png"))));
        labirent[bitis.getX()][bitis.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/h.png"))));
        labirent[robot.getX()][robot.getY()].setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/k.jpg"))));
    }
    public void TumEnkisaYol(int[][] matris2, Izgara izgara, Engel engel) {
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                matris2[i][j] = 1;
            }
        }
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                for (Engel e : engel.getLengel()) {
                    if (j == e.getX() && i == e.getY()) {
                        matris2[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                System.out.print(matris2[i][j]);
            }
            System.out.println();
        }
    }
    public void sonuchareket(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Izgara izgara,ArrayList<Lokasyon> robotko, Engel engel,Robot robot,ArrayList <Lokasyon>matris,ArrayList<Lokasyon>finalK,ArrayList<Lokasyon>[] kakak) {
        Random random = new Random();
        int xo = 0, yo = 0, rastgele = 0, kntrl = 0, a = 0, m = 0, k = 0,t=0,y=0;
        while (kntrl == 0) {
            rastgele = random.nextInt(4);
            switch (rastgele) {
                case 0://sağ
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() + 1 == b.getX() && robot.getY() == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() + 1 == b.getX() && robot.getY() == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){ // geldiği yere geri dönmesinn
                        if(robotko.get(robotko.size()-2).getX()==robot.getX()+1 && robotko.get(robotko.size()-2).getY()==robot.getY() ){
                            k++;
                        }
                    }
                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()-1==e.getY())
                            t++;
                        if((robot.getX()==e.getX() && robot.getY()+1==e.getY()))
                            t++;
                        if(robot.getX()-1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            k=0;
                            y++;
                            System.out.println(t+" sağ engel kaldır");
                        }

                    }
                    if (a == 0 && m != 0 && k==0) {
                        robot.setX(robot.getX() + 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    y = 0;
                    break;
                case 1://sol
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() - 1 == b.getX() && robot.getY() == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() - 1 == b.getX() && robot.getY() == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){
                        if(robotko.get(robotko.size()-2).getX()==robot.getX()-1 && robotko.get(robotko.size()-2).getY()==robot.getY() ){
                            k++;
                        }
                    }

                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()-1==e.getY())
                            t++;
                        if((robot.getX()==e.getX() && robot.getY()+1==e.getY()))
                            t++;
                        if(robot.getX()+1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            k=0;
                            y++;
                             System.out.println(t+" sol engel kaldır");
                        }

                    }

                    if (a == 0 && m != 0 && k==0 ) {
                        robot.setX(robot.getX() - 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    y = 0;
                    break;
                case 2://aşağı
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() == b.getX() && robot.getY() + 1 == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() == b.getX() && robot.getY() + 1 == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){
                        if(robotko.get(robotko.size()-2).getX()==robot.getX() && robotko.get(robotko.size()-2).getY()==robot.getY() +1){
                            k++;
                        }

                    }

                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()-1==e.getY())
                            t++;
                        if((robot.getX()+1==e.getX() && robot.getY()==e.getY()))
                            t++;
                        if(robot.getX()-1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            k=0;
                            y++;
                            System.out.println(t+" aşağı engel kaldır");
                        }
                    }
                    if (a == 0 && m != 0 && k==0 ) {
                        robot.setY(robot.getY() + 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    y = 0;
                    break;
                case 3://yukarı
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() == b.getX() && robot.getY() - 1 == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() == b.getX() && robot.getY() - 1 == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){
                        if(robotko.get(robotko.size()-2).getX()==robot.getX() && robotko.get(robotko.size()-2).getY()==robot.getY()-1 ){
                            k++;
                        }
                    }

                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()+1==e.getY())
                            t++;
                        if((robot.getX()-1==e.getX() && robot.getY()==e.getY()))
                            t++;
                        if(robot.getX()+1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            k=0;
                            y++;
                            System.out.println(t+" yukarı engel kaldır");
                        }
                    }
                    if (a == 0 && m != 0 && k==0) {
                        robot.setY(robot.getY() - 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    y = 0;
                    break;
            }
            if (robot.getX() == bitis.getX() && robot.getY() == bitis.getY()) {
                kntrl++;
                ArrayList<Lokasyon> asf = haritabugula(robot);
                IkinciEnKisa(izgara, asf, engel, baslangic, bitis, kakak);
            }
        }
    }
    public  void  SekilIkiOlustur(Engel engel){
        ArrayList<Lokasyon> sekil = new ArrayList<>();
        ArrayList<Lokasyon> sekilkontrol = new ArrayList<>();
        int sekilturu=0,kntrl=0;
        Random random = new Random();
        for(Engel e:engel.getEngel2()){
            for (Lokasyon a:sekilkontrol) {
                if(a.getX()==e.getX() && a.getY()==e.getY()){
                    kntrl++;
                }
            }
            if(kntrl==0){
                sekilturu = random.nextInt(9);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX());
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY());
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+1);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY());
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX());
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+1);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+1);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+1);
                switch (sekilturu) {
                    case 0:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 1:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 2:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 3:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 4:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 5:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());;
                        break;
                    case 6:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 7:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 8:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                }
            }
            kntrl=0;
        }
        for(Engel e:engel.getEngel3()){
            for (Lokasyon a:sekilkontrol) {
                if(a.getX()==e.getX() && a.getY()==e.getY()){
                    kntrl++;
                }
            }
            if(kntrl==0){
                sekilturu = random.nextInt(14);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX());
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY());
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+1);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY());
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+2);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY());
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX());
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+1);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+1);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+1);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+2);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+1);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX());
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+2);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+1);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+2);
                sekilkontrol.add(new Lokasyon());
                sekilkontrol.get(sekilkontrol.size()-1).setX(e.getX()+2);
                sekilkontrol.get(sekilkontrol.size()-1).setY(e.getY()+2);
                switch (sekilturu) {
                    case 0:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 1:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 2:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 3:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 4:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 5:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 6:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 7:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 8:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;
                    case 9:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        break;

                    case 10:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        break;
                    case 11:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        break;
                    case 12:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY()+2);
                        sekil.add(new Lokasyon());
                        break;
                    case 13:
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX());
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+2);
                        sekil.get(sekil.size()-1).setY(e.getY());
                        sekil.add(new Lokasyon());
                        sekil.get(sekil.size()-1).setX(e.getX()+1);
                        sekil.get(sekil.size()-1).setY(e.getY()+1);
                        sekil.add(new Lokasyon());
                        break;
                }
            }
            kntrl=0;
        }
        for (Lokasyon a:sekil) {
            engel.getLengel().add(new Engel());
            engel.getLengel().get(engel.getLengel().size()-1).setX(a.getX());
            engel.getLengel().get(engel.getLengel().size()-1).setY(a.getY());
        }
    }
    public void BaslangicBitisRastgeleBelirle(Lokasyon baslangic,Lokasyon bitis,Engel engel,int satir,int sutun){
      Random random =new Random();
        int yba=0,xba=0,ybi=0,xbi=0,krr=0,a=0,b=0,c=0;
        while(a==0){
            xba= random.nextInt(sutun);
            if(xba == 1 || xba == sutun) {
                yba = random.nextInt(satir);
                xbi = random.nextInt(sutun+1);
                if(xbi == 1 || xbi == sutun){
                    ybi = random.nextInt(satir);
                }
                else{
                    krr=random.nextInt(2);
                    switch (krr){
                        case 0:
                            ybi=1;
                            break;
                        case 1:
                            ybi=satir-1;
                            break;
                    }
                }
            }
            else{
                krr=random.nextInt(2);
                switch (krr){
                    case 0:
                        yba=1;
                        xbi = random.nextInt(sutun+1);
                        if(xbi == 1 || xbi == sutun){
                            ybi = random.nextInt(satir);
                        }
                        else{
                            krr=random.nextInt(2);
                            switch (krr){
                                case 0:
                                    ybi=1;
                                    break;
                                case 1:
                                    ybi=satir-1;
                                    break;
                            }
                        }
                        break;
                    case 1:
                        yba=satir-1;
                        xbi = random.nextInt(sutun+1);
                        if(xbi == 1 || xbi == sutun){
                            ybi = random.nextInt(satir);
                        }
                        else{
                            krr=random.nextInt(2);
                            switch (krr){
                                case 0:
                                    ybi=1;
                                    break;
                                case 1:
                                    ybi=satir-1;
                                    break;
                            }
                        }
                        break;
                }
            }
            for (Engel e:engel.getLengel()) {
                if(e.getX()==xba && e.getY()==yba){
                    b++;
                }
                if(e.getX()==xbi && e.getY()==ybi){
                    c++;
                }
            }
            if(xba!=xbi && yba!=ybi){
                System.out.println(b+" "+c);
                if(b==0 && c==0) {
                   System.out.println("başlangıç bitiş belirlendi");
                   baslangic.setX(xba);
                   baslangic.setY(yba);
                   bitis.setX(xbi);
                   bitis.setY(ybi);
                   a++;
            } }
            b=0;
            c=0;
        }
        /*

        */
    }
    public ArrayList<Lokasyon> deneme(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Izgara izgara,ArrayList<Lokasyon> robotko, Engel engel,Robot robot,ArrayList <Lokasyon>matris,ArrayList<Lokasyon>finalK,ArrayList<Lokasyon>[] kakak,ArrayList<Lokasyon> robotadim){
        ArrayList<Lokasyon> robotko1 = new ArrayList<>();
        robotko1.add(new Lokasyon());
        robotko1.get(robotko1.size()-1).setX(robot.getX());
        robotko1.get(robotko1.size()-1).setY(robot.getY());
        sonuchareket(labirent,baslangic,bitis,izgara,robotko1,engel,robot,matris,finalK,kakak);
        robotadim=robotko1;
        bugu.clear();
        java.util.Timer timer = new Timer();
        TimerTask gorev = new TimerTask() {
            @Override
            public void run() {
                robot.setX(robotko1.get(0).getX());
                robot.setY(robotko1.get(0).getY());
                robotko1.remove(0);
                robotko.add(new Lokasyon());
                robotko.get(robotko.size()-1).setX(robot.getX());
                robotko.get(robotko.size()-1).setY(robot.getY());
                haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                if (robot.getX() == bitis.getX() && robot.getY() == bitis.getY()) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(gorev,0,300);
        return robotadim;
    }
    public void problem2hareket(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Izgara izgara,ArrayList<Lokasyon> robotko, Engel engel,Robot robot,ArrayList <Lokasyon>matris,ArrayList<Lokasyon>finalK,ArrayList<Lokasyon>[] kakak) {
        Random random = new Random();
        int xo = 0, yo = 0, rastgele = 0, kntrl = 0, a = 0, m = 0, k = 0,t=0,y=0,z=0;
        while (kntrl == 0) {
            rastgele = random.nextInt(4);
            switch (rastgele) {
                case 0://sağ
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() + 1 == b.getX() && robot.getY() == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() + 1 == b.getX() && robot.getY() == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){ // geldiği yere geri dönmesinn
                        if(robotko.get(robotko.size()-2).getX()==robot.getX()+1 && robotko.get(robotko.size()-2).getY()==robot.getY() ){
                            k++;
                        }
                    }
                    if(robot.getX()+1==baslangic.getX() && robot.getY()==baslangic.getY()){
                        System.out.println("başa dönn sağğ");
                        z++;
                    }
                    if(z!=0){
                        k=0;
                    }
                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()-1==e.getY())
                            t++;
                        if((robot.getX()==e.getX() && robot.getY()+1==e.getY()))
                            t++;
                        if(robot.getX()-1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            y++;
                        }
                    }

                    if (a == 0 && m != 0 && k==0 && z==0) {
                        robot.setX(robot.getX() + 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);

                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    z = 0;
                    break;
                case 1://sol
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() - 1 == b.getX() && robot.getY() == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() - 1 == b.getX() && robot.getY() == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){
                        if(robotko.get(robotko.size()-2).getX()==robot.getX()-1 && robotko.get(robotko.size()-2).getY()==robot.getY() ){
                            k++;
                        }
                    }
                    if(robot.getX()-1==baslangic.getX() && robot.getY()==baslangic.getY()){
                        System.out.println("başa dönn bll sol");
                        z++;
                    }
                    if(z!=0){
                    k=0;
                    }
                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()-1==e.getY())
                            t++;
                        if((robot.getX()==e.getX() && robot.getY()+1==e.getY()))
                            t++;
                        if(robot.getX()+1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            y++;
                        }

                    }

                    if (a == 0 && m != 0 && k==0 && z==0) {
                        robot.setX(robot.getX() - 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    z = 0;
                    break;
                case 2://aşağı
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() == b.getX() && robot.getY() + 1 == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() == b.getX() && robot.getY() + 1 == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){
                        if(robotko.get(robotko.size()-2).getX()==robot.getX() && robotko.get(robotko.size()-2).getY()==robot.getY() +1){
                            k++;
                        }

                    }
                    if(robot.getX()==baslangic.getX() && robot.getY()+1==baslangic.getY() ){
                        System.out.println("başa dönn aşağı");
                        z++;
                    }
                    if(z!=0){
                        k=0;
                    }
                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()-1==e.getY())
                            t++;
                        if((robot.getX()+1==e.getX() && robot.getY()==e.getY()))
                            t++;
                        if(robot.getX()-1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            y++;
                        }
                    }
                    if (a == 0 && m != 0 && k==0 && z==0) {
                        robot.setY(robot.getY() + 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    z = 0;
                    break;
                case 3://yukarı
                    for (Engel b : engel.getLengel()) {
                        if (robot.getX() == b.getX() && robot.getY() - 1 == b.getY())
                            a++;
                    }
                    for (Lokasyon b : matris) {
                        if (robot.getX() == b.getX() && robot.getY() - 1 == b.getY())
                            m++;
                    }
                    if(robotko.size()>=2){
                        if(robotko.get(robotko.size()-2).getX()==robot.getX() && robotko.get(robotko.size()-2).getY()==robot.getY()-1 ){
                            k++;
                        }
                    }
                    if(robot.getX()==baslangic.getX() && robot.getY()-1==baslangic.getY() ){
                        System.out.println("başa dönn yukatı");
                        z++;
                    }
                    if(z!=0){
                        k=0;
                    }
                    for(Engel e:engel.getLengel()){
                        if(robot.getX()==e.getX() && robot.getY()+1==e.getY())
                            t++;
                        if((robot.getX()-1==e.getX() && robot.getY()==e.getY()))
                            t++;
                        if(robot.getX()+1==e.getX() && robot.getY()==e.getY())
                            t++;
                        if(t==3){
                            y++;
                        }
                    }
                    if (a == 0 && m != 0 && k==0 && z==0) {
                        robot.setY(robot.getY() - 1);
                        robotko.add(new Lokasyon());
                        robotko.get(robotko.size() - 1).setX(robot.getX());
                        robotko.get(robotko.size() - 1).setY(robot.getY());
                        robothareketciz(labirent,baslangic,bitis,robot,robotko,finalK);
                        haritabugula(robot);
                    }
                    a = 0;
                    m = 0;
                    k = 0;
                    t = 0;
                    z = 0;
                    break;
            }
            ArrayList<Lokasyon> deneme =new ArrayList<>();
            if(y!=0){
                for (Lokasyon f:finalK) {
                    for (int i = robotko.size()-1; i >=0; i--) {
                        if(f.getX()==robotko.get(i).getX() && f.getY()==robotko.get(i).getY()){
                            deneme.add(new Lokasyon());
                            deneme.get(deneme.size() - 1).setX(f.getX());
                            deneme.get(deneme.size() - 1).setY(f.getY());
                            break;
                        }
                    }
                }
                y=0;
                robot.setX(deneme.get(0).getX());
                robot.setY(deneme.get(0).getY());
                robotko.add(new Lokasyon());
                robotko.get(robotko.size() - 1).setX(deneme.get(0).getX());
                robotko.get(robotko.size() - 1).setY(deneme.get(0).getY());
                deneme.clear();
            }
            if (robot.getX() == bitis.getX() && robot.getY() == bitis.getY()) {
                kntrl++;
                ArrayList<Lokasyon> asf = haritabugula(robot);
                IkinciEnKisa(izgara, asf, engel, baslangic, bitis, kakak);
            }
        }
    }
    public ArrayList<Lokasyon> problem2deneme(JLabel[][] labirent, Lokasyon baslangic, Lokasyon bitis, Izgara izgara,ArrayList<Lokasyon> robotko, Engel engel,Robot robot,ArrayList <Lokasyon>matris,ArrayList<Lokasyon>finalK,ArrayList<Lokasyon>[] kakak,ArrayList<Lokasyon> robotadim){
        ArrayList<Lokasyon> robotko1 = new ArrayList<>();
        robotko1.add(new Lokasyon());
        robotko1.get(robotko1.size()-1).setX(robot.getX());
        robotko1.get(robotko1.size()-1).setY(robot.getY());
        Robot fakerobot= new Robot();
        fakerobot.setX(robot.getX());
        fakerobot.setY(robot.getY());
        problem2hareket(labirent,baslangic,bitis,izgara,robotko1,engel,fakerobot,matris,finalK,kakak);
        robotadim=robotko1;
        bugu.clear();
        java.util.Timer timer = new Timer();
        TimerTask gorev = new TimerTask() {
            @Override
            public void run() {
                robot.setX(robotko1.get(0).getX());
                robot.setY(robotko1.get(0).getY());
                robotko1.remove(0);
                robotko.add(new Lokasyon());
                robotko.get(robotko.size()-1).setX(robot.getX());
                robotko.get(robotko.size()-1).setY(robot.getY());
                haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);
                if (robot.getX() == bitis.getX() && robot.getY() == bitis.getY()) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(gorev,0,500);
        return robotadim;
    }

}