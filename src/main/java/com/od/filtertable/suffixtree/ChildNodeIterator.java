package com.od.filtertable.suffixtree;

import com.od.filtertable.index.MutableCharSequence;

/**
* User: nick
* Date: 16/05/13
* Time: 08:30
*/
public class ChildNodeIterator<V> {

    private SuffixTree<V> parent;
    private SuffixTree<V> currentNode;
    private SuffixTree<V> lastNode;

    public ChildNodeIterator(SuffixTree<V> parent) {
        this.parent = parent;
        currentNode = parent.firstChild;
    }

    public boolean isValid() {
        return currentNode != null;
    }

    public void next() {
        lastNode = currentNode;
        currentNode = currentNode.nextPeer;
    }

    public SuffixTree<V> getCurrentNode() {
        return currentNode;
    }

    public SuffixTree<V> getLastNode() {
        return lastNode;
    }

    public int getSharedChars(MutableCharSequence s) {
        return CharUtils.getSharedPrefixCount(s, currentNode.label);
    }

    public boolean shouldInsert(MutableCharSequence s) {
        return s.charAt(0) < currentNode.label[0];
    }

    public int getCurrentLabelLength() {
        return currentNode.label.length;
    }

    public void insert(SuffixTree<V> newNode) {
        if (lastNode != null)  {
            lastNode.nextPeer = newNode;
        } else {
            parent.firstChild = newNode; 
        }
        newNode.nextPeer = currentNode;
    }

    public void replaceCurrent(SuffixTree<V> replacementNode) {
        if ( lastNode != null) {
            lastNode.nextPeer = replacementNode;
        } else {
            parent.firstChild = replacementNode;
        }
        replacementNode.nextPeer = currentNode.nextPeer;
        currentNode = replacementNode;
    }
}
