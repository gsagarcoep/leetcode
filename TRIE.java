//https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
class Trie {
    
    static final Integer ALPHABET_SIZE = 26;
    
    static public class TrieNode{
        Character letter;
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode(){
            isEndOfWord = false;
            children = new TrieNode[ALPHABET_SIZE];
            for(int i=0; i<ALPHABET_SIZE; i++){
                children[i] = null;
             } 
        }
    }
    
    static TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Character curr = word.charAt(0);
        if(root.children[curr - 'a'] != null){
            insertLetter(word.substring(1,word.length()), root.children[curr - 'a']);
        }
        else{
            insertLetter(word, root);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Character curr = word.charAt(0);
        if(root.children[curr - 'a'] != null){
            return search(word.substring(1,word.length()), root.children[curr - 'a']);
        }
        else{
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Character curr = prefix.charAt(0);
        if(root.children[curr - 'a'] != null){
            return startsWith(prefix.substring(1,prefix.length()), root.children[curr - 'a']);
        }
        else{
            return false;
        }
    }
    
     /** Inserts a word into the trie. */
    private void insertLetter(String word, TrieNode root){
        if(word.length() == 0 ) {
            root.isEndOfWord = true;
            return;
        }
        
        Character curr = word.charAt(0);
        if(root.children[curr - 'a'] != null){
            insertLetter(word.substring(1,word.length()), root.children[curr - 'a']);
        }
        else{
            root.children[curr - 'a'] = new TrieNode();
            root.children[curr - 'a'].letter = curr;
            insertLetter(word.substring(1,word.length()), root.children[curr - 'a']);
        }
    }
    
    private boolean search(String word, TrieNode root){
        if(word.length() == 0 && root.isEndOfWord)
            return true;
        else if (word.length() == 0) return false;
                
        Character curr = word.charAt(0);
        if(root.children[curr - 'a'] != null){
            return search(word.substring(1,word.length()), root.children[curr - 'a']);
        }
        else{
            return false;
        }
    }
    
    private boolean startsWith(String word, TrieNode root){
        if(word.length() == 0)
            return true;
                
        Character curr = word.charAt(0);
        if(root.children[curr - 'a'] != null){
            return startsWith(word.substring(1,word.length()), root.children[curr - 'a']);
        }
        else{
            return false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
