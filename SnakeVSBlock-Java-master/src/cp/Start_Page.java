//package cp;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class Start_Page extends Application{
//	
//	LeaderBoard leaderboard;
//	
//	/*Start_Page()
//	{
//		leaderboard =  new LeaderBoard();
//	}*/
//	
//	public static void main(String[] args) 
//	{
//		Application.launch(args);
//	}
//	
//	@Override
//	public void start(Stage stage) 
//	{
//		/*/ Create the Label for the Name
//		Label nameLbl = new Label("Name:");
//		// Set the position of the Label
//		nameLbl.relocate(10, 10);
//		// Create the TextField for the Name
//		TextField nameFld = new TextField();
//		// Set the position of the TextField
//		nameFld.relocate(50, 10);
//		// Create the Label for the Password
//		Label passwordLbl = new Label("Password:");
//		// Set the position of the Label
//		passwordLbl.relocate(200, 10);
//		// Create the TextField for the Password
//		TextField passwordFld = new TextField();
//		// Set the position of the TextField
//		passwordFld.relocate(260, 20);
//		// Create the Login Button
//		Button loginBtn = new Button("Login");
//		// Set the position of the Button
//		loginBtn.relocate(420, 10);*/
//		
//		Button StartBut = new Button("Start");
//		StartBut.setStyle(
//                "-fx-background-radius: 150em; " +
//                "-fx-min-width: 125px; " +
//                "-fx-min-height: 125px; " +
//                "-fx-max-width: 125px; " +
//                "-fx-max-height: 125px;"
//        );
//		
//		StartBut.relocate(420, 400);
//		
//		Button ResumeBut = new Button("Resume");
//		ResumeBut.setStyle(
//                "-fx-background-radius: 15000em; " +
//                "-fx-min-width: 110px; " +
//                "-fx-min-height: 110px; " +
//                "-fx-max-width: 110px; " +
//                "-fx-max-height: 110px;"
//        );
//		
//		Button LeadershipBut = new Button("Leader Board");
//		LeadershipBut.setStyle(
//                "-fx-background-radius: 15000em; " +
//                "-fx-min-width: 110px; " +
//                "-fx-min-height: 110px; " +
//                "-fx-max-width: 110px; " +
//                "-fx-max-height:110px;"
//        );
//		
//		
//		LeadershipBut.setOnAction(e -> {
//			
//			leaderboard =  new LeaderBoard();
//			Scene leaderscene = leaderboard.getboard();
//			stage.setScene(leaderscene);
//			// Set the title of the Stage
//			stage.setTitle("Lets Check the Lead");
//			// Display the Stage
//			stage.show();
//			
//		});
//		
////		StartBut.setOnAction(e -> {
////			Game_Page.my_main(stage);
////			
////		});
//		
//		// Create the GridPane
//		/*GridPane root = new GridPane();
//
//		root.add(StartBut, 1000, 9000);
//
//		root.add(ResumeBut, 300, 500);
//
//		root.add(LeadershipBut, 500, 500);
//		*/
//		AnchorPane.setLeftAnchor(StartBut, 160.0);
//		AnchorPane.setLeftAnchor(ResumeBut, 60.0);		
//		AnchorPane.setRightAnchor(LeadershipBut, 60.0);
//	
//		AnchorPane.setBottomAnchor(StartBut,170.0);
//		AnchorPane.setBottomAnchor(ResumeBut, 75.0);
//		AnchorPane.setBottomAnchor(LeadershipBut, 75.0);
//		AnchorPane root = new AnchorPane();
//		
//		// Set the padding of the GridPane
//		root.setStyle("-fx-padding: 10;"+
//				"-fx-border-style: solid inside;"+
//				"-fx-border-width: 2;"+
//				"-fx-border-insets: 5;"+
//				"-fx-border-radius: 5;"+
//				"-fx-border-color: blue;");
//		
//		/*root.setStyle("-fx-padding: 10;");
//		// Set the border-style of the GridPane
//		root.setStyle("-fx-border-style: solid inside;");
//		// Set the border-width of the GridPane
//		root.setStyle("-fx-border-width: 2;");
//		// Set the border-insets of the GridPane
//		root.setStyle("-fx-border-insets: 5;");
//		// Set the border-radius of the GridPane
//		root.setStyle("-fx-border-radius: 5;");
//		// Set the border-color of the GridPane
//		root.setStyle("-fx-border-color: blue;");
//		// Set the size of the GridPane*/	
//		root.setPrefSize(450,650);
//		root.getChildren().addAll(ResumeBut,StartBut,LeadershipBut);
//		/*.bodybg{
//    " -fx-background-image: url('/home/himanshu/Pictures/epicfight');"+
//     "-fx-background-size: 100% 100%;"    
//  }	*/
//		
//		// Create the Scene
//		Scene scene = new Scene(root);
//		// Add the scene to the Stage
//		stage.setScene(scene);
//		// Set the title of the Stage
//		stage.setTitle("Time to Play the Game");
//		// Display the Stage
//		stage.show();
//	}
//
//}
package cp;

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/** 
 * The start page which displays all the options of resume , start and leaderboards.
 * @author Dinesh Kumari
 *
 */
