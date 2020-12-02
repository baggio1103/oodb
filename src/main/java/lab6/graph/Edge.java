package lab6.graph;

public class Edge {
    private EntityNode nodeSource;
    private EntityNode nodeTarget;
    private RelationType relationType;

    public Edge(EntityNode nodeSource, EntityNode nodeTarget, RelationType relationType){
        this.nodeSource = nodeSource;
        this.nodeTarget = nodeTarget;
        this.relationType = relationType;
    }

    public EntityNode getNodeSource() {
        return nodeSource;
    }

    public void setNodeSource(EntityNode nodeSource) {
        this.nodeSource = nodeSource;
    }

    public EntityNode getNodeTarget() {
        return nodeTarget;
    }

    public void setNodeTarget(EntityNode nodeTarget) {
        this.nodeTarget = nodeTarget;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    @Override
    public String toString() {
        return "<Edge>\n" +
                "\t<nodeSource>" + nodeSource.getEntityName()+"</nodeSource>\n"+
                "\t<nodeTarget>" + nodeTarget.getEntityName() + "</nodeTarget>\n"+
                "\t<relationType>" + relationType +"</relationType>\n"+
                "</Edge>"+"\n";
    }
}
