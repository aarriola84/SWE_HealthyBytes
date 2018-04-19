package healthybytes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @authors "Night owls"
 */
public class HealthyBytes extends Application
{
    MainView mainView = new MainView();
    
    @Override
    public void start(Stage primaryStage)
    {
        
        Scene scene = new Scene(mainView, 300, 250);
        
        primaryStage.setTitle("Healthy Bytes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
