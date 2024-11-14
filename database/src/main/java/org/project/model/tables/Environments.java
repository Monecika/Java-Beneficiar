package org.project.model.tables;

public class Environments {
    private String environment;
    private int popularityPercentage;

    public Environments(String environment, int popularityPercentage) {
        this.environment = environment;
        this.popularityPercentage = popularityPercentage;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getPopularityPercentage() {
        return popularityPercentage;
    }

    public void setPopularityPercentage(int popularityPercentage) {
        this.popularityPercentage = popularityPercentage;
    }
}
