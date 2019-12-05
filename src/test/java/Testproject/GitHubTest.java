package Testproject;

import org.testng.annotations.BeforeSuite;

import java.io.*;

public class GitHubTest {
    @BeforeSuite
    public void GitTest() throws IOException {
        String command = "cmd.exe /c start "+"cd C:\\Users\\User\\Selina && git status && git pull";
        Process child = Runtime.getRuntime().exec(command);
}
}
