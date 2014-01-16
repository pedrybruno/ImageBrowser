package imagebrowser.ui.swing;

import imagebrowser.ui.ImageViewer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private ImageViewer imageViewer;
    private ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Browser");
        this.factory = factory;
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.createComponents();
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }
    
    private void createComponents() {
        this.add(createToolbar(), BorderLayout.SOUTH);
        this.add(createImagePanel());  
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }

    private JButton createButton(String str) {
        JButton button = new JButton(str);
        button.addActionListener(factory.create(str));
        return button;
    }
    
    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        imageViewer = panel;
        return panel;
    }

}
