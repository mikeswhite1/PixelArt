import java.awt.Color;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class Pixelator {
	
	public static void main (String[] arg0) {
		File file = new File("src/fdoi.jpg");
		File file1 = new File("image.jpg");
		Pixelator pxlt = new Pixelator(file1, 5);
		pxlt.exportImage(fullColor, file);
	}
	
	private static BufferedImage orimage = null;
	protected static Color[][] fullColor = null;
	protected static Color[][] pixColor = null;
	private static int pixelRate = 10;
	
	public Pixelator(File file, int rate) {
		pixelRate = rate;
		try {
			orimage = ImageIO.read(file);
			pixelate(orimage, pixelRate);		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Color[][] getColor() {
//		Color[][] pixelated = null;
//		if (fullColor.length % pixelRate != 0) {
//			pixelated = new Color[fullColor.length/pixelRate + 1][fullColor[0].length/pixelRate + 1];
//		} else {
//			pixelated = new Color[fullColor.length/pixelRate][fullColor[0].length/pixelRate];
//		}
//		int yy = 0;
//		int xx = 0;
//		for (int y = 0; y < fullColor.length; y += pixelRate) {
//			xx = 0;
//            for (int x = 0; x < fullColor[0].length; y += pixelRate) {
//                pixelated[yy][xx] = fullColor[y][x];
//            }
//        }
//		
//		if (fullColor.length % pixelRate != 0) {
//			for (int y = 0 ; y < pixelated[0].length ; y++) {
////				pixelated[y][xx+1] = colorArray[][];
//			}
//		}
//		if (fullColor[0].length % pixelRate != 0) {
//			
//		}
		return pixColor;
	}
	
	public File exportImage(Color[][] colorArray, File file) {
		BufferedImage image = new BufferedImage(orimage.getWidth(), orimage.getHeight(), orimage.getType());
		for (int y = 0 ; y < colorArray.length ; y++) {
			for (int x = 0 ; x < colorArray[0].length ; x++) {
				image.setRGB(x, y, colorArray[y][x].getRGB());
				
			}
		}
		try {
			ImageIO.write(image, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
	
	private static BufferedImage pixelate(BufferedImage imageToPixelate, int pixelSize) {
        BufferedImage pixelateImage = new BufferedImage(
            imageToPixelate.getWidth(),
            imageToPixelate.getHeight(),
            imageToPixelate.getType());
        fullColor = new Color[imageToPixelate.getHeight()][imageToPixelate.getWidth()];
        if (fullColor.length % pixelRate != 0) {
			pixColor = new Color[fullColor.length/pixelRate + 1][fullColor[0].length/pixelRate + 1];
		} else {
			pixColor = new Color[fullColor.length/pixelRate][fullColor[0].length/pixelRate];
		}
        for (int y = 0; y < imageToPixelate.getHeight(); y += pixelSize) {
        	for (int x = 0; x < imageToPixelate.getWidth(); x += pixelSize) {
                BufferedImage croppedImage = getCroppedImage(imageToPixelate, x, y, pixelSize, pixelSize);
                Color dominantColor = getDominantColor(croppedImage);
                pixColor[y][x] = dominantColor;
                for (int yd = y; (yd < y + pixelSize) && (yd < pixelateImage.getHeight()); yd++) {
                    for (int xd = x; (xd < x + pixelSize) && (xd < pixelateImage.getWidth()); xd++) {
                        pixelateImage.setRGB(xd, yd, dominantColor.getRGB());
                        fullColor[yd][xd] = new Color(dominantColor.getRGB());
                    }
                }
            }
        }

        return pixelateImage;
    }

	private static BufferedImage getCroppedImage(BufferedImage image, int startx, int starty, int width, int height) {
        if (startx < 0) startx = 0;
        if (starty < 0) starty = 0;
        if (startx > image.getWidth()) startx = image.getWidth();
        if (starty > image.getHeight()) starty = image.getHeight();
        if (startx + width > image.getWidth()) width = image.getWidth() - startx;
        if (starty + height > image.getHeight()) height = image.getHeight() - starty;
        return image.getSubimage(startx, starty, width, height);
    }

	private static Color getDominantColor(BufferedImage image) {
        Map<Integer, Integer> colorCounter = new HashMap<>(100);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int currentRGB = image.getRGB(x, y);
                int count = colorCounter.getOrDefault(currentRGB, 0);
                colorCounter.put(currentRGB, count + 1);
            }
        }
        return getDominantColor(colorCounter);
    }

    private static Color getDominantColor(Map<Integer, Integer> colorCounter) {
        int dominantRGB = colorCounter.entrySet().stream()
            .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
            .get()
            .getKey();
        return new Color(dominantRGB);
    }
	
	
}
