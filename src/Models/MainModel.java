/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.google.common.base.Joiner;
import static irproject.MainController.Disabled;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author am012
 */
public class MainModel {
    
    public  List<String> ListPathes = PrepareFiles();
    
    public  List<String> ListOfTokensID = new ArrayList<>(); //Has the token with the doc id 
    
    public  List<Integer> ListIDs = IDsOfFiles();
    
    public  List<Integer> ListOfPositions = new ArrayList<>() ;
    
    public List<Integer> WordListIDs = new ArrayList<>();
    
    public List<Word> Words = new ArrayList<>();
    
    public  List<VectorModel> ListOfVectors = new ArrayList();
    
    public static List<String> Stops = new ArrayList<String>( Arrays.asList("a", "able", "about",
        "across", "after", "all", "almost", "also", "am", "among", "an",
        "and", "any", "are", "as", "at", "b", "be", "because", "been",
        "but", "by", "c", "can", "cannot", "could", "d", "dear", "did",
        "do", "does", "e", "either", "else", "ever", "every", "f", "for",
        "from", "g", "get", "got", "h", "had", "has", "have", "he", "her",
        "hers", "him", "his", "how", "however", "i", "if", "in", "into",
        "is", "it", "its", "j", "just", "k", "l", "least", "let", "like",
        "likely", "m", "may", "me", "might", "most", "must", "my",
        "neither", "n", "no", "nor", "not", "o", "of", "off", "often",
        "on", "only", "or", "other", "our", "own", "p", "q", "r", "rather",
        "s", "said", "say", "says", "she", "should", "since", "so", "some",
        "t", "than", "that", "the", "their", "them", "then", "there",
        "these", "they", "this", "tis", "to", "too", "twas", "u", "us",
        "v", "w", "wants", "was", "we", "were", "what", "when", "where",
        "which", "while", "who", "whom", "why", "will", "with", "would",
        "x", "y", "yet", "you", "your", "z"));
    
    public String Quiery;
    
    DecimalFormat DF3 = new DecimalFormat("#.###");
      
    public int DOCSNUMEBR = IDsOfFiles().size();
    
