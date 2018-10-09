package com.j2rd.refactoring.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserView", schema = "JAVATEST")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "email", nullable = false,unique = true)
    String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "JAVATEST.Roles",
            joinColumns = @JoinColumn(
                    name = "userId", referencedColumnName = "userId", nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "roleId", nullable = false))
    private List<Role> roles;
    //getter and setter
    public Long getId()
    {
        return id;
    }
    
    public void setId(final Long id)
    {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
