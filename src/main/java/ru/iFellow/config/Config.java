package ru.iFellow.config;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties prop = new Properties();
    private @Getter String url;
    private @Getter String userName;
    private @Getter String password;
    private @Getter String testProjectName;
    private @Getter String counterTaskName;
    private @Getter String detailsTaskName;
    private @Getter String issueReportName;

    public  Config() {
        try (InputStream input = new FileInputStream("src/test/resources/jiraTests.properties")) {
            prop.load(input);
            url = prop.getProperty("url");
            userName = prop.getProperty("login");
            password = prop.getProperty("password");
            testProjectName = prop.getProperty("testProjectName");
            counterTaskName = prop.getProperty("counterTaskName");
            detailsTaskName = prop.getProperty("detailsTaskName");
            issueReportName = prop.getProperty("issueReportName");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
