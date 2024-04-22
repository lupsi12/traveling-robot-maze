import java.util.ArrayList;
public class Engel extends Lokasyon{
    private ArrayList<Engel> lengel;
    private ArrayList<Engel> engel1;
    private ArrayList<Engel> engel2;
    private ArrayList<Engel> engel3;
    private ArrayList<Engel> engel4;
    public Engel() {
    }
    public Engel(int X, int Y, ArrayList<Engel> lengel, ArrayList<Engel> engel1, ArrayList<Engel> engel2, ArrayList<Engel> engel3, ArrayList<Engel> engel4) {
        super(X, Y);
        this.setEngel1(engel1);
        this.setEngel2(engel2);
        this.setEngel3(engel3);
        this.setLengel(lengel);
        this.setEngel4(engel4);
    }
    public ArrayList<Engel> getLengel() {
        return lengel;
    }
    public void setLengel(ArrayList<Engel> lengel) {
        this.lengel = lengel;
    }
    public ArrayList<Engel> getEngel1() {
        return engel1;
    }
    public void setEngel1(ArrayList<Engel> engel1) {
        this.engel1 = engel1;
    }
    public ArrayList<Engel> getEngel2() {
        return engel2;
    }
    public void setEngel2(ArrayList<Engel> engel2) {
        this.engel2 = engel2;
    }
    public ArrayList<Engel> getEngel3() {
        return engel3;
    }
    public void setEngel3(ArrayList<Engel> engel3) {
        this.engel3 = engel3;
    }
    public ArrayList<Engel> getEngel4() {
        return engel4;
    }
    public void setEngel4(ArrayList<Engel> engel4) {
        this.engel4 = engel4;
    }
}
