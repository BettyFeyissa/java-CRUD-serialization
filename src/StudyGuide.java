import java.util.ArrayList;
import java.util.Scanner;

public class StudyGuide {
    ArrayList<Topic> topics;
    Scanner scan = new Scanner(System.in);
    public StudyGuide(){
        //initialization an empty array
        this.topics = new ArrayList<Topic>();
    }

    //instance method to print
    public void printTopics(){
        System.out.println("Here are the list of topics");
        for(Topic topic : this.topics){
            topic.print();
        }
    }

    //instance method to create topics
    public void createTopics(){
        System.out.println("What is the name of the topic you want to study?");
        String name = scan.nextLine();
        System.out.println("What is the description of the topic?");
        String description = scan.nextLine();
        System.out.println("what are the list of tasks for this topic?");
        String listoftasks = scan.nextLine();

        //create a new instance of Topic class
        Topic topic = new Topic(name,description,listoftasks);

        //add the new topic to the arraylist
        this.topics.add(topic);

        //print the topics
        this.printTopics();
    }

    //instance method to update a topic
    public void updateTopic() {
        this.printTopics();
        System.out.println("What is the name of the topic you want to update? ");
        String name = scan.nextLine();

        //find the topic
        for (Topic topicToUpdate : this.topics) {
            if (topicToUpdate.name.equalsIgnoreCase(name)) {
                //update this topic
                System.out.println("What is the new name of the topic? ");
                topicToUpdate.name = scan.nextLine();
                System.out.println("What is the new description?");
                topicToUpdate.description = scan.nextLine();
                System.out.println("What are the list of tasks? ");
                topicToUpdate.listoftask = scan.nextLine();
                break;
            }
        }
    }
    //instance method to delete topic
    public void deleteTopic(){
        this.printTopics();
        System.out.println("what is the name of the topic you want to delete? ");
        String name = scan.nextLine();
        Topic topicToDelete;
        //step 1: find the item
        for (Topic t:this.topics) {
            if(t.name.equalsIgnoreCase(name)) {
                //delete this topic
                topicToDelete = t;
                this.topics.remove(topicToDelete);
                break;
            }
        }
    }
}