package com.verma.tarun.ccbox.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verma.tarun.ccbox.model.Folder;

public interface FolderRepository extends MongoRepository<Folder, String> {
    List<Folder> findByName(String name);
}
