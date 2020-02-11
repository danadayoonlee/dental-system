package dentalSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DentalController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private ComboBox<String> provinceTextArea;
    
    public void initialize() {
    	provinceTextArea.getItems().addAll("Alberta", "Ontario", "Quebec");
    }

    @FXML
    private CheckBox flossingCheckBox;

    @FXML
    private CheckBox fillingCheckBox;

    @FXML
    private CheckBox rootCanalCheckBox;

    @FXML
    private RadioButton seniorRadio;

    @FXML
    private RadioButton kidsRadio;

    @FXML
    private RadioButton adultRadio;

    @FXML
    private Button calculateButton;

    @FXML
    private Label outputLabel;

    @FXML
    private ToggleGroup RadioToggleGroup;
    
    @FXML
    void calculateButtonClicked(ActionEvent event) {
    	float amount = 0;
    	if (flossingCheckBox.isSelected())
    	{
    		amount += 20;
    	}
    	if (fillingCheckBox.isSelected())
    	{
    		amount += 75;
    	}
    	if (rootCanalCheckBox.isSelected())
    	{
    		amount += 150;
    	}
    	float total = amount;
		if (seniorRadio.isSelected())
    	{
    		total *= 0.9;
    	}
    	if (kidsRadio.isSelected())
    	{
    		total *= 0.85;
    	}
		if (provinceTextArea.getValue().equals("Alberta"))
    	{
    		total *= 1.07;
    	}
    	if (provinceTextArea.getValue().equals("Ontario"))
    	{
    		total *= 1.13;
    	}
    	if (provinceTextArea.getValue().equals("Quebec"))
    	{
    		total *= 1.06;
    	}
    	String name = nameTextField.getText();
    	String address = addressTextField.getText();
    	outputLabel.setText("Payment detail: " + "Name: " + name + " " + "Address: " + address + " " + "Total amount: " + total);
    }
}