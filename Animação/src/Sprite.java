import java.awt.image.BufferedImage;

public class Sprite {
	private int width;
	private int height;
	private int posX;
	private int posY;
	BufferedImage image;
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public Sprite() {
		
	}
	
	public Sprite(int width, int height, int posX, int posY, BufferedImage image) {
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		this.image = image;
	}	
}
