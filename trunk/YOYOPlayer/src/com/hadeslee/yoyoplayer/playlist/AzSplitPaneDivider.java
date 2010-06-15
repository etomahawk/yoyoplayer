package com.hadeslee.yoyoplayer.playlist;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import sun.swing.DefaultLookup;

/**
 * @author Azure
 * @version 1.0 24/03/07
 */
public class AzSplitPaneDivider extends BasicSplitPaneDivider {

    private int oneTouchOffset;
    protected AzSplitPaneUI splitPaneUI;
    protected MouseHandler mouseHandler;
    protected DragController dragger;
    private boolean centerOneTouchButtons;
    private ImageIcon splitLeftIcon;
    private ImageIcon splitLeftIcon1;
    private ImageIcon splitRightIcon;
    private ImageIcon splitRightIcon1;

    public AzSplitPaneDivider(AzSplitPaneUI ui, ImageIcon splitLeftIcon,
            ImageIcon splitLeftFocusIcon, ImageIcon splitRightIcon,
            ImageIcon splitRightFocusIcon) {
        super(ui);
        setLayout(new DividerLayout());
        splitPaneUI = ui;
        setImageIcons(splitLeftIcon, splitLeftFocusIcon, splitRightIcon,
                splitRightFocusIcon);
    }

    public void setImageIcons(ImageIcon splitLeftIcon,
            ImageIcon splitLeftFocusIcon, ImageIcon splitRightIcon,
            ImageIcon splitRightFocusIcon) {
        this.splitLeftIcon = splitLeftIcon;
        this.splitLeftIcon1 = splitLeftFocusIcon;
        this.splitRightIcon = splitRightIcon;
        this.splitRightIcon1 = splitRightFocusIcon;
    }

