package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Toolkit;
  
public class Test
{
JFrame frame;
 
public Test()
{
frame = new JFrame("Test");
Toolkit tk = Toolkit.getDefaultToolkit();
int xSize = ((int) tk.getScreenSize().getWidth());
int ySize = ((int) tk.getScreenSize().getHeight());
frame.setSize(xSize,ySize);
frame.show();
  
}
public static void main(String[] args)
{
Test app = new Test();
}
}