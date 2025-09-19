package project1;

import bag.BagInterface;
import cs2.Button;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;

public class ShapeWindow {

	/**
	 * the window that holds the graphical user interface
	 */
	private Window window;

	/**
	 * the Quit button which exits the application
	 */
	private Button quitButton;

	/**
	 * the chosee button which displays an item from the bag
	 */
	private Button chooseButton;

	/**
	 * the text shape used to display the bag item
	 */
	private TextShape textShape;

	/**
	 * thr bag containing strings to display
	 */
	private BagInterface<String> itemBag;

	/**
	 * Constructs a ShapeWindow with a given bag of strings.
	 *  Initializes the window,
	 * adds buttons, and sets up the text shape.
	 *
	 * @param bag the bag of strings to display
	 */
	public ShapeWindow(BagInterface<String> bag) {
		window = new Window();
		window.setTitle("Project 1");
		itemBag = bag;

		// Initialize and set up the Quit button.
		quitButton = new Button("Quit");
		quitButton.onClick(this, "clickedQuit");
		window.addButton(quitButton, WindowSide.NORTH);

		// Initialize and set up the Choose button.
		chooseButton = new Button("Choose");
		chooseButton.onClick(this, "clickedChoose");
		window.addButton(chooseButton, WindowSide.SOUTH);

		// Initialize the TextShape at (0, 0) with an empty string.
		textShape = new TextShape(0, 0, "");
		window.addShape(textShape);
	}

	/**
	 * Event handler for the Quit button. Exits the application.
	 *
	 * @param button the Quit button that was clicked
	 */
	public void clickedQuit(Button button) {
		System.exit(0);
	}

	/**
	 * Event handler for the Choose button. Removes an item from the bag and
	 * displays it. If the bag is empty,
	 *  displays "No more items." The text color is
	 * set based on the content, and the text is centered within the window.
	 *
	 * @param button the Choose button that was clicked
	 */
	public void clickedChoose(Button button) {
		String item = itemBag.remove();
		if (item == null) {
			textShape.setText("No more items.");
		} else {
			textShape.setText(item);
		}
		colorText(textShape.getText());
		centerText();
	}

	/**
	 * sets the text color of the text shape based on its content.
	 *
	 * @param text the text to evaluate
	 */
	private void colorText(String text) {
		if (text.contains("red")) {
			textShape.setForegroundColor(Color.RED);
		} else if (text.contains("blue")) {
			textShape.setForegroundColor(Color.BLUE);
		} else {
			textShape.setForegroundColor(Color.BLACK);
		}
	}

	/**
	 * centers the text shape in the window
	 *  by calculating the proper x and y coords
	 */
	private void centerText() {
		int panelWidth = window.getGraphPanelWidth();
		int panelHeight = window.getGraphPanelHeight();
		int textWidth = textShape.getWidth();
		int textHeight = textShape.getHeight();
		int newX = (panelWidth - textWidth) / 2;
		int newY = (panelHeight - textHeight) / 2;

		// use the setX and setY methods to repositionTextShape.
		textShape.setX(newX);
		textShape.setY(newY);
	}
}





