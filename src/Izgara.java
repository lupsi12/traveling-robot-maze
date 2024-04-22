import java.util.ArrayList;

public class Izgara extends Lokasyon{
    private int satir;
    private int sutun;
    private ArrayList<Izgara> lIzgara;
    public Izgara() {
    }
    public Izgara(int X, int Y, int satir, int sutun, ArrayList<Izgara> lIzgara) {
        super(X, Y);
        this.setSatir(satir);
        this.setSutun(sutun);
        this.lIzgara = lIzgara;

    }
    public ArrayList<Izgara> getlIzgara() {
        return lIzgara;
    }
    public void setlIzgara(ArrayList<Izgara> lIzgara) {
        this.lIzgara = lIzgara;
    }
    public int getSatir() {
        return satir;
    }
    public void setSatir(int satir) {
        this.satir = satir;
    }
    public int getSutun() {
        return sutun;
    }
    public void setSutun(int sutun) {
        this.sutun = sutun;
    }
}
