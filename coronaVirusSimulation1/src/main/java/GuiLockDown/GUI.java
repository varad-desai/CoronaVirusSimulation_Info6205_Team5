/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiLockDown;
import GuiQuarantine.ChartGuiQuarantine;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author varad
 * 
 * 1. 80% population is under lockdown 20% population can move 
 */
public class GUI {
     public static void demo() {
      int height = 600;
      int width = 800;
      JFrame f = new JFrame("corona");
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      AnimationPanel ap = new AnimationPanel(height, width);
      f.getContentPane().add(ap);
      f.pack();
      f.show();
     
      //Application.launch (ChartLockDown.class);
   }
     
}
