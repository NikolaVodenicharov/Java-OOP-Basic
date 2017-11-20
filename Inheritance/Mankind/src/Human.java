public class Human {
    private final int FIRST_NAME_MINIMUM_LENGTH = 4;
    private final int LAST_NAME_MINIMUM_LENGTH = 3;

    private String firstName;
    private String lastName;

    public Human (String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName){
        if (firstName == null){
            throw new NullPointerException("First name can not be null.");
        }
        if (firstName.trim().length() == 0){
            throw new IllegalArgumentException("First name can not be white space");
        }
        if (!Character.isUpperCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < FIRST_NAME_MINIMUM_LENGTH){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }
    protected void setLastName(String lastName){
        if (lastName == null){
            throw new NullPointerException("Last name can not be null.");
        }
        if (lastName.trim().length() == 0){
            throw new IllegalArgumentException("Last name can not be white space");
        }
        if (!Character.isUpperCase(lastName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < LAST_NAME_MINIMUM_LENGTH){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName ");
        }

        this.lastName = lastName;
    }

    @Override
    public String toString(){
        StringBuilder formated = new StringBuilder();
        formated
                .append(String.format("First Name: %s", this.firstName))
                .append(System.lineSeparator())
                .append(String.format("Last Name: %s", this.lastName));

        return formated.toString();
    }
}