    public  List<String> PrepareFiles() //Returns list of file pathes which are used in ReadFiles
    {
        List ListOfPathes = new ArrayList<String>();
        try
        {
            File[] ListOfFiles = new File("files").listFiles();
           
            for(File f : ListOfFiles)
            {
                ListOfPathes.add(f.getPath());
            }
            
            return ListOfPathes;
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
    public  List<Integer> IDsOfFiles()  //Returns the IDs of files 
    {
        List ListOfIDs = new ArrayList<String>();
        try
        {
            File[] ListOfFiles = new File("files").listFiles();
           
            for(File f : ListOfFiles)
            {
                ListOfIDs.add(Integer.parseInt(DeleteExtension(f.getName())));
            }
            
            return ListOfIDs;
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
    public static String DeleteExtension(String s)//Returns the file number as a string value
    {
         s = s.replaceAll(s.substring(s.length()-4), "");
         s = s.replaceAll(s.substring(0, 3), "");
         return s;
    }
    
    public  List<String> ReadFiles(List<String> Tokens) //Reads all files and return the tokens into a list
    {
        
        List ListOfTokens = new ArrayList<String>();
        List Chars = new ArrayList<Character>();
        String ClusterChars;
        int Position = 0;
        int c = 0;  
        int Reader;
        try {
            for(String S : ListPathes)
            {
                FileInputStream FIS = new FileInputStream(ListPathes.get(c));
                InputStreamReader ISR = new InputStreamReader(FIS);
                BufferedReader BR = new BufferedReader(ISR);
                
                while((Reader = BR.read()) != -1)
                {
                    if(Reader != 32)
                    {
                       Chars.add((char)Reader);
                    }
                    else
                    {
                        ClusterChars = Joiner.on("").join(Chars);
                        if(Tokens.contains(ClusterChars))
                        {
                            ListOfTokens.add(ClusterChars);
                            ListOfTokensID.add(ClusterChars+" "+c);
                        }
                            
                        Chars.removeAll(Chars);
                        Position++;
                    }
                    
                }
                BR.close();
                ISR.close();
                FIS.close();
                
                //Use while changing from file to anthor
                ClusterChars = Joiner.on("").join(Chars);
                if(Tokens.contains(ClusterChars))
                {
                    ListOfTokens.add(ClusterChars);
                    ListOfTokensID.add(ClusterChars+" "+c);
                }
                Chars.removeAll(Chars);
                c++;
                Position = 0;
                
            }
            
            return ListOfTokens;
        } catch (IOException ex) {
            return null;
        }
    }
    
    
    public  List<String> ReadFile(List<String> Tokens , int FileNum) //Reads file and return the tokens into a list
    {
        
        List ListOfTokens = new ArrayList<String>();
        List Chars = new ArrayList<Character>();
        String ClusterChars;
        int Reader;
        try {
            
                FileInputStream FIS = new FileInputStream(ListPathes.get(FileNum));
                InputStreamReader ISR = new InputStreamReader(FIS);
                BufferedReader BR = new BufferedReader(ISR);
                
                while((Reader = BR.read()) != -1)
                {
                    if(Reader != 32)
                    {
                       Chars.add((char)Reader);
                    }
                    else
                    {
                        ClusterChars = Joiner.on("").join(Chars);
                        if(Tokens.contains(ClusterChars))
                            ListOfTokens.add(ClusterChars);
                        Chars.removeAll(Chars);
                    }
                    
                }
                BR.close();
                ISR.close();
                FIS.close();
                
                //Use while changing from file to anthor
                ClusterChars = Joiner.on("").join(Chars);
                if(Tokens.contains(ClusterChars))
                    ListOfTokens.add(ClusterChars);
                Chars.removeAll(Chars);
            return ListOfTokens;
        } catch (IOException ex) {
            return null;
        }
    }
    
    
    
    
    
    public List<Word> Words()//Returns a list of Word which contains every word with it's data
   {
        List<String> TEMP = ReadFiles(Tokenization(Quiery));
        List<String> TEMP2 = Tokenization(Quiery);
        List<String> DistinctTokens = DistinctTokens(ListOfTokensID);
        List<String> ReadOneFile ;
        List ListOfWord = new ArrayList<Word>();
       
        
        List Chars = new ArrayList<Character>();
        String ClusterChars;
        int Position = 0;
        int c = 0;  
        int Reader;
        int Frequency = 0;
        int DF = 0;
        double TF = 0;
        double TFQ = 0;
        double IDF;
        double SIM;
        double VectorDoc;
        double VectorQuery;
        double Similarity;
        try {
            for(String S : ListPathes)
            {
                ReadOneFile = ReadFile(Tokenization(Quiery), c); //Read only the current file to calculate the DF
                
                FileInputStream FIS = new FileInputStream(ListPathes.get(c));
                InputStreamReader ISR = new InputStreamReader(FIS);
                BufferedReader BR = new BufferedReader(ISR);
                
                while((Reader = BR.read()) != -1)
                {
                    ReadOneFile = ReadFile(Tokenization(Quiery), c);
                    if(Reader != 32)
                    {
                       Chars.add((char)Reader);
                    }
                    else
                    {
                        ClusterChars = Joiner.on("").join(Chars);
                        while(TEMP.contains(ClusterChars))
                        {
                            Frequency++;
                            TEMP.remove(ClusterChars);
                        }
                        
                        while(TEMP2.contains(ClusterChars))
                        {
                            TFQ++;
                            TEMP2.remove(ClusterChars);
                        }
                        
                        while(ReadOneFile.contains(ClusterChars))
                        {
                            TF++;
                            ReadOneFile.remove(ClusterChars);
                        }
                        
                        while(DistinctTokens.contains(ClusterChars))
                        {
                            DF++;
                            DistinctTokens.remove(ClusterChars);
                        }
                        
                        if(Tokenization(Quiery).contains(ClusterChars))
                        {
                            
                            ListOfWord.add(new Word(ClusterChars,Frequency,Position,ListIDs.get(c)));
                            if(DF != 0)//Because we can not divide on zero
                            {
                                TF = calcTF(TF);
                                TFQ = calcTF(TFQ);
                                IDF = calcIDF(DOCSNUMEBR, DF);
                                SIM = calcSIM(TF, IDF);
                                VectorDoc = TF/SummationTF(c);
                                VectorQuery = TFQ/SummationTFQ();
                                Similarity = VectorDoc * VectorQuery;
                                ListOfVectors.add(new VectorModel(ClusterChars, ListIDs.get(c), Position,Double.parseDouble(DF3.format(TF)),
                                        Double.parseDouble(DF3.format(TFQ)),Double.parseDouble(DF3.format(IDF)), Double.parseDouble(DF3.format(SIM))
                                        , Double.parseDouble(DF3.format(VectorDoc)), Double.parseDouble(DF3.format(VectorQuery)), Double.parseDouble(DF3.format(Similarity))
                                ));
                            }
                        }
                            
                            
                        Chars.removeAll(Chars);
                        Position++;
                        Frequency = 0;
                        DF = 0;
                        TF = 0;
                        TFQ = 0;
                        TEMP.clear();
                        TEMP2.clear();
                        ReadOneFile.clear();
                        DistinctTokens.clear();
                        TEMP = ReadFiles(Tokenization(Quiery));
                        TEMP2 = Tokenization(Quiery);
                        DistinctTokens = DistinctTokens(ListOfTokensID);
                    }
                    
                }
                BR.close();
                ISR.close();
                FIS.close();
                
                //Use while changing from file to anthor
                ClusterChars = Joiner.on("").join(Chars);
                while(TEMP.contains(ClusterChars))
                {
                      Frequency++;
                      TEMP.remove(ClusterChars);
                }
                
                while(TEMP2.contains(ClusterChars))
                {
                      TFQ++;
                      TEMP2.remove(ClusterChars);
                }
                        
                while(ReadOneFile.contains(ClusterChars))
                 {
                      TF++;
                      ReadOneFile.remove(ClusterChars);
                 }   
                        
                while(DistinctTokens.contains(ClusterChars))
                {
                      DF++;
                      DistinctTokens.remove(ClusterChars);
                }
                
                if(Tokenization(Quiery).contains(ClusterChars))
                {
                      
                      ListOfWord.add(new Word(ClusterChars,Frequency,Position,ListIDs.get(c)));
                      if(DF != 0)//Because we can not divide on zero
                      {
                                TF = calcTF(TF);
                                TFQ = calcTF(TFQ);
                                IDF = calcIDF(DOCSNUMEBR, DF);
                                SIM = calcSIM(TF, IDF);
                                VectorDoc = TF/SummationTF(c);
                                VectorQuery = TFQ/SummationTFQ();
                                Similarity = VectorDoc * VectorQuery;
                                ListOfVectors.add(new VectorModel(ClusterChars, ListIDs.get(c), Position,Double.parseDouble(DF3.format(TF)),
                                        Double.parseDouble(DF3.format(TFQ)),Double.parseDouble(DF3.format(IDF)), Double.parseDouble(DF3.format(SIM))
                                        , Double.parseDouble(DF3.format(VectorDoc)), Double.parseDouble(DF3.format(VectorQuery)), Double.parseDouble(DF3.format(Similarity))
                                ));
                                
                      }
                }
                Chars.removeAll(Chars);
                c++;
                Position = 0;
                Frequency = 0;
                DF = 0;
                TF = 0;
                TFQ = 0;
                TEMP.clear();
                TEMP2.clear();
                ReadOneFile.clear();
                DistinctTokens.clear();
                TEMP = ReadFiles(Tokenization(Quiery));
                TEMP2 = Tokenization(Quiery);
                DistinctTokens = DistinctTokens(ListOfTokensID);
            }
            
            return ListOfWord;
        } catch (IOException ex) {
            return null;
        }
    }
    
    public static List<String> RemoveStopWords(List<String> Tokens ,boolean isDisabled)
    {
       
       int  i = 0;
       
       List<String> TEMP = new ArrayList<>();
       for(int c = 0 ; c<Tokens.size() ; c++)
       {
           TEMP.add(Tokens.get(c));
       }
                
       if(!isDisabled)
       {
           for(String s : Tokens)
           {
               if(Stops.contains(Tokens.get(i)))
               {
                   TEMP.remove(Tokens.get(i));
               }
               i++;
           }
       }
       
       return TEMP;
        
    }
    
    public static List<String> Tokenization(String Quiery)
    {
        List<String> Subs = new ArrayList<>();
        
        int prefix = 0;
        int suffix = 0;
        int c = 0;
        //Starting to divide the quiery
        while(suffix <= Quiery.length())
        {
            try{
                while(Quiery.charAt(suffix) != 32)
                {
                    suffix++;
                }
            }catch(IndexOutOfBoundsException e)
            {
                Subs.add(Quiery.substring(prefix, suffix).toLowerCase());
                break;
            }
            Subs.add(Quiery.substring(prefix, suffix).toLowerCase());
            suffix++;
            prefix = suffix;
            
        }
        
        Subs = RemoveStopWords(Subs,Disabled);
        return Subs;
        
    }
    
    public static List<String> DistinctTokens(List<String> TokensID) //Returns the tokens without any redudant
    {
        List<String>distinctTokens = new ArrayList<>(TokensID);
        List<String>TEMP = new ArrayList<>();
        
        int i ;
        int c;
        String Token;
        
        distinctTokens = distinctTokens.stream().distinct().collect(Collectors.toList()); //Removes the redudant to calculate the df
        
        for(c = 0 ; c < distinctTokens.size() ; c++)
        {
            Token = distinctTokens.get(c);
            i = 0;
            while(i != Token.length())
            {
                if(Token.charAt(i) == 32)
                {
                    TEMP.add(Token.substring(0,i));
                }
                i++;
            }
        }
        
        return TEMP;
        
    }
    
    public  double SummationTFQ ()
    {
        double c =0;
        double summation = 0;
        int count =0;
        List<String> s = new ArrayList<>(MainModel.Tokenization(Quiery));
        List<String> temp = new ArrayList<>(MainModel.Tokenization(Quiery));
        List<Double> i = new ArrayList<>(); 
        for(String ss : s)
        {
            while(s.contains(ss))
            {
                c++;
                temp.remove(ss);
                s = temp;
            }
            if(c != 0)
                i.add(calcTF(c));
            count++;
            c = 0;
            
        }
        
        for(double d : i)
        {
            summation = summation + d;
        }
        
        return summation;
                
    }
    
    public  double SummationTF (int docNum)
    {
        double c =0;
        double summation = 0;
        int count =0;
        List<String> s = new ArrayList<>(ReadFile(Tokenization(Quiery), docNum));
        List<String> temp = new ArrayList<>(ReadFile(Tokenization(Quiery), docNum));
        List<Double> i = new ArrayList<>(); 
        for(String ss : s)
        {
            while(s.contains(ss))
            {
                c++;
                temp.remove(ss);
                s = temp;
            }
            if(c != 0)
                i.add(calcTF(c));
            count++;
            c = 0;
            
        }
        
        for(double d : i)
        {
            summation = summation + d;
        }
        
        return summation;
                
    }
   
    public static double calcTF(double TF)
    {
        return 1 + Math.log10(TF);
    }
    
    public static double calcIDF(int Docs ,int DF)
    {
        return Math.log10(Docs/DF);
    }
    
    public static double calcSIM(double TF , double IDF)
    {
        return TF * IDF;
    }
    
    
    
}
