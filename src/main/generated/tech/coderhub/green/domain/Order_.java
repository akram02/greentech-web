package tech.coderhub.green.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Long> sellerId;
	public static volatile SingularAttribute<Order, Long> productId;
	public static volatile SingularAttribute<Order, Long> consumerId;
	public static volatile SingularAttribute<Order, String> description;
	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, String> status;

	public static final String SELLER_ID = "sellerId";
	public static final String PRODUCT_ID = "productId";
	public static final String CONSUMER_ID = "consumerId";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

