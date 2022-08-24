package com.studentportal.portal.services;

import com.studentportal.portal.models.admins;

import java.util.List;

public interface AdminService {
    admins saveAdmin(admins admin);
    admins getAdmin(String email);
    admins deleteAdmin(String email);
    admins updateAdmins(String email,admins admin);
    List<admins> getAllAdmins();
}
