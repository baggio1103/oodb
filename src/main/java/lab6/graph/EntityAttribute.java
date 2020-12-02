package lab6.graph;

public class EntityAttribute {
    private String attributeName;
    private String attributeType;

    public EntityAttribute(String attributeName, String attributeType){
        this.attributeName = attributeName;
        this.attributeType = attributeType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    @Override
    public String toString() {
        return "<attributeName>"+attributeName + "<attributeName>\n"+
                "<attributeType>" + attributeType +"</attributeType>\n";
    }
}
