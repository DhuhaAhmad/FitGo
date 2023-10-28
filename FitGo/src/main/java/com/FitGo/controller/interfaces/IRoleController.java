package com.FitGo.controller.interfaces;

import com.FitGo.controller.DTO.RoleToUserDTO;
import com.FitGo.model.Role;

public interface IRoleController {

    /**
     * Save a new role
     *
     * @param role the role to be saved
     */
    void saveRole(Role role);

    /**
     * Add a role to a user
     *
     * @param roleToUserDTO object containing the username and role name to be added to the user
     */
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
