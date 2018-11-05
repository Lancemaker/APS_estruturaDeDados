import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Sheet {
    private Node inicio, fim;
    private int quantidade;
    String imagePath;
    BufferedImage img;
    
    public Sheet(String imagePath) {
    	this.imagePath=imagePath;
        inicio = fim = null;
        quantidade = 0;
        try {
			img = ImageIO.read(new File(imagePath));
			
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int size() {
        return quantidade;
    }

    public void add(Sprite sprite, int indice) {
        if (indice >= 0 && indice <= quantidade) {
            Node novo = new Node(sprite);
            if (indice == 0) {
                novo.proximo = inicio;
                inicio = novo;
                if (inicio.proximo == null) {
                    fim = novo;
                }
            } else if (quantidade == indice) {
                fim.proximo = novo;
                fim = novo;
            } else {
                Node aux = inicio;
                for (int i = 0; i < indice - 1; i++) {
                    aux = aux.proximo;
                }
                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }
            quantidade++;
        }
    }
    
    public Sprite remove(int indice) {
        if (indice >= 0 && indice < quantidade) {
            quantidade--;
            Node retorno = inicio;
            if (indice == 0) {
                inicio = inicio.proximo;
                if (inicio == null) {
                    fim = null;
                }
                retorno.proximo = null;
                return retorno.sprite;
            } else {
                Node aux = inicio;
                for (int i = 0; i < indice - 1; i++) {
                    aux = aux.proximo;
                }
                retorno = aux.proximo;
                aux.proximo = aux.proximo.proximo;
                //aux.proximo = retorno.proximo;
                if (aux.proximo == null) {
                    fim = aux;
                }
                retorno.proximo = null;
                return retorno.sprite;
            }
        }
        return null;
    }
    
    public void FillSheet(int x,int y,int width,int height) {
    	int qtd=0;
    	 for(int i=0;i<y;i++) {
    		 for(int j=0;j<x;j++) {
    			System.out.println(i+" "+j);
    			BufferedImage imagem = img.getSubimage(j*width, i*height, width, height);
    			Sprite sprite = new Sprite(width,height,j*width,i*height,imagem);    			
    			add(sprite,qtd);
    			qtd++;
    			
    		 }    		 
    	 }
    	 System.out.println("total de imagens :" + qtd);
    }
    
    public Sprite getSprite(int index) {
    	int qtd =0;
    	Node aux=null;
    	if(!isEmpty()) {
    	aux = inicio;
    	while(qtd != index) {
    		aux=aux.proximo;
    		qtd++;
    	}
    	return aux.sprite;
    	}
    	else {
    	return null;
    	}    	
    }   
    
}
