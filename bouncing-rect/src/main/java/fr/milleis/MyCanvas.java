package fr.milleis;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyCanvas extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
     
        for (Box box :  ((ArrayList<Box>)Main.boxes.clone())) {
            g.setColor(box.color);
            g.drawRect(box.x, box.y, box.width, box.height);
        }
    }

}