/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.cleo.todoapp.util.table;

import br.com.cleo.todoapp.model.Task;
import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Enum to filter the tasks.
 * Get predicates to filter the tasks.
 * @author Cleo
 */
public enum FilterTasks {
    ALL((Task e) -> !e.getName().isBlank()),
    COMPLETED((Task e) -> e.isCompleted()),
    NOTCOMPLETED((Task e) -> !e.isCompleted()),
    EXPIRED((Task e) -> !e.isCompleted() && !e.getDeadline().isAfter(LocalDateTime.now()));
    private final Predicate<? super Task> filter;

    private FilterTasks(Predicate<? super Task> filter) {
        this.filter = filter;
    }


    /**
     * @return predicate to filter the tasks
     */
    public Predicate<? super Task> getFilter() {
        return filter;
    }


}
