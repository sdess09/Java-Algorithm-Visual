import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * 
 * @author sohamdessai
 *
 */

public class BubbleSort {

	private int[] array;
	private int indicated = -1;
	private int position = -1;

	private JComponent component;
	private static final int DELAY = 100;


	public BubbleSort(int[] exarray, JComponent excomponent) {
		this.array= exarray;
		this.component= excomponent; 
	}
	
	// Bubble sort swaping numbers 
	public void sort() throws InterruptedException {
		boolean swap = true;
		int j = 0;

		while(swap) {
			swap = false;

			indicated = array.length - j - 1;

			j++;

			for(int i=0; i<array.length - j; i++) {
				try {
					if(array[i] > array[i+1]) {
						int temp = array[i+1];
						array[i+1] = array[i];
						array[i] = temp;
						position = i;
						swap = true;
					}

				} finally {
					

				}
				pause(1);
			}

			if(swap == false) {
				indicated = 0;
			}

		}
	}

	//indicates current graphic to be swapped 
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
	
		g.drawString("Bubble- An Algorithim that compares each pair of adjacent items and swaps them if they are in the wrong order.", 50, 550);
		try {
			
			for(int i=0; i<array.length; i++) {
				if(i == position) {
					g.setColor(Color.RED);
				} else if(i >= indicated) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.BLUE);
				}
				
				g.fillRect(100 + (i*10), 600, 8, array[i]*2);
			}
		} finally {

		}
	}

	public void pause(int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(DELAY * steps);
	}


}
