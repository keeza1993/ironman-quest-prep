package com.ironquestprep;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/** Small code-drawn quest compass, shared by the toolbar and panel. */
final class QuestIcon
{
    private QuestIcon() { }

    static BufferedImage create()
    {
        BufferedImage image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        try
        {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(67, 25, 48));
            g.fillOval(2, 2, 28, 28);
            g.setColor(new Color(240, 71, 160));
            g.fillOval(4, 4, 24, 24);
            g.setColor(new Color(255, 172, 216));
            g.setStroke(new BasicStroke(1.5f));
            g.drawOval(3, 3, 26, 26);
            Polygon compass = new Polygon(
                    new int[]{16, 19, 28, 20, 16, 13, 4, 12},
                    new int[]{2, 12, 16, 19, 30, 20, 16, 13}, 8);
            g.setColor(new Color(102, 31, 70));
            g.setStroke(new BasicStroke(2f));
            g.drawPolygon(compass);
            g.setColor(Color.WHITE);
            g.fillPolygon(compass);
            g.setColor(new Color(240, 71, 160));
            g.fillOval(13, 13, 6, 6);
        }
        finally
        {
            g.dispose();
        }
        return image;
    }
}