package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.File;
import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.model.Folder;
import com.mulesoft.exercise.usecases.ListFileComponent;

import java.util.List;

public class DefaultListFileComponent implements ListFileComponent {

    @Override
    public FileComponent showFiles(FileComponent current) {

        final Folder folder = (Folder) current;

        final List<FileComponent> componentList = folder.getComponentList();

        componentList.forEach(component -> {

            if(component instanceof Folder){

               System.out.print (" " + ((Folder) component).getName());
            }

            if(component instanceof File){

                System.out.print (" " + ((File) component).getName());
            }

        });

        System.out.println(" ");

        return current;
    }
}
