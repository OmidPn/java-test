package com.h2rd.refactoring.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true) //this annotation will not get undefined values when serializing object
public class UserView
{
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
   private String name;
    @JsonProperty("email")
  private   String email;
    @JsonProperty("roles")
   private List<RoleView> roleViews;

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
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(final Long id)
    {
        this.id = id;
    }
}
