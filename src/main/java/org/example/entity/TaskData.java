package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default:
                return new HashSet<>();
        }
    }

    // Varargs (...) sayesinde test sınıfları hem getUnion(set1, set2) hem getUnion(set1, set2, set3) çağırabilir
    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> total = new HashSet<>();
        for (Set<Task> taskSet : sets) {
            if (taskSet != null) {
                total.addAll(taskSet);
            }
        }
        return total;
    }

    // Test sınıfının çağırdığı isim: getIntersection
    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    // Test sınıfının çağırdığı isim: getDifferences
    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }
}