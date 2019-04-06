package cp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Drop box button on main game screen
 * @author Himanshu and Kartikey
 *
 */
public class dropbox {
	
	/**
	 * Creates and handles the pause button on game screen.
	 * @param gameloop AnimationTimer object of main game
	 * @param game_page Game_Page object from which it is called
	 * @param stage Stage on which all the game is imposed
	 * @param gaana holds the background melody of running game
	 */
	public static void display(AnimationTimer gameloop , Game_Page game_page , Stage  stage , AudioClip gaana)
	{
		gameloop.stop();
		Button exit  =  new Button("");
		exit.setStyle(
				"-fx-background-color:black;"+
					    " -fx-border-color:white;"+
					    "-fx-border-width: 3 3 3 3;"+
					    "-fx-border-radius: 150em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 150em; " +
		                "-fx-min-width: 125px; " +
		                "-fx-min-height: 125px; " +
		                "-fx-max-width: 125px; " +
		                "-fx-max-height: 125px;"
				
			);	
		
		Image image = new Image("file:cross-ConvertImage.jpg"); 
		ImageView imview =  new ImageView();
		imview.setImage(image);
		//imview.setPreserveRatio(true);
		imview.setFitHeight(80);
		imview.setFitWidth(80);
		exit.setGraphic(imview);
		
		Button restart =  new Button("");
		restart.setStyle(
				"-fx-background-color:black;"+
					    " -fx-border-color:white;"+
					    "-fx-border-width: 3 3 3 3;"+
					    "-fx-border-radius: 150em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 150em; " +
		                "-fx-min-width: 125px; " +
		                "-fx-min-height: 125px; " +
		                "-fx-max-width: 125px; " +
		                "-fx-max-height: 125px;"
				
			);
		
		Image image1 = new Image("file:resume-ConvertImage.jpg"); 
		ImageView imview1 =  new ImageView();
		imview1.setImage(image1);
		//imview.setPreserveRatio(true);
		imview1.setFitHeight(60);
		imview1.setFitWidth(60);
		restart.setGraphic(imview1);
		
		
		Button pause  =  new Button("");
		pause.setStyle(
				"-fx-background-color:black;"+
					    " -fx-border-color:white;"+
					    "-fx-border-width: 3 3 3 3;"+
					    "-fx-border-radius: 150em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 150em; " +
		                "-fx-min-width: 125px; " +
		                "-fx-min-height: 125px; " +
		                "-fx-max-width: 125px; " +
		                "-fx-max-height: 125px;"
				
			);	
		
		Image image3 = new Image("file:playfinal-ConvertImage.jpg"); 
		ImageView imview3 =  new ImageView();
		imview3.setImage(image3);
		//imview.setPreserveRatio(true);
		imview3.setFitHeight(65);
		imview3.setFitWidth(65);
		pause.setGraphic(imview3);

		
		Pane layout = new Pane();
		layout.getChildren().addAll(exit,restart,pause);
		
		exit.setLayoutX(160);
		restart.setLayoutX(160);
		pause.setLayoutX(160);
		exit.setLayoutY(100);
		restart.setLayoutY(250);
		pause.setLayoutY(420);
		
		Scene scene1 = new Scene(layout,450,650);
		scene1.setFill(Color.YELLOW);
		
		Stage popstage = new Stage();
		popstage.initModality(Modality.APPLICATION_MODAL);
		popstage.setOpacity(0.7);
		popstage.setScene(scene1);
		popstage.show();
		
		restart.setOnAction(e1 -> {
			popstage.close();
			Game_Page game = new Game_Page();
			game.start(stage);
		});
		
		exit.setOnAction(e1 -> {
			popstage.close();
			new save_game(game_page.mblock_wall1 , game_page.mblock_wall2 , game_page.mdeevar1 , game_page.mdeevar2 , 
					game_page.mball1 , game_page.mball2 ,game_page.mball3 , game_page.mbachao1 , game_page.mkheecho 
					, game_page.mdestroyer , game_page.snake_length , game_page.scoree);
			gaana.stop();
			Start_Page.actual_start(stage);
		});
		
		pause.setOnAction(e1 -> {
			popstage.close();
			gameloop.start();
		});
	}
	
