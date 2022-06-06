package team15.airbnb.category.infrastructure;

import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.spatial.dialect.mysql.MySQL8SpatialDialect;
import org.hibernate.type.StandardBasicTypes;

public class AirbnbMySqlDialect extends MySQL8SpatialDialect {

    public AirbnbMySqlDialect() {
        registerFunction("st_distance_sphere", new StandardSQLFunction("st_distance_sphere", StandardBasicTypes.DOUBLE));
    }
}
