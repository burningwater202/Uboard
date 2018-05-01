/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Sound implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer buttonid;

    private Integer buttonnumber;

    private String filename;
    
    private String color;

    public Integer getButtonId()
    {
        return buttonid;
    }

    public void setButtonId(Integer buttonid) 
    {
        this.buttonid = buttonid;
    }

    public Integer getButtonNumber() 
    {
        return buttonnumber;
    }

    public void setButtonNumber(Integer buttonnumber)
    {
        this.buttonnumber = buttonnumber;
    }

    public String getFileName() 
    {
        return filename;
    }

    public void setFileName(String filename)
    {
        this.filename = filename;
    }

    public String getColor() 
    {
        return color;
    }

    public void setColor(String color) 
    {
        this.color = color;
    }
}