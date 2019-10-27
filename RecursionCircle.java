import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RecursionCircle extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		circlePane pane = new circlePane();
		Scene scene = new Scene(pane,250,250);
		Stage stage = new Stage();
		
		
		primaryStage.setTitle("Recursion Circles");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.requestFocus();
	}

}


//class to draw a circle in a pane
class circlePane extends Pane {
	
	private Color[] colors = {Color.RED,Color.BLUE,Color.ORANGE,Color.PINK,Color.BLUEVIOLET,Color.TEAL};
	
	private int num = 1;
	private int color = 0;
	
	circlePane(){
		
		this.drawButtons();
		drawCircle(1,true);
		
	}
	
	
	//draw a circle with a recursive method
	int drawCircle(int amount,boolean clear){
		
		//will determine whether pane needs to be cleared or not
		if (clear) {
			getChildren().clear();
			this.drawButtons();
		}

		//creating a new circle object
		Circle circle = new Circle(amount * 5);
		circle.setCenterX(125);
		circle.setCenterY(125);
		circle.setStroke(colors[color]);
		color++;
		circle.setFill(Color.TRANSPARENT);
		
		getChildren().addAll(circle);
		
		//set color to beginning of array again if is out of bounds
		if (color >= colors.length - 1) {
			color = 0;
		}
		
		
		if (amount == num) {
			return 1;
		} else {
			return drawCircle(amount += 1,false);
		}
	}
	
	
	//draw the buttons in the pane
	void drawButtons() {
		Button add = new Button("+");
		add.setLayoutX(15);
		add.setLayoutY(15);
		
		Button remove = new Button("-");
		remove.setLayoutX(205);
		remove.setLayoutY(15);
		
		add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				if (num > 20) {
					//do nothing
				} else {
					color = 0;
					num += 1;
					drawCircle(1,true);
				}
			}
		});
		
		remove.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				if (num <= 1) {
					//do nothing
				} else {
					color = 0;
					num -= 1;
					drawCircle(1,true);
				}
				
			}
			
		});
		
		getChildren().addAll(add,remove);
	}
	
	
}


















