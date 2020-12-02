package lab6.graph;

import lab6.PathScan;
import lab6.annotation.Entity;
import lab6.hotel.Hotel;
import lab6.hotel.Person;
import lab6.hotel.Room;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class App {

    static List<Class<?>> classes = PathScan.find("lab6.hotel");

    public static void main(String[] args) {

        GraphModel graphModel = new GraphModel();

//Forming nodes

        for (Class<?> cs : classes) {
            if (cs.getDeclaredAnnotations().length > 0) {
            EntityNode node = new EntityNode(cs);
            graphModel.getEntityNodeList().add(node);
            }
        }

//Setting edges between nodes

        List<EntityNode> entityNodes = graphModel.getEntityNodeList();
        List<Edge> edges = graphModel.getEdges();
        List<String> types = graphModel.getRelationTypes();

        for (EntityNode entityNode : entityNodes){
            for (Field field : entityNode.getEntityClass().getDeclaredFields()){
                if(field.getType().isAnnotationPresent(Entity.class)){
                    for (Annotation annotation : field.getDeclaredAnnotations()){
                        if (types.contains(annotation.annotationType().getSimpleName())){
                            EntityNode targetNode = getNode(entityNodes, field.getType().getSimpleName());
                            graphModel.addEdge(entityNode, targetNode,  RelationType.valueOf(annotation.annotationType().getSimpleName()));
                        }
                    }
                }
            }
        }

        System.out.println(graphModel);

    }

        public static EntityNode getNode(List<EntityNode> list, String simpleName){
            for (EntityNode node : list){
                if (node.getEntityClass().getSimpleName().equalsIgnoreCase(simpleName)){
                    return node;
                }
            }
            return null;

        }

}
