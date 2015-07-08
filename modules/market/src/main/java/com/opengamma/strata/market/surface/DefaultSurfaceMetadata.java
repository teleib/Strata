/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.market.surface;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableConstructor;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.basics.date.DayCount;
import com.opengamma.strata.market.value.ValueType;

/**
 * Default metadata for a surface.
 * <p>
 * This implementation of {@link SurfaceMetadata} provides the surface name and nodes.
 */
@BeanDefinition
public final class DefaultSurfaceMetadata
    implements SurfaceMetadata, ImmutableBean, Serializable {

  /**
   * The surface name.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final SurfaceName surfaceName;
  /**
   * The x-value type, providing meaning to the x-values of the curve.
   * <p>
   * This type provides meaning to the x-values. For example, the x-value might
   * represent a year fraction, as represented using {@link ValueType#YEAR_FRACTION}.
   * <p>
   * If using the builder, this defaults to {@link ValueType#UNKNOWN}.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ValueType xValueType;
  /**
   * The y-value type, providing meaning to the y-values of the curve.
   * <p>
   * This type provides meaning to the y-values.
   * <p>
   * If using the builder, this defaults to {@link ValueType#UNKNOWN}.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ValueType yValueType;
  /**
   * The x-value type, providing meaning to the z-values of the curve.
   * <p>
   * This type provides meaning to the z-values.
   * <p>
   * If using the builder, this defaults to {@link ValueType#UNKNOWN}.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ValueType zValueType;
  /**
   * The day count, optional.
   * <p>
   * If the x-value of the surface represents time as a year fraction, the day count
   * can be specified to define how the year fraction is calculated.
   */
  @PropertyDefinition(get = "optional", overrideGet = true)
  private final DayCount dayCount;
  /**
   * The metadata about the parameters.
   * <p>
   * If present, the parameter metadata should match the number of parameters on the surface.
   */
  @PropertyDefinition(get = "optional", overrideGet = true, type = "List<>")
  private final ImmutableList<SurfaceParameterMetadata> parameterMetadata;

  //-------------------------------------------------------------------------
  /**
   * Creates the metadata.
   * <p>
   * No information will be available for the x-values, y-values, z-values or parameters.
   * 
   * @param name  the surface name
   * @return the metadata
   */
  public static DefaultSurfaceMetadata of(String name) {
    return of(SurfaceName.of(name));
  }

  /**
   * Creates the metadata.
   * <p>
   * No information will be available for the x-values, y-values, z-values or parameters.
   * 
   * @param name  the surface name
   * @return the metadata
   */
  public static DefaultSurfaceMetadata of(SurfaceName name) {
    return new DefaultSurfaceMetadata(name, ValueType.UNKNOWN, ValueType.UNKNOWN, ValueType.UNKNOWN, null, null);
  }

  //-------------------------------------------------------------------------
  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.xValueType = ValueType.UNKNOWN;
    builder.yValueType = ValueType.UNKNOWN;
    builder.zValueType = ValueType.UNKNOWN;
  }

  @ImmutableConstructor
  private DefaultSurfaceMetadata(
      SurfaceName name,
      ValueType xValueType,
      ValueType yValueType,
      ValueType zValueType,
      DayCount dayCount,
      List<? extends SurfaceParameterMetadata> parameterMetadata) {
    JodaBeanUtils.notNull(name, "curveName");
    JodaBeanUtils.notNull(xValueType, "xValueType");
    JodaBeanUtils.notNull(yValueType, "yValueType");
    JodaBeanUtils.notNull(zValueType, "zValueType");
    this.surfaceName = name;
    this.xValueType = xValueType;
    this.yValueType = yValueType;
    this.zValueType = zValueType;
    this.dayCount = dayCount;
    this.parameterMetadata = (parameterMetadata != null ? ImmutableList.copyOf(parameterMetadata) : null);
  }

  //-------------------------------------------------------------------------
  @Override
  public DefaultSurfaceMetadata withParameterMetadata(List<SurfaceParameterMetadata> parameterMetadata) {
    return toBuilder().parameterMetadata(parameterMetadata).build();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code DefaultSurfaceMetadata}.
   * @return the meta-bean, not null
   */
  public static DefaultSurfaceMetadata.Meta meta() {
    return DefaultSurfaceMetadata.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(DefaultSurfaceMetadata.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static DefaultSurfaceMetadata.Builder builder() {
    return new DefaultSurfaceMetadata.Builder();
  }

  @Override
  public DefaultSurfaceMetadata.Meta metaBean() {
    return DefaultSurfaceMetadata.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the surface name.
   * @return the value of the property, not null
   */
  @Override
  public SurfaceName getSurfaceName() {
    return surfaceName;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the x-value type, providing meaning to the x-values of the curve.
   * <p>
   * This type provides meaning to the x-values. For example, the x-value might
   * represent a year fraction, as represented using {@link ValueType#YEAR_FRACTION}.
   * <p>
   * If using the builder, this defaults to {@link ValueType#UNKNOWN}.
   * @return the value of the property, not null
   */
  @Override
  public ValueType getXValueType() {
    return xValueType;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the y-value type, providing meaning to the y-values of the curve.
   * <p>
   * This type provides meaning to the y-values.
   * <p>
   * If using the builder, this defaults to {@link ValueType#UNKNOWN}.
   * @return the value of the property, not null
   */
  @Override
  public ValueType getYValueType() {
    return yValueType;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the x-value type, providing meaning to the z-values of the curve.
   * <p>
   * This type provides meaning to the z-values.
   * <p>
   * If using the builder, this defaults to {@link ValueType#UNKNOWN}.
   * @return the value of the property, not null
   */
  @Override
  public ValueType getZValueType() {
    return zValueType;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the day count, optional.
   * <p>
   * If the x-value of the surface represents time as a year fraction, the day count
   * can be specified to define how the year fraction is calculated.
   * @return the optional value of the property, not null
   */
  @Override
  public Optional<DayCount> getDayCount() {
    return Optional.ofNullable(dayCount);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the metadata about the parameters.
   * <p>
   * If present, the parameter metadata should match the number of parameters on the surface.
   * @return the optional value of the property, not null
   */
  @Override
  public Optional<List<SurfaceParameterMetadata>> getParameterMetadata() {
    return Optional.ofNullable(parameterMetadata);
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      DefaultSurfaceMetadata other = (DefaultSurfaceMetadata) obj;
      return JodaBeanUtils.equal(getSurfaceName(), other.getSurfaceName()) &&
          JodaBeanUtils.equal(getXValueType(), other.getXValueType()) &&
          JodaBeanUtils.equal(getYValueType(), other.getYValueType()) &&
          JodaBeanUtils.equal(getZValueType(), other.getZValueType()) &&
          JodaBeanUtils.equal(dayCount, other.dayCount) &&
          JodaBeanUtils.equal(parameterMetadata, other.parameterMetadata);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getSurfaceName());
    hash = hash * 31 + JodaBeanUtils.hashCode(getXValueType());
    hash = hash * 31 + JodaBeanUtils.hashCode(getYValueType());
    hash = hash * 31 + JodaBeanUtils.hashCode(getZValueType());
    hash = hash * 31 + JodaBeanUtils.hashCode(dayCount);
    hash = hash * 31 + JodaBeanUtils.hashCode(parameterMetadata);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(224);
    buf.append("DefaultSurfaceMetadata{");
    buf.append("surfaceName").append('=').append(getSurfaceName()).append(',').append(' ');
    buf.append("xValueType").append('=').append(getXValueType()).append(',').append(' ');
    buf.append("yValueType").append('=').append(getYValueType()).append(',').append(' ');
    buf.append("zValueType").append('=').append(getZValueType()).append(',').append(' ');
    buf.append("dayCount").append('=').append(dayCount).append(',').append(' ');
    buf.append("parameterMetadata").append('=').append(JodaBeanUtils.toString(parameterMetadata));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code DefaultSurfaceMetadata}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code surfaceName} property.
     */
    private final MetaProperty<SurfaceName> surfaceName = DirectMetaProperty.ofImmutable(
        this, "surfaceName", DefaultSurfaceMetadata.class, SurfaceName.class);
    /**
     * The meta-property for the {@code xValueType} property.
     */
    private final MetaProperty<ValueType> xValueType = DirectMetaProperty.ofImmutable(
        this, "xValueType", DefaultSurfaceMetadata.class, ValueType.class);
    /**
     * The meta-property for the {@code yValueType} property.
     */
    private final MetaProperty<ValueType> yValueType = DirectMetaProperty.ofImmutable(
        this, "yValueType", DefaultSurfaceMetadata.class, ValueType.class);
    /**
     * The meta-property for the {@code zValueType} property.
     */
    private final MetaProperty<ValueType> zValueType = DirectMetaProperty.ofImmutable(
        this, "zValueType", DefaultSurfaceMetadata.class, ValueType.class);
    /**
     * The meta-property for the {@code dayCount} property.
     */
    private final MetaProperty<DayCount> dayCount = DirectMetaProperty.ofImmutable(
        this, "dayCount", DefaultSurfaceMetadata.class, DayCount.class);
    /**
     * The meta-property for the {@code parameterMetadata} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<SurfaceParameterMetadata>> parameterMetadata = DirectMetaProperty.ofImmutable(
        this, "parameterMetadata", DefaultSurfaceMetadata.class, (Class) List.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "surfaceName",
        "xValueType",
        "yValueType",
        "zValueType",
        "dayCount",
        "parameterMetadata");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1403077416:  // surfaceName
          return surfaceName;
        case -868509005:  // xValueType
          return xValueType;
        case -1065022510:  // yValueType
          return yValueType;
        case -1261536015:  // zValueType
          return zValueType;
        case 1905311443:  // dayCount
          return dayCount;
        case -1169106440:  // parameterMetadata
          return parameterMetadata;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public DefaultSurfaceMetadata.Builder builder() {
      return new DefaultSurfaceMetadata.Builder();
    }

    @Override
    public Class<? extends DefaultSurfaceMetadata> beanType() {
      return DefaultSurfaceMetadata.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code surfaceName} property.
     * @return the meta-property, not null
     */
    public MetaProperty<SurfaceName> surfaceName() {
      return surfaceName;
    }

    /**
     * The meta-property for the {@code xValueType} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ValueType> xValueType() {
      return xValueType;
    }

    /**
     * The meta-property for the {@code yValueType} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ValueType> yValueType() {
      return yValueType;
    }

    /**
     * The meta-property for the {@code zValueType} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ValueType> zValueType() {
      return zValueType;
    }

    /**
     * The meta-property for the {@code dayCount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<DayCount> dayCount() {
      return dayCount;
    }

    /**
     * The meta-property for the {@code parameterMetadata} property.
     * @return the meta-property, not null
     */
    public MetaProperty<List<SurfaceParameterMetadata>> parameterMetadata() {
      return parameterMetadata;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1403077416:  // surfaceName
          return ((DefaultSurfaceMetadata) bean).getSurfaceName();
        case -868509005:  // xValueType
          return ((DefaultSurfaceMetadata) bean).getXValueType();
        case -1065022510:  // yValueType
          return ((DefaultSurfaceMetadata) bean).getYValueType();
        case -1261536015:  // zValueType
          return ((DefaultSurfaceMetadata) bean).getZValueType();
        case 1905311443:  // dayCount
          return ((DefaultSurfaceMetadata) bean).dayCount;
        case -1169106440:  // parameterMetadata
          return ((DefaultSurfaceMetadata) bean).parameterMetadata;
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code DefaultSurfaceMetadata}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<DefaultSurfaceMetadata> {

    private SurfaceName surfaceName;
    private ValueType xValueType;
    private ValueType yValueType;
    private ValueType zValueType;
    private DayCount dayCount;
    private List<SurfaceParameterMetadata> parameterMetadata;

    /**
     * Restricted constructor.
     */
    private Builder() {
      applyDefaults(this);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(DefaultSurfaceMetadata beanToCopy) {
      this.surfaceName = beanToCopy.getSurfaceName();
      this.xValueType = beanToCopy.getXValueType();
      this.yValueType = beanToCopy.getYValueType();
      this.zValueType = beanToCopy.getZValueType();
      this.dayCount = beanToCopy.dayCount;
      this.parameterMetadata = beanToCopy.parameterMetadata;
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1403077416:  // surfaceName
          return surfaceName;
        case -868509005:  // xValueType
          return xValueType;
        case -1065022510:  // yValueType
          return yValueType;
        case -1261536015:  // zValueType
          return zValueType;
        case 1905311443:  // dayCount
          return dayCount;
        case -1169106440:  // parameterMetadata
          return parameterMetadata;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -1403077416:  // surfaceName
          this.surfaceName = (SurfaceName) newValue;
          break;
        case -868509005:  // xValueType
          this.xValueType = (ValueType) newValue;
          break;
        case -1065022510:  // yValueType
          this.yValueType = (ValueType) newValue;
          break;
        case -1261536015:  // zValueType
          this.zValueType = (ValueType) newValue;
          break;
        case 1905311443:  // dayCount
          this.dayCount = (DayCount) newValue;
          break;
        case -1169106440:  // parameterMetadata
          this.parameterMetadata = (List<SurfaceParameterMetadata>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public DefaultSurfaceMetadata build() {
      return new DefaultSurfaceMetadata(
          surfaceName,
          xValueType,
          yValueType,
          zValueType,
          dayCount,
          parameterMetadata);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code surfaceName} property in the builder.
     * @param surfaceName  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder surfaceName(SurfaceName surfaceName) {
      JodaBeanUtils.notNull(surfaceName, "surfaceName");
      this.surfaceName = surfaceName;
      return this;
    }

    /**
     * Sets the {@code xValueType} property in the builder.
     * @param xValueType  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder xValueType(ValueType xValueType) {
      JodaBeanUtils.notNull(xValueType, "xValueType");
      this.xValueType = xValueType;
      return this;
    }

    /**
     * Sets the {@code yValueType} property in the builder.
     * @param yValueType  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder yValueType(ValueType yValueType) {
      JodaBeanUtils.notNull(yValueType, "yValueType");
      this.yValueType = yValueType;
      return this;
    }

    /**
     * Sets the {@code zValueType} property in the builder.
     * @param zValueType  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder zValueType(ValueType zValueType) {
      JodaBeanUtils.notNull(zValueType, "zValueType");
      this.zValueType = zValueType;
      return this;
    }

    /**
     * Sets the {@code dayCount} property in the builder.
     * @param dayCount  the new value
     * @return this, for chaining, not null
     */
    public Builder dayCount(DayCount dayCount) {
      this.dayCount = dayCount;
      return this;
    }

    /**
     * Sets the {@code parameterMetadata} property in the builder.
     * @param parameterMetadata  the new value
     * @return this, for chaining, not null
     */
    public Builder parameterMetadata(List<SurfaceParameterMetadata> parameterMetadata) {
      this.parameterMetadata = parameterMetadata;
      return this;
    }

    /**
     * Sets the {@code parameterMetadata} property in the builder
     * from an array of objects.
     * @param parameterMetadata  the new value
     * @return this, for chaining, not null
     */
    public Builder parameterMetadata(SurfaceParameterMetadata... parameterMetadata) {
      return parameterMetadata(ImmutableList.copyOf(parameterMetadata));
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(224);
      buf.append("DefaultSurfaceMetadata.Builder{");
      buf.append("surfaceName").append('=').append(JodaBeanUtils.toString(surfaceName)).append(',').append(' ');
      buf.append("xValueType").append('=').append(JodaBeanUtils.toString(xValueType)).append(',').append(' ');
      buf.append("yValueType").append('=').append(JodaBeanUtils.toString(yValueType)).append(',').append(' ');
      buf.append("zValueType").append('=').append(JodaBeanUtils.toString(zValueType)).append(',').append(' ');
      buf.append("dayCount").append('=').append(JodaBeanUtils.toString(dayCount)).append(',').append(' ');
      buf.append("parameterMetadata").append('=').append(JodaBeanUtils.toString(parameterMetadata));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
