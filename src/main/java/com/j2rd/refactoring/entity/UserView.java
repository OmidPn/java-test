package com.j2rd.refactoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserView
{
    @JsonProperty("name")
    String name;
    @JsonProperty("email")
    String email;
    @JsonProperty("roles")
    List<RoleView> roleViews;

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
    public List<RoleView> getRoles() {
        return roleViews;
    }
    public void setRoles(List<RoleView> roleViews) {
        this.roleViews = roleViews;
    }
}