	/**
	 * Creates and handles the pause button on game screen.
	 * @param gameloop AnimationTimer object of main game
	 * @param game_page Game_Page object from which it is called
	 * @param stage Stage on which all the game is imposed
	 * @param gaana holds the background melody of running game
	 */
	public static void display(AnimationTimer gameloop , Game_Page1 game_page , Stage stage , AudioClip gaana)
	{
		gameloop.stop();
		Button exit  =  new Button("");
		exit.setStyle(
				"-fx-background-color:black;"+
					    " -fx-border-color:white;"+
					    "-fx-border-width: 3 3 3 3;"+
					    "-fx-border-radius: 150em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 150em; " +
		                "-fx-min-width: 125px; " +
		                "-fx-min-height: 125px; " +
		                "-fx-max-width: 125px; " +
		                "-fx-max-height: 125px;"
				
			);	
		
		Image image = new Image("file:cross-ConvertImage.jpg"); 
		ImageView imview =  new ImageView();
		imview.setImage(image);
		//imview.setPreserveRatio(true);
		imview.setFitHeight(80);
		imview.setFitWidth(80);
		exit.setGraphic(imview);
		
		Button restart =  new Button("");
		restart.setStyle(
				"-fx-background-color:black;"+
					    " -fx-border-color:white;"+
					    "-fx-border-width: 3 3 3 3;"+
					    "-fx-border-radius: 150em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 150em; " +
		                "-fx-min-width: 125px; " +
		                "-fx-min-height: 125px; " +
		                "-fx-max-width: 125px; " +
		                "-fx-max-height: 125px;"
				
			);
		
		Image image1 = new Image("file:resume-ConvertImage.jpg"); 
		ImageView imview1 =  new ImageView();
		imview1.setImage(image1);
		//imview.setPreserveRatio(true);
		imview1.setFitHeight(60);
		imview1.setFitWidth(60);
		restart.setGraphic(imview1);
		
		
		Button pause  =  new Button("");
		pause.setStyle(
				"-fx-background-color:black;"+
					    " -fx-border-color:white;"+
					    "-fx-border-width: 3 3 3 3;"+
					    "-fx-border-radius: 150em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 150em; " +
		                "-fx-min-width: 125px; " +
		                "-fx-min-height: 125px; " +
		                "-fx-max-width: 125px; " +
		                "-fx-max-height: 125px;"
				
			);	
		
		Image image3 = new Image("file:playfinal-ConvertImage.jpg"); 
		ImageView imview3 =  new ImageView();
		imview3.setImage(image3);
		//imview.setPreserveRatio(true);
		imview3.setFitHeight(65);
		imview3.setFitWidth(65);
		pause.setGraphic(imview3);

		
		Pane layout = new Pane();
		layout.getChildren().addAll(exit,restart,pause);
		
		exit.setLayoutX(160);
		restart.setLayoutX(160);
		pause.setLayoutX(160);
		exit.setLayoutY(100);
		restart.setLayoutY(250);
		pause.setLayoutY(420);
		
		Scene scene1 = new Scene(layout,455.0,700);
		scene1.setFill(Color.YELLOW);
		
		Stage popstage = new Stage();
		popstage.initModality(Modality.APPLICATION_MODAL);
		//popstage.setOpacity(0.7);
		popstage.setScene(scene1);
		
		popstage.setHeight(700.0);
		popstage.setWidth(455.0);
		
		popstage.show();
		
		restart.setOnAction(e1 -> {
			popstage.close();
			Game_Page game = new Game_Page();
			game.start(stage);
		});
		
		exit.setOnAction(e1 -> {
			popstage.close();
			new save_game(game_page.mblock_wall1 , game_page.mblock_wall2 , game_page.mdeevar1 , game_page.mdeevar2 , 
					game_page.mball1 , game_page.mball2 ,game_page.mball3 , game_page.mbachao1 , game_page.mkheecho 
					, game_page.mdestroyer , game_page.snake_length , game_page.scoree);
			gaana.stop();
			Start_Page.actual_start(stage);
		});
		
		pause.setOnAction(e1 -> {
			popstage.close();
			gameloop.start();
		});
	}

}
