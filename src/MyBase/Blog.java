package MyBase;

import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject {

    List<Observer> observersList;
    private boolean stateChange;
    private String currentArticle;

    public Blog() {
        this.observersList = new ArrayList();
        stateChange = false;
    }

    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    public void unRegisterObserver(Observer observer) {
        observersList.remove(observer);
    }

    public void notifyObserver() {

        if (stateChange) {
            for (Observer observer : observersList) {
                observer.update();
            }
        }
    }

    public Object getUpdate() {
        Object changedState = null;
        // should have logic to send the
        // state change to querying observer
        if (stateChange) {
            changedState = currentArticle;
        }
        return changedState;
    }

    public void postNewArticle(String title) {
        stateChange = true;
        currentArticle = title;
        notifyObserver();
    }

}