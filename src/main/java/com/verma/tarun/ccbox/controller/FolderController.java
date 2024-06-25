package com.verma.tarun.ccbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verma.tarun.ccbox.model.Folder;
import com.verma.tarun.ccbox.repository.FolderRepository;

@RestController()
@RequestMapping("/folder")
public class FolderController {

    private static final Logger log = LoggerFactory.getLogger(FolderController.class);

    @Autowired
    private FolderRepository repository;

    @GetMapping
    public ResponseEntity<?> getFolder(@RequestParam String name) {
        List<Folder> folders = repository.findByName(name);
        if (folders == null || folders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(folders.get(0));
    }

    @PostMapping
    public ResponseEntity<?> createFolder(@RequestParam String name) {
        List<Folder> folders = repository.findByName(name);
        if (!folders.isEmpty()) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }

        Folder newFolder = repository.save(new Folder(name, new ArrayList<>(), new ArrayList<>()));

        return ResponseEntity.ok(newFolder);
    }

    @PutMapping
    public ResponseEntity<?> addFolder(@RequestParam String parentFolder, @RequestParam String childFolder) {
        List<Folder> folders = repository.findByName(parentFolder);
        if (folders == null || folders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Folder folder = folders.get(0);
        folder.getChildFolders().add(new Folder(childFolder));

        Folder updatedFolder = repository.save(folder);

        return ResponseEntity.ok(updatedFolder);
    }
    
}
