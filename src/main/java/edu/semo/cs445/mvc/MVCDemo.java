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
	/**
	 * Logging frameworks are a common tool for tracking what's going on in
	 * a program. It's similar to System.out.println() but includes many
	 * features that make loggers useful for larger programs.
	 */
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
		frame.setMinimumSize(new Dimension(320, 240));

		navigator = new JTree(new DefaultMutableTreeNode("Root"));
		tabbedPane = new JTabbedPane();

		JSplitPane content = new JSplitPane();
		frame.setContentPane(content);
		content.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		content.setResizeWeight(0.125);
		content.setLeftComponent(navigator);
		content.setRightComponent(tabbedPane);

		tabbedPane.addTab("Tab 1", new JPanel());
		tabbedPane.addTab("Tab 2", new JPanel());
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
