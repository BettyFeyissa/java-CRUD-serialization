import java.io.Serializable;

// This defines a topic to be on the study guide
public class Topic implements Serializable {
    // create class attributes
    private String name;
    private String description;
    private String listoftask;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListoftask() {
        return listoftask;
    }

    public void setListoftask(String listoftask) {
        this.listoftask = listoftask;
    }

    // create constructor method
    public Topic(String name,String description,String listoftask) {
        this.name = name;
        this.description = description;
        this.listoftask = listoftask;
    }

    // create instance method to print in well formatted way
    public void print(){
        System.out.println("\nTopic Name: " + this.name + "\nTopic Description: " + this.description + "\nList of Tasks: " + this.listoftask);
    }

    // this define a method that allows for a user to add a new task to the list of tasks
    public void newTask(String listoftask){
        this.listoftask = this.listoftask + listoftask;
    }
}