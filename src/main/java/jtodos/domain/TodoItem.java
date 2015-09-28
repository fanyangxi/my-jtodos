package jtodos.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by yxfan on 9/28/15.
 */

@Entity
@Table(name = "todoitems")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long userid;

    private String name;

    private String content;

    public TodoItem() {
    }

    public TodoItem(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
