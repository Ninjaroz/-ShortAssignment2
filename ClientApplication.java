package JavaFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 * @author Gary
 *
 */
public class ClientApplication extends Application {
	// no arg constructor
	public ClientApplication() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	//Create an instance of the VideoSizeCalculator Javabean and GridPane
	GridPane grid = new GridPane();
	
	//Create fields in window and set their column locations
	TextField txtSeconds = new TextField();
	grid.add(txtSeconds, 0, 1);
	TextField txtType = new TextField();
	grid.add(txtType, 2, 1);
	Label lblSeconds = new Label ("Enter video length in seconds: ");
	grid.add(lblSeconds, 0, 0);
	Label lblType = new Label ("Enter video quality 720p or 1080p: ");
	grid.add(lblType, 2, 0);
	Label lblReqStorage = new Label ("Output here.");
	grid.add(lblReqStorage, 2, 2);
	Button btnSubmit = new Button();
	btnSubmit.setText("Calculate");
	grid.add(btnSubmit,0,2);
	Button btnClear = new Button();
	btnClear.setText("Clear fields");
	grid.add(btnClear,0,3);
	
	//Calculate button action
	btnSubmit.setOnAction((event) -> {
		VideoSizeCalculator newVideo = new VideoSizeCalculator();
		newVideo.setSeconds(Integer.parseInt(txtSeconds.getText()));
		newVideo.setType(txtType.getText());
		lblReqStorage.setText(newVideo.CalculateVideoSize());
		});
	
	//Clear button action
	btnClear.setOnAction((event) -> {
		lblReqStorage.setText("Output here");
		txtType.setText(null);
		txtSeconds.setText(null);
		});
	
    //Window properties 
    Scene scene = new Scene(grid, 400, 150);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
    primaryStage.setTitle("Video size Calculator");
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(5);
	grid.setVgap(5);
	
	}
	   public static void main(String[] args) {
	        launch(args);
	    }
}
