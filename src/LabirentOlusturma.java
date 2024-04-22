import java.util.concurrent.ThreadLocalRandom;

public class LabirentOlusturma {
    private java.util.Random rand = new java.util.Random();
    private int satir_numarasi, sutun_numarasi;
    private int runnerXPos = 0;
    private int runnerYPos = 0;
    private int baslangicX = 0;
    private int baslangicY = 0;
    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int START = 0;
    private static final int END = 0;
    private int[][] gecici_labirent;
    private static int[][] labirent;

    public LabirentOlusturma(int satir_numarasi, int sutun_numarasi) {
        this.satir_numarasi = satir_numarasi;
        this.sutun_numarasi = sutun_numarasi;
    }
    public int[][] generate(){
        boolean start = false;
        boolean end = false;
        gecici_labirent = new int[sutun_numarasi +2][];
        labirent = new int[sutun_numarasi][satir_numarasi];
        for(int k = 0; k < sutun_numarasi +2; k++) {
            gecici_labirent[k] = new int[satir_numarasi +2];
            for(int l = 0; l < satir_numarasi +2; l++) {
                gecici_labirent[k][l] = WALL;
            }
        }
        for(int k = 0; k < sutun_numarasi +2; k++) {
            gecici_labirent[k][0] = FREE;
            gecici_labirent[k][satir_numarasi +2 - 1] = FREE;
        }
        for(int y = 0; y < satir_numarasi +2; y++) {
            gecici_labirent[0][y] = FREE;
            gecici_labirent[sutun_numarasi +2 - 1][y] = FREE;
        }

        gecici_labirent[2][2] = FREE;
        carve(2, 2);
        int rastgele_satir = 0;
        int rastgele_sutun = 0;

        while(true){
            if(!start) {
                rastgele_satir = ThreadLocalRandom.current().nextInt(1, sutun_numarasi +2-1);
                rastgele_sutun = ThreadLocalRandom.current().nextInt(1, satir_numarasi +2-1);
                if (gecici_labirent[rastgele_satir][rastgele_sutun] == FREE) {
                    gecici_labirent[rastgele_satir][rastgele_sutun] = START;
                    start = true;
                }
            }

            if(!end) {
                rastgele_satir = ThreadLocalRandom.current().nextInt(1, sutun_numarasi +2-1);
                rastgele_sutun = ThreadLocalRandom.current().nextInt(1, satir_numarasi +2-1);
                if (gecici_labirent[rastgele_satir][rastgele_sutun] == FREE) {
                    gecici_labirent[rastgele_satir][rastgele_sutun] = END;
                    end = true;
                }
            }

            if(start && end){
                break;
            }
        }
        sonLabirent();
        return labirent;
    }
    private void carve(int x, int y) {
        final int[] yukarix = { 1, -1, 0, 0 };
        final int[] yukariy = { 0, 0, 1, -1 };
        int uretilen_sayi = rand.nextInt(4);
        int sayac = 0;
        while(sayac < 4) {
            final int x1 = x + yukarix[uretilen_sayi];
            final int y1 = y + yukariy[uretilen_sayi];
            final int x2 = x1 + yukarix[uretilen_sayi];
            final int y2 = y1 + yukariy[uretilen_sayi];
            if(gecici_labirent[x1][y1] == WALL && gecici_labirent[x2][y2] == WALL) {
                gecici_labirent[x1][y1] = FREE;
                gecici_labirent[x2][y2] = FREE;
                carve(x2, y2);
            } else {
                uretilen_sayi = (uretilen_sayi + 1) % 4;
                sayac ++;
            }
        }
    }
    public void sonLabirent(){

        for (int k = 0; k < gecici_labirent.length; k++){

            for (int l = 0; l < gecici_labirent[0].length; l++){

                if((k != 0 && k != gecici_labirent.length-1) && (l != 0 && l != gecici_labirent[0].length-1)){

                    if (gecici_labirent[k][l] == START){

                        runnerXPos = l-1;
                        runnerYPos = k-1;
                        baslangicX = runnerXPos;
                        baslangicY = runnerYPos;
                        labirent[k-1][l-1] = 0;
                    }
                    else {
                        labirent[k-1][l-1] = gecici_labirent[k][l];
                    }
                }
            }
        }
    }
}