package com.example.rock_paper_scissors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class RockPaperScissors extends Application {

    private enum Choice {
        ROCK, PAPER, SCISSORS
    }

    private Choice userChoice;
    private Choice computerChoice;
    private Label resultLabel;
    private Label scoreLabel;
    private int playerWins = 0;
    private int computerWins = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rock Paper Scissors");

        Label titleLabel = new Label("Rock Paper Scissors Game");
        titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        Label instructionLabel = new Label("Select your move:");

        Button rockButton = new Button("Rock");
        rockButton.setOnAction(e -> {
            userChoice = Choice.ROCK;
            playGame();
        });

        Button paperButton = new Button("Paper");
        paperButton.setOnAction(e -> {
            userChoice = Choice.PAPER;
            playGame();
        });

        Button scissorsButton = new Button("Scissors");
        scissorsButton.setOnAction(e -> {
            userChoice = Choice.SCISSORS;
            playGame();
        });

        resultLabel = new Label();
        scoreLabel = new Label("Score: Player - 0, Computer - 0");

        HBox buttonsBox = new HBox(10);
        buttonsBox.getChildren().addAll(rockButton, paperButton, scissorsButton);
        buttonsBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20);
        root.getChildren().addAll(titleLabel, instructionLabel, buttonsBox, resultLabel, scoreLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playGame() {
        computerChoice = generateComputerChoice();
        String result = determineWinner();
        resultLabel.setText(result);
        updateScore(result);
    }

    private Choice generateComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3); // Generates random number between 0 and 2
        switch (choice) {
            case 0:
                return Choice.ROCK;
            case 1:
                return Choice.PAPER;
            case 2:
                return Choice.SCISSORS;
            default:
                return Choice.ROCK;
        }
    }

    private String determineWinner() {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        } else if ((userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                (userChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||
                (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)) {
            playerWins++;
            return "You win!";
        } else {
            computerWins++;
            return "Computer wins!";
        }
    }

    private void updateScore(String result) {
        scoreLabel.setText("Score: Player - " + playerWins + ", Computer - " + computerWins);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
