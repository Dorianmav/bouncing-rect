package fr.milleis;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Box extends Rectangle {

    Random random = new Random();

    float r = random.nextFloat();
    float g = random.nextFloat();
    float b = random.nextFloat();

    Color color;

    Boolean dirX;
    Boolean dirY;

    int rand = 10 + (int)(Math.random() * 100 - 20);

    public Box (int x, int y){
        this.x = x;
        this.y = y;
        this.width = rand;
        this.height = rand;
        this.color = new Color(r, g, b);
        this.dirX = random.nextBoolean();
        this.dirY = random.nextBoolean();
    }

    public void move(){
        if(!(dirX)){
            x -= 10;
        } else {
            x+= 10;
        }

        if(!(dirY)){
            y-= 10;
        } else {
            y+= 10;
        }
    }

    public boolean outTop(){
        return y <= 0 ;
    }

    public boolean outBottom(){
        return y >= Main.jFrame.getHeight() - 85;
    }

    public boolean outRight(){
        return x >= Main.jFrame.getWidth() - 85;
    }

    public boolean outLeft(){
        return x <= 0;
    }

    public void colide() {
        dirX = !dirX;
        dirY = !dirY;
    }

    public void bounce() {
        if (outRight() || outLeft()) {
            dirX = !dirX;
        }
        if (outTop() || outBottom()) {
            dirY = !dirY;
        }
    }

}