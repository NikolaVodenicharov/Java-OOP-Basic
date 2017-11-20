public class Worker extends Human{
    private final int LAST_NAME_LENGTH_ABOVE = 3;
    private final double WEEK_SALARY_ABOVE = 10;
    private final double MINIMUM_WORKING_HOURS = 1;
    private final double MAXIMUM_WORKING_HOURS = 12;
    private final int WORK_DAYS_WEEKLY = 7;

    private double weekSalary;
    private double workingHoursDaily;

    public Worker (String firstName, String lastName, double weekSalary, double workingHoursDaily){
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkingHoursDaily(workingHoursDaily);
    }

    @Override
    protected void setLastName(String lastName){
        if (lastName == null){
            throw new NullPointerException("Last name can not be null.");
        }
        if (lastName.trim().length() == 0){
            throw new IllegalArgumentException("Last name can not be white space");
        }
        if (lastName.length() <= LAST_NAME_LENGTH_ABOVE){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }

        super.setLastName(lastName);
    }
    private void setWeekSalary(double weekSalary){
        if (weekSalary <= WEEK_SALARY_ABOVE){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }
    private void setWorkingHoursDaily(double workingHoursDaily){
        if (workingHoursDaily < MINIMUM_WORKING_HOURS || workingHoursDaily > MAXIMUM_WORKING_HOURS){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.workingHoursDaily = workingHoursDaily;
    }

    private double calculateHourSalary(){
        double hourSalary = this.weekSalary / WORK_DAYS_WEEKLY / this.workingHoursDaily;
        return hourSalary;
    }

    @Override
    public String toString(){
        StringBuilder formated = new StringBuilder();
        formated
                .append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Week Salary: %.2f", this.weekSalary))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.workingHoursDaily))
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.calculateHourSalary()));

        return formated.toString();
    }
}

