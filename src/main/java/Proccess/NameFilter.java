/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import java.util.ArrayList;

/**
 *
 * @author Ryan Vemulapalli 
 */
public class NameFilter {
    private ArrayList<Entries> outputList = new ArrayList<Entries>();
    private ArrayList<Entries> inputList;
    private String Key;
        
    public NameFilter(ArrayList<Entries> inputList, String Key){
        this.inputList = inputList;
        this.Key = Key;
    }
    
    public ArrayList<Entries> Name(){
        for (Entries obj : inputList) {  //Interate over the input entries object ArrayList.
            String name; //Temp name string that will hold current object's name.
            name = obj.getName(); //Need to create getName method in input objects that are in the arrayList input.
            
            if (name.contains(Key)){
                outputList.add(obj);
            }
        }
        return outputList;
    }
}