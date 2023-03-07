package africa.semicolon.myBlogApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
//      private static UserController userController = new UserController();
//    private static ArticleController articleController = new ArticleController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//         startApp();
    }

//    private static void startApp() {
//        String message = """
//                Hi Welcome, What would you like to do?::
//                1 -> Register.
//                2 -> Create Post.
//                3 -> Find Users.
//                4 -> Find Post.
//                5 -> Exit.
//                """;
//        String input = input(message);
//        switch (input.charAt(0)){
//            case '1' -> register();
//            case '2' -> createPost();
//            case '3' -> findUser();
//            case '4' -> findPost();
//            case '5' -> exitApplication();
//            default -> {
//                display("Invalid input try again");
//                startApp();
//            }
//        }
//    }
//
//    private static void findPost(){
//        String userInput = input("Enter user ID to search:: ");
//        display(articleController.findPost(Integer.parseInt(userInput)).toString());
//        startApp();
//    }
//
//    private static void createPost() {
//        String title = input("What's ur title?:: ");
//        String body = input("What would you want to post today?:: ");
//        int id = Integer.parseInt(input("Enter user id to post:: "));
////        var post = articleController.createPost(title,body,id);
////        display(post.toString());
//        startApp();
//    }
//
//    private static void exitApplication() {
//        display("Thanks for using this application.");
//        System.exit(1);
//    }
//
//    private static void findUser() {
//        String userInput = input("Enter user ID to search:: ");
//        display(userController.findUserById(Integer.parseInt(userInput)).toString());
//        startApp();
//    }
//
//    private static void register() {
//        RegisterRequest request = new RegisterRequest();
//        request.setFirstName(input("Enter first Name:: "));
//        request.setLastName(input("Enter last Name:: "));
//        request.setUsername(input("Enter username:: "));
//        request.setPassword(input("Enter password:: "));
//        var result = userController.register(request);
//        display(result.toString());
//        startApp();
//    }
//
//    private static void display(String message) {
//        JOptionPane.showMessageDialog(null, message);
//    }
//    private static String input(String dialogue) {
//        return JOptionPane.showInputDialog(dialogue);
//    }
}