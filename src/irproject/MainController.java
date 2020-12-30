/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irproject;

import Models.MainModel;
import Models.VectorModel;
import Models.Word;
import com.kirankunigiri.Sprint.Sprint;
import com.sun.rowset.internal.Row;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author am012
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //FOR ANIMATIONS
    //Buttons
    Sprint sprintPOS;
    Sprint sprintVEC;
    Sprint sprintTOK;
    Sprint sprintdIS;
    //Image View
    Sprint sprintPOSIMG;
    Sprint sprintVECIMG;
    Sprint sprintTOKIMG;
    //Labels
    Sprint sprintPOSLB;
    Sprint sprintVECLB;
    Sprint sprintTOKLB;
    //Panes
    Sprint sprintTOKPN;
    Sprint sprintPOSPN;
    Sprint sprintVECPN;
    //Mouse hover
    Sprint sprintPOSHOV;
    Sprint sprintVECHOV;
    Sprint sprintTOKHOV;
    //TEXTS
    Sprint sprintQUEIRY;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     Disabled = true;
        
     sprintPOS = new Sprint(POS_BT);
     sprintVEC = new Sprint(VEC_BT);
     sprintTOK = new Sprint(TOKEN_BT);
     sprintdIS = new Sprint(dIS_BT);
     
     sprintPOSIMG = new Sprint(POSIMG);
     sprintTOKIMG = new Sprint(TOKIMG);
     sprintVECIMG = new Sprint(VECIMG);
     
     sprintPOSLB = new Sprint(POS_LB);
     sprintVECLB = new Sprint(VEC_LB);
     sprintTOKLB =new Sprint(TOK_LB);
     
     sprintTOKPN =new Sprint(TOK_PANE);
     sprintPOSPN =new Sprint(POS_PANE);
     sprintVECPN =new Sprint(VEC_PANE);
     
     sprintPOSHOV = new Sprint(POS_BT);
     sprintVECHOV = new Sprint(VEC_BT);
     sprintTOKHOV = new Sprint(TOKEN_BT);
     
     
     sprintQUEIRY = new Sprint(quieryField);
     
        
        // TODO
    }    
    
    //BEGIN OF TABLES
    @FXML
    private TableView TOK_POS_TABLE;
    
    ObservableList<Word> setData = FXCollections.observableArrayList();
    ObservableList<VectorModel> setDataVM = FXCollections.observableArrayList();

    @FXML
    private TableColumn TOK_COL;

    @FXML
    private TableColumn FREQ_COL;

    @FXML
    private TableColumn DOC_NUM_COL;

    @FXML
    private TableColumn POS_COL;
    
    @FXML
    private TableView TOK_TABLE;

    @FXML
    private TableColumn TOK_COL_TOK;

    @FXML
    private TableColumn FREQ_COL_TOK;

    @FXML
    private TableColumn DOC_NUM_COL_TOK;
    
    @FXML
    private TableView VEC_TABLE;

    @FXML
    private TableColumn VECTOK_COL;
    
    @FXML
    private TableColumn DocID_COL;
    
    @FXML
    private TableColumn VEC_POS_COL;

    @FXML
    private TableColumn TF_COL;
    
    @FXML
    private TableColumn TFQ_COL;

    @FXML
    private TableColumn IDF_COL;

    @FXML
    private TableColumn SIM_COL;
    
    @FXML
    private TableColumn VECTORDOC_COL;

    @FXML
    private TableColumn VECTORQUERY_COL;

    @FXML
    private TableColumn SIMILARITY_COL;
    //END OF TABLES
    
    @FXML
    private Label POS_LB;

    @FXML
    private Label TOK_LB;

    @FXML
    private Label VEC_LB;
    
    @FXML
    private ImageView POSIMG;

    @FXML
    private ImageView VECIMG;

    @FXML
    private ImageView TOKIMG;
    
    @FXML
    private Button POS_BT;

    @FXML
    private Button VEC_BT;

    @FXML
    private Button TOKEN_BT;
    
     @FXML
    private Button dIS_BT;
     
    @FXML
    private TextField quieryField;
    
    @FXML
    private AnchorPane TOK_PANE;

    @FXML
    private AnchorPane POS_PANE;

    @FXML
    private AnchorPane VEC_PANE;
    
    //VARS
    int y = -50;
    int def = 0;
    double dur = 0.5;
    public static boolean Disabled;
    
    MainModel M = new MainModel();
    

    @FXML
    void BACK_BT(MouseEvent event) throws IOException {
        
        Stage current_stg = (Stage) ((Node)event.getSource() ).getScene().getWindow();
                      
        current_stg.close();
        
        Parent root2 = FXMLLoader.load(getClass().getResource("Main.fxml"));
                   
        Scene scene2 = new Scene(root2);
            
         Stage stage = new Stage();
         
         stage.setScene(scene2);
         
         stage.setTitle("Informational Retrieval System");
         
         stage.setFullScreen(true);
         
         stage.setFullScreenExitHint("");
         
         stage.show();
         

    }

    @FXML
    void POS_BT(ActionEvent event)  {
        
        
        if(CheckTXT(quieryField.getText()))
        {
                M.Quiery = quieryField.getText();
                WordTable(M.Words());
                
                POS_BT.setDisable(true);
                TOKEN_BT.setDisable(true);
                VEC_BT.setDisable(true);
                POS_BT.setOpacity(1);

                sprintPOSLB.moveTo(0.8, 0, -5).sprint();

                POS_LB.setText("Getting Positions...");

                sprintPOSLB.scaleTo(1.5, 2, 2).sprint();

                sprintPOS.wait(0.5);

                sprintTOK.fadeTo(1.5, 0).sprint();
                sprintTOKIMG.fadeTo(1.5, 0).sprint();
                sprintTOKLB.fadeTo(1.5, 0).sprint();

                sprintPOSIMG.fadeTo(1.5, 0).sprint();

                sprintVEC.fadeTo(1.5, 0).sprint();
                sprintVECIMG.fadeTo(1.5, 0).sprint();
                sprintVECLB.fadeTo(1.5, 0).sprint();

                sprintPOS.wait(0.5);
                sprintPOS.scaleTo(1, 50, 50).sprint();

                sprintPOSLB.wait(1.0);
                sprintPOSLB.fadeTo(1, 0).loop(5);

                sprintPOS.wait(10.0);
                sprintPOSLB.wait(10.0);
                sprintPOS.scaleTo(1, 0, 0).sprint();
                sprintPOSLB.fadeTo(1, 0).sprint();


                //DO something

                POS_PANE.setVisible(true);
                sprintPOSPN.wait(10.5);
                sprintPOSPN.fadeTo(0.1, 1).sprint();
        }
        else
        {
                EmptyField();
        }
        
    }

    @FXML
    void TOKEN_BT(ActionEvent event)  {
        
        if(CheckTXT(quieryField.getText()))
        {
                M.Quiery = quieryField.getText();
                WordTable(M.Words());
                
                POS_BT.setDisable(true);
                TOKEN_BT.setDisable(true);
                VEC_BT.setDisable(true);
                TOKEN_BT.setOpacity(1);

                TOK_LB.setText("Tokenizing...");

                sprintTOKLB.scaleTo(1.5, 2, 2).sprint();

                sprintTOK.wait(0.5);

                sprintPOS.fadeTo(1.5, 0).sprint();
                sprintPOSIMG.fadeTo(1.5, 0).sprint();
                sprintPOSLB.fadeTo(1.5, 0).sprint();

                sprintTOKIMG.fadeTo(1.5, 0).sprint();

                sprintVEC.fadeTo(1.5, 0).sprint();
                sprintVECIMG.fadeTo(1.5, 0).sprint();
                sprintVECLB.fadeTo(1.5, 0).sprint();

                sprintTOK.wait(0.5);
                sprintTOK.scaleTo(1, 50, 50).sprint();
                sprintTOKLB.wait(0.8);
                sprintTOKLB.moveTo(0.2, 245, -5).sprint();

                sprintTOKLB.wait(1.0);
                sprintTOKLB.fadeTo(1, 0).loop(5);

                sprintTOK.wait(10.0);
                sprintTOKLB.wait(10.0);
                sprintTOK.scaleTo(1, 0, 0).sprint();
                sprintTOKLB.fadeTo(1, 0).sprint();

                TOK_PANE.setVisible(true);
                sprintTOKPN.wait(10.5);
                sprintTOKPN.fadeTo(0.1, 1).sprint();
        }
        else
        {
            EmptyField();
        }


    }

    @FXML
    void VEC_BT(ActionEvent event) {
        
        if(CheckTXT(quieryField.getText()))
        {
        
                M.Quiery = quieryField.getText();
                M.Words();//To Fill the ListOfVectors
                VMTable(M.ListOfVectors);
                
                POS_BT.setDisable(true);
                TOKEN_BT.setDisable(true);
                VEC_BT.setDisable(true);
                VEC_BT.setOpacity(1);
                
                VEC_LB.setText("Calculating Vector...");

                sprintVECLB.scaleTo(1.5, 2, 2).sprint();

                sprintVEC.wait(0.5);

                sprintPOS.fadeTo(1.5, 0).sprint();
                sprintPOSIMG.fadeTo(1.5, 0).sprint();
                sprintPOSLB.fadeTo(1.5, 0).sprint();

                sprintVECIMG.fadeTo(1.5, 0).sprint();

                sprintTOK.fadeTo(1.5, 0).sprint();
                sprintTOKIMG.fadeTo(1.5, 0).sprint();
                sprintTOKLB.fadeTo(1.5, 0).sprint();

                sprintVEC.wait(0.5);
                sprintVEC.scaleTo(1, 50, 50).sprint();
                sprintVECLB.wait(0.8);
                sprintVECLB.moveTo(0.2, -245, -5).sprint();

                sprintVECLB.wait(1.0);
                sprintVECLB.fadeTo(1, 0).loop(5);

                sprintVEC.wait(10.0);
                sprintVECLB.wait(10.0);
                sprintVEC.scaleTo(1, 0, 0).sprint();
                sprintVECLB.fadeTo(1, 0).sprint();



                VEC_PANE.setVisible(true);
                sprintVECPN.wait(10.5);
                sprintVECPN.fadeTo(0.1, 1).sprint();
        }
        else
        {
            EmptyField();
        }

    }
    
    @FXML
    void DIS_BT(ActionEvent event) {
        if(Disabled)
        {
            dIS_BT.setText("Enabled");
            Disabled = false;
            sprintdIS.rotateTo(0.5, 360).sprint();
            dIS_BT.setStyle("-fx-background-color:  #00bfff ; -fx-background-radius : 7");
            
        }
        else
        {
            dIS_BT.setText("Disabled");
            Disabled = true;
            sprintdIS.rotateTo(0.5, -360).sprint();
            dIS_BT.setStyle("-fx-background-color:  #b3b3b3 ; -fx-background-radius : 7");
            
            
            
        }
        

    }

    
    
    @FXML
    void POS_BT_MOUSE(MouseEvent event) {
        
        sprintPOSHOV.moveTo(dur, 0, y).sprint();
        sprintPOSIMG.moveTo(dur+0.3, 0, y).sprint();
        sprintPOSLB.moveTo(dur+0.1, 0, y).sprint();
        
    }
    
    @FXML
    void POS_BT_EX(MouseEvent event) {
        
        sprintPOSHOV.moveTo(dur, 0, def).sprint();
        sprintPOSIMG.moveTo(dur+0.3, 0, def).sprint();
        sprintPOSLB.moveTo(dur+0.1, 0, def).sprint();
    }

    @FXML
    void TOKEN_BT_MOUSE(MouseEvent event) {
        
        sprintTOKHOV.moveTo(dur, 0, y).sprint();
        sprintTOKIMG.moveTo(dur+0.3, 0, y).sprint();
        sprintTOKLB.moveTo(dur+0.1, 0, y).sprint();

    }
    
    @FXML
    void TOKEN_BT_EX(MouseEvent event) {
            
        sprintTOKHOV.moveTo(dur, 0, def).sprint();
        sprintTOKIMG.moveTo(dur+0.3, 0, def).sprint();
        sprintTOKLB.moveTo(dur+0.1, 0, def).sprint();

    }
    
    @FXML
    void VEC_BT_MOUSE(MouseEvent event) {
        
        sprintVECHOV.moveTo(dur, 0, y).sprint();
        sprintVECIMG.moveTo(dur+0.3, 0, y).sprint();
        sprintVECLB.moveTo(dur+0.1, 0, y).sprint();

    }
    
    @FXML
    void VEC_BT_EX(MouseEvent event) {
        
        sprintVECHOV.moveTo(dur, 0, def).sprint();
        sprintVECIMG.moveTo(dur+0.3, 0, def).sprint();
        sprintVECLB.moveTo(dur+0.1, 0, def).sprint();
       

    }
    
    void WordTable(List<Word> word) 
    {
        for(Word w : word)
        {
            setData.add(new Word(w.Word,w.Frequency,w.Position,w.DocID));
        }
        //POSITIONAL TABLE
        TOK_COL.setCellValueFactory(new PropertyValueFactory<>("Word"));
        FREQ_COL.setCellValueFactory(new PropertyValueFactory<>("Frequency"));
        POS_COL.setCellValueFactory(new PropertyValueFactory<>("Position"));
        DOC_NUM_COL.setCellValueFactory(new PropertyValueFactory<>("DocID"));
        
        //TOKENIZATION TABLE
        TOK_COL_TOK.setCellValueFactory(new PropertyValueFactory<>("Word"));
        FREQ_COL_TOK.setCellValueFactory(new PropertyValueFactory<>("Frequency"));
        DOC_NUM_COL_TOK.setCellValueFactory(new PropertyValueFactory<>("DocID"));
        
        TOK_POS_TABLE.setItems(setData);
        TOK_TABLE.setItems(setData);
        
        sortColumnAsc(TOK_COL, TOK_TABLE);
        sortColumnAsc(TOK_COL_TOK, TOK_POS_TABLE);
        
    }
    
    void VMTable(List<VectorModel> VM) 
    {
        for(VectorModel v : VM)
        {
            setDataVM.add(new VectorModel(v.getWord(),v.getDocID(),v.getPosition(),v.getTF(),v.getTFQ(),v.getIDF(),v.getSimilarity()
                    ,v.getVectorDoc(),v.getVectorQuery(),v.getSim()));
        }
        //VECTORMODEL TABLE
        VECTOK_COL.setCellValueFactory(new PropertyValueFactory<>("Word"));
        DocID_COL.setCellValueFactory(new PropertyValueFactory<>("DocID"));
        VEC_POS_COL.setCellValueFactory(new PropertyValueFactory<>("Position"));
        TF_COL.setCellValueFactory(new PropertyValueFactory<>("TF"));
        TFQ_COL.setCellValueFactory(new PropertyValueFactory<>("TFQ"));
        IDF_COL.setCellValueFactory(new PropertyValueFactory<>("IDF"));
        SIM_COL.setCellValueFactory(new PropertyValueFactory<>("Similarity"));
        VECTORDOC_COL.setCellValueFactory(new PropertyValueFactory<>("VectorDoc"));
        VECTORQUERY_COL.setCellValueFactory(new PropertyValueFactory<>("VectorQuery"));
        SIMILARITY_COL.setCellValueFactory(new PropertyValueFactory<>("Sim"));
        
        VEC_TABLE.setItems(setDataVM);
        
        sortColumnDsc(SIMILARITY_COL, VEC_TABLE);
        
    }
    
    boolean CheckTXT(String text)
    {
        return !text.isEmpty();
    }
    
    void EmptyField()
    {
        sprintQUEIRY.moveTo(0.1, 15, 0).loop(5);
        sprintQUEIRY.moveTo(0.1, -15, 0).loop(5);
        sprintQUEIRY.wait(0.2);
        sprintQUEIRY.moveTo(0.1, 0, 0).sprint();
        quieryField.setPromptText("The Query Field Couldn't be Empty !");
    }
    
    void sortColumnDsc(TableColumn C , TableView T)
    {
        C.setSortType(TableColumn.SortType.DESCENDING);
        T.getSortOrder().add(C);
        T.sort();
    }
    
    void sortColumnAsc(TableColumn C , TableView T)
    {
        C.setSortType(TableColumn.SortType.ASCENDING);
        T.getSortOrder().add(C);
        T.sort();
    }
    


}
