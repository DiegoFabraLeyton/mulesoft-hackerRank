package com.mulesoft.exercise.model;

import com.mulesoft.exercise.model.FileComponent;

public class File implements FileComponent {

    private String name;

    public File(final String name) {
        this.name = name;
    }

    @Override
    public FileComponent addFileComponent(FileComponent component) {
       throw new UnsupportedOperationException("");
    }

    @Override
    public void display() {

        System.out.print(getName());

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}
