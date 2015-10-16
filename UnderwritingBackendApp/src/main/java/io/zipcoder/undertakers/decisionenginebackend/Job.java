package io.zipcoder.undertakers.decisionenginebackend;

/**
 * Created by rsparks on 10/15/15.
 */
public class Job {
    private String position;
    private int income;
    private String company;
    private String type;

    public Job() {
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setType(String type) {
        this.type = type;
    }

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
