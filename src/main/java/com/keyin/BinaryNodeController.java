package com.keyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BinaryNodeController {

    @Autowired
    BinaryNodeService binaryNodeService;

    @PostMapping("/buildTree")
    public BinaryNode buildBinarySearchTree(@RequestBody List<Integer> numbers) {
       return binaryNodeService.buildTree(numbers);
    };

    @GetMapping("/getPreviousTrees")
    public List<TreeStructure> getPreviousTrees() {
       return binaryNodeService.getPreviousTreeJson();
    }
}
