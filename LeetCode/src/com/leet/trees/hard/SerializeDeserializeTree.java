package com.leet.trees.hard;

import com.leet.trees.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeTree {
    public static void main(String[] args) {

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeTree(root, "");
    }

    // serializing using preorder traversal.
    private String serializeTree(TreeNode root, String str) {
        if(root==null) str = str+"null,";
        else{
            str=str+root.val+",";
            str = serializeTree(root.left, str);
            str = serializeTree(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(array));
        return deserializeTree(list);
    }

    private TreeNode deserializeTree(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeTree(list);
        root.right = deserializeTree(list);

        return root;
    }
}
