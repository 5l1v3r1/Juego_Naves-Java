package Main;
import sun.rmi.runtime.NewThreadAction;

import javax.swing.JFrame;
import java.awt.*;

public class Lienzo extends JFrame implements Runnable{
    // Constantes de resolución de lienzo
    public static final int WIDTH = 1280, HEIGHT = 720;
    private Canvas canvas;
    private Thread thread;
    public Lienzo(){
        setTitle("Juego -  prueba "); // Nombre del frame
        setSize(WIDTH,HEIGHT);        // Dimensiones del Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permite que la ventana se pueda cerrar
        setResizable(false);//Redimencionar la pantalla
        setLocationRelativeTo(null);    // Centrar pantalla
        // Muestra formulario
        setVisible(true);

        // Canvas instanciando
        canvas = new Canvas();
        // Instanciando dimensiones
        Dimension dimension = new Dimension(WIDTH,HEIGHT);
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setFocusable(true);  //recibe eventos del teclado
        add(canvas);


    }

    public static void main(String[] args){
        System.out.println("Hola mundo en IntellJ");
        Lienzo s = new Lienzo(); // or New Main.Lienzo()
    }

    @Override
    public void run() {

    }
    private void start(){

    }
    private void stop(){

    }

}
