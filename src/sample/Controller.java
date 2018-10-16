package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button buttonRefresh;

    @FXML
    private TextField textfeildSearch;

    @FXML
    private Button buttonRemoveWord;

    @FXML
    private Button buttonTranslate;

    @FXML
    private Button buttonFixWord;

    @FXML
    private Button buttonExportFile;

    @FXML
    private Button buttonAddWord;

    @FXML
    private TextField textfeildPronounce;

    @FXML
    private ListView listWord;

    @FXML
    private TextArea textArea;

    Word word = new Word("data.txt");
    ArrayList<String> arr = word.creatWordList();

    public void listViewMouseClick()
    {
        int selectedIndex = listWord.getSelectionModel().getSelectedIndex();
        textfeildSearch.setText(arr.get(selectedIndex));
    }

    public void loadWord()
    {

        ObservableList<String> items = FXCollections.observableArrayList(arr);
        listWord.setItems(items);
    }

    public void suggestions()
    {
        TextFields.bindAutoCompletion(textfeildSearch,arr);
    }

    public void refresh()
    {
        buttonRefresh.setOnAction(e->{
            textfeildSearch.setText("Nhập từ cần tìm");
            textArea.setText("");
            arr = word.creatWordList();
            loadWord();
        });
    }

    public void translate()
    {
        buttonTranslate.setOnAction(e->{
            String meanning = word.getWord(textfeildSearch.getText());
            textArea.setText(meanning);
            String pronounce = word.getPronounce(textfeildSearch.getText());
            textfeildPronounce.setText(pronounce);
        });
    }

    public void openWindowAddWord()
    {
        buttonAddWord.setOnAction(e->{
            try {
                Stage primaryStage1 = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("windowAddWord.fxml"));
                primaryStage1.setTitle("Thêm từ");
                primaryStage1.setScene(new Scene(root, 530, 500));


                primaryStage1.show();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
    }

    public void openWindowFixWord()
    {
        buttonFixWord.setOnAction(e->{
            try {
                Stage primaryStage1 = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("windowFixWord.fxml"));
                primaryStage1.setTitle("Sửa từ");
                primaryStage1.setScene(new Scene(root, 700, 700));


                primaryStage1.show();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
    }

    public void openWindowRemoveWord()
    {
        buttonRemoveWord.setOnAction(e->{
            try {
                Stage primaryStage1 = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("windowRemoveWord.fxml"));
                primaryStage1.setTitle("Xóa từ");
                primaryStage1.setScene(new Scene(root, 531, 474));


                primaryStage1.show();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
    }

    public void openwindowExportFile()
    {
        buttonExportFile.setOnAction(e->{
            try {
                Stage primaryStage1 = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("windowExportFile.fxml"));
                primaryStage1.setTitle("Xuất File");
                primaryStage1.setScene(new Scene(root, 581, 284));


                primaryStage1.show();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textfeildPronounce.setEditable(false);
        textArea.setEditable(false);
        loadWord();
        suggestions();
        refresh();
        translate();
        openWindowAddWord();
        openWindowFixWord();
        openWindowRemoveWord();
        openwindowExportFile();
    }
}
