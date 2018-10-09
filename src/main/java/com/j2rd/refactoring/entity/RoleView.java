package com.j2rd.refactoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleView
{
    @JsonProperty("role")
    private String role;
    
    public String getRole()
    {
        return role;
    }
    
    public void setRole(final String role)
    {
        this.role = role;
    }
}
