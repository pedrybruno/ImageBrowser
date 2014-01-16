package imagebrowser;

import imagebrowser.control.Command;
import imagebrowser.control.NextImageCommand;
import imagebrowser.control.PrevImageCommand;
import imagebrowser.model.Image;
import imagebrowser.persistence.ImageListLoader;
import imagebrowser.persistence.file.FileImageListLoader;
import imagebrowser.ui.swing.ActionListenerFactory;
import imagebrowser.ui.swing.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageBrowser {

    public static void main(String[] args) {
        new ImageBrowser().execute();
    }

    private static final String PATH = "/Users/Bruno/Desktop/fotos_gopro";
    private Map<String, Command> commandMap;
    private ApplicationFrame frame;

    private void execute() {
        ImageListLoader loader = createImageListLoader(PATH);
        List<Image> list = loader.load();
        frame = new ApplicationFrame(createActionListenerFactory());
        frame.getImageViewer().setImage(list.get(0));
        createCommands();
        frame.setVisible(true);
    }

    private ImageListLoader createImageListLoader(String PATH) {
        return new FileImageListLoader(PATH);
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {

            @Override
            public ActionListener create(final String action) {
                return new ActionListener() {
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Command command = commandMap.get(action);
                        if (command == null) return;
                        command.execute();
                    }
                };
            }
        };
    }

    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Next", new NextImageCommand(frame.getImageViewer()));
        commandMap.put("Prev", new PrevImageCommand(frame.getImageViewer()));
    }

}
