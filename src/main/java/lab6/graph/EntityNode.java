package lab6.graph;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityNode {
    private Class<?> entityClass;
    private String entityName;
    private List<EntityAttribute> attributes = new ArrayList<>();

    public EntityNode(Class<?> entityClass){
        this.entityClass = entityClass;
        this.entityName = cutString(entityClass.getName()).toLowerCase();
        for (Field field : entityClass.getDeclaredFields()){
            attributes.add(new EntityAttribute(field.getName(), field.getType().getCanonicalName()));
        }
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<EntityAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<EntityAttribute> attributes) {
        this.attributes = attributes;
    }

    public static String cutString(String name){
        String string = "";
        String str = "";
        int i = name.length()-1;
        while (name.charAt(i) != '.'){
            string += name.charAt(i);
            i--;
        }

        for (i = string.length()-1; i >= 0; i--){
            str += string.charAt(i);
        }

        return str;
    }

    public String arrayToString(){
        String string = "";
        for (EntityAttribute attribute : attributes){
            string += "     <attributeName>"+attribute.getAttributeName() + "<attributeName>\n"+
                    "       <attributeType>" + attribute.getAttributeType() +"</attributeType>\n";
        }
        return string;
    }

    @Override
    public String toString() {
        return "<EntityNode>\n" +
                "<entityClass>" + entityClass.getSimpleName() +"</entityClass>" +
                "\n<entityName>" + entityName + "</entityName>\n" +
                "<attributes>\n" + arrayToString() + "</attributes>\n" +
                "       </EntityNode>";
    }
}
