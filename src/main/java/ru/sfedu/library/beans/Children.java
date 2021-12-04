package ru.sfedu.library.beans;

import org.simpleframework.xml.Attribute;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.util.Objects;

public class Children extends ArtBook{

    @Attribute
    private Boolean isEducational;

    public Children(Long id, String title, String author, Integer numberOfPages, Integer ageRestriction, String genre, Boolean isComics, Boolean isEducational) {
        super(id, title, author, numberOfPages, ageRestriction,  TypeOfBook.CHILDREN, genre, isComics);
        this.isEducational = isEducational;
    }

    public Children () { };

    public Boolean getEducational() { return isEducational; }

    public void setEducational(Boolean educational) { isEducational = educational; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Children children = (Children) o;
        return Objects.equals(isEducational, children.isEducational);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isEducational);
    }

    @Override
    public String toString() {
        return "Children{" +
                " id=" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", ageRestriction=" + ageRestriction +
                ", typeOfBook=" + typeOfBook +
                ", isEducational=" + isEducational +
                ", genre='" + genre +
                ", isComics=" + isComics +
                '}';
    }
}
