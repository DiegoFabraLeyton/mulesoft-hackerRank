package com.mulesoft.exercise;

import com.mulesoft.exercise.model.FileComponent;
import com.mulesoft.exercise.usecases.*;
import com.mulesoft.exercise.usecases.impl.DefaultCreateDirectory;
import com.mulesoft.exercise.usecases.impl.DefaultCreateFile;

import java.util.HashSet;
import java.util.Set;

public class DefaultCommandManager implements CommandManager {

    private FolderExist folderExist;
    private FileComponent root;
    private ListFileComponent listFileComponent;
    private ChangeDirectory changeDirectory;
    private ShowPath showPath;


    private FileComponent current;

    public DefaultCommandManager(final FolderExist folderExist,
                                 final FileComponent root,
                                 final ListFileComponent listFileComponent,
                                 final ChangeDirectory changeDirectory,
                                 final ShowPath showPath) {

        this.folderExist = folderExist;
        this.root = root;
        this.listFileComponent = listFileComponent;
        this.changeDirectory = changeDirectory;
        this.showPath = showPath;


        this.current = root;

    }

    @Override
    public FileComponent executeStep(final String command) {

        final String[] splitCommand = command.trim().split(" ");

        final String useCommand = splitCommand[0];

        if (commands().contains(useCommand)) {

            switch (useCommand) {

                case "mkdir":

                    String name = splitCommand[1];

                    CreateDirectory createDirectory = new DefaultCreateDirectory(folderExist);

                    current = createDirectory.create(current, name);

                    return current;

                case "cd":

                    name = splitCommand[1];

                    final FileComponent change = changeDirectory.change(current, name);

                    current = change;

                    return current;

                case "touch":

                    name = splitCommand[1];

                    CreateFile createFile = new DefaultCreateFile();

                    createFile.touch(current,name);

                    return current;


                case "ls":

                   listFileComponent.showFiles(current);

                   return current;

                case "pwd":

                    showPath.display();

                    return current;

            }

        }

        System.out.print(" Unrecognized command");

        return current;

    }

    private static Set<String> commands() {

        Set<String> commands = new HashSet<>();

        commands.add("mkdir");
        commands.add("touch");
        commands.add("cd");
        commands.add("ls");
        commands.add("pwd");

        return commands;
    }

}
