import javax.swing.*;

/**
 * Proyecto de visualización de votos en la política.
 * @author yofeliz
 */
public class Politica extends JFrame {
    public static void main(String[] params) {
        Porcentajes panel = new Porcentajes();
        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.add(panel);
        aplicacion.setSize(800, 400);
        aplicacion.setVisible(true);
    }//main
}//Politica
