package com.mulesoft.exercise;

import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.model.Folder;
import com.mulesoft.exercise.model.Path;
import com.mulesoft.exercise.usecases.*;
import com.mulesoft.exercise.usecases.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Folder root = new Folder("root");

        System.out.println("Input command");

        final FolderExist exist = new DefaultFolderExit();

        final ListFileComponent listFileComponent = new DefaultListFileComponent();

        final Set<String> setPaths = new LinkedHashSet<>();

        setPaths.add(root.getName());

        Map<String, FileComponent> fileComponentMap = new HashMap<>();

        fileComponentMap.put(root.getName(), root);

        final Path path = new Path(setPaths, fileComponentMap);

        final GetPath getPath = new DefaultGetPath(path);

        final UpdatePath updatePath = new DefaultUpdatedPath(getPath);

        final ChangeDirectory changeDirectory = new DefaultChangeDirectory(updatePath,getPath);

        final ShowPath showPath = new DefaultShowPath(getPath);

        final CommandManager commandManager = new DefaultCommandManager(exist, root, listFileComponent,changeDirectory,showPath);

        String command = bufferedReader.readLine();

        while (!command.equals("quit")) {

            commandManager.executeStep(command);

            command = bufferedReader.readLine();

            System.out.print(" ");

        }

    }
}

