package Trie;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("adam");
        trie.insert("adamm");
        trie.insert("adamee");

//        List<String> list = trie.allWordsWithPrefix("");
//
//        for (String s : list)
//            System.out.println(s);
        //System.out.println(trie.allWordsWithPrefix("sh"));

        System.out.println(trie.longestCommonPrefix());
    }

}