    /**
     * Creates and return an instance of JButton that can be used to collapse
     * the left component in the metal split pane.
     */
    protected JButton createLeftOneTouchButton() {
        JButton b = new JButton() {

            public void setBorder(Border b) {
            }

            public boolean isFocusTraversable() {
                return false;
            }
        };
        b.setIcon(splitLeftIcon);

        b.setMinimumSize(new Dimension(splitLeftIcon.getIconWidth(),
                splitLeftIcon.getIconHeight()));
        b.setRequestFocusEnabled(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        maybeMakeButtonOpaque(b);

        return b;
    }

    /**
     * If necessary <code>c</code> is made opaque.
     */
    private void maybeMakeButtonOpaque(JComponent c) {
        Object opaque = UIManager.get("SplitPane.oneTouchButtonsOpaque");
        if (opaque != null) {
            c.setOpaque(((Boolean) opaque).booleanValue());
        }
    }

    /*
     * The following methods only exist in order to be able to access protected
     * members in the superclass, because these are otherwise not available in
     * any inner class.
     */
    int getOneTouchSizeFromSuper() {
        return ONE_TOUCH_SIZE;
    }

    int getOneTouchOffsetFromSuper() {
        return ONE_TOUCH_OFFSET;
    }

    int getOrientationFromSuper() {
        return orientation;
    }

    JSplitPane getSplitPaneFromSuper() {
        return splitPane;
    }

    JButton getRightButtonFromSuper() {
        return rightButton;
    }

    JButton getLeftButtonFromSuper() {
        return leftButton;
    }

    /**
     * MouseHandler is responsible for converting mouse events (released,
     * dragged...) into the appropriate DragController methods.
     * <p>
     */
    protected class MouseHandler extends MouseAdapter implements
            MouseMotionListener {

        /**
         * Starts the dragging session by creating the appropriate instance of
         * DragController.
         */
        public void mousePressed(MouseEvent e) {
            if ((e.getSource() == AzSplitPaneDivider.this || e.getSource() == splitPane)
                    && dragger == null && splitPane.isEnabled()) {
                Component newHiddenDivider = splitPaneUI.getNonContinuousLayoutDivider();

                if (hiddenDivider != newHiddenDivider) {
                    if (hiddenDivider != null) {
                        hiddenDivider.removeMouseListener(this);
                        hiddenDivider.removeMouseMotionListener(this);
                    }
                    hiddenDivider = newHiddenDivider;
                    if (hiddenDivider != null) {
                        hiddenDivider.addMouseMotionListener(this);
                        hiddenDivider.addMouseListener(this);
                    }
                }
                if (splitPane.getLeftComponent() != null
                        && splitPane.getRightComponent() != null) {
                    if (orientation == JSplitPane.HORIZONTAL_SPLIT) {
                        dragger = new DragController(e);
                    } else {
                        dragger = new VerticalDragController(e);
                    }
                    if (!dragger.isValid()) {
                        dragger = null;
                    } else {
                        prepareForDragging();
                        dragger.continueDrag(e);
                    }
                }
                e.consume();
            }
        }

        /**
         * If dragger is not null it is messaged with completeDrag.
         */
        public void mouseReleased(MouseEvent e) {
            if (dragger != null) {
                if (e.getSource() == splitPane) {
                    dragger.completeDrag(e.getX(), e.getY());
                } else if (e.getSource() == AzSplitPaneDivider.this) {
                    Point ourLoc = getLocation();

                    dragger.completeDrag(e.getX() + ourLoc.x, e.getY()
                            + ourLoc.y);
                } else if (e.getSource() == hiddenDivider) {
                    Point hDividerLoc = hiddenDivider.getLocation();
                    int ourX = e.getX() + hDividerLoc.x;
                    int ourY = e.getY() + hDividerLoc.y;

                    dragger.completeDrag(ourX, ourY);
                }
                dragger = null;
                e.consume();
            }
        }

        //
        // MouseMotionListener
        //
        /**
         * If dragger is not null it is messaged with continueDrag.
         */
        public void mouseDragged(MouseEvent e) {
            if (dragger != null) {
                if (e.getSource() == splitPane) {
                    dragger.continueDrag(e.getX(), e.getY());
                } else if (e.getSource() == AzSplitPaneDivider.this) {
                    Point ourLoc = getLocation();

                    dragger.continueDrag(e.getX() + ourLoc.x, e.getY()
                            + ourLoc.y);
                } else if (e.getSource() == hiddenDivider) {
                    Point hDividerLoc = hiddenDivider.getLocation();
                    int ourX = e.getX() + hDividerLoc.x;
                    int ourY = e.getY() + hDividerLoc.y;

                    dragger.continueDrag(ourX, ourY);
                }
                e.consume();
            }
        }

        /**
         * Resets the cursor based on the orientation.
         */
        public void mouseMoved(MouseEvent e) {
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e
         *            MouseEvent describing the details of the enter event.
         * @since 1.5
         */
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == AzSplitPaneDivider.this) {
                setMouseOver(true);
            }
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e
         *            MouseEvent describing the details of the exit event.
         * @since 1.5
         */
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == AzSplitPaneDivider.this) {
                setMouseOver(false);
            }
        }
    }

    /**
     * Handles the events during a dragging session for a HORIZONTAL_SPLIT
     * oriented split pane. This continually messages <code>dragDividerTo</code>
     * and then when done messages <code>finishDraggingTo</code>. When an
     * instance is created it should be messaged with <code>isValid</code> to
     * insure that dragging can happen (dragging won't be allowed if the two
     * views can not be resized).
     * <p>
     * <strong>Warning:</strong> Serialized objects of this class will not be
     * compatible with future Swing releases. The current serialization support
     * is appropriate for short term storage or RMI between applications running
     * the same version of Swing. As of 1.4, support for long term storage of
     * all JavaBeans<sup><font size="-2">TM</font></sup> has been added to
     * the <code>java.beans</code> package. Please see
     * {@link java.beans.XMLEncoder}.
     */
    protected class DragController {

        /**
         * Initial location of the divider.
         */
        int initialX;
        /**
         * Maximum and minimum positions to drag to.
         */
        int maxX, minX;
        /**
         * Initial location the mouse down happened at.
         */
        int offset;

        protected DragController(MouseEvent e) {
            JSplitPane splitPane = splitPaneUI.getSplitPane();
            Component leftC = splitPane.getLeftComponent();
            Component rightC = splitPane.getRightComponent();

            initialX = getLocation().x;
            if (e.getSource() == AzSplitPaneDivider.this) {
                offset = e.getX();
            } else { // splitPane
                offset = e.getX() - initialX;
            }
            if (leftC == null || rightC == null || offset < -1
                    || offset >= getSize().width) {
                // Don't allow dragging.
                maxX = -1;
            } else {
                Insets insets = splitPane.getInsets();

                if (leftC.isVisible()) {
                    minX = leftC.getMinimumSize().width;
                    if (insets != null) {
                        minX += insets.left;
                    }
                } else {
                    minX = 0;
                }
                if (rightC.isVisible()) {
                    int right = (insets != null) ? insets.right : 0;
                    maxX = Math.max(0, splitPane.getSize().width
                            - (getSize().width + right)
                            - rightC.getMinimumSize().width);
                } else {
                    int right = (insets != null) ? insets.right : 0;
                    maxX = Math.max(0, splitPane.getSize().width
                            - (getSize().width + right));
                }
                if (maxX < minX) {
                    minX = maxX = 0;
                }
            }
        }

        /**
         * Returns true if the dragging session is valid.
         */
        protected boolean isValid() {
            return (maxX > 0);
        }

        /**
         * Returns the new position to put the divider at based on the passed in
         * MouseEvent.
         */
        protected int positionForMouseEvent(MouseEvent e) {
            int newX = (e.getSource() == AzSplitPaneDivider.this) ? (e.getX() + getLocation().x)
                    : e.getX();

            newX = Math.min(maxX, Math.max(minX, newX - offset));
            return newX;
        }

        /**
         * Returns the x argument, since this is used for horizontal splits.
         */
        protected int getNeededLocation(int x, int y) {
            int newX;

            newX = Math.min(maxX, Math.max(minX, x - offset));
            return newX;
        }

        protected void continueDrag(int newX, int newY) {
            dragDividerTo(getNeededLocation(newX, newY));
        }

        /**
         * Messages dragDividerTo with the new location for the mouse event.
         */
        protected void continueDrag(MouseEvent e) {
            dragDividerTo(positionForMouseEvent(e));
        }

        protected void completeDrag(int x, int y) {
            finishDraggingTo(getNeededLocation(x, y));
        }

        /**
         * Messages finishDraggingTo with the new location for the mouse event.
         */
        protected void completeDrag(MouseEvent e) {
            finishDraggingTo(positionForMouseEvent(e));
        }
    } // End of BasicSplitPaneDivider.DragController

    /**
     * Handles the events during a dragging session for a VERTICAL_SPLIT
     * oriented split pane. This continually messages <code>dragDividerTo</code>
     * and then when done messages <code>finishDraggingTo</code>. When an
     * instance is created it should be messaged with <code>isValid</code> to
     * insure that dragging can happen (dragging won't be allowed if the two
     * views can not be resized).
     */
    protected class VerticalDragController extends DragController {
        /* DragControllers ivars are now in terms of y, not x. */

        protected VerticalDragController(MouseEvent e) {
            super(e);
            JSplitPane splitPane = splitPaneUI.getSplitPane();
            Component leftC = splitPane.getLeftComponent();
            Component rightC = splitPane.getRightComponent();

            initialX = getLocation().y;
            if (e.getSource() == AzSplitPaneDivider.this) {
                offset = e.getY();
            } else {
                offset = e.getY() - initialX;
            }
            if (leftC == null || rightC == null || offset < -1
                    || offset > getSize().height) {
                // Don't allow dragging.
                maxX = -1;
            } else {
                Insets insets = splitPane.getInsets();

                if (leftC.isVisible()) {
                    minX = leftC.getMinimumSize().height;
                    if (insets != null) {
                        minX += insets.top;
                    }
                } else {
                    minX = 0;
                }
                if (rightC.isVisible()) {
                    int bottom = (insets != null) ? insets.bottom : 0;

                    maxX = Math.max(0, splitPane.getSize().height
                            - (getSize().height + bottom)
                            - rightC.getMinimumSize().height);
                } else {
                    int bottom = (insets != null) ? insets.bottom : 0;

                    maxX = Math.max(0, splitPane.getSize().height
                            - (getSize().height + bottom));
                }
                if (maxX < minX) {
                    minX = maxX = 0;
                }
            }
        }

        /**
         * Returns the y argument, since this is used for vertical splits.
         */
        protected int getNeededLocation(int x, int y) {
            int newY;

            newY = Math.min(maxX, Math.max(minX, y - offset));
            return newY;
        }

        /**
         * Returns the new position to put the divider at based on the passed in
         * MouseEvent.
         */
        protected int positionForMouseEvent(MouseEvent e) {
            int newY = (e.getSource() == AzSplitPaneDivider.this) ? (e.getY() + getLocation().y)
                    : e.getY();

            newY = Math.min(maxX, Math.max(minX, newY - offset));
            return newY;
        }
    } // End of BasicSplitPaneDividier.VerticalDragController

    /**
     * Used to layout a <code>BasicSplitPaneDivider</code>. Layout for the
     * divider involves appropriately moving the left/right buttons around.
     * <p>
     */
    protected class DividerLayout implements LayoutManager {

        public void layoutContainer(Container c) {
            if (leftButton != null && c == AzSplitPaneDivider.this) {
                if (splitPane.isOneTouchExpandable()) {
                    Insets insets = getInsets();

                    if (orientation == JSplitPane.VERTICAL_SPLIT) {
                        int extraX = (insets != null) ? insets.left : 0;
                        int blockSize = getHeight();

                        if (insets != null) {
                            blockSize -= (insets.top + insets.bottom);
                            blockSize = Math.max(blockSize, 0);
                        }
                        blockSize = Math.min(blockSize, splitLeftIcon.getIconHeight());

                        leftButton.setBounds(extraX + oneTouchOffset, splitPane.getHeight()
                                / 2 - splitLeftIcon.getIconHeight() / 2,
                                blockSize * 2, blockSize);
                    } else {
                        int extraY = (insets != null) ? insets.top : 0;
                        int blockSize = getWidth();

                        if (insets != null) {
                            blockSize -= (insets.left + insets.right);
                            blockSize = Math.max(blockSize, 0);
                        }
                        blockSize = Math.min(blockSize, splitLeftIcon.getIconHeight());

                        int x = (c.getSize().width - blockSize) / 2;

                        if (!centerOneTouchButtons) {
                            x = (insets != null) ? insets.left : 0;
                            extraY = 0;
                        }

                        leftButton.setBounds(x, extraY + splitPane.getHeight()
                                / 2 - splitLeftIcon.getIconHeight() / 2,
                                blockSize, splitLeftIcon.getIconHeight());
                    }
                } else {
                    leftButton.setBounds(-5, -5, 1, 1);
                }
            }
        }

        public Dimension minimumLayoutSize(Container c) {
            // NOTE: This isn't really used, refer to
            // BasicSplitPaneDivider.getPreferredSize for the reason.
            // I leave it in hopes of having this used at some point.
            if (c != AzSplitPaneDivider.this || splitPane == null) {
                return new Dimension(0, 0);
            }
            Dimension buttonMinSize = null;

            if (splitPane.isOneTouchExpandable() && leftButton != null) {
                buttonMinSize = leftButton.getMinimumSize();
            }

            Insets insets = getInsets();
            int width = getDividerSize();
            int height = width;

            if (orientation == JSplitPane.VERTICAL_SPLIT) {
                if (buttonMinSize != null) {
                    int size = buttonMinSize.height;
                    if (insets != null) {
                        size += insets.top + insets.bottom;
                    }
                    height = Math.max(height, size);
                }
                width = 1;
            } else {
                if (buttonMinSize != null) {
                    int size = buttonMinSize.width;
                    if (insets != null) {
                        size += insets.left + insets.right;
                    }
                    width = Math.max(width, size);
                }
                height = 1;
            }
            return new Dimension(width, height);
        }

        public Dimension preferredLayoutSize(Container c) {
            return minimumLayoutSize(c);
        }

        public void removeLayoutComponent(Component c) {
        }

        public void addLayoutComponent(String string, Component c) {
        }
    } // End of class BasicSplitPaneDivider.DividerLayout

    /**
     * Listeners installed on the one touch expandable buttons.
     */
    private class OneTouchActionHandler implements ActionListener {

        /**
         * True indicates the resize should go the minimum (top or left) vs
         * false which indicates the resize should go to the maximum.
         */
        boolean toMinimum = true;

        OneTouchActionHandler(boolean toMinimum1) {
            toMinimum = toMinimum1;
        }

        public void actionPerformed(ActionEvent e) {
            Insets insets = splitPane.getInsets();
            int lastLoc = splitPane.getLastDividerLocation();
            int currentLoc = splitPaneUI.getDividerLocation(splitPane);
            int newLoc = insets.left;

            // We use the location from the UI directly, as the location the
            // JSplitPane itself maintains is not necessarly correct.
            if (toMinimum) {
                if (currentLoc < (splitPane.getWidth() - insets.right - getWidth())) {
                    newLoc = insets.left;
                    leftButton.setIcon(splitRightIcon);
                    toMinimum = false;
                }
            } else {
                if (currentLoc == insets.left) {
                    int maxLoc = splitPane.getMaximumDividerLocation();
                    leftButton.setIcon(splitLeftIcon1);
                    newLoc = Math.min(lastLoc, maxLoc);
                    toMinimum = true;
                }
            }
            if (currentLoc != newLoc) {
                splitPane.setDividerLocation(newLoc);
                // We do this in case the dividers notion of the location
                // differs from the real location.
                splitPane.setLastDividerLocation(currentLoc);
            }
        }
    } // End of class BasicSplitPaneDivider.LeftActionListener

    public void setBasicSplitPaneUI(AzSplitPaneUI newUI) {
        if (splitPane != null) {
            splitPane.removePropertyChangeListener(this);
            if (mouseHandler != null) {
                splitPane.removeMouseListener(mouseHandler);
                splitPane.removeMouseMotionListener(mouseHandler);
                removeMouseListener(mouseHandler);
                removeMouseMotionListener(mouseHandler);
                mouseHandler = null;
            }
        }
        splitPaneUI = newUI;
        if (newUI != null) {
            splitPane = newUI.getSplitPane();
            if (splitPane != null) {
                if (mouseHandler == null) {
                    mouseHandler = new MouseHandler();
                }
                splitPane.addMouseListener(mouseHandler);
                splitPane.addMouseMotionListener(mouseHandler);
                addMouseListener(mouseHandler);
                addMouseMotionListener(mouseHandler);
                splitPane.addPropertyChangeListener(this);
                if (splitPane.isOneTouchExpandable()) {
                    this.oneTouchExpandableChanged();
                }
            }
        } else {
            splitPane = null;
        }
    }

    @Override
    protected void oneTouchExpandableChanged() {
        if (!DefaultLookup.getBoolean(splitPane, splitPaneUI,
                "SplitPane.supportsOneTouchButtons", true)) {
            // Look and feel doesn't want to support one touch buttons, bail.
            return;
        }
        if (splitPane.isOneTouchExpandable() && leftButton == null
                && rightButton == null) {
            /*
             * Create the left button and add an action listener to
             * expand/collapse it.
             */
            leftButton = createLeftOneTouchButton();
            if (leftButton != null) {
                leftButton.addActionListener(new OneTouchActionHandler(true));
            }
            leftButton.addMouseListener(new MouseAdapter() {

                /**
                 * {@inheritDoc}
                 */
                public void mouseExited(MouseEvent e) {
                    String iconStr = leftButton.getIcon().toString();
                    if (iconStr.equals(splitLeftIcon1.toString())) {
                        leftButton.setIcon(splitLeftIcon);
                    } else if (iconStr.equals(splitRightIcon1.toString())) {
                        leftButton.setIcon(splitRightIcon);
                    }
                }

                /**
                 * {@inheritDoc}
                 */
                public void mouseEntered(MouseEvent e) {
                    String iconStr = leftButton.getIcon().toString();
                    if (iconStr.equals(splitLeftIcon.toString())) {
                        leftButton.setIcon(splitLeftIcon1);
                    } else if (iconStr.equals(splitRightIcon.toString())) {
                        leftButton.setIcon(splitRightIcon1);
                    }
                }
            });

            /*
             * Create the right button and add an action listener to
             * expand/collapse it.
             */
            rightButton = createRightOneTouchButton();
            if (rightButton != null) {
                rightButton.addActionListener(new OneTouchActionHandler(false));
            }

            if (leftButton != null && rightButton != null) {
                add(leftButton);
                add(rightButton);
            }
        }
        revalidate();
    }

    private void revalidate() {
        invalidate();
        if (splitPane != null) {
            splitPane.revalidate();
        }
    }
}
