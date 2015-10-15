package io.zipcoder.undertakers.decisionenginebackend;

/**
 * Created by rsparks on 10/15/15.
 */
public class Job {
    private String position;
    private int income;
    private String company;
    private String type;

    public Job(String position, int income, String company, String type){
        this.position = position;
        this.income = income;
        this.company = company;
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public int getIncome() {
        return income;
    }

    public String getCompany() {
        return company;
    }

    public String getType() {
        return type;
    }
}
