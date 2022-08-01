/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package nlmk.l3.transport.current_location;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class RecordPositions extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8324540909435326802L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RecordPositions\",\"namespace\":\"nlmk.l3.transport.current_location\",\"fields\":[{\"name\":\"wagonNum\",\"type\":\"int\",\"doc\":\"Номер вагона\"},{\"name\":\"waybillWagonLink\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Идентификатор конкретного вагона в конкретной накладной\"},{\"name\":\"wagonType\",\"type\":\"int\",\"doc\":\"Пустой-порожний\"},{\"name\":\"elemNum\",\"type\":\"int\",\"doc\":\"порядковый номер\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

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
  /** Идентификатор конкретного вагона в конкретной накладной */
   private java.lang.String waybillWagonLink;
  /** Пустой-порожний */
   private int wagonType;
  /** порядковый номер */
   private int elemNum;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RecordPositions() {}

  /**
   * All-args constructor.
   * @param wagonNum Номер вагона
   * @param waybillWagonLink Идентификатор конкретного вагона в конкретной накладной
   * @param wagonType Пустой-порожний
   * @param elemNum порядковый номер
   */
  public RecordPositions(java.lang.Integer wagonNum, java.lang.String waybillWagonLink, java.lang.Integer wagonType, java.lang.Integer elemNum) {
    this.wagonNum = wagonNum;
    this.waybillWagonLink = waybillWagonLink;
    this.wagonType = wagonType;
    this.elemNum = elemNum;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return wagonNum;
    case 1: return waybillWagonLink;
    case 2: return wagonType;
    case 3: return elemNum;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: wagonNum = (java.lang.Integer)value$; break;
    case 1: waybillWagonLink = value$ != null ? value$.toString() : null; break;
    case 2: wagonType = (java.lang.Integer)value$; break;
    case 3: elemNum = (java.lang.Integer)value$; break;
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
   * Gets the value of the 'waybillWagonLink' field.
   * @return Идентификатор конкретного вагона в конкретной накладной
   */
  public java.lang.String getWaybillWagonLink() {
    return waybillWagonLink;
  }


  /**
   * Sets the value of the 'waybillWagonLink' field.
   * Идентификатор конкретного вагона в конкретной накладной
   * @param value the value to set.
   */
  public void setWaybillWagonLink(java.lang.String value) {
    this.waybillWagonLink = value;
  }

  /**
   * Gets the value of the 'wagonType' field.
   * @return Пустой-порожний
   */
  public int getWagonType() {
    return wagonType;
  }


  /**
   * Sets the value of the 'wagonType' field.
   * Пустой-порожний
   * @param value the value to set.
   */
  public void setWagonType(int value) {
    this.wagonType = value;
  }

  /**
   * Gets the value of the 'elemNum' field.
   * @return порядковый номер
   */
  public int getElemNum() {
    return elemNum;
  }


  /**
   * Sets the value of the 'elemNum' field.
   * порядковый номер
   * @param value the value to set.
   */
  public void setElemNum(int value) {
    this.elemNum = value;
  }

  /**
   * Creates a new RecordPositions RecordBuilder.
   * @return A new RecordPositions RecordBuilder
   */
  public static nlmk.l3.transport.current_location.RecordPositions.Builder newBuilder() {
    return new nlmk.l3.transport.current_location.RecordPositions.Builder();
  }

  /**
   * Creates a new RecordPositions RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RecordPositions RecordBuilder
   */
  public static nlmk.l3.transport.current_location.RecordPositions.Builder newBuilder(nlmk.l3.transport.current_location.RecordPositions.Builder other) {
    if (other == null) {
      return new nlmk.l3.transport.current_location.RecordPositions.Builder();
    } else {
      return new nlmk.l3.transport.current_location.RecordPositions.Builder(other);
    }
  }

  /**
   * Creates a new RecordPositions RecordBuilder by copying an existing RecordPositions instance.
   * @param other The existing instance to copy.
   * @return A new RecordPositions RecordBuilder
   */
  public static nlmk.l3.transport.current_location.RecordPositions.Builder newBuilder(nlmk.l3.transport.current_location.RecordPositions other) {
    if (other == null) {
      return new nlmk.l3.transport.current_location.RecordPositions.Builder();
    } else {
      return new nlmk.l3.transport.current_location.RecordPositions.Builder(other);
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
    /** Идентификатор конкретного вагона в конкретной накладной */
    private java.lang.String waybillWagonLink;
    /** Пустой-порожний */
    private int wagonType;
    /** порядковый номер */
    private int elemNum;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(nlmk.l3.transport.current_location.RecordPositions.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.wagonNum)) {
        this.wagonNum = data().deepCopy(fields()[0].schema(), other.wagonNum);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.waybillWagonLink)) {
        this.waybillWagonLink = data().deepCopy(fields()[1].schema(), other.waybillWagonLink);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.wagonType)) {
        this.wagonType = data().deepCopy(fields()[2].schema(), other.wagonType);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.elemNum)) {
        this.elemNum = data().deepCopy(fields()[3].schema(), other.elemNum);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing RecordPositions instance
     * @param other The existing instance to copy.
     */
    private Builder(nlmk.l3.transport.current_location.RecordPositions other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.wagonNum)) {
        this.wagonNum = data().deepCopy(fields()[0].schema(), other.wagonNum);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.waybillWagonLink)) {
        this.waybillWagonLink = data().deepCopy(fields()[1].schema(), other.waybillWagonLink);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.wagonType)) {
        this.wagonType = data().deepCopy(fields()[2].schema(), other.wagonType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.elemNum)) {
        this.elemNum = data().deepCopy(fields()[3].schema(), other.elemNum);
        fieldSetFlags()[3] = true;
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
    public nlmk.l3.transport.current_location.RecordPositions.Builder setWagonNum(int value) {
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
    public nlmk.l3.transport.current_location.RecordPositions.Builder clearWagonNum() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'waybillWagonLink' field.
      * Идентификатор конкретного вагона в конкретной накладной
      * @return The value.
      */
    public java.lang.String getWaybillWagonLink() {
      return waybillWagonLink;
    }


    /**
      * Sets the value of the 'waybillWagonLink' field.
      * Идентификатор конкретного вагона в конкретной накладной
      * @param value The value of 'waybillWagonLink'.
      * @return This builder.
      */
    public nlmk.l3.transport.current_location.RecordPositions.Builder setWaybillWagonLink(java.lang.String value) {
      validate(fields()[1], value);
      this.waybillWagonLink = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'waybillWagonLink' field has been set.
      * Идентификатор конкретного вагона в конкретной накладной
      * @return True if the 'waybillWagonLink' field has been set, false otherwise.
      */
    public boolean hasWaybillWagonLink() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'waybillWagonLink' field.
      * Идентификатор конкретного вагона в конкретной накладной
      * @return This builder.
      */
    public nlmk.l3.transport.current_location.RecordPositions.Builder clearWaybillWagonLink() {
      waybillWagonLink = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'wagonType' field.
      * Пустой-порожний
      * @return The value.
      */
    public int getWagonType() {
      return wagonType;
    }


    /**
      * Sets the value of the 'wagonType' field.
      * Пустой-порожний
      * @param value The value of 'wagonType'.
      * @return This builder.
      */
    public nlmk.l3.transport.current_location.RecordPositions.Builder setWagonType(int value) {
      validate(fields()[2], value);
      this.wagonType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'wagonType' field has been set.
      * Пустой-порожний
      * @return True if the 'wagonType' field has been set, false otherwise.
      */
    public boolean hasWagonType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'wagonType' field.
      * Пустой-порожний
      * @return This builder.
      */
    public nlmk.l3.transport.current_location.RecordPositions.Builder clearWagonType() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'elemNum' field.
      * порядковый номер
      * @return The value.
      */
    public int getElemNum() {
      return elemNum;
    }


    /**
      * Sets the value of the 'elemNum' field.
      * порядковый номер
      * @param value The value of 'elemNum'.
      * @return This builder.
      */
    public nlmk.l3.transport.current_location.RecordPositions.Builder setElemNum(int value) {
      validate(fields()[3], value);
      this.elemNum = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'elemNum' field has been set.
      * порядковый номер
      * @return True if the 'elemNum' field has been set, false otherwise.
      */
    public boolean hasElemNum() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'elemNum' field.
      * порядковый номер
      * @return This builder.
      */
    public nlmk.l3.transport.current_location.RecordPositions.Builder clearElemNum() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecordPositions build() {
      try {
        RecordPositions record = new RecordPositions();
        record.wagonNum = fieldSetFlags()[0] ? this.wagonNum : (java.lang.Integer) defaultValue(fields()[0]);
        record.waybillWagonLink = fieldSetFlags()[1] ? this.waybillWagonLink : (java.lang.String) defaultValue(fields()[1]);
        record.wagonType = fieldSetFlags()[2] ? this.wagonType : (java.lang.Integer) defaultValue(fields()[2]);
        record.elemNum = fieldSetFlags()[3] ? this.elemNum : (java.lang.Integer) defaultValue(fields()[3]);
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

    out.writeString(this.waybillWagonLink);

    out.writeInt(this.wagonType);

    out.writeInt(this.elemNum);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.wagonNum = in.readInt();

      this.waybillWagonLink = in.readString();

      this.wagonType = in.readInt();

      this.elemNum = in.readInt();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.wagonNum = in.readInt();
          break;

        case 1:
          this.waybillWagonLink = in.readString();
          break;

        case 2:
          this.wagonType = in.readInt();
          break;

        case 3:
          this.elemNum = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










