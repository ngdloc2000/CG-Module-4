package com.example.quanlynghesi.service.role;

import com.example.quanlynghesi.model.Role;
import com.example.quanlynghesi.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
