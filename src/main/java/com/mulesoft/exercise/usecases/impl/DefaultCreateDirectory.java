package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.model.Folder;
import com.mulesoft.exercise.usecases.CreateDirectory;
import com.mulesoft.exercise.usecases.FolderExist;

public class DefaultCreateDirectory implements CreateDirectory {

    private FolderExist folderExits;

    public DefaultCreateDirectory(final FolderExist folderExits) {
        this.folderExits = folderExits;
    }

    @Override
    public FileComponent create(final FileComponent root, String name) {

        if(folderExits.exits((Folder) root,name)){

            System.out.println("Directory already exit");

            return root;
        }

        Folder folder = new Folder(name);

        root.addFileComponent(folder);

        return root;

    }
}
