package com.h2rd.refactoring.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleView
{
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Long id;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(final Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return  name;
    }
    
    public void setName(final String name)
    {
        this.name = name;
    }
}
