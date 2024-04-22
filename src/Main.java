import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }catch (InstantiationException ex){
            throw new RuntimeException(ex);
        }catch (IllegalAccessException ex){
            throw new RuntimeException(ex);
        }catch (UnsupportedLookAndFeelException ex){
            throw new RuntimeException(ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Basla ilk_frame = new Basla();
                ilk_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // * işaretine basıldığına programın arka planda durmasını sağlar
                ilk_frame.setVisible(true); // görünürlüğünü true yapar framenin
            }
        });
    }
}