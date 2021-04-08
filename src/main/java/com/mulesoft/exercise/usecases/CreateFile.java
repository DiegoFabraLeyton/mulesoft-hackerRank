package com.mulesoft.exercise.usecases;

import com.mulesoft.exercise.model.FileComponent;

public interface CreateFile {

    FileComponent touch(FileComponent root, String name);
}
