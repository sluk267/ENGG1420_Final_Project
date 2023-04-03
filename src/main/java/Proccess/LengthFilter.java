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
public class LengthFilter {
    private ArrayList<Entries> outputList = new ArrayList<Entries>();
    private ArrayList<Entries> inputList;
    private long Length;
    private String Operator;
    
    public LengthFilter(ArrayList<Entries> inputList, long Length, String Operator){
        this.inputList = inputList;
        this.Length = Length;
        this.Operator = Operator;
    }
    
    public ArrayList<Entries> Filter(){
        for (Entries obj : inputList) {  //Interate over the input entries object ArrayList.
            long tempLength = obj.getLength();//Need to create getLength method in input objects that are in the arrayList input.
            
            // The switch statement compares two integer values (tempLength and Length) based on the value of a string variable (Operator)
            switch (Operator) {
                case "EQ":
                    if (tempLength == Length) {
                        outputList.add(obj);
                    }
                    break;
                    
                case "NEQ":
                    if (tempLength != Length) {
                        outputList.add(obj);
                    }
                    break;
                    
                case "GT":
                    if (tempLength > Length) {
                        outputList.add(obj);
                    }
                    break;
                    
                case "GTE":
                    if (tempLength >= Length) {
                        outputList.add(obj);
                    }
                    break;
                    
                case "LT":
                    if (tempLength < Length) {
                        outputList.add(obj);
                    }
                    break;
                    
                case "LTE":
                    if (tempLength <= Length) {
                        outputList.add(obj);
                    } 
                    break;
                    
                default:
                    System.out.println("Invalid operator");
                    break;
            }
        }    
        return outputList;
    }   
}
