/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

/**
 *
 * @author Dhanasit
 */
public class FXMLDocumentController implements Initializable {
    
    private MediaPlayer mediaPlayer;
    
    
    
    @FXML
    private MediaView mediaView;
    
    @FXML
    private Label label;
    private String filePath;
    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       //Create a fileChooser and add the extension.
       FileChooser fileChooser = new FileChooser();
       FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.mp4)","*.mp4" );
       fileChooser.getExtensionFilters().add(filter);
       
       //Open the fileChooser
       File file = fileChooser.showOpenDialog(null);
       filePath = file.toURI().toString(); 
       
       System.out.println(filePath);
       
       //If a file is selected, set up the media, media player, and media view, and play.
       if(filePath != null) {
           Media media = new Media(filePath);
           mediaPlayer = new MediaPlayer(media);
           mediaView.setMediaPlayer(mediaPlayer);
           
                //Bind the media.
                DoubleProperty width = mediaView.fitWidthProperty();
                DoubleProperty height = mediaView.fitHeightProperty();
                width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
           
           mediaPlayer.play();
       }
       
       
       
       
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
