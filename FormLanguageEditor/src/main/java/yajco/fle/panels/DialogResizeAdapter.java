package yajco.fle.panels;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class DialogResizeAdapter implements MouseListener, MouseMotionListener {

    public enum Action {

        MOVE, RESIZE_RIGHT, RESIZE_LEFT
    }

    private final Window window;

    private final Action action;

    private Point lastPoint, lastPosition;

    private Dimension lastDimension;

    public DialogResizeAdapter(Window dialog, JComponent actionComponent, Action action) {
        this.window = dialog;
        this.action = action;

        actionComponent.addMouseListener(this);
        actionComponent.addMouseMotionListener(this);

        switch (action) {
            case MOVE:
                actionComponent.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                break;
            case RESIZE_RIGHT:
                actionComponent.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
                break;
            case RESIZE_LEFT:
                actionComponent.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        lastPoint = evt.getPoint();
        lastPosition = window.getLocation();
        lastDimension = window.getSize();
        SwingUtilities.convertPointToScreen(lastPoint, evt.getComponent());
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        Point point = evt.getPoint();
        SwingUtilities.convertPointToScreen(point, evt.getComponent());
        int xDelta = point.x - lastPoint.x;
        int yDelta = point.y - lastPoint.y;

        switch (action) {
            case MOVE:
                window.setLocation(lastPosition.x + xDelta, lastPosition.y + yDelta);
                break;
            case RESIZE_RIGHT:
                window.setSize(new Dimension(lastDimension.width + xDelta, lastDimension.height + yDelta));
                break;
            case RESIZE_LEFT:
                window.setLocation(lastPosition.x + xDelta, lastPosition.y);
                window.setSize(new Dimension(lastDimension.width - xDelta, lastDimension.height + yDelta));
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
