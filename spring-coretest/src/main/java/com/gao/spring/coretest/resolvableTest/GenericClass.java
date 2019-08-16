package com.gao.spring.coretest.resolvableTest;

/**
 * 名称: GenericClass.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2018/12/13 9:12 PM
 */
import java.util.List;
import java.util.Map;

public class GenericClass {

    private List<String> listString;
    private List<List<String>> listLists;
    private Map<String, Long> maps;
    private Person<String> persons;

    public GenericClass() {
    }

    public List<String> getListString() {
        return listString;
    }

    public void setListString(List<String> listString) {
        this.listString = listString;
    }

    public Map<String, Long> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Long> maps) {
        this.maps = maps;
    }

    public Person<String> getPersons() {
        return persons;
    }

    public void setPersons(Person<String> persons) {
        this.persons = persons;
    }

    public List<List<String>> getListLists() {
        return listLists;
    }

    public void setListLists(List<List<String>> listLists) {
        this.listLists = listLists;
    }
}
