package GuiCovidTesting;
import GuiLockDown.ChartLockDown;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;


public class GUI {
     public static void demo() {
      int height = 600;
      int width = 800;
      JFrame f = new JFrame("covid-19");
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      AnimationPanel ap = new AnimationPanel(height, width);
      f.getContentPane().add(ap);
      f.pack();
      f.show();
      //Application.launch (ChartCovidTesting.class);
   }
     
   
     
     
}
