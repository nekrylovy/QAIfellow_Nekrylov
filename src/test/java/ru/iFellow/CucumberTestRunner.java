package ru.iFellow;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/main/java/ru/iFellow/steps")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/ru/iFellow/feature")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@jira")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "ru.iFellow")

public class CucumberTestRunner {
}
