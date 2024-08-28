package com.epam.user.management.application.dto;


import com.epam.user.management.application.constants.Role;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "Id cannot be null")
    private int id;


    @NotBlank
    @Size(min = 5, max = 20 , message = "can contain 5 - 20 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "must contains only alphabets")
    private String first_name;

    @NotBlank
    @Size(min = 5, max = 20 , message = "can contain 5 - 20 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "must contains only alphabets")
    private String last_name;

    @NotNull(message = "Age is mandatory")
    @Positive(message = "Age cannot be negative")
    private int age;

    @NotBlank
    private String gender;

    @Pattern(regexp = "^\\+?[\\d\\s\\-()]{7,15}$", message = "Invalid phone number format")
    private String phone_number;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n",message = "Invalid email format")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n",message = "Password not valid")
    private String password;

    @NotNull
    private Role role;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotNull(message = "Id cannot be null")
    public int getId() {
        return id;
    }

    public void setId(@NotNull(message = "Id cannot be null") int id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 5, max = 20, message = "can contain 5 - 20 characters") @Pattern(regexp = "[a-zA-Z]+", message = "must contains only alphabets") String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(@NotBlank @Size(min = 5, max = 20, message = "can contain 5 - 20 characters") @Pattern(regexp = "[a-zA-Z]+", message = "must contains only alphabets") String first_name) {
        this.first_name = first_name;
    }

    public @NotBlank @Size(min = 5, max = 20, message = "can contain 5 - 20 characters") @Pattern(regexp = "[a-zA-Z]+", message = "must contains only alphabets") String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NotBlank @Size(min = 5, max = 20, message = "can contain 5 - 20 characters") @Pattern(regexp = "[a-zA-Z]+", message = "must contains only alphabets") String last_name) {
        this.last_name = last_name;
    }

    @NotNull(message = "Age is mandatory")
    @Positive(message = "Age cannot be negative")
    public int getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "Age is mandatory") @Positive(message = "Age cannot be negative") int age) {
        this.age = age;
    }

    public @NotBlank String getGender() {
        return gender;
    }

    public void setGender(@NotBlank String gender) {
        this.gender = gender;
    }

    public @Pattern(regexp = "^\\+?[\\d\\s\\-()]{7,15}$", message = "Invalid phone number format") String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@Pattern(regexp = "^\\+?[\\d\\s\\-()]{7,15}$", message = "Invalid phone number format") String phone_number) {
        this.phone_number = phone_number;
    }

    public @NotBlank @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n", message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n", message = "Invalid email format") String email) {
        this.email = email;
    }

    public @NotBlank @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n", message = "Password not valid") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n", message = "Password not valid") String password) {
        this.password = password;
    }

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
