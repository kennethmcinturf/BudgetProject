CREATE DATABASE budget_project;
USE budget_project;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username)
);

CREATE TABLE budget(
  budget_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id int unsigned not null,
  budget_name varchar (50),
  primary key (budget_id),
  FOREIGN KEY (user_id) references users(id) ON DELETE CASCADE
);

CREATE TABLE income (
  income_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  income_name varchar (50),
  primary key (income_id),
  unique (income_name)
);

CREATE TABLE expense (
  expense_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  expense_name varchar (50),
  primary key (expense_id),
  unique (expense_name)
);

create table budget_expense(
    budget_id INT UNSIGNED NOT NULL,
    expense_id INT UNSIGNED NOT NULL,
    expense_amount int not null,
    FOREIGN KEY (budget_id) REFERENCES budget(budget_id),
    FOREIGN KEY (expense_id) REFERENCES expense(expense_id)
);

create table budget_income(
    budget_id INT UNSIGNED NOT NULL,
    income_id INT UNSIGNED NOT NULL,
    income_amount int not null,
    income_frequency int null,
    FOREIGN KEY (budget_id) REFERENCES budget(budget_id),
    FOREIGN KEY (income_id) REFERENCES income(income_id)
);