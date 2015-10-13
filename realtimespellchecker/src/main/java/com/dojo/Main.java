package com.dojo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:/enable1.txt"));

        SpellChecker checker = new SpellChecker(lines);
        Trie trie = new Trie();
    }
}

class Trie{
    public Node head = new Node('\b', false);

    public Node insert(String target){
        Node curr = head;
        for(int i = 0; i < target.length(); i++){
            if(!curr.hasChild(target.charAt(i))){
                curr.addChild(target.charAt(i));
            }

            curr = curr.getChild(target.charAt(i));
        }

        curr.IsWord = true;
        return head;
    }

    public Node delete(String target){return head;}
    public boolean lookup(String target){return false;}
}

class Node{
    public char Value;
    public boolean IsWord;
    public HashMap<Character, Node> Children;

    public Node(char val, boolean isWord){
        Value = val;
        IsWord = isWord;
        Children = new HashMap<>();
    }

    public boolean hasChild(char c) {
        return Children.containsKey(c);
    }

    public void addChild(char c) {
        Children.put(c, new Node(c, false));
    }

    public Node getChild(char c) {
        return Children.get(c);
    }

    @Override
    public String toString() {
        return "Node: " + Value + ", Children: " + Children.size();
    }
}