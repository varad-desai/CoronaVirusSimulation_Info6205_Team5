package GuiSocialDistanceWithQuarantine;
import javafx.application.Application;

import javax.swing.*;

public class GUI {
    public static void demo() {
        int height = 600;
        int width = 800;
        JFrame f = new JFrame("corona");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GuiSocialDistanceWithQuarantine.AnimationPanel ap = new AnimationPanel (height, width);
        f.getContentPane().add(ap);
        f.pack();
        f.show();
        //Application.launch (ChartGuiSocialDistanceWithQuarantine.class);
    }
}