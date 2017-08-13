package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;

public class Controller {
    private RPNStack rpnStack;
    private boolean lastActionWasOperator;
    private final String FILE_PATH;
    @FXML private TextField xRegister;
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

    public Controller() {
        rpnStack = new RPNStack();
        lastActionWasOperator = false;
        FILE_PATH = "files/storage.txt";
    }

    public void onOperandButtonClick(ActionEvent e) {
        if(lastActionWasOperator) {
            xRegister.clear();
            yRegister.setText(String.valueOf(rpnStack.peek()));
            lastActionWasOperator = false;
        }

        if(e.getSource().equals(button0))
            xRegister.setText(xRegister.getText() + "0");
        else if(e.getSource().equals(button1))
            xRegister.setText(xRegister.getText() + "1");
        else if(e.getSource().equals(button2))
            xRegister.setText(xRegister.getText() + "2");
        else if(e.getSource().equals(button3))
            xRegister.setText(xRegister.getText() + "3");
        else if(e.getSource().equals(button4))
            xRegister.setText(xRegister.getText() + "4");
        else if(e.getSource().equals(button5))
            xRegister.setText(xRegister.getText() + "5");
        else if(e.getSource().equals(button6))
            xRegister.setText(xRegister.getText() + "6");
        else if(e.getSource().equals(button7))
            xRegister.setText(xRegister.getText() + "7");
        else if(e.getSource().equals(button8))
            xRegister.setText(xRegister.getText() + "8");
        else if(e.getSource().equals(button9))
            xRegister.setText(xRegister.getText() + "9");
    }

    public void onOperatorButtonClick(ActionEvent e) { //if user clicks on + - * / buttons
        //if xRegister is not empty and stack has at least one item
        if(xRegister.getLength() != 0 && rpnStack.getSize() > 0) {
            if(! lastActionWasOperator) {
                rpnStack.push(Double.parseDouble(xRegister.getText()));
            }

            if(e.getSource().equals(buttonAdd)) {
                rpnStack.calculateOperation('+');
                yRegister.setText(String.valueOf(rpnStack.peekBefore()));
            } else if(e.getSource().equals(buttonSubtract)) {
                rpnStack.calculateOperation('-');
                yRegister.setText(String.valueOf(rpnStack.peekBefore()));
            } else if(e.getSource().equals(buttonMultiply)) {
                rpnStack.calculateOperation('*');
                yRegister.setText(String.valueOf(rpnStack.peekBefore()));
            } else {
                rpnStack.calculateOperation('/');
                yRegister.setText(String.valueOf(rpnStack.peekBefore()));
            }

            xRegister.setText(String.valueOf(rpnStack.peek()));
            lastActionWasOperator = true;
        }


    }

    public void onDecimalButtonClick() {
        if(! xRegister.getText().contains("."))
            xRegister.setText(xRegister.getText() + ".");
    }

    public void onEnterButtonClick() { //this method appears to be good
        if(! lastActionWasOperator) { //prevents user from keying something like "+" "ENTER"
            if(xRegister.getLength() != 0)
                rpnStack.push(Double.parseDouble(xRegister.getText()));

            yRegister.setText(String.valueOf(rpnStack.peek()));
            xRegister.clear();
        }
    }

    public void onBackButtonClick() {
        int length = xRegister.getLength();
        if(length > 0)
            xRegister.setText(xRegister.getText(0, length-1)); //removes the last char
    }

    public void onStoreButtonClick() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FILE_PATH), "utf-8"))){
            writer.write(String.valueOf(rpnStack.peek()));
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void onRetrieveButtonClick() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line = bufferedReader.readLine();
            xRegister.setText(line);
            lastActionWasOperator = false;
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onButtonResetClick() { //not working
        rpnStack.clearStack();
        xRegister.clear();
        yRegister.clear();
    }

}
