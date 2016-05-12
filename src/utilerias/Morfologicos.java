/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

//import org.opencv.highgui.Highgui;
public class Morfologicos {
    
    public Mat erosion( Mat src) {
  
         Mat source = src.clone();
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         
         destination = source.clone();

         int erosion_size = 5;
         
         Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
         Imgproc.erode(source, destination, element);
         
         
         return destination;
      
    }
    public Mat dilatation(Mat src){
        Mat dilat = src.clone();
        Mat destination = new Mat(dilat.rows(),dilat.cols(),dilat.type());

        destination = dilat.clone();
        
        int dilation_size = 5;

         Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*dilation_size + 1, 2*dilation_size+1));
         Imgproc.dilate(dilat, destination, element1);
        
         
         return destination;
        
    }
    
}
