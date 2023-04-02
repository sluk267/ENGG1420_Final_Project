/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

/**
 *
 * @author Dave
 */
public class PrintElement {
    Entries[] entryList;
    void printElement(Entries entry){
        if(entry.type == "local"){
            System.out.println("Name:" + entry.getName());
            System.out.println("Length:" + entry.getEntryID());
            System.out.println("Path:" + entry.getPath());
        }else if(entry.type == "remote"){
            System.out.println("Id:" + entry.getEntryID());
            System.out.println("Name:" + entry.getName());
            System.out.println("Length:" + entry.getEntryID());
            System.out.println("Path:" + entry.getPath());
        }
    }
    
    PrintElement(Entries[] entryList){
        this.entryList = entryList;
        
    }
}
