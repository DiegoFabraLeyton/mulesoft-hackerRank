package com.mulesoft.exercise.usecases;

import com.mulesoft.exercise.model.FileComponent;

public interface CreateDirectory  {

    FileComponent create(FileComponent root, String name);
}
