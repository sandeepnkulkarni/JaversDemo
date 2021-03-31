package local.snk;

import org.javers.core.metamodel.annotation.Id;

public class Person {
    @Id
    private int id;
    private String login;
    private String name;
    private Position position;

    Person() {
    }

    public Person(int id, String login, String name) {
        this.id = id;
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}