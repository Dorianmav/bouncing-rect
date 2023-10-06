package fr.milleis;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

    public static JFrame jFrame;

    public static MyCanvas canvas;
    public static ArrayList<Box> boxes = new ArrayList<>();

    public static void main(String[] args) {

        jFrame = new JFrame("Terrain de jeu");
        canvas = new MyCanvas();

        int width = 750;
        int height = 650;

        jFrame.setSize(width, height);
        jFrame.setContentPane(canvas);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        var boxR = new Box(75, 150);
        var boxB = new Box(300, 300);

        boxes.add(boxR);
        boxes.add(boxB);

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
           
                    for (Box box : ((ArrayList<Box>)boxes.clone())) {
                        box.move();
                    }
                    try {
                        Thread.sleep(20);
                        for (Box box :  ((ArrayList<Box>)boxes.clone())) {
                            box.bounce();
                            for (Box box2 :  ((ArrayList<Box>)boxes.clone())) {
                                if (box2 != box && (box.intersects(box2))) {
                                    box.colide();
                                }
                            }
                        }
                        canvas.repaint();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }).start();

        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point pointSouri = MouseInfo.getPointerInfo().getLocation();
                var box = new Box((int) pointSouri.getX(), (int) pointSouri.getY());
                boxes.add(box);
            }
        });

    }

    public void give() {

    }

}