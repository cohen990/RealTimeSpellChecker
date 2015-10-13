package com.dojo;

import java.util.List;

public class SpellChecker {
    public Trie trie = new Trie();
    private Node pointer = trie.head;

    public SpellChecker(List<String> words){
        for(String word: words){
            trie.insert(word);
        }
    }

    public String Check(String input) {
        String result = "";
        String[] split = input.split("\n");
        for(String word: split){
            int locationOfMisspell = -1;
            for(int i = 0; i < word.length(); i++) {
                if(!pointer.hasChild(word.charAt(i))){
                    locationOfMisspell = i;
                    break;
                }
                pointer = pointer.getChild(word.charAt(i));
            }
            pointer = trie.head;
            if(locationOfMisspell >= 0){
                StringBuilder builder = new StringBuilder(word);
                builder.insert(locationOfMisspell + 1, '<');
                result += builder.toString();
            }
            else{
                result += word;
            }
            result += '\n';
        }
        return result.trim();
    }
}
