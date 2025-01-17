/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary alienDictionary = new AlienDictionary();
	
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
    	lblTesto.clear();
    	txtResult.clear();
    	alienDictionary.resetDictionary();
    	
    }

    @FXML
    void doTraslate(ActionEvent event) {
    	
    	txtResult.clear();
		String riga = lblTesto.getText().toLowerCase();

		// Controllo sull'input
		if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		StringTokenizer st = new StringTokenizer(riga, " ");
		
		// Controllo su String Tokenizer (superfluo)
		if (!st.hasMoreElements()) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		// Estraggo la prima parola
		String alienWord = st.nextToken();

		if (st.hasMoreTokens()) {
			// Devo inserire nel dizionario

			// Estraggo la seconda parola
			String translation = st.nextToken();

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			// Aggiungo la parola aliena e traduzione nel dizionario
			alienDictionary.addWord(alienWord, translation);

			txtResult.setText("La parola: " + alienWord + " traduzione: " + translation + " è stata inserita.");

		} else {

			// Controllo che non ci siano caratteri non ammessi
			if (!alienWord.matches("[a-zA-Z?]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation;

			if (alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {

				// Traduzione con WildCard
				translation = alienDictionary.translateWordWildCard(alienWord);

			} else {

				// Traduzione classica
				translation = alienDictionary.translateWord(alienWord);
			}

			if (translation != null) {
				txtResult.setText(translation);
			} else {
				txtResult.setText("La parola cercata non esiste nel dizionario.");
			}
		}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntTraslate != null : "fx:id=\"bntTraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntClear != null : "fx:id=\"bntClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
