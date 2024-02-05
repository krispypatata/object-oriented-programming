package memoryGame;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverStage {
	private Scene scene;

	//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	// image for background
	public final Image bg = new Image("images/background.jpg",MainGameStage.WINDOW_WIDTH,MainGameStage.WINDOW_WIDTH,false,false);
	//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

	GameOverStage(int moveCount, int windowWidth){

		Canvas canvas = new Canvas(windowWidth, windowWidth);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// TODO: Add background to the canvas
		gc.drawImage(this.bg, 0, 0);

		// TODO: Add the move count message to the canvas
		// set font type, style and size
		Font theFont = Font.font("Times New Roman",FontWeight.BOLD,30);
		gc.setFont(theFont);

		gc.setFill(Color.BLACK);										//set font color of text
		gc.fillText("You finished the board in " + moveCount + " moves!", 0, windowWidth*0.3);				//add message

		// TODO: Create an exit button
		Button exitBtn = new Button("Exit Game");
		this.addEventHandler(exitBtn);

		// TODO: Create Stack pane and add the text and button to it
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(canvas, exitBtn);
		this.scene = new Scene(stackPane, windowWidth, windowWidth);
	}

	//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	private void addEventHandler(Button btn) {
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent exitBtn) {
				System.exit(0);
			}
		});

	}
	//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

	Scene getScene(){
		return this.scene;
	}
}
