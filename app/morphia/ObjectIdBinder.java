package morphia;

import org.bson.types.ObjectId;
import play.data.binding.Global;
import play.data.binding.TypeBinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Global
public class ObjectIdBinder implements TypeBinder<ObjectId> {

    @SuppressWarnings("rawtypes")
	@Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType) {
        return new ObjectId(value);
    }
    
}
