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
public class BTree {
    private BTreeNode root;
    private int totalWords;
    
/******************************************************
‘***  addWord(String word)
‘***  Gabriel Brown
‘******************************************************
‘*** Purpose: Public exposed method to addWordRec
‘*** Method Inputs: 
‘***      String word
‘*** Return value:
‘***      void
‘******************************************************
‘*** 10/02/2017
‘******************************************************/
    public void addWord(String word)
    {
        if (word.compareTo("") != 0)
        {
            BTreeNode temp = new BTreeNode();
        temp.setWord(word);
        if (root == null)
            root = temp;
        else
            addWordRec(root, temp);
        }
    }
    
/******************************************************
‘***  addWordRec(BTreeNode current, BTreeNode temp)
‘***  Gabriel Brown
‘******************************************************
‘*** Purpose: RECURSIVE to correctly place a word on the BTree
‘*** Method Inputs: 
‘***      BTreeNode current
‘***      BTreeNode temp
‘*** Return value:
‘***      void
‘******************************************************
‘*** 10/02/2017
‘******************************************************/
    private void addWordRec(BTreeNode current, BTreeNode temp)
    {
        int sort = current.getWord().compareTo(temp.getWord());
         if(sort < 0)
         {
             if (current.left == null)
                 current.left = temp;
             else
                 addWordRec(current.left, temp);
         }
         else if(sort > 0)
         {
             if (current.right == null)
                 current.right = temp;
             else
                 addWordRec(current.right, temp);
         }
         else
             current.count++;
                
    }
    
/******************************************************
‘***  public String printWC()
‘***  Gabriel Brown
‘******************************************************
‘*** Purpose: public method to call recPrint
‘*** Method Inputs: 
‘***      none
‘*** Return value:
‘***      String representation of BTree
‘******************************************************
‘*** 10/02/2017
‘******************************************************/
    public String printWC()
    {   
        totalWords = 0;
        return "<html>" + recPrintWC(root);
    }
    
/******************************************************
‘***  recPrintWC(BTreeNode current)
‘***  Gabriel Brown
‘******************************************************
‘*** Purpose: RECURSIVE to Print BTree in sorted order
‘*** Method Inputs: 
‘***      BTreeNode current
‘*** Return value:
‘***      String representation of BTree
‘******************************************************
‘*** 10/02/2017
‘******************************************************/
    private String recPrintWC(BTreeNode current)
    {
        String answer = "";

        if (current != null)
        {
            answer += recPrintWC(current.right);
            answer += current.getWord();
            answer += ".x" + current.count + ", ";
            totalWords += current.count;
            answer += recPrintWC(current.left);
            
        }
        if (current == root)
           answer += "<br><br><font color ='blue'>Total Words: " + totalWords + "</font>";
        return answer;
    }
    
}
