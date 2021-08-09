package Trees_Graphs;

public class Trie {
    /*
    Complexity: O(word_length) for search, insert, delete (practically O(N))

    Usage: finding prefix, for printing words in alphabetical order, auto-complete...
     */

    private TrieNode root;
    private static int ALPHABET_SIZE = 26;

    public Trie() {
        this.root = new TrieNode();
    }

    class TrieNode {
        int val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26]; // each letter can have 26 letters coming out of it
            this.isWord = false;
        }

        public TrieNode() {
            this.children = new TrieNode[ALPHABET_SIZE]; // each letter can have 26 letters coming out of it
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;

            this.isWord = false;
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(node.children[word.charAt(i)-'a'] == null) {
                TrieNode addedNode = new TrieNode(word.charAt(i));
                node.children[word.charAt(i)-'a'] = addedNode;
            }
            // note: it's not an "else" statement here, otherwise if we have e.g apple, it will insert only aple
            node = node.children[word.charAt(i)-'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(node.children[c-'a']==null)
                    return false;
                node = node.children[c-'a'];
            }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        for(char c : prefix.toCharArray()) {
            if(n.children[c-'a']==null)
                return false;
            n = n.children[c-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("app");
        System.out.println("Searched for apple: " + param_2);
        boolean param_3 = obj.startsWith("app");
    }
}
