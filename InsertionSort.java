import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * Soham Dessai
 */
import javax.swing.JComponent;

public class InsertionSort {

	private int[] array;
	private int position = -1;
	private int indicated = -1;
	private int replaced = -1;
	private JComponent component;
	private static final int DELAY = 100;

	public InsertionSort(int[] exarray, JComponent excomponent) {
		this.array = exarray;
		this.component = excomponent;
	}
	
	
	//ALgorithim for insertion sort 
	public void sort() throws InterruptedException {
		int n = array.length;
		for(int j=1; j<n; j++) {
			int key = array[j];
			int i = j-1;
			position = j;
			indicated = j;
			try {
				while((i>=0) && (array[i] > key)) {
					array[i+1] = array[i];
					i--;
				}
				array[i+1] = key;
				replaced = (i+1);
			} finally {

			}
			pause(1);
		}
	}

	
	//Draws rectangles and indicates object that is getting inserted 
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);

		g.drawString("Insertion-  Algorithm that builds the final sorted array by inserting items one at a time", 50, 300);
		try {
			for(int i=0; i<array.length; i++) {
				if(i == position) {
					g.setColor(Color.RED);
				} else if(i == replaced) {
					g.setColor(Color.ORANGE);
				} 
				else if(i <= indicated) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.BLUE);
				}
				g.fillRect(100 + (i*10), 350, 8, array[i]*2);
			}
		} finally {

		}
	}

	
	//delays the pause 
	public void pause(int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(DELAY * steps);
	}

}


