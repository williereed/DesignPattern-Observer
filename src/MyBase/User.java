package MyBase;

import java.util.ArrayList;

public class User implements Observer {

    private String mostRecentArticle;
    private ArrayList<String> allArticles;
    private Subject blog;
    private String name;

    // make the default constructor private to force passing a name
    private User() {}

    public User(String n) {
        name = n;
        allArticles = new ArrayList<String>();
    }

    public void setSubject(Subject blog) {
        this.blog = blog;
        mostRecentArticle = "No New Article!";
        System.out.println(name + ": " + mostRecentArticle);
    }

    @Override
    public void update() {
        mostRecentArticle = (String) blog.getUpdate();
        allArticles.add(mostRecentArticle);
        System.out.println(name + ": New article found \"" + mostRecentArticle + "\"");
    }

    public String getArticle() {
        return mostRecentArticle;
    }

    public void displayAllArticles() {
        System.out.println(name + ": All articles include...");
        for (String t :allArticles) {
            System.out.println("\"" + t + "\"");
        }
    }
}