package com.verma.tarun.ccbox.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Folder {
    
    @Id
    private Long id;

    private String name;
    private List<Folder> childFolders;
    private List<File> childFiles;
}
