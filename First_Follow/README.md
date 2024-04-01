## Computing First and Follow sets for LL1 parser

This project implements algorithms to calculate first sets and follow sets for a given context-free grammar (CFG). These sets are fundamental concepts used in parser generation for LL(1) parsing.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources

- `First_follow.java`: The main class containing the entry point for the program.
- `First.java`: This class defines functions for calculating the first sets of non-terminals and terminals in the grammar.
- `Follow.java`: This class implements functions for computing the follow sets of non-terminals in the grammar.

- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Usage:

- Clone this repository.
- Modify the grammar rules within the First_follow class (refer to the example provided).
- Run the First_follow class to calculate and print the first and follow sets for each non-terminal.

## Input Foramt:
- This program takes the following as input

- Number of Non Terminals.
- Grammar -> For each Non Terminal enter the number of productions first and then productions.
- Epsilon is considered as "#".
## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
