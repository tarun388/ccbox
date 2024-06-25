package com.verma.tarun.ccbox.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Folder {
    
    @Id
    private String id;

    private String name;
    private List<Folder> childFolders;
    private List<File> childFiles;

    private Folder() {};

    public Folder(String name) {
        this.name = name;
    }

    public Folder(String name, List<Folder> folders, List<File> files) {
        this.name = name;
        this.childFolders = folders;
        this.childFiles = files;
    }
}
