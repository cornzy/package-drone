package de.dentrassi.pm.storage.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-11T12:54:39.083+0100")
@StaticMetamodel(ChannelCacheEntity.class)
public class ChannelCacheEntity_ {
	public static volatile SingularAttribute<ChannelCacheEntity, String> namespace;
	public static volatile SingularAttribute<ChannelCacheEntity, String> key;
	public static volatile SingularAttribute<ChannelCacheEntity, ChannelEntity> channel;
	public static volatile SingularAttribute<ChannelCacheEntity, byte[]> data;
	public static volatile SingularAttribute<ChannelCacheEntity, Long> size;
	public static volatile SingularAttribute<ChannelCacheEntity, String> name;
	public static volatile SingularAttribute<ChannelCacheEntity, String> mimeType;
}
