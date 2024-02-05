/*************************************************************************************************************************
 * CMSC 22: Introduction to Object-Oriented Programming
 * Laboratory exercise (JavaFX)
 * Topic: Graphical User Interface I
 *
 * This is a simple Memory Card Game.
 *
 * Specifications:
 * - A 4x4 Grid of Cards was created for the Memory Game.
 * - The user should be able to flip open 2 cards at a time.
 * - Each time 2 cards are flipped up, that counts as 1 move.
 * - If the cards match, they will be kept face up.
 * - If the cards don’t match, they will be flipped face down after a delay of 1 second.
 * - Only 2 cards should ever be flipped up at once (not counting previously matched cards).
 * 	 That means the user should not be able to flip up more cards during the 1 second delay before cards are hidden again.
 * - When all the cards have been matched, the game over screen with the final move count will be displayed.
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 * @author Keith Ginoel S. Gabinete
 * @date 2023-05-06 17:26
 *
 *************************************************************************************************************************/

package memoryGame;

import javafx.application.Application;
import javafx.stage.Stage;

public class MemoryGame extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage){
		@SuppressWarnings("unused")
		MainGameStage gameStage = new MainGameStage(stage);
	}

}
