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
public class Word {
    
    public String Word ;
    public Integer  Frequency;
    public int Position;
    public int DocID;
          
    public Word(String Word  , Integer Frequency , int Position , int DocID)
    {
        this.Word = Word;
        this.Frequency = Frequency;
        this.Position = Position;
        this.DocID = DocID;
    }

    public void setWord(String word)
    {
        this.Word = word;
    }
    
    public String getWord()
    {
        return Word;
    }
    
    public void setFrequency(Integer Frequency)
    {
        this.Frequency = Frequency;
    }
    
    public Integer getFrequency()
    {
        return Frequency;
    }
    
    public void setPosition(int Position)
    {
        this.Position = Position;
    }
    
    public int getPosition()
    {
        return Position;
    }
    
    public void setDocID(int DocID)
    {
        this.DocID = DocID;
    }
    
    public int getDocID()
    {
        return DocID;
    }
    
    
}
