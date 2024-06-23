package com.verma.tarun.ccbox.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.verma.tarun.ccbox.model.Folder;

@RepositoryRestResource(collectionResourceRel = "folder", path = "folder")
public interface FolderRepository extends MongoRepository<Folder, Long> {
    List<Folder> findByName(String name);
}
