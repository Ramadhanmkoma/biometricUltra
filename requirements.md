# Bams Application Requirements

## Application User

### 1. User new account (unique email address)

- [ ] Account Verification (Verify Email address)
- [ ] User profile
- [ ] User details (name, email, position, bio, **phone**, address, etc)
- [ ] Being able to update user detail information

### 2. User reset password (without being logged in)

- [ ] Password reset link should expire within 24 hours

### 3. User Login (using email and password)

- [ ] Token based authentication (JWT Token)
- [ ] Refresh Token seamlessly

### 4. Brute force attack mitigation (account lock mechanism)

- [ ] Lock account on 6 failed login attemps

### 5. Role and Permission based application access(ACL)

- [ ] Protect application resources using roles and permissions

### 6. Two-factor authentication (using user phone number)

- [ ] Send verification code to user's phone

### 7. Keep track of user activities (login, account change, etc)

- [ ] Ability to report suspicious activities
- [ ] Tracking information
    - [ ] IP Address
    - [ ] Device
    - [ ] Browser
    - [ ] Date
    - [ ] Type

## Human Resource Manager

### 1. HR Information

- [ ] Manage customer information(name, address, etc)
- [ ] HR should have a status
- [ ] HR will have an invoice
- [ ] Print lecturers spreadsheet

### 2. Search Lecturers

- [ ] Be able to search lecturer by name
- [ ] Pagination