package com.mulesoft.exercise.model;

public interface FileComponent extends IsDirectory, DisplayFileComponent {

    FileComponent addFileComponent(FileComponent root);

}
