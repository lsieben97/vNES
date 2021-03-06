package com.lsieben.retroscript;

import com.lsieben.retroscript.lang.constructs.CodeBase;
import com.lsieben.retroscript.lang.exceptions.RetroScriptCompilerException;
import com.lsieben.retroscript.logger.Logger;
import com.lsieben.retroscript.models.VnesProject;
import com.lsieben.retroscript.parser.Parser;
import org.apache.commons.cli.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Compiler {
    public static final String VERSION = "v1.0.0";

    static void compile(CommandLine commandLine) {
        if (commandLine.hasOption("output") || commandLine.hasOption("library")) {
            String input = commandLine.getOptionValue("compile");
            if(commandLine.hasOption("output")) {
                String output = commandLine.getOptionValue("output");
                // compile to rom
                VnesProject project = ProjectManager.makeProjectFromDefinition(input);
                if (project != null) {
                    Logger.writeInfo("Starting ROM compilation for project '" + project.getName() + "'");
                    // compile rom...
                }
            } else {
                // compile to library
                String library = commandLine.getOptionValue("library");
                VnesProject project = ProjectManager.makeProjectFromDefinition(input);
                if (project != null) {
                    Logger.writeInfo("Starting Library compilation for project '" + project.getName() + "'");
                    // compile library...
                    CodeBase codeBase = new CodeBase();
                    CodeBase.setCurrent(codeBase);
                    codeBase.setProject(project);
                    codeBase.setSourceFiles(new ArrayList<>());
                    List<File> sourceFiles = ProjectManager.getSourceFilesForProject(project);
                    for( File file : sourceFiles) {
                        codeBase.getSourceFiles().add(Parser.parseFile(file));
                    }

                    try {
                        codeBase.validate();
                    }
                    catch (RetroScriptCompilerException ex) {
                        Logger.writeError(ex);
                    }

                    // Write codebase to a file.


                }
            }

        } else {
            Logger.writeError("argument 'compile' requires argument 'output' or 'library' to be present");
        }
    }

}
