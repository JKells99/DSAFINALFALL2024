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
        String[] jsons = convertTreeToJson(root, numbers);
        saveTreeJson(jsons[0], jsons[1]);
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

    private String[] convertTreeToJson(BinaryNode root, List<Integer> numbers) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String treeJson = gson.toJson(root);
        String userInputsJson = gson.toJson(numbers);
        return new String[]{treeJson, userInputsJson};
    }

    private void saveTreeJson(String treeJson, String userInputsJson) {
        TreeStructure treeStructure = new TreeStructure(treeJson, userInputsJson);
        treeStructureRepository.save(treeStructure);
    }

    public List<TreeStructure> getPreviousTreeJson() {
        return treeStructureRepository.findAll();
    }
}