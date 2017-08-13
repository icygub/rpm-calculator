package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private RPNStack rpnStack;
    private boolean lastActionWasOperator;
    @FXML private TextField textDisplay;
    @FXML private TextField yRegister;
    @FXML private Button button0;
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button buttonAdd;
    @FXML private Button buttonSubtract;
    @FXML private Button buttonMultiply;
    @FXML private Button buttonDivide;
    @FXML private Button buttonEnter;
    @FXML private Button buttonDecimal;
    @FXML private Button buttonStore;
    @FXML private Button buttonRetrieve;
    @FXML private Button buttonBack;

    public Controller() {
        rpnStack = new RPNStack();
        lastActionWasOperator = false;
    }

    public void onOperandButtonClick(ActionEvent e) {
        if(lastActionWasOperator) {
            textDisplay.clear();
            yRegister.setText(String.valueOf(rpnStack.peek()));
            lastActionWasOperator = false;
        }


        if(e.getSource().equals(button0))
            textDisplay.setText(textDisplay.getText() + "0");
        else if(e.getSource().equals(button1))
            textDisplay.setText(textDisplay.getText() + "1");
        else if(e.getSource().equals(button2))
            textDisplay.setText(textDisplay.getText() + "2");
        else if(e.getSource().equals(button3))
            textDisplay.setText(textDisplay.getText() + "3");
        else if(e.getSource().equals(button4))
            textDisplay.setText(textDisplay.getText() + "4");
        else if(e.getSource().equals(button5))
            textDisplay.setText(textDisplay.getText() + "5");
        else if(e.getSource().equals(button6))
            textDisplay.setText(textDisplay.getText() + "6");
        else if(e.getSource().equals(button7))
            textDisplay.setText(textDisplay.getText() + "7");
        else if(e.getSource().equals(button8))
            textDisplay.setText(textDisplay.getText() + "8");
        else if(e.getSource().equals(button9))
            textDisplay.setText(textDisplay.getText() + "9");
    }

    public void onOperatorButtonClick(ActionEvent e) {
        if(textDisplay.getLength() != 0) { //&& !lastActionWasOperator) {
            rpnStack.push(Double.parseDouble(textDisplay.getText()));

            if(e.getSource().equals(buttonAdd)) {
                rpnStack.calculateOperation('+');
                yRegister.setText(String.valueOf(rpnStack.peekBefore()));
            }

            textDisplay.setText(String.valueOf(rpnStack.peek()));
            lastActionWasOperator = true;
        }


    }

    public void onDecimalButtonClick() {
        if(! textDisplay.getText().contains("."))
            textDisplay.setText(textDisplay.getText() + ".");
    }

    public void onEnterButtonClick() { //this method appears to be good
        if(! lastActionWasOperator) { //prevents user from keying something like "+" "ENTER"
            if(textDisplay.getLength() != 0)
                rpnStack.push(Double.parseDouble(textDisplay.getText()));
            yRegister.setText(String.valueOf(rpnStack.peek()));
            textDisplay.clear();
        }
    }

    public void onBackButtonClick() {
        int length = textDisplay.getLength();
        if(length > 0)
            textDisplay.setText(textDisplay.getText(0, length-1)); //removes the last char
    }

    public void onStoreRetrieveButtonClick(ActionEvent e) {

    }

}
