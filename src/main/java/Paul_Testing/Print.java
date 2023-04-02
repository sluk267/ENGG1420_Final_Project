/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
public class Print extends ProcessingElement {
    @Override
    public List<Entry> processInput(List<Entry> input) {
        for (Entry entry : input) {
            System.out.println(entry.toString());
        }
        return input;
    }
}
