/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irproject;


import Models.MainModel;
import Models.VectorModel;
import Models.Word;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author am012
 */
public class IRProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Informational Retrieval System");
        
        stage.setScene(scene);
        
        stage.setFullScreen(true);
        
        stage.setFullScreenExitHint("");
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       MainModel m = new MainModel();
       DecimalFormat df2 = new DecimalFormat("#.##");
     int i = 0;
       
        m.Quiery = "computer is information";
        List<Word> wo = m.Words();
        List<VectorModel> vm= new ArrayList<>(m.ListOfVectors);
        
        
//        for(String w : MainModel.DistinctTokens(m.ListOfTokensID) )
//        {
//            //System.out.print("Word content : " + i +  " " + w.word + " " + w.position + " " +w.docID+ " " +w.frequency+"\n");
//            System.out.println(MainModel.DistinctTokens(m.ListOfTokensID).get(i) + "   "+MainModel.DistinctTokens(m.ListOfTokensID).size());
//            i++;
//        }
//List<String> s = m.ReadFile(Tokenization("computer "), 0);
for(VectorModel v : vm )
        {
            
            System.out.println(v.getWord() + "   "+ v.getDocID() + "   " + v.getTF() + "   " + v.getIDF() + "   " + v.getSimilarity());
        }
       System.out.println(m.DOCSNUMEBR);
        
    }
    
}
