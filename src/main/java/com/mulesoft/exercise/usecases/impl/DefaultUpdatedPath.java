package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.model.Folder;
import com.mulesoft.exercise.model.Path;
import com.mulesoft.exercise.usecases.GetPath;
import com.mulesoft.exercise.usecases.UpdatePath;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DefaultUpdatedPath implements UpdatePath {

    private GetPath getPath;

    public DefaultUpdatedPath(final GetPath getPath) {
        this.getPath = getPath;
    }

    @Override
    public void updated(final FileComponent fileComponent) {

        final Path rootPath = getPath.get();

        Set<String> namesFolders = rootPath.getListFolderNames();

        if(fileComponent.isDirectory()) {

            final String name = ((Folder) fileComponent).getName();

            if(namesFolders.contains(name)){

                final List<String> namesList = new ArrayList<>(namesFolders);

                final Set<String> newPath = new LinkedHashSet<>();

                for (String s : namesList){

                    if(!s.equals(name)){

                        newPath.add(s);
                    }

                    break;
                }

                newPath.add(name);

                rootPath.setPath(newPath);
            }

            namesFolders.add(name);

            rootPath.getFileComponentMap().put(name,fileComponent);

        }

    }
}
