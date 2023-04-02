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
    
    public ArrayList<Object> NameFilter(ArrayList<Object> inputList, String Key){
        ArrayList<Object> outputList = new ArrayList<Object>();
        
        for (Object obj : inputList) {  //Interate over the input entries object ArrayList.
            String name; //Temp name string that will hold current object's name.
            name = obj.getName(); //Need to create getName method in input objects that are in the arrayList input.
            
            if (name.contains(Key)){
                outputList.add(obj);
            }
        }   
        return outputList; //Returned filtered ArrayList
    }
    
}
