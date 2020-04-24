package model;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
  
public class E118
{
   public static void main(String[] args) throws Exception
   {
	   URL imageLocation = new URL(
			   "http://horstmann.com/java4everyone/duke.gif");
	   JOptionPane.showMessageDialog(null, "Welcome to this weird ICON", "Penguin title",
			   JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
			   
			   
     
	   
   }
}