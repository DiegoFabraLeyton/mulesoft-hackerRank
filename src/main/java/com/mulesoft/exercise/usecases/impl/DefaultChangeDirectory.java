package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.model.Folder;
import com.mulesoft.exercise.model.IsDirectory;
import com.mulesoft.exercise.model.Path;
import com.mulesoft.exercise.usecases.ChangeDirectory;
import com.mulesoft.exercise.usecases.GetPath;
import com.mulesoft.exercise.usecases.UpdatePath;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultChangeDirectory implements ChangeDirectory {

    private UpdatePath updatePath;
    private GetPath getPath;


    public DefaultChangeDirectory(final UpdatePath updatePath,final GetPath getPath) {

        this.updatePath = updatePath;
        this.getPath = getPath;

    }

    @Override
    public FileComponent change(final FileComponent current, String name) {

        if(!"..".equals(name)){

            return moveToForward(current, name);
        }

        return MoveToBack(current);

    }

    private FileComponent MoveToBack(final FileComponent current) {

        final Path path = getPath.get();

        final Map<String, FileComponent> fileComponentMap = path.getFileComponentMap();

        if(fileComponentMap.size() == 1){
            return current;
        }
        final Set<String> names = path.getListFolderNames();

        List<String> strings = new ArrayList<>(path.getListFolderNames());

        final String key = strings.get(names.size() - 2);

        final FileComponent fileComponent = fileComponentMap.get(key);

        updatePath.updated(fileComponent);

        return fileComponent;
    }

    private FileComponent moveToForward(FileComponent current, String name) {
        final Folder folder = (Folder) current;

        final List<FileComponent> componentList = folder.getComponentList();

        final List<FileComponent> fileComponent = componentList.stream().filter(IsDirectory::isDirectory).collect(Collectors.toList());

        final List<Folder> folders = fileComponent.stream().map(e -> (Folder) e).collect(Collectors.toList());

        final Optional<Folder> optionalFolder = folders.stream().filter(e -> e.getName().equals(name)).findFirst();

        if(optionalFolder.isPresent()){

            final Folder newRootFolder = optionalFolder.get();

            updatePath.updated(newRootFolder);

            return newRootFolder;
        }

        System.out.println("Directory Not found");

        return current;
    }
}
