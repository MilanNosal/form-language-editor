package yajco.fle.panels;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class DialogResizeAdapter implements MouseListener, MouseMotionListener {

    public enum Action {

        MOVE, RESIZE_RIGHT, RESIZE_LEFT
    }

    private final JDialog dialog;

    private final Action action;

    private Point lastPoint, lastPosition;

    private Dimension lastDimension;

    public DialogResizeAdapter(JDialog dialog, JComponent actionComponent, Action action) {
        this.dialog = dialog;
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
        lastPosition = dialog.getLocation();
        lastDimension = dialog.getSize();
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
                dialog.setLocation(lastPosition.x + xDelta, lastPosition.y + yDelta);
                break;
            case RESIZE_RIGHT:
                dialog.setSize(new Dimension(lastDimension.width + xDelta, lastDimension.height + yDelta));
                break;
            case RESIZE_LEFT:
                dialog.setLocation(lastPosition.x + xDelta, lastPosition.y);
                dialog.setSize(new Dimension(lastDimension.width - xDelta, lastDimension.height + yDelta));
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
