/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.model;

import com.mycompany.Bslogic.Instruction;
import com.mycompany.Bslogic.Memory;
import java.util.ArrayList;

/**
 *
 * @author fredd
 */
public class Model {
    ArrayList<String> lines = new ArrayList<>();
    Memory memory = new Memory(100, 0, 20);
    
    public Model() {
        
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
    
    public void printLines() {
        System.out.println(this.lines);
    }
    
    public Instruction[] convertLinesToIns() {
        Instruction[] insProv = new Instruction[lines.size()];
        int index = 0;
        for (String line: lines) {
            insProv[index] = new Instruction(line);
            index++;
        }
        return insProv;
    }
    
    public void setUserInsToMemo() {
        Instruction[] insProv = convertLinesToIns();
        Instruction[] actualIns = memory.getMemoryInstrucs();
        int actualInd = memory.getActualIndexUser();
        
        for (Instruction element: insProv) {
            actualIns[actualInd] = element;
            actualInd++;
        }
        memory.setActualIndexUser(actualInd);
        memory.setMemoryInstrucs(actualIns);
     
        //System.out.println(memory.getMemoryInstrucs()[20].getEachPartIns()[1]);
    }
}
