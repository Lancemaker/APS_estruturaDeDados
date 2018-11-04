import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserInterface {
	public static void main(String[] args) {		
		//carrega imagem que contem os sprites.
		String imagePath = "/home/lancemaker/Documents/Github/APS_estruturaDeDados/Animação/src/imagens/mario.png";
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imagePath));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		BufferedImage imgToRender = img.getSubimage(0, 0, 18, 36);
		ImageIcon icon = new ImageIcon(imgToRender);
		//janela
		JFrame janela = new JFrame("AnimaAe");
		JLabel canvas = new JLabel();
		canvas.setIcon(icon);
		
		janela.add(canvas);
		janela.setSize(800, 600);
		janela.setVisible(true);
	}	
}
