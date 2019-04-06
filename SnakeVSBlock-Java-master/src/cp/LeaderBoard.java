package cp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.FontFamilyAction;


/**
 * This class manages and displays the Leader Board of the game featuring top 10 performers.
 * @author Himanshu and Kartikey
 *
 */
public class LeaderBoard implements Serializable {
	
	private Text t;
	private Player playa;
	private String filename ;
	private File f;
	private Image image = new Image("file:leader background 2.jpeg");
	
	
	public LeaderBoard()
	{
		try
		{
			filename = "score.text";
			f = new File("score.txt");
			if(!f.createNewFile() || f.length() == 0)  // file does not exits, so not object to save from and creates the new file
			{
				playa = new Player();
			}
			else
			{
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream fiso = new ObjectInputStream(fis);
				playa = (Player)fiso.readObject();
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
		
	}
	
	
	
	/**
	 * This methods creates and sets all the elements of the Leaderboard in the scene and returns it.
	 * @param stage from the Home page for the funtionality of the return button. 
	 * @param startscene from the Home page for the funtionality of the return button.
	 * @return the scene containing all the text and button to the Home page.
	 */
	public Scene getboard(Stage stage,Scene startscene)
	{
		AnchorPane root = new AnchorPane();
		
		
		Text heading = new Text();
		heading.setText("LEADER BOARD");
		//heading.setFont(Font.font ("GEORGIA", 25));
		//heading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
		heading.setFont(Font.font("System",FontWeight.LIGHT, 35));
		heading.setStrokeWidth(2);
		heading.setStroke(Color.DARKGREY);
		heading.setFill(Color.WHITE);
		heading.setStyle(
			"-fx-font-family: serif;"+
			"-fx-font-smoothing-type: lcd;"
		);
		
		Image imageOk2 = new Image("file:return-ConvertImage.jpg");
		ImageView imagev2 = new ImageView(imageOk2);
		imagev2.setFitWidth(50);
		imagev2.setFitHeight(50);
		Button ReturnBut = new Button();
		ReturnBut.setGraphic(imagev2);
		ReturnBut.setStyle(
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
		// content for the leaderboard by text
		
		Text content = new Text();
		/*content.setText("1  Chris 560"+"\n"+
				"2  Raman 500"+"\n"+
				"3  Paul  459"+"\n"+
				"4  Raju  450"+"\n"+
				"5  Rishi 405"+"\n"+
				"6  Harsh 350"+"\n"+
				"7  Anand 300"+"\n"+
				"8  Arish 260"+"\n"+
				"9  Lalan 200"+"\n"+
				"10 Avi  145");*/
		content.setText(getContent());
		content.setFont(Font.font ("Georgia", 25));
		content.setFill(Color.WHITE);
		content.setLayoutX(70);
		content.setLayoutY(130);
		
		
		// table presentation
		
		/*TableView<Scoredata> table = new TableView<Scoredata>();
		// TableColumn<Scoredata, Integer> index1 = new TableColumn<Scoredata, Integer>("Rank");
		 TableColumn<Scoredata, String> date2 = new TableColumn<Scoredata, String>("Date");
		 TableColumn<Scoredata, Integer> score3 = new TableColumn<Scoredata, Integer>("Score");
		
		 //index1.setCellValueFactory(new PropertyValueFactory<>("Rank"));
		 date2.setCellValueFactory(new PropertyValueFactory<>("Date"));
		 score3.setCellValueFactory(new PropertyValueFactory<>("Score"));
		 
		 //index1.setSortable(false);
		 date2.setSortable(false);
		 score3.setSortable(false);
		
		 ObservableList<Scoredata> list = getUserList();
	      table.setItems(list);
		 
	      table.setItems(list);
		 table.getColumns().addAll(date2,score3);
		 
		 table.setLayoutX(100);
		 table.setLayoutY(100);
		 table.setFixedCellSize(10); */
		
		
		

		AnchorPane.setBottomAnchor(heading,582.0);
		AnchorPane.setLeftAnchor(heading,75.0);
	
		/*AnchorPane.setBottomAnchor(content,270.0);
		AnchorPane.setLeftAnchor(content,120.0);*/
		
		AnchorPane.setBottomAnchor(ReturnBut,10.0);
		AnchorPane.setLeftAnchor(ReturnBut,150.0);
		
		ImageView imview =  new ImageView();
		imview.setImage(image);
		//imview.setPreserveRatio(true);
		imview.setFitHeight(720);
		imview.setFitWidth(450);
		
		
		// Set the padding of the GridPane
		root.setStyle("-fx-padding: 10;"+
				"-fx-border-style: solid inside;"+
				"-fx-border-width: 2;"+
				"-fx-border-insets: 5;"+
				"-fx-border-radius: 5;"+
				"-fx-border-color: blue;");
		
		ReturnBut.setOnAction(e -> {			
			stage.setScene(startscene);
			// Set the title of the Stage
			stage.setTitle("Lets Check the Lead");
			// Display the Stage
			stage.show();
			
		});
			
		root.setPrefSize(450,650);
		
		root.getChildren().addAll(imview,heading,content,ReturnBut);

		
		Scene scene = new Scene(root);
		return scene;
	}
	
	/*public ObservableList<Scoredata> getUserList() {
		 
		try {
			
			File f = new File("score.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream fiso = new ObjectInputStream(fis);
			Player p = (Player) fiso.readObject();
			
			System.out.println("Leaderboard = " + p);
			
			if(fiso==null)
			{
				return null;
			}
			else
			{
				ObservableList<Scoredata> datalist = FXCollections.observableArrayList();
				for(int i=0;i<p.getList().size();i++)
				{
					datalist.add(p.getList().get(i));
					System.out.println(datalist.get(i).getDate() +" "+datalist.get(i).getScore());
				}
				return datalist;
			}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
	 
	     // ObservableList<UserAccount> list = FXCollections.observableArrayList(user1, user2, user3);
		return null;
		//return list;
	  }*/
	
	/**
	 * 
	 * @return the String value containing the information of the top 10 performers
	 */
	public String getContent() 
	{
		String content = "NO  CONTENT  AVAILABLE";
		try {
			
			File f = new File("score.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream fiso = new ObjectInputStream(fis);
			Player p = (Player) fiso.readObject();
			
			System.out.println("Leaderboard = " + p);
			
			if(fiso==null)
			{
				return content;
			}
			else
			{
				content = "RANK" +"     "+"DATE"+"        "+"SCORE"+"\n\n";
				content = content +p.getString();
				return content;
			}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return content;
	}
	
	
}
