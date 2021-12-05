package ru.sfedu.library.beans;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "xml")
public class Wrapper<T> {

    @ElementList(name ="conteiner")
    private List<T> conteiner;

    public Wrapper(List<T> conteiner) {
        this.conteiner = conteiner;
    }
    public Wrapper() { }

    public List<T> getList() {
        return conteiner;
    }

    public void setList(List<T> conteiner) {
        this.conteiner = conteiner;
    }
}



//@Root(name = "list")
//public class Wrapper<T> {
//    @ElementList(inline = true, required = false)
//    private List<T> list;
//
//    public Wrapper() {
//    }
//
//    public Wrapper(List<T> list) {
//        this.list = list;
//    }
//
//    public List<T> getList() {
//        return list;
//    }
//
//    public void setList(List<T> list) {
//        this.list = list;
//    }
//}
