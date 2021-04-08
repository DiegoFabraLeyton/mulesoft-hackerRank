package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.model.Folder;
import com.mulesoft.exercise.usecases.FolderExist;

import java.util.List;

public class DefaultFolderExit implements FolderExist {

    @Override
    public boolean exits(final Folder component, String name) {

        final List<FileComponent> componentList = component.getComponentList();

        if (componentList.isEmpty()) {

            return false;
        }

        for (FileComponent c : componentList) {

            if (c.isDirectory()) {

                final Folder folder = (Folder) c;

                return name.equals(folder.getName());
            }
        }

        return false;
    }
}
