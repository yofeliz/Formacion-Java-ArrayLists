import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Class de entrenamiento con gráficos, ArrayLists y colores.
 * @author yofeliz
 */
public class Porcentajes extends JPanel {
    //Definición de colores no existentes en la paleta de Java.
    private final static Color PP           = Color.BLUE;
    private final static Color PSOE         = Color.RED;
    private final static Color PODEMOS      = new Color(128, 0, 128);
    private final static Color CIUDADANOS   = Color.ORANGE;
    private final static Color PNV          = Color.GREEN;
    private final static Color CC           = Color.YELLOW;
    
    //Array de colores del arcoiris.
    private Color[] colores                 = {PP, PSOE, PODEMOS, CIUDADANOS, PNV, CC};
    private String[] partidos               = {"PP", "PSOE", "PODEMOS", "CIUDADANOS", "PNV", "CC"};
    private ArrayList<Integer> votos        = new ArrayList<Integer>();
    private ArrayList<String> listaPartidos = new ArrayList<>(Arrays.asList(partidos));
    
    //Suma total de los votos.
    private Integer sumaVotos               = 0;
    
    //Constructor.
    public Porcentajes() {
        //Se toman los valores de los votos.
        for(int i=0; i<listaPartidos.size(); i++) {
            try{
                votos.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Votos del " + partidos[i])));
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Voto de " + partidos[i] + " no válido. Se pondrá a 0");
            }//try-catch
            
            //Se suman los votos introducidos al total de votos.
            sumaVotos += votos.get(i);
        }//for
    }//Constructor
    
    //Función para pintar los arcos de la votación según su porcentaje.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Radio del arco.
        int radio       = 60;
        //Borde del rectángulo que contiene el arco.
        int borde       = 10;
        
        //Valores para el arco.
        int valorX      = borde;
        int valorY      = borde;
        int ancho       = getWidth() - borde * 2;
        int alto        = (getHeight() - 10) * 2 - borde * 2;
        int inicioArco  = 0;
        int gradosArco  = 0;
        
        for(int i=listaPartidos.size()-1; i>=0; i--) {
            //Establece el color del arco.
            g.setColor(colores[i]);
            
            //Operaciones de arcos.
            if(i==0) {
                //Operación para completar los 180º (.fillArc no acepta decimales).
                gradosArco = 180 - inicioArco;
            } else {
                gradosArco = (180 * votos.get(i)) / sumaVotos;
            }//if-else
            
            //Rellena el arco con los valores de su tramo de arco.
            g.fillArc(valorX, valorY, ancho, alto, inicioArco, gradosArco);
            
            //Se configura el inicio del siguiente arco con el final anterior.
            inicioArco += gradosArco;
        }//for
    }//paintComponent
}//Porcentajes