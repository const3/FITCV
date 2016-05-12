/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

//import org.opencv.highgui.Highgui;

public class BrilloContraste {
   static int width;
   static int height;
   static double alpha = 2;
   static double beta = 50;
   
public Mat Brillo( Mat src) {
    
         Mat source = src.clone();
         Mat destination = new Mat(source.rows(),source.cols(),
         
         source.type());
         source.convertTo(destination, -1, alpha, beta);
         
         return destination;
      
    }
  public Mat Contraste(Mat src){
      
         Mat source = src.clone();
         Mat gray = new Mat();
         
         Imgproc.cvtColor(source, gray, Imgproc.COLOR_BGR2GRAY);
         
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         
         Imgproc.equalizeHist(gray, destination);
         
         return destination;
    
      
  }
    
}
