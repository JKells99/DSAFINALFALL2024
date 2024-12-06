package com.keyin;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity

public class TreeStructure {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5000)
    private String treeJson;

    public TreeStructure(String treeJson) {
        this.treeJson = treeJson;
    }

    public TreeStructure() {

    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
