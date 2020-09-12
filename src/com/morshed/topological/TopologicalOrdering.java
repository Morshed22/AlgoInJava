package com.morshed.topological;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalOrdering {
        private Stack<Vertex> stack = new Stack();

        public Stack<Vertex> getStack() {
            return this.stack;
        }

        public TopologicalOrdering() {
        }

        public void dfs(Vertex vertex) {
            vertex.setVisited(true);
            Iterator var2 = vertex.getNeighbourList().iterator();

            while(var2.hasNext()) {
                Vertex v = (Vertex)var2.next();
                if (!v.isVisited()) {
                    this.dfs(v);
                }
            }

            this.stack.push(vertex);
        }
    }

