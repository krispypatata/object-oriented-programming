package memoryGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainGameStage {
	private Scene scene;
	private Stage stage;

	private Group root;
	private Canvas scoreCanvas;
	private GridPane cardGrid = new GridPane();

	// The window is square so height is also 500
	public final static int WINDOW_WIDTH = 500;
	public final static int WINDOW_PADDING = 50;

	// the grid is square to the columns are also 4
	private final static int CARD_ROWS = 4;
	private final static int CARD_PADDING = 5;

	private Boolean startedPairOpening = false;
	private Boolean flippingAllowed = true;

	private Card[] openedCards = new Card[2];
	private int totalMatchedPairs = 0;
	private int moveCount = 0;


	//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	// image for background
	public final Image bg = new Image("images/background.jpg",MainGameStage.WINDOW_WIDTH,MainGameStage.WINDOW_WIDTH,false,false);
	// create a drawer/GraphicsContext for Canvas
	private GraphicsContext gc;
	// array list for cards
	private ArrayList<Card> cardCells;
	// cardboard
	private int[][] cardBoard;
	//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000


	public MainGameStage(Stage stage) {

		this.stage = stage;

		this.root = new Group();

		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		// initialize cardBoard
		this.cardBoard = new int[MainGameStage.CARD_ROWS][MainGameStage.CARD_ROWS];
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000


		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		// TODO: Set background image Canvas
		this.scoreCanvas = new Canvas(MainGameStage.WINDOW_WIDTH, MainGameStage.WINDOW_WIDTH);
		this.gc =  scoreCanvas.getGraphicsContext2D();
		this.gc.drawImage(bg, 0, 0);
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

		// initializes the game elements (score display, cards)
		initGameElements();



		this.scene = new Scene(root, WINDOW_WIDTH, WINDOW_WIDTH, Color.WHITE);

		this.stage.setTitle("Memory Game");
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	// Adds the score Canvas and card GridPane
	public void initGameElements() {

		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		// TODO: Create score canvas and add it to the root group
		this.root.getChildren().add(scoreCanvas);
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

		// Sets up the Card GridPane and add it to the root group
		initCards();
		root.getChildren().add(cardGrid);

	}

	private void initCards(){

		// Initalizes the 16 Cards, randomize their values, and add it to the grid
		this.addCardsToGrid();

		// Sets the layout properties of the 4x4 card grid
		this.setGridLayoutProperties();
	}

	private void addCardsToGrid() {

		// calculates card length (square) based on window size, padding, number of cards in grid, and padding in between
		int cardLength = ((WINDOW_WIDTH - (WINDOW_PADDING * 2)) - ((CARD_ROWS - 1) * CARD_PADDING)) / CARD_ROWS;


		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		// TODO: Instantiate 16 cards with random values from 1-8, distributed among them twice. Add these cards to the gridPane property
        Random r = new Random();
		for (int number=0; number<8; number++) {
			// will contain the value of the card
			int cardValue = number+1;

			// generate random numbers for the index of the first card in the cardboard
			int i1 = r.nextInt(4);
			int j1 = r.nextInt(4);

			// find an empty card field in the cardBoard
			while (cardBoard[i1][j1] != 0) {
				i1 = r.nextInt(4);
				j1 = r.nextInt(4);
			}

			// assign the card value to the empty node
			cardBoard[i1][j1] = cardValue;

			// generate random numbers for the index of the second card in the cardboard
			int i2 = r.nextInt(4);
			int j2 = r.nextInt(4);

			// find an empty card field in the cardBoard
			while (cardBoard[i2][j2] != 0) {
				i2 = r.nextInt(4);
				j2 = r.nextInt(4);
			}
			// assign the card value to the empty node
			cardBoard[i2][j2] = cardValue;
		}

		// print
		for(int i=0;i<MainGameStage.CARD_ROWS;i++){
			System.out.println(Arrays.toString(this.cardBoard[i]));//print final board content
		}

		// add these cards to the gridPaneProperty
		for(int i=0;i<MainGameStage.CARD_ROWS;i++){
			for(int j=0;j<MainGameStage.CARD_ROWS;j++){

				// Instantiate cards
				Card card = new Card(this, cardBoard[i][j], cardLength);

				//add each card to the array list cardCells
				this.cardCells.add(card);
			}
		}
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

	}

	// Layout properties such as padding around the grid, between the cards, etc.
	private void setGridLayoutProperties(){
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		// TODO: Set layout properties. Use the WINDOW_WITH, WINDOW_PADDING, CARD_WIDTH, CARD_PADDING properties
		this.cardGrid.setPrefSize(MainGameStage.WINDOW_WIDTH - (WINDOW_PADDING * 2), MainGameStage.WINDOW_WIDTH - (WINDOW_PADDING * 2));
		this.cardGrid.setLayoutX(MainGameStage.WINDOW_WIDTH*0.15);
	    this.cardGrid.setLayoutY(MainGameStage.WINDOW_WIDTH*0.15);
	    this.cardGrid.setVgap(5);
	    this.cardGrid.setHgap(5);

	    //loop that will set the constraints of the elements in the grid pane
	     int counter=0;
	     for(int row=0;row<MainGameStage.CARD_ROWS;row++){
	    	 for(int col=0;col<MainGameStage.CARD_ROWS;col++){
	    		 // map each card's constraints
	    		 GridPane.setConstraints(cardCells.get(counter).getImageView(),col,row);
	    		 counter++;
	    	 }
	     }
		  //loop to add each card element to the gridpane/cardGrid
	     for(Card cardCell: cardCells){
	    	 this.cardGrid.getChildren().add(cardCell.getImageView());
	     }
	   //0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	}


	private void updateScore() {
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
		// TODO: Clear the score canvas and display an updated one
		gc.clearRect(0, 0, MainGameStage.WINDOW_WIDTH, MainGameStage.WINDOW_WIDTH);
		initGameElements();
		//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	}


	void checkState(Card card) {

		// TODO: Disable flipping face down of the first card until a second card is revealed
		this.flippingAllowed = false;

		// this takes note of the first opened card
		if (!startedPairOpening) {
			openedCards[0] = card;
		}

		// this takes note of the second opened card
		else {
			openedCards[1] = card;

			// TODO: Update move count after every 2 cards opened
			this.moveCount++;

			// TODO: Disable flipping cards globally while game state is checked
			this.flippingAllowed = false;

			// TODO: If the cards match, no need to hide them again. Allow flipping cards again immediately
			if (openedCards[0].getValue() == openedCards[1].getValue()) {
				this.flippingAllowed = true;

				// TODO: Check if all cards have been matched. If yes, display game over scene, else continue the game
				if (this.totalMatchedPairs == 8) {
					displayGameOverScene();
				}
			}

			// TODO: If the cards don't match. Hide them after a 1 second delay. Do not allow flipping of other cards during the delay
			else {
				PauseTransition transition = new PauseTransition(Duration.seconds(1));
				transition.play();

				// TODO: After the delay, flip down the 2 revealed cards. Enable flipping again after the delay
				openedCards[0].flip();
				openedCards[1].flip();
				this.flippingAllowed = true;
			}
		}


		// This is for keeping track of the cards opened
		startedPairOpening = !startedPairOpening;
	}

	Boolean isFlippingAllowed() {
		return flippingAllowed;
	}


	private void displayGameOverScene(){
		PauseTransition transition = new PauseTransition(Duration.seconds(1));
		transition.play();

		transition.setOnFinished(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				GameOverStage gameover = new GameOverStage(moveCount, WINDOW_WIDTH);
				stage.setScene(gameover.getScene());
			}
		});
	}

}

