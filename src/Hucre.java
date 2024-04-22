public class Hucre extends Uygulama {
    int x;
    int y;
    int mesafe;
    Hucre onceki;
    Hucre(int x, int y, int mesafe, Hucre onceki) {
        this.x = x;
        this.y = y;
        this.mesafe = mesafe;
        this.onceki = onceki;
    }
    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getMesafe() {
        return mesafe;
    }
    public void setMesafe(int mesafe) {
        this.mesafe = mesafe;
    }
    public Hucre getOnceki() {
        return onceki;
    }
    public void setOnceki(Hucre onceki) {
        this.onceki = onceki;
    }
}