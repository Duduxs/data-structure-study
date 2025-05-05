package org.edudev.lists.linkeds.tasks;

import static org.edudev.lists.linkeds.tasks.TaskStatus.COMPLETED;

public class Main {

    public static void main(String[] args) {
        var task1 = new Task(1, "Daily with a team", "meeting");
        var task2 = new Task(2, "Implementing some feature", "job", COMPLETED);
        var task3 = new Task(3, "Reading a book", "study", COMPLETED);
        var task4 = new Task(4, "Review a documentation", "job");
        var task5 = new Task(5, "Review a project", "meeting");
        var task6 = new Task(6, "Deploy a project", "job");
        var task7 = new Task(7, "Reading article", "study");

        var taskList1 = new TaskList();
        taskList1.add(task1);
        taskList1.add(task2, 0);
        taskList1.add(task3);
        taskList1.add(task4);
        taskList1.add(task5);
        taskList1.add(task6);
        taskList1.add(task7);
        taskList1.show();

        System.out.println("------------------------------------------------------_");
        taskList1.getTasksByTag("meeting").forEach(System.out::println);
        System.out.println("------------------------------------------------------_");
        taskList1.getTasksByTag("study").forEach(System.out::println);
        System.out.println("------------------------------------------------------_");
        taskList1.getTasksByTag("jobs").forEach(System.out::println);
        System.out.println("------------------------------------------------------_");

        System.out.println(STR."Buscando tarefa com id 7: \{taskList1.getTaskById(7)}");
        System.out.println(STR."Buscando tarefa com id 8: \{taskList1.getTaskById(8)}");
        System.out.println("------------------------------------------------------_");
        System.out.println("Removendo elementos...");
        taskList1.remove(8);
        taskList1.show();
        System.out.println("------------------------------------------------------_");
        taskList1.remove(6);
        taskList1.show();
        System.out.println("------------------------------------------------------_");
        System.out.println("Marcando algumas tasks como concluídas...");
        System.out.println(STR."Concluído task 7: \{taskList1.setTaskToCompleted(7)}");
        System.out.println(STR."Concluído task inexistente 8: \{taskList1.setTaskToCompleted(8)}");
        taskList1.show();
        System.out.println("------------------------------------------------------_");
        var taskUpdate = new Task(null, "Reading working article", "job");
        System.out.println(STR."Atualizando a task 7: \{taskList1.setTaskDataById(7, taskUpdate)}");
        System.out.println(STR."Atualizando a task inexistente 8: \{taskList1.setTaskDataById(8, taskUpdate)}");
        taskList1.show();
        System.out.println("------------------------------------------------------_");
        System.out.println("Começando a movimentar as tasks");
        taskList1.show();
        System.out.println("Movendo task 7 para o índice 1");
        taskList1.move(7, 1);
        taskList1.show();
    }
}