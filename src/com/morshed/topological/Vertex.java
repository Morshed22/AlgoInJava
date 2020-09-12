package com.morshed.topological;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String data;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(String data) {
        this.data = data;
        this.neighbourList = new ArrayList();
    }

    public String getName() {
        return this.data;
    }

    public void setName(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return this.neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public void addNeighbour(Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    public String toString() {
        return this.data;
    }
}
