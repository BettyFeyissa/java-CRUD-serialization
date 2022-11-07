// This defines a topic to be on the study guide
public class Topic {
    // create class attributes
    String name;
    String description;
    String listoftask;
    // create constructor method
    public Topic(String name,String description,String listoftask) {
        this.name = name;
        this.description = description;
        this.listoftask = listoftask;
    }

    // create instance method to print in well formatted way
    public void print(){
        System.out.println("Topic Name: " + this.name + "\nTopic Description: " + this.description + "\nList of Tasks: " + this.listoftask);
    }

    // this define a method that allows for a user to add a new task to the list of tasks
    public void newTask(String listoftask){
        this.listoftask = this.listoftask + listoftask;
    }
}