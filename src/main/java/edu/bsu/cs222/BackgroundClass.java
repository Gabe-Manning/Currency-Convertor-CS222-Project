package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;

public class BackgroundClass extends JPanel {
    private final Image image;
    public BackgroundClass(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(image, 110, 0, this);
    }

}
