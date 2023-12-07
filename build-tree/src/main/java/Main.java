import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.declarative.DeclarativeBuildTree;
import org.gradle.tooling.declarative.DeclarativeConnection;
import org.gradle.tooling.declarative.DeclarativeConnector;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            loadBuildTreeFrom(new File(".").getAbsoluteFile());
        } else {
            loadBuildTreeFrom(new File(args[0]).getAbsoluteFile());
        }
    }

    private static void loadBuildTreeFrom(File rootDir) {
        System.out.println("Loading build tree from " + rootDir);
        DeclarativeConnector connector = DeclarativeConnector.newConnector(
                GradleConnector.newConnector().forProjectDirectory(rootDir)
        );
        DeclarativeConnection connection = connector.connect();
        DeclarativeBuildTree buildTree = connection.getBuildTree();
        File rootProjectDirectory = buildTree.getRootProjectDirectory();
        System.out.println("  root: " + rootProjectDirectory + " (isDirectory: " + rootProjectDirectory.isDirectory() + ")");
        for (File projectDirectory : buildTree.getSubprojectsDirectories()) {
            System.out.println("  sub:  " + projectDirectory + " (isDirectory: " + projectDirectory.isDirectory() + ")");
        }
    }
}
