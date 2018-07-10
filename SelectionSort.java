import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * 
 * @author sohamdessai
 *
 */
public class SelectionSort {
	private int[] array;
	private int position = -1;
	private int indicated = -1;
	private int minimumpos = -1;
	private JComponent component;
	private static final int DELAY = 100;

	public SelectionSort(int[] exarray, JComponent excomponent) {
		array = exarray;
		component = excomponent;
	}

	
	//finds minimum using helper method 
	public void sort() throws InterruptedException {
		for(int i=0; i<array.length-1; i++) {
			int minPos = minimumPosition(i);
			try {
				int temp = array[i];
				array[i] = array[minPos];
				array[minPos] = temp;
				indicated = i;
			} finally {

			}
			pause(1);
		}
	}
	
	//recursive helper method to fidn minimum postion 
	private int minimumPosition(int from) throws InterruptedException {
		int stored = from;
		minimumpos = stored;
		for(int i=from+1; i<array.length; i++) {
			try {
				if(array[i] < array[stored]) {
					stored = i;
					minimumpos = i;
				}
				position = i;
			} finally {

			}
			pause(1);
		}
		return stored;
	}
	
	//Demonstrates minimum position selected in the bar graph,  
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);

		g.drawString("Selection- Algorithm that repeatedly finds the minimum element and puts it at the beginning. ", 50, 50);
		try {
			
			for(int i=0; i<array.length; i++) {
				if(i == position) {
					g.setColor(Color.RED);
				} else if(i == minimumpos) {
					g.setColor(Color.ORANGE);
				} else if(i <= position) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.BLUE);
				}
				g.fillRect(100 + (i*10), 100, 8, array[i]*2);
			}
		} finally {

		}
	}

	
	public void pause(int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(DELAY * steps);
	}
}


