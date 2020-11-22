import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigInteger;

public class CalculatorController {

    public TextField text;
    public TextField formula;
    private String operation;
    private double leftArg;

    public void input(ActionEvent p) {
        String input = getText(p);
        switch (input) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                text.setText(text.getText() + input);
                break;
            case "x ^ y":
            case "+":
            case "-":
            case "*":
            case "/":
                operation = input;
                leftArg = Double.parseDouble(text.getText());
                clear(p);
        }

    }

    public void clear(ActionEvent actionEvent) {
        text.setText("");
    }

    public void processBinary(ActionEvent actionEvent) throws ScriptException {
        if (!formula.getText().isEmpty()) {
            ScriptEngine engine = new NashornScriptEngineFactory().getScriptEngine("nashorn");
            formula.setText(String.valueOf(engine.eval(formula.getText())));
        }
        double rightArg = Double.parseDouble(text.getText());
        switch (operation) {
            case "x ^ y":
                text.setText(roundIfNeed(String.valueOf(Math.pow(leftArg, rightArg))));
                operation = "";
                break;
            case "+":
                text.setText(roundIfNeed(String.valueOf(leftArg + rightArg)));
                operation = "";
                break;
            case "-":
                text.setText(roundIfNeed(String.valueOf(leftArg - rightArg)));
                operation = "";
                break;
            case "*":
                text.setText(roundIfNeed(String.valueOf(leftArg * rightArg)));
                operation = "";
                break;
            case "/":
                text.setText(roundIfNeed(String.valueOf(leftArg / rightArg)));
                operation = "";
        }
    }

    public void processUnary(ActionEvent actionEvent) {
        String type = getText(actionEvent);
        switch (type) {
            case "Sqrt":
                text.setText(String.valueOf(
                        Math.sqrt(Double.parseDouble(text.getText()))
                        )
                );
                break;
            case "Bin":
                text.setText(new BigInteger(text.getText(), 10).toString(2));
                break;
            case "Dec":
                text.setText(new BigInteger(text.getText(), 2).toString(10));
        }
    }

    private String roundIfNeed(String str) {
        if (str.endsWith(".0")) {
            return str.substring(0, str.length() - 2);
        }
        return str;
    }

    private String getText(ActionEvent event) {
        return ((Button) event.getSource()).getText();
    }
}
