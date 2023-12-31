package io.techswahili.biometric.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class User {
    @Unsigned
    private Long id;
    @NotEmpty(message = "First name cannot be empty")   // Validation
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")    // Validation
    private String lastName;
    @NotEmpty(message = "Email name cannot be empty")   // Validation
    @Email(message = "Invalid email!. Please enter a valid email")  // Validation
    private String email;
    @NotEmpty(message = "Password name cannot be empty")    // Validation
    private String password;
    private String phone;
    private String title;
    private String bio;
    private String imageUrl;
    private boolean enabled;
    private boolean isNotLocked;
    private boolean usingMfa;
    private LocalDateTime createdAt;
}

