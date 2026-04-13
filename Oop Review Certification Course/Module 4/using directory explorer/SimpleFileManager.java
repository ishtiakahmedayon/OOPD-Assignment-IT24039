import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SimpleFileManager {

    private File currentDir;
    private Scanner sc;

    public SimpleFileManager() {
        currentDir = new File(System.getProperty("user.dir"));
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Simple File Manager Started");
        System.out.println("Commands: ls, cd <name>, mkdir <name>, touch <name>, rm <name>, pwd, exit");

        while (true) {
            System.out.print(currentDir.getName() + "> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;

            handleCommand(input);
        }

        sc.close();
        System.out.println("Exited File Manager");
    }

    private void handleCommand(String input) {
        String[] cmd = input.split(" ", 2);
        String action = cmd[0];

        String arg = (cmd.length > 1) ? cmd[1] : "";

        switch (action) {

            case "ls":
                listFiles();
                break;

            case "pwd":
                System.out.println(currentDir.getAbsolutePath());
                break;

            case "cd":
                changeDir(arg);
                break;

            case "mkdir":
                createFolder(arg);
                break;

            case "touch":
                createFile(arg);
                break;

            case "rm":
                deleteFile(arg);
                break;

            default:
                System.out.println("Unknown command");
        }
    }

    private void listFiles() {
        File[] files = currentDir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Empty directory");
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("[DIR]  " + f.getName());
            } else {
                System.out.println("[FILE] " + f.getName());
            }
        }
    }

    private void changeDir(String name) {
        if (name.equals("..")) {
            File parent = currentDir.getParentFile();
            if (parent != null) currentDir = parent;
            return;
        }

        File next = new File(currentDir, name);

        if (next.exists() && next.isDirectory()) {
            currentDir = next;
        } else {
            System.out.println("Directory not found");
        }
    }

    private void createFolder(String name) {
        if (name.isEmpty()) {
            System.out.println("Folder name required");
            return;
        }

        File f = new File(currentDir, name);

        if (f.mkdir()) {
            System.out.println("Folder created");
        } else {
            System.out.println("Failed to create folder");
        }
    }

    private void createFile(String name) {
        if (name.isEmpty()) {
            System.out.println("File name required");
            return;
        }

        File f = new File(currentDir, name);

        try {
            if (f.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file");
        }
    }

    private void deleteFile(String name) {
        File f = new File(currentDir, name);

        if (!f.exists()) {
            System.out.println("Not found");
            return;
        }

        if (f.delete()) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Delete failed");
        }
    }

    public static void main(String[] args) {
        SimpleFileManager fm = new SimpleFileManager();
        fm.run();
    }
}
