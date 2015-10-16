package io.zipcoder.undertakers.decisionenginebackend;

/**
 * Created by rsparks on 10/15/15.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String social;
    private boolean male;
    private Job[] jobs;
    private int dependants;
    private boolean married;
    private int debt;
    private Asset[] assets;

    /**
     * Constructor for the person class
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param social String (social security number)
     * @param male boolean
     * @param jobs Job[]
     * @param dependants int
     * @param married boolean
     * @param debt int
     * @param assets Asset[]
     */
    public Person(String firstName, String lastName, int age, String social,boolean male,Job[] jobs,int dependants,boolean married,int debt,Asset[] assets){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.social = social;
        this.male = male;
        this.jobs = jobs;
        this.dependants = dependants;
        this.married = married;
        this.debt = debt;
        this.assets = assets;
    }

    /**
     * Cycles through assets and calculates the Total Score
     * @return assetScore - total score of assets
     */
    public int getAssetScore(){
        int assetScore = 0;
        for(Asset asset: assets){
            assetScore+=asset.calculateScore();
        }
        return assetScore;
    }

    /**
     * Cycles through jobs and calculates total income
     * @return totalIncome
     */
    public int getTotalIncome(){
        int totalIncome = 0;
        for(Job job: jobs){
            totalIncome += job.getIncome();
        }
        return totalIncome;
    }

    /**
     * assigns a random credit score depending on the person's age
     * @return creditScore - randomized credit score
     */
    public int lookupCreditScore(){
        int creditScore=0;
        if(age<=25){
            creditScore = (int)(Math.random()*400)+400;
        }
        else if(age>25&&age<=35){
            creditScore = (int)(Math.random()*300)+500;
        }
        else if(age>35){
            creditScore = (int)(Math.random()*150)+650;
        }
        return creditScore;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSocial() {
        return social;
    }

    public boolean isMale() {
        return male;
    }

    public Job[] getJobs() {
        return jobs;
    }

    public int getDependants() {
        return dependants;
    }

    public boolean isMarried() {
        return married;
    }

    public int getDebt() {
        return debt;
    }

    public Asset[] getAssets() {
        return assets;
    }
}
