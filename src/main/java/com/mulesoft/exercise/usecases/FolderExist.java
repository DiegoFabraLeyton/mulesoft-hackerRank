package com.mulesoft.exercise.usecases;

import com.mulesoft.exercise.model.Folder;

public interface FolderExist {

    boolean exits(Folder component, String name);
}
