import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface {
	public static void main(String[] args) {				
		String imagePath = "/home/lancemaker/Documents/Github/APS_estruturaDeDados/Animação/src/imagens/muybridge_run_cycle_by_cacodaemonia.jpg";
		Sheet sheet = new Sheet(imagePath);
		sheet.FillSheet(6, 2, 210, 290);	
		
		JFrame janela = new JFrame("AnimaAe");
		JLabel canvas = new JLabel();
		janela.setSize(800, 600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Pra parar a execução quando a janela fechar.
		
		int index =0;
		int displacement=0;
		int framesToRender=12;
		
		while(true) {
			
			System.out.println((index%framesToRender)+displacement);
			canvas.setIcon(new ImageIcon(sheet.getSprite((index%framesToRender)+displacement).getImage()) );
			janela.add(canvas);
			index++;
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}						
	}	
}
