package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
	    GridPane rootGridPane= loader.load();
	    controller=loader.getController();
	    controller.createPlayground();

	    Pane menuPane=(Pane)rootGridPane.getChildren().get(0);
	    MenuBar menuBar= createMenu();
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    menuPane.getChildren().add(menuBar);

	    Scene scene=new Scene(rootGridPane);

	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Connect4");
	    primaryStage.setResizable(false);
	    primaryStage.show();


    }
    private MenuBar  createMenu(){
	    Menu fileMenu= new Menu("File");
	    MenuItem newGame= new MenuItem("New Game");
	    newGame.setOnAction(event -> controller.newGame());
	    MenuItem resetGame= new MenuItem("Reset Game");
	    resetGame.setOnAction(event -> controller.resetGame());
	    SeparatorMenuItem s1=new SeparatorMenuItem();
	    MenuItem exitGame=new MenuItem("Exit Game");
	    exitGame.setOnAction(event -> exitGame());

	    Menu helpMenu=new Menu("Help");
	    MenuItem aboutGame=new MenuItem("About Connect 4");
	    MenuItem aboutMe=new MenuItem("About Me");
	    SeparatorMenuItem s2=new SeparatorMenuItem();
	    helpMenu.getItems().addAll(aboutGame,s2,aboutMe);

	    aboutGame.setOnAction(event -> aboutGame());
	    aboutMe.setOnAction(event -> aboutMe());

	    MenuBar menuBar=new MenuBar();
	    fileMenu.getItems().addAll(newGame,resetGame,s1,exitGame);
	    menuBar.getMenus().addAll(fileMenu,helpMenu);
	    return menuBar;

    }

	private void aboutMe() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Satyam Dalai");
		alert.setContentText("I love coding and wanted to create awesome games. " +
				"So here is the my first game developed by me.");
		alert.show();
	}

	private void aboutGame() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play?");
		alert.setContentText("Connect Four is a two-player connection game in which " +
				"the players first choose a color and then take turns dropping colored " +
				"discs from the top into a seven-column, six-row vertically suspended grid. " +
				"The pieces fall straight down, occupying the next available space within the column. " +
				"The objective of the game is to be the first to form a horizontal, vertical, or " +
				"diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.");
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

}
