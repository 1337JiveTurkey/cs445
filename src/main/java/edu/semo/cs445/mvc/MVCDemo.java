package edu.semo.cs445.mvc;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * This is a simple Swing application demonstrating the basics of the MVC
 * architecture. In this case the MVCDemo class is a controller object that
 * ties together the various model and view objects that make up the UI.
 */
public class MVCDemo {
	private static final System.Logger log = System.getLogger(MVCDemo.class.getSimpleName());

	private final JFrame frame;
	private final JTree navigator;
	private final JTabbedPane tabbedPane;

	public static void main(String[] args) {
		MVCDemo demo = new MVCDemo();
		demo.show();
	}

	public MVCDemo() {
		frame = new JFrame("Swing MVC Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(640, 480));

		navigator = new JTree(new DefaultMutableTreeNode("Root"));
		tabbedPane = new JTabbedPane();

		JSplitPane content = new JSplitPane();
		frame.setContentPane(content);
		content.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		content.setResizeWeight(0.125);
		content.setLeftComponent(navigator);
		content.setRightComponent(tabbedPane);
	}

	/**
	 * Makes the window used for the demo visible even if called from any thread.
	 */
	public void show() {
		if (SwingUtilities.isEventDispatchThread()) {
			frame.setVisible(true);
			frame.pack();
		} else {
			SwingUtilities.invokeLater(() -> frame.setVisible(true));
		}
	}
}
