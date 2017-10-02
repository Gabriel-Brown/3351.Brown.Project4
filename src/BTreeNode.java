/******************************************************
‘***  Project 4 - BTree Word Counter
‘***  Gabriel Brown
‘******************************************************
‘*** To Demonstrate a BTree Data Structure
‘***
‘******************************************************
‘*** 10/02/2017
‘******************************************************
‘*****************************************************/

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
