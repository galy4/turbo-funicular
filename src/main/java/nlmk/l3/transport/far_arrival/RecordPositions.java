/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package nlmk.l3.transport.far_arrival;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class RecordPositions extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5085820955883906901L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RecordPositions\",\"namespace\":\"nlmk.l3.transport.far_arrival\",\"fields\":[{\"name\":\"wagonNum\",\"type\":\"int\",\"doc\":\"Номер вагона\"},{\"name\":\"wagonType\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Тип вагона\"},{\"name\":\"weightNet\",\"type\":\"float\",\"doc\":\"Вес груза, т\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<RecordPositions> ENCODER =
      new BinaryMessageEncoder<RecordPositions>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<RecordPositions> DECODER =
      new BinaryMessageDecoder<RecordPositions>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<RecordPositions> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<RecordPositions> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<RecordPositions> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<RecordPositions>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this RecordPositions to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a RecordPositions from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a RecordPositions instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static RecordPositions fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Номер вагона */
  private int wagonNum;
  /** Тип вагона */
  private java.lang.String wagonType;
  /** Вес груза, т */
  private float weightNet;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RecordPositions() {}

  /**
   * All-args constructor.
   * @param wagonNum Номер вагона
   * @param wagonType Тип вагона
   * @param weightNet Вес груза, т
   */
  public RecordPositions(java.lang.Integer wagonNum, java.lang.String wagonType, java.lang.Float weightNet) {
    this.wagonNum = wagonNum;
    this.wagonType = wagonType;
    this.weightNet = weightNet;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return wagonNum;
    case 1: return wagonType;
    case 2: return weightNet;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: wagonNum = (java.lang.Integer)value$; break;
    case 1: wagonType = value$ != null ? value$.toString() : null; break;
    case 2: weightNet = (java.lang.Float)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'wagonNum' field.
   * @return Номер вагона
   */
  public int getWagonNum() {
    return wagonNum;
  }


  /**
   * Sets the value of the 'wagonNum' field.
   * Номер вагона
   * @param value the value to set.
   */
  public void setWagonNum(int value) {
    this.wagonNum = value;
  }

  /**
   * Gets the value of the 'wagonType' field.
   * @return Тип вагона
   */
  public java.lang.String getWagonType() {
    return wagonType;
  }


  /**
   * Sets the value of the 'wagonType' field.
   * Тип вагона
   * @param value the value to set.
   */
  public void setWagonType(java.lang.String value) {
    this.wagonType = value;
  }

  /**
   * Gets the value of the 'weightNet' field.
   * @return Вес груза, т
   */
  public float getWeightNet() {
    return weightNet;
  }


  /**
   * Sets the value of the 'weightNet' field.
   * Вес груза, т
   * @param value the value to set.
   */
  public void setWeightNet(float value) {
    this.weightNet = value;
  }

  /**
   * Creates a new RecordPositions RecordBuilder.
   * @return A new RecordPositions RecordBuilder
   */
  public static nlmk.l3.transport.far_arrival.RecordPositions.Builder newBuilder() {
    return new nlmk.l3.transport.far_arrival.RecordPositions.Builder();
  }

  /**
   * Creates a new RecordPositions RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RecordPositions RecordBuilder
   */
  public static nlmk.l3.transport.far_arrival.RecordPositions.Builder newBuilder(nlmk.l3.transport.far_arrival.RecordPositions.Builder other) {
    if (other == null) {
      return new nlmk.l3.transport.far_arrival.RecordPositions.Builder();
    } else {
      return new nlmk.l3.transport.far_arrival.RecordPositions.Builder(other);
    }
  }

  /**
   * Creates a new RecordPositions RecordBuilder by copying an existing RecordPositions instance.
   * @param other The existing instance to copy.
   * @return A new RecordPositions RecordBuilder
   */
  public static nlmk.l3.transport.far_arrival.RecordPositions.Builder newBuilder(nlmk.l3.transport.far_arrival.RecordPositions other) {
    if (other == null) {
      return new nlmk.l3.transport.far_arrival.RecordPositions.Builder();
    } else {
      return new nlmk.l3.transport.far_arrival.RecordPositions.Builder(other);
    }
  }

  /**
   * RecordBuilder for RecordPositions instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RecordPositions>
    implements org.apache.avro.data.RecordBuilder<RecordPositions> {

    /** Номер вагона */
    private int wagonNum;
    /** Тип вагона */
    private java.lang.String wagonType;
    /** Вес груза, т */
    private float weightNet;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(nlmk.l3.transport.far_arrival.RecordPositions.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.wagonNum)) {
        this.wagonNum = data().deepCopy(fields()[0].schema(), other.wagonNum);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.wagonType)) {
        this.wagonType = data().deepCopy(fields()[1].schema(), other.wagonType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.weightNet)) {
        this.weightNet = data().deepCopy(fields()[2].schema(), other.weightNet);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing RecordPositions instance
     * @param other The existing instance to copy.
     */
    private Builder(nlmk.l3.transport.far_arrival.RecordPositions other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.wagonNum)) {
        this.wagonNum = data().deepCopy(fields()[0].schema(), other.wagonNum);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.wagonType)) {
        this.wagonType = data().deepCopy(fields()[1].schema(), other.wagonType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.weightNet)) {
        this.weightNet = data().deepCopy(fields()[2].schema(), other.weightNet);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'wagonNum' field.
      * Номер вагона
      * @return The value.
      */
    public int getWagonNum() {
      return wagonNum;
    }


    /**
      * Sets the value of the 'wagonNum' field.
      * Номер вагона
      * @param value The value of 'wagonNum'.
      * @return This builder.
      */
    public nlmk.l3.transport.far_arrival.RecordPositions.Builder setWagonNum(int value) {
      validate(fields()[0], value);
      this.wagonNum = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'wagonNum' field has been set.
      * Номер вагона
      * @return True if the 'wagonNum' field has been set, false otherwise.
      */
    public boolean hasWagonNum() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'wagonNum' field.
      * Номер вагона
      * @return This builder.
      */
    public nlmk.l3.transport.far_arrival.RecordPositions.Builder clearWagonNum() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'wagonType' field.
      * Тип вагона
      * @return The value.
      */
    public java.lang.String getWagonType() {
      return wagonType;
    }


    /**
      * Sets the value of the 'wagonType' field.
      * Тип вагона
      * @param value The value of 'wagonType'.
      * @return This builder.
      */
    public nlmk.l3.transport.far_arrival.RecordPositions.Builder setWagonType(java.lang.String value) {
      validate(fields()[1], value);
      this.wagonType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'wagonType' field has been set.
      * Тип вагона
      * @return True if the 'wagonType' field has been set, false otherwise.
      */
    public boolean hasWagonType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'wagonType' field.
      * Тип вагона
      * @return This builder.
      */
    public nlmk.l3.transport.far_arrival.RecordPositions.Builder clearWagonType() {
      wagonType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'weightNet' field.
      * Вес груза, т
      * @return The value.
      */
    public float getWeightNet() {
      return weightNet;
    }


    /**
      * Sets the value of the 'weightNet' field.
      * Вес груза, т
      * @param value The value of 'weightNet'.
      * @return This builder.
      */
    public nlmk.l3.transport.far_arrival.RecordPositions.Builder setWeightNet(float value) {
      validate(fields()[2], value);
      this.weightNet = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'weightNet' field has been set.
      * Вес груза, т
      * @return True if the 'weightNet' field has been set, false otherwise.
      */
    public boolean hasWeightNet() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'weightNet' field.
      * Вес груза, т
      * @return This builder.
      */
    public nlmk.l3.transport.far_arrival.RecordPositions.Builder clearWeightNet() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecordPositions build() {
      try {
        RecordPositions record = new RecordPositions();
        record.wagonNum = fieldSetFlags()[0] ? this.wagonNum : (java.lang.Integer) defaultValue(fields()[0]);
        record.wagonType = fieldSetFlags()[1] ? this.wagonType : (java.lang.String) defaultValue(fields()[1]);
        record.weightNet = fieldSetFlags()[2] ? this.weightNet : (java.lang.Float) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<RecordPositions>
    WRITER$ = (org.apache.avro.io.DatumWriter<RecordPositions>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<RecordPositions>
    READER$ = (org.apache.avro.io.DatumReader<RecordPositions>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.wagonNum);

    out.writeString(this.wagonType);

    out.writeFloat(this.weightNet);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.wagonNum = in.readInt();

      this.wagonType = in.readString();

      this.weightNet = in.readFloat();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.wagonNum = in.readInt();
          break;

        case 1:
          this.wagonType = in.readString();
          break;

        case 2:
          this.weightNet = in.readFloat();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










