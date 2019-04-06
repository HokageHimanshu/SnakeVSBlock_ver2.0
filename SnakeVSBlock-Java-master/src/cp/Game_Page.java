package cp;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Main game page which handles all the events in the game.
 * @author Himanshu and Kartikey
 *
 */
public class Game_Page
{
	block_wall mblock_wall1;
	block_wall mblock_wall2;
	
	wall mdeevar1;
	wall mdeevar2;
	
	ball mball1;
	ball mball2;
	ball mball3;
	
	shield mbachao1;
	destroy_blocks mdestroyer;
	magnet mkheecho;
	
	int scoree=0;
	int game_complete=0;
	int snake_length=0;
	
	/**
	 * Helper function for flow control.
	 * @param stage Stage on which whole game is set up
	 */
	public void start(Stage stage)
	{
		my_main(stage);
	}
	
	/**
	 * Main handler function consisting of infinite loop
	 * @param stage Stage on which whole game is set up
	 */
	public void my_main(Stage stage)
	{
		Pane pane = new Pane();
		Scene scene = new Scene(pane , 450 ,600 , Color.BLACK);
		temp_snake saanp = new temp_snake(pane);
		//AudioClip collide = new AudioClip();
		
		/*------------------------------------------------------*/
		
		EventHandler<MouseEvent> lol = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
         		//System.out.println(head_ball.getCenterX()+" "+head_ball.getCenterY());
				/*-------------------------Wall code ------------------*/
				
//					saanp.set_coordinate_of_head((int)e.getX(), 330);
//					saanp.move_snake();
				if(mdeevar1!=null)
				{
					if(mdeevar1.getY() >= 325-150 && mdeevar1.getY()-70 <= 335)
					{
						int lower=0;
						int upper=450;
						for(int i=0 ; i<mdeevar1.dande.size()-1 ; i++)
						{
							if(mdeevar1.dande.get(i).getLayoutX() <= saanp.ret_head_ball().getCenterX()
									&& mdeevar1.dande.get(i+1).getLayoutX() >= saanp.ret_head_ball().getCenterX()) {
								lower = (int)mdeevar1.dande.get(i).getLayoutX();
								upper = (int)mdeevar1.dande.get(i+1).getLayoutX();
							}
						}
						if(saanp.ret_head_ball().getCenterX() >=0 && 
								saanp.ret_head_ball().getCenterX() <= mdeevar1.dande.get(0).getLayoutX()) {
							lower = 0;
							upper = (int)mdeevar1.dande.get(0).getLayoutX();
						}
						if(saanp.ret_head_ball().getCenterX() <=450 && 
								saanp.ret_head_ball().getCenterX() >= mdeevar1.dande.get(mdeevar1.dande.size()-1).getLayoutX()) {
							lower = (int)mdeevar1.dande.get(mdeevar1.dande.size()-1).getLayoutX();
							upper = 450;
						}
						System.out.println("bounds1 "+lower+" "+upper);
						if(e.getX()<=upper && e.getX()>=lower) {
							saanp.set_coordinate_of_head((int)e.getX(), 330);
							saanp.move_snake();
						}	
					}
				}
				if(mdeevar2!=null)
				{
					if(mdeevar2.getY() >= 325-150 && mdeevar2.getY()-70 <= 335)
					{
						int lower=0;
						int upper=450;
						for(int i=0 ; i<mdeevar2.dande.size()-1 ; i++)
						{
							if(mdeevar2.dande.get(i).getLayoutX() <= saanp.ret_head_ball().getCenterX()
									&& mdeevar2.dande.get(i+1).getLayoutX() >= saanp.ret_head_ball().getCenterX()) {
								lower = (int)mdeevar2.dande.get(i).getLayoutX();
								upper = (int)mdeevar2.dande.get(i+1).getLayoutX();
							}
						}
						if(saanp.ret_head_ball().getCenterX() >=0 && 
								saanp.ret_head_ball().getCenterX() <= mdeevar2.dande.get(0).getLayoutX()) {
							lower = 0;
							upper = (int)mdeevar2.dande.get(0).getLayoutX();
						}
						if(saanp.ret_head_ball().getCenterX() <=450 && 
								saanp.ret_head_ball().getCenterX() >= mdeevar2.dande.get(mdeevar2.dande.size()-1).getLayoutX()) {
							lower = (int)mdeevar2.dande.get(mdeevar2.dande.size()-1).getLayoutX();
							upper = 450;
						}
						System.out.println("bounds2 "+lower+" "+upper);
						if(e.getX()<=upper && e.getX()>=lower) {
							saanp.set_coordinate_of_head((int)e.getX(), 330);
							saanp.move_snake();
						}	
					}
				}
				if(mdeevar1==null || !(mdeevar1.getY() >= 325-150 && mdeevar1.getY()-70 <= 335) && 
						(mdeevar2==null || !(mdeevar2.getY() >= 325-150 && mdeevar2.getY()-70 <= 335)))
				{
					saanp.set_coordinate_of_head((int)e.getX(), 330);
					saanp.move_snake();
				}
			}
		};
		scene.addEventFilter(MouseEvent.ANY, lol);
		
		Text score  = new Text();
		score.prefHeight(50);
		score.prefWidth(50);
		score.setLayoutX(220);
		score.setLayoutY(120);
		score.setStyle("-fx-font: 50 arial;");
		score.toFront();
		score.setFill(Color.BLACK);
		score.setText(Integer.toString(scoree));
		pane.getChildren().add(score);
		
		String resource = getClass().getResource("game2.mp3").toString();
		AudioClip gana =new AudioClip(resource);
		gana.play();
		
		AnimationTimer gameloop = new AnimationTimer() {
			
			block_wall block_wall1 = new block_wall(saanp.len(),pane);
			block_wall block_wall2;
			
			wall deevar1 = new wall(pane);
			wall deevar2;
			
			ball ball1 = new ball(pane);
			ball ball2;
			ball ball3;
			
			shield bachao1 = new shield(pane);
			
			magnet kheecho = new magnet(pane);
			
			destroy_blocks destroyer = new destroy_blocks(pane);
			
			@Override
			public void handle(long now)
			{
				if(saanp.len() == 0) {
					gana.stop();
					Media hit = new Media(new File("game_over.wav").toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
					this.stop();
					stopgame(this,scoree);
					Start_Page.show_again(stage);
				}
				scene.setFill(Color.BLACK);
				score.setText(Integer.toString(scoree));
				/*------------------- box motion code--------------------------*/
				block_wall1.translate(block_wall1.getY()+5,pane);
				deevar1.translate(deevar1.getY()+5,pane);
				ball1.translate(ball1.getY()+5,pane);
				bachao1.translate(bachao1.getY()+5,pane);
				kheecho.translate(kheecho.getY()+5,pane);
				destroyer.translate(destroyer.getY()+5, pane);
				
				if(block_wall1.getY() == 75)
					ball3 = new ball(pane);
				
				if(block_wall1.getY() == 300) {
					block_wall2 = new block_wall(saanp.len(),pane);
					if(bachao1.getY() >= 600)
						bachao1 = new shield(pane);
					deevar2 = new wall(pane);
					ball2 = new ball(pane);
				}
				
				if(bachao1.getY() == 300 && kheecho.getY() >= 600) {
					kheecho = new magnet(pane);
				}
				
				if(kheecho.getY() == 500 && destroyer.getY()>=600)
					destroyer = new destroy_blocks(pane);
				
				if(block_wall2!=null) {
					block_wall2.translate(block_wall2.getY()+5,pane);
				}
				
				if(deevar2!=null)
					deevar2.translate(deevar2.getY()+5,pane);
				
				if(ball2!=null)
					ball2.translate(ball2.getY()+5,pane);
				
				if(ball3!=null)
					ball3.translate(ball3.getY()+5,pane);
				
				if(block_wall1.getY() == 800) {
					block_wall1 = new block_wall(saanp.len(),pane);
					deevar1 = new wall(pane);
					ball1 = new ball(pane);
				}
				/*----------------------------------------------------------*/
				/*--------------------Shield--------------------------------*/
				if(saanp.is_shielded())
					if(block_wall1.getY()%20 == 0)
						saanp.change_color();
				if(block_wall1.getY()>=790) {
					saanp.take_shield();
					if(!saanp.is_shielded())
						saanp.set_red();
				}
				/*----------------------------------------------------------*/
				/*--------------------destroyer------------------------------*/
				if(block_wall1!=null)
				{
					if(saanp.is_destroyer() && block_wall1.getY()<=330 && block_wall1.getY()>=0)
					{
						for(block temp : block_wall1.wall)
						{
							temp.pane.setVisible(false);
						}
					}
				}
				if(block_wall2!=null)
				{
					if(saanp.is_destroyer() && block_wall2.getY()<=330 && block_wall2.getY()>=0)
					{
						for(block temp : block_wall2.wall)
						{
							temp.pane.setVisible(false);
						}
					}
				}
				/*-----------------------------------------------------------*/
				/*---------------------Magnet-------------------------------*/
				if(saanp.is_magnetic() && block_wall1.getY()>=700) {
					saanp.take_magnet();
					saanp.set_red();
				}
				if(saanp.is_magnetic())
				{
					if(block_wall1.getY()%50==0)
					{
						saanp.set_color(Color.WHEAT);
					}
				}
				if(saanp.is_magnetic())
				{
					if(ball1!=null)
					{
						if(ball1.getY() >= 310 && ball1.getY() <= 330)
						{
							for(int i=0 ; i<ball1.balls.size() ; i++)
							{
								point point = ball1.balls.get(i);
								int pos = (int)ball1.balls.get(i).spane.getLayoutX();
								if(Math.abs(pos-saanp.ret_head_ball().getCenterX())<=150)
								{
									System.out.println("turrrrrraaaaaaa");
									if(pos>=saanp.ret_head_ball().getCenterX())
										point.setc(point.c.getx()-35,point.c.gety());
									else
										point.setc(point.c.getx()+35,point.c.gety());
								}
							}
						}
					}
					if(ball2!=null)
					{
						if(ball2.getY() >= 310 && ball2.getY() <= 330)
						{
							for(int i=0 ; i<ball2.balls.size() ; i++)
							{
								point point = ball2.balls.get(i);
								int pos = (int)ball2.balls.get(i).spane.getLayoutX();
								if(Math.abs(pos-saanp.ret_head_ball().getCenterX())<=150)
								{
									if(pos>=saanp.ret_head_ball().getCenterX())
										point.setc(point.c.getx()-35,point.c.gety());
									else
										point.setc(point.c.getx()+35,point.c.gety());
								}
							}
						}
					}
					if(ball3!=null)
					{
						if(ball3.getY() >= 310 && ball3.getY() <= 330)
						{
							for(int i=0 ; i<ball3.balls.size() ; i++)
							{
								point point = ball3.balls.get(i);
								int pos = (int)ball3.balls.get(i).spane.getLayoutX();
								if(Math.abs(pos-saanp.ret_head_ball().getCenterX())<=150)
								{
									System.out.println("turrrrrraaaaaaa");
									if(pos>=saanp.ret_head_ball().getCenterX())
										point.setc(point.c.getx()-35,point.c.gety());
									else
										point.setc(point.c.getx()+35,point.c.gety());
								}
							}
						}
					}
				}
				/*-----------------------------------------------------------*/
				/*----------------- Collision -------------------------*/
				collision_with_blocks(block_wall1 , block_wall2 , saanp , pane);
				collision_with_balls(ball1 , ball2 , ball3 , saanp , pane);
				collision_with_shield(bachao1 ,saanp,pane);
				collision_with_magnet(kheecho , saanp , pane);
				collision_with_destroyer(destroyer , saanp , pane);
				/*----------------------------------------------------------*/
				/* ------------------- Save state in class variables --------------- */
				mblock_wall1 = block_wall1;
				mblock_wall2 = block_wall2;
				
				mdeevar1 = deevar1;
				mdeevar2 = deevar2;
				
				mball1 = ball1;
				mball2 = ball2;
				mball3 = ball3;
				
				mbachao1 = bachao1;
				mdestroyer = destroyer;
				mkheecho = kheecho;
				snake_length = saanp.len();
				/*-------------------------------------------------------------------*/
			}	
		};
		gameloop.start();
		stage.setOnCloseRequest(event -> {
			gameloop.stop();
			System.out.println("bye bye");
			if(game_complete == 0)
				new save_game(mblock_wall1 , mblock_wall2 , mdeevar1 , mdeevar2 , 
					mball1 , mball2 , mball3 , mbachao1 , mkheecho , mdestroyer , saanp.len() , scoree );
		});
		/*-------------------------------------
		Button pause = new Button("Pause");
		pane.getChildren().add(pause);
		pause.setLayoutX(0);
		pause.prefHeight(2);
		pause.prefWidth(4);
		pause.setLayoutY(575);
		scene.setFill(Color.BLACK);
		saanp.set_coordinate_of_head(200, 400);
		Button pause1 = new Button("play");
		pane.getChildren().add(pause1);
		pause1.setLayoutX(0);
		pause1.prefHeight(2);
		pause1.prefWidth(4);
		pause1.setLayoutX(400);
		pause1.setLayoutY(575);
		scene.setFill(Color.BLACK);
		saanp.set_coordinate_of_head(200, 400);
		
		pause.setOnAction(e ->{
				gameloop.stop();
		});
		pause1.setOnAction(e ->{
			gameloop.start();
		});
		----------------*/
		
		/*----------------------------------------------*/
		Button dropbutton = new Button("");
		dropbutton.setStyle(
				"-fx-background-color:white;"+
					    " -fx-border-color:grey;"+
					    "-fx-border-width: 2 2 2 2;"+
					    "-fx-border-radius: 10em;"+
					    "-fx-background-insests: 0;"+
						
		                "-fx-background-radius: 10em; " +
		                "-fx-min-width: 65px; " +
		                "-fx-min-height: 65px; " +
		                "-fx-max-width: 65px; " +
		                "-fx-max-height: 65px;"
				
			);
		
		Image image = new Image("file:dop2.png"); 
		ImageView imview =  new ImageView();
		imview.setImage(image);
		//imview.setPreserveRatio(true);
		imview.setFitHeight(74.6);
		imview.setFitWidth(74.6);
		dropbutton.setGraphic(imview);
		
		dropbutton.setLayoutX(13);
		dropbutton.setLayoutY(570);
		pane.getChildren().add(dropbutton);
		dropbutton.setOnAction(e -> dropbox.display(gameloop,this,stage,gana));
		/*-----------------------------------------------*/
		
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Manages , updates and saves score once game finishes.
	 * @param gameloop infinite loop instance
	 * @param score score at completion of game
	 */
	public void stopgame(AnimationTimer gameloop, int score)
	{
		gameloop.stop();
		Player p = new Player();
		p.updatescore(score);
		p.checksize();
		p.savetofile();
	}
	
	/**
	 * Generates Animation when snake collides with block 
	 * @param x X coordinate of point of intersection of snake and block
	 * @param y Y coordinate of point of intersection of snake and block
	 * @param pane main game screen layout which adds components into it.
	 */
	public void animation(int x , int y , Pane pane)
	{
		for(int i=0 ; i<8 ; i++)
		{
			Circle temp = new Circle();
// 			temp.setCenterX(e.getX());
// 			temp.setCenterY(e.getY());
 			temp.setFill(Color.BLACK);
 			temp.setRadius(3);
 			pane.getChildren().add(temp);
 			Line l=null;
 			if(i==0)
 				l = new Line(x,y,x+8000,y+2000);
 			if(i==1)
 				l = new Line(x,y,x+2000,y+8000);
 			if(i==2)
 				l = new Line(x,y,x-2000,y+8000);
 			if(i==3)
 				l = new Line(x,y,x-8000,y+2000);
 			if(i==4)
 				l = new Line(x,y,x-8000,y-2000);
 			if(i==5)
 				l = new Line(x,y,x-2000,y-8000);
 			if(i==6)
 				l = new Line(x,y,x+2000,y-8000);
 			if(i==7)
 				l = new Line(x,y,x+8000,y-2000);
		    PathTransition pathTransition = new PathTransition();
		    pathTransition.setDuration(Duration.millis(1500));
		    pathTransition.setNode(temp);
		    pathTransition.setPath(l);
		    pathTransition.play();
		}
	}
	
	/**
	 * Collision handler of shield collectible and snake
	 * @param bachao shield object reference
	 * @param saanp snake object reference
	 * @param pane main game screen layout which adds components into it.
	 */
	public  void collision_with_shield(shield bachao , temp_snake saanp , Pane pane)
	{
		if(bachao!=null)
		{
			point shield = bachao.shields.get(0);
			if(shield.spane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent())) {
				saanp.give_shield();
				shield.spane.setVisible(false);
				
			}
		}
	}
	
	/**
	 * Collision handler of block destroyer collectible and snake
	 * @param destroyer block destroyer object reference
	 * @param saanp snake object reference
	 * @param pane main game screen layout which adds components into it.
	 */
	public  void collision_with_destroyer(destroy_blocks destroyer , temp_snake saanp , Pane pane)
	{
		if(destroyer!=null)
		{
			point dest = destroyer.destroy_blocks.get(0);
			if(dest.spane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent())) {
				saanp.give_destroyer();
				dest.spane.setVisible(false);
				Media hit = new Media(new File("destroyer.wav").toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.play();
			}
		}
	}
	
	/**
	 * Collision handler of magnet collectible and snake
	 * @param kheecho magnet object reference
	 * @param saanp snake object reference
	 * @param pane main game screen layout which adds components into it.
	 */
	public  void collision_with_magnet(magnet kheecho , temp_snake saanp , Pane pane)
	{
		if(kheecho!=null)
		{
			point magnet = kheecho.magnets.get(0);
			if(magnet.spane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent())) {
				saanp.give_magnet();
				magnet.spane.setVisible(false);
				Media hit = new Media(new File("shoot.mp3").toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.play();
			}
		}
	}
	
	/**
	 * Collision handler of blocks and snake
	 * @param block_wall1 Wall of blocks 1
	 * @param block_wall2 Wall of blocks 2
	 * @param saanp object reference of snake
	 * @param pane main game screen layout which adds components into it.
	 */
	public  void collision_with_blocks(block_wall block_wall1, block_wall block_wall2 , temp_snake saanp , Pane pane)
	{
		boolean detected = false;
		for(int i=0 ; i<block_wall1.wall.size() ; i++)
		{
			block block = block_wall1.wall.get(i);
			if(block.pane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent()) && block.pane.getLayoutY()+80==330
					&& (int)block.pane.getLayoutX() < saanp.ret_head_ball().getCenterX() && (int)block.pane.getLayoutX()+90 > saanp.ret_head_ball().getCenterX()) {
				if(saanp.is_destroyer())
				{
					saanp.take_destroyer();
					return;
				}
				detected = true;
				animation((int)saanp.ret_head_ball().getCenterX(),(int)saanp.ret_head_ball().getCenterY(),pane);
				
				System.out.println("tamacha 1");
				if(saanp.len() <= Integer.parseInt(block.text.getText()))
				{
					System.out.println("khali karo");
					scoree+=saanp.len();
					if(!saanp.is_shielded())
						saanp.empty_it(pane);
				}
				else
				{
					int n = Integer.parseInt(block.text.getText());
					try {
						if(n>5) {
							Thread.sleep(200);
							animation((int)saanp.ret_head_ball().getCenterX(),(int)saanp.ret_head_ball().getCenterY(),pane);
						}
					}catch(Exception e) {System.out.println(e);}
					if(!saanp.is_shielded())
						saanp.cut_short(n , pane);
					scoree+=n;
					pane.getChildren().remove(block.pane);
					block_wall1.wall.remove(i);
					Media hit = new Media(new File("pop.wav").toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
				}
			}
			if(detected)
				return;
		}
		if(block_wall2!=null)
		{
			for(int i=0 ; i<block_wall2.wall.size() ; i++)
			{
				block block = block_wall2.wall.get(i);
				if(block.pane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent())&& block.pane.getLayoutY()+90==330
						&& (int)block.pane.getLayoutX() < saanp.ret_head_ball().getCenterX() && (int)block.pane.getLayoutX()+90 > saanp.ret_head_ball().getCenterX()) {
					if(saanp.is_destroyer())
					{
						saanp.take_destroyer();
						return;
					}
					detected = true;
					animation((int)saanp.ret_head_ball().getCenterX(),(int)saanp.ret_head_ball().getCenterY(),pane);
					
					System.out.println("tamacha 2");
					if(saanp.len() <= Integer.parseInt(block.text.getText()))
					{
						System.out.println("khali karo");
						if(!saanp.is_shielded())
							saanp.empty_it(pane);
						scoree+=saanp.len();
					}
					else
					{
						int n = Integer.parseInt(block.text.getText());
						try {
							if(n>5) {
								Thread.sleep(200);
								animation((int)saanp.ret_head_ball().getCenterX(),(int)saanp.ret_head_ball().getCenterY(),pane);
							}
						}catch(Exception e) {System.out.println(e);}
						if(!saanp.is_shielded())
							saanp.cut_short(n , pane);
						scoree+=n;
						pane.getChildren().remove(block.pane);
						block_wall2.wall.remove(i);
						Media hit = new Media(new File("pop.wav").toURI().toString());
						MediaPlayer mediaPlayer = new MediaPlayer(hit);
						mediaPlayer.play();
					}
				}
				if(detected)
					return;
			}
		}
	}
	
	
	/**
	 * Collision handler of balls/coins and snake
	 * @param ball1 list of coins 1
	 * @param ball2 list of coins 2
	 * @param ball3 list of coins 3
	 * @param saanp object reference of snake
	 * @param pane main game screen layout which adds components into it.
	 */
	public  void collision_with_balls(ball ball1, ball ball2 , ball ball3 , temp_snake saanp , Pane pane )
	{
		if(ball1 != null)
		{
			for(int i=0 ; i<ball1.balls.size() ; i++)
			{
				point temp  = ball1.balls.get(i);
				if(temp.spane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent()))
				{
					String s = ball1.text.get(ball1.balls.indexOf(temp)).getText();
					//temp.spane.setVisible(false);
					pane.getChildren().remove(temp.spane);
					ball1.balls.remove(i);
					int to_add = Integer.parseInt(s);
					for(int j=0 ; j<to_add ; j++)
						saanp.add(pane);
					System.out.println(saanp.len()+" 1");
					Media hit = new Media(new File("coin.wav").toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
				}
			}
		}
		if(ball2 != null)
		{
			for(int i=0 ; i<ball2.balls.size() ; i++)
			{
				point temp = ball2.balls.get(i);
				if(temp.spane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent()))
				{
					String s = ball2.text.get(ball2.balls.indexOf(temp)).getText();
					//temp.spane.setVisible(false);
					pane.getChildren().remove(temp.spane);
					ball2.balls.remove(i);
					int to_add = Integer.parseInt(s);
					for(int j=0 ; j<to_add ; j++)
						saanp.add(pane);
					System.out.println(saanp.len()+" 2");
					Media hit = new Media(new File("coin.wav").toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
				}
			}
		}
		if(ball3 != null)
		{
			for(int i=0 ; i<ball3.balls.size() ; i++)
			{
				point temp = ball3.balls.get(i);
				if(temp.spane.getBoundsInParent().intersects(saanp.ret_head_ball().getBoundsInParent()))
				{
					String s = ball3.text.get(ball3.balls.indexOf(temp)).getText();
					pane.getChildren().remove(temp.spane);
					//temp.spane.setVisible(false);
					ball3.balls.remove(i);
					int to_add = Integer.parseInt(s);
					System.out.println("to_add "+to_add);
					for(int j=0 ; j<to_add ; j++)
						saanp.add(pane);
					System.out.println(saanp.len()+" 3");
					Media hit = new Media(new File("coin.wav").toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
				}
			}
		}
	}
}
