package com.keyin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinaryNodeService {



    @Autowired
    private BinaryNodeRepository binaryNodeRepository;

    @Autowired
    private TreeStructureRepository treeStructureRepository;

    public BinaryNode buildTree(List<Integer> numbers) {
        BinaryNode root = null;
        for (int number : numbers) {
            root = insertRec(root, number);
        }
         binaryNodeRepository.save(root);
        String treeJson = convertTreeToJson(root);
        saveTreeJson(treeJson);
        return root;


    }

    private BinaryNode insertRec(BinaryNode root, int value) {
        if (root == null) {
            return new BinaryNode(value);
        }
        if (value < root.getValue()) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insertRec(root.getRight(), value));
        }
        return root;
    }

    private String convertTreeToJson(BinaryNode root) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return  gson.toJson(root);
    }
    private void saveTreeJson(String treejson){
        TreeStructure treeStructure = new TreeStructure(treejson);
        treeStructureRepository.save(treeStructure);
    }

    public List<TreeStructure> getPreviousTreeJson() {
        return treeStructureRepository.findAll();
    }
}
