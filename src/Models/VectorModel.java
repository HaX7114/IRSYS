/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author am012
 */
public class VectorModel {
    
    String Word;
    int DocID;
    int Position;
    double TF;
    double IDF;
    double Similarity;
    
    public VectorModel(String Word ,int DocID , int Position,double TF , double IDF , double Similarity)
    {
        this.Word = Word;
        this.DocID = DocID;
        this.Position = Position;
        this.TF = TF;
        this.IDF = IDF;
        this.Similarity = Similarity;
    }
    
    public void setWord(String Word)
    {
        this.Word = Word;
    }
    
    public String getWord()
    {
        return  Word;
    }
    
    public void setDocID(int DocID)
    {
        this.DocID = DocID;
    }
    
    public int getDocID()
    {
        return DocID;
    }
    
    public void setPosition(int Position)
    {
        this.Position= Position;
    }
    
    public int getPosition()
    {
        return Position;
    }
    
    public void setTF(double TF)
    {
        this.TF = TF;
    }
    
    public double getTF()
    {
        return TF;
    }
    
    public void setIDF(double IDF)
    {
        this.IDF = IDF;
    }
    
    public double getIDF()
    {
        return IDF;
    }
    
    public void setSimilarity(double Similarity)
    {
        this.Similarity = Similarity;
    }
    
    public double getSimilarity()
    {
        return Similarity;
    }
    
}
