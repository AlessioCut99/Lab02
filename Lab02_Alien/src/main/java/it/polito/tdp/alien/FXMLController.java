/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblTesto"
    private TextField lblTesto; // Value injected by FXMLLoader

    @FXML // fx:id="bntTraslate"
    private Button bntTraslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="bntClear"
    private Button bntClear; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTraslate(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntTraslate != null : "fx:id=\"bntTraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntClear != null : "fx:id=\"bntClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
