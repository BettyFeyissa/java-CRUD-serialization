import java.util.*;
import java.io.*;

public class StudyGuide {
    ArrayList<Topic> topics;

    Scanner scan = new Scanner(System.in);

    private static HashMap<String, String>
    convertArrayListToHashMap(ArrayList<Topic> arrayList)
    {

        LinkedHashMap<String, String> linkedHashMap
                = new LinkedHashMap<>();

        for (Topic top : arrayList) {
            linkedHashMap.put("Topic Name", top.getName());
            linkedHashMap.put("Topic Description", top.getDescription());
            linkedHashMap.put("List of Task", top.getListoftask());
            linkedHashMap.keySet();
            linkedHashMap.values();

            // key should be unique
        }
        return linkedHashMap;
    }
    public StudyGuide() {
        //initialization an empty array
        this.topics = new ArrayList<Topic>();
    }

    //instance method to print
    public void printTopics() {
        System.out.println("Here are the list of topics");
        //for (Topic topic : this.topics) {
          //  topic.print();
            //}
        HashMap<String, String> hashTopics= convertArrayListToHashMap(this.topics);
        for (Map.Entry<String, String> entry :
                hashTopics.entrySet()) {

            System.out.println(entry.getKey() + " : "
                    + entry.getValue());
            //print the topics
            //this.printTopics();
        }
    }


    //instance method to create topics
    public void createTopics() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the topic you want to study?");
        String name = scan.nextLine();
        System.out.println("What is the description of the topic?");
        String description = scan.nextLine();
        System.out.println("what are the list of tasks for this topic?");
        String listoftasks = scan.nextLine();

        //create a new instance of Topic class
        Topic topic = new Topic(name, description, listoftasks);

        //add the new topic to the arraylist
        this.topics.add(topic);
        saveData(topics);

       /* HashMap<String, String> hashTopics= convertArrayListToHashMap(topics);
        for (Map.Entry<String, String> entry :
                hashTopics.entrySet()) {

            System.out.println(entry.getKey() + " : "
                    + entry.getValue());
            //print the topics
            //this.printTopics();
        }*/

    }

    //instance method to update a topic
    public void updateTopic() {
        Scanner scan = new Scanner(System.in);
        loadData();
        this.printTopics();
        System.out.println("What is the name of the topic you want to update? ");
        String name = scan.nextLine();

        //find the topic
        for (Topic topicToUpdate : this.topics) {
            if (topicToUpdate.getName().equalsIgnoreCase(name)) {
                //update this topic
                System.out.println("What is the new name of the topic? ");
                topicToUpdate.setName(scan.nextLine());
                System.out.println("What is the new description?");
                topicToUpdate.setDescription(scan.nextLine());
                System.out.println("What are the list of tasks? ");
                topicToUpdate.setListoftask(scan.nextLine());
                break;
            }
        }
    }

    //instance method to delete topic
    public void deleteTopic() {
        Scanner scan = new Scanner(System.in);
        this.printTopics();
        System.out.println("what is the name of the topic you want to delete? ");
        String name = scan.nextLine();
        Topic topicToDelete;
        //step 1: find the item
        for (Topic t : this.topics) {
            if (t.getName().equalsIgnoreCase(name)) {
                //delete this topic
                topicToDelete = t;
                this.topics.remove(topicToDelete);
                break;
            }
        }
    }

    public static void saveData(ArrayList <Topic> topics) {
        //ArrayList<Topic> topics = new ArrayList<>();
        // Serialization
        try {
            FileOutputStream fileOut = new FileOutputStream("topics.ser");
            // ^ opening a connect to a new file and allowing to connect
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // ^ streaming data from an object into a file
            out.writeObject(topics);
            // take this object and i'm lobbing it
            out.close();
            // close it once we are done with the file
            fileOut.close();
            // close it once we are done with the file
            System.out.println("Serialized data is saved!");

        } catch (IOException i) {
            i.printStackTrace();
            // history of all the methods that were called - allows us to see where the code went wrong.
            //principle of a stack is similar to pringles - last in, first out
        }
    }

    public static void loadData() {
        // we need to read from the file object.ser the data for our topic
        // and if possible create a new employee otherwise return null

        ArrayList<Topic> topics = new ArrayList<>(); // this create an object of type topic to receive data from file or return

        //Deserialization
        try {
            // read object from a file
            FileInputStream file = new FileInputStream("topics.ser");
            // create a connect to a file
            ObjectInputStream in = new ObjectInputStream(file);

            // method for deserialization for an object
            topics = (ArrayList<Topic>)in.readObject();
            // read object and convert data to type Topic

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            System.out.println(topics.size());

            for (Topic t : topics)
                t.print();

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}