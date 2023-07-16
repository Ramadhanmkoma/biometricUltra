--######################################################################
--###                                                                ###
--###  Author: Ramadhan Mohammed Mkoma                               ###
--###  License: TechSwahili LLC License (http://ramadhanmkoma.me)    ###
--###  Date: July 14th, 2023                                         ###
--###  version: 1.0                                                  ###
--###                                                                ###
--######################################################################

CREATE SCHEMA IF NOT EXISTS biometric;

SET NAMES 'UTF8';

--SET TIME ZONE 'EAT';

SET search_path TO biometric, public;

DROP TABLE IF EXISTS biometricII.Users;

CREATE TABLE IF NOT EXISTS Users
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    password      VARCHAR(255) DEFAULT NULL,
    address       VARCHAR(255) DEFAULT NULL,
    phone         VARCHAR(50) DEFAULT NULL,
    title         VARCHAR(50) DEFAULT NULL,
    bio           VARCHAR(255) DEFAULT NULL,
    enabled       BOOLEAN DEFAULT FALSE,
    non_locked    BOOLEAN DEFAULT TRUE,
    using_mfa     BOOLEAN DEFAULT FALSE,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    img_url       VARCHAR(255) DEFAULT 'https://cdn-icons-png.flaticon.com/512/149/149071.png',
    CONSTRAINT UQ_Users_Email UNIQUE (email)
);


DROP TABLE IF EXISTS biometricII.Roles;

CREATE TABLE IF NOT EXISTS Roles
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    r_name      VARCHAR(50) NOT NULL,
    permissions VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Roles_Name UNIQUE (r_name)
);


DROP TABLE IF EXISTS biometricII.UserRoles;

CREATE TABLE IF NOT EXISTS UserRoles
(
    id      BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES Roles (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT UQ_UserRoles_User_id UNIQUE (user_id)
);

DROP TABLE IF EXISTS biometricII.Events;

CREATE TABLE IF NOT EXISTS Events
(
    id   BIGSERIAL PRIMARY KEY NOT NULL,
    type VARCHAR(50) NOT NULL CHECK(type IN ('LOGIN_ATTEMP', 'LOGIN_ATTEMP_FAILURE', 'LOGIN_ATTEMP_SUCCESS', 'PROFILE_UPDATE', 'PROFILE_PICTURE_UPDATE', 'ROLE_UPDATE', 'ACCOUNT_SETTINGS_UPDATE', 'PASSWORD_UPDATE', 'MFA_UPDATE')),
    description VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Events_Type UNIQUE (type)
);

DROP TABLE IF EXISTS biometricII.UserEvents;

CREATE TABLE IF NOT EXISTS UserEvents
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    event_id    BIGINT NOT NULL,
    device      VARCHAR(100) DEFAULT NULL,
    ip_address  VARCHAR(100) DEFAULT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (event_id) REFERENCES Events (id) ON DELETE RESTRICT ON UPDATE CASCADE
);


DROP TABLE IF EXISTS biometricII.AccountVerifications;

CREATE TABLE IF NOT EXISTS AccountVerifications
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    url         VARCHAR(255) NOT NULL,
--    u_date      TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_AccountVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_AccountVerifications_Url UNIQUE (url)
);

--DROP TABLE IF EXISTS AccountVerifications;

CREATE TABLE IF NOT EXISTS ResetPasswordVerifications
(
    id                  BIGSERIAL NOT NULL PRIMARY KEY,
    user_id             BIGINT NOT NULL,
    url                 VARCHAR(255) NOT NULL,
    expiration_date     TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_ResetPasswordVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_ResetPasswordVerifications_Url UNIQUE (url)
);


--DROP TABLE IF EXISTS TwoFactorAuthentications;

CREATE TABLE IF NOT EXISTS TwoFactorAuthentications
(
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    code            VARCHAR(10) NOT NULL,
    expiration_date TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_TwoFactorAuthentications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_TwoFactorAuthentications_Code UNIQUE (code)
);






