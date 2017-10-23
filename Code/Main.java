package Code;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = new AnchorPane();
			FXMLLoader d=new FXMLLoader();
			d.setLocation(getClass().getResource("/Graphic/MainWindow.fxml"));
			root=d.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/Graphic/source/application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
