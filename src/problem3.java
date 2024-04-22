import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class problem3 extends JFrame {
    Izgara izgara = new Izgara();
    Robot robot = new Robot();
    Engel engel = new Engel();
    Lokasyon baslangic = new Lokasyon();
    Lokasyon bitis = new Lokasyon();
    ArrayList<Lokasyon> matris = new ArrayList<>();//harita full label koordinat
    ArrayList<Lokasyon> bugu = new ArrayList<>();
    ArrayList<Lokasyon> yolgecis = new ArrayList<>(); // robot hareket koordinatları engeller yok en kısa yoll
    ArrayList<Lokasyon> robotko = new ArrayList<>();
    ArrayList<Lokasyon> robotko1=new ArrayList<>();
    ArrayList<Lokasyon> robotadim=new ArrayList<>();
    ArrayList<Lokasyon> k = new ArrayList<>();
    ArrayList<Lokasyon> kakak = new ArrayList<>();
    public problem3(Izgara izgara1,Engel engel1,Robot robot1,Lokasyon baslangic1,Lokasyon bitis1) {
        Fonksiyonlar asd = new Fonksiyonlar();
        izgara = izgara1;
        engel = engel1;
        robot = robot1;
        baslangic = baslangic1;
        bitis = bitis1;
        engel.setEngel1(new ArrayList<>());
        engel.setEngel2(new ArrayList<>());
        engel.setEngel3(new ArrayList<>());
        JLabel[][] labirent = new JLabel[izgara.getSutun()][izgara.getSatir()];
        JPanel panel = new JPanel();
        add(panel);
        setSize(1000, 800);
        setTitle("GEZGİN ROBOT");
        JLabel label = new JLabel();
        label.setBounds(0, 0, 1000, 800);
        getContentPane().add(label);
        LabirentOlusturma maze1 = new LabirentOlusturma((izgara.getSutun()), (izgara.getSatir()));
        int[][] mazebos;
        int[][] maze = new int[izgara.getSatir()][izgara.getSutun()];
        while(k.size()==0){
        mazebos = maze1.generate();
        //System.out.println("----------------sınıftaki mazee---------------------");
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
               // System.out.print(mazebos[i][j] + " ");
                if (mazebos[i][j] == 1)
                    mazebos[i][j] = 0;
                else if (mazebos[i][j] == 0)
                    mazebos[i][j] = 1;
                if (i == izgara.getSatir() - 1 || j == izgara.getSutun() - 1) {
                    mazebos[i][j] = 0;
                }
            }
            System.out.println();
        }
      //  System.out.println("----------------mazee---------------------");
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                maze[i][j] = mazebos[i][j];
            }
        }
        //izgara.setSutun(maze[0].length);
        //izgara.setSatir(maze.length);
        System.out.println("-------------------------------------");
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
              //  System.out.print(maze[i][j]);
                if (j < izgara.getSutun() - 1)
                    System.out.print(" ");
            }
            System.out.print("\n");
        }

        //System.out.println("-------------------------------------");
        maze[baslangic.getY()][baslangic.getX()] = 4;
        maze[bitis.getY()][bitis.getX()] = 5;
        if(baslangic.getX()==0 && baslangic.getY()==1){
            System.out.println("1 kaldır");
           if(maze[1][2]==0)
               maze[1][2]=1;
            if(maze[2][1]==0)
                maze[2][1]=1;
        }
        else if(baslangic.getX()==izgara.getSutun()-1 && baslangic.getY()==1){
            if(maze[1][izgara.getSutun()-3]==0)
                maze[1][izgara.getSutun()-3]=1;
            if(maze[2][izgara.getSutun()-2]==0)
                maze[2][izgara.getSutun()-2]=1;
            }
        else if(baslangic.getX()==0 && baslangic.getY()==izgara.getSatir() - 2){
            if(maze[izgara.getSatir() - 2][2]==0)
                maze[izgara.getSatir() - 2][2]=1;
            if(maze[izgara.getSatir() - 3][1]==0)
                maze[izgara.getSatir() - 3][1]=1;
            }
        else if(baslangic.getX()==izgara.getSutun()-1 && baslangic.getY()==izgara.getSatir() - 2){
            if(maze[izgara.getSatir() - 2][izgara.getSutun()-3]==0)
                maze[izgara.getSatir() - 2][izgara.getSutun()-3]=1;
            if(maze[izgara.getSatir() - 3][izgara.getSutun()-2]==0)
                maze[izgara.getSatir() - 3][izgara.getSutun()-2]=1;
        }
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
               /*
               if(maze[i][j-2]==0)
                    maze[i][j-2]=1;
                if(maze[i][j+2]==0)
                    maze[i][j-2]=1;
                if(maze[i+1][j-1]==0)
                    maze[i+1][j-1]=1;
                if(maze[i-1][j+1]==0)
                    maze[i-1][j+1]=1;
                */
               // System.out.print(maze[i][j]);
                if (j < izgara.getSutun() - 1)
                    System.out.print(" ");
            }
            System.out.print("\n");
        }

        System.out.println("****************************");
        izgara.setlIzgara(new ArrayList<>());
        engel.setLengel(new ArrayList<>());
        for (int i = 0; i < izgara.getSatir(); i++) {
            for (int j = 0; j < izgara.getSutun(); j++) {
                if (maze[i][j] == 1) {
                    izgara.getlIzgara().add(new Izgara());
                    izgara.getlIzgara().get(izgara.getlIzgara().size() - 1).setX(j);
                    izgara.getlIzgara().get(izgara.getlIzgara().size() - 1).setY(i);
                    yolgecis.add(new Lokasyon());
                    yolgecis.get(yolgecis.size() - 1).setX(j);
                    yolgecis.get(yolgecis.size() - 1).setY(i);
                } else if (maze[i][j] == 0) {
                    engel.getLengel().add(new Engel());
                    engel.getLengel().get(engel.getLengel().size() - 1).setX(j);
                    engel.getLengel().get(engel.getLengel().size() - 1).setY(i);
                }

            }
        }
        System.out.println(izgara.getlIzgara().size());
        System.out.println(engel.getLengel().size());
        for (int j = 0; j < izgara.getlIzgara().size(); j++) {
            System.out.println(izgara.getlIzgara().get(j).getX() + " " + izgara.getlIzgara().get(j).getY());
        }
        robot.setX(baslangic.getX());
        robot.setY(baslangic.getY());
        asd.LabirentOlusturma(labirent, matris, label, izgara);
        robotko.add(new Lokasyon());
        robotko.get(robotko.size() - 1).setX(robot.getX());
        robotko.get(robotko.size() - 1).setY(robot.getY());
        Uygulama a1 = new Uygulama(); // en kısa yol koordinatlarını verir
        int[] baslangic_koordinatlari = {baslangic.getY(), baslangic.getX()};
        int[] bitis_koordinatlari = {bitis.getY(), bitis.getX()};
        k = a1.enKisaYol(maze, baslangic_koordinatlari, bitis_koordinatlari);
        if (k.size() == 0) {
            System.out.println("çıkış");
            engel.getLengel().clear();
            robotko.clear();
            yolgecis.clear();
        }
    }
        ArrayList<Lokasyon> finalK = k;
        final ArrayList<Lokasyon>[] kakak = new ArrayList[]{new ArrayList<>()};
        asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,finalK);

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
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,k);
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
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,k);
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
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,k);
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
                    asd.haritaciz(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,k);
                }
                else if(e.getKeyCode()==KeyEvent.VK_E){
                    asd.enkisayoluciz(labirent,baslangic,bitis,robot,k);
                }
                else if(e.getKeyCode()==KeyEvent.VK_M){
                    asd.ikincienkisayoluciz(labirent,baslangic,bitis,robot,kakak[0]);
                }
                else if(e.getKeyCode()==KeyEvent.VK_R){
                    asd.robothareketciz(labirent,baslangic,bitis,robot,robotko,k);
                }
                else if(e.getKeyCode()==KeyEvent.VK_B){
                    asd.bugukaldir(labirent,izgara,engel,baslangic,bitis,robot,matris,robotko,k);
                }
                else if(e.getKeyCode()==KeyEvent.VK_H){
                    asd.haritaciz(labirent, izgara, engel, baslangic, bitis, robot, matris, robotko, k);
                }
                else if(e.getKeyCode()==KeyEvent.VK_O){
                    robotadim=asd.problem2deneme(labirent,baslangic,bitis,izgara,robotko,engel,robot,matris,k,kakak,robotadim);
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
                    asd.problem2hareket(labirent,baslangic,bitis,izgara,robotko,engel,robot,matris,k,kakak);
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
                    asd.haritaciz(labirent, izgara, engel, baslangic, bitis, robot, matris, robotko1,k);
                    label11.setText("İKİNCİ EN KISA YOL:"+String.valueOf(kakak[0].size()-1) );
                }
            }
        });
    }
}
