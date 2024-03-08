package bookstore.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;
    private String name;

    public Category() {
    }

    public Category(String name) {
        
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public String getName() {
        return name;
    }
}

