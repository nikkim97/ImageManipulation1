//Niharika Mishra nm729
public class Milestone2
{
//Returns the number of red pixels in a picture
// (1) from MS1
public static int countRedPixels(Picture v){
	int countRedPixels = 0;
	for(int x=0; x<v.getWidth();x++){
		for(int y=0;y<v.getHeight();y++){
			Pixel p=v.getPixel(x,y);
			if(p.getRed()==255 && p.getBlue()==0 && p.getGreen()==0) {
				countRedPixels++;
			}
		}
	}
		
	return countRedPixels; 
}
//Switches all red and blue pixels (pure red, pure blue)
// (2) from MS1
public static void switchRedBlue(Picture v){
	for(int x=0; x<v.getWidth();x++){
		for(int y=0;y<v.getHeight();y++){
			Pixel p=v.getPixel(x,y);
			if (p.getRed()==255 && p.getBlue()==0 && p.getGreen()==0) {
				p.setBlue(255);
				p.setRed(0);
				p.setGreen(0);
				continue;
			}

			if (p.getRed()==0 && p.getBlue()==255 && p.getGreen()==0) {
				p.setRed(255);
				p.setBlue(0);
				p.setGreen(0);
				continue;
			}
		}
	}
}


//Flips over imaginary vertical line (3) from MS1
// IF pixels exist ON the midline, leave them there without reflecting
public static void flipHorizontal(Picture v) {	
	for(int x=0; x<v.getWidth()/2;x++){
		for(int y=0;y<v.getHeight();y++){
			Pixel p=v.getPixel(x,y);
			Pixel z=v.getPixel(v.getWidth()-x-1, y);
			z.setRed(p.getRed());
			z.setGreen(p.getGreen());
			z.setBlue(p.getBlue());
	}
}
}

 
//Flips over imaginary horizontal line (4) from MS1
// IF pixels exist ON the midline, leave them there without reflecting
public static void flipVertical(Picture v) {
	for(int x=0; x<v.getWidth();x++){
		for(int y=0;y<v.getHeight()/2;y++){
			Pixel p=v.getPixel(x,y);
			Pixel z=v.getPixel(x, v.getHeight()-y-1);
			z.setRed(p.getRed());
			z.setGreen(p.getGreen());
			z.setBlue(p.getBlue());
  		} 
	}
}
 
//Flips over imaginary diagonal line (5) from MS1
// upper right to lower left diagonal line
// you may assume SQUARE images (height == width)
// IF pixels exist ON the midline, leave them there without reflecting
public static void flipDiagonal(Picture v) {
	for(int x=0; x<v.getWidth();x++){
		for(int y=0;y<v.getHeight();y++){
			Pixel p=v.getPixel(x,y);
			Pixel z=v.getPixel(v.getWidth()-1-y,v.getHeight()-1-x);
			z.setRed(p.getRed());
			z.setGreen(p.getGreen());
			z.setBlue(p.getBlue());
  		} 
  	}
}
 public static void main(String[] agrs){
	Picture image=new Picture("square.jpg");
	//int x=countRedPixels(image);
	//System.out.println(x);
	//flipVertical(image);
	//flipHorizontal(image);
	//flipDiagonal(image);
	image.show();
	}
}