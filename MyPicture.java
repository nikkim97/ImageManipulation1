public class MyPicture {
	String filename;
	String description;
	int width;
	int height;
	Picture a;

	public MyPicture(String filename, String description) {
		this.filename = filename;
		this.description = description;
		this.a = new Picture (filename);
		this.width = a.getWidth();
		this.height = a.getHeight();
	}

	public String toString() {
		return (filename + " " + width + " x " + height + " " + description);
	}

	public boolean equals(MyPicture p) {
		if (filename.equals(p.filename) && description.equals(p.description)) {
			return true;
		}

		return false;
	}

	public Picture negative() {
		Picture pic2 = new Picture(a);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Pixel m = pic2.getPixel(i,j);
				m.setRed(255 - m.getRed());
				m.setBlue(255 - m.getBlue());
				m.setGreen(255 - m.getGreen());
			}
		}
		
		return pic2;

	}

	public double redness() {
		double count = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Pixel p = a.getPixel(i,j);
				if (p.getRed() > p.getBlue() && p.getRed() > p.getGreen()) {
					count++;
				}
			}
		}

		double totalPixels = 1.0 * width * height;
		double redness = count / totalPixels;

		return redness;
	}

	public void flipHorizontal() {
		for(int i = 0; i < width / 2; i++){
			for(int j = 0; j < height; j++){
				Pixel p = a.getPixel(i,j);
				Pixel z = a.getPixel(width-i-1, j);
				z.setRed(p.getRed());
				z.setGreen(p.getGreen());
				z.setBlue(p.getBlue());
			}
		}
	}

	public void flipVertical() {
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height / 2; j++){
				Pixel p = a.getPixel(i,j);
				Pixel z = a.getPixel(i, height-j-1);
				z.setRed(p.getRed());
				z.setGreen(p.getGreen());
				z.setBlue(p.getBlue());
	  		} 
		}
	}	
}