/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb011
 */
public class BTree {
    private BTreeNode root;
    private int totalWords;
    
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
         else if(sort == 0)
             current.count++;
                
    }
    
    public String printWC()
    {   
        totalWords = 0;
        return "<html>" + recPrintWC(root);
    }
    
    public String recPrintWC(BTreeNode current)
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
           answer += "<br><br>Total Words: " + totalWords;
        return answer;
    }
    
}
