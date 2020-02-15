package tech.coderhub.green.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, String> location;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, String> category;
	public static volatile SingularAttribute<Product, Long> userId;

	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String USER_ID = "userId";

}

