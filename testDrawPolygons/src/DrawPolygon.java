import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawPolygon extends Component{
    Point poly_cpoint;
    String poly_type;

    public DrawPolygon(Point p, String p_type){
        poly_cpoint = p;
        poly_type = p_type;
    }//constructor

    @Override
    public void paint(Graphics g) {

        if (poly_type.equals("square"))
            g.drawRect(poly_cpoint.x -10, poly_cpoint.y -10, 20, 20);
        else if (poly_type.equals("triangle")) {
            g.drawLine(poly_cpoint.x, poly_cpoint.y-10, poly_cpoint.x-10, poly_cpoint.y+10);
            g.drawLine(poly_cpoint.x-10, poly_cpoint.y+10,
                    poly_cpoint.x+10, poly_cpoint.y+10);
            g.drawLine(poly_cpoint.x+10, poly_cpoint.y+10, poly_cpoint.x, poly_cpoint.y-10);
        } else if (poly_type.equals("rectangle"))
            g.drawRect(poly_cpoint.x -20, poly_cpoint.y -10, 40, 20);
        else
            System.out.println("Ej igenkänd polygon");

    }//paint

    public static void main(String[] args) {
        Integer xcoord = Integer.parseInt(JOptionPane.showInputDialog(null,"X-koordinat:"));
        Integer ycoord = Integer.parseInt(JOptionPane.showInputDialog(null,"Y-koordinat:"));
        String typ = JOptionPane.showInputDialog(null,"Typ av polygon:");

        Point p1 = new Point(xcoord,ycoord);

        JFrame frame = new JFrame();
        DrawPolygon polygon = new DrawPolygon(p1,typ);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygon);
        frame.setVisible(true);

    }//main

}//DrawPolygons