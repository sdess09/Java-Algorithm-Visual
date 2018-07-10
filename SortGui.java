import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * Used Rohit Chhatre as a reference 
 * Used Big JAVA Textbook 
 * @author 
 * Soham Dessai
 *
 */
public class SortGui  extends JComponent{


	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SortGui component = new SortGui();
		frame.add(component);

		frame.setVisible(true);
		component.AnimationStart();
	}

	private SelectionSort selectionSorter;
	private BubbleSort bubbleSorter;
	private InsertionSort insertionSorter;

	public SortGui() {
		
		//creates 3 viewers 
		int[] array1 = Randomizer();
		int[] array2 = array1.clone();
		int[] array3 = array1.clone();
		
		
		bubbleSorter = new BubbleSort(array1, this);
		
		selectionSorter = new SelectionSort(array3, this);
		
		insertionSorter = new InsertionSort(array2, this);
	}



	public void paintComponent(Graphics g) {
		insertionSorter.draw(g);
		selectionSorter.draw(g);
		bubbleSorter.draw(g);
		
		
	}
	
	//randomized the array list using shuffle 
	public int[] Randomizer() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1; i<=50; i++) {
			nums.add(i);
		}
		Collections.shuffle(nums);
		int[] arr = new int[50];
		for(int x=0; x<arr.length; x++) {
			arr[x] = nums.get(x);
		}

		return arr;
	}

	public void AnimationStart() {
	
		//runs runnable thread for the sorts 
		class InsertionRunnable implements Runnable {
			public void run() {
				try {
					insertionSorter.sort();
				} 
				
				catch(InterruptedException e) {

				}
			}
		}
		//runs runnable thread for the sorts 
		class SelectionRunnable implements Runnable {
			public void run() {
				try {
					selectionSorter.sort();
				}
				
				catch(InterruptedException e) {

				}
			}
			
		}
		//runs runnable thread for the sorts 
		class BubbleRunnable implements Runnable {
			public void run() {
				try {
					bubbleSorter.sort();
				} catch(InterruptedException e) {

				}
			}
		}

		
		//runnable 
		Runnable i = new InsertionRunnable();
		Thread ti = new Thread(i);
		ti.start();
		
		//runnable 
		Runnable b = new BubbleRunnable();
		Thread tb = new Thread(b);
		tb.start();
		//runnable
		Runnable s = new SelectionRunnable();
		Thread ts = new Thread(s);
		ts.start();
	}
}

