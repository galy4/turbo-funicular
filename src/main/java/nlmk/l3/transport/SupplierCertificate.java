/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package nlmk.l3.transport;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Сертификат качества поставщика */
@org.apache.avro.specific.AvroGenerated
public class SupplierCertificate extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -942713030685584823L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SupplierCertificate\",\"namespace\":\"nlmk.l3.transport\",\"doc\":\"Сертификат качества поставщика\",\"fields\":[{\"name\":\"ts\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Дата и время передачи\"},{\"name\":\"op\",\"type\":{\"type\":\"enum\",\"name\":\"enum_op\",\"symbols\":[\"I\",\"D\"]},\"doc\":\"Код операции\"},{\"name\":\"pk\",\"type\":{\"type\":\"record\",\"name\":\"RecordPk\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Идентификатор сертификата\"}]},\"doc\":\"Ключ записи\"},{\"name\":\"data\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"RecordData\",\"doc\":\"Список передаваемых данных\",\"fields\":[{\"name\":\"certNum\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Номер сертификата качества\"},{\"name\":\"certDate\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Дата сертификата качества в формате YYYY-MM-DD\"},{\"name\":\"supplierCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Код внешнего поставщика\"},{\"name\":\"supplierName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Наименование внешнего поставщика\"},{\"name\":\"materialCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Код ресурса\"},{\"name\":\"materialName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Наименование ресурса (сырья)\"},{\"name\":\"materialOZM\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"ОЗМ материального ресурса\"},{\"name\":\"standart\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Наименование нормативного документа\"},{\"name\":\"lotNum\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Номер партии\"},{\"name\":\"shipmentOperDate\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Дата отгрузки в формате YYYY-MM-DD\"},{\"name\":\"vehicles\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RecordVehicles\",\"fields\":[{\"name\":\"vehicleNum\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Номер средства транспортировки\"},{\"name\":\"weightNet\",\"type\":\"float\",\"doc\":\"Вес ресурса\"},{\"name\":\"waybillNum\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Номер накладной\"}]}},\"doc\":\"Средства транспортировки\"},{\"name\":\"qualityIndicators\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RecordQualityindicators\",\"fields\":[{\"name\":\"qualityIndicatorCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Код показателя качества\"},{\"name\":\"qualityIndicatorName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Наименование показателя качества\"},{\"name\":\"qualityIndicatorType\",\"type\":\"int\",\"doc\":\"Тип данных показателя качества\"},{\"name\":\"qualityIndicatorTypeName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Наименование типа данных показателя качества\"},{\"name\":\"qualityIndicatorValue\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Значение показателя качества\"},{\"name\":\"qualityIndicatorFormat\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Формат передачи показателя качества\"},{\"name\":\"qualityIndicatorMeasure\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Единица измерения\"}]}},\"doc\":\"Показатели качества\"}]}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SupplierCertificate> ENCODER =
      new BinaryMessageEncoder<SupplierCertificate>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SupplierCertificate> DECODER =
      new BinaryMessageDecoder<SupplierCertificate>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SupplierCertificate> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SupplierCertificate> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SupplierCertificate> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SupplierCertificate>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SupplierCertificate to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SupplierCertificate from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SupplierCertificate instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SupplierCertificate fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Дата и время передачи */
   private java.lang.String ts;
  /** Код операции */
   private nlmk.l3.transport.enum_op op;
  /** Ключ записи */
   private nlmk.l3.transport.RecordPk pk;
   private nlmk.l3.transport.RecordData data;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SupplierCertificate() {}

  /**
   * All-args constructor.
   * @param ts Дата и время передачи
   * @param op Код операции
   * @param pk Ключ записи
   * @param data The new value for data
   */
  public SupplierCertificate(java.lang.String ts, nlmk.l3.transport.enum_op op, nlmk.l3.transport.RecordPk pk, nlmk.l3.transport.RecordData data) {
    this.ts = ts;
    this.op = op;
    this.pk = pk;
    this.data = data;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ts;
    case 1: return op;
    case 2: return pk;
    case 3: return data;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ts = value$ != null ? value$.toString() : null; break;
    case 1: op = (nlmk.l3.transport.enum_op)value$; break;
    case 2: pk = (nlmk.l3.transport.RecordPk)value$; break;
    case 3: data = (nlmk.l3.transport.RecordData)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'ts' field.
   * @return Дата и время передачи
   */
  public java.lang.String getTs() {
    return ts;
  }


  /**
   * Sets the value of the 'ts' field.
   * Дата и время передачи
   * @param value the value to set.
   */
  public void setTs(java.lang.String value) {
    this.ts = value;
  }

  /**
   * Gets the value of the 'op' field.
   * @return Код операции
   */
  public nlmk.l3.transport.enum_op getOp() {
    return op;
  }


  /**
   * Sets the value of the 'op' field.
   * Код операции
   * @param value the value to set.
   */
  public void setOp(nlmk.l3.transport.enum_op value) {
    this.op = value;
  }

  /**
   * Gets the value of the 'pk' field.
   * @return Ключ записи
   */
  public nlmk.l3.transport.RecordPk getPk() {
    return pk;
  }


  /**
   * Sets the value of the 'pk' field.
   * Ключ записи
   * @param value the value to set.
   */
  public void setPk(nlmk.l3.transport.RecordPk value) {
    this.pk = value;
  }

  /**
   * Gets the value of the 'data' field.
   * @return The value of the 'data' field.
   */
  public nlmk.l3.transport.RecordData getData() {
    return data;
  }


  /**
   * Sets the value of the 'data' field.
   * @param value the value to set.
   */
  public void setData(nlmk.l3.transport.RecordData value) {
    this.data = value;
  }

  /**
   * Creates a new SupplierCertificate RecordBuilder.
   * @return A new SupplierCertificate RecordBuilder
   */
  public static nlmk.l3.transport.SupplierCertificate.Builder newBuilder() {
    return new nlmk.l3.transport.SupplierCertificate.Builder();
  }

  /**
   * Creates a new SupplierCertificate RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SupplierCertificate RecordBuilder
   */
  public static nlmk.l3.transport.SupplierCertificate.Builder newBuilder(nlmk.l3.transport.SupplierCertificate.Builder other) {
    if (other == null) {
      return new nlmk.l3.transport.SupplierCertificate.Builder();
    } else {
      return new nlmk.l3.transport.SupplierCertificate.Builder(other);
    }
  }

  /**
   * Creates a new SupplierCertificate RecordBuilder by copying an existing SupplierCertificate instance.
   * @param other The existing instance to copy.
   * @return A new SupplierCertificate RecordBuilder
   */
  public static nlmk.l3.transport.SupplierCertificate.Builder newBuilder(nlmk.l3.transport.SupplierCertificate other) {
    if (other == null) {
      return new nlmk.l3.transport.SupplierCertificate.Builder();
    } else {
      return new nlmk.l3.transport.SupplierCertificate.Builder(other);
    }
  }

  /**
   * RecordBuilder for SupplierCertificate instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SupplierCertificate>
    implements org.apache.avro.data.RecordBuilder<SupplierCertificate> {

    /** Дата и время передачи */
    private java.lang.String ts;
    /** Код операции */
    private nlmk.l3.transport.enum_op op;
    /** Ключ записи */
    private nlmk.l3.transport.RecordPk pk;
    private nlmk.l3.transport.RecordPk.Builder pkBuilder;
    private nlmk.l3.transport.RecordData data;
    private nlmk.l3.transport.RecordData.Builder dataBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(nlmk.l3.transport.SupplierCertificate.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ts)) {
        this.ts = data().deepCopy(fields()[0].schema(), other.ts);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.op)) {
        this.op = data().deepCopy(fields()[1].schema(), other.op);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.pk)) {
        this.pk = data().deepCopy(fields()[2].schema(), other.pk);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (other.hasPkBuilder()) {
        this.pkBuilder = nlmk.l3.transport.RecordPk.newBuilder(other.getPkBuilder());
      }
      if (isValidValue(fields()[3], other.data)) {
        this.data = data().deepCopy(fields()[3].schema(), other.data);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (other.hasDataBuilder()) {
        this.dataBuilder = nlmk.l3.transport.RecordData.newBuilder(other.getDataBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing SupplierCertificate instance
     * @param other The existing instance to copy.
     */
    private Builder(nlmk.l3.transport.SupplierCertificate other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.ts)) {
        this.ts = data().deepCopy(fields()[0].schema(), other.ts);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.op)) {
        this.op = data().deepCopy(fields()[1].schema(), other.op);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pk)) {
        this.pk = data().deepCopy(fields()[2].schema(), other.pk);
        fieldSetFlags()[2] = true;
      }
      this.pkBuilder = null;
      if (isValidValue(fields()[3], other.data)) {
        this.data = data().deepCopy(fields()[3].schema(), other.data);
        fieldSetFlags()[3] = true;
      }
      this.dataBuilder = null;
    }

    /**
      * Gets the value of the 'ts' field.
      * Дата и время передачи
      * @return The value.
      */
    public java.lang.String getTs() {
      return ts;
    }


    /**
      * Sets the value of the 'ts' field.
      * Дата и время передачи
      * @param value The value of 'ts'.
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder setTs(java.lang.String value) {
      validate(fields()[0], value);
      this.ts = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'ts' field has been set.
      * Дата и время передачи
      * @return True if the 'ts' field has been set, false otherwise.
      */
    public boolean hasTs() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ts' field.
      * Дата и время передачи
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder clearTs() {
      ts = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'op' field.
      * Код операции
      * @return The value.
      */
    public nlmk.l3.transport.enum_op getOp() {
      return op;
    }


    /**
      * Sets the value of the 'op' field.
      * Код операции
      * @param value The value of 'op'.
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder setOp(nlmk.l3.transport.enum_op value) {
      validate(fields()[1], value);
      this.op = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'op' field has been set.
      * Код операции
      * @return True if the 'op' field has been set, false otherwise.
      */
    public boolean hasOp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'op' field.
      * Код операции
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder clearOp() {
      op = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'pk' field.
      * Ключ записи
      * @return The value.
      */
    public nlmk.l3.transport.RecordPk getPk() {
      return pk;
    }


    /**
      * Sets the value of the 'pk' field.
      * Ключ записи
      * @param value The value of 'pk'.
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder setPk(nlmk.l3.transport.RecordPk value) {
      validate(fields()[2], value);
      this.pkBuilder = null;
      this.pk = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'pk' field has been set.
      * Ключ записи
      * @return True if the 'pk' field has been set, false otherwise.
      */
    public boolean hasPk() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'pk' field and creates one if it doesn't exist yet.
     * Ключ записи
     * @return This builder.
     */
    public nlmk.l3.transport.RecordPk.Builder getPkBuilder() {
      if (pkBuilder == null) {
        if (hasPk()) {
          setPkBuilder(nlmk.l3.transport.RecordPk.newBuilder(pk));
        } else {
          setPkBuilder(nlmk.l3.transport.RecordPk.newBuilder());
        }
      }
      return pkBuilder;
    }

    /**
     * Sets the Builder instance for the 'pk' field
     * Ключ записи
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public nlmk.l3.transport.SupplierCertificate.Builder setPkBuilder(nlmk.l3.transport.RecordPk.Builder value) {
      clearPk();
      pkBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'pk' field has an active Builder instance
     * Ключ записи
     * @return True if the 'pk' field has an active Builder instance
     */
    public boolean hasPkBuilder() {
      return pkBuilder != null;
    }

    /**
      * Clears the value of the 'pk' field.
      * Ключ записи
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder clearPk() {
      pk = null;
      pkBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'data' field.
      * @return The value.
      */
    public nlmk.l3.transport.RecordData getData() {
      return data;
    }


    /**
      * Sets the value of the 'data' field.
      * @param value The value of 'data'.
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder setData(nlmk.l3.transport.RecordData value) {
      validate(fields()[3], value);
      this.dataBuilder = null;
      this.data = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'data' field has been set.
      * @return True if the 'data' field has been set, false otherwise.
      */
    public boolean hasData() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'data' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public nlmk.l3.transport.RecordData.Builder getDataBuilder() {
      if (dataBuilder == null) {
        if (hasData()) {
          setDataBuilder(nlmk.l3.transport.RecordData.newBuilder(data));
        } else {
          setDataBuilder(nlmk.l3.transport.RecordData.newBuilder());
        }
      }
      return dataBuilder;
    }

    /**
     * Sets the Builder instance for the 'data' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public nlmk.l3.transport.SupplierCertificate.Builder setDataBuilder(nlmk.l3.transport.RecordData.Builder value) {
      clearData();
      dataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'data' field has an active Builder instance
     * @return True if the 'data' field has an active Builder instance
     */
    public boolean hasDataBuilder() {
      return dataBuilder != null;
    }

    /**
      * Clears the value of the 'data' field.
      * @return This builder.
      */
    public nlmk.l3.transport.SupplierCertificate.Builder clearData() {
      data = null;
      dataBuilder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SupplierCertificate build() {
      try {
        SupplierCertificate record = new SupplierCertificate();
        record.ts = fieldSetFlags()[0] ? this.ts : (java.lang.String) defaultValue(fields()[0]);
        record.op = fieldSetFlags()[1] ? this.op : (nlmk.l3.transport.enum_op) defaultValue(fields()[1]);
        if (pkBuilder != null) {
          try {
            record.pk = this.pkBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("pk"));
            throw e;
          }
        } else {
          record.pk = fieldSetFlags()[2] ? this.pk : (nlmk.l3.transport.RecordPk) defaultValue(fields()[2]);
        }
        if (dataBuilder != null) {
          try {
            record.data = this.dataBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("data"));
            throw e;
          }
        } else {
          record.data = fieldSetFlags()[3] ? this.data : (nlmk.l3.transport.RecordData) defaultValue(fields()[3]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SupplierCertificate>
    WRITER$ = (org.apache.avro.io.DatumWriter<SupplierCertificate>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SupplierCertificate>
    READER$ = (org.apache.avro.io.DatumReader<SupplierCertificate>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.ts);

    out.writeEnum(this.op.ordinal());

    this.pk.customEncode(out);

    if (this.data == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      this.data.customEncode(out);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.ts = in.readString();

      this.op = nlmk.l3.transport.enum_op.values()[in.readEnum()];

      if (this.pk == null) {
        this.pk = new nlmk.l3.transport.RecordPk();
      }
      this.pk.customDecode(in);

      if (in.readIndex() != 1) {
        in.readNull();
        this.data = null;
      } else {
        if (this.data == null) {
          this.data = new nlmk.l3.transport.RecordData();
        }
        this.data.customDecode(in);
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.ts = in.readString();
          break;

        case 1:
          this.op = nlmk.l3.transport.enum_op.values()[in.readEnum()];
          break;

        case 2:
          if (this.pk == null) {
            this.pk = new nlmk.l3.transport.RecordPk();
          }
          this.pk.customDecode(in);
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.data = null;
          } else {
            if (this.data == null) {
              this.data = new nlmk.l3.transport.RecordData();
            }
            this.data.customDecode(in);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