public class Start_Page extends Application{
	
	static Image image = new Image("file:svsb1-ConvertImage.png");
	
	static LeaderBoard leaderboard;
	
	/**
	 * Helper function for flow control
	 * @param args command line arguements
	 */
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) 
	{
		actual_start(stage);
	}
	
	/**
	 * Initialises page with buttons and their handlers
	 * @param stage Stage instance provided by application
	 */
	public static void actual_start(Stage stage)
	{
		Image imageOk = new Image("file:playfinal-ConvertImage.jpg");
		ImageView imagev = new ImageView(imageOk);
		imagev.setFitWidth(60);
		imagev.setFitHeight(50);
		Button StartBut = new Button();
		StartBut.setGraphic(imagev);

	    //graphicsContext.setEffect(new DropShadow(10, 0, 2, Color.GREY));
		
		/*DropShadow shadow = new DropShadow();
	    shadow.setOffsetY(1.0);
	    shadow.setOffsetX(1.0);
	    shadow.setColor(Color.WHITE);
	    StartBut.setEffect(shadow);*/
		
		StartBut.setStyle(
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
		
		
		Image imageOk2 = new Image("file:resume-ConvertImage.jpg");
		ImageView imagev2 = new ImageView(imageOk2);
		imagev2.setFitWidth(50);
		imagev2.setFitHeight(50);
		Button ResumeBut = new Button();
		ResumeBut.setGraphic(imagev2);
		ResumeBut.setStyle(
				"-fx-background-color:black;"+
				" -fx-border-color:white;"+
				"-fx-border-width: 3 3 3 3;"+
			    "-fx-border-radius: 150em;"+
			    "-fx-background-insets: 0;"+
				
                "-fx-background-radius: 15000em; " +
                "-fx-min-width: 110px; " +
                "-fx-min-height: 110px; " +
                "-fx-max-width: 110px; " +
                "-fx-max-height: 110px;"
        );
		
		
		Image imageOk1 = new Image("file:tropy1-ConvertImage.jpg");
		ImageView imagev1 = new ImageView(imageOk1);
		imagev1.setFitWidth(70);
		imagev1.setFitHeight(70);
		Button LeadershipBut = new Button();
		LeadershipBut.setGraphic(imagev1);
		
	
		//Button LeadershipBut = new Button("Leader Board");
		LeadershipBut.setStyle(
		    	"-fx-background-color:black;"+
			    " -fx-border-color:white;"+
			    "-fx-border-width: 3 3 3 3;"+
			    "-fx-border-radius: 150em;"+
			    "-fx-background-insets: 0;"+
			    
                "-fx-background-radius: 15000em; " +
                "-fx-min-width: 110px; " +
                "-fx-min-height: 110px; " +
                "-fx-max-width: 110px; " +
                "-fx-max-height:110px;"
        );
		
		ImageView imview =  new ImageView();
		imview.setImage(image);
		//imview.setPreserveRatio(true);
		imview.setFitHeight(720);
		imview.setFitWidth(450);
		
		
		
//		StartBut.setOnAction(e -> {
//			Game_Page.my_main(stage);
//			
//		});
		
		// Create the GridPane
		/*GridPane root = new GridPane();

		root.add(StartBut, 1000, 9000);

		root.add(ResumeBut, 300, 500);

		root.add(LeadershipBut, 500, 500);
		*/
		AnchorPane.setLeftAnchor(StartBut, 160.0);
		AnchorPane.setLeftAnchor(ResumeBut, 60.0);		
		AnchorPane.setRightAnchor(LeadershipBut, 60.0);
	
		AnchorPane.setBottomAnchor(StartBut,170.0);
		AnchorPane.setBottomAnchor(ResumeBut, 75.0);
		AnchorPane.setBottomAnchor(LeadershipBut, 75.0);
		AnchorPane root = new AnchorPane();
		
		// Set the padding of the GridPane
		/*root.setStyle("-fx-padding: 10;"+
				"-fx-border-style: solid inside;"+
				"-fx-border-width: 2;"+
				"-fx-border-insets: 5;"+
				"-fx-border-radius: 5;"+
				"-fx-border-color: blue;");*/
		
		// Set the size of the GridPane*/	
		root.setPrefSize(450,650);
		root.getChildren().addAll(imview,ResumeBut,StartBut,LeadershipBut);
		/*double height = root.getMaxHeight();
		double width = root.getMaxWidth();
		imview.setFitHeight(height);
		imview.setFitWidth(width);*/
		
		/*.bodybg{
    " -fx-background-image: url('/home/himanshu/Pictures/epicfight');"+
     "-fx-background-size: 100% 100%;"    
  }	*/
		
		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
		
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("Time to Play the Game");
		// Display the Stage
		stage.setResizable(false);
		
		stage.setHeight(700.0);
		stage.setWidth(455.0);
		stage.show();
		
		StartBut.setOnAction(e -> {			
			//add functionality here	
			Game_Page game = new Game_Page();
			game.start(stage);
			int score = game.scoree;
			System.out.println("Score : "+score);
			//show_again(stage);
		});
		
		ResumeBut.setOnAction(e -> {			
			//add functionality here
			Game_Page1 game = new Game_Page1();
			game.start(stage);
			int score = game.scoree;
		});
		
		LeadershipBut.setOnAction(e -> {			
			leaderboard =  new LeaderBoard();
			Scene leaderscene = leaderboard.getboard(stage,scene);
			stage.setScene(leaderscene);
			// Set the title of the Stage
			stage.setTitle("Lets Check the Lead");
			// Display the Stage
			stage.show();
			
		});
	}
	
	/**
	 * Initialises page with buttons and their handlers when game is saved atleast once.
	 * @param stage stage Stage instance provided by application
	 */
	public static void show_again(Stage stage)
	{	
		Image imageOk = new Image("file:playfinal-ConvertImage.jpg");
	ImageView imagev = new ImageView(imageOk);
	imagev.setFitWidth(60);
	imagev.setFitHeight(50);
	Button StartBut = new Button();
	StartBut.setGraphic(imagev);

    //graphicsContext.setEffect(new DropShadow(10, 0, 2, Color.GREY));
	
	/*DropShadow shadow = new DropShadow();
    shadow.setOffsetY(1.0);
    shadow.setOffsetX(1.0);
    shadow.setColor(Color.WHITE);
    StartBut.setEffect(shadow);*/
	
	StartBut.setStyle(
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
	
	
	Image imageOk2 = new Image("file:resume-ConvertImage.jpg");
	ImageView imagev2 = new ImageView(imageOk2);
	imagev2.setFitWidth(50);
	imagev2.setFitHeight(50);
	Button ResumeBut = new Button();
	ResumeBut.setGraphic(imagev2);
	ResumeBut.setStyle(
			"-fx-background-color:black;"+
			" -fx-border-color:white;"+
			"-fx-border-width: 3 3 3 3;"+
		    "-fx-border-radius: 150em;"+
		    "-fx-background-insets: 0;"+
			
            "-fx-background-radius: 15000em; " +
            "-fx-min-width: 110px; " +
            "-fx-min-height: 110px; " +
            "-fx-max-width: 110px; " +
            "-fx-max-height: 110px;"
    );
	
	
	Image imageOk1 = new Image("file:tropy1-ConvertImage.jpg");
	ImageView imagev1 = new ImageView(imageOk1);
	imagev1.setFitWidth(70);
	imagev1.setFitHeight(70);
	Button LeadershipBut = new Button();
	LeadershipBut.setGraphic(imagev1);
	

	//Button LeadershipBut = new Button("Leader Board");
	LeadershipBut.setStyle(
	    	"-fx-background-color:black;"+
		    " -fx-border-color:white;"+
		    "-fx-border-width: 3 3 3 3;"+
		    "-fx-border-radius: 150em;"+
		    "-fx-background-insets: 0;"+
		    
            "-fx-background-radius: 15000em; " +
            "-fx-min-width: 110px; " +
            "-fx-min-height: 110px; " +
            "-fx-max-width: 110px; " +
            "-fx-max-height:110px;"
    );
	
	ImageView imview =  new ImageView();
	imview.setImage(image);
	//imview.setPreserveRatio(true);
	imview.setFitHeight(720);
	imview.setFitWidth(450);
	
	
	
//	StartBut.setOnAction(e -> {
//		Game_Page.my_main(stage);
//		
//	});
	
	// Create the GridPane
	/*GridPane root = new GridPane();

	root.add(StartBut, 1000, 9000);

	root.add(ResumeBut, 300, 500);

	root.add(LeadershipBut, 500, 500);
	*/
	AnchorPane.setLeftAnchor(StartBut, 160.0);
	AnchorPane.setLeftAnchor(ResumeBut, 60.0);		
	AnchorPane.setRightAnchor(LeadershipBut, 60.0);

	AnchorPane.setBottomAnchor(StartBut,170.0);
	AnchorPane.setBottomAnchor(ResumeBut, 75.0);
	AnchorPane.setBottomAnchor(LeadershipBut, 75.0);
	AnchorPane root = new AnchorPane();
	
	// Set the padding of the GridPane
	/*root.setStyle("-fx-padding: 10;"+
			"-fx-border-style: solid inside;"+
			"-fx-border-width: 2;"+
			"-fx-border-insets: 5;"+
			"-fx-border-radius: 5;"+
			"-fx-border-color: blue;");*/
	
	// Set the size of the GridPane*/	
	root.setPrefSize(450,650);
	root.getChildren().addAll(imview,ResumeBut,StartBut,LeadershipBut);
	/*double height = root.getMaxHeight();
	double width = root.getMaxWidth();
	imview.setFitHeight(height);
	imview.setFitWidth(width);*/
	
	/*.bodybg{
" -fx-background-image: url('/home/himanshu/Pictures/epicfight');"+
 "-fx-background-size: 100% 100%;"    
}	*/
	
	// Create the Scene
	Scene scene = new Scene(root);
	// Add the scene to the Stage
	
	stage.setScene(scene);
	// Set the title of the Stage
	stage.setTitle("Time to Play the Game");
	// Display the Stage
	stage.setResizable(false);
	
	stage.setHeight(700.0);
	stage.setWidth(450.0);
	stage.show();
	
	StartBut.setOnAction(e -> {			
		//add functionality here	
		Game_Page game = new Game_Page();
		game.start(stage);
		int score = game.scoree;
		System.out.println("Score : "+score);
		//show_again(stage);
	});
	
	ResumeBut.setOnAction(e -> {			
		//add functionality here
		
	});
	
	LeadershipBut.setOnAction(e -> {			
		leaderboard =  new LeaderBoard();
		Scene leaderscene = leaderboard.getboard(stage,scene);
		stage.setScene(leaderscene);
		// Set the title of the Stage
		stage.setTitle("Lets Check the Lead");
		// Display the Stage
		stage.show();
		
	});
	}

}
