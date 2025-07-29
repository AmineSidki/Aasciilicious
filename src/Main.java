import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedImage image = ImageIO.read(new File(args[0]));
            int height = image.getHeight();
            int width = image.getWidth();

            StringBuilder sb = new StringBuilder();

            for(int y = 0 ; y < height ; y++){
                for(int x = 0 ; x < width ; x++){
                    int rgb = image.getRGB(x,y);
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;
                    int brightness = (red + green + blue) / 3;

                    String asciiChars = " .:-=+*#%@";
                    char asciiChar = asciiChars.charAt((int) (brightness / 255.0 * (asciiChars.length() - 1)));
                    sb.append(asciiChar);

                }
                sb.append('\n');
            }

            System.out.println(sb);

        }catch(Exception e){
            System.out.println("An error occurred while reading the image file !" + e);
            System.exit(1);
        }
    }
}