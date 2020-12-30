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
    double TFQ;
    double IDF;
    double Similarity;
    double VectorDoc;
    double VectorQuery;
    double Sim;
    
    public VectorModel(String Word ,int DocID , int Position,double TF ,double TFQ, double IDF , double Similarity , double VectorDoc , double VectorQuery ,double Sim)
    {
        this.Word = Word;
        this.DocID = DocID;
        this.Position = Position;
        this.TF = TF;
        this.TFQ = TFQ;
        this.IDF = IDF;
        this.Similarity = Similarity;
        this.VectorDoc = VectorDoc;
        this.VectorQuery = VectorQuery;
        this.Sim = Sim;
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
    
    public void setTFQ(double TFQ)
    {
        this.TFQ = TFQ;
    }
    
    public double getTFQ()
    {
        return TFQ;
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
    
    public void setVectorDoc(double VectorDoc)
    {
        this.VectorDoc = VectorDoc;
    }
    
    public double getVectorDoc()
    {
        return VectorDoc;
    }
    
    public void setVectorQuery(double VectorQuery)
    {
        this.VectorQuery = VectorQuery;
    }
    
    public double getVectorQuery()
    {
        return VectorQuery;
    }
    
    public void setSim(double Sim)
    {
        this.Sim = Sim;
    }
    
    public double getSim()
    {
        return Sim;
    }
    
}
