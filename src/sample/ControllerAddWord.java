package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerAddWord implements Initializable {
    @FXML
    private TextField textFieldAdjective;

    @FXML
    private TextField textFieldVerb;

    @FXML
    private CheckBox checkBoxVerb;

    @FXML
    private CheckBox checkBoxNoun;

    @FXML
    private Button buttonCancel;

    @FXML
    private TextField newWord;

    @FXML
    private TextField textFieldPronounce;

    @FXML
    private CheckBox checkBoxAdjective;

    @FXML
    private CheckBox checkBoxAdverb;

    @FXML
    private Button buttonOK;

    @FXML
    private TextField textFieldNoun;

    @FXML
    private TextField textFieldAdverb;


    AddFixRemoveWord  handlingWord = new AddFixRemoveWord("data.txt");

    public void clickOnVerb()
    {
        checkBoxVerb.setOnAction(e->{
            if(checkBoxVerb.isSelected())
                textFieldVerb.setEditable(true);
        });
    }

    public void clickOnAdjective()
    {
        checkBoxAdjective.setOnAction(e->{
            if(checkBoxAdjective.isSelected())
                textFieldAdjective.setEditable(true);
        });
    }
    public void clickOnAdverb()
    {
        checkBoxAdverb.setOnAction(e->{
            if(checkBoxAdverb.isSelected())
                textFieldAdverb.setEditable(true);
        });
    }
    public void clickOnNoun()
    {
        checkBoxNoun.setOnAction(e->{
            if(checkBoxNoun.isSelected())
                textFieldNoun.setEditable(true);
        });
    }

    public void cancel()
    {
        buttonCancel.setOnAction(e->{
            Stage stage = (Stage) buttonCancel.getScene().getWindow();
            stage.close();
        });
    }

    public String getTypeOfWord(String s)
    {
        if(s.equals("Danh từ"))
            return textFieldNoun.getText();
        else if(s.equals("Động từ"))
            return textFieldVerb.getText();
        else if(s.equals("Tính từ"))
            return textFieldAdjective.getText();
        else if (s.equals("Trạng từ"))
            return textFieldAdverb.getText();
        return null;
    }

    public void AddWord()
    {
        ArrayList<String> ingredientOfNewWord = new ArrayList<>();
        ingredientOfNewWord.add(newWord.getText());
        ingredientOfNewWord.add(textFieldPronounce.getText());
        CheckBox[] listCheckBox = {checkBoxNoun,checkBoxVerb,checkBoxAdjective,checkBoxAdverb};
        for (CheckBox check : listCheckBox)
        {
            if (check.isSelected())
            {
                ingredientOfNewWord.add(check.getText());
                ingredientOfNewWord.add(getTypeOfWord(check.getText()));
            }
        }
        handlingWord.AddWordAction(ingredientOfNewWord);
    }

    public void setWindowAddWordAgain()
    {
        checkBoxAdverb.setSelected(false);
        checkBoxAdjective.setSelected(false);
        checkBoxVerb.setSelected(false);
        checkBoxNoun.setSelected(false);
        newWord.setText("");
        textFieldPronounce.setText("");
        textFieldAdjective.setText("");
        textFieldVerb.setText("");
        textFieldAdverb.setText("");
        textFieldNoun.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldAdjective.setEditable(false);
        textFieldAdverb.setEditable(false);
        textFieldNoun.setEditable(false);
        textFieldVerb.setEditable(false);
        clickOnNoun();
        clickOnAdverb();
        clickOnVerb();
        clickOnAdjective();
        cancel();
        buttonOK.setOnAction(e -> {
            AddWord();
            setWindowAddWordAgain();
            try {
                Stage notificationWindow = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("notificationWindowAddWord.fxml"));
                notificationWindow.setTitle("Thông báo");
                notificationWindow.setScene(new Scene(root, 300, 80));

                notificationWindow.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
