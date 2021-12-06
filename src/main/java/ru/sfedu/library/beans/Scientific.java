package ru.sfedu.library.beans;

import org.simpleframework.xml.Attribute;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.util.Objects;

public class Scientific extends Book {

    @Attribute
    private String direction;

    public Scientific(Long id, String title, String author, Integer numberOfPages, Integer ageRestriction, String direction) {
        super(id, title, author, numberOfPages, ageRestriction,  TypeOfBook.SCIENTIFIC);
        this.direction = direction;
    }

    public Scientific () { };

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Scientific that = (Scientific) o;
        return Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), direction);
    }

    @Override
    public String toString() {
        return "Scientific{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", ageRestriction=" + ageRestriction +
                ", typeOfBook=" + typeOfBook +
                ", direction='" + direction + '\'' +
                '}';
    }
}
