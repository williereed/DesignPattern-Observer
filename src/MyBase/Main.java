package MyBase;

public class Main {

    public static void main(String[] args) {

        Blog blog = new Blog();

        // create and register user1
        User user1 = new User("Paul");
        blog.registerObserver(user1);
        user1.setSubject(blog);

        System.out.println("Main: posting a new article");
        blog.postNewArticle("first post");

        // create and register user2
        User user2 = new User("Fred");
        blog.registerObserver(user2);
        user2.setSubject(blog);

        System.out.println("Main: posting a new article");
        blog.postNewArticle("second post");

        // unregister user2
        blog.unRegisterObserver(user2);

        System.out.println("Main: posting a new article");
        blog.postNewArticle("third post");

        user1.displayAllArticles();
    }
}
