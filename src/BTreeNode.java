/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb011
 */
public class BTreeNode {
    private String word;
    public int count;
    public BTreeNode left;
    public BTreeNode right;
    

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        count = 1;
    }
    
}
