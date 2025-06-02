package oop;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class NonInnerClassExample extends JFrame {

    private String originalTitle = "Original Title";

    public NonInnerClassExample() {
        setTitle(originalTitle);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new ExternalMouseEventHandler(this) );
        setVisible(true);
    }


    public void updateTitle(String newTitle) { setTitle(newTitle); }
    public String getOriginalTitle() { return originalTitle; }
}

class ExternalMouseEventHandler implements MouseListener {
    private NonInnerClassExample frame;

    public ExternalMouseEventHandler(NonInnerClassExample frame) {this.frame = frame; }

    public void mouseEntered(MouseEvent e) {frame.updateTitle("Mouse On");}
    public void mouseExited(MouseEvent e) {frame.updateTitle(frame.getOriginalTitle());}

    public void mouseClicked(MouseEvent e) {} //{frame.updateTitle("Mouse Clicked");}
    public void mousePressed(MouseEvent e) {frame.updateTitle("Mouse Pressed");}
    public void mouseReleased(MouseEvent e) {frame.updateTitle("Mouse Released");}
}
// ---

class InnerClassExample extends JFrame {

    private String originalTitle = "Original Title";

    public InnerClassExample() {
        setTitle(originalTitle);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new MouseEventHandler());
        setVisible(true);
    }

    class MouseEventHandler implements MouseListener {
        public void mouseEntered(MouseEvent e) {setTitle("Mouse On");}
        public void mouseExited(MouseEvent e) {setTitle(originalTitle);}

        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}

    }
}

public class test06022 {
    public static void main(String[] args) {
        new NonInnerClassExample();
        new InnerClassExample();
    }
}
