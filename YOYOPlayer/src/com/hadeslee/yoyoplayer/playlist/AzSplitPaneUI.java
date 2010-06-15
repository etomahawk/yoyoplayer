package com.hadeslee.yoyoplayer.playlist;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * @author Azure
 * @version 1.0 24/03/07
 */
public class AzSplitPaneUI extends BasicSplitPaneUI {

    private ImageIcon splitLeftIcon;
    private ImageIcon splitLeftFocusIcon;
    private ImageIcon splitRightIcon;
    private ImageIcon splitRightFocusIcon;

    public void setImageIcons(ImageIcon splitLeftIcon,
            ImageIcon splitLeftFocusIcon, ImageIcon splitRightIcon,
            ImageIcon splitRightFocusIcon) {
        this.splitLeftIcon = splitLeftIcon;
        this.splitLeftFocusIcon = splitLeftFocusIcon;
        this.splitRightIcon = splitRightIcon;
        this.splitRightFocusIcon = splitRightFocusIcon;
    }

    /**
     * Creates a new MetalSplitPaneUI instance
     */
    public static ComponentUI createUI(JComponent x) {
        return new AzSplitPaneUI();
    }

    /**
     * Creates the default divider.
     */
    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new AzSplitPaneDivider(this, splitLeftIcon, splitLeftFocusIcon,
                splitRightIcon, splitRightFocusIcon);
    }
}
