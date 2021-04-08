package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.File;
import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.usecases.CreateFile;

public class DefaultCreateFile implements CreateFile {

    @Override
    public FileComponent touch(final FileComponent current, String name) {

        File file = new File(name);

        current.addFileComponent(file);

        return current;
    }
}
