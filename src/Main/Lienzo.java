package Main;
import sun.rmi.runtime.NewThreadAction;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Lienzo extends JFrame implements Runnable{
    // Constantes de resolución de lienzo
    public static final int WIDTH = 1280, HEIGHT = 720;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy buffer;
    private Graphics graphics;
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
    @Override
    public void run() {
        // Emula el método Step
        while(running){
            update();
            draw();
        }
        stop();
    }
    private void start(){
        thread = new Thread(this);
        running = true;
        thread.start();
    }
    private void stop(){
       try {
           running = false;
           thread.join();
       }catch (InterruptedException e){
           System.out.println("Hubo un error: "+e);
       }
    }


    int x = 10;
    private void update(){
        x++;
    }

    private void draw(){
        Toolkit.getDefaultToolkit().sync();
        buffer = canvas.getBufferStrategy();
        if (buffer == null){
            canvas.createBufferStrategy(2);
            return;
        }
        graphics = buffer.getDrawGraphics();
        //------------------------------------//
        graphics.drawRect(x,50,150,150);




        //------------------X-----------------//
        graphics.dispose();
        buffer.show();
    }


    public static void main(String[] args){
        System.out.println("Hola mundo en IntellJ");
        Lienzo s = new Lienzo(); // or New Main.Lienzo()
        s.start();  // start Thread
    }

}
