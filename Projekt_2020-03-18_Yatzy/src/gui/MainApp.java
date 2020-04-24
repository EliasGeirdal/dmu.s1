package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Yatzy;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Contains the face values of the 5 dice.
	private TextField[] txfValues = new TextField[5];
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds = new CheckBox[5];
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults = new TextField[15];

	// Create text fields for sums, bonus and total.
	private TextField txfSumSame = new TextField(), txfBonus = new TextField(), txfSumOther = new TextField(),
			txfTotal = new TextField();

	// Create labels for sums, bonus and total.
	private Label lblSumSame = new Label("Sum"), lblBonus = new Label("Bonus"), lblSumOther = new Label("Sum"),
			lblTotal = new Label("Total");

	// contains the sum, bonus.
	private int sumSame = 0;
	private int sumOther = 0;
	private int bonus = 0;
	// To receive a bonus, the sum of 1-s to 6-s, i.e. sumSame needs to be 63 or
	// above.
	private final int BONUS_CONDITION = 63;

	// Shows the number of times the dice has been rolled.
	private Label lblRolled = new Label("Rolled: ");

	// Button to roll the dices.
	private Button btnRoll = new Button("Roll");

	// Button to restart game.
	private Button btnRestart = new Button("Restart");

	// Shows the String for combinations.
	private String[] combinationNames = { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pairs",
			"Three Same", "Four same", "Full House", "Small Straight", "Large straight", "Chance", "Yatzy" };

	// labels for combinations.
	private Label[] lblCombinations = new Label[combinationNames.length];

	// Contains the values of the combinations.
	private TextField[] txfCombinations = new TextField[combinationNames.length];

	// Contains if check boxes are checked or unchecked.
	private boolean[] holds = { false, false, false, false, false };

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// Initialise txfValues, chbHolds, btnRoll and lblRolled
		for (int i = 0; i < 5; i++) {
			// check box placing and adding
			chbHolds[i] = new CheckBox("Hold");
			chbHolds[i].setPadding(new Insets(100, 0, 0, 0));
			dicePane.add(chbHolds[i], i, 1);
			chbHolds[i].setDisable(true);

			// text field placing and cosmetic editing.
			txfValues[i] = new TextField();
			txfValues[i].setMinHeight(100);
			txfValues[i].setMaxWidth(100);
			// remove highlight on dice text field.
			txfValues[i].setFocusTraversable(false);
			txfValues[i].setEditable(false);
			txfValues[i].setStyle("-fx-font: 50 default");
			// adding the textField.
			dicePane.add(txfValues[i], i, 0);
		}

		// Styling and adding the button to roll.
		btnRoll.setMinWidth(100);
		btnRoll.setMinHeight(50);
		btnRoll.setStyle("-fx-font: 24 default");
		dicePane.add(btnRoll, 0, 1);
		dicePane.add(lblRolled, 1, 1);

		// adding and styling the button to restart.
		btnRestart.setMinWidth(100);
		btnRestart.setMinHeight(50);
		btnRestart.setStyle("-fx-font: 24 default");
		btnRestart.setDisable(true);
		btnRestart.setFocusTraversable(false);
		dicePane.add(btnRestart, 4, 1);

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		// Initialise labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
		for (int i = 0; i < lblCombinations.length; i++) {
			// Create & add labels for combinations. (with names from combinationNames
			// array).
			lblCombinations[i] = new Label(combinationNames[i]);
			scorePane.add(lblCombinations[i], 0, i);
			// Create, add text fields containing thrown dice results. (getResult() method).
			txfCombinations[i] = new TextField();
			scorePane.add(txfCombinations[i], 1, i);
			// styling
			txfCombinations[i].setMaxWidth(w);
			txfCombinations[i].setDisable(true);
			txfCombinations[i].setEditable(false);
			txfCombinations[i].setFocusTraversable(false);

			// add & styling of labels and text fields for sum, bonus & total.
			if (i == 5) {
				// sum for 1-6
				scorePane.add(lblSumSame, 2, i);
				txfSumSame.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
				txfSumSame.setMaxWidth(w);
				scorePane.add(txfSumSame, 3, i);
				txfSumSame.setEditable(false);
				txfSumSame.setFocusTraversable(false);
				// bonus for 1-6
				scorePane.add(lblBonus, 4, i);
				txfBonus.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
				txfBonus.setMaxWidth(w);
				scorePane.add(txfBonus, 5, i);
				txfBonus.setEditable(false);
				txfBonus.setFocusTraversable(false);
			} else if (i == txfCombinations.length - 1) {
				// sum for yatzy
				scorePane.add(lblSumOther, 2, i);
				txfSumOther.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
				txfSumOther.setMaxWidth(w);
				scorePane.add(txfSumOther, 3, i);
				txfSumOther.setEditable(false);
				txfSumOther.setFocusTraversable(false);
				// total of all point values.
				scorePane.add(lblTotal, 4, i);
				txfTotal.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
				txfTotal.setMaxWidth(w);
				scorePane.add(txfTotal, 5, i);
				txfTotal.setEditable(false);
				txfTotal.setFocusTraversable(false);
			}
		}
		// Add event to btnRoll.
		btnRoll.setOnAction(event -> rollAction());
		// add event to btnRestart.
		btnRestart.setOnAction(event -> restart());

		// add mouse click event for 1-s to 6-s.
		for (int i = 0; i < 6; i++) {
			txfCombinations[i].setOnMouseClicked(event -> this.chooseFieldActionFirst(event));
		}
		// Add mouse click event for one-pair to yatzy.
		for (int i = 6; i < txfCombinations.length; i++) {
			txfCombinations[i].setOnMouseClicked(event -> this.chooseFieldActionSecond(event));
		}
	}

	// -------------------------------------------------------------------------
	// Initialise yatzy object.
	private Yatzy game = new Yatzy();

	/**
	 * Action method for the roll button.
	 */
	public void rollAction() {
		btnRestart.setDisable(false);
		setStyleSumBonusTotal();
		// Update holds array with checked check boxes.
		setHolds();
		// Throw dices.
		game.throwDice(holds);
		// Enables check boxes.
		setCheckBox(true);
		// Inserts the face values of the dices.
		setFaceValues();
		// Shows statistics of how many times the dices have been thrown.
		lblRolled.setText("Rolled: " + game.getThrowCount() + " times.");
		// Fill the combination values into corresponding index.
		fillResult();
		// Reset counters, disable button etc.
		endTurn();
	}

	/**
	 * Changes the values of holds array to true or false depending if the check box
	 * is selected.
	 */
	public void setHolds() {
		for (int i = 0; i < holds.length; i++) {
			holds[i] = chbHolds[i].isSelected();
		}
	}

	/**
	 * Set the face values of each dice into the text field of corresponding index.
	 */
	public void setFaceValues() {
		// Create local array containing the face values of each die.
		int[] faceValues = game.getValues();
		for (int i = 0; i < faceValues.length; i++) {
			txfValues[i].setText("" + faceValues[i]);
		}
	}

	/**
	 * Fill the combination values into corresponding index.
	 */
	public void fillResult() {
		int[] result = game.getResults();
		for (int i = 0; i < txfResults.length; i++) {
			// if the combination has been used - do not fill result. (id is set in
			// chooseFieldAction methods).
			if (txfCombinations[i].getId() != null) {
			} else {
				txfResults[i] = new TextField("" + result[i]);
				txfCombinations[i].setText("" + txfResults[i].getText());
			}
		}
	}

	/**
	 * Disable button, reset counter, disables check boxes, enable score fields.
	 */
	public void endTurn() {
		// player gets three throws before turn is ended.
		if (game.getThrowCount() == 3) {
			btnRoll.setDisable(true);
			game.resetThrowCount();
			setCheckBox(false);
			setCombinationFields(true);
		}
	}

	/**
	 * Action on click for 1-s to 6-s.
	 * 
	 * @param event mouse click event.
	 */
	public void chooseFieldActionFirst(Event event) {
		// initialise a reference to the text field clicked on.
		TextField txt = (TextField) event.getSource();
		txt.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
		// create an id for the text field. (To store that it has been clicked on).
		txt.setId("used");
		// update sum and total for 1-s to 6-s
		sumSame += Integer.parseInt(txt.getText());
		// check if bonus condition is met.
		if (sumSame >= BONUS_CONDITION) {
			bonus = 50;
		}
		txfSumSame.setText("" + sumSame);
		txfBonus.setText("" + bonus);
		txfTotal.setText("" + (sumSame + sumOther + bonus));
		// enable button, disable check boxes etc.
		startTurn();
	}

	/**
	 * Action on click for pairs - yatzy.
	 */
	public void chooseFieldActionSecond(Event event) {
		TextField txt = (TextField) event.getSource();
		txt.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
		txt.setId("used");
		// update sum and total for pairs - yatzy
		sumOther += Integer.parseInt(txt.getText());
		txfSumOther.setText("" + sumOther);
		txfTotal.setText("" + (sumSame + sumOther + bonus));
//		setCombinationFields(false);
		startTurn();
	}

	/**
	 * Reset dices to be empty, i.e. not thrown.
	 */
	public void resetFaceValues() {
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].clear();
			lblRolled.setText("Rolled: " + game.getThrowCount() + " times.");
		}
	}

	/**
	 * Start new turn.
	 */
	public void startTurn() {
		// enable button.
		btnRoll.setDisable(false);
		// disable check boxes.
		setCheckBox(false);
		// disable the score field to be accessed. i.e. setDisable(true).
		setCombinationFields(false);
		// set all check boxes to not selected.
		resetCheckBox();
		// set dices to null.
		resetFaceValues();
	}

	/**
	 * all check boxes are disabled or enabled.
	 * 
	 * @param enable set true to enable check box.
	 */
	private void setCheckBox(boolean enable) {
		for (int i = 0; i < chbHolds.length; i++) {
			chbHolds[i].setDisable(!enable);
		}
	}

	/**
	 * Enables the scoreField to be accessed. i.e. setDisable(false)
	 * 
	 * @param enable true to enable scoreField. Note: except text fields with the
	 *               id: "used".
	 */
	private void setCombinationFields(boolean enable) {
		for (int i = 0; i < txfCombinations.length; i++) {
			if (txfCombinations[i].getId() != null) {
				txfCombinations[i].setDisable(true);
			} else {
				txfCombinations[i].setDisable(!enable);
			}
		}
	}

	/**
	 * Reset all check boxes to not be selected.
	 */
	public void resetCheckBox() {
		for (int i = 0; i < chbHolds.length; i++) {
			chbHolds[i].setSelected(false);
		}
	}

	/**
	 * Restarts the game.
	 */
	public void restart() {
		// Set the combination values to null.
		resetCombinationFields();
		// Set sum, bonus and total to null.
		resetSumBonusTotal();
		// set throw count to 0.
		game.resetThrowCount();
		sumSame = 0;
		sumOther = 0;
		bonus = 0;
		// enable button, disable check boxes etc.
		startTurn();

	}

	/**
	 * Set the combination values to null.
	 */
	public void resetCombinationFields() {
		for (int i = 0; i < txfResults.length; i++) {
			txfCombinations[i].setText(null);
			txfCombinations[i].setStyle(null);
			txfCombinations[i].setId(null);
		}
	}

	/**
	 * Set sum, bonus and total to null.
	 */
	public void resetSumBonusTotal() {
		txfSumSame.setText(null);
		txfSumSame.setStyle(null);
		txfSumOther.setText(null);
		txfSumOther.setStyle(null);
		txfBonus.setText(null);
		txfBonus.setStyle(null);
		txfTotal.setText(null);
		txfTotal.setStyle(null);
	}

	/**
	 * Set text of sum, bonus and total to blue and bold.
	 */
	public void setStyleSumBonusTotal() {
		txfSumSame.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
		txfSumOther.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
		txfBonus.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");
		txfTotal.setStyle("-fx-text-fill: blue; -fx-font-weight: bold");

	}
}
