import java.util.ArrayList;
import java.util.LinkedList;
public class Uygulama extends Lokasyon{
    private static void ziyaretEdilenYollar(Hucre[][] hucreler, LinkedList<Hucre> onceki_durum, int x, int y, Hucre parent) {
        //out of boundary
        if (x < 0 || x >= hucreler.length || y < 0 || y >= hucreler[0].length || hucreler[x][y] == null) {
            return;
        }
        int mesafe = parent.mesafe + 1;
        Hucre gecici = hucreler[x][y];
        if (mesafe < gecici.mesafe) {
            gecici.mesafe = mesafe;
            gecici.onceki = parent;
            onceki_durum.add(gecici);
        }
    }
    public  ArrayList<Lokasyon> enKisaYol(int[][] gelenMatris, int[] baslangic_koordinatlari, int[] bitis_koordinatlari) {
        ArrayList<Lokasyon> lokasyons= new ArrayList<>();
        int sx=0,sy=0,dx=0,dy=0;
        sx = baslangic_koordinatlari[0];
        sy = baslangic_koordinatlari[1];
        dx = bitis_koordinatlari[0];
        dy =bitis_koordinatlari[1];
        if (gelenMatris[sx][sy] == 0 || gelenMatris[dx][dy] == 0) {
            System.out.println("Yol bulunamadı.");
            return  lokasyons;
        }
        int m = gelenMatris.length;
        int n = gelenMatris[0].length;
        Hucre[][] hucres = new Hucre[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (gelenMatris[k][l] != 0) {
                    hucres[k][l] = new Hucre(k, l, Integer.MAX_VALUE, null);
                }
            }
        }

        //breadth first search algoritması
        LinkedList<Hucre> bilinmez = new LinkedList<>();
        Hucre kaynak = hucres[sx][sy];
        kaynak.mesafe = 0;
        bilinmez.add(kaynak);
        Hucre kisa_yol = null;
        Hucre birim;
        while ((birim = bilinmez.poll()) != null) {
            if (birim.x == dx && birim.y == dy) {
                kisa_yol = birim;
                break;
            }
            ziyaretEdilenYollar(hucres, bilinmez, birim.x - 1, birim.y, birim);// aşağı doğru ilerleme yapması için
            ziyaretEdilenYollar(hucres, bilinmez, birim.x + 1, birim.y, birim);// sola doğru ilerlemsi için
            ziyaretEdilenYollar(hucres, bilinmez, birim.x, birim.y - 1, birim);//sağa doğru ilerlemsi için
            ziyaretEdilenYollar(hucres, bilinmez, birim.x, birim.y + 1, birim);// yukarı doğru hareket etmesini sağlar
        }
        int engel_sayisi=0;
        if (kisa_yol == null) {
            System.out.println("ÇIKIŞA ULAŞAN EN KISA YOL BULUNAMADI.");
            return lokasyons;
        } else {
            LinkedList<Hucre> yol = new LinkedList<>();
            birim = kisa_yol;
            do {
                yol.addFirst(birim);
                lokasyons.add(new Lokasyon());
                lokasyons.get(lokasyons.size()-1).setY(yol.get(0).x);
                lokasyons.get(lokasyons.size()-1).setX(yol.get(0).y);
               engel_sayisi++;
            } while ((birim = birim.onceki) != null);
            System.out.println(yol);
            System.out.println("TOPLAM ADIM SAYISI: "+ (engel_sayisi-1));
        }
        return lokasyons;
    }
}