package lab6.graph;

import lab6.annotation.Entity;

import java.util.ArrayList;
import java.util.List;

public class GraphModel {

    private List<EntityNode> entityNodeList = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    private final List<String> relationTypes = new ArrayList<>();

    public GraphModel(){
        relationTypes.add(RelationType.OneToMany.name());
        relationTypes.add(RelationType.ManyToMany.name());
        relationTypes.add(RelationType.ManyToOne.name());
        relationTypes.add(RelationType.OneToOne.name());
    }

    public List<EntityNode> getEntityNodeList() {
        return entityNodeList;
    }

    public void setEntityNodeList(List<EntityNode> entityNodeList) {
        this.entityNodeList = entityNodeList;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    void addEdge(EntityNode nodeSource, EntityNode nodeTarget, RelationType relationType){
        edges.add(new Edge(nodeSource,nodeTarget, relationType));
    }

    public List<String> getRelationTypes() {
        return relationTypes;
    }

    @Override
    public String toString() {
//        return "GraphModel{" +
//                "entityNodeList=" + entityNodeList +
//                ", edges=" + edges +
//                ", relationTypes=" + relationTypes +
//                '}';
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\"  \n" +
                "\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "\txsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns \n" +
                "\thttp://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n" +
                "\t<graph id=\"G\" edgedefault=\"undirected\">\n");
        for (EntityNode entityNode : entityNodeList) {
            builder.append(entityNode.toString()).append("\n");
        }
        for (Edge edge : edges) {
            builder.append(edge.toString());
        }
        builder.append("\t</graph>\n" +
                "</graphml>");
        return builder.toString();

    }
}
